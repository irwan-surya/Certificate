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

WebUI.click(findTestObject('Admin/Pengaturan Kelompok/sidebar_Pengaturan Kelompok'))

WebUI.click(findTestObject('Admin/Pengaturan Kelompok/Admin1/button_Tambah Daftar'))

CustomKeywords.'custom.Access.VerifyLineError'(
	'Admin/Pengaturan Kelompok/Admin1/input_Kode kelompok',
	'Kode Harus Terisi',
	'Admin/Pengaturan Kelompok/Admin1/text/text_Kode Harus Terisi' )

CustomKeywords.'custom.Access.VerifyLineError'(
	'Admin/Pengaturan Kelompok/Admin1/input_Nama Kelompok',
	'Nama Kelompok Harus Terisi',
	'Admin/Pengaturan Kelompok/Admin1/text/text_Nama Kelompok Harus Terisi' )

def field = [
	[name: 'Kode Kelompok', objectPath: 'Admin/Pengaturan Kelompok/Admin1/input_Kode kelompok', negativeLength: KodeKelompok_NegativeLength, expectedLength: KodeKelompok_ExpectedLength, negativeChar: KodeKelompok_NegativeChar, expectedChar: KodeKelompok_ExpectedChar ],
	[name: 'Nama kelompok', objectPath: 'Admin/Pengaturan Kelompok/Admin1/input_Nama Kelompok', negativeLength: NamaKelompok_NegativeLength, expectedLength: NamaKelompok_ExpectedLength, negativeChar: NamaKelompok_NegativeChar, expectedChar: NamaKelompok_ExpectedChar ]
	
]

for (def input : field) {

	CustomKeywords.'custom.Access.VerifyInputLength'(
		input.objectPath,
		input.negativeLength,
		input.expectedLength
	)
	CustomKeywords.'custom.Select_Keyword.ClearField'(input.objectPath)

	CustomKeywords.'custom.Access.VerifyInputType'(
		input.objectPath,
		input.negativeChar,
		input.expectedChar
	)
	CustomKeywords.'custom.Select_Keyword.ClearField'(input.objectPath)
}

WebUI.sendKeys(findTestObject('Admin/Pengaturan Kelompok/Admin1/input_Kode kelompok'), kodeKelompok)

WebUI.sendKeys(findTestObject('Admin/Pengaturan Kelompok/Admin1/input_Nama Kelompok'), NamaKelompok)

WebUI.click(findTestObject('Admin/Pengaturan Kelompok/Admin1/Checkbox_Daftar Fitur Pengguna'))

CustomKeywords.'custom.Select_Keyword.SelectDropdown'('Admin/Pengaturan Kelompok/Admin1/Dropdown_Kelompok Rekening', 'Admin/Pengaturan Kelompok/Admin1/div_Default')

//WebUI.click(findTestObject('Admin/Pengaturan Kelompok/Admin1/button_Simpan'))
//
//WebUI.click(findTestObject('Admin/Pengaturan Kelompok/Admin1/button_OK'))

CustomKeywords.'custom.Access.UserLogout'()