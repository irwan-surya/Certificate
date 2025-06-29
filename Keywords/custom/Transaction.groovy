package custom

import static com.kms.katalon.core.checkpoint.CheckpointFactory.findCheckpoint
import static com.kms.katalon.core.testcase.TestCaseFactory.findTestCase
import static com.kms.katalon.core.testdata.TestDataFactory.findTestData
import static com.kms.katalon.core.testobject.ObjectRepository.findTestObject
import static com.kms.katalon.core.testobject.ObjectRepository.findWindowsObject

import com.kms.katalon.core.annotation.Keyword
import com.kms.katalon.core.checkpoint.Checkpoint
import com.kms.katalon.core.cucumber.keyword.CucumberBuiltinKeywords as CucumberKW
import com.kms.katalon.core.mobile.keyword.MobileBuiltInKeywords as Mobile
import com.kms.katalon.core.model.FailureHandling
import com.kms.katalon.core.testcase.TestCase
import com.kms.katalon.core.testdata.TestData
import com.kms.katalon.core.testobject.TestObject
import com.kms.katalon.core.webservice.keyword.WSBuiltInKeywords as WS
import com.kms.katalon.core.webui.keyword.WebUiBuiltInKeywords as WebUI
import com.kms.katalon.core.windows.keyword.WindowsBuiltinKeywords as Windows

import internal.GlobalVariable

import com.kms.katalon.core.webui.driver.DriverFactory
import com.kms.katalon.core.util.KeywordUtil
import org.openqa.selenium.By
import org.openqa.selenium.WebElement
import com.kms.katalon.core.testobject.ConditionType
import com.kms.katalon.core.exception.StepFailedException
import com.kms.katalon.core.webui.keyword.WebUiBuiltInKeywords as WebUI




import com.kms.katalon.core.webui.driver.DriverFactory
import org.openqa.selenium.By
import org.openqa.selenium.WebElement
import java.text.SimpleDateFormat
import java.util.Locale

import org.openqa.selenium.*
import org.openqa.selenium.support.ui.*
import java.text.SimpleDateFormat

public class Transaction {

	/**
	 * Extracts key-value pairs from a container with repeating rows of <p>Label</p><p>Value</p>
	 * or <p>Label</p><span>Value</span>
	 *
	 * @param cssSelector: CSS selector pointing to the main container
	 * @return Map of label-value pairs
	 */
	@Keyword
	def Map<String, String> extractTransactionDetails(String cssSelectorParent, String cssSelectorChild) {
		WebElement container = DriverFactory.getWebDriver().findElement(By.cssSelector(cssSelectorParent))
		List<WebElement> items = container.findElements(By.cssSelector(cssSelectorChild))

		Map<String, String> detailsMap = [:]

		KeywordUtil.logInfo("🔍 Extracting transaction details from: ${cssSelectorParent}")
		KeywordUtil.logInfo("Found ${items.size()} rows to parse")

		for (WebElement item : items) {
			List<WebElement> children = item.findElements(By.cssSelector("p, span"))

			if (children.size() >= 2) {
				String label = children[0].getText().trim()
				String value = children[1].getText().trim()

				detailsMap[label] = value

				// Log each key-value pair
				KeywordUtil.logInfo("✔️ ${label}: ${value}")
				println "✔️ ${label}: ${value}"
			} else {
				KeywordUtil.logInfo("⚠️ Skipping row due to insufficient children: " + item.getText())
			}
		}
		KeywordUtil.logInfo("✅ Completed extracting transaction details")
		return detailsMap
	}

	@Keyword
	def String extractTransactionDate(String containerCssSelector) {
		WebElement container = DriverFactory.getWebDriver().findElement(By.cssSelector(containerCssSelector))
		List<WebElement> paragraphs = container.findElements(By.tagName("p"))

		if (paragraphs.size() >= 3) {
			String fullText = paragraphs[2].getText().trim()

			// Split by " | " to get only the date part
			String[] parts = fullText.split("\\|")
			if (parts.length >= 1) {
				String dateOnly = parts[0].trim()
				KeywordUtil.logInfo("📅 Extracted Date: ${dateOnly}")
				println "📅 Extracted Date: ${dateOnly}"
				return dateOnly
			}
		}

		KeywordUtil.logInfo("⚠️ Failed to extract date from: ${containerCssSelector}")
		return ""
	}


