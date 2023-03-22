package in.ineuron.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import in.ineuron.bo.BookBO;
import in.ineuron.dao.IBookDAO;
import in.ineuron.util.JdbcUtil;
import in.ineuron.util.Util.BookOperationStatus;

public class BookDAOImpl implements IBookDAO
{
	private static final String INSERT_BOOK_QUERY = "INSERT INTO library_management.books "
			+ "(title,author,category,available_quantity) VALUES (?,?,?,?)";
	private static final String GET_BOOK_QUERY = "SELECT * FROM library_management.books " + "WHERE book_id = ?";
	private static final String DELETE_BOOK_QUERY = "DELETE FROM library_management.books " + "WHERE book_id = ?";

	Connection connection = null;
	PreparedStatement preparedStatement = null;
	ResultSet resultSet = null;

	@Override
	public BookOperationStatus saveBook(BookBO bookBO)
	{
		connection = JdbcUtil.getDatabasePhysicalConnection();

		BookOperationStatus insertOperationStatus = null;

		try
		{
			preparedStatement = connection.prepareStatement(INSERT_BOOK_QUERY);

			// setting placeholder values in preparedStatement
			preparedStatement.setString(1, bookBO.getTitle());
			preparedStatement.setString(2, bookBO.getAuthor());
			preparedStatement.setString(3, bookBO.getCategory());
			preparedStatement.setInt(4, bookBO.getAvailableQuantity());

			// executing query
			int inserRowCount = preparedStatement.executeUpdate();

			if (inserRowCount > 0)
				insertOperationStatus = BookOperationStatus.SUCCESS;
			else
				insertOperationStatus = BookOperationStatus.FAILED;

		} catch (SQLException se)
		{
			se.printStackTrace();
		} catch (Exception e)
		{
			e.printStackTrace();
		}

		return insertOperationStatus;
	}

	@Override
	public BookBO getBookById(Integer bookId)
	{
		connection = JdbcUtil.getDatabasePhysicalConnection();
		BookBO bookBO = null;

		try
		{
			preparedStatement = connection.prepareStatement(GET_BOOK_QUERY);

			// setting placeholder values in preparedStatement
			preparedStatement.setInt(1, bookId);

			// executing query
			resultSet = preparedStatement.executeQuery();

			if (resultSet.next())
			{
				bookBO = new BookBO();
				bookBO.setBookId(resultSet.getInt("book_id"));
				bookBO.setTitle(resultSet.getString("title"));
				bookBO.setAuthor(resultSet.getString("author"));
				bookBO.setCategory(resultSet.getString("category"));
				bookBO.setAvailableQuantity(resultSet.getInt("available_quantity"));
			}

		} catch (SQLException se)
		{
			se.printStackTrace();
		} catch (Exception e)
		{
			e.printStackTrace();
		}

		return bookBO;
	}

	@Override
	public BookOperationStatus deleteBookById(Integer bookId)
	{
		connection = JdbcUtil.getDatabasePhysicalConnection();
		PreparedStatement preparedStatement = null;
		BookOperationStatus deleteStatus = null;

		try
		{
			preparedStatement = connection.prepareStatement(DELETE_BOOK_QUERY);
			
			// set palceholder 
			preparedStatement.setInt(1, bookId);

			// executiong delete
			int deleteRowCount = preparedStatement.executeUpdate();

			if (deleteRowCount > 0)
				deleteStatus = BookOperationStatus.SUCCESS;
			else
				deleteStatus = BookOperationStatus.FAILED;

		} catch (SQLException se)
		{
			se.printStackTrace();
		} catch (Exception e)
		{
			e.printStackTrace();
		}

		return deleteStatus;
	}

	@Override
	public BookOperationStatus updateBookById(Integer bookId)
	{
		// TODO Auto-generated method stub
		return null;
	}

}
