package hudson.plugins.jira;

import io.jenkins.plugins.casc.ConfigurationAsCode;
import java.util.List;
import java.util.Objects;
import org.junit.Assert;
import org.junit.Rule;
import org.junit.Test;
import org.jvnet.hudson.test.JenkinsRule;

public class ConfigAsCodeTest {

    @Rule
    public JenkinsRule r = new JenkinsRule();

    @Test
    public void shouldSupportConfigurationAsCode() throws Exception {
        ConfigurationAsCode.get().configure(
            ConfigAsCodeTest.class.getResource("configuration-as-code.yml").toString());
        List<JiraSite> sites = JiraGlobalConfiguration.get().getSites();
        Assert.assertEquals(2, sites.size());
        Assert.assertEquals("https://issues.jenkins-ci.org/", Objects
            .requireNonNull(sites.get(0).getUrl()).toExternalForm());
        Assert.assertEquals("https://jira.com/", Objects
            .requireNonNull(sites.get(1).getUrl()).toExternalForm());

    }

}
