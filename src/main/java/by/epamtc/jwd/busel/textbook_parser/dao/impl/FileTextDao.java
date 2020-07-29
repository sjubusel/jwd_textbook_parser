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
        StringBuilder codeBlockBuilder = new StringBuilder();
        StringBuilder nonCodeBlockBuilder = new StringBuilder();
        StringBuilder currentBuilder = nonCodeBlockBuilder;

        String testFilePath = System.getProperty("user.dir") +
                File.separator + "src" +
                File.separator + "main" +
                File.separator + "resources" +
                File.separator + textName;
        String filePath = System.getProperty("java.class.path") + File.separator + textName;

        //TODO create class FileAssistant in order to form a File-Path
        try (FileReader in = new FileReader(testFilePath);
             BufferedReader bufferedReader = new BufferedReader(in)) {

            Deque<String> curlyBracketsStack = new LinkedList<>();
            while (bufferedReader.ready()) {
                String line = cleanLine(bufferedReader.readLine());
                boolean isCodelineable = parserProvider.isCodeLine(line,
                        curlyBracketsStack);

                if (!curlyBracketsStack.isEmpty()) {
                    if (currentBuilder == nonCodeBlockBuilder) {
                        String parsableBlock = new String(currentBuilder);
                        parserProvider.parseAndUpdate(parsableBlock, text);
                        currentBuilder.delete(0, currentBuilder.length());
                        currentBuilder = codeBlockBuilder;
                    }
                    currentBuilder.append(line).append('\n');
                    continue;
                }

                if (!isCodelineable) {
                    if (currentBuilder == codeBlockBuilder) {
                        String parsableBlock = new String(currentBuilder);
                        parserProvider.parseAndUpdate(parsableBlock, text);
                        currentBuilder.delete(0, currentBuilder.length());
                        currentBuilder = nonCodeBlockBuilder;
                    }
                } else {
                    if (currentBuilder == nonCodeBlockBuilder) {
                        String parsableBlock = new String(currentBuilder);
                        parserProvider.parseAndUpdate(parsableBlock, text);
                        currentBuilder.delete(0, currentBuilder.length());
                        currentBuilder = codeBlockBuilder;
                    }
                }
                currentBuilder.append(line).append('\n');
            }
        } catch (FileNotFoundException e) {
            throw new DaoException("FILE NOT FOUND", e);
        } catch (IOException e) {
            throw new DaoException("OTHER DAO IO ERROR", e);
        }

        String lastParsableLine = new String(currentBuilder);
        parserProvider.parseAndUpdate(lastParsableLine, text);

        return text;
    }

    private String cleanLine(String line) {
        line = line.replaceAll("[ \\t]{2,}|\\t", " ");
        return line.trim();
    }
}
