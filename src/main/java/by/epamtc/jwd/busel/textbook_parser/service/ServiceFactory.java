package by.epamtc.jwd.busel.textbook_parser.service;

import by.epamtc.jwd.busel.textbook_parser.service.impl.DefaultTextProcessingService;
import by.epamtc.jwd.busel.textbook_parser.service.impl.DefaultTextService;

public class ServiceFactory {
    private static final ServiceFactory instance = new ServiceFactory();
    private final TextService textService = new DefaultTextService();
    private final TextProcessingService textProcessingService
            = new DefaultTextProcessingService();

    private ServiceFactory() {
    }

    public static ServiceFactory getInstance() {
        return instance;
    }

    public TextService getTextService() {
        return textService;
    }

    public TextProcessingService getTextProcessingService() {
        return textProcessingService;
    }

}
