package storage;

import emumirations.Command;
import input.Input;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import emumirations.Message;

public class EmailList {

  private Set<String> mailSet;

  public EmailList() {
    this.mailSet = new HashSet<>();
  }

  public void add(String email) {

    if (!mailSet.contains(email.toLowerCase())
        && email.matches("\\w+([\\.-]?\\w+)*@\\w+([\\.-]?\\w+)*\\.\\w{2,4}")) {
      /**
       * Checking the validity of the email was performed in the CommandExecutor class earlier,
       * additionally it is carried out here in order to successfully pass the tests.
       */
      mailSet.add(email.toLowerCase());
    }
  }

  public List<String> getSortedEmails() {

    List<String> mailList = new ArrayList<>(mailSet);
    Collections.sort(mailList);
    return mailList;
  }

  public void delete(String mail){

    if (mailSet.contains(mail.toLowerCase())) {

      mailSet.remove(mail);
    } else {


      System.out.println(Message.EMAIL_NOT_IN_SET.getMsg());
      String input = Input.getInstance().nextLine();

      if (input.equals(Command.YES.getCmd())){

        add(mail);
      } else if (!input.equals(Command.NOT.getCmd())) {

        System.out.println(Message.COMMAND_NOT_SUPPORTED);
      }
    }
  }

  public void clearSet(){

    System.out.println(Message.CONFIRMATION_MSG.getMsg());
    String input = Input.getInstance().nextLine();
    if (input.equals(Command.CLEAR.getCmd())){

      mailSet.clear();
    }
  }
}
