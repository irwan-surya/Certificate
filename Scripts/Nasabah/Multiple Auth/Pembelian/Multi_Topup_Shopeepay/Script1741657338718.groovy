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

WebUI.openBrowser(GlobalVariable.SIT_Url)

WebUI.sendKeys(findTestObject('Login/input_CorpID'), GlobalVariable.CorpID_SIT_Maker_masirwan2)

WebUI.sendKeys(findTestObject('Login/input_userID'), GlobalVariable.UserID_SIT_Maker_masirwan2)

WebUI.sendKeys(findTestObject('Login/input_password'), GlobalVariable.Pass_SIT_masirwan2)

WebUI.click(findTestObject('Login/button_Login'))

WebUI.click(findTestObject('Nasabah/Pembelian/Sidebar_Pembelian'))

WebUI.click(findTestObject('Nasabah/Pembelian/Submenu_Top Up'))

WebUI.click(findTestObject('Nasabah/Pembelian/dropdown_Penyedia Jasa'))

WebUI.click(findTestObject('Nasabah/Pembelian/Provider_ShopeePay'))

WebUI.sendKeys(findTestObject('Nasabah/Pembelian/input_phoneNumber'), '990061239810002')

WebUI.sendKeys(findTestObject('Nasabah/Pembelian/input__amount'), '10000')

WebUI.click(findTestObject('Nasabah/Pembelian/button_Selanjutnya'))

WebUI.click(findTestObject('Nasabah/Pembelian/button_Selanjutnya_konfirmasi'))

WebUI.mouseOver(findTestObject('Object Repository/Login/icon_profile'))

WebUI.click(findTestObject('Login/button_Keluar'))

WebUI.click(findTestObject('Login/button_Yakin'))

