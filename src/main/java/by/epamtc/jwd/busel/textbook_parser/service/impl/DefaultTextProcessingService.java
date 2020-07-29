package by.epamtc.jwd.busel.textbook_parser.service.impl;

import by.epamtc.jwd.busel.textbook_parser.entity.Text;
import by.epamtc.jwd.busel.textbook_parser.entity.composite.Paragraph;
import by.epamtc.jwd.busel.textbook_parser.entity.composite.TextComposite;
import by.epamtc.jwd.busel.textbook_parser.entity.composite.TextSentence;
import by.epamtc.jwd.busel.textbook_parser.entity.leaf.SentenceWord;
import by.epamtc.jwd.busel.textbook_parser.service.TextProcessingService;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class DefaultTextProcessingService implements TextProcessingService {
    @Override
    public void deleteWordsOfLengthIfFirstLetterIsConsonant(Text text, int length) {
        TextComposite textComposite = null;
        if (text.isComposite() && (text.getClass() == TextComposite.class)) {
            textComposite = (TextComposite) text;
        }

        List<Text> textSentences = receiveAllSentences(textComposite);
        for (Text textSentence : textSentences) {
            if (textSentence.getClass() == TextSentence.class) {
                TextSentence sentence = (TextSentence) textSentence;
                deleteWordsOfLengthIfFirstLetterIsConsonant(sentence, length);
            }
        }
    }

    @Override
    public void deleteCoincidencesOfFirstLetterOfEachWord(Text text) {

    }

    @Override
    public void replaceWordsOfLengthWithSubstring(Text text, int length, String substring) {

    }

    private List<Text> receiveAllSentences(TextComposite textComposite) {
        List<Text> sentences = new ArrayList<>();
        if (textComposite != null) {
            List<Text> textParts = textComposite.receiveCompositeContents();
            for (Text textPart : textParts) {
                if (textPart.getClass() == Paragraph.class) {
                    Paragraph paragraph = (Paragraph) textPart;
                    sentences.addAll(paragraph.getSentences());
                }
            }
        }
        return sentences;
    }

    private void deleteWordsOfLengthIfFirstLetterIsConsonant(TextSentence sentence,
            int length) {
        List<Text> sentenceParts = sentence.getSentenceParts();
        for (Text sentencePart : sentenceParts) {
            if (sentencePart.getClass() == SentenceWord.class) {
                String s = "[-'\"A-Za-z]+";


            }
        }

        Iterator<Text> iterator = sentenceParts.iterator();
        while (iterator.hasNext()) {
            Text sentencePart = iterator.next();
            if (sentencePart.getClass() == SentenceWord.class) {
                SentenceWord word = (SentenceWord) sentencePart;
                if (isWordToDelete(word)) {
                    iterator.remove();
                }
            }

        }
    }

    private boolean isWordToDelete(SentenceWord word) {
        if (word.getValue().matches("[-'\"A-Za-z]+")) {
            if (!word.getValue().startsWith("\"")) {
                return isLetterConsonant(word.getValue().charAt(0));
            } else {
                return isLetterConsonant(word.getValue().charAt(1));
            }
        }
        return false;
    }

    private boolean isLetterConsonant(char letter) {
        String consonants = "BbCcDdFfGfHhJjKkLlMmNnPpQqRrSsTtVvXxZzWwYy";
        return consonants.contains(String.valueOf(letter));
    }
}
