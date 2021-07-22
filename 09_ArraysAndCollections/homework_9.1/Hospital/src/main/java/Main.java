public class Main {

  public static void main(String[] args) {

    float[] patientsCount = Hospital.generatePatientsTemperatures(30);
    System.out.println(Hospital.getReport(patientsCount));
  }
}
