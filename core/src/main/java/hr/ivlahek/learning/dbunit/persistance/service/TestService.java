package hr.ivlahek.learning.dbunit.persistance.service;

import com.google.common.collect.Lists;
import hr.ivlahek.learning.dbunit.persistance.model.Test;
import hr.ivlahek.learning.dbunit.persistance.repository.TestRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * @author ivlahek
 */
@RestController
public class TestService {

    @Autowired
    private TestRepository testRepository;

    @RequestMapping(value = "/", method = RequestMethod.GET, produces = "application/json" )
    public
    @ResponseBody
    List<Test> index() {
        return Lists.newArrayList(testRepository.findAll());
    }

    @RequestMapping(value = "/ss", method = RequestMethod.GET, consumes = "application/json", produces = "application/json")
    public
    @ResponseBody
    String string() {
        return "nana";
    }
}
