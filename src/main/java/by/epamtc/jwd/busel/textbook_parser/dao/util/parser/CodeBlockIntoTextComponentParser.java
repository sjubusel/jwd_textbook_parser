package by.epamtc.jwd.busel.textbook_parser.dao.util.parser;

import by.epamtc.jwd.busel.textbook_parser.entity.Text;
import by.epamtc.jwd.busel.textbook_parser.entity.composite.TextComposite;
import by.epamtc.jwd.busel.textbook_parser.entity.leaf.CodeBlock;

public class CodeBlockIntoTextComponentParser extends TextParser {
    @Override
    public void parseAndUpdate(String parsableElement, Text text) {
        if (text.isComposite()) {
            if (text.getClass() == TextComposite.class) {
                TextComposite textComposite = (TextComposite) text;
                textComposite.add(new CodeBlock(parsableElement));
            }
        }
    }
}
