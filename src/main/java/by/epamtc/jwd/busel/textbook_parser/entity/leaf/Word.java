package by.epamtc.jwd.busel.textbook_parser.entity.leaf;

import by.epamtc.jwd.busel.textbook_parser.entity.Text;

public class Word implements Text {
    /**
     * simple word or punctuation mark
     */
    String value;

    public Word() {
    }

    public Word(String value) {
        this.value = value;
    }

    @Override
    public void m() {
        System.out.println(value);
    }

    @Override
    public boolean isComposite() {
        return false;
    }

    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        Word word = (Word) o;
        return value.equals(word.value);
    }

    @Override
    public int hashCode() {
        int hash = 17;
        hash = 31 * hash + (value == null ? 0 : value.hashCode());
        return hash;
    }

    @Override
    public String toString() {
        return "Word{" +
                "value='" + value + '\'' +
                '}';
    }
}
