package lesson7.clinic.objects;

import lesson7.clinic.persons.Doctor;
import lesson7.clinic.types.DiagnosisType;

public class TreatmentPlan {

    private DiagnosisType diagnosisType;
    private Doctor treatmentDoctor;

    {
        this.diagnosisType = null;
    }

    public TreatmentPlan(Doctor treatmentDoctor) {
        this.treatmentDoctor = treatmentDoctor;
    }

    public TreatmentPlan(DiagnosisType diagnosisType, Doctor treatmentDoctor) {
        this.diagnosisType = diagnosisType;
        this.treatmentDoctor = treatmentDoctor;
    }

    public Doctor getTreatmentDoctor() {
        return treatmentDoctor;
    }

    public void setTreatmentDoctor(Doctor treatmentDoctor) {
        this.treatmentDoctor = treatmentDoctor;
    }

    public DiagnosisType getDiagnosisType() {
        return diagnosisType;
    }

    public void setDiagnosisType(DiagnosisType diagnosisType) {
        this.diagnosisType = diagnosisType;
    }

    @Override
    public String toString() {
        return "(" + "Лечащий врач:" + treatmentDoctor + " Диагноз: " + (diagnosisType != null ? diagnosisType.getTypeName() : "Не определен") + ")";
    }
}
