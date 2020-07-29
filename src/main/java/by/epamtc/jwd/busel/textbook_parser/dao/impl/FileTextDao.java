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

import static by.epamtc.jwd.busel.textbook_parser.entity.RegExPattern.*;

public class FileTextDao implements TextDao {
    private final ParserProvider parserProvider = new ParserProvider();
    private StringBuilder codeBlockBuilder = new StringBuilder();
    private StringBuilder nonCodeBlockBuilder = new StringBuilder();
    private StringBuilder currentBuilder = nonCodeBlockBuilder;

    @Override
    public Text find(String textName) throws DaoException {
        Text text = new TextComposite();
        String filePath = receiveFilePath(textName);

        try (FileReader in = new FileReader(filePath);
             BufferedReader bufferedReader = new BufferedReader(in)) {

            Deque<String> curlyBracketsStack = new LinkedList<>();
            while (bufferedReader.ready()) {
                String line = cleanLine(bufferedReader.readLine());
                boolean isCodelineable = parserProvider.isCodeLine(line,
                        curlyBracketsStack);

                if (!curlyBracketsStack.isEmpty()) {
                    if (currentBuilder == nonCodeBlockBuilder) {
                        forwardToParsing(currentBuilder, text);
                        changeCurrentBuilder(codeBlockBuilder);
                    }
                    currentBuilder.append(line).append('\n');
                    continue;
                }

                if (!isCodelineable) {
                    if (currentBuilder == codeBlockBuilder) {
                        forwardToParsing(currentBuilder, text);
                        changeCurrentBuilder(nonCodeBlockBuilder);
                    }
                } else {
                    if (currentBuilder == nonCodeBlockBuilder) {
                        forwardToParsing(currentBuilder, text);
                        changeCurrentBuilder(codeBlockBuilder);
                    }
                }
                currentBuilder.append(line).append('\n');
            }
        } catch (FileNotFoundException e) {
            throw new DaoException("FILE NOT FOUND", e);
        } catch (IOException e) {
            throw new DaoException("OTHER DAO IO ERROR", e);
        }

        forwardToParsing(currentBuilder, text);
        currentBuilder.delete(0, currentBuilder.length());

        return text;
    }

    private String receiveFilePath(String textName) {
        return System.getProperty("java.class.path") + File.separator + textName;
    }

    private String cleanLine(String line) {
        line = line.replaceAll(REPEATING_WHITESPACES, BLANK_SPACE);
        return line.trim();
    }

    private void forwardToParsing(StringBuilder currentBuilder, Text text) {
        String parsableBlock = new String(currentBuilder);
        parserProvider.parseAndUpdate(parsableBlock, text);
    }

    private void changeCurrentBuilder(StringBuilder codeBlockBuilder) {
        currentBuilder.delete(0, currentBuilder.length());
        currentBuilder = codeBlockBuilder;
    }
}
