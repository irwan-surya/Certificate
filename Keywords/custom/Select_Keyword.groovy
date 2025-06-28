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
import org.openqa.selenium.Keys
import com.kms.katalon.core.util.KeywordUtil
import com.kms.katalon.core.webui.keyword.WebUiBuiltInKeywords as WebUI
import com.kms.katalon.core.model.FailureHandling
import internal.GlobalVariable


import internal.GlobalVariable

public class Select_Keyword {
	//	@Keyword
	//	def SelectDropdown(dropdown,list) {
	//		WebUI.click(findTestObject(dropdown))
	//		WebUI.waitForElementClickable(findTestObject(list), 10)
	//		WebUI.click(findTestObject(list))
	//	}

	@Keyword
	def SelectDropdown(String dropdown, String list) {
		try {
			WebUI.click(findTestObject(dropdown))
			WebUI.waitForElementClickable(findTestObject(list), 10)
			WebUI.click(findTestObject(list))

			KeywordUtil.markPassed("Dropdown selection successful")
		} catch (Exception e) {

			KeywordUtil.markFailed("Dropdown selection failed: " + e.message)

			UserLogout()

			//			Assert.fail("Dropdown selection failed. Logged out.")
		}
	}

	@Keyword
	def UserLogout() {
		WebUI.mouseOver(findTestObject('Object Repository/Login/icon_profile'))
		WebUI.click(findTestObject('Login/button_Keluar'))
		WebUI.click(findTestObject('Login/button_Yakin'))
	}

	def ClearField(object) {
		WebUI.click(findTestObject(object)) // Focus the field
		WebUI.sendKeys(findTestObject(object), Keys.chord(Keys.COMMAND, 'a')) // Select all text
		WebUI.sendKeys(findTestObject(object), Keys.chord(Keys.DELETE)) // Delete the selected text
	}
}