	@Keyword
	def String extractTransactionDateTime(String containerCssSelector) {
		WebElement container = DriverFactory.getWebDriver().findElement(By.cssSelector(containerCssSelector))
		List<WebElement> paragraphs = container.findElements(By.tagName("p"))

		if (paragraphs.size() >= 3) {
			String fullText = paragraphs[2].getText().trim()

			// Expecting format like "13/06/2025 | 8:04:05"
			String[] parts = fullText.split("\\|")
			if (parts.length == 2) {
				String rawDate = parts[0].trim()   // 13/06/2025
				String rawTime = parts[1].trim()   // 8:04:05 or 1:4:5

				try {
					// Format the date part
					SimpleDateFormat inputDateFormat = new SimpleDateFormat("dd/MM/yyyy")
					SimpleDateFormat outputDateFormat = new SimpleDateFormat("dd MMM yyyy")
					String formattedDate = outputDateFormat.format(inputDateFormat.parse(rawDate))

					// Normalize and pad the time
					String[] timeParts = rawTime.split(":")
					if (timeParts.length == 3) {
						String hour = timeParts[0].padLeft(2, '0')
						String minute = timeParts[1].padLeft(2, '0')
						String second = timeParts[2].padLeft(2, '0')
						String paddedTime = "${hour}:${minute}:${second}"

						String finalDateTime = "${formattedDate} ${paddedTime}"
						KeywordUtil.logInfo("📅 Extracted Formatted DateTime: ${finalDateTime}")
						println "📅 Extracted Formatted DateTime: ${finalDateTime}"
						return finalDateTime
					} else {
						KeywordUtil.logInfo("⚠️ Time format is invalid: ${rawTime}")
					}
				} catch (Exception e) {
					KeywordUtil.logInfo("❌ Date parsing error: ${e.message}")
				}
			}
		}

		KeywordUtil.logInfo("⚠️ Failed to extract or format date/time from: ${containerCssSelector}")
		return ""
	}

	@Keyword
	def void verifyAnyTransactionDateMatches(String dateCssSelector, String expectedDate) {
		try {
			List<WebElement> dateElements = DriverFactory.getWebDriver().findElements(By.cssSelector(dateCssSelector))

			KeywordUtil.logInfo("🔍 Total elements found with selector '${dateCssSelector}': ${dateElements.size()}")

			boolean isMatchFound = false

			for (WebElement dateElement : dateElements) {
				String actualDate = dateElement.getText().trim()
				KeywordUtil.logInfo("📅 Found date: ${actualDate}")

				if (actualDate == expectedDate) {
					KeywordUtil.markPassed("✅ Match found: ${actualDate}")
					isMatchFound = true
					break
				}
			}

			if (!isMatchFound) {
				KeywordUtil.markFailed("❌ No match found for expected date: ${expectedDate}")
			}
		} catch (Exception e) {
			KeywordUtil.markFailed("❌ Exception occurred during date verification: ${e.message}")
		}
	}


	@Keyword
	def searchReferenceWithProgressiveFilter(String referenceText) {
		WebDriver driver = DriverFactory.getWebDriver()
		List<String> dateOptions = [
			'3 Bulan',
			'6 Bulan',
			'1 Tahun'
		]
		boolean found = false

		// Step 1: Initial search without applying any filter
		WebUI.comment("🔍 Searching '${referenceText}' in default view (no filter)...")
		found = searchReferenceOnAllPages(referenceText)

		if (found) return

			// Step 2: Apply filters progressively
			for (String dateText : dateOptions) {
				WebUI.comment("🕒 Reference not found. Trying with filter: '${dateText}'")

				// Open drop down
				WebUI.click(findTestObject('Nasabah/Kotak Masuk/Waktu/div_1 Bulan'))

				// Select filter option
				String script = """
				  [...document.querySelectorAll('.css-md1jk9')].find(el => el.textContent.trim() === '${dateText}').click();
				"""
				WebUI.executeJavaScript(script, null)

				// Click 'Terapkan'
				TestObject applyButton = new TestObject().addProperty("xpath", ConditionType.EQUALS, "//button[.//p[text()='Terapkan']]")
				WebUI.click(applyButton)

				// Wait for filter to apply
				WebUI.delay(2)

				// Step 4: Search again with this filter
				found = searchReferenceOnAllPages(referenceText)

				if (found) {
					WebUI.comment("✅ Found '${referenceText}' under filter '${dateText}'")
					break
				}
			}

		if (!found) {
			WebUI.comment("❌ '${referenceText}' not found in any filter level.")
		}
	}

