package automacao.runner;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(
        features = "src/test/resources/features",
        glue = "automacao.steps", // <-- CORRIGIDO AQUI!
        plugin = {"pretty", "html:target/cucumber-reports.html"},
        monochrome = true
)
public class RunnerTest {
}