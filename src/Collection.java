import java.util.ArrayList;
import java.util.Iterator;

public class Collection {
    public static void main(String args[]) {

        ArrayList<String> strings = new ArrayList<String>(9);
        ArrayList<String> strings1 = new ArrayList<String>(9);
        String[] wordsArray = {"this", "is", "lots", "of", "fun", "for", "every", "Java", "programmer"};

        for(String word : wordsArray) {
            strings.add(word);
            strings1.add(word);
        }

        System.out.println("Исходная коллекция: \n" + strings);
        System.out.println();
        StringCollectionUtil listMark = new StringCollectionUtil();
        strings = listMark.resetWordsByLength(strings, 4);
        System.out.println("Преобразованная коллекция: \n" + strings);
        System.out.println();
        strings1 = listMark.removeWordsByLength(strings1, 4);
        System.out.println("Коллекция без слов из 4 букв: \n" + strings1);
    }

    public static class StringCollectionUtil {

        // Первый метод заменяет слова из переданного в параметр количества букв на звездочки

        public ArrayList<String> resetWordsByLength(ArrayList<String> strings, int wordLength){
            ArrayList<String> newStrings = new ArrayList<String>();
            for(String oneString : strings) {
                if(oneString.length() == wordLength) {
                    newStrings.add("*");
                } else {
                    newStrings.add(oneString);
                }
            }
            return newStrings;
        }

        // Второй метод удаляет слова из переданного количества букв

        public ArrayList<String> removeWordsByLength(ArrayList<String> strings, int wordLength){
            ArrayList<String> newStrings = new ArrayList<String>();
            for(String oneString : strings) {
                if(oneString.length() != wordLength) {
                    newStrings.add(oneString);
                }
            }
            return newStrings;
        }

    }
}