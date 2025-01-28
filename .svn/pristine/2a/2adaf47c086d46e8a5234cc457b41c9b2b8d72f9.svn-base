package cucumber_test;

import static org.junit.Assert.assertEquals;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import maven_test.Main;

class IsItNumeric {
    @SuppressWarnings("deprecation")
	static boolean isNumeric(String inStr) {
    	Main mApp = new Main();
    	mApp.hide();
        return mApp.isNumeric(inStr);
    }
}

public class CucumberStepMainTest {
    private String string;
    private String actualAnswer;

    @Given("string is Av")
    public void string_is_av() {
        string = "Av";
    }

    @When("I ask whether it's Numeric")
    public void i_ask_whether_it_s_numeric() {
        actualAnswer = (IsItNumeric.isNumeric(string)) ? "Yeah":"Nope";
    }
    @Then("I should be told {string}")
    public void i_should_be_told(String expectedAnswer) {
        assertEquals(expectedAnswer, actualAnswer);
    }
    
}
