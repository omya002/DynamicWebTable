package dynamicWebTable;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class Dynamic_Web_Table {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		System.setProperty("webdriver.chrome.driver", "D:\\Softwares\\Selenium\\chromedriver.exe");
		WebDriver driver= new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://cosmocode.io/automation-practice-webtable/");
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));


		List<WebElement> totalRows =  driver.findElements(By.xpath("//table[@id ='countries']//tbody//tr"));
		System.out.println("Total Rows in the table are : " +totalRows.size());

		List<WebElement> totalColumns = driver.findElements(By.xpath("//table[@id ='countries']//tbody//tr//h3"));
		System.out.println("Total Columns in the table are : " +totalColumns.size());

		String expectedCurrency = "Guyanese Dollar";

		for(int i=1;i<=totalRows.size();i++) {
			for(int j=1;j<=totalColumns.size(); j++) {
				WebElement tablePath = driver.findElement(By.xpath("//table[@id ='countries']//tbody//tr["+i+"]//td["+j+"]"));
				if(tablePath.getText().equalsIgnoreCase(expectedCurrency)) {
					System.out.println(tablePath.getText());
					break;
				}	
			}
		}

		driver.quit();
	}

}
