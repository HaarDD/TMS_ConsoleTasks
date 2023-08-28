package lesson7.clinic;

import base.ConsoleUtil;
import lesson7.clinic.objects.TreatmentPlan;
import lesson7.clinic.persons.Doctor;
import lesson7.clinic.persons.Patient;
import lesson7.clinic.persons.doctors.Therapist;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class Clinic {


    private static List<Doctor> doctorList;

    private final List<Patient> patientList;
    private final String clinicName;
    private final String address;

    {
        doctorList = new ArrayList<>();
        patientList = new ArrayList<>();
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
        doctorList.add(doctor);
    }

    public void addDoctors(Doctor... doctors) {
        for (Doctor doctor : doctors) {
            addDoctor(doctor);
        }
    }

    //Найти пациента по фамилии и имени
    public Patient findPatientBySurnameName(String patientSurname, String patientName) {
        Optional<Patient> foundDoctorType = patientList.stream().filter(patient
                -> patient.getSurname().equals(patientSurname) && patient.getName().equals(patientName)).findFirst();
        return foundDoctorType.orElse(null);
    }

    //Найти свободного доктора по диагнозу (список дигнозов у кажого доктора свой). Статический, т.к. его нужно вызывать в других классах (терапевт)
    public static Doctor findDoctorByDiagnosisName(String diagnosisName) {
        Optional<Doctor> foundDoctor = doctorList.stream()
                .filter(doctor -> doctor.findDiagnosis(diagnosisName) && !doctor.isBusy())
                .findFirst();
        return foundDoctor.orElse(null);
    }

    private static Therapist findFreeTherapist() {
        Optional<Doctor> foundDoctor = doctorList.stream()
                .filter(doctor -> doctor instanceof Therapist && !doctor.isBusy())
                .findFirst();
        return (Therapist) foundDoctor.orElse(null);
    }

    public void assignTreatmentPlan(Patient patient, String diagnosis) {
        if (patient == null) {
            ConsoleUtil.println("Пациента не существует");
            return;
        }
        Therapist freeTherapist = findFreeTherapist();
        if (freeTherapist != null) {
            TreatmentPlan treatmentPlan = new TreatmentPlan(freeTherapist, diagnosis);
            patient.setTreatmentPlan(treatmentPlan);
            freeTherapist.startTreatment(treatmentPlan);
        } else {
            ConsoleUtil.println("На данный момент все терапевты заняты");
        }

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
