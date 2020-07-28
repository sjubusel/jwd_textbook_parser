package by.epamtc.jwd.busel.textbook_parser.dao.util;

import by.epamtc.jwd.busel.textbook_parser.entity.Text;

import java.util.Deque;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

//TODO create chains of parsers
public class ParserProvider {
    //TODO create parsers

    private final Pattern curlyBracketsPattern = Pattern.compile("[{}]");

    public boolean isCodeLine(String line, Deque<String> curlyBracketsStack) {
        Matcher matcher = curlyBracketsPattern.matcher(line);
        boolean isCodelineable = false;
        while (matcher.find()) {
            isCodelineable = true;
            String curlyBracket = matcher.group();
            if (curlyBracket.equals("{")) {
                curlyBracketsStack.addLast("{");
            } else {
                curlyBracketsStack.pollLast();
            }
        }
        if (line.matches("[\\w]+\\s=\\s[\\w]+;?")) {
            isCodelineable = true;
        }
        return isCodelineable;
    }

    public void parseAndUpdate(String str, Text text) {
        if (str.contains("{") || str.matches("[\\w]+\\s=\\s[\\w]+;?")) {
            // отправить в парсер из блока кода
        } else {
            // отправить в парсер из текстового блока в абзац из абщзаца в предложение из предложения в слово
        }
        //TODO depending on whether code block or text line FORWARD to certain chains of parsers
    }
}
