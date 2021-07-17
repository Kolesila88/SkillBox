
The purpose of the assignment
Learn how to create objects of the LocalDate class, add to dates and compare dates with each other.


What should be done
Do the assignment in the class Main project 07_NumbersAndDates / Dates

Implement the method

public String collectBirthdays (int year, int month, int day),

which will return strings, all your past birthdays from zero years to date in a required format. Date of birth is passed in the three-number method.

Output format:

0 - 31.12.1990 - Mon

1 - 31.12.1991 - Tue

...


Recommendations

Create two variables of the LocalDate class at the beginning of the method - birthday and today.
After that, write a loop in which you add one year to birthday and compare the resulting date with today using the isAfter or isBefore method.
Thus, you will check not only the year, but also the day, which will allow you to accurately display data on past birthdays.
To wrap text on a new line, use the line break character returned by the System.lineSeparator () method:
String text = text + "Date string" + System.lineSeparator ();
This method returns the system line break, which is the default for your operating system. On Windows it is \ r \ n, on MacOS and Linux it is \ n.


What is evaluated
The correctness of the displayed list of birth dates depending on the date, 
as well as the quality of the written code and the use of the classes and methods learned in the lessons.

=========================================================================================================================================================

Что нужно сделать
Выполните задание в классе Main проекта 07_NumbersAndDates/Dates


Реализуйте метод

public String collectBirthdays(int year, int month, int day),

который вернёт строки, содержащие все ваши прошедшие дни рождения от нуля лет до текущей даты в требуемом формате. 
Дата рождения передаётся в метод тремя числами.


Формат требуемого вывода:

0 - 31.12.1990 - Mon

1 - 31.12.1991 - Tue

…


Рекомендации

Создайте в начале метода две переменные класса LocalDate — birthday и today. 
После этого напишите цикл, в котором добавляйте один год к birthday и сравнивайте получившуюся дату с сегодняшней, используя метод isAfter или isBefore. 
Таким образом у вас будет проверяться не только год, но и день, что позволит точно выводить данные о прошедших днях рождениях.
Для переноса текста на новую строку используйте символ переноса строки, который возвращается методом System.lineSeparator():
String text = text + "Строка с датой" + System.lineSeparator();
Этот метод возвращает системный перенос строки — тот, который используется в вашей операционной системе по умолчанию. 
В Windows это \r\n, в MacOS и Linux — \n.



Что оценивается
Корректность выводимого списка дат рождения в зависимости от даты, а также качество написанного кода и использование классов и методов, изученных в уроках.