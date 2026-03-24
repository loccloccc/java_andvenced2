package Bai5.dao.impl;

import Bai5.dao.PaymentDAO;
import java.sql.Connection;
import java.sql.PreparedStatement;

public class PaymentDAOImpl implements PaymentDAO {

    @Override
    public boolean insertPayment(int patientId, double amount, Connection conn) {

        try {

            String sql = "INSERT INTO payments(patient_id,amount,created_at) VALUES(?,?,NOW())";

            PreparedStatement pst = conn.prepareStatement(sql);

            pst.setInt(1, patientId);
            pst.setDouble(2, amount);

            return pst.executeUpdate() > 0;

        } catch (Exception e) {
            e.printStackTrace();
        }

        return false;
    }
}