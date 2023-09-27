package lesson14_extended.university.real_estates;

import base.ConsoleUtil;
import lesson14_extended.university.persons.Student;

import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Objects;

public class Room implements StudentAddressable {

    private final int roomNumber;

    private final Dormitory dormitoryOwner;

    private final HashSet<Student> studentHashSet;
    private int maxInhabitants;

    {
        studentHashSet = new HashSet<>();
        maxInhabitants = 4;
    }

    public Room(int roomNumber, Dormitory dormitoryOwner, int maxInhabitants) {
        this.roomNumber = roomNumber;
        this.dormitoryOwner = dormitoryOwner;
        this.maxInhabitants = maxInhabitants;
    }

    public Room(int roomNumber, Dormitory dormitoryOwner) {
        this.roomNumber = roomNumber;
        this.dormitoryOwner = dormitoryOwner;
    }

    public int getMaxInhabitants() {
        return maxInhabitants;
    }

    public void setMaxInhabitants(int maxInhabitants) {
        this.maxInhabitants = maxInhabitants;
    }

    public int getRoomNumber() {
        return roomNumber;
    }

    public void addStudent(Student... students) {
        if (students.length > maxInhabitants) {
            studentHashSet.addAll(Arrays.stream(students).limit(maxInhabitants).toList());
            ConsoleUtil.println("При заселении студентов возникла ошибка, их больше чем мест в комнате (" + maxInhabitants + ')');
        } else {
            studentHashSet.addAll(Arrays.asList(students));
        }
    }

    public void removeStudents(Student... students) {
        Arrays.asList(students).forEach(student -> {
            boolean isRemoved = studentHashSet.remove(student);
            if (!isRemoved) ConsoleUtil.println("Ошибка выселения! Студента  " + student + " нет в комнате!");
        });
    }

    public boolean studentContains(Student student) {
        return studentHashSet.contains(student);
    }

    public List<Student> getStudentsList() {
        return studentHashSet.stream().toList();
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Room room = (Room) o;
        return roomNumber == room.roomNumber && Objects.equals(dormitoryOwner.getAddress(), room.dormitoryOwner.getAddress());
    }

    @Override
    public int hashCode() {
        return Objects.hash(roomNumber, dormitoryOwner);
    }

    @Override
    public String getAddressString() {
        return dormitoryOwner + " , комната: " + roomNumber;
    }

    @Override
    public Room getRoom() {
        return this;
    }

    @Override
    public Dormitory getDormitory() {
        return dormitoryOwner;
    }

    @Override
    public String toString() {
        return "Комната (номер комнаты: " + roomNumber + ", общежитие: " + dormitoryOwner.getName() + ", макс. кол-во жильцов: " + maxInhabitants + ", живет сейчас: " + studentHashSet.size() + ')';
    }
}
