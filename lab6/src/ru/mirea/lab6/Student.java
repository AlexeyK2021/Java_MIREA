package ru.mirea.lab6;

public class Student implements Comparable<Student> {
    private double averageMark;
    private int course;
    private String name;

    public Student(String name, double averageMark, int course) {
        this.averageMark = averageMark;
        this.course = course;
        this.name = name;
    }

    public double getAverageMark() {
        return averageMark;
    }

    public void setAverageMark(double averageMark) {
        this.averageMark = averageMark;
    }

    public int getCourse() {
        return course;
    }

    public void setCourse(int course) {
        this.course = course;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public int compareTo(Student o) {
        return averageMark > o.getAverageMark() ? -1 : 1;
    }
}
