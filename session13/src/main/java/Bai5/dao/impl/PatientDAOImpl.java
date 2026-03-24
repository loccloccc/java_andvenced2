package Bai5.dao.impl;




import Bai5.dao.PatientDAO;
import Bai5.entity.Patient;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.Statement;
import java.sql.ResultSet;

public class PatientDAOImpl implements PatientDAO {

    @Override
    public int insertPatient(Patient patient, Connection conn) {

        try {

            String sql = "INSERT INTO patients(name,age,bed_id) VALUES(?,?,?)";

            PreparedStatement pst =
                    conn.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);

            pst.setString(1, patient.getName());
            pst.setInt(2, patient.getAge());
            pst.setString(3, patient.getBedId());

            pst.executeUpdate();

            ResultSet rs = pst.getGeneratedKeys();

            if (rs.next()) {
                return rs.getInt(1);
            }

        } catch (Exception e) {
            e.printStackTrace();
        }

        return -1;
    }
}
