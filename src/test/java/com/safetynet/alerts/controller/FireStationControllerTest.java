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

import com.safetynet.alerts.service.FireStationService;

@WebMvcTest(controllers = FireStationController.class)
public class FireStationControllerTest {
    final String contentBodyFireStation = "{\"address\": \"12 Street\", \"station\": \"2\"}";
    final String contentBodyFireStationNull = "{\"station\": \"2\"}";

    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private FireStationService fireStationService;

    @Test
    public void testGetFireStation() throws Exception {
	mockMvc.perform(get("/firestation")).andExpect(status().isOk());
    }

    @Test
    public void testPostFireStation() throws Exception {
	mockMvc.perform(post("/firestation").contentType(MediaType.APPLICATION_JSON).content(contentBodyFireStation))
		.andExpect(status().isCreated());
    }

    @Test
    public void testPutFireStation() throws Exception {
	mockMvc.perform(put("/firestation").contentType(MediaType.APPLICATION_JSON).content(contentBodyFireStation))
		.andExpect(status().isOk());
    }

    @Test
    public void testDeleteFireStation() throws Exception {
	mockMvc.perform(delete("/firestation").contentType(MediaType.APPLICATION_JSON).content(contentBodyFireStation))
		.andExpect(status().isOk());
    }

    @Test
    public void testPostWrongFireStation() throws Exception {
	mockMvc.perform(
		post("/firestation").contentType(MediaType.APPLICATION_JSON).content(contentBodyFireStationNull))
		.andExpect(status().isBadRequest());
    }

    @Test
    public void testPutWrongFireStation() throws Exception {
	mockMvc.perform(put("/firestation").contentType(MediaType.APPLICATION_JSON).content(contentBodyFireStationNull))
		.andExpect(status().isBadRequest());
    }

    @Test
    public void testDeleteWrongFireStation() throws Exception {
	mockMvc.perform(
		delete("/firestation").contentType(MediaType.APPLICATION_JSON).content(contentBodyFireStationNull))
		.andExpect(status().isBadRequest());
    }

}
