package com.safetynet.alerts.service;

import java.util.List;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.safetynet.alerts.model.MedicalRecord;
import com.safetynet.alerts.repository.IDTOjson;

@Service
public class MedicalRecordService implements IMedicalRecordService {
    @Autowired
    private IDTOjson DTOjson;
    private static final Logger logger = LogManager.getLogger("MedicalRecordService");

    @Override
    public List<MedicalRecord> getMedicalRecords() {
	return DTOjson.getJsonData().getMedicalRecords();
    }

    @Override
    public void postMedicalRecord(MedicalRecord medicalRecordToAdd) {
	List<MedicalRecord> medicalRecords = getMedicalRecords();
	medicalRecords.add(medicalRecordToAdd);
	DTOjson.getJsonData().setMedicalRecords(medicalRecords);
    }

    @Override
    public void putMedicalRecord(MedicalRecord medicalRecordToUpdate) {
	List<MedicalRecord> medicalRecords = getMedicalRecords();

	for (MedicalRecord medicalRecord : medicalRecords) {
	    if (medicalRecord.getFirstName() == medicalRecordToUpdate.getFirstName()
		    && medicalRecord.getLastName() == medicalRecordToUpdate.getLastName()) {
		medicalRecord.setBirthDate(medicalRecordToUpdate.getBirthDate());
		medicalRecord.setMedications(medicalRecordToUpdate.getMedications());
		medicalRecord.setAllergies(medicalRecordToUpdate.getAllergies());
	    }
	}
    }

    @Override
    public void deleteMedicalRecord(MedicalRecord medicalRecordToDelete) {
	List<MedicalRecord> medicalRecords = getMedicalRecords();

	for (int i = 0; i < medicalRecords.size(); i++) {
	    if (medicalRecords.get(i).getFirstName().equals(medicalRecordToDelete.getFirstName())
		    && medicalRecords.get(i).getLastName().equals(medicalRecordToDelete.getLastName())) {
		medicalRecords.remove(i);
	    }
	}
    }

}
