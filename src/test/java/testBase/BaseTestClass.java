package testBase;

import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.net.URI;
import java.net.URL;
import java.text.SimpleDateFormat;
import java.time.Duration;
import java.util.Date;
import java.util.Properties;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.Platform;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;

public class BaseTestClass {
	public static WebDriver driver;
	 public  Logger logger; 
	public Properties p;
	
	
	@BeforeClass(groups= {"Sanity","Regresssion","Master"})
	@Parameters({"os","browser"})
	public void setUp(String os,String br) throws IOException
{
		//loading config.properties file
		
			FileReader file=new FileReader("./src/test/resources//config.properties");
			p=new Properties();
			p.load(file);
		
			logger= LogManager.getLogger(this.getClass());
			if(p.getProperty("execution_env").equals("remote"))
			{
				 DesiredCapabilities dc=new DesiredCapabilities();
				 if(os.equalsIgnoreCase("windows"))
				 {
					 dc.setPlatform(Platform.WIN11);
				 }
				 else if(os.equalsIgnoreCase("mac"))
				 {
					 dc.setPlatform(Platform.MAC);
				 }
				 
				 switch(br.toLowerCase())
					{
					case "chrome" :dc.setBrowserName("chrome");break;
					case "firefox" :dc.setBrowserName("firefox");break;
					case "edge" :dc.setBrowserName("MicrosoftEdge");break;
					default :System.out.println("No matching browswer");return;
					}
				// driver = new RemoteWebDriver(URI.create("http://localhost:4444/wd/hub").toURL(),dc);
				 driver = new RemoteWebDriver(new URL("http://localhost:4444/wd/hub"),dc);
				 driver.manage().deleteAllCookies();
					driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
					driver.get(p.getProperty("appUrl"));
					driver.manage().window().maximize();
			}
			if(p.getProperty("execution_env").equals("local"))
			{	
			
	switch(br.toLowerCase())
	{
	case "chrome" :driver=new ChromeDriver();break;
	case "firefox" :driver=new FirefoxDriver();break;
	case "edge" :driver=new EdgeDriver();break;
	default :System.out.println("Invalid browser name");return;
	}
	
	driver.manage().deleteAllCookies();
	driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
	driver.get(p.getProperty("appUrl"));
	driver.manage().window().maximize();

}
}
	


	public String captureScreen(String name) {
		// TODO Auto-generated method stub
		String timeStamp = new SimpleDateFormat("yyyy.MM.dd.HH.mm.ss").format(new Date());
		TakesScreenshot ts=(TakesScreenshot)driver;
		File src=ts.getScreenshotAs(OutputType.FILE);
		String filePath=System.getProperty("user.dir")+"\\screenshots\\"+name+ "-"+timeStamp;
		File target=new File(filePath);
		src.renameTo(target);
		return filePath;
	}
	
	@AfterClass(groups= {"Sanity","Regresssion","Master"})
	public void tearDown()
{  if(driver!=null)
		{
	driver.close();
		}
}
}
