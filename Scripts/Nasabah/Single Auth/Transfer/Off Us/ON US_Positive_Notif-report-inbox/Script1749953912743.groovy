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

//WebUI.maximizeWindow()

WebUI.click(findTestObject('Nasabah/Notif/button_Notif'))

CustomKeywords.'custom.Transaction.clickMenuItem'("Transfer BI-FAST", "11/04/2025")

def transactionData = CustomKeywords.'custom.Transaction.extractTransactionDetails'('.css-1putcy6','.css-1b2apei')

def transactionDate = CustomKeywords.'custom.Transaction.extractTransactionDate'('.css-wtrezf')

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

//		//verifikasi di halaman inbox
WebUI.click(findTestObject('Nasabah/Kotak Masuk/sidebar_Layanan Nasabah'))

WebUI.click(findTestObject('Nasabah/Kotak Masuk/div_Kotak Masuk'))

def Noreff = GlobalVariable.transactionData['No Ref']

CustomKeywords.'custom.Transaction.searchReferenceWithProgressiveFilter'(Noreff)


// Extract again from new page
def extractedDetails = CustomKeywords.'custom.Transaction.extractTransactionDetails'('.css-16xvqac','.css-83zc01')

//// Get detail template from global variable
//def expectedID = GlobalVariable.transactionData['ID Transaksi']
//def expectedNoref = GlobalVariable.transactionData['No Ref']
//def expectedTransferCategory = GlobalVariable.transactionData['Kategori Transfer']
//def expectedTransferOption = GlobalVariable.transactionData['Pilihan Transfer']
////def expectedTransferAmount = GlobalVariable.transactionData['Nominal Transfer']
////def expectedTransferFee = GlobalVariable.transactionData['Biaya Transaksi']
////def expectedTransactionAdminFee = GlobalVariable.transactionData['Biaya Admin']
////def expectedTotalFee = GlobalVariable.transactionData['Total Biaya']
//
//
////log each data
//KeywordUtil.logInfo("Expected Transaction ID: " + expectedID)
//KeywordUtil.logInfo("Expected Noref: " + expectedNoref)
//KeywordUtil.logInfo("Expected Transfer Category: " + expectedTransferCategory)
//KeywordUtil.logInfo("Expected Transfer Option: " + expectedTransferOption)
//
//
////compare data from global variable with inbox
//WebUI.verifyMatch(extractedDetails['ID Transaksi'], expectedID, false)
//WebUI.verifyMatch(extractedDetails['No Ref'], expectedNoref, false)
//WebUI.verifyMatch(extractedDetails['Kategori Transfer'], expectedTransferCategory, false)
//WebUI.verifyMatch(extractedDetails['Pilihan Transfer'], expectedTransferOption, false)

// Map of field keys from GlobalVariable + human-readable log labels
def fields = [
	'ID Transaksi'      : 'Transaction ID',
	'No Ref'            : 'Noref',
	'Kategori Transfer' : 'Transfer Category',
	'Tipe Transfer'		: 'Transfer Type',
	'Tipe BI-FAST'		: 'Proxy BI-FAST',
//	'Pilihan Transfer'  : 'Transfer Option',
	'Nominal Transfer'  : 'Transfer Amount',
	'Biaya Transaksi'   : 'Transaction Fee',
	'Biaya Admin'       : 'Admin Fee',
	'Total Biaya'       : 'Total Fee',
	'Berita'			: 'Berita',
	'Total Transaksi'	: 'Total Transaction'
]

// Iterate through each field, log expected value, and verify match
fields.each { key, label ->
	def expectedValue = GlobalVariable.transactionData[key]
	def actualValue = extractedDetails[key]
	
	KeywordUtil.logInfo("Expected ${label}: ${expectedValue}")
//	WebUI.verifyMatch(actualValue, expectedValue, false)
	try {
		WebUI.verifyMatch(actualValue, expectedValue, false)
		KeywordUtil.logInfo("✅ Match PASSED for ${label}: ${expectedValue}")
	} catch (Exception e) {
		KeywordUtil.logInfo("❌ Match FAILED: Expected '${expectedValue}' but got '${actualValue}'")
		throw e
	}
}



//logout
CustomKeywords.'custom.login_keyword.UserLogout'()
WebUI.closeBrowser()



