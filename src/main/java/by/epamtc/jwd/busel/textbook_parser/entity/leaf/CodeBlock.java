package by.epamtc.jwd.busel.textbook_parser.entity.leaf;

import by.epamtc.jwd.busel.textbook_parser.entity.Text;

public class CodeBlock implements Text {
    /**
     * code block, which consists of clock lines
     */
    String value;

    public CodeBlock() {
    }

    public CodeBlock(String value) {
        this.value = value;
    }

    @Override
    public void fillWithContents(StringBuilder builder) {

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
        CodeBlock codeBlock = (CodeBlock) o;
        return value.equals(codeBlock.value);
    }

    @Override
    public int hashCode() {
        int hash = 17;
        hash = 31 * hash + (value == null ? 0 : value.hashCode());
        return hash;
    }

    @Override
    public String toString() {
        return "CodeBlock{" +
                "value='" + value + '\'' +
                '}';
    }
}
