package in.ineuron.service;

import in.ineuron.bo.BookBO;
import in.ineuron.dto.BookDTO;
import in.ineuron.util.Util.BookOperationStatus;

public interface IBookService
{
	

	public abstract BookOperationStatus saveBook(BookDTO bookDTO);

	public abstract BookBO getBookById(Integer bookId);

	public abstract BookOperationStatus deleteBookById(Integer bookId);

	public abstract BookOperationStatus updateBook(BookBO bookBO);
}
