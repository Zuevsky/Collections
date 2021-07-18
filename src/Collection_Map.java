import java.util.Collection;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;
import java.util.TreeMap;
import java.util.NavigableMap;

public class Collection_Map {
    public static void main(String args[]) {
        String text = "Этим утром погода радовала теплом и отсутствием облаков. Солнце слегка пригревало землю и высушивала ее от остатков ночной росы. Отличная погода для начала нового дня!";
        TextMonitoring newText = new TextMonitoring();
        HashMap<String, Integer> wordFrequency = newText.researchText(text);
        for(Map.Entry<String, Integer> item : wordFrequency.entrySet()) {
            System.out.println(newText.toString(item));
        }
        System.out.println();
        System.out.println("Количество уникальных слов в тексте: " + newText.getCountUniqueWords(wordFrequency));
        System.out.println();
        System.out.println("Уникальные слова из текста:" + newText.getUniqueWords(wordFrequency));
        System.out.println();
        System.out.println("Частота повторения слова \"погода\": " + newText.getFrequencyWord("погода"));
        System.out.println();
        System.out.println(newText.getFrequencyWords(false));
    }
    public static class TextMonitoring {
        HashMap<String, Integer> wordFrequency = new HashMap<String, Integer>();
        public String toString(Map.Entry<String, Integer> item) {
            return "Слово: \"" + item.getKey() + "\"; " + "Частота повторения: " + item.getValue() + ";\n";
        }

        // researchText() принимает в качестве параметра текст, выделяет все различные слова и высчитывает частоту, с которой они встречаются.
        // Слова считаются различными даже если у них отличается регистром букв.

        public HashMap researchText(String text) {
            String textWithoutSpaces = spaceReplacement(text);
            String textWithoutPunctuation = removePunctuationMarks(textWithoutSpaces);
            String[] wordsFromText = textWithoutPunctuation.split(" ");
            for(String oneWordFromText : wordsFromText) {
                int counter = 0;
                for(String anotherWordFromText : wordsFromText) {
                    if(oneWordFromText.equals(anotherWordFromText)) {
                        counter++;
                    }
                }
                if(!wordFrequency.containsKey(oneWordFromText) & !oneWordFromText.equals("")) {
                    wordFrequency.put(oneWordFromText, counter);
                }
            }
            return wordFrequency;
        }

        // Возвращает количество уникальных слов в тексте

        public int getCountUniqueWords(HashMap<String, Integer> wordFrequency) {
            return wordFrequency.size();
        }

        // Возвращает коллекцию уникальных слов из текста

        public Set<String> getUniqueWords(HashMap<String, Integer> wordFrequency) {
            return wordFrequency.keySet();
        }

        // Возвращае частоту употребления слова word

        public int getFrequencyWord(String word) {
            boolean doesTheWordExist = wordFrequency.containsKey(word);
            if(doesTheWordExist) {
                return wordFrequency.get(word);
            } else {
                System.out.println("Такого слова в тексте нет!");
                return -1;
            }
        }

        // Возвращает все слова и частоту их употребления, isAscendingFrequency - если true, то по возрастанию, иначе по убыванию

        public Map getFrequencyWords(boolean isAscendingFrequency) {
            TreeMap wordFrequencyAscending = new TreeMap(wordFrequency);
            if(isAscendingFrequency) {
                return wordFrequencyAscending;
            } else {
                NavigableMap wordFrequencyDescending = new TreeMap(wordFrequencyAscending);
                return wordFrequencyDescending.descendingMap();
            }
        }

        //Метод заменяет лишние пробелы в строке на точки (вспомогательный метод)
        public static String spaceReplacement(String str) {
            str = str.trim();
            char[] stringChars = str.toCharArray();
            for(int i = 1; i < stringChars.length; i++) {
                if(stringChars[i] == ' ' & stringChars[i-1] == ' ') {
                    stringChars[i-1] = '.';
                }
            }
            String newString = String.valueOf(stringChars);
            System.out.println("Текст после замены лишних пробелов на точки: " + newString);
            System.out.println();
            return newString;
        }

        //Метод удаляет из строки знаки пунктуации (вспомогательный метод)
        public static String removePunctuationMarks(String str) {
            char[] punctuationMarks = {'.', ',', '?', '!', ':', ';', '"', '\'', '-', '—'};
            for(char singlePunctuationMark : punctuationMarks) {
                while(str.indexOf(singlePunctuationMark) >= 0) {
                    int indexOfPunctuationMark = str.indexOf(singlePunctuationMark);
                    str = str.substring(0, indexOfPunctuationMark) + str.substring(indexOfPunctuationMark + 1);
                }
            }
            System.out.println("Текст после удаления знаков пунктуации: " + str);
            System.out.println();
            return str;
        }
    }
}