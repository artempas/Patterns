import java.util.ArrayList;

public class Airplane implements PassengerComposite {
    private final int passengersQuota;
    private final int luggageWeightQuota;
    private ArrayList<PassengerComposite> passengers;
    Airplane(int passengersQuota, int luggageWeightQuota){
        this.passengers = new ArrayList<>();
        this.passengersQuota=passengersQuota;
        this.luggageWeightQuota =luggageWeightQuota;
    }
    boolean addPassengers(PassengerComposite passenger){
        if (passenger.totalPassengers()+this.totalPassengers()>passengersQuota)
            return false;
        else{
            this.passengers.add(passenger);
            return true;
        }
    }
    boolean takeOff(){
        if (this.passengersQuota<=this.totalPassengers() && this.luggageWeightQuota <=this.getWeight()){
            System.out.format("Took off successfully. Weight %dKG/%dKG. Passengers %d/%d\n",
                    this.getWeight(), this.luggageWeightQuota,
                    this.totalPassengers(), this.passengersQuota);
            return true;
        }
        else{
            if (this.passengersQuota<this.totalPassengers())
                throw new IllegalArgumentException("Too much passengers");
            if (this.getWeight()>this.luggageWeightQuota){
                System.out.format("Luggage overweight (%dKG/%dKG)! Drop off started\n", this.getWeight(), this.luggageWeightQuota);
                int droppedOff=this.reduceWeight(this.getWeight()-this.luggageWeightQuota);
                if (this.getWeight()<this.luggageWeightQuota){
                    System.out.format("Took off successfully. Weight %dKG/%dKG. Passengers %d/%d. Dropped %dKG of luggage\n",
                            this.getWeight(), this.luggageWeightQuota,
                            this.totalPassengers(), this.passengersQuota,
                            droppedOff);
                    return true;
                }
                else{
                    System.out.format("Unable to take off! Dropped off %dKG. Airplane is still overweight (%dKG/%dKG)!", droppedOff, this.getWeight(), this.luggageWeightQuota);
                    return false;
                }
            }
            System.out.println("Can't be here");
            return false;
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

    public int totalPassengers() {
        int total = 0;
        for (var passenger : this.passengers) {
            total += passenger.totalPassengers();
        }

        return total;
    }
}
