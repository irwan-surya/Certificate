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

WebUI.sendKeys(findTestObject('Login/input_CorpID'), 'masirwan')

WebUI.sendKeys(findTestObject('Login/input_userID'), 'Admin2')

WebUI.sendKeys(findTestObject('Login/input_password'), 'Johndev2@')

WebUI.click(findTestObject('Login/button_Login'))

WebUI.click(findTestObject('Admin1/Pengelompokan Rekening/Admin2/Sidebar_Daftar Tugas'))

WebUI.click(findTestObject('Admin1/Pengaturan Kelompok/Admin2/submenu_Pengaturan Kelompok'))

WebUI.click(findTestObject('Admin1/Pengelompokan Rekening/Admin2/button_Lihat Detail'))

WebUI.click(findTestObject('Admin1/Pengelompokan Rekening/Admin2/button_Tolak'))

WebUI.click(findTestObject('Admin1/Pengelompokan Rekening/Admin2/button_Ya Tolak'))

WebUI.click(findTestObject('Admin1/Pengelompokan Rekening/Admin2/button_OK berhasil tolak'))

WebUI.mouseOver(findTestObject('Object Repository/Login/icon_profile'))

WebUI.click(findTestObject('Login/button_Keluar'))

WebUI.click(findTestObject('Login/button_Yakin'))

