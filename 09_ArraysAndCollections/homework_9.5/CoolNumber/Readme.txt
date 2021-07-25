
The purpose of the assignment:
Learn to sort and search for items in collections.

What should be done:
Do the job at 09_NumbersStringsAndDates / homework_9.5 / CoolNumbers

1. Implement the generateCoolNumbers () method for generating "nice" license plates in the CoolNumbers class. Use the following rules for generating numbers:
-XYZ - a different set from the list of allowed letters, N - numbers, R - region (from 01 to 199);
-XNNNYZR - example: A111BC197, U777HC66.
-The following letters are used in license plates of cars in the Russian Federation: A, B, E, K, M, H, O, P, C, T, U, X
-The collection must contain at least 2 million numbers.

2. Implement the search methods of the CoolNumbers class to find numbers in each collection:
-direct search over ArrayList,
-binary search on sorted ArrayList,
-search in HashSet,
-by searching the TreeSet.

3. Measure and output the duration of each search method.
Search results output format:
-Brute force search: number found / not found, search took 34ns
-Binary search: number found / not found, search took 34ns
-Search in HashSet: number found / not found, search took 34ns
-TreeSet search: number found / not found, search took 34ns

4. Write in the answer form which search is the fastest and which is the slowest.


The video Search and Sort does not accurately estimate the result of the Collections.binarySearch () binary search method. 
The method returns int if the return value is greater than or equal to zero, which means that the element has been found. 
If the returned int value is less than zero, the item was not found in the collection.


Recommendations:
Sorting is not included in the timing for binary search;
for detailed comparison of search methods use time in nanoseconds: System.nanoTime ()
 
Criteria for evaluation:
"Passed" - when entering a license plate into the console, the program unambiguously answers whether the license plate is found in each of the collections. 
All tests run successfully.
"For revision" - the task has not been completed.

================================================================================================================================================================

Цель задания:
Научиться сортировать и искать элементы в коллекциях.

Что нужно сделать:
Выполните задание в 09_NumbersStringsAndDates/homework_9.5/CoolNumbers

1. Реализуйте метод генерации «красивых» автомобильных номеров generateCoolNumbers() в классе CoolNumbers. 
Используйте следующие правила генерации номеров:
-XYZ — различный набор из списка разрешенных букв, N — цифры, R — регион (от 01 до 199);
-XNNNYZR — пример: A111BC197, У777HC66.
-В госномерах автомобилей в РФ используются следующие буквы: А, В, Е, К, М, Н, О, Р, С, Т, У, Х
-В коллекции должно быть не менее 2 млн номеров.

2. Реализуйте методы поиска класса CoolNumbers по поиску номеров в каждой коллекции:
-прямым перебором по ArrayList,
-бинарным поиском по сортированному ArrayList,
-поиском в HashSet,
-поиском в TreeSet.

3. Измерьте и выведите длительность каждого метода поиска. 
Формат вывода результатов поиска:
-Поиск перебором: номер найден/не найден, поиск занял 34нс
-Бинарный поиск: номер найден/не найден, поиск занял 34нс
-Поиск в HashSet: номер найден/не найден, поиск занял 34нс
-Поиск в TreeSet: номер найден/не найден, поиск занял 34нс

4. Напишите в форме ответа, какой поиск — самый быстрый, а какой — самый медленный.


В видео Поиск и сортировка неточно указана оценка результата работы метода бинарного поиска Collections.binarySearch(). 
Метод возвращает int, если возвращаемое значение больше или равно нулю — это означает, что элемент найден. 
Если возвращаемое значение int меньше нуля — элемент в коллекции не найден.

 
Рекомендации:

Cортировка не входит в учёт времени для бинарного поиска;
для детального сравнения методов поиска используйте время в наносекундах:   System.nanoTime()
 
Критерии оценки:
«Зачёт» — при вводе в консоль автомобильного номера программа однозначно отвечает, найден ли номер в каждой из коллекций. Все тесты успешно выполняются.
«На доработку» — задание не выполнено.

