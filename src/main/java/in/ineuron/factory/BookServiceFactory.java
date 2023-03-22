package in.ineuron.factory;

import in.ineuron.service.IBookService;
import in.ineuron.service.imp.BookServiceImpl;

public class BookServiceFactory
{
	private static IBookService bookService;
	
	private BookServiceFactory() {}
	
	public static IBookService getBookService() {
		if(bookService!=null)
			return bookService;
		else
			return new BookServiceImpl();
	}
	
}
