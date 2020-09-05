package Runner;


import cucumber.api.CucumberOptions;
import cucumber.api.junit.Cucumber;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)                      //testin cucumber testi olarak yürütülmesi gerektiğini anlatan kod parçasıdır.
@CucumberOptions(                             //test çalıştığında hangi package alanlarını okuyacağını tariflediğimiz alandır.
features = "src/test/java/Features",
        glue = {"StepDefination"}
)
public class TestRunner {
}
