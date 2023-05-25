import java.util.*;

public class Teacher implements Observable{
    private final ArrayList<Observer> observers;
    private boolean report;
    public String FIO;
    public Teacher(String FIO) {
        observers = new ArrayList<>();
        this.FIO = FIO;
        report = false;
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
        for (Observer observer: observers)
            observer.update(this);
    }

    public void createReport() {
        System.out.println("Преподаватель " + FIO + " сделал отчёт");
        report = true;
        notifyObservers();
    }
    public boolean hasReport(){
        return report;
    }
}
