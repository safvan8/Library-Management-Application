package in.ineuron.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.omg.PortableServer.POAPackage.AdapterAlreadyExists;

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
		}

	}

	@Override
	public void destroy()
	{
		System.out.println("Servlet destruction");
	}

}
