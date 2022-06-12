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
    void secondTest2() throws Exception {

        ElementsPage elementsPage = new ElementsPage();
        elementsPage.selectProductByName();
    }
}
