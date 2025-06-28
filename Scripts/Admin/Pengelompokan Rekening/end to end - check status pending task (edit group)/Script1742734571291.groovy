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

import com.kms.katalon.core.webui.keyword.WebUiBuiltInKeywords as WebUI
import com.kms.katalon.core.testcase.TestCaseFactory as TestCaseFactory
import com.kms.katalon.core.model.FailureHandling as FailureHandling
import com.kms.katalon.core.webui.driver.DriverFactory

import org.openqa.selenium.By
import org.openqa.selenium.WebDriver
import org.openqa.selenium.WebElement

CustomKeywords.'custom.Access.UserLogin'(
	GlobalVariable.CorpID_PROD_MULTIE1,
	GlobalVariable.UserID_PROD_Admin2,
	GlobalVariable.Pass_Prod_MULTIE1,
	GlobalVariable.Prod_URL)

WebUI.maximizeWindow()
WebUI.click(findTestObject('Admin/Sidebar_Daftar Tugas'))
WebUI.click(findTestObject('Admin/Pengelompokan Rekening/Admin2/submenu_Pengaturan Rekening'))

// Get the active WebDriver instance
WebDriver driver = DriverFactory.getWebDriver()

// Find all rows based on "MuiCardContent-root" class
List<WebElement> rows = driver.findElements(By.cssSelector("div.MuiCardContent-root.css-qzdrxb"))

// Flag to determine if matching row is found
boolean matchFound = false

// Loop through each row
for (WebElement row : rows) {
	// Get all 'div' elements inside this row
	List<WebElement> columns = row.findElements(By.cssSelector("div.MuiBox-root"))

	if (columns.size() >= 5) {
		// Description is usually the 4th column (index 3)
		String description = columns[3].getText().trim()
		// Status is usually in the 5th column (index 4)
		String status = columns[4].getText().trim()

		if (description.equalsIgnoreCase("Edit Kelompok") && status.equalsIgnoreCase("Menunggu Persetujuan")) {
			matchFound = true
			break
		}
	}
}

// Branch to the correct test case
if (matchFound) {
	WebUI.comment("Found row with 'Edit Group' and 'Waiting for Approval'. Start validate popup.")
	CustomKeywords.'custom.Access.UserLogout'()
	WebUI.callTestCase(findTestCase('Test Cases/Admin/Pengelompokan Rekening/Edit Grup - validate popup pending task'), [:], FailureHandling.STOP_ON_FAILURE)
	
} else {
	WebUI.comment("No matching row found. Start edit group and validate popup.")
	CustomKeywords.'custom.Access.UserLogout'()
	WebUI.callTestCase(findTestCase('Test Cases/Admin/Pengelompokan Rekening/Edit Grup'), [:], FailureHandling.STOP_ON_FAILURE)
	WebUI.callTestCase(findTestCase('Test Cases/Admin/Pengelompokan Rekening/Edit Grup - validate popup pending task'), [:], FailureHandling.STOP_ON_FAILURE)
}