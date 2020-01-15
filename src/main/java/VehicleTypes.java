import lombok.AllArgsConstructor;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

@AllArgsConstructor
public enum VehicleTypes {

    VEHICLE1("Седельный тягач T, C, K 4х2 или 4х4");

    String name;

    public static List<VehicleTypes> getListOfVehicles() {
        return Stream.of(VehicleTypes.values()).collect(Collectors.toList());
    }
}
