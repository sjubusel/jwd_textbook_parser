package by.epamtc.jwd.busel.textbook_parser.dao;

import by.epamtc.jwd.busel.textbook_parser.dao.impl.FileTextDao;

public class DaoFactory {
    private static final DaoFactory instance = new DaoFactory();

    private final TextDao textDao = new FileTextDao();

    private DaoFactory() {
    }

    public static DaoFactory getInstance() {
        return instance;
    }

    public TextDao getTextDao() {
        return textDao;
    }
}
