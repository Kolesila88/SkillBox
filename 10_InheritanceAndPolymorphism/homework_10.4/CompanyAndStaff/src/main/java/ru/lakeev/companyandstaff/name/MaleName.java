package ru.lakeev.companyandstaff.name;

public enum MaleName {
  MALE_NAME_0("Артём"),
  MALE_NAME_1("Артемий"),
  MALE_NAME_2("Александр"),
  MALE_NAME_3("Максим"),
  MALE_NAME_4("Даниил"),
  MALE_NAME_5("Данил"),
  MALE_NAME_6("Данила"),
  MALE_NAME_7("Дмитрий"),
  MALE_NAME_8("Димитрий"),
  MALE_NAME_9("Иван"),
  MALE_NAME_10("Кирилл"),
  MALE_NAME_11("Никита"),
  MALE_NAME_12("Михаил"),
  MALE_NAME_13("Егор"),
  MALE_NAME_14("Егорий"),
  MALE_NAME_15("Матвей"),
  MALE_NAME_16("Андрей"),
  MALE_NAME_17("Илья"),
  MALE_NAME_18("Алексей"),
  MALE_NAME_19("Роман"),
  MALE_NAME_20("Сергей"),
  MALE_NAME_21("Владислав"),
  MALE_NAME_22("Ярослав"),
  MALE_NAME_23("Тимофей"),
  MALE_NAME_24("Арсений"),
  MALE_NAME_25("Арсентий"),
  MALE_NAME_26("Денис"),
  MALE_NAME_27("Владимир"),
  MALE_NAME_28("Павел"),
  MALE_NAME_29("Глеб"),
  MALE_NAME_30("Константин"),
  MALE_NAME_31("Богдан"),
  MALE_NAME_32("Евгений"),
  MALE_NAME_33("Николай"),
  MALE_NAME_34("Степан"),
  MALE_NAME_35("Захар"),
  MALE_NAME_36("Тимур"),
  MALE_NAME_37("Марк"),
  MALE_NAME_38("Семён"),
  MALE_NAME_39("Фёдор"),
  MALE_NAME_40("Георгий"),
  MALE_NAME_41("Лев"),
  MALE_NAME_42("Антон"),
  MALE_NAME_43("Антоний"),
  MALE_NAME_44("Вадим"),
  MALE_NAME_45("Игорь"),
  MALE_NAME_46("Руслан"),
  MALE_NAME_47("Вячеслав"),
  MALE_NAME_48("Григорий"),
  MALE_NAME_49("Макар"),
  MALE_NAME_50("Артур"),
  MALE_NAME_51("Виктор"),
  MALE_NAME_52("Станислав"),
  MALE_NAME_53("Савелий"),
  MALE_NAME_54("Олег"),
  MALE_NAME_55("Давид"),
  MALE_NAME_56("Давыд"),
  MALE_NAME_57("Леонид"),
  MALE_NAME_58("Пётр"),
  MALE_NAME_59("Юрий"),
  MALE_NAME_60("Виталий"),
  MALE_NAME_61("Мирон"),
  MALE_NAME_62("Василий"),
  MALE_NAME_63("Всеволод"),
  MALE_NAME_64("Елисей"),
  MALE_NAME_65("Назар"),
  MALE_NAME_66("Родион"),
  MALE_NAME_67("Марат"),
  MALE_NAME_68("Платон"),
  MALE_NAME_69("Герман"),
  MALE_NAME_70("Игнат"),
  MALE_NAME_71("Игнатий"),
  MALE_NAME_72("Святослав"),
  MALE_NAME_73("Анатолий"),
  MALE_NAME_74("Тихон"),
  MALE_NAME_75("Валерий"),
  MALE_NAME_76("Мирослав"),
  MALE_NAME_77("Ростислав"),
  MALE_NAME_78("Борис"),
  MALE_NAME_79("Филипп"),
  MALE_NAME_80("Демьян"),
  MALE_NAME_81("Клим"),
  MALE_NAME_82("Климент"),
  MALE_NAME_83("Гордей"),
  MALE_NAME_84("Валентин"),
  MALE_NAME_85("Геннадий"),
  MALE_NAME_86("Демид"),
  MALE_NAME_87("Диомид"),
  MALE_NAME_88("Прохор"),
  MALE_NAME_89("Серафим"),
  MALE_NAME_90("Савва"),
  MALE_NAME_91("Яромир"),
  MALE_NAME_92("Аркадий"),
  MALE_NAME_93("Архип"),
  MALE_NAME_94("Тарас"),
  MALE_NAME_95("Трофим");

  private String name;

  MaleName(String name) {

    this.name = name;
  }

  public String getName() {

    return name;
  }

  public static String getMaleName() {

    return values()[(int) (Math.random() * values().length)].getName();
  }
}
