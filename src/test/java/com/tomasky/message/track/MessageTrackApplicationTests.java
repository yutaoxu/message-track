package com.tomasky.message.track;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.mongodb.core.MongoOperations;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;

import static org.springframework.data.mongodb.core.query.Criteria.where;


@SpringBootTest
@RunWith(SpringJUnit4ClassRunner.class)
public class MessageTrackApplicationTests {

    private MockMvc mvc;

    @Autowired
    MongoOperations ops;

    @Autowired
    private WebApplicationContext context;

    @Test
    public void contextLoads() {
    }

    @Before
    public void setUp() {
        this.mvc = MockMvcBuilders.webAppContextSetup(this.context).build();
    }

    /**
     * new Query(where("assignee").is("Joe Dev"))
     */
    @Test
    public void canAccessDb() {
        Object assignee = ops.getCollectionNames();
        Assert.assertNotNull("object is not null!",assignee);
    }

}
