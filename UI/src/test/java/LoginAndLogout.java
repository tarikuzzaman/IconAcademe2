import org.testng.annotations.Test;

public class LoginAndLogout extends Commons {
    public void verifyURL(String url) {
        String currentURL = driver.getCurrentUrl();
        try {
            url.equals(currentURL);
        }
        catch (Exception e){
            System.out.println("Expected Url:" + url + "but current url is: " + currentURL);
        }


    }
    public String viewCurrentURL(){
        String currentUrL = driver.getCurrentUrl();
        System.out.println(currentUrL);
        return currentUrL;

    }
    @Test
    public void startWebDriver() throws InterruptedException {
        verifyTitle("IconACADEME - Online Education Revolution in Bangladesh");

        //Click Login button
        clickByCss("a.login");
        verifyURL(ObjectRepo.loginURL);

        //UserID input
        typeByCss("input#user_login", "test");

        //UserPassword input
        typeByCss("input#user_pass", "test1234");

        //Click Submit button
        clickByCss("#wp-submit");
        sleepFor(5);

        //Log out from main menu
        clickByXpath("//*[@id=\"menu-item-4546\"]/a");
        sleepFor(5);

        viewCurrentURL();
        verifyURL(ObjectRepo.loginURL);

        //go to home page
        clickByCss("#logo > h2 > a > img.boss-logo.large");
        sleepFor(2);

        viewCurrentURL();
        verifyURL(ObjectRepo.homeURL);

        closeBrowser();

    }
}
