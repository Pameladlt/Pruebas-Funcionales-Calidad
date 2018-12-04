/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
import java.util.logging.Level;
import java.util.logging.Logger;
import org.junit.AfterClass;
import static org.junit.Assert.assertEquals;
import org.junit.BeforeClass;
import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runners.MethodSorters;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

/**
 *
 * @author karen
 */
@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class TestIndex {
    private static final String URL = "https://mylistapp.000webhostapp.com/index.php";
    private static ChromeDriver driver;
    public TestIndex() {
    }
    
    @BeforeClass
    public static void setUp() {
        //setear el driver
        System.setProperty("webdriver.chrome.driver","chromedriver.exe");
        //abrir chrome
        driver = new ChromeDriver(); 
        driver.get(URL);
                try {
            Thread.sleep(2000);
        } catch (InterruptedException ex) {
            Logger.getLogger(TestIndex.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    @AfterClass
    public static void tearDown() {
        //Cerrar el browser y el driver
        driver.quit();
    }

         @Test
     public void AddTaskTest(){
        WebElement Inputtask = driver.findElementById("taskname");
        Inputtask.sendKeys("leer libro");  
        WebElement InputType = driver.findElementById("tasktype");
        InputType.sendKeys("estudio");
        WebElement InputImp = driver.findElementById("taskimp");
        InputImp.sendKeys("media");
        WebElement Send = driver.findElementByClassName("add_btn");
        Send.click();
        WebElement Task = driver.findElementByClassName("task");
        
        String result= Task.getText();
        String expected="leer libro";
        assertEquals(expected, result);
        }
      
          @Test
     public void BCompleteTaskTest(){
        WebElement registro1 = driver.findElementByXPath("//*[@id=\"tareas\"]");
        WebElement ComBtn = registro1.findElement(By.className("Com_btn"));
        ComBtn.click();
        WebElement Task= driver.findElementByClassName("task");
        WebElement ComTask= driver.findElementByClassName("comtask");
        String result= ComTask.getText();
        String expected= Task.getText();
        assertEquals(expected,result);
     }
    
      @Test
     public void CShowTasksTest(){
        WebElement registro1 = driver.findElementByXPath("//*[@id=\"tareas\"]");
        String result = registro1.findElement(By.className("id")).getText();
        String expected = "1";
        assertEquals(expected, result);
     }
     
           @Test
     public void DComTasksTest(){
        WebElement registro1 = driver.findElementByXPath("//*[@id=\"completas\"]");
        String result = registro1.findElement(By.className("id")).getText();
        String expected = "1";
        assertEquals(expected, result);
     }
     
      @Test
    public void EDelTaskTest() {
        WebElement DelBtn = driver.findElementByClassName("Del_btn");
        DelBtn.click();
        WebElement Task = driver.findElementByXPath("/html/body/table/tbody");
        
        String result= Task.getText();
        String expected="";
        assertEquals(expected, result);
    }
    
}
