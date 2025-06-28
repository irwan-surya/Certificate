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

public class Report {

	@Keyword
	def void verifyAnyTransactionDateMatches(String dateCssSelector) {
		try {
			List<WebElement> dateElements = DriverFactory.getWebDriver().findElements(By.cssSelector(dateCssSelector))

			KeywordUtil.logInfo("🔍 Found ${dateElements.size()} elements with selector '${dateCssSelector}'")

			boolean matchFound = false

			for (WebElement el : dateElements) {
				String rawText = el.getText().trim()
				KeywordUtil.logInfo("📋 Raw Text Found: ${rawText}")

				if (rawText == GlobalVariable.transactionDateFull) {
					KeywordUtil.markPassed("✅ Match found: ${rawText}")
					matchFound = true
					break
				}
			}

			if (!matchFound) {
				KeywordUtil.markFailed("❌ No transaction date matched expected value: ${GlobalVariable.transactionDateFull}")
			}
		} catch (Exception e) {
			KeywordUtil.markFailed("❌ Error occurred during date verification: ${e.message}")
		}
	}


	//	@Keyword
	//	void extractAndValidateTransactionDetails(String rowCssSelector) {
	//		List<WebElement> rows = DriverFactory.getWebDriver().findElements(By.cssSelector(rowCssSelector))
	//
	//		boolean matchFound = false
	//
	//		for (WebElement row : rows) {
	//				WebElement contentContainer = row.findElement(By.cssSelector("div.css-a8731x"))
	//				List<WebElement> sections = contentContainer.findElements(By.cssSelector("div.css-5ju8hh"))
	//
	//				if (sections.size() < 4) {
	//					continue
	//				}
	//
	//				String dateTime = sections[0].findElement(By.tagName("p")).getText().trim()
	//
	//				List<WebElement> receiverSection = sections[1].findElements(By.tagName("p"))
	//				String receiverName = receiverSection[0].getText().trim()
	//				String senderAccount = receiverSection.size() > 1 ? receiverSection[1].getText().trim() : ""
	//
	//				List<WebElement> transactionSection = sections[2].findElements(By.tagName("p"))
	//				String transactionType = transactionSection[0].getText().trim()
	//				String accountNumber = transactionSection.size() > 1 ? transactionSection[1].getText().trim() : ""
	//
	//				String amount = sections[3].findElement(By.tagName("p")).getText().trim()
	//
	//
	//				KeywordUtil.logInfo("🔍 Checking row:")
	//				KeywordUtil.logInfo("  📅 dateTime:       ${dateTime}")
	//				KeywordUtil.logInfo("  💸 transactionType:${transactionType}")
	//				KeywordUtil.logInfo("  💰 amount:         ${amount}")
	//				KeywordUtil.logInfo("  ✅ comparing to:")
	//				KeywordUtil.logInfo("     GlobalVariable.transactionDateFull:  ${GlobalVariable.transactionDateFull}")
	//				KeywordUtil.logInfo("     GlobalVariable.transactionType:      ${GlobalVariable.transactionType['report']}")
	//				KeywordUtil.logInfo("     GlobalVariable.transactionData[Total Transaksi]: ${GlobalVariable.transactionData['Total Transaksi']}")
	//
	////				🔍 Compare against expected values
	//	if (dateTime == GlobalVariable.transactionDateFull &&
	//	transactionType == GlobalVariable.transactionType['report'] &&
	//	amount == GlobalVariable.transactionData['Total Transaksi']) {
	//
	//	KeywordUtil.markPassed("✅ Transaction match found.")
	//	matchFound = true
	//	break
	//}
	//		}
	//		if (!matchFound) {
	//			KeywordUtil.markFailed("❌ No matching transaction found.")
	//		}
	//	}

	@Keyword
	void extractAndValidateTransactionDetails(String rowCssSelector) {
		List<WebElement> rows = DriverFactory.getWebDriver().findElements(By.cssSelector(rowCssSelector))

		boolean matchFound = false

		for (WebElement row : rows) {
			WebElement contentContainer = row.findElement(By.cssSelector("div.css-a8731x"))
			List<WebElement> sections = contentContainer.findElements(By.cssSelector("div.css-5ju8hh"))

			if (sections.size() < 4) {
				continue
			}

			String dateTime = sections[0].findElement(By.tagName("p")).getText().trim()

			List<WebElement> receiverSection = sections[1].findElements(By.tagName("p"))
			String receiverName = receiverSection[0].getText().trim()
			String senderAccount = receiverSection.size() > 1 ? receiverSection[1].getText().trim() : ""

			List<WebElement> transactionSection = sections[2].findElements(By.tagName("p"))
			String transactionType = transactionSection[0].getText().trim()
			String accountNumber = transactionSection.size() > 1 ? transactionSection[1].getText().trim() : ""

			String amount = sections[3].findElement(By.tagName("p")).getText().trim()

			// Expected values
			String expectedDate = GlobalVariable.transactionDateFull
			String expectedType = GlobalVariable.transactionType['report']
			String expectedAmount = GlobalVariable.transactionData['Total Transaksi']

			// Check if all match
			if (dateTime == expectedDate &&
					transactionType == expectedType &&
					amount == expectedAmount) {

				// ✅ Log only the matched fields
				KeywordUtil.logInfo("✅ Date match:       ${dateTime}")
				KeywordUtil.logInfo("✅ Type match:       ${transactionType}")
				KeywordUtil.logInfo("✅ Amount match:     ${amount}")

				String path = WebUI.takeScreenshot("/Users/irwan/Desktop/match_found.png")
				KeywordUtil.logInfo("📸 Screenshot saved at: " + path)

				KeywordUtil.markPassed("✅ Transaction match found.")
				matchFound = true
				break
			}
		}

		if (!matchFound) {
			KeywordUtil.markFailed("❌ No matching transaction found.")
		}
	}
}