	@Keyword
	def searchReferenceOnAllPages(String referenceText) {
		WebDriver driver = DriverFactory.getWebDriver()
		boolean found = false

		while (true) {
			List<WebElement> rows = driver.findElements(By.xpath("//div[contains(@class,'MuiCard-root') and .//p[contains(text(),'IBB')]]"))
			for (WebElement row : rows) {
				if (row.getText().contains(referenceText)) {
					WebUI.comment("📍 Found '${referenceText}'")
					WebElement lihatDetailBtn = row.findElement(By.xpath(".//button[.//p[text()='Lihat Detail']]"))
					lihatDetailBtn.click()
					found = true
					break
				}
			}

			if (found) break

				// Check and click next page
				try {
					WebElement nextBtn = driver.findElement(By.xpath("//button[contains(@class,'MuiPaginationItem-root') and @aria-label='Go to next page' and not(@disabled)]"))
					nextBtn.click()
					WebUI.delay(1)
				} catch (Exception e) {
					WebUI.comment("📄 No more pages.")
					break
				}
		}

		return found
	}


	def void clickDateFromGlobalVariable() {
		// Step 1: Get date from GlobalVariable
		String targetDateString = GlobalVariable.transactionDate  // e.g., "15/05/2025"
		if (!targetDateString) {
			throw new Exception("❌ 'Date' not found in GlobalVariable.transactionDate.")
		}

		// Step 2: Parse the date string
		SimpleDateFormat inputFormat = new SimpleDateFormat("dd/MM/yyyy")
		Date targetDate = inputFormat.parse(targetDateString)

		// Extract day, month, year
		Calendar targetCal = Calendar.getInstance()
		targetCal.setTime(targetDate)
		int targetMonth = targetCal.get(Calendar.MONTH)  // 0-based (May = 4)
		int targetYear = targetCal.get(Calendar.YEAR)

		// Step 3: Get current month and year from datepicker
		WebDriver driver = DriverFactory.getWebDriver()
		WebElement monthLabel = driver.findElement(By.cssSelector(".react-datepicker__current-month"))
		WebElement yearLabel = driver.findElement(By.cssSelector(".react-datepicker__year-read-view--selected-year"))

		String visibleMonthText = monthLabel.getText().trim()  // e.g., "Juni"
		String visibleYearText = yearLabel.getText().trim()

		// Convert month name to number
		Map<String, Integer> monthMap = [
			"Januari": 0, "Februari": 1, "Maret": 2, "April": 3,
			"Mei": 4, "Juni": 5, "Juli": 6, "Agustus": 7,
			"September": 8, "Oktober": 9, "November": 10, "Desember": 11
		]

		int visibleMonth = monthMap[visibleMonthText]
		int visibleYear = Integer.parseInt(visibleYearText)

		// Step 4: Navigate to correct month/year
		while (visibleYear > targetYear || (visibleYear == targetYear && visibleMonth > targetMonth)) {
			WebElement prevButton = driver.findElement(By.cssSelector(".react-datepicker__navigation--previous"))
			prevButton.click()
			WebUI.delay(0.5)

			// Re-read after clicking
			monthLabel = driver.findElement(By.cssSelector(".react-datepicker__current-month"))
			yearLabel = driver.findElement(By.cssSelector(".react-datepicker__year-read-view--selected-year"))
			visibleMonth = monthMap[monthLabel.getText().trim()]
			visibleYear = Integer.parseInt(yearLabel.getText().trim())
		}

		// Step 5: Convert to aria-label format used in the calendar
		SimpleDateFormat ariaFormat = new SimpleDateFormat("'Choose' EEEE, d MMMM yyyy", new Locale("id"))
		String expectedAriaLabel = ariaFormat.format(targetDate)

		// Step 6: Find and click the correct date
		WebElement dateContainer = driver.findElement(By.cssSelector(".react-datepicker__month"))
		List<WebElement> dateElements = dateContainer.findElements(By.cssSelector(".react-datepicker__day"))

		for (WebElement day : dateElements) {
			String ariaLabel = day.getAttribute("aria-label")
			String isDisabled = day.getAttribute("aria-disabled")
			if (ariaLabel == expectedAriaLabel && isDisabled == "false") {
				day.click()
				println "✅ Clicked on date: ${ariaLabel}"
				return
			}
		}

		throw new Exception("❌ Clickable date '${expectedAriaLabel}' not found in date picker.")
	}
}
