
The purpose of the assignment:
Master writing class tests using the JUnit library.

What should be done:
Perform the task in the project
12_ExceptionsDebuggingAndTesting / homework_12.2

Write tests for all methods of the RouteCalculator class in the SPBMetro project.
Using tests and debugging, fix the error that you find in the SPBMetro project in the RouteCalculator class.

Recommendations:

Create a metro map (StationIndex) in the test class, in which you can build at least one route with two transfers. 
	-Make a small diagram to make it easier to navigate.
	-To test the private methods of the RouteCalculator class, 
	use the various arguments to the getShortestRoute () method to call non-hop, one-hop and two-hop methods.
	-Code Coverage is a tool in IDEA that determines the level of test coverage of classes, methods and strings. 
	To run tests with coverage checking, right-click on the class of the test directory and select Run All tests with Coverage. 
	It is desirable to achieve 100% coverage of the methods of the RouteCalculator class.

Criteria for evaluation:
"Pass" - a bug in the SPBMetro project has been fixed, all tests for checking routes and travel times are performed without errors.
"Failed" - the task has not been completed.

==============================================================================================================================================================

Цель задания:
Освоить написание тестов для классов, используя библиотеку JUnit.

Что нужно сделать:
Задание выполняйте в проекте
12_ExceptionsDebuggingAndTesting/homework_12.2

Напишите тесты на все методы класса RouteCalculator в проекте SPBMetro.
С помощью тестов и отладки исправьте ошибку, которую вы найдёте в проекте SPBMetro в классе RouteCalculator.

Рекомендации:
	-Сформируйте схему метро (StationIndex) в тестовом классе, в которой можно построить хотя бы один маршрут с двумя пересадками. 
	Делайте небольшую схему, чтобы легче ориентироваться в ней.
	-Чтобы протестировать приватные методы класса RouteCalculator, 
	используйте различные аргументы метода getShortestRoute() для вызова методов без пересадок, с одной и двумя пересадками.
	-Code Coverage — инструмент в IDEA, определяющий уровень покрытия тестами классов, методов и строк. 
	Чтобы запустить тесты с проверкой покрытия, надо нажать правой кнопкой мыши по классу директории с тестами и выбрать Run All tests with Coverage. 
	Желательно добиться 100%-ного покрытия методов класса RouteCalculator.

Критерии оценки:
«Зачёт» — исправлена ошибка в проекте SPBMetro, все тесты для проверки маршрутов и времени проезда выполняются без ошибок.
«Незачёт» — задание не выполнено.