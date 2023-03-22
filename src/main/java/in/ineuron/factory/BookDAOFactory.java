package in.ineuron.factory;

import in.ineuron.dao.IBookDAO;
import in.ineuron.dao.impl.BookDAOImpl;

public class BookDAOFactory
{
	private static IBookDAO bookDAO;

	private BookDAOFactory()
	{

	}

	public static IBookDAO getBookDAO()
	{
		if(bookDAO!=null)
			return bookDAO;
		else
			return new BookDAOImpl();
	}

}
