
The purpose of the assignment:
Learn to write controllers to handle requests in accordance with the REST API.

What should be done:
	1.Write what entities will be in your ToDoList.
	2.Specify their properties and URL in the API for each entity.
	3.Complete the REST JSON API formats for the ToDoList application. (Create a case, delete a case, update a case, get a list, delete the entire list).

You don't need to do the web interface (HTML + JavaScript) in this task, in this case you only need to write requests.

Test queries using query testing tools:
	1.Chrome browser extension Talend API
	2.Postman app. Video how to use the application.

Recommendations for naming queries:
	-Use nouns in request addresses.
	-Stick to the following query style:

Resource	GET request type -	POST request type -	PUT request type -	DELETE request type -
                Retrieving data         Creation                Update                  Deleting

/courses	Get a list of all       Create a new course     Bulk update course      Delete all courses
                courses                                         data

/courses/711    Returns course          Method not allowed      Updating course         Deleting course with 
                with id 711             (405)                   data with id 711        id 711

Keep in mind:
In Spring, each API request occurs on a separate thread. 
Configure data handling in a thread-safe manner using knowledge from the module on multithreading.

Criteria for evaluation:
"Test" - all controllers for REST API are written.
"Failed" - the task has not been completed.

==================================================================================================================================================================

Цель задания:
Научиться писать контроллеры для обработки запросов в соответствии с REST API.

Что нужно сделать:
	1.Напишите, какие сущности будут в вашем ToDoList. 
	2.Укажите их свойства и URL в API для каждой сущности.
	3.Пропишите полностью форматы REST JSON API для приложения ToDoList. 
	(Создание дела, удаление дела, обновление дела, получение списка, удаление всего списка).

Веб интерфейс (HTML + JavaScript) в этом задании делать не надо, в данном случае необходимо прописать только запросы. 

Тестируйте запросы используя инструменты для тестирования запросов:
	1.Расширение для браузера Chrome Talend API
	2.Приложение Postman. Видео как пользоваться приложением.

Рекомендации по именованию запросов:
	-В адресах запросов используйте существительные.
	-Придерживайтесь следующего стиля запросов:

Ресурc		Тип запроса GET —	Тип запроса POST —	Тип запроса PUT —	Тип запроса DELETE —
                Получение данных        Создание                Обновление              Удаление

/courses	Получение списка 	Создание нового 	Массовое обновление 	Удаление всех курсов
                всех курсов             курса                   данных курсов

/courses/711	Возвращает курс 	Метод не разрешён 	Обновление данных 	Удаление курса с id 711
                с id 711                (405)                   курса с id 711

Обратите внимание:
В Spring каждый запрос к API происходит в отдельном потоке. 
Настройте работу с данными потокобезопасно, используя знания из модуля по многопоточности.

Критерии оценки:
«Зачёт» — написаны все контроллеры для REST API.
«Незачёт» — задание не выполнено.



