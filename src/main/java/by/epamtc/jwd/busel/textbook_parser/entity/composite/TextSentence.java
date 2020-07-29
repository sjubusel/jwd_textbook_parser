package by.epamtc.jwd.busel.textbook_parser.entity.composite;

import by.epamtc.jwd.busel.textbook_parser.entity.Composite;
import by.epamtc.jwd.busel.textbook_parser.entity.Text;

import java.util.ArrayList;
import java.util.List;

public class TextSentence implements Text, Composite {
    /**
     * words
     */
    List<Text> words = new ArrayList<>();

    public TextSentence() {
    }

    public TextSentence(List<Text> words) {
        this.words = words;
    }

    @Override
    public void fillWithContents(StringBuilder builder) {

    }

    @Override
    public boolean isComposite() {
        return true;
    }

    @Override
    public void add(Text component) {
        words.add(component);
    }

    @Override
    public void remove(Text component) {
        words.remove(component);
    }

    @Override
    public List<Text> receiveCompositeContents() {
        return words;
    }

    public List<Text> getWords() {
        return words;
    }

    public void setWords(List<Text> words) {
        this.words = words;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }

        TextSentence textSentence = (TextSentence) o;
        boolean isEquals = true;
        for (int i = 0; i < textSentence.words.size(); i++) {
            if (!words.get(i).equals(textSentence.words.get(i))) {
                isEquals = false;
                break;
            }
        }

        return isEquals;
    }

    @Override
    public int hashCode() {
        int hash = 17;
        for (Text word : words) {
            hash = 31 * hash + (word == null ? 0 : word.hashCode());
        }
        return hash;
    }

    @Override
    public String toString() {
        return "TextSentence{" +
                "words=" + words +
                '}';
    }
}
