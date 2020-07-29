package by.epamtc.jwd.busel.textbook_parser.main;

import by.epamtc.jwd.busel.textbook_parser.entity.Text;
import by.epamtc.jwd.busel.textbook_parser.service.ServiceFactory;
import by.epamtc.jwd.busel.textbook_parser.service.TextProcessingService;
import by.epamtc.jwd.busel.textbook_parser.service.TextService;
import by.epamtc.jwd.busel.textbook_parser.service.exception.ServiceException;

public class Main {
    public static void main(String[] args) {
        ServiceFactory serviceFactory = ServiceFactory.getInstance();
        TextService textService = serviceFactory.getTextService();
        TextProcessingService textProcessingService
                = serviceFactory.getTextProcessingService();
        Text text;
        try {
            text = textService.find("text.txt");
        } catch (ServiceException e) {
            System.err.println(e.toString());
            System.out.println("SOMETHING WENT WRONG, PLEASE CONTACT: " +
                    "sergey.busel@tut.by");
            return;
        }

        // an original text from an aforementioned file
        StringBuilder builder = new StringBuilder();
        text.fillWithContents(builder);
        System.out.println(new String(builder));
        builder.delete(0, builder.length());

        // a modified text im compliance with Functionality 12
        textProcessingService.deleteWordsOfLengthIfFirstLetterIsConsonant(text,
                3);
        text.fillWithContents(builder);
        System.out.println(new String(builder));
        builder.delete(0, builder.length());

        // a modified text in compliance with Functionality 15
        textProcessingService.deleteCoincidencesOfFirstLetterOfEachWord(text);
        text.fillWithContents(builder);
        System.out.println(new String(builder));
        builder.delete(0, builder.length());

        // a modified text in compliance with Functionality 16
        textProcessingService.replaceWordsOfLengthWithSubstring(text, 4,
                "REPLACING SUBSTRING");
        text.fillWithContents(builder);
        System.out.println(new String(builder));
        builder.delete(0, builder.length());
    }
}
