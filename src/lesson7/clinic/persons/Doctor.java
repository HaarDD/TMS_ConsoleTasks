package lesson7.clinic.persons;

import lesson7.clinic.types.DoctorType;

public class Doctor extends Person {


    private boolean isBusy;

    private DoctorType doctorType;

    {
        isBusy = false;
        doctorType = DoctorType.findDoctorTypeByName("Терапевт");
    }

    public Doctor(String surname, String name, String patronymic) {
        super(surname, name, patronymic);
    }

    public Doctor(String surname, String name, String patronymic, DoctorType doctorType) {
        super(surname, name, patronymic);
        this.doctorType = doctorType;
    }

    public boolean isBusy() {
        return isBusy;
    }

    public void setBusy() {
        isBusy = true;
    }

    public void setFree() {
        isBusy = false;
    }

    public DoctorType getDoctorType() {
        return doctorType;
    }

    public void setDoctorType(DoctorType doctorType) {
        this.doctorType = doctorType;
    }

    @Override
    public String toString() {
        return "(" + super.toString() + " Тип: " + doctorType.getTypeName() + "; Лечит сейчас: " + (isBusy ? "Да" : "Нет") + ")";
    }
}
