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
import com.kms.katalon.core.webui.keyword.internal.WebUIAbstractKeyword as WebUIAbstractKeyword
import com.kms.katalon.core.windows.keyword.WindowsBuiltinKeywords as Windows
import internal.GlobalVariable as GlobalVariable
import org.openqa.selenium.Keys as Keys

CustomKeywords.'custom.Access.UserLogin'(GlobalVariable.CorpID_PROD_MULTIE1, GlobalVariable.UserID_PROD_Admin1, GlobalVariable.Pass_Prod_MULTIE1, 
    GlobalVariable.Prod_URL)

WebUI.maximizeWindow()

WebUI.click(findTestObject('Object Repository/Admin/Pengaturan Pengguna/Admin1/Sidebar_Pengaturan Pengguna'))

WebUI.click(findTestObject('Object Repository/Admin/Pengaturan Pengguna/Admin1/Tab_Aktif'))

WebUI.click(findTestObject('Object Repository/Admin/Pengaturan Pengguna/Admin1/button_Terapkan'))

WebUI.verifyElementPresent(findTestObject('Object Repository/Admin/Pengaturan Pengguna/Admin1/Status_Aktif'), 10)

WebUI.click(findTestObject('Object Repository/Admin/Pengaturan Pengguna/Admin1/button_Tambah'))

CustomKeywords.'custom.Select_Keyword.SelectDropdown'('Admin/Pengaturan Pengguna/Admin1/Dropdown_Pilih Peran', 'Admin/Pengaturan Pengguna/Admin1/list_Maker')

CustomKeywords.'custom.Select_Keyword.SelectDropdown'('Admin/Pengaturan Pengguna/Admin1/Dropdown_Level Persetujuan', 'Admin/Pengaturan Pengguna/Admin1/List_Default')

CustomKeywords.'custom.Select_Keyword.SelectDropdown'('Admin/Pengaturan Pengguna/Admin1/Dropdown_Kelompok Pengguna', 'Admin/Pengaturan Pengguna/Admin1/List_Bermain')

WebUI.sendKeys(findTestObject('Object Repository/Admin/Pengaturan Pengguna/Admin1/input_userId'), UserID)

WebUI.sendKeys(findTestObject('Object Repository/Admin/Pengaturan Pengguna/Admin1/input_Nama'), Name)

WebUI.sendKeys(findTestObject('Object Repository/Admin/Pengaturan Pengguna/Admin1/input_email'), Email)

WebUI.sendKeys(findTestObject('Object Repository/Admin/Pengaturan Pengguna/Admin1/input_KTP'), KTP)

WebUI.sendKeys(findTestObject('Object Repository/Admin/Pengaturan Pengguna/Admin1/input_No HP'), HP_Existing)

WebUI.click(findTestObject('Object Repository/Admin/Pengaturan Pengguna/Admin1/button_Tambah 2'))

WebUI.verifyElementText(findTestObject('Admin/Pengaturan Pengguna/Admin1/text/text_No HP sudah tersedia'), 'No HP sudah tersedia')

WebUI.click(findTestObject('Object Repository/Admin/Pengaturan Pengguna/Admin1/button_OK'))

CustomKeywords.'custom.Access.UserLogout'()


