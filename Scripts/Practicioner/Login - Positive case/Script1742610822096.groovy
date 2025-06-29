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

import com.kms.katalon.core.webservice.keyword.WSBuiltInKeywords as WS
import com.kms.katalon.core.testobject.ResponseObject

CustomKeywords.'custom.Access.UserLogin'(
	GlobalVariable.CorpID_PROD_SINGLEC1, 
	GlobalVariable.UserID_PROD_SINGLEC1, 
	GlobalVariable.Pass_Prod_SINGLEC1,
	GlobalVariable.Prod_URL)

CustomKeywords.'custom.helper.setDestinationFolder'('/Users/irwan/Documents/screenshots/Inbox')

CustomKeywords.'custom.helper.Screenshoot'()

WebUI.click(findTestObject('Nasabah/Kotak Masuk/sidebar_Layanan Nasabah'))

CustomKeywords.'custom.helper.Screenshoot'()

WebUI.click(findTestObject('Nasabah/Kotak Masuk/div_Kotak Masuk'))

CustomKeywords.'custom.helper.Screenshoot'()

//WebUI.click(findTestObject('Nasabah/Kotak Masuk/Waktu/div_1 Bulan'))
//
////WebUI.mouseOver(findTestObject('Nasabah/Kotak Masuk/Waktu/div_3 Bulanv2'))
//
//WebUI.sendKeys(null,'3')

//WebUI.click(findTestObject('Nasabah/Kotak Masuk/Waktu/p_3 Bulan'))

CustomKeywords.'custom.Access.UserLogout'()

CustomKeywords.'custom.helper.Screenshoot'()

