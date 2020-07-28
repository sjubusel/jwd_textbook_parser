package by.epamtc.jwd.busel.textbook_parser.dao.util.parser;

import by.epamtc.jwd.busel.textbook_parser.entity.Text;

public abstract class TextParser {
    protected TextParser next;

    public TextParser setNext(TextParser parser) {
        this.next = parser;
        return parser;
    }

    public abstract void parseAndUpdate(String parsableElement, Text text);

}
