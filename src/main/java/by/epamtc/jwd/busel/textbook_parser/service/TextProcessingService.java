package by.epamtc.jwd.busel.textbook_parser.service;

import by.epamtc.jwd.busel.textbook_parser.entity.Text;

public interface TextProcessingService {
    void deleteWordsOfLengthIfFirstLetterIsConsonant(Text text, int length);

    void deleteCoincidencesOfFirstLetterOfEachWord(Text text);

    void replaceWordsOfLengthWithSubstring(Text text, int length,
            String substring);
}
