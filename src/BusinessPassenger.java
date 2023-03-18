public class BusinessPassenger implements PassengerComposite {

    private int luggageWeight;
    BusinessPassenger(int luggageWeight) throws IllegalArgumentException{
        if (5>luggageWeight || luggageWeight>35){
            throw new IllegalArgumentException("Too light or overweight luggage");
        }
        this.luggageWeight=luggageWeight;
    }

    @Override
    public int getWeight() {
        return this.luggageWeight;
    }

    @Override
    public int reduceWeight(int reduceBy) {
        return 0;
    }

    @Override
    public int totalPassengers() {
        return 1;
    }
}
