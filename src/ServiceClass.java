import java.util.ArrayList;

public class ServiceClass implements PassengerComposite {
    private ArrayList<PassengerComposite> passengers;
    private int passengersQuota;
    ServiceClass(int passengersQuota){
        this.passengers= new ArrayList<>();
        this.passengersQuota=passengersQuota;
    }
    boolean addPassenger(PassengerComposite passenger){
        if (this.totalPassengers()+passenger.totalPassengers()>this.passengersQuota){
            return false;
        }
        else {
            this.passengers.add(passenger);
            return true;
        }
    }

    @Override
    public int getWeight() {
        int total=0;
        for (PassengerComposite passenger:
             this.passengers) {
            total+=passenger.getWeight();
        }
        return total;
    }

    @Override
    public int reduceWeight(int reduceBy) {
        int totalReduced=0;
        for (PassengerComposite passenger: this.passengers) {
            totalReduced+=passenger.reduceWeight(reduceBy-totalReduced);
            if (totalReduced>=reduceBy)
                break;
        }
        return totalReduced;
    }

    @Override
    public int totalPassengers() {
        int total = 0;
        for (PassengerComposite passenger : this.passengers) {
            total += passenger.totalPassengers();
        }
        if (total!=this.passengers.size()){
            System.out.format("totalPassengers = %d size = %d", total, this.passengers.size());
        }
        return total;
    }
}
