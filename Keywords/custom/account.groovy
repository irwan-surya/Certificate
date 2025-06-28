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
import com.kms.katalon.core.webui.keyword.WebUiBuiltInKeywords as WebUI
import org.openqa.selenium.By
import org.openqa.selenium.WebElement
import com.kms.katalon.core.webui.driver.DriverFactory
import com.kms.katalon.core.util.KeywordUtil

public class account {
	
	@Keyword
	def selectAccountWithSmallestBalance() {
		
		// Get the WebDriver instance
		def driver = DriverFactory.getWebDriver()
		
		// Find all the account card elements
		List<WebElement> accountCards = driver.findElements(By.cssSelector(".MuiCard-root"))
		
		if (accountCards.isEmpty()) {
			KeywordUtil.markFailedAndStop("❌ No account cards found.")
		}
		
		double smallestBalance = Double.MAX_VALUE
		WebElement targetRadioButton = null
		
		// Iterate through each card
		for (WebElement card : accountCards) {
			
			try {
				// Get the balance text, assumed to be inside <p> with specific class
				WebElement balanceElement = card.findElement(By.cssSelector("p.css-wv7fbn"))
				String balanceText = balanceElement.getText().replace("Rp", "").replace(".", "").replace(",", ".").trim()
				
				double balance = Double.parseDouble(balanceText)
				
				KeywordUtil.logInfo("Found balance: " + balance)
				
				// Compare to find the smallest
				if (balance < smallestBalance) {
					smallestBalance = balance
					targetRadioButton = card.findElement(By.cssSelector("input[type='radio']"))
				}
				
			} catch (Exception e) {
				KeywordUtil.logInfo("⚠️ Skipping a card due to error: " + e.getMessage())
			}
		}
		
		if (targetRadioButton != null) {
			targetRadioButton.click()
			KeywordUtil.markPassed("✅ Selected account with smallest balance: Rp " + smallestBalance)
		} else {
			KeywordUtil.markFailedAndStop("❌ Failed to find and select account with smallest balance.")
		}
	}
	
}
