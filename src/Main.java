import java.util.Random;

public class Main {
    public static void main(String[] args) {
        Random random = new Random(System.currentTimeMillis());
        PlaneBuilder planeBuilder = new PlaneBuilder();
        for (int i=0;i<7;i++){
            planeBuilder.addFirstClassPassenger(new FirstClassPassenger(random.nextInt(56)+5));
        }
        for (int i=0;i<21;i++){
            planeBuilder.addBusinessPassenger(new BusinessPassenger(random.nextInt(31)+5));
        }
        for (int i=0;i<151;i++){
            planeBuilder.addEconomyPassenger(new EconomyPassenger(random.nextInt(16)+5));
        }
        planeBuilder.addPilot(new Pilot(0)).addSteward(new Steward(0)).addSteward(new Steward(0));
        Airplane plane = planeBuilder.build();
        plane.takeOff();
    }
}