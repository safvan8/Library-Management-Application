package in.ineuron.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import in.ineuron.bo.BookBO;
import in.ineuron.dao.IBookDAO;
import in.ineuron.util.JdbcUtil;
import in.ineuron.util.Util.BookOperationStatus;

public class BookDAOImpl implements IBookDAO
{
	private static final String INSERT_BOOK_QUERY = "INSERT INTO library_management.books "
			+ "(title,author,category,available_quantity) VALUES (?,?,?,?)";

	Connection connection = null;
	PreparedStatement preparedStatement = null;

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
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public BookOperationStatus deleteBookById(Integer bookId)
	{
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public BookOperationStatus updateBookById(Integer bookId)
	{
		// TODO Auto-generated method stub
		return null;
	}

}
