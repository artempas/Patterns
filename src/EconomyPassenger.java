public class EconomyPassenger implements PassengerComposite {

    private int luggageWeight;
    EconomyPassenger(int luggageWeight) throws IllegalArgumentException{
        if (5>luggageWeight || luggageWeight>20){
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
        int weightTookOff=this.luggageWeight;
        this.luggageWeight=0;
        System.out.format("I'm economy passenger and my %dkg luggage was left behind\n", weightTookOff);
        return weightTookOff;
    }

    @Override
    public int totalPassengers() {
        return 1;
    }
}
