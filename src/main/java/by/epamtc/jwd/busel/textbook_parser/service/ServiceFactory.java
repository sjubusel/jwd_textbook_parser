package by.epamtc.jwd.busel.textbook_parser.service;

import by.epamtc.jwd.busel.textbook_parser.service.impl.DefaultTextService;

public class ServiceFactory {
    private static final ServiceFactory instance = new ServiceFactory();

    private final TextService textService
            = new DefaultTextService();

    private ServiceFactory() {
    }

    public static ServiceFactory getInstance() {
        return instance;
    }

    public TextService getApplianceService() {
        return textService;
    }

}
