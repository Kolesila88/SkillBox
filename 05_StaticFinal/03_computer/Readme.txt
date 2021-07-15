What should be done
1. Create a non-immutable Computer class with immutable component properties.
For each such property, create classes with the listed fields (the names of the classes and fields, as well as the types of the fields, come up with your own).

CPU:
-frequency,
-Number of Cores,
-manufacturer,
-weight.
RAM:
-a type,
-volume,
-weight.
HDD:
-type - HDD, SSD,
-memory size,
-weight.
Screen:
-diagonal,
-type (IPS, TN, VA),
-weight.
Keyboard:
-a type,
-the presence of backlight,
-weight.
All of these classes must be immutable (immutable). Make up the names of classes and fields, as well as the types of fields yourself.


2. In the Computer class also create the vendor and name immutable text fields,
 set when creating a computer (in the constructor).


3. Implement the following methods in the Computer class:

A method for calculating the total mass of a computer that returns the total weight of all of its components.
Getters and setters for all computer components.
A toString method that returns all information about the computer and its components in a human-readable format.


What is evaluated
All requirements specified in the assignment have been met.
The variable names correspond to the data they store.
The names of the created and implemented methods correspond to the actions they perform, and the names of the getters and setters correspond to the naming conventions for getters and setters.
==============================================================================================================================================================
Что нужно сделать
1. Создайте неиммутабельный класс Computer с иммутабельными свойствами-компонентами. 
Для каждого такого свойства создайте классы с перечисленными полями (имена классов и полей, а также типы полей придумайте самостоятельно).

Процессор:
	-частота,
	-количество ядер,
	-производитель,
	-вес.
Оперативная память:
	-тип,
	-объём,
	-вес.
Жёсткий диск:
	-тип — HDD, SSD,
	-объём памяти,
	-вес.
Экран:
	-диагональ,
	-тип (IPS, TN, VA),
	-вес.
Клавиатура:
	-тип,
	-наличие подсветки,
	-вес.
Все эти классы должны быть иммутабельными (неизменяемыми). Имена классов и полей, а также типы полей придумайте самостоятельно.



2. В классе Computer также создайте иммутабельные (неизменяемые) текстовые поля vendor (производитель) и name (название),
 задаваемые при создании компьютера (в конструкторе).



3. Реализуйте в классе Computer следующие методы:

Метод расчёта общей массы компьютера, возвращающий суммарный вес всех его компонентов.
Геттеры и сеттеры для всех компонентов компьютера.
Метод toString, возвращающий в удобочитаемом формате всю информацию о компьютере и его компонентах.


Что оценивается
Выполнены все указанные в задании требования.
Имена переменных соответствуют хранимым в них данным.
Имена созданных и реализованных методов соответствуют выполняемым ими действиям, а имена геттеров и сеттеров — правилам именования геттеров и сеттеров.