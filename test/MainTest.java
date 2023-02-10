import java.util.HashMap;
import java.util.Map;

public class MainTest {
    public static void main(String[] args) {
        Map<String, Integer> testMap = getTestMap();
        testMap.forEach((key, value) -> {
            System.out.println(
                    "Для значения: " + key
                            + " Ожидаемое значение: " + value
                            + " результат теста: " + value.equals(Main.countValidParentheses(key)));
        });
    }

    private static Map<String, Integer> getTestMap() {
        Map<String, Integer> testValueMap = new HashMap<>();
        testValueMap.put("(()", 2);
        testValueMap.put(")()())", 4);
        testValueMap.put(")(()())", 6);
        testValueMap.put(")(", 0);
        testValueMap.put("()", 2);
        testValueMap.put("())", 2);
        testValueMap.put("", 0);
        testValueMap.put(" ", 0);
        testValueMap.put("    ", 0);
        testValueMap.put(")  ", 0);
        testValueMap.put("(  ", 0);
        testValueMap.put(null, 0);
        return testValueMap;
    }
}
