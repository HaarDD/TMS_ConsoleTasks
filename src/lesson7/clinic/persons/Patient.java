package lesson7.clinic.persons;

import lesson7.clinic.objects.TreatmentPlan;

public class Patient extends Person {


    private TreatmentPlan treatmentPlan;

    {
        treatmentPlan = null;
    }

    public Patient(String surname, String name, String patronymic) {
        super(surname, name, patronymic);
    }

    public void setTreatmentPlan(TreatmentPlan treatmentPlan) {

        this.treatmentPlan = treatmentPlan;
    }

    @Override
    public String toString() {
        return "(" + super.toString() + " План лечения: " + (treatmentPlan != null ? treatmentPlan : "Отсутствует") + ")";
    }

}