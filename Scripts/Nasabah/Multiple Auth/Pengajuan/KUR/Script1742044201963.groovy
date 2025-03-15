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

CustomKeywords.'login.login_keyword.UserLogin'(GlobalVariable.CorpID_PROD_MULTIE1, GlobalVariable.UserID_PROD_Maker_makerRiza, 
    GlobalVariable.Pass_Prod_MULTIE1, GlobalVariable.Prod_URL)

WebUI.click(findTestObject('Nasabah/KUR/Sidebar_Pengajuan Produk'))

WebUI.click(findTestObject('Nasabah/KUR/Submenu_Kredit Usaha'))

WebUI.click(findTestObject('Nasabah/KUR/button_Ajukan'))

WebUI.click(findTestObject('Nasabah/KUR/Kategori_pengajuan KUR'))

WebUI.scrollToElement(findTestObject('Nasabah/KUR/txt_syarat dan ketentuan berlaku'), 10)

WebUI.click(findTestObject('Nasabah/KUR/CheckBox_TnC'))

WebUI.click(findTestObject('Nasabah/KUR/button_Selanjutnya'))

WebUI.click(findTestObject('Nasabah/KUR/informsai_pengajuan/Dropdown_Jangka Waktu Angsuran'))

WebUI.click(findTestObject('Nasabah/KUR/informsai_pengajuan/list_2 Tahun'))

WebUI.click(findTestObject('Nasabah/KUR/informsai_pengajuan/Dropdown_Tujuan Pengajuan'))

WebUI.click(findTestObject('Nasabah/KUR/informsai_pengajuan/list_Modal Kerja'))

WebUI.sendKeys(findTestObject('Nasabah/KUR/informsai_pengajuan/input_Alasan Pengajuan'), 'Pengajuan KUR')

WebUI.sendKeys(findTestObject('Nasabah/KUR/informsai_pengajuan/input_Jumlah Pinjaman'), '25000000')

WebUI.click(findTestObject('Nasabah/KUR/Informasi Pribadi/button_Selanjutnya'))

WebUI.click(findTestObject('Nasabah/KUR/Informasi Pribadi/radio_btn_Belum Menikah'))

CustomKeywords.'login.login_keyword.UserLogout'()

