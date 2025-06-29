package credential

import static com.kms.katalon.core.checkpoint.CheckpointFactory.findCheckpoint
import static com.kms.katalon.core.testcase.TestCaseFactory.findTestCase
import static com.kms.katalon.core.testdata.TestDataFactory.findTestData
import static com.kms.katalon.core.testobject.ObjectRepository.findTestObject
import static com.kms.katalon.core.testobject.ObjectRepository.findWindowsObject

import com.kms.katalon.core.annotation.Keyword
import com.kms.katalon.core.checkpoint.Checkpoint
import com.kms.katalon.core.cucumber.keyword.CucumberBuiltinKeywords as CucumberKW
import com.kms.katalon.core.mobile.keyword.MobileBuiltInKeywords as Mobile
import com.kms.katalon.core.model.FailureHandling
import com.kms.katalon.core.testcase.TestCase
import com.kms.katalon.core.testdata.TestData
import com.kms.katalon.core.testobject.TestObject
import com.kms.katalon.core.webservice.keyword.WSBuiltInKeywords as WS
import com.kms.katalon.core.webui.keyword.WebUiBuiltInKeywords as WebUI
import com.kms.katalon.core.windows.keyword.WindowsBuiltinKeywords as Windows
import custom.Access

import internal.GlobalVariable

public class UAT {

	@Keyword
	Ngakak(){
		Access.UserLogin(
				GlobalVariable.CorpID_UAT_Ngakak,
				GlobalVariable.UserID_UAT_Ngakak,
				GlobalVariable.Pass_UAT_Ngakak,
				GlobalVariable.UAT_Url
				)
	}
	
	@Keyword
	cantiks(){
		Access.UserLogin(
				GlobalVariable.CorpID_UAT_cantiks,
				GlobalVariable.UserID_UAT_cantiks,
				GlobalVariable.Pass_UAT_cantiks,
				GlobalVariable.UAT_Url
				)
	}
	
	@Keyword
	manualir1_maker(){
		Access.UserLogin(
			GlobalVariable.CorpID_UAT_manualir1,
			GlobalVariable.UserID_UAT_manualir1_Maker,
			GlobalVariable.Pass_UAT_manualir1,
			GlobalVariable.UAT_Url)
	}
	
	@Keyword
	manualir1_approver(){
		Access.UserLogin(
			GlobalVariable.CorpID_UAT_manualir1,
			GlobalVariable.UserID_UAT_manualir1_Approver,
			GlobalVariable.Pass_UAT_manualir1,
			GlobalVariable.UAT_Url)
	}
	
	@Keyword
	manualir1_releaser(){
		Access.UserLogin(
			GlobalVariable.CorpID_UAT_manualir1,
			GlobalVariable.UserID_UAT_manualir1_Releaser,
			GlobalVariable.Pass_UAT_manualir1,
			GlobalVariable.UAT_Url)
	}
}
