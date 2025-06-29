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
	GlobalVariable.UserID_PROD_Maker_makerRiza, 
    GlobalVariable.Pass_Prod_MULTIE1, 
	GlobalVariable.Prod_URL)

WebUI.click(findTestObject('Nasabah/KUR/Sidebar_Pengajuan Produk'))

WebUI.click(findTestObject('Nasabah/KUR/Submenu_Kredit Usaha'))

WebUI.click(findTestObject('Nasabah/KUR/button_Ajukan'))

WebUI.click(findTestObject('Nasabah/KUR/Kategori_pengajuan KUR'))

WebUI.scrollToElement(findTestObject('Nasabah/KUR/txt_syarat dan ketentuan berlaku'), scrollWaitTime)

WebUI.click(findTestObject('Nasabah/KUR/CheckBox_TnC'))

WebUI.click(findTestObject('Nasabah/KUR/button_Selanjutnya'))

//informasi pengajuan
CustomKeywords.'custom.Select_Keyword.SelectDropdown'(
	'Nasabah/KUR/info pengajuan/Dropdown_Jangka Waktu Angsuran', 
	'Nasabah/KUR/info pengajuan/list_2 Tahun')

CustomKeywords.'custom.Select_Keyword.SelectDropdown'(
	'Nasabah/KUR/info pengajuan/Dropdown_Tujuan Pengajuan', 
	'Nasabah/KUR/info pengajuan/list_Modal Kerja')

WebUI.sendKeys(findTestObject('Nasabah/KUR/info pengajuan/input_Alasan Pengajuan'), 'Pengajuan KUR')

WebUI.sendKeys(findTestObject('Nasabah/KUR/info pengajuan/input_Jumlah Pinjaman'), '25000000')

WebUI.click(findTestObject('Nasabah/KUR/Info Pribadi/button_Selanjutnya'))

//informasi pribadi
WebUI.sendKeys(findTestObject('Nasabah/KUR/Info Pribadi/input_Kota Kelahiran'), 'Yogyakarta')

CustomKeywords.'custom.Select_Keyword.SelectDropdown'(
	'Nasabah/KUR/Info Pribadi/Dropdown_Jenis Kelamin', 
	'Nasabah/KUR/Info Pribadi/list_Laki-laki')

CustomKeywords.'custom.Select_Keyword.SelectDropdown'(
	'Nasabah/KUR/Info Pribadi/datepicker_tanggal lahir', 
	'Nasabah/KUR/Info Pribadi/div_13')

WebUI.scrollToElement(findTestObject('Nasabah/KUR/Info Pribadi/input_RT'), 10)

WebUI.click(findTestObject('Nasabah/KUR/Info Pribadi/radio_btn_Belum Menikah'))

WebUI.click(findTestObject('Nasabah/KUR/Info Pribadi/radio_btn_Milik Sendiri'))

WebUI.sendKeys(findTestObject('Nasabah/KUR/Info Pribadi/input_Alamat Domisili'), 'Jl satu dua tiga empat lima')

CustomKeywords.'custom.Select_Keyword.SelectDropdown'(
	'Nasabah/KUR/Info Pribadi/Dropdown_Pilih Provinsi', 
	'Nasabah/KUR/Info Pribadi/list_DI Yogyakarta')

CustomKeywords.'custom.Select_Keyword.SelectDropdown'(
	'Nasabah/KUR/Info Pribadi/Dropdown_Pilih Kota', 
	'Nasabah/KUR/Info Pribadi/list_Kota Yogyakarta')

CustomKeywords.'custom.Select_Keyword.SelectDropdown'(
	'Nasabah/KUR/Info Pribadi/Dropdown_Pilih Kecamatan', 
	'Nasabah/KUR/Info Pribadi/list_Gondomanan')

CustomKeywords.'custom.Select_Keyword.SelectDropdown'(
	'Nasabah/KUR/Info Pribadi/Dropdown_Pilih Kelurahan', 
	'Nasabah/KUR/Info Pribadi/list_Prawirodirjan')

WebUI.sendKeys(findTestObject('Nasabah/KUR/Info Pribadi/input_RT'), '12')

WebUI.sendKeys(findTestObject('Nasabah/KUR/Info Pribadi/input_RW'), '13')

WebUI.click(findTestObject('Nasabah/KUR/Info Pribadi/button_Selanjutnya'))
CustomKeywords.'custom.Access.UserLogout'()

