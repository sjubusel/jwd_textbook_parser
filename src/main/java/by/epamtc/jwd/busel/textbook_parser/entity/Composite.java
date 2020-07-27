package by.epamtc.jwd.busel.textbook_parser.entity;

import java.util.List;

/**
 * an interface, which is an abstraction over Composite from Composite Pattern.
 */
public interface Composite extends Text {
    void add(Text text);

    void remove(Text text);

    List<Text> receiveCompositeContents();
}
