The purpose of the assignment

Learn to work with the ArrayList.

 What should be done

Perform the task in the project

09_ArraysAndCollections / homework_9.2 / storage.TodoList.

Develop a program - a to-do list that is controlled by commands in the console. Commands: LIST, ADD, EDIT, DELETE.
To work with to-do list data, the project contains the storage.TodoList class, which should be responsible for storing and working with the to-do list.
Implement all methods and test the class using existing tests.
In the Main class, write the code to implement user interaction by entering commands into the console.
How commands work:

LIST - displays cases with their serial numbers;
ADD - adds a case to the end of the list or a case to a certain place, moving the rest of the cases forward, if you specify a number; 
if a non-existent index is specified, add to the end of the list.
EDIT - replaces the case with the specified number; if a non-existent index is specified, do nothing.
DELETE - deletes; if a non-existent index is specified, do nothing.
Commands are entered by the user into the console in one line.

Examples of working with a to-do list (user input is in bold)

ADD buy milk
Added "buy milk" case
ADD learn java
Added "learn java" case
LIST
0 - buy milk
1 - learn java
EDIT 0 make a cup of tea
Replaced "buy milk" with "make a cup of tea"
DELETE 1
"Learn java" case removed
LIST
0 - make a cup of tea
DELETE 100
The case with such a number does not exist


Criteria for evaluation

"Pass" - the work of the to-do list has been implemented, the tests are successfully performed.
"For revision" - the task has not been completed or not all tests are being executed successfully.
==========================================================================================================================================================

Цель задания

Научиться работать со списком ArrayList.

 Что нужно сделать

Задание выполняйте в проекте 

09_ArraysAndCollections/homework_9.2/storage.TodoList.

Разработайте программу — список дел, который управляется командами в консоли. Команды: LIST, ADD, EDIT, DELETE. 
Для работы с данными списка дел в проекте находится класс storage.TodoList, который должен отвечать за хранение и работу со списком дел. Реализуйте все методы и проверьте класс с помощью существующих тестов.
В классе Main напишите код для реализации взаимодействия с пользователем через ввод команд в консоль.
Принцип работы команд:

LIST — выводит дела с их порядковыми номерами;
ADD — добавляет дело в конец списка или дело на определённое место, сдвигая остальные дела вперёд, если указать номер; если указан несуществующий индекс - добавить в конец списка.
EDIT — заменяет дело с указанным номером; если указан несуществующий индекс - ничего не делать.
DELETE — удаляет; если указан несуществующий индекс - ничего не делать.
Команды вводятся пользователем в консоль одной строкой.

Примеры работы со списком дел (жирным шрифтом выделен ввод пользователя)

ADD buy milk
Добавлено дело "buy milk"
ADD learn java
Добавлено дело "learn java"
LIST
0 - buy milk
1 - learn java
EDIT 0 make a cup of tea
Дело "buy milk" заменено на "make a cup of tea"
DELETE 1
Дело "learn java" удалено
LIST
0 - make a cup of tea
DELETE 100
Дело с таким номером не существует


 Критерии оценки

«Зачёт» —  реализована работа списка дел, тесты успешно выполняются.

«На доработку» — задание не выполнено или не все тесты успешно выполняются.