import formulas.FormulaForBmw;
import formulas.FormulaForSkoda;
import formulas.FormulaForToyota;
import formulas.FormulaForVolvo;

public class Formula {

    public Formula(String vehicleType) {
        VehicleTypes.getListOfVehicles().forEach(vehicle -> {
            switch (vehicle.name) {
                case "Bmw":
                    new FormulaForBmw(vehicleType);
                    break;
                case "Skoda":
                    new FormulaForSkoda(vehicleType);
                    break;
                case "Toyota":
                    new FormulaForToyota(vehicleType);
                    break;
                case "Volvo":
                    new FormulaForVolvo(vehicleType);
                    break;
                default:
                    throw new IllegalArgumentException("Неверный пункт");

            }
        });
    }

}
