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

CustomKeywords.'custom.login_keyword.UserLogin'(
	GlobalVariable.CorpID_PROD_MULTIE1, 
	GlobalVariable.UserID_PROD_Admin1, 
	GlobalVariable.Pass_Prod_MULTIE1,
	GlobalVariable.Prod_URL)

WebUI.executeJavaScript('document.body.style.zoom="75%";', null)

WebUI.click(findTestObject('Admin/Sidebar_Pengaturan Rekening'))

WebUI.click(findTestObject('Admin/Konfigurasi Rekening/Submenu_Konfigurasi Rekening'))

WebUI.click(findTestObject('Admin/Konfigurasi Rekening/Rekening_Tabungan BTN Batara'))

WebUI.clearText(findTestObject('Admin/Konfigurasi Rekening/input_payment Limit'))

WebUI.mouseOver(findTestObject('Object Repository/Login/icon_profile'))

WebUI.click(findTestObject('Login/button_Keluar'))

WebUI.click(findTestObject('Login/button_Yakin'))

