package by.epamtc.jwd.busel.textbook_parser.entity;

/**
 * A Component, which is a part of Composite Pattern
 */
public interface Text {
    void fillWithContents(StringBuilder builder);

    boolean isComposite();
}
