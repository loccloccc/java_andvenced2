package Bai5.dao;

import java.sql.Connection;

public interface PaymentDAO {

    boolean insertPayment(int patientId, double amount, Connection conn);
}