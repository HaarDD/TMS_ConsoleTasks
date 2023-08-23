package lesson7.clinic.types;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class DoctorType {

    private static final List<DoctorType> doctorTypes = new ArrayList<>();

    private String typeName;

    public DoctorType(String typeName) {
        this.typeName = typeName;
    }

    public static void addDoctorType(DoctorType doctorType) {
        doctorTypes.add(doctorType);
    }

    public static void addDoctorType(DoctorType... doctorTypes) {
        for (DoctorType doctorType : doctorTypes) {
            addDoctorType(doctorType);
        }
    }

    public static DoctorType findDoctorTypeByName(String typeName) {
        Optional<DoctorType> foundDoctorType = doctorTypes.stream().filter(doctorType -> doctorType.getTypeName().equals(typeName)).findFirst();
        return foundDoctorType.orElse(null);
    }

    public String getTypeName() {
        return typeName;
    }

    public void setTypeName(String typeName) {
        this.typeName = typeName;
    }

    @Override
    public String toString() {
        return this.typeName;
    }
}
