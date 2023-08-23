package lesson7.clinic;

import lesson7.clinic.objects.TreatmentPlan;
import lesson7.clinic.persons.Doctor;
import lesson7.clinic.persons.Patient;
import lesson7.clinic.types.DiagnosisType;
import lesson7.clinic.types.DoctorType;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.Optional;

public class Clinic {


    private List<Doctor> doctorList = new ArrayList<>();

    private List<Patient> patientList = new ArrayList<>();
    private String clinicName;
    private String address;

    {
        DoctorType.addDoctorType(new DoctorType("Хирург"), new DoctorType("Дантист"), new DoctorType("Терапевт"));

        DiagnosisType.addDiagnosisType(new DiagnosisType("Сколиоз", DoctorType.findDoctorTypeByName("Хирург")),
                new DiagnosisType("Простуда", DoctorType.findDoctorTypeByName("Терапевт")),
                new DiagnosisType("Кариес", DoctorType.findDoctorTypeByName("Дантист")));
    }

    public Clinic(String clinicName, String address) {
        this.clinicName = clinicName;
        this.address = address;
    }

    private void addPatient(Patient patient) {
        this.patientList.add(patient);
    }

    public void addPatients(Patient... patients) {
        for (Patient patient : patients) {
            addPatient(patient);
        }
    }

    private void addDoctor(Doctor doctor) {
        this.doctorList.add(doctor);
    }

    public void addDoctors(Doctor... doctors) {
        for (Doctor doctor : doctors) {
            addDoctor(doctor);
        }
    }

    //Назначить паценту план лечения, диагноз неизвестен. Терапевт назначается автоматически
    public void patientSetTreatment(String patientSurname, String patientName) {
        patientSetTreatmentBase(patientSurname, patientName, null);
    }

    //Назначить паценту план лечения, диагноз известен. Назначается свободный врач (isBusy) с нужным типом (определяется по диагнозу)
    public void patientSetTreatment(String patientSurname, String patientName, DiagnosisType diagnosisType) {
        patientSetTreatmentBase(patientSurname, patientName, diagnosisType);
    }

    public void patientSetTreatmentBase(String patientSurname, String patientName, DiagnosisType diagnosisType) {
        Patient foundPatient = findPatientBySurnameName(patientSurname, patientName);
        if (foundPatient != null) {
            if (diagnosisType != null) {
                Doctor foundDoctor = findFreeDoctorByType(diagnosisType.getDoctorType());
                foundPatient.setTreatmentPlan(new TreatmentPlan(diagnosisType, foundDoctor));
                foundDoctor.setBusy();
            } else {
                Doctor foundDoctor = findFreeDoctorByType(DoctorType.findDoctorTypeByName("Терапевт"));
                foundPatient.setTreatmentPlan(new TreatmentPlan(foundDoctor));
                foundDoctor.setBusy();
            }
        }
    }

    //Найти пациента по фамилии и имени
    private Patient findPatientBySurnameName(String patientSurname, String patientName) {
        Optional<Patient> foundDoctorType = patientList.stream().filter(patient
                -> patient.getSurname().equals(patientSurname) && patient.getName().equals(patientName)).findFirst();
        return foundDoctorType.orElse(null);
    }

    //Найти свободного доктора по типу
    private Doctor findFreeDoctorByType(DoctorType doctorType) {
        Optional<Doctor> foundDoctor = doctorList.stream().filter(doctor
                -> Objects.equals(doctor.getDoctorType().getTypeName(), doctorType.getTypeName())
                && !doctor.isBusy()).findFirst();
        return foundDoctor.orElse(null);
    }

    public String getPatientListString() {
        return this.patientList.toString();
    }

    public String getDoctorsListString() {
        return this.doctorList.toString();
    }

    public String clinicStatusToString() {
        StringBuilder result = new StringBuilder();
        result.append("Название клиники: ").append(clinicName);
        result.append("\nАдрес: ").append(address);
        result.append("\nСписок докторов");
        for (Doctor doctor : doctorList) {
            result.append("\n").append(doctor);
        }
        result.append("\nСписок пациентов");
        for (Patient patient : patientList) {
            result.append("\n").append(patient);
        }

        return result.toString();
    }


}
