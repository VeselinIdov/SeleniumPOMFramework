package tests;

import org.testng.annotations.Test;
import pages.HomePage;

public class runningTests2 extends BaseTest {

    @Test
    void testDropdown() {
        HomePage homePage = new HomePage();
        homePage.clickOnElement();
        System.out.println( Thread.currentThread().getId());

    }

    @Test
    void testDropdown1()  {
        HomePage homePage = new HomePage();
        homePage.clickOnElement();
        System.out.println( Thread.currentThread().getId());
    }

    @Test
    void testDropdown2() {
        HomePage homePage = new HomePage();
        homePage.clickOnElement();    }

    @Test
    void testDropdown3(){
        HomePage homePage = new HomePage();
        homePage.clickOnElement();    }
}