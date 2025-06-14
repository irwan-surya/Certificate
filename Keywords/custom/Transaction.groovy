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

import com.kms.katalon.core.annotation.Keyword
import com.kms.katalon.core.webui.driver.DriverFactory
import com.kms.katalon.core.util.KeywordUtil
import org.openqa.selenium.By
import org.openqa.selenium.WebElement

import com.kms.katalon.core.webui.driver.DriverFactory
import org.openqa.selenium.By
import org.openqa.selenium.WebElement
import java.text.SimpleDateFormat
import java.util.Locale

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
	def void clickDateFromGlobalVariable() {
		// Step 1: Get date from global variable
		String targetDateString = GlobalVariable.transactionDate  // e.g., "05/06/2025"
		if (!targetDateString) {
			throw new Exception("❌ 'Date' not found in GlobalVariable.transactionData.")
		}

		// Step 2: Parse input string
		SimpleDateFormat inputFormat = new SimpleDateFormat("dd/MM/yyyy")
		Date targetDate = inputFormat.parse(targetDateString)

		// Step 3: Convert to date picker's aria-label format
		SimpleDateFormat ariaFormat = new SimpleDateFormat("'Choose' EEEE, d MMMM yyyy", new Locale("id"))
		String expectedAriaLabel = ariaFormat.format(targetDate)
		println "🎯 Target date aria-label: ${expectedAriaLabel}"

		// Step 4: Find all date cells
		WebElement dateContainer = DriverFactory.getWebDriver().findElement(By.cssSelector(".react-datepicker__month"))
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
