package dao;

import connection.MyConnection;
import model.Account;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;

public class AccountDAO {
    public Account getById(long id){
        Account account = null;
        try{
            //1:
            Connection conn = MyConnection.getConnection();
            //2:
            String sql = String.format("SELECT * FROM `accounts` WHERE ` id` = "+ id +" LIMIT 1");
            Statement stmt = conn.createStatement();
            //3:
            ResultSet resultSet = stmt.executeQuery(sql);

            if (resultSet.next()){
                account = new Account();
                account.setId(resultSet.getLong("id"));
                account.setUsername(resultSet.getString("username"));
            }
            //4:
            resultSet.close();
            stmt.close();
            conn.close();
        }catch (Exception e){
            e.printStackTrace();
        }
        return account;
    }
    public Account getByUserNameAndPassword(String username, String password) {
        Account account = null;
        try {
            Connection conn = MyConnection.getConnection();
            String sql = String.format("SELECT id, username FROM accounts WHERE username='%s' AND password='%s' LIMIT 1 ",
                    username, password);

            // THUC THI
            Statement stmt = conn.createStatement();
            ResultSet resultSet = stmt.executeQuery(sql);
            if (resultSet.next()) {
                account = new Account();
                account.setId(resultSet.getLong("id"));
                account.setUsername(resultSet.getString("username"));
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

        return account;
    }
}
