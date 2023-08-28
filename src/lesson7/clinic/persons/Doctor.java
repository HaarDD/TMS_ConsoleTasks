package lesson7.clinic.persons;

import lesson7.clinic.objects.TreatmentPlan;

import java.util.ArrayList;
import java.util.List;

public class Doctor extends Person {

    private List<String> diagnosesNameList;

    private boolean isBusy;

    {
        isBusy = false;
        diagnosesNameList = new ArrayList<>();
    }

    public Doctor(String surname, String name, String patronymic, String... diagnosesNameList) {
        super(surname, name, patronymic);
        this.diagnosesNameList.addAll(List.of(diagnosesNameList));
    }

    public boolean findDiagnosis(String diagnosisName) {
        return diagnosesNameList.stream().anyMatch(diagnosis -> diagnosis.equals(diagnosisName));
    }

    public boolean isBusy() {
        return isBusy;
    }

    public void startTreatment(TreatmentPlan treatmentPlan) {
        this.isBusy = true;
    }

    public void endTreatment() {
        this.isBusy = false;
    }

    @Override
    public String toString() {
        return "(" + super.toString() + " Тип: " + this.getClass().getSimpleName() + "; Лечит сейчас: " + (isBusy ? "Да" : "Нет") + ")";
    }
}
