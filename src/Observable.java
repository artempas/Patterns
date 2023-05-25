
public interface Observable {

    void addObserver(Observer observer);
    boolean removeObserver(Observer observer);
    void notifyObservers();
}
