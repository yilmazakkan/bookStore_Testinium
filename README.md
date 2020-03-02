# bookStore_Testinium
Testinum Homework Documentation

1-Homework (Character Tree )<br>

1- The character tree, consisting of lines as many as the number of input values received from the user, is returned to the output.<br>

2- Controlled by Try-Catch throws an exception if the input is not integer.<br>

2-Homework (BookStore )<br>

·         Documentation your API / OpenAPI<br>
http://localhost:8090/swagger-ui/index.html?configUrl=/api-docs/swagger-config<br>

·        
Mysql database was used.<br>


·         H2 database for testing added in test scope.<br>


·         Script data must be import first. There are sample data for testing the services in this script.<br>


·         Lombok library was used.<br>


·         There is Logging in the project.<br>


·         Some unit tests and integration tests were done.<br>



·         All service requests for Postman are available in the file.<br>

 

Category<br>

3- "CreateCategory" creates a new category.<br>

4- "GetAllCategory" lists all categories.<br>

5- Replaces the category of the id book specified in the Update Category category with the given Category id category.<br>

 BookStore<br>

7- "CreateBookStore" creates a new BookStore.<br>

8- "Delete Id" deletes the given Book from BookStore.<br>

"GetAll BookStore" lists all bookstores<br>

 



Book<br>

 "CreateBook" creates a new book.<br>

 "Create New Book And Add to BookStores", Create a book and adds it to multiple bookstores at the same time.<br>

 "Add Book" to book Store Adds an existing book to an existing bookstore.<br>

"List Books By Category" Lists the books by category<br>

 "GetAll Book" Lists all books.<br>
 


 Rules<br>
 
 1-The category must be added first. It cannot be created without a category of books.<br>
 2-A book can be added to many Bookstores at the same time or just one bookstore and book can be added to bookstore later.<br>
 3-The code of the book is unique.<br>
 4-Books must have a category.<br>
 5-A bookstore with the same name cannot be in the same city.<br>
 6-Two categories with the same name cannot be created.<br>
 7-Category name cannot be empty.<br>
 8-Book price Cannot be Empty<br>
 9-Book Code Cannot be Empty<br>
 10-BookStore Name Cannot be Empty<br>
 11-City Name Cannot be Empty<br>
