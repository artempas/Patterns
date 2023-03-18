public class PlaneBuilder {
    private Airplane plane;
    private ServiceClass firstClass;
    private ServiceClass businessClass;
    private ServiceClass economyClass;
    private Pilot pilot;
    private Steward[] stewards;
    PlaneBuilder(){
        this.plane = new Airplane(183, 10);
        this.stewards = new Steward[2];

        this.firstClass = new ServiceClass(10);
        this.businessClass = new ServiceClass(20);
        this.economyClass = new ServiceClass(150);
    }
    PlaneBuilder addPilot(Pilot pilot){
        this.pilot = pilot;
        return this;
    }
    PlaneBuilder addSteward(Steward steward){
        if (this.stewards[0]==null){
            this.stewards[0] = steward;
            return this;
        }
        if (this.stewards[1]==null){
            this.stewards[1]=steward;
            return this;
        }
        throw new IllegalArgumentException("Too much stewards");
    }
    PlaneBuilder addFirstClassPassenger(PassengerComposite passenger) {
        if (!this.firstClass.addPassenger(passenger))
            throw new IllegalArgumentException("First class is full");
        return this;
    }
    PlaneBuilder addBusinessPassenger(PassengerComposite passenger) {
        if (this.businessClass.addPassenger(passenger))
            return this;

        else {
            if (this.firstClass.addPassenger(passenger)) {
                System.out.println("Business was full so we put business passenger to 1st class");
                return this;
            } else
                throw new IllegalArgumentException("Business and first classes are full");
        }
    }
    PlaneBuilder addEconomyPassenger(PassengerComposite passenger){
        if(this.economyClass.addPassenger(passenger))
            return this;
        else {
            if (this.businessClass.addPassenger(passenger)){
                System.out.println("Economy was full so we put economy passenger to business class");
                return this;
            }
            else {
                if(this.firstClass.addPassenger(passenger)){
                    System.out.println("Economy and business was full so we put economy passenger to first class");
                    return this;
                }
                else
                    throw new IllegalArgumentException("Economy, business and first classes are full");
            }
        }
    }
    Airplane build(){
        this.plane.addPassengers(this.pilot);
        if (this.stewards[0]==null || this.stewards[1]==null)
            throw new IllegalArgumentException("Not enough stewards");
        this.plane.addPassengers(this.stewards[0]);
        this.plane.addPassengers(this.stewards[1]);
        this.plane.addPassengers(this.firstClass);
        this.plane.addPassengers(this.businessClass);
        this.plane.addPassengers(this.economyClass);
        return this.plane;
    }
}
