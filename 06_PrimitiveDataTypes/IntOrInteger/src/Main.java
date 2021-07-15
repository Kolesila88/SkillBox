public class Main {

  //Максимальное значение кода символа
  private static final int CHAR_CODE_MAX_VALUE = 65536;
  //Шаблон диапазона искомых символов
  private static final String requiredPattern = "[А-Яа-яЁё]";

  public static void main(String[] args) {
    Container container = new Container();
    container.addCount(5672);
    System.out.println(container.getCount());

    // TODO: ниже напишите код для выполнения задания:
    //  С помощью цикла и преобразования чисел в символы найдите все коды
    //  букв русского алфавита — заглавных и строчных, в том числе буквы Ё.

    //Запуск цикла в котором i соттветствует коду символа
    for (int i = 0; i < CHAR_CODE_MAX_VALUE; i++) {

      //Приводим код символа к символу
      char c = (char) i;

      //Сравниваем символ с шаблоном в случае совпадения, печатаем код символа и символ в консоль.
      if (String.valueOf(c).matches(requiredPattern)) {
        System.out.println(i + "-" + c);
      }
    }
  }
}
