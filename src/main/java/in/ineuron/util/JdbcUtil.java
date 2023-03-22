package in.ineuron.util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;


public class JdbcUtil
{

	private static final String PASSWORD = "Safvan@123";
	private static final String USER_NAME = "root";
	private static final String JDBC_URL = "jdbc:mysql://localhost:3306/library_management";

	private static Connection connection;

	// making class singleton
	private JdbcUtil()
	{
	}

	public static void loadJDBCDriver()
	{
		try
		{
			Class.forName("com.mysql.cj.jdbc.Driver");
		} catch (ClassNotFoundException e)
		{
			throw new ExceptionInInitializerError();
		}
	}

	public static Connection getDatabasePhysicalConnection()
	{
		if (connection == null)
			try
			{
				return DriverManager.getConnection(JDBC_URL, USER_NAME, PASSWORD);
			} catch (SQLException e)
			{
				e.printStackTrace();
			}
		return connection;
	}

}
