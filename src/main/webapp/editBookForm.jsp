<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Add Book</title>
</head>
<body>
<body bgcolor="lightblue">
	<form method="post" action="./controller/editBookForm">
		<table align='center;'>
			<tr>
				<td>Book ID </td>
				<td><input type="text" name='bookId' value="${existingBookForUpdate.bookId}" readonly/></td>
			</tr>
		
			<tr>
				<td>Book Title</td>
				<td><input type="text" name='title' value="${existingBookForUpdate.title}" /></td>
			</tr>

			<tr>
				<td>Author</td>
				<td><input type="text" name='author' value="${existingBookForUpdate.author}"/></td>
			<tr>
				<td>Category</td>
				<td><input type="text" name='category' value="${existingBookForUpdate.category}" /></td>
			</tr>
			<tr>
				<td>Quanitity</td>
				<td><input type="text" name='availableQuantity' value="${existingBookForUpdate.availableQuantity}" /></td>
			</tr>
			<tr>
				<td></td>
				<td><input type="submit" value='save' /></td>
			</tr>
		</table>
	</form>
</body>
</html>

