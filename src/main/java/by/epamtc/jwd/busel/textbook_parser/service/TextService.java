package by.epamtc.jwd.busel.textbook_parser.service;

import by.epamtc.jwd.busel.textbook_parser.entity.Text;
import by.epamtc.jwd.busel.textbook_parser.service.exception.ServiceException;

public interface TextService {
    Text find(String textName) throws ServiceException;
}
