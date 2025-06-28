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

CustomKeywords.'custom.helper.setDestinationFolder'('/Users/irwan/Documents/screenshots/Pembayaran/Pegadaian - KCA Cicilan')

CustomKeywords.'custom.login_keyword.UserLogin'(
	GlobalVariable.CorpID_PROD_SINGLEC1,
	GlobalVariable.UserID_PROD_SINGLEC1,
	GlobalVariable.Pass_Prod_SINGLEC1,
	GlobalVariable.Prod_URL)

WebUI.maximizeWindow()

//CustomKeywords.'custom.helper.Screenshoot'()

WebUI.click(findTestObject('Nasabah/Pembayaran/sidebar_Pembayaran'))

CustomKeywords.'custom.helper.Screenshoot'()

WebUI.click(findTestObject('Nasabah/Pembayaran/Pegadaian/menu_Pegadaian'))

CustomKeywords.'custom.helper.Screenshoot'()

WebUI.click(findTestObject('Nasabah/Pembayaran/Pegadaian/dropdown_Pilih Institusi'))

CustomKeywords.'object.dropdown.pegadaian'('KCA Cicilan')
  
 CustomKeywords.'custom.helper.Screenshoot'()

WebUI.sendKeys(findTestObject('Nasabah/Pembayaran/Pegadaian/input_no kredit'), '25000000')

CustomKeywords.'custom.helper.Screenshoot'()

WebUI.sendKeys(findTestObject('Nasabah/Pembayaran/Pegadaian/input_nominal'), '25000000')

CustomKeywords.'custom.helper.Screenshoot'()

WebUI.click(findTestObject('Nasabah/Pembayaran/Pegadaian/button_Selanjutnya'))

CustomKeywords.'custom.helper.Screenshoot'()

WebUI.click(findTestObject('Admin/Pengaturan Kelompok/Admin1/button_OK'))

CustomKeywords.'custom.login_keyword.UserLogout'()

WebUI.closeBrowser()

