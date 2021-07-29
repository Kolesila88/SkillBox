import ru.lakeev.customerlist.exceptions.CommandException;
import ru.lakeev.customerlist.exceptions.CustomerException;
import ru.lakeev.customerlist.model.Customer;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import ru.lakeev.customerlist.storage.CustomerStorage;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

@DisplayName("Проверка выброса исключений")
public class ExceptionTests {

  private CustomerStorage storage;

  @BeforeEach
  void beforeEach() {
    storage = new CustomerStorage();
  }

  @Test
  @DisplayName("Передано более 4 слов в строке")
  void moreThenFourElementsInputString() {
    final String input = "Василий Петров vasily.petrov@gmail.com +79215637722 5слово";

    assertThrows(Throwable.class, () -> storage.addCustomer(input),
        "Не выброшено исключение при количестве элементов в строке больше 4");
  }

  @Test
  @DisplayName("Передано менее 4 слов в строке")
  void lessThanFourElementsInputString() {
    final String input = "Василий Петров vasily.petrov@gmail.com";
    assertThrows(Throwable.class, () -> storage.addCustomer(input),
        "Не выброшено исключение при количестве элементов в строке меньше 4");
  }

  @Test
  @DisplayName("Неверный формат email")
  void wrongEmailFormatWithoutAt() {
    final String wrongEmail = "thisIsNotAnEmail";
    final String input = "Василий Петров " + wrongEmail + " +79215637722";

    assertThrows(Throwable.class, () -> storage.addCustomer(input),
        "Не выброшено исключение при неверном формате email -> " + wrongEmail);
  }

  @Test
  @DisplayName("Неверный формат номера")
  void wrongPhoneFormatWithoutDigits() {
    final String wrongPhoneNumber = "+thisIsNotANumber";
    final String input = "Василий Петров hello@skillbox.ru " + wrongPhoneNumber;

    assertThrows(Throwable.class, () -> storage.addCustomer(input),
        "Не выброшено исключение при неверном формате номера -> " + wrongPhoneNumber);
  }

  /**
   * Ввод некорректного имени не был покрыт тестами.
   */
  @Test
  @DisplayName("Неверный формат имени")
  void wrongNameFormat() {
    final String wrongName = "thisIsNotName";
    final String input = wrongName.concat(" hello@skillbox.ru").concat(" +79215637722");

    assertThrows(Throwable.class, () -> storage.addCustomer(input),
        "Не выброшено исключение при неверном формате имени -> " + wrongName);
  }


  @Test
  @DisplayName("Тест добавления корректных данных ru.lakeev.customerlist.model.Customer")
  void insertCorrectData() throws CommandException, CustomerException {
    final String name = "Василий Петров";
    final String email = "hello@skillbox.ru";
    final String phone = "+79991234567";
    final String input = String.join(" ", name, email, phone);

    storage.addCustomer(input);
    assertEquals(1, storage.getCount());

    Customer customer = storage.getCustomer(name);
    assertEquals(name, customer.getName());
    assertEquals(email, customer.getEmail());
    assertEquals(phone, customer.getPhone());
  }
}
