package by.epamtc.jwd.busel.textbook_parser.dao.util.parser;

import by.epamtc.jwd.busel.textbook_parser.entity.RegExPattern;
import by.epamtc.jwd.busel.textbook_parser.entity.Text;
import by.epamtc.jwd.busel.textbook_parser.entity.composite.Paragraph;
import by.epamtc.jwd.busel.textbook_parser.entity.composite.TextSentence;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class ParagraphIntoSentenceParser extends TextParser {
    private Pattern sentencePattern = Pattern.compile(RegExPattern.SENTENCE);

    @Override
    public void parseAndUpdate(String parsableElement, Text text) {
        Paragraph paragraph = null;
        if (text.isComposite()) {
            if (text.getClass() == Paragraph.class) {
                paragraph = (Paragraph) text;
            }
        }

        if (next != null) {
            Matcher matcher = sentencePattern.matcher(parsableElement);
            while (matcher.find()) {
                TextSentence sentence = new TextSentence();
                String strSentence = matcher.group();
                next.parseAndUpdate(strSentence, sentence);
                if (paragraph != null) {
                    paragraph.add(sentence);
                }
            }
        }

    }
}
