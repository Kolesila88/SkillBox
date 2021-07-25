package storage;

import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.TreeSet;

public class CoolNumbersStorage {

  private final List<String> numbersList;
  private final Set<String> numbersTreeSet;
  private final Set<String> numbersHashSet;

  private CoolNumbersStorage(List<String> numbersList) {
    this.numbersList = numbersList;
    Collections.sort(numbersList);
    this.numbersTreeSet = new TreeSet<>(numbersList);
    this.numbersHashSet = new HashSet<>(numbersList);
  }

  public static CoolNumbersStorage getStorage(List<String> numbersList) {

    return new CoolNumbersStorage(numbersList);
  }

  public List<String> getNumbersList() {
    return numbersList;
  }

  public Set<String> getNumbersTreeSet() {
    return numbersTreeSet;
  }

  public Set<String> getNumbersHashSet() {
    return numbersHashSet;
  }
}
