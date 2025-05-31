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

CustomKeywords.'custom.login_keyword.UserLogin'(
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

CustomKeywords.'custom.login_keyword.VerifyLineError'(
	'Nasabah/KUR/info pengajuan/input_Alasan Pengajuan', 
	'Wajib Diisi',
	'Nasabah/KUR/Info Pribadi/Text/text_Alasan Pengajuan Wajib Diisi' )

CustomKeywords.'custom.login_keyword.VerifyInputLength'(
	'Nasabah/KUR/info pengajuan/input_Alasan Pengajuan',
	alasanPengajuan_NegativeLength,
	alasanPengajuan_ExpectedLength 
	)
CustomKeywords.'custom.Select_Keyword.ClearField'('Nasabah/KUR/info pengajuan/input_Alasan Pengajuan')
	
CustomKeywords.'custom.login_keyword.VerifyInputType'(
	'Nasabah/KUR/info pengajuan/input_Alasan Pengajuan', 
	alasanPengajuan_NegativeChar, 
	alasanPengajuan_ExpectedChar)
CustomKeywords.'custom.Select_Keyword.ClearField'('Nasabah/KUR/info pengajuan/input_Alasan Pengajuan')

WebUI.sendKeys(findTestObject('Nasabah/KUR/info pengajuan/input_Alasan Pengajuan'), alasanPengajuan)

WebUI.sendKeys(findTestObject('Nasabah/KUR/info pengajuan/input_Jumlah Pinjaman'), '25000000')

WebUI.click(findTestObject('Nasabah/KUR/Info Pribadi/button_Selanjutnya'))

//informasi pribadi

CustomKeywords.'custom.login_keyword.VerifyLineError'(
	'Nasabah/KUR/Info Pribadi/input_Kota Kelahiran',
	'Wajib Diisi',
	'Nasabah/KUR/Info Pribadi/Text/text_Kota Kelahiran Wajib Diisi' )

CustomKeywords.'custom.login_keyword.VerifyInputLength'(
	'Nasabah/KUR/Info Pribadi/input_Kota Kelahiran', 
	kotaKelahiran_NegativeLength, 
	kotaKelahiran_ExpectedLength)

CustomKeywords.'custom.Select_Keyword.ClearField'('Nasabah/KUR/Info Pribadi/input_Kota Kelahiran')

CustomKeywords.'custom.login_keyword.VerifyInputType'(
	'Nasabah/KUR/Info Pribadi/input_Kota Kelahiran',
	kotaKelahiran_NegativeChar,
	kotaKelahiran_ExpectedChar)
CustomKeywords.'custom.Select_Keyword.ClearField'('Nasabah/KUR/Info Pribadi/input_Kota Kelahiran')

WebUI.sendKeys(findTestObject('Nasabah/KUR/Info Pribadi/input_Kota Kelahiran'), kotaKelahiran)

CustomKeywords.'custom.Select_Keyword.SelectDropdown'(
	'Nasabah/KUR/Info Pribadi/Dropdown_Jenis Kelamin', 
	'Nasabah/KUR/Info Pribadi/list_Laki-laki')

CustomKeywords.'custom.Select_Keyword.SelectDropdown'(
	'Nasabah/KUR/Info Pribadi/datepicker_tanggal lahir',
	'Nasabah/KUR/Info Pribadi/div_13')

WebUI.scrollToElement(findTestObject('Nasabah/KUR/Info Pribadi/input_RT'), 10)

WebUI.click(findTestObject('Nasabah/KUR/Info Pribadi/radio_btn_Belum Menikah'))

WebUI.click(findTestObject('Nasabah/KUR/Info Pribadi/radio_btn_Milik Sendiri'))

	//alamat domisili
CustomKeywords.'custom.login_keyword.VerifyLineError'(
	'Nasabah/KUR/Info Pribadi/input_Alamat Domisili',
	'Wajib Diisi',
	'Nasabah/KUR/Info Pribadi/Text/text_Alamat Domisili Wajib Diisi' )

CustomKeywords.'custom.login_keyword.VerifyInputLength'(
	'Nasabah/KUR/Info Pribadi/input_Alamat Domisili',
	alamatDomisili_NegativeLength,
	alamatDomisili_ExpectedLength)
CustomKeywords.'custom.Select_Keyword.ClearField'('Nasabah/KUR/Info Pribadi/input_Alamat Domisili')

CustomKeywords.'custom.login_keyword.VerifyInputType'(
	'Nasabah/KUR/Info Pribadi/input_Alamat Domisili',
	alamatDomisili_NegativeChar,
	alamatDomisili_ExpectedChar)
CustomKeywords.'custom.Select_Keyword.ClearField'('Nasabah/KUR/Info Pribadi/input_Alamat Domisili')

WebUI.sendKeys(findTestObject('Nasabah/KUR/Info Pribadi/input_Alamat Domisili'), alamatDomisili)

	//provinsi, kota, kec, kel
def dropdown1 = [
	[placeholder: 'Nasabah/KUR/Info Pribadi/Dropdown_Pilih Provinsi', 	 list: 'Nasabah/KUR/Info Pribadi/list_DI Yogyakarta'],
	[placeholder: 'Nasabah/KUR/Info Pribadi/Dropdown_Pilih Kota',		 list: 'Nasabah/KUR/Info Pribadi/list_Kota Yogyakarta'],
	[placeholder: 'Nasabah/KUR/Info Pribadi/Dropdown_Pilih Kecamatan',	 list: 'Nasabah/KUR/Info Pribadi/list_Gondomanan'],
	[placeholder: 'Nasabah/KUR/Info Pribadi/Dropdown_Pilih Kelurahan',	 list: 'Nasabah/KUR/Info Pribadi/list_Prawirodirjan']
	]
	
for (def select : dropdown1) {
	CustomKeywords.'custom.Select_Keyword.SelectDropdown'(
		select.placeholder,
		select.list)
}

//	rt & rw
def field = [
	[name: 'RT', objectPath: 'Nasabah/KUR/Info Pribadi/input_RT', textPath: 'Nasabah/KUR/Info Pribadi/Text/text_RT Wajib Diisi'],
	[name: 'RW', objectPath: 'Nasabah/KUR/Info Pribadi/input_RW', textPath: 'Nasabah/KUR/Info Pribadi/Text/text_RW Wajib Diisi']
]

for (def input : field) {
	CustomKeywords.'custom.login_keyword.VerifyLineError'(
		input.objectPath,
		'Wajib Diisi',
		input.textPath
	)

	CustomKeywords.'custom.login_keyword.VerifyInputLength'(
		input.objectPath,
		RTRW_NegativeLength,
		RTRW_ExpectedLength
	)
	CustomKeywords.'custom.Select_Keyword.ClearField'(input.objectPath)

	CustomKeywords.'custom.login_keyword.VerifyInputType'(
		input.objectPath,
		RTRW_NegativeChar,
		RTRW_ExpectedChar
	)
	CustomKeywords.'custom.Select_Keyword.ClearField'(input.objectPath)

	WebUI.sendKeys(findTestObject(input.objectPath), RTRW)
}

WebUI.click(findTestObject('Nasabah/KUR/Info Pribadi/button_Selanjutnya'))

//Informasi usaha

	//Nama Usaha
CustomKeywords.'custom.Select_Keyword.ClearField'('Nasabah/KUR/Info Usaha/input_Nama Usaha')

CustomKeywords.'custom.login_keyword.VerifyLineError'(
	'Nasabah/KUR/Info Usaha/input_Nama Usaha',
	'Wajib Diisi',
	'Nasabah/KUR/Info Usaha/Text/text_nama usaha Wajib Diisi' )

CustomKeywords.'custom.login_keyword.VerifyInputLength'(
	'Nasabah/KUR/Info Usaha/input_Nama Usaha',
	NamaUsaha_NegativeLength,
	NamaUsaha_ExpectedLength)
CustomKeywords.'custom.Select_Keyword.ClearField'('Nasabah/KUR/Info Usaha/input_Nama Usaha')

CustomKeywords.'custom.login_keyword.VerifyInputType'(
	'Nasabah/KUR/Info Usaha/input_Nama Usaha',
	NamaUsaha_NegativeChar,
	NamaUsaha_ExpectedChar)
CustomKeywords.'custom.Select_Keyword.ClearField'('Nasabah/KUR/Info Usaha/input_Nama Usaha')

WebUI.sendKeys(findTestObject('Nasabah/KUR/Info Usaha/input_Nama Usaha'), NamaUsaha)

	//omset usaha
CustomKeywords.'custom.login_keyword.VerifyLineError'(
	'Nasabah/KUR/Info Usaha/input_Omset Usaha',
	'Wajib Diisi',
	'Nasabah/KUR/Info Usaha/Text/text_omset usaha Wajib Diisi' )

CustomKeywords.'custom.login_keyword.VerifyInputLength'(
	'Nasabah/KUR/Info Usaha/input_Omset Usaha',
	omsetUsaha_NegativeLength,
	omsetUsaha_ExpectedLength)
CustomKeywords.'custom.Select_Keyword.ClearField'('Nasabah/KUR/Info Usaha/input_Omset Usaha')

CustomKeywords.'custom.login_keyword.VerifyInputType'(
	'Nasabah/KUR/Info Usaha/input_Omset Usaha',
	omsetUsaha_NegativeChar,
	omsetUsaha_ExpectedChar)
CustomKeywords.'custom.Select_Keyword.ClearField'('Nasabah/KUR/Info Usaha/input_Omset Usaha')
WebUI.sendKeys(findTestObject('Nasabah/KUR/Info Usaha/input_Omset Usaha'), omsetUsaha)

	//sektor usaha & status tmpt usaha
def dropdown2 = [
	[placeholder: 'Nasabah/KUR/Info Usaha/Dropdown_Sektor Usaha', 	 	list: 'Nasabah/KUR/Info Usaha/list_Perdagangan Eceran'],
	[placeholder: 'Nasabah/KUR/Info Usaha/Dropdown_Status Tempat Usaha',list: 'Nasabah/KUR/Info Usaha/list_Milik Sendiri']
	]
	
for (def select : dropdown2) {
	CustomKeywords.'custom.Select_Keyword.SelectDropdown'(
		select.placeholder,
		select.list)
}
	//lama usaha
CustomKeywords.'custom.login_keyword.VerifyLineError'(
	'Nasabah/KUR/Info Usaha/input_Lama Usaha',
	'Wajib Diisi',
	'Nasabah/KUR/Info Usaha/Text/text_lama usaha Wajib Diisi' )

CustomKeywords.'custom.login_keyword.VerifyInputLength'(
	'Nasabah/KUR/Info Usaha/input_Lama Usaha',
	lamaUsaha_NegativeLength,
	lamaUsaha_ExpectedLength)
CustomKeywords.'custom.Select_Keyword.ClearField'('Nasabah/KUR/Info Usaha/input_Lama Usaha')

CustomKeywords.'custom.login_keyword.VerifyInputType'(
	'Nasabah/KUR/Info Usaha/input_Lama Usaha',
	lamaUsaha_NegativeChar,
	lamaUsaha_ExpectedChar)
CustomKeywords.'custom.Select_Keyword.ClearField'('Nasabah/KUR/Info Usaha/input_Lama Usaha')
WebUI.sendKeys(findTestObject('Nasabah/KUR/Info Usaha/input_Lama Usaha'), lamaUsaha)

	//alamat usaha
CustomKeywords.'custom.login_keyword.VerifyLineError'(
	'Nasabah/KUR/Info Usaha/input_Alamat Usaha',
	'Wajib Diisi',
	'Nasabah/KUR/Info Usaha/Text/text_alamat usaha Wajib Diisi' )

CustomKeywords.'custom.login_keyword.VerifyInputLength'(
	'Nasabah/KUR/Info Usaha/input_Alamat Usaha',
	alamatUsaha_NegativeLength,
	alamatUsaha_ExpectedLength)
CustomKeywords.'custom.Select_Keyword.ClearField'('Nasabah/KUR/Info Usaha/input_Alamat Usaha')

CustomKeywords.'custom.login_keyword.VerifyInputType'(
	'Nasabah/KUR/Info Usaha/input_Alamat Usaha',
	alamatUsaha_NegativeChar,
	alamatUsaha_ExpectedChar)
CustomKeywords.'custom.Select_Keyword.ClearField'('Nasabah/KUR/Info Usaha/input_Alamat Usaha')

WebUI.sendKeys(findTestObject('Nasabah/KUR/Info Usaha/input_Alamat Usaha'), alamatUsaha)
WebUI.scrollToElement(findTestObject('Nasabah/KUR/Info Usaha/input_RT Usaha'), 10)

//provinsi, kota, kec, kel
def dropdown = [
	[placeholder: 'Nasabah/KUR/Info Pribadi/Dropdown_Pilih Provinsi', 	 list: 'Nasabah/KUR/Info Pribadi/list_DI Yogyakarta'],
	[placeholder: 'Nasabah/KUR/Info Usaha/Dropdown_Pilih KotaKabupaten',		 list: 'Nasabah/KUR/Info Pribadi/list_Kota Yogyakarta'],
	[placeholder: 'Nasabah/KUR/Info Usaha/Dropdown_Pilih Kecamatan',	 list: 'Nasabah/KUR/Info Pribadi/list_Gondomanan'],
	[placeholder: 'Nasabah/KUR/Info Usaha/Dropdown_Kelurahan',	 list: 'Nasabah/KUR/Info Usaha/list_Prawirodirjan']
	]
	
for (def select : dropdown) {
	CustomKeywords.'custom.Select_Keyword.SelectDropdown'(
		select.placeholder,
		select.list)
}

//	rt & rw
def fields = [
	[name: 'RT', objectPath: 'Nasabah/KUR/Info Usaha/input_RT Usaha', textPath: 'Nasabah/KUR/Info Usaha/text/text_RT Wajib Diisi'],
	[name: 'RW', objectPath: 'Nasabah/KUR/Info Usaha/input_RW Usaha', textPath: 'Nasabah/KUR/Info Usaha/text/text_RW Wajib Diisi']
]
for (def input : fields) {
	CustomKeywords.'custom.login_keyword.VerifyLineError'(
		input.objectPath,
		'Wajib Diisi',
		input.textPath
	)

	CustomKeywords.'custom.login_keyword.VerifyInputLength'(
		input.objectPath,
		RTRW_NegativeLength,
		RTRW_ExpectedLength
	)
	CustomKeywords.'custom.Select_Keyword.ClearField'(input.objectPath)

	CustomKeywords.'custom.login_keyword.VerifyInputType'(
		input.objectPath,
		RTRW_NegativeChar,
		RTRW_ExpectedChar
	)
	CustomKeywords.'custom.Select_Keyword.ClearField'(input.objectPath)

	WebUI.sendKeys(findTestObject(input.objectPath), RTRW)
}

WebUI.click(findTestObject('Nasabah/KUR/Info Pribadi/button_Selanjutnya'))



//CustomKeywords.'custom.login_keyword.UserLogout'()

