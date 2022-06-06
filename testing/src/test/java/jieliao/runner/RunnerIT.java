package jieliao.runner;

import org.junit.runner.RunWith;
import io.cucumber.junit.CucumberOptions;
import net.serenitybdd.cucumber.CucumberWithSerenity;
import net.thucydides.junit.annotations.Concurrent;

@Concurrent
@RunWith(CucumberWithSerenity.class)
@CucumberOptions(features="src/test/resources/features/crowdstreet",
				 glue="jieliao.step"
				)
public class RunnerIT {}
