import java.util.Stack;

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

    public static int countValidParentheses(String s) {
        char[] arrChar = s == null ? new char[]{} : s.toCharArray();
        Stack<Character> stack = new Stack<>();
        int count = 0;
        for (char c : arrChar) {
            if (c == '(') {
                stack.push('(');
            } else if (c == ')') {
                if (!stack.isEmpty() && stack.pop() != c) {
                    count = count + 2;
                }
            }
        }
        return count;
    }
}
