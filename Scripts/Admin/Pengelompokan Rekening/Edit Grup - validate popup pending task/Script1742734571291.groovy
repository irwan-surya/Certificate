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

CustomKeywords.'custom.Access.UserLogin'(
	GlobalVariable.CorpID_PROD_MULTIE1,
	GlobalVariable.UserID_PROD_Admin1,
	GlobalVariable.Pass_Prod_MULTIE1,
	GlobalVariable.Prod_URL)

WebUI.maximizeWindow()

WebUI.click(findTestObject('Admin/Sidebar_Pengaturan Rekening'))

WebUI.click(findTestObject('Admin/Pengelompokan Rekening/Submenu_Pengelompokan Rekening'))

WebUI.click(findTestObject('Object Repository/Admin/Pengelompokan Rekening/Admin1/svg_multimenuv2'))

WebUI.click(findTestObject('Admin/Pengelompokan Rekening/Admin1/svg_Edit Kelompok'))

CustomKeywords.'custom.Select_Keyword.ClearField'('Admin/Pengelompokan Rekening/Admin1/input_Nama Kelompok')

WebUI.sendKeys(findTestObject('Admin/Pengelompokan Rekening/Admin1/input_Nama Kelompok'), 'Kelompok 1')

WebUI.click(findTestObject('Admin/Pengelompokan Rekening/Admin1/button_Simpan'))

WebUI.verifyElementText(findTestObject('Admin/Pengelompokan Rekening/Admin1/text/text_Tidak dapat mengubah kelompok'), 'Tidak dapat mengubah kelompok. Anda tidak dapat mengubah data karena data sedang menunggu persetujuan.')

WebUI.click(findTestObject('Admin/Pengelompokan Rekening/Admin1/button_OK waiting approval'))

CustomKeywords.'custom.Access.UserLogout'() 

WebUI.closeBrowser()

