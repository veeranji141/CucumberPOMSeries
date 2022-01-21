package com.testrunners;

import org.junit.runner.RunWith;
import org.testng.annotations.DataProvider;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import io.cucumber.testng.AbstractTestNGCucumberTests;

@RunWith(Cucumber.class)
@CucumberOptions(features="src/test/resources/com/features/AccountsPage.feature",
				
				glue={"com.stepDefinitions", "com.applicationHooks"},
				dryRun=false,
				monochrome=true,
						plugin={"pretty", "json: target/myReports/report.json",
                        		"rerun: target/failedCases.txt"}
	
		)

/*public class MyTestRunner extends AbstractTestNGCucumberTests {

	@Override
	@DataProvider(parallel=true)
	public Object[][] scenarios() {
		
		return super.scenarios();
	}
	
}*/
	
public class MyTestRunner {
}
