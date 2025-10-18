package Training;

import com.microsoft.playwright.Browser;
import com.microsoft.playwright.BrowserType;
import com.microsoft.playwright.Page;
import com.microsoft.playwright.Playwright;
import com.microsoft.playwright.assertions.PlaywrightAssertions;

public class LoginLogoutTest {
    public static void main(String[] args) {

        try (Playwright playwright = Playwright.create();
             Browser browser = playwright.chromium().launch(new BrowserType.LaunchOptions().setHeadless(false));
             Page page = browser.newPage())
        {
            page.navigate("https://www.saucedemo.com/v1/index.html");

            String title = page.title();
            PlaywrightAssertions.assertThat(page).hasTitle("Swag Labs");
            System.out.println("The Title Is " + title);

            page.locator("#user-name").fill("standard_user");
            page.locator("#password").fill("secret_sauce");
            page.locator("#login-button").click();

            PlaywrightAssertions.assertThat(page.locator("xpath=//*[@class='product_label']")).containsText("Products");
            page.locator("xpath=//*[@class='bm-burger-button']").click();
            page.locator("#logout_sidebar_link").click();
            PlaywrightAssertions.assertThat(page).hasTitle("Swag Labs");
        }
    }
}