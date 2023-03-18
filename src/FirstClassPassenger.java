public class FirstClassPassenger implements PassengerComposite {

    private int luggageWeight;
    FirstClassPassenger(int luggageWeight) throws IllegalArgumentException{
        if (5>luggageWeight || luggageWeight>60){
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
