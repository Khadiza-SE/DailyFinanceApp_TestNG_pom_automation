package testrunner;

import config.Setup;
import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.RegistrationPage;

import java.time.Duration;


public class RegTestRunner extends Setup {

    @Test
    public void userRegistration() throws InterruptedException {
        RegistrationPage userReg=new RegistrationPage(driver);
        String firstname="Tefdfghkfdg";
        String lastname="Khdgfhafn";
        String email="testusegfrkhafgn@test.com";
        String password="1234";
        String phonenumber="01509004400";
        String address="Gulshan, Dhaka";
        userReg.doRegistraion(firstname, lastname,email, password, phonenumber, address);

        Thread.sleep(1000);

        WebDriverWait wait=new WebDriverWait(driver, Duration.ofSeconds(50));
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.className("Toastify__toast"))).getText();
        String successMessageActual= driver.findElement(By.className("Toastify__toast")).getText();
        String successMessageExpected="successfully";
        System.out.println(successMessageActual);
        Assert.assertTrue(successMessageActual.contains(successMessageExpected));

    }
}
