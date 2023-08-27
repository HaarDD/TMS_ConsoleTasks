package lesson7.clinic.persons.doctors;

import base.ConsoleUtil;
import lesson7.clinic.objects.TreatmentPlan;
import lesson7.clinic.persons.Doctor;

public class Dantist extends Doctor {


    public Dantist(String surname, String name, String patronymic, String... diagnosesNameList) {
        super(surname, name, patronymic, diagnosesNameList);
    }

    @Override
    public void startTreatment(TreatmentPlan treatmentPlan) {
        super.startTreatment(treatmentPlan);
        ConsoleUtil.println("Дантист лечит");
    }

}
