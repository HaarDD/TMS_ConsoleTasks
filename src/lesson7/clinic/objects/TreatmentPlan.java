package lesson7.clinic.objects;

import lesson7.clinic.persons.Doctor;

public class TreatmentPlan {

    private String diagnosis;
    private Doctor treatmentDoctor;

    {
        this.diagnosis = null;
    }

    public TreatmentPlan(Doctor treatmentDoctor, String diagnosis) {
        this.diagnosis = diagnosis;
        this.treatmentDoctor = treatmentDoctor;
    }

    public Doctor getTreatmentDoctor() {
        return treatmentDoctor;
    }

    public void setTreatmentDoctor(Doctor treatmentDoctor) {
        this.treatmentDoctor = treatmentDoctor;
    }

    public String getDiagnosisName() {
        return diagnosis;
    }

    public void setDiagnosis(String diagnosis) {
        this.diagnosis = diagnosis;
    }

    @Override
    public String toString() {
        return "(" + "Лечащий врач:" + treatmentDoctor + " Диагноз: " + (diagnosis != null ? diagnosis : "Не определен") + ")";
    }
}
