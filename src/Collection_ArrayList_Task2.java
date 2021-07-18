import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Comparator;

public class Collection_ArrayList_Task2 {
    public static void main(String[] args) {
        ArrayList<Student> students = new ArrayList();
        NameComparator nameComparator = new NameComparator();
        SurnameComparator surnameComparator = new SurnameComparator();
        Comparator<Student> fullNameComparator = new NameComparator().thenComparing(new SurnameComparator());
        AgeComparator ageComparator = new AgeComparator();
        AverageAnnualMarkComparator averageAnnualMarkComparator = new AverageAnnualMarkComparator();
        Student one = new Student("Carl", "Brown", 15, 7);
        Student two = new Student("Redmond", "Wills", 20, 8);
        Student three = new Student("Alex", "Markovets", 21, 6);
        Student four = new Student("Alex", "Filson", 25, 9);
        students.add(one);
        students.add(two);
        students.add(three);
        students.add(four);
        SchoolClass bestStudent = new SchoolClass();
        System.out.println("Лучший студент по среднему баллу из списка: \n" + bestStudent.getBestStudent(students));
        System.out.println();
        Collections.sort(students, fullNameComparator);
        System.out.println("Коллекция студентов, отсортированная по полному имени (имя + фамилия): \n" + students);
        System.out.println();
        Collections.sort(students, ageComparator);
        System.out.println("Коллекция студентов, отсортированная по возрасту: \n" + students);
        System.out.println();
        Collections.sort(students, averageAnnualMarkComparator);
        System.out.println("Коллекция студентов, отсортированная по среднему баллу: \n" + students);
    }
    public static class Student implements Comparable<Student>{
        private String name;
        private String surname;
        private int age;
        private int averageAnnualMark;
        public Student(String name, String surname, int age, int averageAnnualMark) {
            this.name = name;
            this.surname = surname;
            this.age = age;
            this.averageAnnualMark = averageAnnualMark;
        }
        public String getName() {
            return name;
        }
        public String getSurname() {
            return surname;
        }
        public int getAge() {
            return age;
        }
        public int getAverageAnnualMark() {
            return averageAnnualMark;
        }
        public void setName(String name) {
            this.name = name;
        }
        public void setSurname(String surname) {
            this.surname = surname;
        }
        public void setAge(int age) {
            this.age = age;
        }
        public void setAverageAnnualMark(int averageAnnualMark) {
            this.averageAnnualMark = averageAnnualMark;
        }
        @Override
        public int compareTo(Student one) {
            return this.getAverageAnnualMark() - one.getAverageAnnualMark();
        }
        @Override
        public String toString() {
            return "(name = " + name + ", surname = " + surname + ", age = " + age + ", averageAnnualMark = " + averageAnnualMark + ")\n";
        }
    }
    public static class SchoolClass {
        private ArrayList<Student> students;
        public ArrayList<Student> getStudents() {
            return students;
        }
        public void setStudents(ArrayList<Student> students) {
            this.students = students;
        }
        public Student getBestStudent(ArrayList<Student> students) {
            Collections.sort(students);
            return students.get(students.size()-1);
        }
    }
    public static class NameComparator implements Comparator<Student> {
        @Override
        public int compare(Student one, Student two) {
            return one.getName().compareTo(two.getName());
        }
    }
    public static class SurnameComparator implements Comparator<Student> {
        @Override
        public int compare(Student one, Student two) {
            return one.getSurname().compareTo(two.getSurname());
        }
    }
    public static class AgeComparator implements Comparator<Student> {
        @Override
        public int compare(Student one, Student two) {
            Integer firstAge = (Integer) one.getAge();
            Integer secondAge = (Integer) two.getAge();
            return firstAge.compareTo(secondAge);
        }
    }
    public static class AverageAnnualMarkComparator implements Comparator<Student> {
        @Override
        public int compare(Student one, Student two) {
            Integer firstMark = (Integer) one.getAverageAnnualMark();
            Integer secondMark = (Integer) two.getAverageAnnualMark();
            return firstMark.compareTo(secondMark);
        }
    }
}
