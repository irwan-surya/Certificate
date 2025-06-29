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

public class PROD {

	@Keyword
	SINGLEC1(){
		Access.UserLogin(
				GlobalVariable.CorpID_PROD_SINGLEC1,
				GlobalVariable.UserID_PROD_SINGLEC1,
				GlobalVariable.Pass_Prod_SINGLEC1,
				GlobalVariable.Prod_URL
				)
	}

	@Keyword
	MULTIE1_Admin1(){
		Access.UserLogin(
				GlobalVariable.CorpID_PROD_MULTIE1,
				GlobalVariable.UserID_PROD_Admin1,
				GlobalVariable.Pass_Prod_MULTIE1,
				GlobalVariable.Prod_URL
				)
	}

	@Keyword
	MULTIE1_Admin2(){
		Access.UserLogin(
				GlobalVariable.CorpID_PROD_MULTIE1,
				GlobalVariable.UserID_PROD_Admin2,
				GlobalVariable.Pass_Prod_MULTIE1,
				GlobalVariable.Prod_URL
				)
	}
}
