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

CustomKeywords.'custom.login_keyword.UserLogin'(GlobalVariable.CorpID_PROD_MULTIE1, GlobalVariable.UserID_PROD_Admin1, GlobalVariable.Pass_Prod_MULTIE1,
	GlobalVariable.Prod_URL)

WebUI.click(findTestObject('Object Repository/Admin/Pengaturan Pengguna/Admin1/Sidebar_Pengaturan Pengguna'))

WebUI.click(findTestObject('Object Repository/Admin/Pengaturan Pengguna/Admin1/Tab_Aktif'))

WebUI.click(findTestObject('Object Repository/Admin/Pengaturan Pengguna/Admin1/button_Terapkan'))

WebUI.verifyElementPresent(findTestObject('Object Repository/Admin/Pengaturan Pengguna/Admin1/Status_Aktif'), 10)

WebUI.click(findTestObject('Object Repository/Admin/Pengaturan Pengguna/Admin1/button_Tambah'))

def field = [
	[name: 'User ID', objectPath: 'Admin/Pengaturan Pengguna/Admin1/input_userid', negativeLength: UserID_NegativeLength, expectedLength: UserID_ExpectedLength, negativeChar: UserID_NegativeChar, expectedChar: UserID_ExpectedChar ],
	[name: 'Name', objectPath: 'Admin/Pengaturan Pengguna/Admin1/input_Nama', negativeLength: Name_NegativeLength, expectedLength: Name_ExpectedLength, negativeChar: Name_NegativeChar, expectedChar: Name_ExpectedChar ],
	[name: 'Email', objectPath: 'Admin/Pengaturan Pengguna/Admin1/input_email', negativeLength: Email_NegativeLength, expectedLength: Email_ExpectedLength, negativeChar: Email_NegativeChar, expectedChar: Email_ExpectedChar ],
	[name: 'KTP', objectPath: 'Admin/Pengaturan Pengguna/Admin1/input_KTP', negativeLength: KTP_NegativeLength, expectedLength: KTP_ExpectedLength, negativeChar: KTP_NegativeChar, expectedChar: KTP_ExpectedChar ],
	[name: 'HP', objectPath: 'Admin/Pengaturan Pengguna/Admin1/input_No HP', negativeLength: HP_NegativeLength, expectedLength: HP_ExpectedLength, negativeChar: HP_NegativeChar, expectedChar: HP_ExpectedChar ],
]

for (def input : field) {

	CustomKeywords.'custom.login_keyword.VerifyInputLength'(
		input.objectPath,
		input.negativeLength,
		input.expectedLength
	)
	CustomKeywords.'custom.Select_Keyword.ClearField'(input.objectPath)

	CustomKeywords.'custom.login_keyword.VerifyInputType'(
		input.objectPath,
		input.negativeChar,
		input.expectedChar
	)
	CustomKeywords.'custom.Select_Keyword.ClearField'(input.objectPath)
}

//WebUI.sendKeys(findTestObject('Object Repository/Admin/Pengaturan Pengguna/Admin1/input_userid'),UserID)
//
//WebUI.sendKeys(findTestObject('Object Repository/Admin/Pengaturan Pengguna/Admin1/input_Nama'),Name)
//
//WebUI.sendKeys(findTestObject('Object Repository/Admin/Pengaturan Pengguna/Admin1/input_email'),Email)
//
//WebUI.sendKeys(findTestObject('Object Repository/Admin/Pengaturan Pengguna/Admin1/input_KTP'),KTP)
//
//WebUI.sendKeys(findTestObject('Object Repository/Admin/Pengaturan Pengguna/Admin1/input_No HP'),HP)

//CustomKeywords.'custom.login_keyword.UserLogout'()