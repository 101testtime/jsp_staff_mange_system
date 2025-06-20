package com.cn.dao;
import com.mchange.v2.c3p0.ComboPooledDataSource;
import java.sql.Connection;
import java.sql.SQLException;
public class ConnectionPool {

	 private static ComboPooledDataSource dataSource = new ComboPooledDataSource();

	    static {

	        try {
	            dataSource.setDriverClass("com.mysql.cj.jdbc.Driver");
	            dataSource.setJdbcUrl("jdbc:mysql://localhost:3306/infost");  
	            dataSource.setUser("root");  
	            dataSource.setPassword("root");  

	            dataSource.setInitialPoolSize(10);
	            dataSource.setMinPoolSize(5);
	            dataSource.setMaxPoolSize(20);
	            dataSource.setMaxIdleTime(300);  
	        } catch (Exception e) {
	            e.printStackTrace();
	        }
	    }

	    // 获取数据库连接
	    public static Connection getConnection() throws SQLException {
	        return dataSource.getConnection();
	    }
	
}
