package Bai5.dao.impl;

import Bai5.dao.BedDAO;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class BedDAOImpl implements BedDAO {

    @Override
    public boolean isBedAvailable(String bedId, Connection conn) {
        try {

            String sql = "SELECT status FROM beds WHERE id = ?";
            PreparedStatement pst = conn.prepareStatement(sql);
            pst.setString(1, bedId);

            ResultSet rs = pst.executeQuery();

            if (rs.next()) {
                return rs.getString("status").equals("Empty");
            }

        } catch (Exception e) {
            e.printStackTrace();
        }

        return false;
    }

    @Override
    public boolean updateBedStatus(String bedId, Connection conn) {

        try {

            String sql = "UPDATE beds SET status='Occupied' WHERE id=?";
            PreparedStatement pst = conn.prepareStatement(sql);

            pst.setString(1, bedId);

            return pst.executeUpdate() > 0;

        } catch (Exception e) {
            e.printStackTrace();
        }

        return false;
    }
}
