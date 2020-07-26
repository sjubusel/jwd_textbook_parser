package by.epamtc.jwd.busel.textbook_parser.dao;

import by.epamtc.jwd.busel.textbook_parser.dao.exception.DaoException;
import by.epamtc.jwd.busel.textbook_parser.entity.Text;

public interface TextDao {
    Text find(String textName) throws DaoException;
}
