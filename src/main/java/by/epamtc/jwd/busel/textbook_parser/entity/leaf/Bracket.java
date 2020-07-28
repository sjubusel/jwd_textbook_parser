package by.epamtc.jwd.busel.textbook_parser.entity.leaf;

import by.epamtc.jwd.busel.textbook_parser.entity.Text;

public class Bracket implements Text {
    /**
     * an opening or closing round bracket
     */
    String value;

    public Bracket() {
    }

    public Bracket(String value) {
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

        Bracket bracket = (Bracket) o;

        return value.equals(bracket.value);
    }

    @Override
    public int hashCode() {
        int hash = 17;
        hash = 31 * hash + (value == null ? 0 : value.hashCode());
        return hash;
    }
}
