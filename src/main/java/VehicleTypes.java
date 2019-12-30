import lombok.AllArgsConstructor;
import lombok.Data;

import java.awt.*;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

@AllArgsConstructor
public enum VehicleTypes {

    VOLVO("Volvo", Color.lightGray),
    BMW("Bmw", Color.blue),
    SKODA("Skoda", Color.cyan),
    TOYOTA("Toyota", Color.orange);


    String name;
    Color color;

    public static List<VehicleTypes> getListOfVehicles() {
        return Stream.of(VehicleTypes.values()).collect(Collectors.toList());
    }
}
