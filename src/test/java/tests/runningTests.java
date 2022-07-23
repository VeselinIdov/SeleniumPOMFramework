package tests;

import configurations.BaseTest;
import org.testng.annotations.Test;
import pages.ElementsPage;

public class runningTests extends BaseTest {

    @Test
    void testDropdown()throws Exception  {
        ElementsPage elementsPage = new ElementsPage();
        elementsPage.selectProductByName();
    }

    @Test
    void testDropdown1()throws Exception  {
        System.out.println("Test 2");
    }

    @Test
    void testDropdown2()throws Exception  {
        System.out.println("Test 3");
    }
}