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

WebUI.openBrowser('http://ibbisnis-sit.btn.co.id/login')

WebUI.sendKeys(findTestObject('Login/input_CorpID'), 'SINGLE25')

WebUI.sendKeys(findTestObject('Login/input_userID'), 'SINGLE25')

WebUI.sendKeys(findTestObject('Login/input_password'), 'Johndev2@')

WebUI.click(findTestObject('Login/button_Login'))

WebUI.click(findTestObject('Nasabah/Pembelian/Sidebar_Pembelian'))

WebUI.click(findTestObject('Nasabah/Pembelian/Submenu_Top Up'))

WebUI.click(findTestObject('Nasabah/Pembelian/dropdown_Penyedia Jasa'))

WebUI.click(findTestObject('Nasabah/Pembelian/Provider_GoPay'))

WebUI.click(findTestObject('Nasabah/Pembelian/Dropdown_Tipe'))

WebUI.click(findTestObject('Nasabah/Pembelian/tipe_Customer'))

WebUI.sendKeys(findTestObject('Nasabah/Pembelian/input_phoneNumber'), '08111803190')

WebUI.sendKeys(findTestObject('Nasabah/Pembelian/input__amount'), '10000')

WebUI.click(findTestObject('Nasabah/Pembelian/button_Selanjutnya'))

WebUI.click(findTestObject('Nasabah/Pembelian/button_Selanjutnya_konfirmasi'))

WebUI.sendKeys(findTestObject('Nasabah/Soft_Token/input_digit 1'), '1')

WebUI.sendKeys(findTestObject('Nasabah/Soft_Token/input_digit 2'), '2')

WebUI.sendKeys(findTestObject('Nasabah/Soft_Token/input_digit 3'), '3')

WebUI.sendKeys(findTestObject('Nasabah/Soft_Token/input_digit 4'), '4')

WebUI.sendKeys(findTestObject('Nasabah/Soft_Token/input_digit 5'), '5')

WebUI.sendKeys(findTestObject('Nasabah/Soft_Token/input_digit 6'), '6')

WebUI.mouseOver(findTestObject('Object Repository/Login/icon_profile'))

WebUI.click(findTestObject('Login/button_Keluar'))

WebUI.click(findTestObject('Login/button_Yakin'))

