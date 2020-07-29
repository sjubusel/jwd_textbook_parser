package by.epamtc.jwd.busel.textbook_parser.service.validation;

import by.epamtc.jwd.busel.textbook_parser.entity.RegExPattern;

public class TextPathValidator {

    public boolean isTextPathCorrect(String textName) {
        if (textName == null) {
            return false;
        }
        return textName.matches(RegExPattern.FILE_NAMING);
    }
}
