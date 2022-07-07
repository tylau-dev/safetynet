package com.safetynet.alerts.controller;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.delete;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.put;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;

import com.safetynet.alerts.service.PersonService;

@WebMvcTest(controllers = PersonController.class)
public class PersonControllerTest {
    final String contentBody = "{\"firstName\": \"John\", \"lastName\": \"Doe\", \"address\": \"11 Street\", \"city\": \"TestCity\", \"zip\": \"12345\", \"phone\": \"010101\", \"email\": \"john@doe.com\"}";

    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private PersonService personService;

    // @BeforeEach

    @Test
    public void testGetPerson() throws Exception {
	mockMvc.perform(get("/person")).andExpect(status().isOk());
    }

    @Test
    public void testPostPerson() throws Exception {
	mockMvc.perform(post("/person").contentType(MediaType.APPLICATION_JSON).content(contentBody))
		.andExpect(status().isCreated());
    }

    @Test
    public void testPutPerson() throws Exception {
	mockMvc.perform(put("/person").contentType(MediaType.APPLICATION_JSON).content(contentBody))
		.andExpect(status().isOk());
    }

    @Test
    public void testDeletePerson() throws Exception {
	mockMvc.perform(delete("/person").contentType(MediaType.APPLICATION_JSON).content(contentBody))
		.andExpect(status().isOk());
    }
}
