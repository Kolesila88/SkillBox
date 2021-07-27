
The purpose of the assignment:
Learn to work with inheritance using an abstract class.

What should be done:
Complete the assignment in the project
10_InheritanceAndPolymorphism / homework_10.3

1.In the project, find the abstract client.parent.Client class and its descendants client.IndividualBusinessman, client.LegalPerson, and client.PhysicalPerson.
2.Implement the methods of the classes, if necessary, override the methods in the descendants so that the conditions of addition and withdrawal are fulfilled:

	Each client has an amount of money in the account (number). Money can be deposited into the account, withdrawn and returned to the account balance. 
	Each class must contain a method that outputs information to the console about the account: deposit condition, withdrawal condition and balance.

-At client.PhysicalPerson, deposits and withdrawals are commission-free. If you pass a negative value to the deposit method, the amount on the account should not change.
When you try to withdraw an amount more than is on the account, the amount is not debited from the account, the amount on the account does not change.

-client.LegalPerson has all the conditions of the client.PhysicalPerson and an additional withdrawal with a commission of 1%.

-client.IndividualBusinessman has all the client.PhysicalPerson conditions and additionally, replenishment with a commission of 1%, if the amount is less than 1,000 rubles.
And replenishment with a commission of 0.5%, if the amount is greater than or equal to 1,000 rubles.


Criteria for evaluation:
"Pass" - class methods are implemented with inheritance in mind, avoiding code duplication. The tests are running successfully.
"For revision" - the task has not been completed.

======================================================================================================================================================================

Цель задания:
Освоить работу с наследованием, используя абстрактный класс.

Что нужно сделать:
Выполните задание в проекте

10_InheritanceAndPolymorphism/homework_10.3

1.В проекте найдите абстрактный класс client.parent.Client и его наследников client.IndividualBusinessman, client.LegalPerson и client.PhysicalPerson.
2.Реализуйте методы классов, при необходимости переопределите методы в наследниках так, чтобы выполнялись условия пополнения и снятия:

	У каждого клиента есть сумма денег на счету (число). Деньги можно положить на счёт, снять и вернуть остаток на счёте. 
	Каждый класс должен содержать метод, который выводит информацию в консоль о счёте: условие пополнения, условие снятия и баланс.

-У client.PhysicalPerson пополнение и списание происходит без комиссии. Если передать в метод пополнения отрицательное значение, сумма на счёте не должна измениться.
При попытке снять сумму больше, чем есть на счете, сумма не списывается со счёта, сумма на счёте не изменяется.

-У client.LegalPerson — все условия client.PhysicalPerson и дополнительно снятие с комиссией 1%.

-У client.IndividualBusinessman — все условия client.PhysicalPerson и дополнительно, пополнение с комиссией 1%, если сумма меньше 1 000 рублей.
 И пополнение с комиссией 0,5%, если сумма больше либо равна 1 000 рублей.

Критерии оценки:
«Зачёт» — методы классов реализованы с учётом наследования, избегая дублирования кода. Тесты выполняются успешно.
«На доработку» — задание не выполнено.
