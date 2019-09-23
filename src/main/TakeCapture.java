package main;

import java.io.File;
import java.io.IOException;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.OutputType;

import com.machinepublishers.jbrowserdriver.JBrowserDriver;

public class TakeCapture {
	public static void main(String[] args) {
		int code = 0;
		try {
			JBrowserDriver driver = new JBrowserDriver();
			driver.get(args[0]);
			Dimension d = driver.findElementById(args[1]).getSize();
			driver.manage().window().setSize(new Dimension(d.width + 100, d.height));
			File screenshot = driver.getScreenshotAs(OutputType.FILE);
			FileUtils.copyFile(screenshot, new File(args[2]));
			code = 1;
		} catch (IOException e) {
			e.printStackTrace();
			code = 0;
		} finally {
			System.exit(code);
		}
	}
}