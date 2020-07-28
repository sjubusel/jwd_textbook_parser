package by.epamtc.jwd.busel.textbook_parser.service.impl;

import by.epamtc.jwd.busel.textbook_parser.dao.DaoFactory;
import by.epamtc.jwd.busel.textbook_parser.dao.TextDao;
import by.epamtc.jwd.busel.textbook_parser.dao.exception.DaoException;
import by.epamtc.jwd.busel.textbook_parser.entity.Text;
import by.epamtc.jwd.busel.textbook_parser.service.TextService;
import by.epamtc.jwd.busel.textbook_parser.service.exception.ServiceException;
import by.epamtc.jwd.busel.textbook_parser.service.validation.TextPathValidator;

public class DefaultTextService implements TextService {
    private TextPathValidator validator = new TextPathValidator();

    @Override
    public Text find(String textName) throws ServiceException {
        if (!validator.isTextPathCorrect(textName)) {
            throw new ServiceException("INVALID TEXT NAME");
        }

        DaoFactory daoFactory = DaoFactory.getInstance();
        TextDao textDao = daoFactory.getTextDao();

        Text text;
        try {
            text = textDao.find(textName);
        } catch (DaoException e) {
            throw new ServiceException(e);
        }

        return text;
    }
}
