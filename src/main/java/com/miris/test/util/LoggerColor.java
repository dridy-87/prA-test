package com.miris.test.util;

public class LoggerColor {

    private static final String prefix = "\u001B[";

    private static final String ANSI_RESET = prefix + "0m";

    private static final String ANSI_BLACK = prefix + "30m";

    private static final String ANSI_RED = prefix + "31m";

    private static final String ANSI_GREEN = prefix + "32m";

    private static final String ANSI_YELLOW = prefix + "33m";

    private static final String ANSI_BLUE = prefix + "34m";

    private static final String ANSI_PURPLE = prefix + "35m";

    private static final String ANSI_CYAN = prefix + "36m";

    private static final String ANSI_WHITE = prefix + "37m";

    private static final String ANSI_BLACK_BACKGROUND = prefix + "40m";

    private static final String ANSI_RED_BACKGROUND = prefix + "41m";

    private static final String ANSI_GREEN_BACKGROUND = prefix + "42m";

    private static final String ANSI_YELLOW_BACKGROUND = prefix + "43m";

    private static final String ANSI_BLUE_BACKGROUND = prefix + "44m";

    private static final String ANSI_PURPLE_BACKGROUND = prefix + "45m";

    private static final String ANSI_CYAN_BACKGROUND = prefix + "46m";

    private static final String ANSI_WHITE_BACKGROUND = prefix + "47m";

    private static final String ANSI_BOLD = prefix + "1m";

    private static final String ANSI_BRIGHT_BLACK = prefix + "90m";

    public static String red(String message) {
        return ANSI_RED + message + ANSI_RESET;
    }

    public static String green(String message) {
        return ANSI_GREEN + message + ANSI_RESET;
    }

    public static String yellow(String message) {
        return ANSI_YELLOW + message + ANSI_RESET;
    }

    public static String blue(String message) {
        return ANSI_BLUE + message + ANSI_RESET;
    }

    public static String purple(String message) {
        return ANSI_PURPLE + message + ANSI_RESET;
    }

    public static String cyan(String message) {
        return ANSI_CYAN + message + ANSI_RESET;
    }

    public static String white(String message) {
        return ANSI_WHITE + message + ANSI_RESET;
    }

    public static String black(String message) {
        return ANSI_BLACK + message + ANSI_RESET;
    }

    public static String blackBackground(String message) {
        return ANSI_BLACK_BACKGROUND + message + ANSI_RESET;
    }

    public static String redBackground(String message) {
        return ANSI_RED_BACKGROUND + message + ANSI_RESET;
    }

    public static String greenBackground(String message) {
        return ANSI_GREEN_BACKGROUND + message + ANSI_RESET;
    }

    public static String yellowBackground(String message) {
        return ANSI_BLACK + ANSI_YELLOW_BACKGROUND + message + ANSI_RESET;
    }

    public static String blueBackground(String message) {
        return ANSI_BLUE_BACKGROUND + message + ANSI_RESET;
    }

    public static String purpleBackground(String message) {
        return ANSI_PURPLE_BACKGROUND + message + ANSI_RESET;
    }

    public static String cyanBackground(String message) {
        return ANSI_CYAN_BACKGROUND + message + ANSI_RESET;
    }

    public static String whiteBackground(String message) {
        return ANSI_WHITE_BACKGROUND + message + ANSI_RESET;
    }

    public static String bold(String message) {
        return ANSI_BOLD + message + ANSI_RESET;
    }
    
}
