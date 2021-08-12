
The purpose of the assignment:
Learn to work with synchronized blocks and avoid deadlocks.

Job Condition:

	-Project Transactions in the 15_Multithreading module directory.
	-The bank (class Bank) has accounts (class Account) with two fields - money and accNumber.
	-All accounts are kept inside the bank. Many bank customers can simultaneously transfer money between accounts and request a balance on their account.
 	Everything happens in a highly concurrent (multi-threaded) environment.
	-In this case, transactions for amounts> 50,000 are sent for verification to the security service. 
	We can assume that such transactions are no more than 5% of all. 
	A separate and already implemented method Bank.isFraud () is responsible for checking.
	-The security service cannot process more than one transaction at a time. The check takes 1000 ms.
	-If the security service detects fraud, it is necessary to block both accounts, that is, to prohibit any changes in the balances in the future.

What should be done:
	-Create a transfer () method of the Bank class that transfers money from one account to another. 
	If the transaction amount is> 50,000, the transaction is sent for verification to the security service: the isFraud () method is called. 
	If true is returned, then the accounts are blocked (whatever is at your discretion).
	-Create a getBalance method of the Bank class that returns the account balance for the passed account number string.

Recommendations:
	-To solve the problem, you can modify the Account and Bank classes as you like.
	-Additionally, create a test (or test suite) to emulate the real work of these two classes and validate the system.
	-Check the amount in bank accounts before starting transactions and after completion - the amount in the bank should not change.
	-Make sure your program is multithreaded. For this you can use the visualVM utility.

Criteria for evaluation:
"Test" - the program allows banking transactions to work in a multithreaded environment without "loss" of money in the bank and deadlock situations.
"Failed" - the task has not been completed.

===========================================================================================================================================================================

Цель задания:
Научиться работать с synchronized блоками и избегать ситуации deadlock.

Условие задания:
	-Проект Transactions в директории модуля 15_Multithreading. 
	-В банке (класс Bank) есть счета (класс Account) с двумя полями — money и accNumber.
	-Все счета хранятся внутри банка. Множество клиентов банка могут одновременно переводить деньги между счетами и запрашивать баланс по своему счёту. 
	Всё происходит в highly concurrent (многопоточной) среде.
	-При этом транзакции на суммы > 50000 отправляются на проверку в службу безопасности. 
	Можно считать, что таких транзакций не более 5% от всех. За проверку отвечает отдельный и уже реализованный метод Bank.isFraud().
	-Служба безопасности не может обрабатывать более одной транзакции одновременно. Проверка занимает 1000 мс.
	-Если служба безопасности обнаружила мошенничество, необходимо заблокировать оба счёта, то есть запретить любые изменения остатков в дальнейшем.

Что нужно сделать:
	-Создайте метод transfer() класса Bank, который переводит деньги с одного счёта на другой. 
	Если сумма транзакции > 50000 — транзакция отправляется на проверку службе безопасности: вызывается метод isFraud(). 
	Если возвращается true, то счета блокируются (как – на ваше усмотрение).
	-Создайте метод getBalance класса Bank, который возвращает остаток на счёте по переданной строке номера аккаунта.

Рекомендации:
	-Для решения задачи вы можете дорабатывать классы Account и Bank как угодно. 
	-Дополнительно создайте тест (или набор тестов) для эмуляции реальной работы этих двух классов и проверки системы. 
	-Проверяйте сумму на банковских счетах до запуска транзакций и после завершения — сумма в банке не должна измениться.
	-Удостоверьтесь, что ваша программа работает в многопоточном режиме. Для этого можете использовать утилиту visualVM.

Критерии оценки:
«Зачёт» — программа позволяет в многопоточной среде работать банковским транзакциям без «потери» денег в банке и ситуаций deadlock.
«Незачёт» — задание не выполнено.