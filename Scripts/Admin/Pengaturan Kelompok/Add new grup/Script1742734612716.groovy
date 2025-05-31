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

WebUI.openBrowser(GlobalVariable.PROD_Url)

WebUI.sendKeys(findTestObject('Login/input_CorpID'), E1MANUAL)

WebUI.sendKeys(findTestObject('Login/input_userID'), 'Admin1')

WebUI.sendKeys(findTestObject('Login/input_password'), 'Johndev1!!')

WebUI.click(findTestObject('Login/button_Login'))

WebUI.click(findTestObject('Admin/Pengaturan Kelompok/sidebar_Pengaturan Kelompok'))

WebUI.click(findTestObject('Admin/Pengaturan Kelompok/Admin1/button_Tambah Daftar'))

WebUI.sendKeys(findTestObject('Admin/Pengaturan Kelompok/Admin1/input_Kode kelompok'), '013')

WebUI.sendKeys(findTestObject('Admin/Pengaturan Kelompok/Admin1/input_Nama Kelompok'), 'Kelompok 77')

WebUI.click(findTestObject('Admin/Pengaturan Kelompok/Admin1/Dropdown_Kelompok Rekening'))

WebUI.click(findTestObject('Admin/Pengaturan Kelompok/Admin1/div_kelompok baru nih'))

WebUI.click(findTestObject('Admin/Pengaturan Kelompok/Admin1/Checkbox_Daftar Fitur Pengguna'))

WebUI.click(findTestObject('Admin/Pengaturan Kelompok/Admin1/button_Simpan'))

WebUI.click(findTestObject('Admin/Pengaturan Kelompok/Admin1/button_OK'))

WebUI.mouseOver(findTestObject('Object Repository/Login/icon_profile'))

WebUI.click(findTestObject('Login/button_Keluar'))

WebUI.click(findTestObject('Login/button_Yakin'))

