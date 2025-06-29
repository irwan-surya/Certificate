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

CustomKeywords.'custom.helper.setDestinationFolder'('/Users/irwan/Documents/screenshots/Pembayaran/Amal/Dompet Dhuafa - Infaq')

CustomKeywords.'credential.PROD.SINGLEC1'()

WebUI.maximizeWindow()

WebUI.click(findTestObject('Nasabah/Pembayaran/sidebar_Pembayaran'))

CustomKeywords.'custom.helper.Screenshoot'()

WebUI.click(findTestObject('Nasabah/Pembayaran/Amal/menu_Amal'))

CustomKeywords.'custom.helper.Screenshoot'()

WebUI.click(findTestObject('Nasabah/Pembayaran/Amal/Dropdown_Penyedia jasa'))

CustomKeywords.'object.dropdown.amal'('Dompet Dhuafa')

CustomKeywords.'custom.helper.Screenshoot'()

WebUI.click(findTestObject('Nasabah/Pembayaran/Amal/Dropdown_Jenis Pembayaran'))

CustomKeywords.'object.dropdown.amal'('Infaq')

CustomKeywords.'custom.helper.Screenshoot'()

WebUI.click(findTestObject('Nasabah/Pembayaran/Amal/Dropdown_Pilih Nominal'))

CustomKeywords.'object.dropdown.Nominal'('10000')

CustomKeywords.'custom.helper.Screenshoot'()

WebUI.sendKeys(findTestObject('Nasabah/Pembayaran/Amal/input_Nama'), 'Hamba allah')

CustomKeywords.'custom.helper.Screenshoot'()

WebUI.sendKeys(findTestObject('Nasabah/Pembayaran/Amal/input_No HP'), '123456')

CustomKeywords.'custom.helper.Screenshoot'()

WebUI.click(findTestObject('Nasabah/Pembayaran/Pegadaian/button_Selanjutnya'))

CustomKeywords.'custom.helper.Screenshoot'()

def transactionData = CustomKeywords.'custom.Transaction.extractTransactionDetails'('.css-1v8gcgw','.css-1b2apei')

CustomKeywords.'custom.Access.UserLogout'()

WebUI.closeBrowser()