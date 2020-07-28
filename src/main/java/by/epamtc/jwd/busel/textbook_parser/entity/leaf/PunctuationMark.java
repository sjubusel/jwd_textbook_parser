package by.epamtc.jwd.busel.textbook_parser.entity.leaf;

import by.epamtc.jwd.busel.textbook_parser.entity.Text;

public class PunctuationMark implements Text {
    /**
     * a punctuation mark
     */
    String value;

    public PunctuationMark() {
    }

    public PunctuationMark(String value) {
        this.value = value;
    }

    @Override
    public void m() {

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
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }

        PunctuationMark punctuationMark = (PunctuationMark) o;

        return value.equals(punctuationMark.value);
    }

    @Override
    public int hashCode() {
        int hash = 17;
        hash = 31 * hash + (value == null ? 0 : value.hashCode());
        return hash;
    }

    @Override
    public String toString() {
        return "PunctuationMark{" +
                "value='" + value + '\'' +
                '}';
    }
}
