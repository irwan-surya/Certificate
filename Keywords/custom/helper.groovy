package custom

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
import java.nio.file.*


import internal.GlobalVariable

public class helper {

	static String folderPath = ""
	static int counter = 1
	static boolean folderCleared = false

	@Keyword
	static def setDestinationFolder(String path) {
		folderPath = path.endsWith("/") ? path[0..-2] : path  // Remove trailing slash if exists
		counter = 1
		folderCleared = false
	}

	@Keyword
	static def Screenshoot() {

		if (folderPath == "") {
			println("❌ Folder path not set. Call setDestinationFolder() first.")
			return
		}

		// Only clear the folder before first screenshot
		if (!folderCleared) {
			println("⚠️ Clearing folder: " + folderPath)
			File folder = new File(folderPath)

			if (folder.exists() && folder.isDirectory()) {
				folder.eachFile { file ->
					file.delete()
				}
				println("✅ Folder cleared.")
			} else {
				println("⚠️ Folder does not exist. Creating folder.")
				folder.mkdirs()
			}
			folderCleared = true
		}

		String filename = folderPath + "/TC_" + counter + ".png"

		// Check current zoom level
		        def currentZoom = WebUI.executeJavaScript("return document.body.style.zoom;", null)
		
		        if (currentZoom != '90%') {
		            println("ℹ️ Zoom not at 90%. Setting zoom to 90%.")
		            WebUI.executeJavaScript("document.body.style.zoom='90%'", null)
		            WebUI.delay(1)
		        } else {
		            println("✅ Zoom is already at 90%.")
		        }

		// Take screenshot
		WebUI.takeScreenshot(filename)
		println("✅ Screenshot saved to: " + filename)

		counter++
	}
}
