package lesson7;

import base.ConsoleUtil;
import base.Runnable;
import lesson7.clinic.Clinic;
import lesson7.clinic.persons.Patient;
import lesson7.clinic.persons.doctors.Dantist;
import lesson7.clinic.persons.doctors.Surgeon;
import lesson7.clinic.persons.doctors.Therapist;

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

        clinic.addPatients(new Patient("Иванов", "Иван", "Иванович"),
                new Patient("Сергеев", "Сергей", "Сергеевич"),
                new Patient("Антонов", "Антон", "Антонович"));

        clinic.addDoctors(new Therapist("Уваров", "Евдоким", "Егорович", "Простуда"),
                new Surgeon("Жуков", "Гордей", "Алексеевич", "Сколиоз"),
                new Dantist("Лазарев", "Артем", "Юлианович", "Кариес"));

        clinic.assignTreatmentPlan(clinic.findPatientBySurnameName("Сергеев", "Сергей"), "Сколиоз");
        clinic.assignTreatmentPlan(clinic.findPatientBySurnameName("Антонов", "Антон"), "Кариес");
        //т.к. болезнь не записана ни одному доктору - план лечения назначается свободному терапевту, согласно условию задания
        clinic.assignTreatmentPlan(clinic.findPatientBySurnameName("Иванов", "Иван"), "Неизвестная болезнь");


        ConsoleUtil.println(clinic.clinicStatusToString());

    }

}
