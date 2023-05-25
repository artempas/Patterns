import java.util.ArrayList;
import java.util.Arrays;

public class main {
    public static void main(String[] args) {
        Cathedre cathedre = new Cathedre();
        DeanOffice deanOffice = new DeanOffice(new ArrayList<>(Arrays.asList("Teacher 1", "Teacher 2", "Teacher 3")));
        deanOffice.addObserver(cathedre);
        Teacher teacher1=new Teacher("Teacher 1");
        Teacher teacher2 = new Teacher("Teacher 2");
        Teacher teacher3 = new Teacher("Teacher 3");
        teacher1.addObserver(deanOffice);
        teacher2.addObserver(deanOffice);
        teacher3.addObserver(deanOffice);
        teacher1.createReport();
        teacher3.createReport();
        deanOffice.timeHasCome();
    }
}
