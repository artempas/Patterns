public class Pilot implements PassengerComposite {
    private int luggageWeight;
    Pilot(int luggageWeight) throws IllegalArgumentException{
        if (luggageWeight>0){
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
