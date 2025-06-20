package com.cn.dao;
import com.cn.model.User;
import java.sql.*;
public class UserDAO {
	 // 注册用户
    public boolean register(User user) {
        String sql = "INSERT INTO user (user_name, user_pwd) VALUES (?, ?)";
        try (Connection conn = ConnectionPool.getConnection(); // 从连接池获取连接
             PreparedStatement ps = conn.prepareStatement(sql)) {

            // 设置参数
            ps.setString(1, user.getUserName());
            ps.setString(2, user.getUserPwd());

            // 执行插入操作
            int rowsAffected = ps.executeUpdate();
            return rowsAffected > 0;

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return false;
    }

    // 用户登录
    public User login(User user) {
        String sql = "SELECT * FROM user WHERE user_name = ? AND user_pwd = ?";
        try (Connection conn = ConnectionPool.getConnection(); // 从连接池获取连接
             PreparedStatement ps = conn.prepareStatement(sql)) {

            // 设置查询参数
            ps.setString(1, user.getUserName());
            ps.setString(2, user.getUserPwd());

            // 执行查询
            ResultSet rs = ps.executeQuery();
            if (rs.next()) {
                // 成功找到用户，返回用户对象
                user.setUserId(rs.getInt("user_id"));  // 假设有 user_id 字段
                user.setUserName(rs.getString("user_name"));
                user.setUserPwd(rs.getString("user_pwd"));
                return user;
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }
}
