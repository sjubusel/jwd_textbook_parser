package by.epamtc.jwd.busel.textbook_parser.dao.impl;

import by.epamtc.jwd.busel.textbook_parser.dao.TextDao;
import by.epamtc.jwd.busel.textbook_parser.dao.exception.DaoException;
import by.epamtc.jwd.busel.textbook_parser.dao.util.ParserProvider;
import by.epamtc.jwd.busel.textbook_parser.entity.Text;
import by.epamtc.jwd.busel.textbook_parser.entity.composite.TextComposite;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Deque;
import java.util.LinkedList;

public class FileTextDao implements TextDao {
    private final ParserProvider parserProvider = new ParserProvider();

    @Override
    public Text find(String textName) throws DaoException {
        Text text = new TextComposite();
        StringBuilder sb = new StringBuilder();

        //TODO create class FileAssistant in order to form a File-Path
        try (FileReader in = new FileReader(System.getProperty("java.class.path" + File.separator + textName));
             BufferedReader bufferedReader = new BufferedReader(in)) {
            Deque<String> curlyBracketsStack = new LinkedList<>();
            while (bufferedReader.ready()) {
                String line = bufferedReader.readLine();
                boolean isCodelineable = parserProvider.isCodeLine(line,
                        curlyBracketsStack);

                if (curlyBracketsStack.isEmpty()) {
                    if (isCodelineable) {
                        sb.append(line);
                        line = new String(sb);
                        sb.delete(0, sb.length());
                    }
                    parserProvider.parseAndUpdate(line, text);
                } else {
                    sb.append(line).append('\n');
                }
            }
        } catch (FileNotFoundException e) {
            throw new DaoException("FILE NOT FOUND", e);
        } catch (IOException e) {
            throw new DaoException("OTHER DAO IO ERROR", e);
        }

        return text;
    }
}
