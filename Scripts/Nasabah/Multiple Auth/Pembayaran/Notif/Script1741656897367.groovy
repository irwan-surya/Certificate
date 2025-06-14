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
import com.kms.katalon.core.util.KeywordUtil
import custom.Transaction as TE
import com.kms.katalon.core.testobject.ConditionType
import org.openqa.selenium.WebElement
import org.openqa.selenium.By
import com.kms.katalon.core.webui.driver.DriverFactory
import com.kms.katalon.core.webui.keyword.WebUiBuiltInKeywords as WebUI


CustomKeywords.'custom.login_keyword.UserLogin'(
	GlobalVariable.CorpID_PROD_SINGLEC1, 
	GlobalVariable.UserID_PROD_SINGLEC1, 
	GlobalVariable.Pass_Prod_SINGLEC1,
	GlobalVariable.Prod_URL)

WebUI.maximizeWindow()

WebUI.click(findTestObject('Nasabah/Notif/button_Notif'))

WebUI.click(findTestObject('Object Repository/Nasabah/Notif/List_notifv2'))


// Use a CSS selector for the root container
//def transactionData = TE.extractTransactionDetails('.css-1putcy6')

//def extractor = new custom.Transaction()
//def data = extractor.extractTransactionDetails('.css-1putcy6')

//// Create instance
//def extractor = new TransactionExtractor()
//
//// Call the method and assign to variable
//def transactionData = extractor.extractTransactionDetails('.css-1putcy6')

def transactionData = CustomKeywords.'custom.Transaction.extractTransactionDetails'('.css-1putcy6','.css-1b2apei')

def transactionDate = CustomKeywords.'custom.Transaction.extractTransactionDate'('.css-wtrezf')
// Output: 05/06/2025


//def transactionDate = CustomKeywords.'custom.Transaction.extractTransactionDetails'('.css-wtrezf','.css-18p54y6')

// store data to global variable
GlobalVariable.transactionData = transactionData
GlobalVariable.transactionDate = transactionDate

KeywordUtil.logInfo(GlobalVariable.transactionDate)

WebUI.click(findTestObject('Nasabah/Laporan/sidebar_Laporan'))

WebUI.click(findTestObject('Nasabah/Laporan/submenu_Financial'))

WebUI.click(findTestObject('Nasabah/Laporan/input_datepicker start'))

CustomKeywords.'custom.Transaction.clickDateFromGlobalVariable'()

WebUI.click(findTestObject('Nasabah/Laporan/input_datepicker end'))

CustomKeywords.'custom.Transaction.clickDateFromGlobalVariable'()

WebUI.click(findTestObject('Nasabah/Laporan/button_Terapkan'))

//KeywordUtil.logInfo(GlobalVariable.transactionData['ID Transaksi'])
//KeywordUtil.logInfo(GlobalVariable.transactionData['No Ref'])
//KeywordUtil.logInfo(GlobalVariable.transactionData['Berita'])




//		//verifikasi di halaman inbox
WebUI.click(findTestObject('Nasabah/Kotak Masuk/sidebar_Layanan Nasabah'))

WebUI.click(findTestObject('Nasabah/Kotak Masuk/div_Kotak Masuk'))

WebUI.click(findTestObject('Nasabah/Kotak Masuk/button_Lihat Detail inbox'))

// Extract again from new page
def extractedDetails = CustomKeywords.'custom.Transaction.extractTransactionDetails'('.css-16xvqac','.css-83zc01')

// Comparison
def expectedID = GlobalVariable.transactionData['ID Transaksi']
def expectedNoref = GlobalVariable.transactionData['No Ref']

KeywordUtil.logInfo("Expected Transaction ID: " + expectedID)
KeywordUtil.logInfo("Expected Noref: " + expectedNoref)

WebUI.verifyMatch(extractedDetails['ID Transaksi'], expectedID, false)
WebUI.verifyMatch(extractedDetails['No Ref'], expectedNoref, false)

CustomKeywords.'custom.login_keyword.UserLogout'()
////WebUI.closeBrowser()



