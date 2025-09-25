package automacao.steps;

import automacao.pages.CompraPage;
import automacao.pages.LoginPage;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import static org.junit.Assert.assertEquals;

public class CompraSteps {

    private WebDriver driver;
    private LoginPage loginPage;
    private CompraPage compraPage;

    @Given("que estou logado na pagina de inventario")
    public void que_estou_logado_na_pagina_de_inventario() {
        WebDriverManager.chromedriver().setup();

        ChromeOptions options = new ChromeOptions();
        options.addArguments("--disable-features=PasswordManagerRedesign");
        options.addArguments("--disable-save-password-bubble");

        driver = new ChromeDriver(options);
        driver.manage().window().maximize();
        driver.get("https://www.saucedemo.com");
        loginPage = new LoginPage(driver);
        compraPage = new CompraPage(driver);

        loginPage.fillUsername("standard_user");
        loginPage.fillPassword("secret_sauce");
        loginPage.clickLoginButton();
    }

    @When("adiciono o {string} ao carrinho")
    public void adiciono_o_ao_carrinho(String item) {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        String xpath = "//div[contains(@class, 'inventory_item_name') and text()='" + item + "']/ancestor::div[@class='inventory_item_label']/following-sibling::div[@class='pricebar']/button";
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(xpath)));
        driver.findElement(By.xpath(xpath)).click();
    }

    // O CÓDIGO CORRIGIDO
    @And("clico no carrinho")
    public void clico_no_carrinho() {
        compraPage.clickCart();

        // Adiciona uma espera para garantir que a página do carrinho carregou e o botão de checkout está visível.
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(20));
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("checkout")));
    }

    @And("clico no botão de checkout")
    public void clico_no_botão_de_checkout() {
        compraPage.clickCheckout();
        // A espera explícita é adicionada aqui para garantir que a próxima página seja carregada
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("first-name")));
    }

    @And("preencho os dados {string}, {string} e {string}")
    public void preencho_os_dados_e(String firstName, String lastName, String zipCode) {
        compraPage.fillBuyerInfo(firstName, lastName, zipCode);
    }

    @And("clico no botão de continuar")
    public void clico_no_botão_de_continuar() {
        compraPage.clickContinue();
    }

    @And("clico no botão de finalizar a compra")
    public void clico_no_botão_de_finalizar_a_compra() {
        compraPage.clickFinish();
    }

    @Then("devo ver a mensagem de compra finalizada com sucesso")
    public void devo_ver_a_mensagem_de_compra_finalizada_com_sucesso() {
        String expectedMessage = "Thank you for your order!";
        assertEquals(expectedMessage, compraPage.getSuccessMessage());
        driver.quit();
    }

    // NOVOS MÉTODOS PARA O CENÁRIO DE FILTRO

    @When("filtro os produtos por {string}")
    public void filtro_os_produtos_por(String option) {
        compraPage.sortBy(option);
    }

    @Then("os produtos devem estar ordenados por preço do menor para o maior")
    public void os_produtos_devem_estar_ordenados_por_preço_do_menor_para_o_maior() {
        List<WebElement> priceElements = compraPage.getProductPrices();

        List<Double> actualPrices = new ArrayList<>();
        for (WebElement element : priceElements) {
            String priceText = element.getText().replace("$", "");
            actualPrices.add(Double.parseDouble(priceText));
        }

        List<Double> sortedPrices = new ArrayList<>(actualPrices);
        Collections.sort(sortedPrices);

        assertEquals(sortedPrices, actualPrices);

        driver.quit();
    }
}