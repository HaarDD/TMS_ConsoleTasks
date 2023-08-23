package lesson7;

import base.ConsoleUtil;
import base.Runnable;
import lesson7.clinic.Clinic;
import lesson7.clinic.persons.Doctor;
import lesson7.clinic.persons.Patient;
import lesson7.clinic.types.DiagnosisType;
import lesson7.clinic.types.DoctorType;

/*Задача 1:
Создать программу для имитации работы клиники. Пусть в клинике будет три врача:
хирург, терапевт и дантист. Каждый врач имеет метод «лечить», но каждый врач лечит
по-своему. Так же предусмотреть класс «Пациент» с полем «План лечения» и полем
«Доктор». Создать объект класса «Пациент» и добавить пациенту план лечения. У
терапевта создать метод, который будет назначать врача пациенту согласно плану
лечения:
Если план лечения имеет код 1 – назначить хирурга и выполнить метод лечить.
Если план лечения имеет код 2 – назначить дантиста и выполнить метод лечить.
Если план лечения имеет любой другой код – назначить терапевта и выполнить метод
лечить.*/
public class L7Task1 extends Runnable {

    public L7Task1() {
        super("Программа имитации работы клиники");
    }

    @Override
    public void run() {

        Clinic clinic = new Clinic("Клиника №1", "Пушкина, 1");

        clinic.addDoctors(new Doctor("Доктор", "Номер", "Один"),
                new Doctor("Доктор", "Номер", "Два", DoctorType.findDoctorTypeByName("Хирург")),
                new Doctor("Доктор", "Номер", "Три", DoctorType.findDoctorTypeByName("Дантист")));

        clinic.addPatients(new Patient("Иванов", "Иван", "Иванович"),
                new Patient("Сергеев", "Сергей", "Сергеевич"),
                new Patient("Артемов", "Артем", "Артемович"));

        ConsoleUtil.printLineDelimiter();
        ConsoleUtil.println("До назначения планов лечения");
        ConsoleUtil.printLineDelimiter();
        ConsoleUtil.println(clinic.clinicStatusToString());

        //Назначение плана лечения (без указания диагноза он назначается автоматически, как бы для его уточнения)
        clinic.patientSetTreatment("Иванов", "Иван");
        //Назначение плана лечения с указанием типа болезни
        clinic.patientSetTreatment("Сергеев", "Сергей", DiagnosisType.findDiagnosisTypeByName("Сколиоз"));
        clinic.patientSetTreatment("Артемов", "Артем", DiagnosisType.findDiagnosisTypeByName("Кариес"));

        ConsoleUtil.printLineDelimiter();
        ConsoleUtil.println("После назначения планов лечения");
        ConsoleUtil.printLineDelimiter();
        ConsoleUtil.println(clinic.clinicStatusToString());
    }

}
