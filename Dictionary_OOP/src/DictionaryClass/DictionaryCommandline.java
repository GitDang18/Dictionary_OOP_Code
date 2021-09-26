package DictionaryClass;

import java.io.FileNotFoundException;

import static DictionaryClass.Dictionary.dictionary_list;

public class DictionaryCommandline {

    public void showAllWords() {
        int size = dictionary_list.size();
        for (int i = 0; i < size; i++) {
            System.out.println(dictionary_list.get(i).getWord_target() + " : " + dictionary_list.get(i).getWord_explain());
        }
    }

    public void dictionaryBasic() {
        DictionaryManagement dcm = new DictionaryManagement();
        dcm.sort_dictionary_list();
        showAllWords();
    }
    public void DictionaryAdvance() throws FileNotFoundException{
        DictionaryManagement dcm = new DictionaryManagement();
//        dcm.addWordInList();
        dcm.insertFromFile("rsrc\\Text_file\\E_V.txt");
//        dcm.Dictionary_Lookup();
        showAllWords();
    }

}
