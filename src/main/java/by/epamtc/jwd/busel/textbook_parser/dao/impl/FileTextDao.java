package by.epamtc.jwd.busel.textbook_parser.dao.impl;

import by.epamtc.jwd.busel.textbook_parser.dao.TextDao;
import by.epamtc.jwd.busel.textbook_parser.dao.exception.DaoException;
import by.epamtc.jwd.busel.textbook_parser.entity.Text;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

public class FileTextDao implements TextDao {
    @Override
    public Text find(String textName) throws DaoException {
        Text text;
        try (FileReader in = new FileReader(textName);
             BufferedReader bufferedReader = new BufferedReader(in)) {
            while (bufferedReader.ready()) {
                String line = bufferedReader.readLine();
//                parser.parseIntoText(line, text);
            }
        } catch (FileNotFoundException e) {
            throw new DaoException("FILE NOT FOUND", e);
        } catch (IOException e) {
            throw new DaoException("OTHER DAO IO ERROR", e);
        }

        return null;
    }
}
