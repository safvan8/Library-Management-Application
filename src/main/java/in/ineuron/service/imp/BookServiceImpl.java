package in.ineuron.service.imp;

import in.ineuron.bo.BookBO;
import in.ineuron.dao.IBookDAO;
import in.ineuron.dto.BookDTO;
import in.ineuron.factory.BookDAOFactory;
import in.ineuron.service.IBookService;
import in.ineuron.util.Util.BookOperationStatus;

public class BookServiceImpl implements IBookService
{

	@Override
	public BookOperationStatus saveBook(BookDTO bookDTO)
	{
		BookBO bookBO = new BookBO();
		bookBO.setTitle(bookDTO.getTitle());
		bookBO.setAuthor(bookDTO.getAuthor());
		bookBO.setCategory(bookDTO.getCategory());
		bookBO.setAvailableQuantity(bookDTO.getAvailableQuantity());
		
		IBookDAO bookDAO = BookDAOFactory.getBookDAO();
		BookOperationStatus status = bookDAO.saveBook(bookBO);
		
		return status;
	}

	@Override
	public BookBO getBookById(Integer bookId)
	{	
		IBookDAO bookDAO = BookDAOFactory.getBookDAO();
		return bookDAO.getBookById(bookId);
		
	}

	@Override
	public BookOperationStatus deleteBookById(Integer bookId)
	{
		IBookDAO bookDAO = BookDAOFactory.getBookDAO();
		return bookDAO.deleteBookById(bookId);
	}

	@Override
	public BookOperationStatus updateBook(BookBO bookBO)
	{
		IBookDAO bookDAO = BookDAOFactory.getBookDAO();
		return bookDAO.updateBook(bookBO);
	}
	
}
