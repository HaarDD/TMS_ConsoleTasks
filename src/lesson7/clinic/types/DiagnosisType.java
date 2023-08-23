package lesson7.clinic.types;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class DiagnosisType {

    private static List<DiagnosisType> diagnosisTypeList = new ArrayList<>();
    private String typeName;
    private DoctorType doctorType;

    public DiagnosisType(String typeName, DoctorType doctorType) {
        this.typeName = typeName;
        this.doctorType = doctorType;
    }

    public static void addDiagnosisType(DiagnosisType diagnosisType) {
        diagnosisTypeList.add(diagnosisType);
    }

    public static void addDiagnosisType(DiagnosisType... diagnosisTypes) {
        for (DiagnosisType diagnosisType : diagnosisTypes) {
            addDiagnosisType(diagnosisType);
        }
    }

    public static DiagnosisType findDiagnosisTypeByName(String typeName) {
        Optional<DiagnosisType> foundDoctorType = diagnosisTypeList.stream().filter(diagnosisType -> diagnosisType.getTypeName().equals(typeName)).findFirst();
        return foundDoctorType.orElse(null);
    }

    public String getTypeName() {
        return typeName;
    }

    public void setTypeName(String typeName) {
        this.typeName = typeName;
    }

    public DoctorType getDoctorType() {
        return doctorType;
    }

    public void setDoctorType(DoctorType doctorType) {
        this.doctorType = doctorType;
    }

    @Override
    public String toString() {
        return "Диагноз:\tНазвание - " + this.typeName + "\tТип доктора: " + this.doctorType.getTypeName();
    }
}
