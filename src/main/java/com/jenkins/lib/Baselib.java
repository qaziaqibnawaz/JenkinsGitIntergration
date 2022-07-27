package com.jenkins.lib;


import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.lang.reflect.Method;
import java.net.URL;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

import java.util.concurrent.TimeUnit;


import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.Assert;
import org.testng.ITestContext;
import org.testng.ITestNGMethod;
import org.testng.ITestResult;
import org.testng.Reporter;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;



import io.github.bonigarcia.wdm.WebDriverManager;



public class Baselib {

	String browser=System.getProperty("browser");
	
	

	static{
		System.setProperty(GenericLib.getPropData("browserkey"), GenericLib.getPropData("browservalue"));
	}

	public WebDriver driver;
	
	  
	  
	 /*local-----------------------------------------------------------------------*/

	
	  
	
	@BeforeMethod
	   public void name() throws IOException {
		System.out.println("browser name"+browser);
	if(browser.equalsIgnoreCase("chrome"))
	{


			//   System.out.println("Hello Chrome");
          WebDriverManager.chromedriver().setup();
		   //    Map<String, Object> prefs = new HashMap<String, Object>();

		        ChromeOptions options = new ChromeOptions();
		   
		     
System.out.println("hello world");
			driver = new ChromeDriver(options); 
		

			}

		else if(browser.equalsIgnoreCase("firefox"))  
		{
			WebDriver driver = new FirefoxDriver();
			WebDriverManager.firefoxdriver().setup();
			FirefoxOptions options = new FirefoxOptions();
			//options.addPreference("dom.webnotifications.enabled", false);
			//WebDriverManager.firefoxdriver().setup();
			//driver = new FirefoxDriver(options); 
			}
		else {
			Assert.fail("browser name not valid");
		}


		Reporter.log("Browser launched successfully ");
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		driver.manage().window().maximize();



		driver.get(GenericLib.getPropData("url1"));
		



		Reporter.log("Application loaded ");
	      
	   }
	
	
	
	

	
	
	
	@BeforeClass
//	@Parameters({ "browsername" })
	public void setUp(ITestContext contex) {
		   
	      

	
			}
	
	
	@AfterClass
	public void tearDown() {

  driver.close();
		
	}
	public void copyXml(){
        String actualXmlPath = System.getProperty("user.dir")+"/test-output/testng-results.xml";
        String timeStamp = new SimpleDateFormat("yyyy_MM_dd_hh_mm_ss").format(Calendar.getInstance().getTime());
        String targetPath = System.getProperty("user.dir")+"/test-output/"+ timeStamp +"-testng-results.xml";;
        try{
            BufferedReader read = new BufferedReader(new FileReader(actualXmlPath));
            BufferedWriter write = new BufferedWriter(new FileWriter(targetPath));
            String str = "";
            while((str = read.readLine())!=null){
                write.write(str);
            }
            read.close();
            write.close();

        }catch (Exception e){
            e.printStackTrace();
        }
    }
	
	@AfterSuite
	public void tearDownSuite() {
	    // reporter.endReport();
	
	//    copyXml();
	//    extent.close();
	}

	//Method for adding logs passed from test cases
	
	 @AfterMethod(alwaysRun=true)
	  public void TearDown_AM(ITestResult result) throws IOException
	  {
	    //  System.out.println("@After Method");
	    try
	    { 
	        if(result.getStatus()==ITestResult.FAILURE)
	        {
	      //     String res = saveScreenShot(driver, result.getName());
	      //      String image= logger.addScreenCapture(res);
	      //      System.out.println(image);
	            String TestCaseName = this.getClass().getSimpleName() + " Test Case Failure and Title/Boolean Value Failed";
	        	            //  logger.log(LogStatus.FAIL, image, this.getClass().getSimpleName() + " Test Case Failure and Title/Boolean Value Failed");
	        }
	        else if(result.getStatus()==ITestResult.SUCCESS)
	        {
	           
	        }
	        else if(result.getStatus()==ITestResult.SKIP)
	        {
	          
	        }
	      

	    }
	    catch(Throwable t)
	    {
	      
	    }

	  }
	 
