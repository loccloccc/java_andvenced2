package Bai5.controller;



import Bai5.dao.impl.BedDAOImpl;
import Bai5.dao.impl.PatientDAOImpl;
import Bai5.dao.impl.PaymentDAOImpl;
import Bai5.entity.Patient;
import Bai5.util.DatabaseHelper;

import java.sql.Connection;

public class PatientController {

    public void admitPatient(String name, int age, String bedId, double amount) {

        Connection conn = null;

        try {

            conn = DatabaseHelper.getConnection();

            conn.setAutoCommit(false);

            BedDAOImpl bedDAO = new BedDAOImpl();
            PatientDAOImpl patientDAO = new PatientDAOImpl();
            PaymentDAOImpl paymentDAO = new PaymentDAOImpl();

            if (!bedDAO.isBedAvailable(bedId, conn)) {
                System.out.println("Bed is already occupied!");
                return;
            }

            Patient patient = new Patient(name, age, bedId);

            int patientId = patientDAO.insertPatient(patient, conn);

            if (patientId == -1)
                throw new Exception("Insert patient failed");

            if (!bedDAO.updateBedStatus(bedId, conn))
                throw new Exception("Update bed failed");

            if (!paymentDAO.insertPayment(patientId, amount, conn))
                throw new Exception("Payment failed");

            conn.commit();

            System.out.println("Patient admitted successfully!");

        } catch (Exception e) {

            try {
                conn.rollback();
            } catch (Exception ex) {}

            System.out.println("Transaction failed. Rollback executed.");

        } finally {

            try {
                conn.setAutoCommit(true);
                conn.close();
            } catch (Exception e) {}
        }
    }
}