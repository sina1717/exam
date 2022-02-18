package repository;

import Entity.Comment;

import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.List;

public class CommentRepository implements BaseRepository<Comment> {
    @Override
    public void save(Comment comment) {
        String sql ="insert into comment(account_id, post_id, description) VALUES (?,?,?);";
        try {
            PreparedStatement preparedStatement = MyConnection.connection.prepareStatement(sql);
            preparedStatement.setInt(1,comment.getAccount().getId());
            preparedStatement.setInt(2,comment.getPost().getId());
            preparedStatement.setString(3,comment.getDescription());
            preparedStatement.executeUpdate();
            preparedStatement.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void update(Comment comment) {
        String sql ="update comment set descripton = ? where id = ?";
        try {
            PreparedStatement preparedStatement = MyConnection.connection.prepareStatement(sql);
            preparedStatement.setString(1,comment.getDescription());
            preparedStatement.setInt(2,comment.getId());
            preparedStatement.executeUpdate();
            preparedStatement.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void delete(int id) {
        String sql ="delete from comment where id = ? ";
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
    public Comment findById(int id) {
        return null;
    }

    @Override
    public List<Comment> findAll() {
        return null;
    }
}
