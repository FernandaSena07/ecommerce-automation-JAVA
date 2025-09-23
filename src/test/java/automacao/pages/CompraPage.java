package automacao.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import java.util.List;

public class CompraPage {
    private WebDriver driver;

    // Construtor
    public CompraPage(WebDriver driver) {
        this.driver = driver;
    }

    // Localizadores dos Elementos
    private By cartButton = By.xpath("//div[@id='shopping_cart_container']");
    private By checkoutButton = By.id("checkout");
    private By firstNameField = By.id("first-name");
    private By lastNameField = By.id("last-name");
    private By zipCodeField = By.id("postal-code");
    private By continueButton = By.id("continue");
    private By finishButton = By.id("finish");
    private By successMessage = By.xpath("//h2[contains(text(),'Thank you for your order!')]");

    // NOVO: Localizadores para a funcionalidade de ordenação
    private By sortDropdown = By.className("product_sort_container");
    private By productPrices = By.className("inventory_item_price");

    // Métodos para interagir com a página
    public void clickCart() {
        driver.findElement(cartButton).click();
    }

    public void clickCheckout() {
        driver.findElement(checkoutButton).click();
    }

    public void fillBuyerInfo(String firstName, String lastName, String zipCode) {
        driver.findElement(firstNameField).sendKeys(firstName);
        driver.findElement(lastNameField).sendKeys(lastName);
        driver.findElement(zipCodeField).sendKeys(zipCode);
    }

    public void clickContinue() {
        driver.findElement(continueButton).click();
    }

    public void clickFinish() {
        driver.findElement(finishButton).click();
    }

    public String getSuccessMessage() {
        return driver.findElement(successMessage).getText();
    }

    // NOVO: Método para ordenar os produtos
    public void sortBy(String option) {
        Select dropdown = new Select(driver.findElement(sortDropdown));
        dropdown.selectByVisibleText(option);
    }

    // NOVO: Método para obter a lista de preços dos produtos
    public List<WebElement> getProductPrices() {
        return driver.findElements(productPrices);
    }
}