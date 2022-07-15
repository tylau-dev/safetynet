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

import com.safetynet.alerts.service.MedicalRecordService;

@WebMvcTest(controllers = MedicalRecordController.class)
public class MedicalRecordControllerTest {
    final String contentBody = "{\"firstName\": \"John\", \"lastName\": \"Doe\", \"birthdate\": \"01/01/1990\", \"medications\": [\"aznol:350mg\"], \"allergies\": [\"nillacilan\"]}";

    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private MedicalRecordService medicalRecordService;

    @Test
    public void testGetMedicalRecord() throws Exception {
	mockMvc.perform(get("/medicalRecord")).andExpect(status().isOk());
    }

    @Test
    public void testPostMedicalRecord() throws Exception {
	mockMvc.perform(post("/medicalRecord").contentType(MediaType.APPLICATION_JSON).content(contentBody))
		.andExpect(status().isCreated());
    }

    @Test
    public void testPutMedicalRecord() throws Exception {
	mockMvc.perform(put("/medicalRecord").contentType(MediaType.APPLICATION_JSON).content(contentBody))
		.andExpect(status().isOk());
    }

    @Test
    public void testDeleteMedicalRecord() throws Exception {
	mockMvc.perform(delete("/medicalRecord").contentType(MediaType.APPLICATION_JSON).content(contentBody))
		.andExpect(status().isOk());
    }

}
