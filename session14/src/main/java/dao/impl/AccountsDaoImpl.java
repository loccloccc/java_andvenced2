package dao.impl;

import commom.DBUlitity;
import dao.AccountsDAO;
import entity.Accounts;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class AccountsDaoImpl implements AccountsDAO {
    @Override
    public Accounts findAccountById(String id) {
        Accounts accounts = null;
        try{
            Connection conn = null;
            String sql = "select * from Accounts where id = ?";
            PreparedStatement pst = conn.prepareCall(sql);
            pst.setString(1, id);
            ResultSet rs = pst.executeQuery();
            if(rs.next()){
                accounts =  new Accounts(
                        rs.getString("AccountId"),
                        rs.getString("FullName"),
                        rs.getDouble("Balance")
                );

            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return accounts;
    }

    @Override
    public List<Accounts> getAllAccounts(String id1, String id2) {
        List<Accounts> list = new ArrayList<>();
        try{
            Connection conn = null;
            String sql = "select * from Accounts where AccountId = ? or AccountId = ?";
            PreparedStatement pst = conn.prepareCall(sql);

            pst.setString(1, id1);
            pst.setString(2, id2);
            ResultSet rs = pst.executeQuery();
            while(rs.next()){
                Accounts accounts = new Accounts(
                        rs.getString("AccountId"),
                        rs.getString("FullName"),
                        rs.getDouble("Balance")
                );
                list.add(accounts);
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return list;
    }

    @Override
    public void updateBalance(String id, double balance) {
        try{
            Connection conn = DBUlitity.getConnection();
            CallableStatement cst = conn.prepareCall("{call sp_UpdateBalance(?,?)}");
            cst.setString(1, id);
            cst.setDouble(2, balance);
            cst.execute();


        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
}
