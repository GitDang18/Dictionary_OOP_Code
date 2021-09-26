package DictionaryClass;

public class Word {
    private String word_target;
    private String word_explain;

    public Word(String wt, String we) {
        this.word_target = wt;
        this.word_explain = we;
    }

    public void setWord_target(String word_target) {
        this.word_target = word_target;
    }

    public void setWord_explain(String word_explain) {
        this.word_explain = word_explain;
    }

    public String getWord_target() {
        return word_target;
    }

    public String getWord_explain() {
        return word_explain;
    }

    public int compareTo(Word x) {
        return this.word_target.compareTo(x.word_target);
    }
}
