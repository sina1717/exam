package repository;

import Entity.Account;
import Entity.Post;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class PostRepository implements BaseRepository<Post> {
    @Override
    public void save(Post post) {
        String sql ="insert into posts (account_id, description) values (?,?)";
        try {
            PreparedStatement preparedStatement = MyConnection.connection.prepareStatement(sql);
            preparedStatement.setInt(1,post.getAccount().getId());
            preparedStatement.setString(2,post.getDescription());
            preparedStatement.executeUpdate();
            preparedStatement.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void update(Post post) {
        String sql ="update posts set description =? where id = ?;";
        try {
            PreparedStatement preparedStatement = MyConnection.connection.prepareStatement(sql);
            preparedStatement.setString(1,post.getDescription());
            preparedStatement.setInt(2,post.getId());
            preparedStatement.executeUpdate();
            preparedStatement.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void delete(int id) {
        String sql ="delete from posts where id = ?;";
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
    public Post findById(int id) {
        String sql = "select * from posts inner join account a on a.id = posts.account_id where posts.id =?";
        try {
            PreparedStatement preparedStatement = MyConnection.connection.prepareStatement(sql);
            preparedStatement.setInt(1,id);
            ResultSet resultSet = preparedStatement.executeQuery();
            if(resultSet.next()){
                return new Post(
                        resultSet.getInt("posts.id"),
                        new Account(resultSet.getInt("a.id"),
                                resultSet.getString("username"),
                                resultSet.getString("password")),
                        resultSet.getString("description"));
            }
            else {
                throw new RuntimeException();
            }
        } catch (SQLException e) {
            throw new RuntimeException();
        }
    }

    @Override
    public List<Post> findAll() {
        String sql = "select * from posts inner join account a on a.id = posts.account_id  ";
        List<Post> postList = new ArrayList<>();
        try {
            PreparedStatement preparedStatement = MyConnection.connection.prepareStatement(sql);
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()){
                postList.add(new Post(
                        resultSet.getInt(1),
                        new Account(resultSet.getInt("a.id"),
                                resultSet.getString("username"),
                                resultSet.getString("password")),
                        resultSet.getString("description")));
            }

        } catch (SQLException e) {
            throw new RuntimeException();
        }
        return postList;
    }
}
