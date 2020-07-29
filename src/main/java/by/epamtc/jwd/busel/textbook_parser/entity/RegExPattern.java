package by.epamtc.jwd.busel.textbook_parser.entity;

//TODO create ResourceManager
public final class RegExPattern {
    public static final String REPEATING_WHITESPACES = "[ \\t]{2,}|\\t";
    public static final String BLANK_SPACE = " ";
    public static final String CURLY_BRACKET = "[{}]";
    public static final String ROUND_BRACKET = "[()]]";
    public static final String SPECIAL_CODE_LINE_CASE
            = "[\\w]+\\s=\\s[\\w]+;?\n?";
    public static final String PARAGRAPH
            = "(^[0-9]\\.([0-9]\\.)*[ \\t]+[-A-Za-z \\t]+$)" +
            "|" + "(^[A-Z][ \\S]+\\n?([a-z][ \\S]+\\n?)+?[.:!?]$)";
    public static final String LINE_BREAK = "\n";
    public static final String SENTENCE
            = "([0-9]\\.([0-9]\\.)*[ \\t]+[-A-Za-z \\t]+)" + "|" +
            "([A-Z][- ><=,:;'\"0-9A-Za-z()%]+[.:!?])";
    public static final String SENTENCE_PART = "(\\b[0-9]\\.([0-9]\\.)?)" +
            "|" + "([-'\"A-Za-z]+)" + "|" + "([0-9]+\\%)" +
            "|" + "(\\b[0-9]+\\b)" + "|" + "([>=]+)" + "|" + "([()])" +
            "|" + "([-.,;:!?])";

    public static final String PUNCTUATION_MARK = "[.,;:!?]";
    public static final String FILE_NAMING = "[A-Za-z0-9]+\\.txt";

    private RegExPattern() {
    }
}
