package by.epamtc.jwd.busel.textbook_parser.dao.util.parser;

import by.epamtc.jwd.busel.textbook_parser.entity.Text;
import by.epamtc.jwd.busel.textbook_parser.entity.composite.TextSentence;
import by.epamtc.jwd.busel.textbook_parser.entity.leaf.Bracket;
import by.epamtc.jwd.busel.textbook_parser.entity.leaf.PunctuationMark;
import by.epamtc.jwd.busel.textbook_parser.entity.leaf.SentenceWord;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

import static by.epamtc.jwd.busel.textbook_parser.entity.RegExPattern.*;

public class SentenceIntoSentencePartsParser extends TextParser {
    private Pattern sentencePartPattern = Pattern.compile(SENTENCE_PART);

    @Override
    public void parseAndUpdate(String parsableElement, Text text) {
        TextSentence sentence = null;
        if (text.isComposite()) {
            if (text.getClass() == TextSentence.class) {
                sentence = (TextSentence) text;
            }
        }


        Matcher matcher = sentencePartPattern.matcher(parsableElement);
        if (sentence != null) {
            while (matcher.find()) {
                String sentencePart = matcher.group();
                if (sentencePart.matches(PUNCTUATION_MARK)) {
                    sentence.add(new PunctuationMark(sentencePart));
                    continue;
                }
                if (sentencePart.matches(ROUND_BRACKET)) {
                    sentence.add(new Bracket(sentencePart));
                    continue;
                }
                sentence.add(new SentenceWord(sentencePart));
            }
        }

    }
}
