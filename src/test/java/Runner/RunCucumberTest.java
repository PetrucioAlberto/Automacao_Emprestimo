package Runner;

import cucumber.api.CucumberOptions;
import cucumber.api.SnippetType;
import cucumber.api.junit.Cucumber;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(
        features = "src/test/java/Resources/Features/Emprestimo.feature",
        glue = {"Steps"},
        tags = {"@CT001_001,@CT002_001,@CT003_001,@CT004_001,@CT005_001,@CT006_001,@CT007_001"},
        plugin = "pretty",
        monochrome = true,
        snippets = SnippetType.CAMELCASE,
        dryRun = false,
        strict = false
)
public class RunCucumberTest  {

}
