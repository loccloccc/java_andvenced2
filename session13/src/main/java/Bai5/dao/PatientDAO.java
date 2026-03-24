package Bai5.dao;

import Bai5.entity.Patient;

import java.sql.Connection;

public interface PatientDAO {

    int insertPatient(Patient patient, Connection conn);
}
