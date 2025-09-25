package automacao.steps;

import automacao.pages.LoginPage;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import static org.junit.Assert.assertTrue;

public class LoginSteps {

    private WebDriver driver;
    private LoginPage loginPage;

    @Given("que estou na página de login")
    public void queEstouNaPaginaDeLogin() {
        WebDriverManager.chromedriver().setup();

        ChromeOptions options = new ChromeOptions();

        // Opções anti-senha:
        options.addArguments("--disable-features=PasswordManagerRedesign");
        options.addArguments("--disable-save-password-bubble");

        // 💥 OPÇÕES CRUCIAIS PARA ESTABILIDADE NO JENKINS 💥
        options.addArguments("--no-sandbox");
        options.addArguments("--disable-dev-shm-usage");
        options.addArguments("--disable-notifications");
        options.addArguments("--disable-extensions");
        options.addArguments("--disable-infobars");

        driver = new ChromeDriver(options);
        driver.manage().window().maximize();
        driver.get("https://www.saucedemo.com");
        loginPage = new LoginPage(driver);
    }

    @When("preencho o campo de usuario com {string}")
    public void preenchoOCampoDeUsuarioCom(String usuario) {
        loginPage.fillUsername(usuario);
    }

    @And("preencho o campo de senha com {string}")
    public void preenchoOCampoDeSenhaCom(String senha) {
        loginPage.fillPassword(senha);
    }

    @And("clico no botão de login")
    public void clicoNoBotaoDeLogin() {
        loginPage.clickLoginButton();
    }

    @Then("devo ser redirecionado para a página de inventário")
    public void devoSerRedirecionadoParaAPaginaDeInventario() {
        assertTrue(driver.getCurrentUrl().contains("inventory.html"));
        driver.quit();
    }
}