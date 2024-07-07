package commonLibs.Utils;

import java.io.File;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;

public class ScreenshotUtils {
	
	private TakesScreenshot camera;
	
	public ScreenshotUtils(WebDriver driver) {
		camera = (TakesScreenshot) driver;
		
	}
	
	public void captureAndSaveScreenshot(String filename) throws Exception{
		filename = filename.trim();
		
		File imgFile, tmpFile;
		imgFile = new File(filename);
		if(imgFile.exists()) {
			throw new Exception("file exists");
		}
		
		tmpFile = camera.getScreenshotAs(OutputType.FILE);
		
		FileUtils.moveFile(tmpFile, imgFile);
		
	}
}
