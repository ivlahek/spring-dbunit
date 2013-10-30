package hr.ivlahek.learning.spring.dbunit.repository;

import com.github.springtestdbunit.annotation.DatabaseSetup;
import com.github.springtestdbunit.annotation.DatabaseTearDown;
import com.github.springtestdbunit.annotation.ExpectedDatabase;

import hr.ivlahek.learning.dbunit.persistance.PersistenceConfig;
import hr.ivlahek.learning.dbunit.persistance.model.Test;
import hr.ivlahek.learning.dbunit.persistance.repository.TestRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.converter.json.MappingJacksonHttpMessageConverter;
import org.springframework.test.annotation.DirtiesContext;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.TestExecutionListeners;

import com.github.springtestdbunit.DbUnitTestExecutionListener;
import org.springframework.test.context.junit4.AbstractJUnit4SpringContextTests;
import org.springframework.web.client.RestTemplate;

import javax.sql.DataSource;
import java.util.List;

/**
 * @author ivlahek
 */
@ContextConfiguration(classes={PersistenceConfig.class})
@TestExecutionListeners(DbUnitTestExecutionListener.class)
@DirtiesContext
@DatabaseTearDown(value = "sampleData1.xml")
public class TestRepositoryTest extends AbstractJUnit4SpringContextTests {

    @Autowired
    private TestRepository testRepository;

    @Autowired
    protected DataSource dataSource;

    private RestTemplate restTemplate;

    private static final String URL = "http://localhost:8080/";


    @org.junit.Test
    @DatabaseSetup("sampleData.xml")
    @ExpectedDatabase("expected.xml")
    public void testSomething() {
        testRepository.save(new Test("name", "surname"));

        restTemplate = new RestTemplate();
        restTemplate.getMessageConverters().add(new MappingJacksonHttpMessageConverter());

        List iterable = restTemplate.getForObject(URL, List.class);
        iterable.size();
    }

}
