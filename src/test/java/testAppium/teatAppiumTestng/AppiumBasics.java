package testAppium.teatAppiumTestng;

import java.io.File;
import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URISyntaxException;
import java.time.Duration;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.annotations.Test;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.options.UiAutomator2Options;
import io.appium.java_client.service.local.AppiumDriverLocalService;
import io.appium.java_client.service.local.AppiumServiceBuilder;

public class AppiumBasics extends PredefinedActions {

	@Test(enabled = false)
	public void appiumTest() throws MalformedURLException, URISyntaxException {
		AppiumDriverLocalService service = new AppiumServiceBuilder()
				.withAppiumJS(new File(
						"\\Users\\Vive.Kumar\\AppData\\Roaming\\npm\\node_modules\\appium\\build\\lib\\main.js"))
				.withIPAddress("127.0.0.1").usingPort(4723).withArgument(() -> "--base-path=/wd/hub")
				.withTimeout(Duration.ofSeconds(120)).build();
		service.start();

		System.out.println("Appium server URL: " + service.getUrl());

		/*
		 * DesiredCapabilities desiredCapabilities = new DesiredCapabilities();
		 * desiredCapabilities.setCapability("appium:platformName", "Android");
		 * desiredCapabilities.setCapability("appium:deviceName", "Pixel 8 Pro");
		 * desiredCapabilities.setCapability("appium:platformVersion", "14.0");
		 * desiredCapabilities.setCapability("appium:automationName", "UIAutomator2");
		 * desiredCapabilities.setCapability("appium:app",
		 * "C:\\Users\\Vive.Kumar\\eclipse-workspace\\testAppiumTestng\\src\\test\\java\\resources\\ApiDemos-debug.apk"
		 * ); desiredCapabilities.setCapability("appium:appWaitDuration", 25000);
		 * desiredCapabilities.setCapability("appium:systemPort", 4723);
		 */

		UiAutomator2Options options = new UiAutomator2Options();
		// options.setDeviceName("Pixel 8 Pro");
		options.setDeviceName("Android Device");
		options.setApp(
				"C:\\Users\\Vive.Kumar\\eclipse-workspace\\testAppiumTestng\\src\\test\\java\\resources\\ApiDemos-debug.apk");
		// options.setPlatformVersion("14.0");
		// options.setPlatformName("Android");

		AndroidDriver driver = new AndroidDriver(new URL("http://127.0.0.1:4723/wd/hub"), options);
		// Thread.sleep(10000);
		// service.stop();
	}

	@Test
	public void appiumTest1() throws InterruptedException, IOException {
		AppiumDriverLocalService service = new AppiumServiceBuilder()
				.withAppiumJS(new File("/Users/Vive.Kumar/AppData/Roaming/npm/node_modules/appium/build/lib/main.js"))
				.withIPAddress("127.0.0.1").usingPort(4723)
				// .withArgument(() -> "--base-path=/wd/hub")
				.withTimeout(Duration.ofSeconds(120)).build();
		service.start();

		System.out.println("Appium server URL: " + service.getUrl());

		startAVD("Pixel_8_Pro");

		DesiredCapabilities capabilities = new DesiredCapabilities();

		capabilities.setCapability("appium:platformName", "Android");
		capabilities.setCapability("appium:deviceName", "Pixel 8 Pro");
		capabilities.setCapability("appium:platformVersion", "14.0");

		// capabilities.setCapability("appium:deviceName", "Android Device");

		capabilities.setCapability("appium:app",
				"C:\\Users\\Vive.Kumar\\eclipse-workspace\\testAppiumTestng\\src\\test\\java\\resources\\ApiDemos-debug.apk");
		capabilities.setCapability("appium:automationName", "UIAutomator2");
		Thread.sleep(60000);

		AndroidDriver driver = new AndroidDriver(new URL("http://127.0.0.1:4723"), capabilities);
		driver.manage().timeouts().implicitlyWait(300, TimeUnit.SECONDS);

		Thread.sleep(10000);
		service.stop();
		// stopAVD("Pixel_8_Pro");
	}
}
