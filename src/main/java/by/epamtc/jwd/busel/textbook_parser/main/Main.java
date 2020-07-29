package by.epamtc.jwd.busel.textbook_parser.main;

import by.epamtc.jwd.busel.textbook_parser.entity.Text;
import by.epamtc.jwd.busel.textbook_parser.service.ServiceFactory;
import by.epamtc.jwd.busel.textbook_parser.service.TextService;
import by.epamtc.jwd.busel.textbook_parser.service.exception.ServiceException;

public class Main {
    public static void main(String[] args) {
        ServiceFactory serviceFactory = ServiceFactory.getInstance();
        TextService textService = serviceFactory.getTextService();
        Text text = null;
        try {
            textService.find("text.txt");
        } catch (ServiceException e) {
            System.err.println(e.toString());
            System.out.println("SOMETHING WENT WRONG, PLEASE CONTACT: " +
                    "sergey.busel@tut.by");
            return;
        }

        StringBuilder builder = new StringBuilder();
        text.m(builder);
        System.out.println(new String(builder));
    }
}