	 /*browserstack---------------------------------------------------------------------------------------------------------------------------------------------------
	  * -------------------------------------*/
	  /*
	@BeforeSuite
		public void before() {
		    extent = new ExtentReports("target\\ExtentReport.html", true);
		}

	     @BeforeMethod(alwaysRun = true)
	    @org.testng.annotations.Parameters(value = { "config"})
	    @SuppressWarnings("unchecked")
	    public void setUp(String config_file,Method method) throws Exception {
	        JSONParser parser = new JSONParser();
	        JSONObject config = (JSONObject) parser.parse(new FileReader("src/test/resources/conf/" + config_file));
	        JSONObject envs = (JSONObject) config.get("environments");
	        System.out.println(method.getName());
		      FileInputStream  fin= new FileInputStream(projDir+"\\src\\test\\resources\\excel\\ScriptNames2.xls");
				 
	        //Create Workbook instance holding reference to .xlsx file
	        HSSFWorkbook workbook = new HSSFWorkbook(fin);

	        //Get first/desired sheet from the workbook
	        HSSFSheet sheet = workbook.getSheetAt(0);

	        //Iterate through each rows one by one
	        Iterator<Row> rowIterator = sheet.iterator();
	        while (rowIterator.hasNext()) 
	        {
	            Row row = rowIterator.next();
	            
	            
	            //For each row, iterate through all the columns
	            Iterator<Cell> cellIterator = row.cellIterator();
	            
	             
	            while (cellIterator.hasNext()) 
	            {
	            	
	                Cell cell;
	                
	                cell= cellIterator.next();
	        //        testCase=cell.getStringCellValue();
	        // 	   System.out.println(testCase);
	                
	                
	                
	                //Check the cell type and format accordingly
	                if(cell.getStringCellValue().equalsIgnoreCase(method.getName()))
	                {
	              	  cell = cellIterator.next();
	              	  cell = cellIterator.next();
	              	  browsername1=cell.getStringCellValue();
	                	cell = cellIterator.next();
	                	OS=cell.getStringCellValue();
	              	   System.out.println(browsername1);
	            	   System.out.println(OS);
	                }
	                
	                
	         //       System.out.print(testCase);
	            }
	            

	        }

	     
	        DesiredCapabilities caps = new DesiredCapabilities();
	        caps.setCapability("os", OS);
	        caps.setCapability("os_version", "10");
	        caps.setCapability("browser", browsername1);
	     

	        String username = System.getenv("BROWSERSTACK_USERNAME");
	        if (username == null) {
	            username = (String) config.get("user");
	        }

	        String accessKey = System.getenv("BROWSERSTACK_ACCESS_KEY");
	        if (accessKey == null) {
	            accessKey = (String) config.get("key");
	        }

	  
	        driver = new RemoteWebDriver(
	                new URL("http://" + username + ":" + accessKey + "@" + config.get("server") + "/wd/hub"), caps);
	        driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);

	        driver.manage().window().maximize();
	        driver.get(GenericLib.getPropData("url1"));
	     }

	    @AfterClass(alwaysRun = true)
	    public void tearDown() throws Exception {
	        driver.close();
	        if (l != null) {
	            l.stop();
	        }
	    }
	    @AfterMethod(alwaysRun=true)
		  public void TearDown_AM(ITestResult result) throws IOException
		  {
		    //  System.out.println("@After Method");
		    try
		    { 
		        if(result.getStatus()==ITestResult.FAILURE)
		        {
		      //     String res = saveScreenShot(driver, result.getName());
		      //      String image= logger.addScreenCapture(res);
		      //      System.out.println(image);
		            String TestCaseName = this.getClass().getSimpleName() + " Test Case Failure and Title/Boolean Value Failed";
		            test.log(LogStatus.FAIL, TestCaseName );
		            //  logger.log(LogStatus.FAIL, image, this.getClass().getSimpleName() + " Test Case Failure and Title/Boolean Value Failed");
		        }
		        else if(result.getStatus()==ITestResult.SUCCESS)
		        {
		            test.log(LogStatus.PASS, this.getClass().getSimpleName() + " Test Case Success and Title Verified"); 
		        }
		        else if(result.getStatus()==ITestResult.SKIP)
		        {
		            test.log(LogStatus.SKIP, this.getClass().getSimpleName() + " Test Case Skipped");
		        }
		      

		    }
		    catch(Throwable t)
		    {
		        test.log(LogStatus.ERROR,t.fillInStackTrace());
		    }

		  }
	    @AfterSuite
		public void tearDownSuite() {
		    // reporter.endReport();
		    extent.flush();
		//    extent.close();
		}
*/
	
	
}
