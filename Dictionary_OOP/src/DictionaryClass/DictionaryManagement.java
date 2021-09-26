package DictionaryClass;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.Collections;
import java.util.Comparator;
import java.util.Scanner;

import static DictionaryClass.Dictionary.dictionary_list;

public class DictionaryManagement {

    public void insertFromCommandline () {
        Scanner sc = new Scanner(System.in);
        String word_target = sc.nextLine();
        String word_explain = sc.nextLine();
        Word new_word = new Word(word_target, word_explain);
        addWord(new_word);
    }

    //thêm từ qua file
    public void insertFromFile(String filename) throws FileNotFoundException{

        try {
            File file = new File(filename);
            FileReader fileReader = new FileReader(file);
            BufferedReader bufferedReader = new BufferedReader(fileReader);

            String line = null;

            while((line = bufferedReader.readLine()) != null){

                int count = 0;
                for (int i = 0; i < line.length(); i++) {
                    if (line.charAt(i) == '<') {
                        count = i;
                        break;
                    }
                }

                String word_target = line.substring(0, count);
                String word_explain = line.substring(count, line.length());
                Word addWord = new Word(word_target, word_explain);
                dictionary_list.add(addWord);

            }
        }
        catch (Exception exception) {
            exception.printStackTrace();
        }


    }

    //sắp xếp lại danh sách
    public void sort_dictionary_list () {
        Collections.sort(dictionary_list, new Comparator<Word>() {
            @Override
            public int compare(Word o1, Word o2) {
                return o1.compareTo(o2);
            }
        });
    }

    //tra từ có trong danh sách

    public void Dictionary_Lookup(){
        String SearchWord;
        Scanner sc = new Scanner(System.in);
        System.out.println("nhập từ tìm kiếm:");
        SearchWord = sc.nextLine();
        int size = dictionary_list.size();
        boolean check = false;
        for(int i = 0; i < size; i++) {
            if (SearchWord.equals(dictionary_list.get(i).getWord_target())) {
                System.out.println("từ bạn cần tìm là :" + dictionary_list.get(i).getWord_explain());
                check = true;
                break;
            }
        }
        if(!check) {
            System.out.println("không có từ bạn cần tìm");
        }
    }

    // nhập dữ liệu từ tay
    public void addWordInList(){
        Scanner sc = new Scanner(System.in);
        System.out.println("nhap tu muon them :");
        String word_target = sc.nextLine();
        System.out.println("nhap nghia :");
        String word_explain = sc.nextLine();
        Word newWord = new Word(word_target,word_explain);
        addWord(newWord);
    }
    public void addWord (Word new_word) {
        dictionary_list.add(new_word);
        sort_dictionary_list();
    }

}
