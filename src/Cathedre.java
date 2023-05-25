import java.util.ArrayList;

public class Cathedre implements Observer{
    Cathedre(){}
    @Override
    public void update(Object notMadeReport) {
        ArrayList<String> teachers = (ArrayList<String>) notMadeReport;
        for (String teacher: teachers){
            System.out.println("Кафедра узнала о том, что преподаватель "+teacher+" не сдал отчёт");
        }
    }
}
