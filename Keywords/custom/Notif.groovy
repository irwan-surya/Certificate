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

public class Notif {

	/**
	 * Clicks on the first menu item that matches the given title and date using TestObject-based XPath
	 */
	@Keyword
	def clickMenuItem(String expectedTitle, String expectedDate) {
		int index = 1

		while (true) {
			String baseXPath = "(//li[@role='menuitem'])[$index]"

			// Early check: is there a next item at this index?
			TestObject itemToClick = createTestObject(baseXPath)
			if (!WebUI.verifyElementPresent(itemToClick, 1, FailureHandling.OPTIONAL)) {
				WebUI.comment("❌ No matching menu item found with title '${expectedTitle}' and date '${expectedDate}'")
				throw new StepFailedException("Matching item not found.")
			}

			// Instead of checking both separately, build one combined XPath for title+date
			String combinedXPath = baseXPath + "[.//p[contains(@class,'400') and contains(text(),'" + expectedTitle + "')] and .//p[contains(@class,'detail') and normalize-space(text())='" + expectedDate + "']]"
			TestObject combinedMatch = createTestObject(combinedXPath)

			if (WebUI.verifyElementPresent(combinedMatch, 1, FailureHandling.OPTIONAL)) {
				WebUI.click(itemToClick)
				WebUI.comment("✅ Clicked menu item #$index with title '$expectedTitle' and date '$expectedDate'")
				return
			}

			index++
		}
	}


	// Utility to create TestObject from XPath
	private TestObject createTestObject(String xpath) {
		TestObject to = new TestObject()
		to.addProperty("xpath", ConditionType.EQUALS, xpath)
		return to
	}
}
