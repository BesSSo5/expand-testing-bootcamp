package Training;

import com.microsoft.playwright.*;
import com.microsoft.playwright.assertions.PlaywrightAssertions;

public class WebInputsTest {
    public static void main(String[] args) {

        try (Playwright playwright = Playwright.create();
             Browser browser = playwright.chromium().launch(new BrowserType.LaunchOptions().setHeadless(false));
             Page page = browser.newPage())
        {
            /// Navigate to page
            page.navigate("https://practice.expandtesting.com/inputs");

            /// Assert Webpage Header
            PlaywrightAssertions.assertThat(page).hasTitle("Web inputs page for Automation Testing Practice");

            /// Declare Locators and Assert
            Locator displayButton = page.locator("#btn-display-inputs");
            Locator clearInputsButton = page.locator("#btn-clear-inputs");
            Locator inputNumberField = page.locator("#input-number");
            Locator inputTextField = page.locator("#input-text");
            Locator inputPasswordField = page.locator("#input-password");
            Locator inputDateField = page.locator("#input-date");

            /// Assert Display and Clear Buttons are Visible and Clickable
            PlaywrightAssertions.assertThat(displayButton).isVisible();
            PlaywrightAssertions.assertThat(displayButton).isEnabled();
            PlaywrightAssertions.assertThat(clearInputsButton).isVisible();
            PlaywrightAssertions.assertThat(clearInputsButton).isEnabled();

            /// Fill Input Fields
            inputNumberField.fill("1234567890");
            inputTextField.fill("This is a test");
            inputPasswordField.fill("pass123");
            inputDateField.fill("2026-01-05"); //Always use YYYY-MM-DD format for date input

            /// Assert and Click Display Button
            PlaywrightAssertions.assertThat(displayButton).isEnabled();
            displayButton.click();

            ///  Write Locators and Assert Results and Output Fields are Displayed
            Locator outputFieldsDisplay = page.locator("#result");
            Locator outputFieldNumber = page.locator("#output-number");
            Locator outputFieldText = page.locator("#output-text");
            Locator outputFieldPassword = page.locator("#output-password");
            Locator outputFieldDate = page.locator("#output-date");

            PlaywrightAssertions.assertThat(outputFieldsDisplay).isVisible();
            PlaywrightAssertions.assertThat(outputFieldNumber).isVisible();
            PlaywrightAssertions.assertThat(outputFieldNumber).hasText("1234567890");
            PlaywrightAssertions.assertThat(outputFieldText).isVisible();
            PlaywrightAssertions.assertThat(outputFieldText).hasText("This is a test");
            PlaywrightAssertions.assertThat(outputFieldPassword).isVisible();
            PlaywrightAssertions.assertThat(outputFieldPassword).hasText("pass123");
            PlaywrightAssertions.assertThat(outputFieldDate).isVisible();
            PlaywrightAssertions.assertThat(outputFieldDate).hasText("2025-01-05");

            /// Clear Inputs and Assert
            PlaywrightAssertions.assertThat(clearInputsButton).isEnabled();
            clearInputsButton.click();
            PlaywrightAssertions.assertThat(outputFieldNumber).not().isVisible();
            PlaywrightAssertions.assertThat(outputFieldText).not().isVisible();
            PlaywrightAssertions.assertThat(outputFieldPassword).not().isVisible();
            PlaywrightAssertions.assertThat(outputFieldDate).not().isVisible();

            PlaywrightAssertions.assertThat(inputNumberField).hasText("");
            PlaywrightAssertions.assertThat(inputTextField).hasText("");
            PlaywrightAssertions.assertThat(inputPasswordField).hasText("");
            PlaywrightAssertions.assertThat(inputDateField).hasText("");


        }

    }
}
