package in.ineuron.dao.impl;

import in.ineuron.bo.BookBO;
import in.ineuron.dao.IBookDAO;
import in.ineuron.util.Util.BookOperationStatus;

public class BookDAOImpl implements IBookDAO
{

	@Override
	public BookOperationStatus saveBook(BookBO bookBO)
	{
		try
		{
			Class.forName("com.mysqlcj.jdbc.Driver");
		} catch (ClassNotFoundException e)
		{
			e.printStackTrace();
		}
		
		
		
		
		
		return null;
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
