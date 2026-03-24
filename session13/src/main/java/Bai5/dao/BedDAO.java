package Bai5.dao;

import java.sql.Connection;

public interface BedDAO {

    boolean isBedAvailable(String bedId, Connection conn);

    boolean updateBedStatus(String bedId, Connection conn);
}
