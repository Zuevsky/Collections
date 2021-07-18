import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Comparator;

public class Collection_ArrayList {
    public static void main(String[] args) {
        ArrayList<Actor> actors = new ArrayList<Actor>();
        Actor first = new Actor("Ivan", "Popugaev", 2500, 18);
        Actor second = new Actor("Alexey", "Romanov", 1700, 45);
        Actor third = new Actor("Sasha", "Brown", 3800, 36);
        Actor fourth = new Actor("Gena", "Brown", 750, 54);
        LastNameComparator lastNameComparator = new LastNameComparator();
        AgeComparator ageComparator = new AgeComparator();
        Comparator<Actor> ageAndLastNameComparator = new LastNameComparator().thenComparing(new AgeComparator());
        actors.add(first);
        actors.add(second);
        actors.add(third);
        actors.add(fourth);
        Collections.sort(actors, lastNameComparator);
        System.out.println("Коллекция актеров, отсортированная по фамилии: \n" + actors);
        System.out.println();
        Collections.sort(actors, ageComparator);
        System.out.println("Коллекция актеров, отсортированная по возрасту: \n" + actors);
        System.out.println();
        Collections.sort(actors, ageAndLastNameComparator);
        System.out.println("Коллекция актеров, отсортированная по фамилии и возрасту: \n" + actors);
        System.out.println();
        Studio newStudio = new Studio();
        System.out.println("Коллекция актеров отсортированная по зарплате и без самого дорогого актера\n" + newStudio.fire(actors));
    }
    public static class Actor implements Comparable<Actor>{
        private String firstName;
        private String lastName;
        private int fee;
        private int age;

        public Actor(String firstName, String lastName, int fee, int age) {
            this.firstName = firstName;
            this.lastName = lastName;
            this.fee = fee;
            this.age = age;
        }

        public String getFirstName() {
            return firstName;
        }

        public String getLastName() {
            return lastName;
        }

        public int getFee() {
            return fee;
        }

        public int getAge() {
            return age;
        }

        public void setFirstName(String firstName) {
            this.firstName = firstName;
        }

        public void setLastName(String lastName) {
            this.lastName = lastName;
        }

        public void setFee(int fee) {
            this.fee = fee;
        }

        public void setAge(int age) {
            this.age = age;
        }

        @Override
        public int compareTo(Actor one) {
            return this.getFee() - one.getFee();
        }

        @Override
        public String toString() {
            return "(firstName = " + firstName + ", lastName = " + lastName + ", fee = " + fee + ", age = " + age + ")\n";
        }

    }

    // Класс Studio с методом fire, который принимает список актеров и удаляет актера с самым большим гонораром

    public static class Studio {
        public ArrayList fire(ArrayList actors){
            FeeComparator feeComparator = new FeeComparator();
            Collections.sort(actors, feeComparator);
            actors.remove(actors.size()-1);
            return actors;
        }
    }

    public static class FeeComparator implements Comparator<Actor> {
        @Override
        public int compare(Actor one, Actor two) {
            return one.getFee() - two.getFee();
        }
    }

    public static class LastNameComparator implements Comparator<Actor> {
        @Override
        public int compare(Actor one, Actor two) {
            return one.getLastName().compareTo(two.getLastName());
        }
    }

    public static class AgeComparator implements Comparator<Actor> {
        @Override
        public int compare(Actor one, Actor two) {
            return one.getAge() - two.getAge();
        }
    }

}