package com.safetynet.alerts.service;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNotNull;

import java.util.Arrays;
import java.util.List;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.safetynet.alerts.model.MedicalRecord;

@SpringBootTest
public class MedicalRecordServiceTest {

    @Autowired
    private MedicalRecordService medicalRecordService;
    private static MedicalRecord medicalRecordToAdd = new MedicalRecord();;

    @BeforeAll
    public static void setup() {

	medicalRecordToAdd.setFirstName("Test");
	medicalRecordToAdd.setLastName("Test2");
	medicalRecordToAdd.setBirthDate("01/01/1990");
	medicalRecordToAdd.setMedications(Arrays.asList("aznol:350mg"));
	medicalRecordToAdd.setAllergies(Arrays.asList("nillacilan"));
    }

    @AfterEach
    public void deleteAddedMedicalRecord() {
	medicalRecordService.deleteMedicalRecord(medicalRecordToAdd);
    }

    @Test
    public void shouldRetrieveNonEmptyPersonList() {
	assertNotNull(medicalRecordService.getMedicalRecords());
    }

    @Test
    public void shouldAddSuccessfullyPerson() {
	medicalRecordService.postMedicalRecord(medicalRecordToAdd);

	List<MedicalRecord> listMedicalRecord = medicalRecordService.getMedicalRecords();
	assertEquals(listMedicalRecord.get(listMedicalRecord.size() - 1).getFirstName(),
		medicalRecordToAdd.getFirstName());
    }

    @Test
    public void shouldEditSuccessfullyPerson() {
	MedicalRecord medicalRecordToEdit = new MedicalRecord();
	medicalRecordToEdit.setFirstName("Test");
	medicalRecordToEdit.setLastName("Test2");
	medicalRecordToEdit.setAllergies(Arrays.asList("nillacilan0"));

	medicalRecordService.postMedicalRecord(medicalRecordToAdd);
	medicalRecordService.putMedicalRecord(medicalRecordToEdit);

	List<MedicalRecord> listMedicalRecord = medicalRecordService.getMedicalRecords();
	assertEquals(listMedicalRecord.get(listMedicalRecord.size() - 1).getAllergies(),
		medicalRecordToEdit.getAllergies());
    }

    @Test
    public void shouldDeleteSuccessfullyPerson() {
	medicalRecordService.postMedicalRecord(medicalRecordToAdd);
	medicalRecordService.deleteMedicalRecord(medicalRecordToAdd);

	List<MedicalRecord> listMedicalRecord = medicalRecordService.getMedicalRecords();
	assertFalse(listMedicalRecord.get(listMedicalRecord.size() - 1).getLastName()
		.equals(medicalRecordToAdd.getLastName()));
    }

}
