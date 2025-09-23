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

        // Código para desabilitar o pop-up do Chrome
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--disable-features=PasswordManagerRedesign");
        options.addArguments("--disable-save-password-bubble");

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