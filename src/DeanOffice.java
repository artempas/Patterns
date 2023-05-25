import java.util.ArrayList;

public class DeanOffice implements Observer, Observable {
    private final ArrayList<String> teachers;
    private final ArrayList<Observer> observers;
    private final ArrayList<Teacher> madeReport;
    private ArrayList<String> notMadeReport;
    DeanOffice(ArrayList<String> allTeachers){
        madeReport=new ArrayList<>();
        teachers=allTeachers;
        observers = new ArrayList<>();
    }

    @Override
    public void update(Object o) {
        Teacher teacher = (Teacher) o;
        if (teacher.hasReport()){
            madeReport.add(teacher);
        }
    }
    public void timeHasCome(){
        notMadeReport=new ArrayList<>(teachers);
        for (Teacher teacher: madeReport){
            notMadeReport.remove(teacher.FIO);
        }
        for (String teacher:notMadeReport)
            System.out.println("Деканат узнал о том, что преподаватель "+teacher+" не сдал отчёт");
        notifyObservers();
    }

    @Override
    public void addObserver(Observer observer) {
        observers.add(observer);
    }

    @Override
    public boolean removeObserver(Observer observer) {
        return observers.remove(observer);
    }

    @Override
    public void notifyObservers() {
        for (Observer observer:observers){
            observer.update(notMadeReport);
        }
    }
}
