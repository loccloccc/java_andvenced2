package dao;

import entity.Accounts;

import java.util.List;

public interface AccountsDAO {
   Accounts findAccountById(String id);
   List<Accounts> getAllAccounts(String id1 , String id2);
   void updateBalance(String id , double balance);
}
