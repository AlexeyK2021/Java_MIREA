package ru.mirea.lab6;

import java.rmi.StubNotFoundException;

public class Sorting {
    private static Comparable<Student>[] mergeSort(Comparable<Student>[] students) {
        if (students.length < 2) {
            return students;
        }
        Comparable<Student>[] a = new Comparable[students.length / 2];
        Comparable<Student>[] b = new Comparable[students.length - students.length / 2];

        for (int i = 0; i < a.length; i++) a[i] = students[i];
        for (int i = 0; i < b.length; i++) b[i] = students[i + a.length];
        a = mergeSort(a);
        b = mergeSort(b);
        return mergeArrays(a, b);
    }

    private static Comparable<Student>[] mergeArrays(Comparable<Student>[] arrayА, Comparable<Student>[] arrayB) {

        Comparable<Student>[] arrayC = new Comparable[arrayА.length + arrayB.length];
        int positionA = 0, positionB = 0;
            for (int i = 0; i < arrayC.length; i++) {
                if (positionA == arrayА.length) {
                    arrayC[i] = arrayB[i - positionB];
                    positionB++;
                } else if (positionB == arrayB.length) {
                    arrayC[i] = arrayА[i - positionA];
                    positionA++;
                } else if (arrayА[i - positionA].compareTo((Student) arrayB[i - positionB]) > 0) {
                    arrayC[i] = arrayА[i - positionA];
                    positionB++;
                } else {
                    arrayC[i] = arrayB[i - positionB];
                    positionA++;
                }
            }
            return arrayC;
    }

    public static void main(String[] args) {

        Comparable<Student>[] studentsM = new Comparable[8];
        studentsM[0] = new Student("Alexey", 4.78, 2);
        studentsM[1] = new Student("Alexander", 4.02, 1);
        studentsM[2] = new Student("Nikolay", 4.23, 5);
        studentsM[3] = new Student("Igor", 3.86, 3);
        studentsM[4] = new Student("Danila", 3.96, 2);
        studentsM[5] = new Student("Egor", 3.78, 3);
        studentsM[6] = new Student("Pavel", 4.58, 1);
        studentsM[7] = new Student("Artem", 4.88, 4);

        Comparable<Student>[] studentsF = new Comparable[8];
        studentsF[0] = new Student("Anastasia", 4.78, 2);
        studentsF[1] = new Student("Alexandra", 4.02, 1);
        studentsF[2] = new Student("Anna", 4.23, 5);
        studentsF[3] = new Student("Tatiana", 3.86, 3);
        studentsF[4] = new Student("Masha", 3.96, 2);
        studentsF[5] = new Student("Polina", 3.78, 3);
        studentsF[6] = new Student("Victoria", 4.58, 1);
        studentsF[7] = new Student("Ekaterina", 4.88, 4);

        Comparable<Student>[] students = new Comparable[16];
        students = mergeSort(studentsF);
        for (Comparable<Student> elem : students) {
            System.out.println(elem);
        }
    }
}
