
The purpose of the assignment:
To master in practice the inheritance of classes.

What should be done:
Complete the assignment in the project
10_InheritanceAndPolymorphism / homework_10.1

Find the BankAccount class in the project and the CardAccount and DepositAccount classes inherited from it.
Implement the methods of the classes, if necessary, override the methods in the descendants so that the conditions of addition and withdrawal are met:
-BankAccount - deposits and withdrawals are commission-free. If you pass a negative value to the deposit method, the amount on the account should not change. 
When you try to withdraw a larger amount than is on the account, the amount is not debited from the account, the amount on the account does not change.
-CardAccount - card account, in addition to the conditions of BankAccount - when withdrawing money, a commission of 1% of the withdrawal amount must be charged. 
Example: when you try to withdraw 100 rubles from the account, 101 rubles should be debited.
-DepositAccount is a deposit account, in addition to the conditions of BankAccount - you cannot withdraw money within one month after the last deposit. 
Name the variable that stores the last deposit date lastIncome. Variable type use Calendar or LocalDate.

Criteria for evaluation:
"Pass" - implemented class methods according to the condition, all tests are executed successfully.
"For revision" - the task has not been completed.


Additional task *
The purpose of the assignment:
Practice writing interactions between classes.

What should be done:
Write a method in the BankAccount class:
-boolean send (BankAccount receiver, double amount)
to send money from one account to another. The method should return true if the money was successfully transferred.
- 💡 you can add a boolena return to the take () method to track whether the money was successfully debited (true) or not (false)

Criteria for evaluation:
"Credit" - the send () method transfers money between accounts, taking into account commissions and restrictions.
"For revision" - the task has not been completed.

=======================================================================================================================================================================

Цель задания:
Освоить на практике наследование классов.

Что нужно сделать:
Выполните задание в проекте
10_InheritanceAndPolymorphism/homework_10.1

В проекте найдите класс BankAccount и унаследованные от него классы CardAccount и DepositAccount.
Реализуйте методы классов, при необходимости переопределите методы в наследниках так, чтобы выполнялись условия пополнения и снятия:
-BankAccount — пополнение и списание происходит без комиссии. Если передать в метод пополнения отрицательное значение, сумма на счёте не должна измениться. 
При попытке снять большую сумму, чем есть на счёте, сумма не списывается со счёта, сумма на счёте не изменяется.
-CardAccount — карточный счёт, в дополнение к условиям BankAccount — при снятии денег должна взиматься комиссия 1% от суммы списания. 
Пример: при попытке снять со счёта 100 рублей должен списаться 101 рубль.
-DepositAccount — депозитный расчётный счёт, в дополнение к условиям BankAccount — нельзя снимать деньги в течение одного месяца после последнего пополнения. 
Переменную, в которой хранится дата последнего внесения, назовите lastIncome. Тип переменной используйте Calendar или LocalDate.


 
Критерии оценки:
«Зачёт» — реализованы методы классов согласно условию, все тесты выполняются успешно.
«На доработку» — задание не выполнено.


Дополнительное задание*

Цель задания:
Потренироваться в написании взаимодействия между классами.

Что нужно сделать:
Напишите метод в классе BankAccount:
-boolean send(BankAccount receiver, double amount)
для отправки денег с одного счёта на другой. Метод должен вернуть true, если деньги успешно переведены.
- 💡 вы можете добавить возврат boolena у метода take() для отслеживания, успешно ли списались деньги (true) или нет (false)

Критерии оценки:
«Зачёт» — метод send() передаёт деньги между счетами с учётом комиссий и ограничений.
«На доработку» — задание не выполнено.


