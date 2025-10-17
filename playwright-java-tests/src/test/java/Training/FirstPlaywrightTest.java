package Training;

import com.microsoft.playwright.Browser;
import com.microsoft.playwright.BrowserType;
import com.microsoft.playwright.Page;
import com.microsoft.playwright.Playwright;

public class FirstPlaywrightTest {
    public static void main(String[] args) {

        Playwright playwright = Playwright.create();

        BrowserType browserType = playwright.chromium();

        Browser browser = browserType.launch(new BrowserType.LaunchOptions().setHeadless(false));

        Page page = browser.newPage();

        page.navigate("https://playwright.dev/java/docs/intro");
        String title = page.title();
        System.out.println("The Title Is " + title);

        page.close();
        browser.close();
        playwright.close();
    }
}
