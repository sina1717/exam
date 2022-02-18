package repository;

import Entity.Account;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class AccountRepository implements BaseRepository<Account> {

    public Account signIn(String username, String passWord){
        String sql = "select * from account where username = ? and password = ? ";
        try {
            PreparedStatement preparedStatement = MyConnection.connection.prepareStatement(sql);
            preparedStatement.setString(1,username);
            preparedStatement.setString(2,passWord);
            ResultSet resultSet = preparedStatement.executeQuery();
            if(resultSet.next()){
                return new Account(resultSet.getInt(1),
                        resultSet.getString(2),
                        resultSet.getString(3));
            }
            else
                throw new RuntimeException();
        } catch (SQLException e) {
            e.printStackTrace();
            throw new RuntimeException();
        }
    }

    @Override
    public void save(Account account) {
        String sql ="insert into account(username, password)  values (?,?)";
        try {
            PreparedStatement preparedStatement = MyConnection.connection.prepareStatement(sql);
            preparedStatement.setString(1,account.getUsername());
            preparedStatement.setString(2,account.getPassword());
            preparedStatement.executeUpdate();
            preparedStatement.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void update(Account account) {
        String sql ="update account set username = ? , password = ? where id = ? ";
        try {
            PreparedStatement preparedStatement = MyConnection.connection.prepareStatement(sql);
            preparedStatement.setString(1,account.getUsername());
            preparedStatement.setString(2,account.getPassword());
            preparedStatement.setInt(3,account.getId());
            preparedStatement.executeUpdate();
            preparedStatement.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void delete(int id) {
        String sql ="update from account  where id = ? ";
        try {
            PreparedStatement preparedStatement = MyConnection.connection.prepareStatement(sql);
            preparedStatement.setInt(1,id);
            preparedStatement.executeUpdate();
            preparedStatement.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public Account findById(int id) {
        String sql = "select * from account where id = ?";
        try {
            PreparedStatement preparedStatement = MyConnection.connection.prepareStatement(sql);
            preparedStatement.setInt(1,id);
            ResultSet resultSet = preparedStatement.executeQuery();
            if(resultSet.next()){
                return new Account(resultSet.getInt(1),
                        resultSet.getString(2),
                        resultSet.getString(3));
            }
            else
                throw new RuntimeException();
        } catch (SQLException e) {
            e.printStackTrace();
            throw new RuntimeException();
        }

    }

    @Override
    public List<Account> findAll() {
        String sql = "select * from account ";
        List<Account> accounts = new ArrayList<>();
        try {
            PreparedStatement preparedStatement = MyConnection.connection.prepareStatement(sql);
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()){
                accounts.add(new Account(resultSet.getInt(1),
                        resultSet.getString(2),
                        resultSet.getString(3)));
            }
        } catch (SQLException e) {
            e.printStackTrace();
            throw new RuntimeException();
        }
        return accounts;
    }
}
