package by.epamtc.jwd.busel.textbook_parser.service.validation;

public class TextPathValidator {

    public boolean isTextPathCorrect(String textName) {
        if (textName == null) {
            return false;
        }
        return textName.matches("[A-Za-z0-9]+\\.txt");
    }
}
