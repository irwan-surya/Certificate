package custom
import static com.kms.katalon.core.checkpoint.CheckpointFactory.findCheckpoint
import static com.kms.katalon.core.testcase.TestCaseFactory.findTestCase
import static com.kms.katalon.core.testdata.TestDataFactory.findTestData
import static com.kms.katalon.core.testobject.ObjectRepository.findTestObject

import com.kms.katalon.core.annotation.Keyword
import com.kms.katalon.core.checkpoint.Checkpoint
import com.kms.katalon.core.checkpoint.CheckpointFactory
import com.kms.katalon.core.mobile.keyword.MobileBuiltInKeywords
import com.kms.katalon.core.model.FailureHandling
import com.kms.katalon.core.testcase.TestCase
import com.kms.katalon.core.testcase.TestCaseFactory
import com.kms.katalon.core.testdata.TestData
import com.kms.katalon.core.testdata.TestDataFactory
import com.kms.katalon.core.testobject.ObjectRepository
import com.kms.katalon.core.testobject.TestObject
import com.kms.katalon.core.webservice.keyword.WSBuiltInKeywords
import com.kms.katalon.core.webui.keyword.WebUiBuiltInKeywords

import internal.GlobalVariable

import org.openqa.selenium.WebElement
import org.openqa.selenium.WebDriver
import org.openqa.selenium.By
import org.openqa.selenium.Keys

import com.kms.katalon.core.mobile.keyword.internal.MobileDriverFactory
import com.kms.katalon.core.webui.driver.DriverFactory

import com.kms.katalon.core.testobject.RequestObject
import com.kms.katalon.core.testobject.ResponseObject
import com.kms.katalon.core.testobject.ConditionType
import com.kms.katalon.core.testobject.TestObjectProperty

import com.kms.katalon.core.mobile.helper.MobileElementCommonHelper
import com.kms.katalon.core.util.KeywordUtil

import com.kms.katalon.core.webui.exception.WebElementNotFoundException
import com.kms.katalon.core.webui.keyword.WebUiBuiltInKeywords as WebUI

import com.kms.katalon.core.webui.driver.DriverFactory
import org.openqa.selenium.JavascriptExecutor

import com.kms.katalon.core.testobject.TestObject
import com.kms.katalon.core.webui.driver.DriverFactory
import org.openqa.selenium.WebDriver
import org.openqa.selenium.WebElement
import org.openqa.selenium.By

import com.kms.katalon.core.testobject.TestObject
import com.kms.katalon.core.webui.common.WebUiCommonHelper
import com.kms.katalon.core.webui.driver.DriverFactory
import org.openqa.selenium.WebElement
import com.kms.katalon.core.annotation.Keyword
import com.kms.katalon.core.testobject.ObjectRepository as OR
import com.kms.katalon.core.webui.keyword.WebUiBuiltInKeywords as WebUI

import org.openqa.selenium.WebDriver

import com.kms.katalon.core.testobject.TestObject
import com.kms.katalon.core.testobject.ConditionType
import com.kms.katalon.core.webui.keyword.WebUiBuiltInKeywords as WebUI


import CustomKeywords


class login_keyword {
	/**
	 * Refresh browser
	 */
	@Keyword
	def refreshBrowser() {
		KeywordUtil.logInfo("Refreshing")
		WebDriver webDriver = DriverFactory.getWebDriver()
		webDriver.navigate().refresh()
		KeywordUtil.markPassed("Refresh successfully")
	}

	/**
	 * Click element
	 * @param to Katalon test object
	 */
	@Keyword
	def clickElement(TestObject to) {
		try {
			WebElement element = WebUiBuiltInKeywords.findWebElement(to);
			KeywordUtil.logInfo("Clicking element")
			element.click()
			KeywordUtil.markPassed("Element has been clicked")
		} catch (WebElementNotFoundException e) {
			KeywordUtil.markFailed("Element not found")
		} catch (Exception e) {
			KeywordUtil.markFailed("Fail to click on element")
		}
	}

	@Keyword
	def VerifyLineError(inputObject,message,object) {
		// Verify that the error message is displayed
		try {
			WebUI.sendKeys(findTestObject(inputObject), Keys.chord(Keys.TAB))
			String expectedErrorMessage = message
			String actualErrorMessage = WebUI.getText(findTestObject(object))
			WebUI.verifyEqual(actualErrorMessage, expectedErrorMessage, FailureHandling.CONTINUE_ON_FAILURE)
			KeywordUtil.markPassed("Error message as expected")
		} catch (AssertionError e){
			WebUI.verifyNotEqual(actualErrorMessage, message, FailureHandling.CONTINUE_ON_FAILURE)
			KeywordUtil.markError("Error message didn't match")
		}
	}

