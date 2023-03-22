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
		bookBO.setTotalQuantity(bookDTO.getTotalQuantity());
		
		IBookDAO bookDAO = BookDAOFactory.getBookDAO();
		BookOperationStatus status = bookDAO.saveBook(bookBO);
		
		return status;
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
