package service;

import commom.DBUlitity;
import dao.AccountsDAO;
import dao.impl.AccountsDaoImpl;
import entity.Accounts;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class TransferServic {
    AccountsDAO accountsDAO = new AccountsDaoImpl();
    public void transfer(String idFrom, String idTo, double balance) {
        Connection conn = null;
        try {
            conn = DBUlitity.getConnection();
            conn.setAutoCommit(false);
            Accounts check = accountsDAO.findAccountById(idFrom);
            if (check == null) {
                System.out.println("ID khong ton tai");
            }
            if (check.getBalance() < balance) {
                System.out.println("So du khong du");
            }
            accountsDAO.updateBalance(idFrom, balance);
            accountsDAO.updateBalance(idTo, balance);
            conn.commit();
            List<Accounts> list = accountsDAO.getAllAccounts(idFrom, idTo);
            for (Accounts a : list) {
                System.out.println(a);
            }
        } catch (SQLException e) {
            try{
                if (conn != null){
                    conn.rollback();
                }
            } catch (SQLException ex) {
                throw new RuntimeException(ex);
            }
        }

    }
}
