package in.ineuron.dao;

import in.ineuron.bo.BookBO;
import in.ineuron.util.Util.BookOperationStatus;

public interface IBookDAO
{

	public abstract BookOperationStatus saveBook(BookBO bookBO);

	public abstract BookBO getBookById(Integer bookId);

	public abstract BookOperationStatus deleteBookById(Integer bookId);

	public abstract BookOperationStatus updateBookById(Integer bookId);

}
