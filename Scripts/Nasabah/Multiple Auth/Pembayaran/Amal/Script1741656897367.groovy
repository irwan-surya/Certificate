import static com.kms.katalon.core.checkpoint.CheckpointFactory.findCheckpoint
import static com.kms.katalon.core.testcase.TestCaseFactory.findTestCase
import static com.kms.katalon.core.testdata.TestDataFactory.findTestData
import static com.kms.katalon.core.testobject.ObjectRepository.findTestObject
import static com.kms.katalon.core.testobject.ObjectRepository.findWindowsObject
import com.kms.katalon.core.checkpoint.Checkpoint as Checkpoint
import com.kms.katalon.core.cucumber.keyword.CucumberBuiltinKeywords as CucumberKW
import com.kms.katalon.core.mobile.keyword.MobileBuiltInKeywords as Mobile
import com.kms.katalon.core.model.FailureHandling as FailureHandling
import com.kms.katalon.core.testcase.TestCase as TestCase
import com.kms.katalon.core.testdata.TestData as TestData
import com.kms.katalon.core.testng.keyword.TestNGBuiltinKeywords as TestNGKW
import com.kms.katalon.core.testobject.TestObject as TestObject
import com.kms.katalon.core.webservice.keyword.WSBuiltInKeywords as WS
import com.kms.katalon.core.webui.keyword.WebUiBuiltInKeywords as WebUI
import com.kms.katalon.core.windows.keyword.WindowsBuiltinKeywords as Windows
import internal.GlobalVariable as GlobalVariable
import org.openqa.selenium.Keys as Keys

//create login test case with 
//field input user id from input_user id
//field input corp id from input_corp id

// Open the application
WebUI.openBrowser('')

// Navigate to the login page
WebUI.navigateToUrl('http://example.com/login')

// Input user ID
WebUI.setText(findTestObject('Object Repository/LoginPage/input_user_id'), 'input_user_id')

// Input corporate ID
WebUI.setText(findTestObject('Object Repository/LoginPage/input_corp_id'), 'input_corp_id')

// Click the login button
WebUI.click(findTestObject('Object Repository/LoginPage/button_login'))

// Verify successful login
WebUI.verifyElementPresent(findTestObject('Object Repository/HomePage/welcome_message'), 10)