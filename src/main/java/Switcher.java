import formulas.*;

public class Switcher {

    public Switcher(String vehicleType) {
        VehicleTypes.getListOfVehicles().forEach(vehicle -> {
            switch (vehicle.name) {
                case "Седельный тягач T, C, K 4х2 или 4х4":
                    new Vehicle1(vehicleType);
                    break;
                default:
                    throw new IllegalArgumentException("Неверный пункт");

            }
        });
    }

}
