The purpose of the assignment:
Learn to work with interfaces, abstract classes and class interactions.

What should be done:
create a new project in the 10_InheritanceAndPolymorphism / homework_10.4 folder and write all the required classes

1. Create a company class, Company, containing employees and implementing methods:
	-hiring one employee - hire (),
	-hiring a list of employees - hireAll (),
	-dismissing an employee - fire (),
	-getting the value of the company's income - getIncome ().
Choose the arguments and return values ​​of the methods based on the logic of your application.

2. Create two methods that return a list of the specified length (count). They should contain employees sorted in descending and ascending order of wages:
	-List <Employee> getTopSalaryStaff (int count),
	-List <Employee> getLowestSalaryStaff (int count).

3. Create employee classes with salary information and payroll conditions:
	-Manager - the salary consists of a fixed part and a bonus in the form of 5% of the money earned for the company. 
	Generate the amount of money earned for the company at random from 115,000 to 140,000 rubles.
	-TopManager - the salary consists of a fixed part and a bonus in the form of 150% of the salary if the company's income is more than 10 million rubles.
	-Operator - the salary consists of a fixed part only.

Each employee class must implement the Employee interface. The Employee interface must declare a method that returns the employee's salary:
	getMonthSalary ()


Select the arguments and return value of the method according to the payroll logic. 
In the interface, declare the required methods as needed.

To demonstrate and test how your classes work:

Create and hire in the company: 180 Operators, 80 Sales Managers, 10 Top Managers.
Print out a list of the 10-15 highest salaries in the company.
Print out a list of the 30 lowest salaries in the company.
Fire 50% of your employees.
Print out a list of the 10-15 highest salaries in the company.
Print out a list of the 30 lowest salaries in the company.

Examples of displaying a list of salaries
Descending list of five salaries:

	RUB 230,000
	RUB 178,000
	RUB 165 870
	RUB 123,000
	RUB 117,900

Recommendations:
Make it possible to create different instances of the company with your list of employees and income.
To get company data inside an employee class, set up a reference to be stored on Company and pass the Company object using a constructor or setter.
Note that the methods for retrieving salary lists can be passed count values ​​that are greater than the number of employees in the company, or negative.

Criteria for evaluation:
"Pass" - the program meets all the requirements.
"Failed" - the task has not been completed.

==========================================================================================================================================================================================

Цель задания:
Научиться работать с интерфейсами, абстрактными классами и взаимодействием классов. 

Что нужно сделать:
создать новый проект в папке 10_InheritanceAndPolymorphism/homework_10.4 и написать все требуемые классы
1. Создайте класс компании Company, содержащей сотрудников и реализующей методы:
	-найм одного сотрудника — hire(),
	-найм списка сотрудников – hireAll(),
	-увольнение сотрудника – fire(),
	-получение значения дохода компании – getIncome().
Аргументы и возвращаемое значение методов выберите на основании логики работы вашего приложения.

2. Создайте два метода, возвращающие список указанной длины (count). Они должны содержать сотрудников, отсортированных по убыванию и возрастанию заработной платы:
	-List<Employee> getTopSalaryStaff(int count),
	-List<Employee> getLowestSalaryStaff(int count).

3. Создайте классы сотрудников с информацией о зарплатах и условиями начисления зарплаты:
	-Manager — зарплата складывается из фиксированной части и бонуса в виде 5% от заработанных для компании денег. 
	Количество заработанных денег для компании генерируйте случайным образом от 115 000 до 140 000 рублей.
	-TopManager — зарплата складывается из фиксированной части и бонуса в виде 150% от заработной платы, если доход компании более 10 млн рублей.
	-Operator — зарплата складывается только из фиксированной части.
Каждый класс сотрудника должен имплементировать интерфейс Employee. 
В интерфейсе Employee должен быть объявлен метод, возвращающий зарплату сотрудника:
	getMonthSalary()

Аргументы и возвращаемое значение метода выберите в соответствии с логикой начисления зарплат. 
В интерфейсе при необходимости объявляйте необходимые методы.

Для демонстрации и тестирования работы ваших классов:

Создайте и наймите в компанию: 180 операторов Operator, 80 менеджеров по продажам Manager, 10 топ-менеджеров TopManager.
Распечатайте список из 10–15 самых высоких зарплат в компании.
Распечатайте список из 30 самых низких зарплат в компании.
Увольте 50% сотрудников.
Распечатайте список из 10–15 самых высоких зарплат в компании.
Распечатайте список из 30 самых низких зарплат в компании.

Примеры вывода списка зарплат
Список из пяти зарплат по убыванию:
	230 000 руб.
	178 000 руб.
	165 870 руб.
	123 000 руб.
	117 900 руб.
 

Рекомендации:
Сделайте возможным создавать разные экземпляры компании со своим списком сотрудников и доходом.
Чтобы получить данные компании внутри класса сотрудника, настройте хранение ссылки на Company и передавайте объект Company с помощью конструктора или сеттера.
Учтите, в методы получения списков зарплат могут передаваться значения count, превышающие количество сотрудников в компании, или отрицательные.
Критерии оценки

«Зачёт» — программа выполняет все требования.
«Незачёт» — задание не выполнено.