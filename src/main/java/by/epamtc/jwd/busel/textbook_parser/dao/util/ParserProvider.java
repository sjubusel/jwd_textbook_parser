package by.epamtc.jwd.busel.textbook_parser.dao.util;

import by.epamtc.jwd.busel.textbook_parser.entity.Text;

import java.util.Deque;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

//TODO create chains of parsers
public class ParserProvider {
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
        return isCodelineable;
    }

    public void parseAndUpdate(String line, Text text) {
        line = line.replaceAll("\\s+", " ");
        //TODO depending on whether codeblock of text line FORWARD to certain chains of parsers
    }
}
