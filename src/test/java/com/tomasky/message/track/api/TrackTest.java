package com.tomasky.message.track.api;

import com.tomasky.message.track.MessageTrackApplication;
import com.tomasky.message.track.Track;
import org.bson.types.ObjectId;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.SpringApplicationConfiguration;
import org.springframework.http.HttpStatus;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.request.MockHttpServletRequestBuilder;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertThat;
import static org.junit.Assert.assertTrue;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.delete;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;

/**
 * @author: yutaoxun_1130
 * @company: fanqielaile
 * @date: 2016/9/14
 * @description:
 */
@RunWith(SpringJUnit4ClassRunner.class)
@SpringApplicationConfiguration(classes = {MessageTrackApplication.class})
@WebAppConfiguration
@ActiveProfiles("pro")
public class TrackTest {
    public static final String TRACK_API = "/api/v1/message/track";

    @Autowired
    Track track;

    private MockMvc mvc;

    @Autowired
    private WebApplicationContext context;

    @Before
    public void setUp() {
        this.mvc = MockMvcBuilders.webAppContextSetup(this.context).build();
    }

    @Test
    public void testTrack() throws Exception {
        System.out.println("test track api");
        MockHttpServletRequestBuilder builder = get(TRACK_API);
        MvcResult result = mvc.perform(builder).andReturn();
        assertEquals(HttpStatus.OK.value(), result.getResponse().getStatus());
        String location = result.getResponse().getHeader("Location");
        assertNotNull(location);
        String id = location.substring(location.lastIndexOf('/') + 1);
        assertTrue(ObjectId.isValid(id));
        // clean up
        mvc.perform(delete(String.format("%s/%s", TRACK_API, "{id}"), id));
    }

}
