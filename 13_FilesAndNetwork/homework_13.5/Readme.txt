
The purpose of the assignment:
Learn how to get data from an HTML page, create and read JSON files.

What should be done:
	Write a program that:
	1. Receives the HTML-code of the page "List of Moscow Metro stations" https://www.moscowmap.ru/metro.html#lines using the jsoup library.
	2. Parses the received page and gets from it:
		Moscow metro lines (you get the line name, line number, you don't need to parse the color).
		Moscow metro stations (get the station name, line number).
	3. Creates and writes to disk a JSON file with a list of stations by lines and a list of lines in the JSON file format from the SPBMetro project (map.json file).
	4. Reads the file and prints to the console the number of stations on each line.

Recommendations:
By default, Jsoup reads 2MB of data from the requested page. To remove this limitation, you need to add a call to the maxBodySize (0) method, 
which sets the maximum value of the received data:
Document doc = Jsoup.connect (URL) .maxBodySize (0) .get ();
a value of 0 means that there is no limit on the amount of data received.
	-When examining the page code, it is convenient to use the developer console in the browser. 
	To do this, press F12, go to the Elements tab and find the <div id = "metrodata"> tag. 
	It contains tables with lines, stations and transfers. Pay attention to classes, write selectors based on the found classes. See how to get items by selectors in the JSoup documentation.
	-To find the required selectors faster, use the jsoup online service https://try.jsoup.org/

Criteria for evaluation:
"Test" - the program receives data from the site, writes it to a file and displays information about the number of stations on the lines.
"Failed" - the task has not been completed.

Additional task *
The purpose of the assignment:
Practice working with the jsoup library and generating JSON files.

What should be done:
Parse and write to a JSON file transitions between stations in addition to lines and stations (collection of station name, line number between which there are transitions).
Print to the console the number of metro passages.

Criteria for evaluation
"Passed" - the number of transitions in the Moscow metro is displayed in the console.
"Failed" - the task has not been completed.

========================================================================================================================================================================================================

Цель задания:
Научиться получать данные из HTML-страницы, создавать и читать JSON-файлы.

Что нужно сделать:
	Напишите программу, которая:
	1. Получает HTML-код страницы «Список станций Московского метрополитена» https://www.moscowmap.ru/metro.html#lines с помощью библиотеки jsoup.
	2. Парсит полученную страницу и получает из неё: 
	Линии московского метро (получаете имя линии, номер линии, цвет парсить не надо).
	Станции московского метро (получаете имя станции, номер линии).
	3. Создаёт и записывает на диск JSON-файл со списком станций по линиям и списком линий по формату JSON-файла из проекта SPBMetro (файл map.json).
	4. Читает файл и выводит в консоль количество станций на каждой линии.

Рекомендации:
По умолчанию Jsoup читает 2 Мб данных с запрашиваемой страницы. Чтобы снять это ограничение, необходимо добавить вызов метода maxBodySize(0), устанавливающий максимальное значение получаемых данных:
Document doc = Jsoup.connect(URL).maxBodySize(0).get();
значение 0 означает, что нет ограничений на принимаемый объём данных.
	-При изучении кода страницы удобно использовать консоль разработчика в браузере. 
	Для этого нажмите F12, перейдите во вкладку Elements и найдите тег <div id="metrodata">. 
	В нём содержатся таблицы с линиями, станциями и пересадками. Обращайте внимание на классы, напишите селекторы на основе найденных классов. 
	Посмотрите, как получать элементы по селекторам в документации JSoup.
	-Для более быстрого поиска нужных селекторов используйте онлайн сервис jsoup https://try.jsoup.org/
 
Критерии оценки:
-«Зачёт» — программа получает данные с сайта, записывает в файл и выводит информацию о  количестве станций на линиях.
-«Незачёт» — задание не выполнено.

Дополнительное задание*

Цель задания

Потренироваться в работе с библиотекой jsoup и формированием JSON-файлов.

Что нужно сделать:
Пропарсите и записывайте в JSON-файл переходы между станциями в дополнение к линиям и станциям (коллекции имя станции, номер линии, между которым есть переходы).
Выведите в консоль количество переходов в метро.

Критерии оценки:
«Зачёт» — в консоль выводится количество переходов в московском метро.
«Незачёт» — задание не выполнено.

