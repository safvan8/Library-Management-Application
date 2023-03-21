package in.ineuron.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class Controller extends HttpServlet
{
	private static final long serialVersionUID = 1L;

	@Override
	public void init() throws ServletException
	{
		System.out.println("Servlet intilization");
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
			
		}

	}

	@Override
	public void destroy()
	{
		System.out.println("Servlet destruction");
	}

}
