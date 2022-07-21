package com.safetynet.alerts.service;

import java.util.List;

import com.safetynet.alerts.model.MedicalRecord;

public interface IMedicalRecordService {
    List<MedicalRecord> getMedicalRecords();

    void postMedicalRecord(MedicalRecord medicalRecordToAdd);

    void putMedicalRecord(MedicalRecord medicalRecordToUpdate);

    void deleteMedicalRecord(MedicalRecord medicalRecordToDelete);

}
