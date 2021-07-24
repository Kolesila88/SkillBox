import emumirations.Command;
import executor.CommandExecutor;
import input.Input;
import emumirations.Message;

public class Main {
    /* TODO:
        Пример вывода списка Email, после ввода команды LIST в консоль:
        test@test.com
        hello@mail.ru
        - каждый адрес с новой строки
        - список должен быть отсортирован по алфавиту
        - email в разных регистрах считается одинаковыми
           hello@skillbox.ru == HeLLO@SKILLbox.RU
        - вывод на печать должен быть в нижнем регистре
           hello@skillbox.ru
        Пример вывода сообщения об ошибке при неверном формате Email:
        "Неверный формат email"
    */

    private static final CommandExecutor executor = CommandExecutor.getInstance();

    public static void main(String[] args) {
        System.out.println(Message.COMMAND_LIST.getMsg());
        while (true) {

            String input = Input.getInstance().nextLine();

            if (input.equals(Command.EXIT.getCmd())) {

                System.out.println(Message.EXIT_MSG.getMsg());
                break;
            }
            //TODO: write code here
            executor.execute(input);
        }
    }
}
