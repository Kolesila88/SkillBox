
The purpose of the assignment:
Learn to connect MySQL in a project and write a query in code.

What should be done:
Write a code that displays the average purchases per month for each course in 2018. Consider the range of months during which there have been sales. 
More details in the example.
Try to use only SQL, while grouping by month can be done using Java as well.


An example of calculation for the course "Web developer from scratch to PRO"

SELECT pl.course_name, pl.subscription_date FROM PurchaseList pl WHERE pl.course_name = "Web Developer from 0 to PRO" ORDER BY pl.subscription_date;

         course_name        |     subscription_date |

--------------------------  | -------------------   |

Web developer from 0 to PRO | 2018-01-02 00: 00: 00 |

Web developer from 0 to PRO | 2018-02-16 00: 00: 00 |

Web developer from 0 to PRO | 2018-04-02 00: 00: 00 |

Web developer from 0 to PRO | 2018-05-17 00: 00: 00 |

Web developer from 0 to PRO | 2018-07-01 00: 00: 00 |

Web developer from 0 to PRO | 2018-08-15 00: 00: 00 |


The rates were on sale from January to August, that is, eight months. A total of six subscriptions were sold. 
This means that the average sales value for the course "Web developer from zero to PRO" = 0.75.
To get the value of the month from a date in a numeric value, use the function
MONTH (date_value)
https://oracleplsql.ru/function-sql-server-month.html

Usage example:
SELECT * FROM Students s WHERE MONTH (s.registration_date) = 4;
the query will display all students registered in April:

id |       name         | age |  registration_date  |

-  | ------------------ | --- | ------------------- |

14 |   Kutyakov Efrem   | 31  |2016-04-01 00: 00: 00|

15 |   Bondarev Igor    | 32  |2016-04-08 00: 00: 00|

16 | Zhuravlev Sevastian| 33  |2016-04-15 00: 00: 00|

17 |   Inshov Gennady   | 34  |2016-04-22 00: 00: 00|

18 | Shabanov Claudius  | 35  |2016-04-29 00: 00: 00|

67 |   Bugakov Valery   | 34  |2017-04-07 00: 00: 00|

68 |   Gaidenko Ilya    | 35  |2017-04-14 00: 00: 00|

69 | Interceptkin Sergey| 36  |2017-04-21 00: 00: 00|

70 |  Barsukov Victor   | 37  |2017-04-28 00: 00: 00|

If you have an unassigned timezone error.
ERROR: The server time zone value ‘ y    ׼ʱ  ’ is unrecognized or represents more than one time zone. 
You must configure either the server or JDBC driver (via the serverTimezone configuration property) to use a more specific time zone value 
if you want to utilize time zone support.

Solution:
Add to your database connection string a parameter specifying the time zone, serverTimezone = UTC, or specify a specific time zone, 
for example serverTimezone = Europe / Moscow.

Your line will look like this:
jdbc: mysql: // localhost: 3306 / skillbox? useSSL = false & serverTimezone = UTC

Criteria for evaluation:
"Pass" - the console displays the average number of purchases of courses per month for 2018.
"Failed" - the task has not been completed.

================================================================================================================================================================


Цель задания:
Научиться подключать MySQL в проекте и писать запрос в коде.

Что нужно сделать:
Напишите код, который выведет среднее количество покупок в месяц для каждого курса за 2018 год. 
Учитывайте диапазон месяцев, в течение которого были продажи. Подробнее в примере.

Старайтесь использовать только SQL, при этом  группировку по месяцам можно сделать и с помощью Java.

Пример расчёта для курса «Веб-разработчик c нуля до PRO»

SELECT pl.course_name, pl.subscription_date FROM PurchaseList pl WHERE pl.course_name = "Веб-разработчик c 0 до PRO" ORDER BY pl.subscription_date;

course_name               |subscription_date  |

--------------------------|-------------------|

Веб-разработчик c 0 до PRO|2018-01-02 00:00:00|

Веб-разработчик c 0 до PRO|2018-02-16 00:00:00|

Веб-разработчик c 0 до PRO|2018-04-02 00:00:00|

Веб-разработчик c 0 до PRO|2018-05-17 00:00:00|

Веб-разработчик c 0 до PRO|2018-07-01 00:00:00|

Веб-разработчик c 0 до PRO|2018-08-15 00:00:00|


Курсы продавались с января по август, то есть восемь месяцев. Всего было продано шесть подписок. 
Значит, среднее значение продаж для курса «Веб-разработчик c нуля до PRO» = 0,75.
Для получения значения месяца из даты в числовом значении используйте функцию 
MONTH( date_value )
https://oracleplsql.ru/function-sql-server-month.html

Пример использования:
SELECT * FROM Students s WHERE MONTH(s.registration_date ) = 4;
запрос выведет всех студентов, зарегистрированных в апреле:

id|name              |age|registration_date  |

--|------------------|---|-------------------|

14|Кутяков Ефрем     | 31|2016-04-01 00:00:00|

15|Бондарев Игорь    | 32|2016-04-08 00:00:00|

16|Журавлев Севастьян| 33|2016-04-15 00:00:00|

17|Иньшов Геннадий   | 34|2016-04-22 00:00:00|

18|Шабанов Клавдий   | 35|2016-04-29 00:00:00|

67|Бугаков Валерий   | 34|2017-04-07 00:00:00|

68|Гайденко Илья     | 35|2017-04-14 00:00:00|

69|Перехваткин Сергей| 36|2017-04-21 00:00:00|

70|Барсуков Виктор   | 37|2017-04-28 00:00:00|

Если у вас ошибка не назначенного часового пояса.
ERROR: The server time zone value ‘�й���׼ʱ��’ is unrecognized or represents more than one time zone. 
You must configure either the server or JDBC driver (via the serverTimezone configuration property) to use a more specific time zone value 
if you want to utilize time zone support.

Решение:
Добавьте в вашу строку соединения с базой данных параметр, указывающий часовой пояс, serverTimezone=UTC или укажите конкретный часовой пояс, 
например serverTimezone=Europe/Moscow.

Ваша строка будет выглядеть так:
jdbc:mysql://localhost:3306/skillbox?useSSL=false&serverTimezone=UTC

Критерии оценки:
«Зачёт» — в консоль выводятся средние количества покупок курсов в месяц за 2018 год.
«Незачёт» — задание не выполнено.