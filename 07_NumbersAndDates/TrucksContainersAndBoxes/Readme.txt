
What should be done
You deliver humanitarian aid in boxes of the same size. You have trucks and containers.
Each truck holds a maximum of 12 containers. Each container contains no more than 27 boxes.
Boxes, containers and trucks are numbered.

Write a program in the TrucksContainersAndBoxes project,
which will distribute boxes to containers and trucks, depending on their number.
The program should display the required number of trucks and containers.


How the program works

The user enters the number of boxes, the program prints the result as text.
An example of the result for two boxes:

Truck: 1

    Container: 1

        Drawer: 1

        Drawer: 2



It is necessary:

trucks - 1 pc.

containers - 1 pc.


Recommendations
You can use the \ t tab character to indent a line.


Use the string returned by the System.lineSeparator () method to break lines.
This method returns the system line feed of the operating system on which the application is running,
since MacOS, Windows and Linux use different line breaks: for Windows it is \ r \ n, and for MacOS and Linux it is \ n.


Pay attention to the arithmetic operation "Modulus"
 System.out.println (45% 10); // the output will be 5.


What is evaluated
The number of trucks and containers is displayed correctly for any number of boxes, the tests are successful.

===============================================================================================================================================
Что нужно сделать
Вы доставляете гуманитарную помощь в ящиках одинакового размера. У вас есть грузовики и контейнеры. 
В каждый грузовик помещается максимум 12 контейнеров. В каждый контейнер — не более 27 ящиков. 
Ящики, контейнеры и грузовики пронумерованы. 

Напишите в проекте TrucksContainersAndBoxes программу, 
которая распределит ящики по контейнерам и грузовикам в зависимости от их количества. 
Программа должна выводить необходимое для этого число грузовиков и контейнеров.



Принцип работы программы

Пользователь вводит количество ящиков, программа печатает результат в виде текста. 
Пример результата для двух ящиков:

Грузовик: 1

    Контейнер: 1

        Ящик: 1

        Ящик: 2



Необходимо:

грузовиков - 1 шт.

контейнеров - 1 шт.

 

Рекомендации
Для добавления отступа в строке вы можете использовать символ табуляции \t.


Для переноса строк используйте строку, возвращаемую методом System.lineSeparator(). 
Этот метод возвращает системный перенос строки той операционной системы, на которой запущено приложение, 
так как в MacOS, Windows и Linux используются разные символы переноса строк: для Windows это \r\n, а для MacOS и Linux — \n.


Обратите внимание на арифметическую операцию «Остаток от деления»
 System.out.println(45 % 10); // вывод будет 5.


Что оценивается
Количество грузовиков и контейнеров выводится верно при любом количестве ящиков, тесты выполняются успешно.