	@Keyword
	def VerifyInputLength(Object,input,Actuallength) {
		WebUI.sendKeys(findTestObject(Object),input)
		String value = WebUI.getAttribute(findTestObject(Object), 'value')
		if (value.length() == Actuallength) {
			KeywordUtil.markPassed("Input length is correct, expected:" + Actuallength + ", actual length: " + value.length())
		} else {
			KeywordUtil.markFailed("Incorrect input length, expected: " + Actuallength + ", actual length: " + value.length())
		}
	}

	//	@Keyword
	//	def VerifyInputLength(String Object, String input, int expectedLength) {
	//		TestObject obj = findTestObject(Object)
	//		String value = ""
	//
	//		try {
	//			// Step 1: Clear the field before sending input
	//			ClearField(Object)
	//
	//			// Step 2: Send the input
	//			WebUI.sendKeys(obj, input)
	//
	//			// Step 3: Get the field value
	//			value = WebUI.getAttribute(obj, 'value') ?: ""
	//
	//			// Step 4: Compare the lengths
	//			int actualLength = value.length()
	//			if (actualLength == expectedLength) {
	//				KeywordUtil.markPassed("✅ Input length is correct. Expected: ${expectedLength}, Actual: ${actualLength}")
	//			} else {
	//				KeywordUtil.markFailed("❌ Incorrect input length. Expected: ${expectedLength}, Actual: ${actualLength}, Value: '${value}'")
	//			}
	//		} catch (Exception e) {
	//			KeywordUtil.markError("⚠️ Failed to verify input length for object '${Object}': ${e.message}")
	//		} finally {
	//			// Step 5: Always clear field afterward
	//			try {
	//				ClearField(Object)
	//			} catch (Exception clearErr) {
	//				KeywordUtil.markWarning("Could not clear field '${Object}' after test: ${clearErr.message}")
	//			}
	//		}
	//	}


	@Keyword
	def VerifyInputType(Object,input,ExpectedType) {
		WebUI.sendKeys(findTestObject(Object),input)
		String inputType = WebUI.getAttribute(findTestObject(Object), 'value')
		if (inputType == ExpectedType) {
			KeywordUtil.markPassed("Input type is correct, expected: " + ExpectedType + ", actual type: " + inputType)
		} else {
			KeywordUtil.markFailed("Incorrect input type, expected: " + ExpectedType + ", actual type: " + inputType)
		}
	}

	@Keyword
	def UserLogin(corpid,userid,pass,url) {
		WebUI.openBrowser(url)
		WebUI.sendKeys(findTestObject('Login/input_CorpID'),corpid)
		WebUI.sendKeys(findTestObject('Login/input_userID'),userid)
		WebUI.sendKeys(findTestObject('Login/input_password'),pass)
		WebUI.click(findTestObject('Login/button_Login'))
	}

	@Keyword
	def UserLogout() {
//		WebUI.mouseOver(findTestObject('Object Repository/Login/icon_profile'))
		CustomKeywords.'custom.login_keyword.hoverOverRoundIcon'()
//		WebUI.click(findTestObject('Login/button_Keluar'))
		
		String js = '''
  [...document.querySelectorAll('.css-b63xf')]
    .find(el => el.textContent.trim() === 'Keluar')?.click();
'''
	  WebUI.executeJavaScript(js, null)
	  
		
		WebUI.click(findTestObject('Login/button_Yakin'))
	}
	
	static void hoverOverRoundIcon() {
		TestObject icon = new TestObject().addProperty(
			"css", ConditionType.EQUALS, "button.MuiIconButton-root.MuiIconButton-sizeSmall.css-9xgzfu"
		)
		WebUI.waitForElementVisible(icon, 10)
		WebUI.mouseOver(icon)
	}

	/**
	 * Get all rows of HTML table
	 * @param table Katalon test object represent for HTML table
	 * @param outerTagName outer tag name of TR tag, usually is TBODY
	 * @return All rows inside HTML table
	 */
	@Keyword
	def List<WebElement> getHtmlTableRows(TestObject table, String outerTagName) {
		WebElement mailList = WebUiBuiltInKeywords.findWebElement(table)
		List<WebElement> selectedRows = mailList.findElements(By.xpath("./" + outerTagName + "/tr"))
		return selectedRows
	}
}