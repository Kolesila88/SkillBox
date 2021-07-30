The purpose of the assignment:
Learn to read files, folders and their properties.

What should be done:
Perform the task in the project
13_FilesAndNetwork / homework_13.1

Write a program. She must:
get the path from the user to the folder through the console;
get the size of all files in the specified folder and its subfolders, 
the implementation of this should be written in the calculateFolderSize () method of the FileUtils class;
display the received amount of files in a readable form - in bytes, kilobytes, megabytes or gigabytes;
the program should catch all exceptions that occur when reading files and folders, and print an error message with a stack trace.

Examples of the program:
	Enter the path to the folder:
	D: \ Games
	D: \ Games folder size is 56.6 GB

Criteria for evaluation:
"Test" - the program displays the folder size in a readable format, the test of calculating the sum of the file sizes in the folder is performed.
"Failed" - the task has not been completed.

A method, calculateFilesCountInFolder (), has been written that returns the number of files in the specified folder.
Added logging of errors, processed files to separate files, logging of results to the console.

================================================================================================================================================================

Цель задания:
Научиться читать файлы, папки и их свойства.

Что нужно сделать:
Задание выполняйте в проекте 
13_FilesAndNetwork/homework_13.1

Напишите программу. Она должна:
получать через консоль путь от пользователя до папки;
получить размер всех файлов в указанной папке и ее подпапках, реализация этого должна быть написана в методе calculateFolderSize() класса FileUtils;
выводить полученную сумму файлов в удобочитаемом виде — в байтах, килобайтах, мегабайтах или гигабайтах;
программа должна перехватывать все исключения, возникающие при ошибках чтения файлов и папок, и выводить сообщение об ошибке с трассировкой стека (stack trace).

Примеры работы программы:
	Введите путь до папки:
	D:\Games
	Размер папки D:\Games cоставляет 56,6 Гб

Критерии оценки:
«Зачёт» — программа выводит размер папки в удобочитаемом формате, тест подсчета сумму размеров файлов в папке выполняется.
«Незачёт» — задание не выполнено.

Написан метод, calculateFilesCountInFolder(), возвращающий количество файлов в указанной папке.
Добавленно логирование ошибок, обрабатываемых файлов в отдельные файлы, логирование результатов в консоль.
