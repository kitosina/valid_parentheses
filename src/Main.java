public class Main {
    /**
     * Найти валидные круглые скобки.
     * Обязательно счетчик и правильные скобки нужно выводить.
     *
     * Пример 1:
     *                Ввод: "(()"
     *                Вывод: 2 - ()
     * Пример 2:
     *                Ввод: ")()())"
     *                Вывод: 4 - ()()
     * Пример 3:
     *                Ввод: ")(()())"
     *                Вывод: 6 - (()())
     * Пример 4:
     *                Ввод: ")("
     *                Вывод: 0
     * @param args
     */
    public static void main(String[] args) {

        System.out.println(countValidParentheses("(()"));
        System.out.println(countValidParentheses(")()())"));
        System.out.println(countValidParentheses(")(()())"));
        System.out.println(countValidParentheses(")("));
    }

    public static String countValidParentheses(String s) {
        final char OPEN_BRACKET = '(';
        final char CLOSE_BRACKET = ')';

        char[] arrChar = s == null ? new char[]{} : s.trim().toCharArray();
        int countWaitCloseBracket = 0;
        int countIncorrectCloseBracket = 0;
        int countValidParentheses = 0;
        int startIndexToDelete = 0;

        StringBuilder res = new StringBuilder();

        for (int i = 0; i < arrChar.length; i++) {
            switch (arrChar[i]) {
                case OPEN_BRACKET -> {
                    res.append(OPEN_BRACKET);
                    if (countWaitCloseBracket == 0) {
                        startIndexToDelete = i;
                    }
                    countWaitCloseBracket++;
                }
                case CLOSE_BRACKET -> {
                    if (countWaitCloseBracket > 0) {
                        res.append(CLOSE_BRACKET);
                        countWaitCloseBracket--;
                        countValidParentheses +=2;
                    } else {
                        countIncorrectCloseBracket++;
                    }
                }
                default -> {
                    throw new IllegalArgumentException("Incorrect format lines");
                }
            }
        }

        if (countWaitCloseBracket > 0) {
            res.replace(
                    startIndexToDelete - countIncorrectCloseBracket,
                    startIndexToDelete + countWaitCloseBracket - countIncorrectCloseBracket,
                    ""
            );
        }
        return countValidParentheses == 0 ? "0" : countValidParentheses + "-" + res;
    }
}
