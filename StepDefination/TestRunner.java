package StepDefination;

import cucumber.api.CucumberOptions;
import cucumber.api.testng.AbstractTestNGCucumberTests;

@CucumberOptions(features="C:\\Users\\manish.mathur\\EllipsePhoton\\ProjectTwo\\src\\test\\resources\\Features",
//tags="@Login, @Filter",
glue= {"StepDefination"},
plugin= {"pretty","html:target/reportHtmlSecond"}
)

public class Runner extends AbstractTestNGCucumberTests{

}
