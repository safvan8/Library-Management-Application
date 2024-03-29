package in.ineuron.controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import in.ineuron.bo.BookBO;
import in.ineuron.dto.BookDTO;
import in.ineuron.factory.BookServiceFactory;
import in.ineuron.service.IBookService;
import in.ineuron.util.JdbcUtil;
import in.ineuron.util.Util.BookOperationStatus;

public class Controller extends HttpServlet
{
	private static final long serialVersionUID = 1L;

	@Override
	public void init() throws ServletException
	{
		System.out.println("Servlet intilization");

		// load jdbc Driver
		JdbcUtil.loadJDBCDriver();
	}

	@Override
	public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException
	{
		doProcess(request, response);

	}

	@Override
	public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException
	{
		doProcess(request, response);
	}

	public void doProcess(HttpServletRequest request, HttpServletResponse response)
	{
		String uri = request.getRequestURI();
		System.out.println("Library....................");

		if (uri.endsWith("addBookForm"))
		{
			BookDTO bookDTO = new BookDTO();
			bookDTO.setTitle(request.getParameter("title"));
			bookDTO.setAuthor(request.getParameter("author"));
			bookDTO.setCategory(request.getParameter("category"));
			bookDTO.setAvailableQuantity(Integer.parseInt(request.getParameter("availableQuantity")));

			System.out.println(bookDTO);
			IBookService bookService = BookServiceFactory.getBookService();
			BookOperationStatus insertOperationStatus = bookService.saveBook(bookDTO);

			BookOperationStatus success = BookOperationStatus.SUCCESS;

			if (success.equals(insertOperationStatus))
				System.out.println("operration success");
			else
				System.out.println("Failed");
		} else if (uri.endsWith("readBookForm"))
		{
			Integer bookId = Integer.parseInt(request.getParameter("bookId"));
			IBookService bookService = BookServiceFactory.getBookService();
			BookBO bookBO = bookService.getBookById(bookId);

			System.out.println("Book :" + bookBO);

		} else if (uri.endsWith("deleteBookForm"))
		{

			Integer bookId = Integer.parseInt(request.getParameter("bookId"));
			System.out.println("Controller................0");

			IBookService bookService = BookServiceFactory.getBookService();

			BookBO existingBook = bookService.getBookById(bookId);

			System.out.println("Controller................1");

			BookOperationStatus deleteStatus = null;

			BookOperationStatus success = BookOperationStatus.SUCCESS;

			if (existingBook != null)
			{
				deleteStatus = bookService.deleteBookById(bookId);
				System.out.println("Controller................2");

			} else
				System.out.println("No records for the given ID : " + bookId);

			if (success.equals(deleteStatus))
				System.out.println("delete operartion success");
			else
				System.out.println("delete operation failed");
		} else if (uri.endsWith("updateBookForm"))
		{
			Integer bookId = Integer.parseInt(request.getParameter("bookId"));

			System.out.println("Controller.................................5");
			IBookService bookService = BookServiceFactory.getBookService();

			System.out.println("Controller.................................6");

			BookBO existingBookForUpdate = bookService.getBookById(bookId);

			if (existingBookForUpdate != null)
			{
				System.out.println("Controller.................................7");

				request.setAttribute("existingBookForUpdate", existingBookForUpdate);

				try
				{

					System.out.println("Controller.................................8");

					request.getRequestDispatcher("/editBookForm.jsp").forward(request, response);
				} catch (ServletException | IOException e)
				{
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		} else if (uri.endsWith("editBookForm"))
		{
			BookBO bookBO = new BookBO();
			bookBO.setBookId(Integer.parseInt(request.getParameter("bookId")));
			bookBO.setTitle(request.getParameter("title"));
			bookBO.setAuthor(request.getParameter("author"));
			bookBO.setCategory(request.getParameter("category"));
			bookBO.setAvailableQuantity(Integer.parseInt(request.getParameter("availableQuantity")));
			
			System.out.println(bookBO);
			IBookService bookService = BookServiceFactory.getBookService();
			BookOperationStatus updateOperationStatus = bookService.updateBook(bookBO);

			BookOperationStatus success = BookOperationStatus.SUCCESS;

			if (success.equals(updateOperationStatus))
				System.out.println("Update operration success");
			else
				System.out.println("Update Operation Failed");
		}

	}

	@Override
	public void destroy()
	{
		System.out.println("Servlet destruction");
	}

}
