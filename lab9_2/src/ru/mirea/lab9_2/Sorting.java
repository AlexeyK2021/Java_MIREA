package ru.mirea.lab9_2;

import java.util.Objects;
import java.util.Scanner;

public class Sorting {

    public static void mergeSort(Comparable<Student>[] array, int low, int high) {
        if (high <= low) return;

        int mid = (low + high) / 2;
        mergeSort(array, low, mid);
        mergeSort(array, (mid + 1), high);
        merge(array, low, mid, high);
    }

    public static void merge(Comparable<Student>[] array, int low, int mid, int high) {
        Comparable<Student>[] leftArray = new Comparable[mid - low + 1];
        Comparable<Student>[] rightArray = new Comparable[high - mid];

        for (int i = 0; i < leftArray.length; i++)
            leftArray[i] = array[low + i];
        for (int i = 0; i < rightArray.length; i++)
            rightArray[i] = array[mid + i + 1];

        int leftIndex = 0;
        int rightIndex = 0;

        for (int i = low; i < high + 1; i++) {
            if (leftIndex < leftArray.length && rightIndex < rightArray.length) {
                if (leftArray[leftIndex].compareTo((Student) rightArray[rightIndex]) < 0) {
                    array[i] = leftArray[leftIndex];
                    leftIndex++;
                } else {
                    array[i] = rightArray[rightIndex];
                    rightIndex++;
                }
            } else if (leftIndex < leftArray.length) {
                array[i] = leftArray[leftIndex];
                leftIndex++;
            } else if (rightIndex < rightArray.length) {
                array[i] = rightArray[rightIndex];
                rightIndex++;
            }
        }
    }

    public static Scanner scan = new Scanner(System.in);

    public static void main(String[] args) {
        Comparable<Student>[] studentsM = new Comparable[8];
        studentsM[0] = new Student("Alexey", 4.78, 2);
        studentsM[1] = new Student("Alexander", 4.06, 1);
        studentsM[2] = new Student("Nikolay", 4.26, 5);
        studentsM[3] = new Student("Igor", 3.87, 3);
        studentsM[4] = new Student("Danila", 3.93, 2);
        studentsM[5] = new Student("Egor", 3.74, 3);
        studentsM[6] = new Student("Pavel", 4.58, 1);
        studentsM[7] = new Student("Artem", 4.83, 4);

        Comparable<Student>[] studentsF = new Comparable[8];
        studentsF[0] = new Student("Anastasia", 4.95, 2);
        studentsF[1] = new Student("Alexandra", 4.02, 1);
        studentsF[2] = new Student("Anna", 4.23, 5);
        studentsF[3] = new Student("Tatiana", 3.86, 3);
        studentsF[4] = new Student("Masha", 3.96, 2);
        studentsF[5] = new Student("Polina", 3.78, 3);
        studentsF[6] = new Student("Victoria", 4.58, 1);
        studentsF[7] = new Student("Ekaterina", 4.88, 4);

        Comparable<Student>[] students = new Comparable[16];
        for (int i = 0; i < studentsM.length; i++) students[i] = studentsM[i];
        for (int i = 0; i < studentsM.length; i++) students[i + studentsM.length] = studentsF[i];

        for (Comparable<Student> elem : students) {
            Student student = (Student) elem;
            System.out.printf("%-10s %-1f %-1d", student.getName(), student.getAverageMark(), student.getCourse());
            System.out.println();
        }
        System.out.println("\n");
        mergeSort(students, 0, students.length - 1);


        for (Comparable<Student> elem : students) {
            Student student = (Student) elem;
            System.out.printf("%-10s %-1f %-1d", student.getName(), student.getAverageMark(), student.getCourse());
            System.out.println();
        }
        System.out.println("Do you want find the student by his name[Y/N]?");
        String want = scan.nextLine();
        if (Objects.equals(want, "Y") || Objects.equals(want, "y")) {
            System.out.println("Enter student name:");
            String name = scan.nextLine();
            try {
                Student student = findStudentByName(name, students);
                System.out.printf("%-10s %-1f %-1d", student.getName(), student.getAverageMark(), student.getCourse());
            } catch (CantFindStudentException e) {
                System.out.println(e.message);
            }
        }
    }

    private static Student findStudentByName(String name, Comparable<Student>[] students) throws CantFindStudentException {
        for (Comparable<Student> elem : students) {
            Student student = (Student) elem;
            if (student.getName().equals(name)) {
                return student;
            }
        }
        throw new CantFindStudentException("Can't find student " + name + "!");
    }
}
