package lesson7.clinic.persons.doctors;

import base.ConsoleUtil;
import lesson7.clinic.Clinic;
import lesson7.clinic.objects.TreatmentPlan;
import lesson7.clinic.persons.Doctor;

public class Therapist extends Doctor {


    public Therapist(String surname, String name, String patronymic, String... diagnosesNameList) {
        super(surname, name, patronymic, diagnosesNameList);
    }


    //по условию задания сказано, что терапевт должен содержать метод назначения врача в зависимости от плана лечения (и себя в частности)
    @Override
    public void startTreatment(TreatmentPlan treatmentPlan) {
        if (!findDiagnosis(treatmentPlan.getDiagnosisName())) {
            Doctor newTreatmentDoctor = Clinic.findDoctorByDiagnosisName(treatmentPlan.getDiagnosisName());
            if (newTreatmentDoctor != null) {
                treatmentPlan.setTreatmentDoctor(newTreatmentDoctor);
                newTreatmentDoctor.startTreatment(treatmentPlan);
                super.endTreatment();
                return;
            }
        }
        super.startTreatment(treatmentPlan);
        ConsoleUtil.println("Терапевт лечит");
    }


}
