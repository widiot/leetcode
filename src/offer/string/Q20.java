package offer.string;

import java.util.HashMap;
import java.util.Map;

/**
 * 表示数值的字符串
 */
public class Q20 {
    public static void main(String[] args) {
        System.out.println(isNumber("+100"));
        System.out.println(isNumber("5e2"));
        System.out.println(isNumber("-123"));
        System.out.println(isNumber("3.1416"));
        System.out.println(isNumber("-1E-16"));
        System.out.println(isNumber("0123"));

        System.out.println("-------------");
        System.out.println(isNumber("12e"));
        System.out.println(isNumber("1a3.14"));
        System.out.println(isNumber("1.2.3"));
        System.out.println(isNumber("+-5"));
        System.out.println(isNumber("12e+5.4"));

        System.out.println("--------------");
        System.out.println(isNumber("+5e+2"));
        System.out.println(isNumber("-3.+123"));
        System.out.println(isNumber("00123e0023"));
        System.out.println(isNumber("+3."));
        System.out.println(isNumber("+0003."));
        System.out.println(isNumber("+0003.0001"));
        System.out.println(isNumber("."));
        System.out.println(isNumber(".001"));
        System.out.println(isNumber("e9"));
        System.out.println(isNumber("1 "));
        System.out.println(isNumber("6+1"));
        System.out.println(isNumber("+.8"));
        System.out.println(isNumber("46.e3"));
        System.out.println(isNumber("+3.e04116"));
        System.out.println(isNumber(".e1"));
        System.out.println(isNumber(".2e81"));
    }

    public static boolean isNumber(String s) {
        Map<State, Map<CharType, State>> transfer = new HashMap<State, Map<CharType, State>>();
        Map<CharType, State> initialMap = new HashMap<CharType, State>() {{
            put(CharType.CHAR_SPACE, State.STATE_INITIAL);
            put(CharType.CHAR_NUMBER, State.STATE_INTEGER);
            put(CharType.CHAR_POINT, State.STATE_POINT_WITHOUT_INT);
            put(CharType.CHAR_SIGN, State.STATE_INT_SIGN);
        }};
        transfer.put(State.STATE_INITIAL, initialMap);
        Map<CharType, State> intSignMap = new HashMap<CharType, State>() {{
            put(CharType.CHAR_NUMBER, State.STATE_INTEGER);
            put(CharType.CHAR_POINT, State.STATE_POINT_WITHOUT_INT);
        }};
        transfer.put(State.STATE_INT_SIGN, intSignMap);
        Map<CharType, State> integerMap = new HashMap<CharType, State>() {{
            put(CharType.CHAR_NUMBER, State.STATE_INTEGER);
            put(CharType.CHAR_EXP, State.STATE_EXP);
            put(CharType.CHAR_POINT, State.STATE_POINT);
            put(CharType.CHAR_SPACE, State.STATE_END);
        }};
        transfer.put(State.STATE_INTEGER, integerMap);
        Map<CharType, State> pointMap = new HashMap<CharType, State>() {{
            put(CharType.CHAR_NUMBER, State.STATE_FRACTION);
            put(CharType.CHAR_EXP, State.STATE_EXP);
            put(CharType.CHAR_SPACE, State.STATE_END);
        }};
        transfer.put(State.STATE_POINT, pointMap);
        Map<CharType, State> pointWithoutIntMap = new HashMap<CharType, State>() {{
            put(CharType.CHAR_NUMBER, State.STATE_FRACTION);
        }};
        transfer.put(State.STATE_POINT_WITHOUT_INT, pointWithoutIntMap);
        Map<CharType, State> fractionMap = new HashMap<CharType, State>() {{
            put(CharType.CHAR_NUMBER, State.STATE_FRACTION);
            put(CharType.CHAR_EXP, State.STATE_EXP);
            put(CharType.CHAR_SPACE, State.STATE_END);
        }};
        transfer.put(State.STATE_FRACTION, fractionMap);
        Map<CharType, State> expMap = new HashMap<CharType, State>() {{
            put(CharType.CHAR_NUMBER, State.STATE_EXP_NUMBER);
            put(CharType.CHAR_SIGN, State.STATE_EXP_SIGN);
        }};
        transfer.put(State.STATE_EXP, expMap);
        Map<CharType, State> expSignMap = new HashMap<CharType, State>() {{
            put(CharType.CHAR_NUMBER, State.STATE_EXP_NUMBER);
        }};
        transfer.put(State.STATE_EXP_SIGN, expSignMap);
        Map<CharType, State> expNumberMap = new HashMap<CharType, State>() {{
            put(CharType.CHAR_NUMBER, State.STATE_EXP_NUMBER);
            put(CharType.CHAR_SPACE, State.STATE_END);
        }};
        transfer.put(State.STATE_EXP_NUMBER, expNumberMap);
        Map<CharType, State> endMap = new HashMap<CharType, State>() {{
            put(CharType.CHAR_SPACE, State.STATE_END);
        }};
        transfer.put(State.STATE_END, endMap);

        int length = s.length();
        State state = State.STATE_INITIAL;

        for (int i = 0; i < length; i++) {
            CharType type = toCharType(s.charAt(i));
            if (!transfer.get(state).containsKey(type)) {
                return false;
            } else {
                state = transfer.get(state).get(type);
            }
        }
        return state == State.STATE_INTEGER || state == State.STATE_POINT || state == State.STATE_FRACTION || state == State.STATE_EXP_NUMBER || state == State.STATE_END;
    }

    public static CharType toCharType(char ch) {
        if (ch >= '0' && ch <= '9') {
            return CharType.CHAR_NUMBER;
        } else if (ch == 'e' || ch == 'E') {
            return CharType.CHAR_EXP;
        } else if (ch == '.') {
            return CharType.CHAR_POINT;
        } else if (ch == '+' || ch == '-') {
            return CharType.CHAR_SIGN;
        } else if (ch == ' ') {
            return CharType.CHAR_SPACE;
        } else {
            return CharType.CHAR_ILLEGAL;
        }
    }

    enum State {
        STATE_INITIAL,
        STATE_INT_SIGN,
        STATE_INTEGER,
        STATE_POINT,
        STATE_POINT_WITHOUT_INT,
        STATE_FRACTION,
        STATE_EXP,
        STATE_EXP_SIGN,
        STATE_EXP_NUMBER,
        STATE_END,
    }

    enum CharType {
        CHAR_NUMBER,
        CHAR_EXP,
        CHAR_POINT,
        CHAR_SIGN,
        CHAR_SPACE,
        CHAR_ILLEGAL,
    }

    /**
     * 放弃
     */
    public static boolean isNumber1(String s) {
        if (s == null) {
            return false;
        }
        s = s.trim();
        if (s.length() == 0) {
            return false;
        }
        int left = 0, right = 0;
        char c;
        while (left <= right && right < s.length()) {
            c = s.charAt(left);
            if (isDigit(c)) {
                right = left;
                while (right < s.length() && isDigit(s.charAt(right))) {
                    ++right;
                }
                if (!isDigit(s.substring(left, right))) {
                    return false;
                }
                left = right;
            } else {
                if (c == '+' || c == '-') {
                    if (left != 0 && isDigit(s.charAt(left - 1))) {
                        return false;
                    }
                    ++left;
                    if (s.charAt(left) == '.') {
                        ++left;
                    }
                    right = left;
                    while (right < s.length() && isDigit(s.charAt(right))) {
                        ++right;
                    }
                    if (!isDigit(s.substring(left, right))) {
                        return false;
                    }
                } else if (c == 'e' || c == 'E') {
                    if (left == 0 || left == s.length() - 1) {
                        return false;
                    }
                    ++left;
                    if (!isDigit(s.charAt(left))) {
                        if (s.charAt(left) == '+' || s.charAt(left) == '-') {
                            ++left;
                        } else {
                            return false;
                        }
                    }
                    return isDigit(s.substring(left));
                } else if (c == '.') {
                    if (left != 0 && left == s.length() - 1) {
                        return true;
                    }
                    ++left;
                    if (left != 1 && left < s.length() && (s.charAt(left) == 'e' || s.charAt(left) == 'E')) {
                        ++left;
                    }
                    return isDigit(s.substring(left));
                } else {
                    return false;
                }
            }
        }
        return true;
    }

    public static boolean isDigit(String s) {
        if (s.length() == 0) return false;
        for (int i = 0; i < s.length(); ++i) {
            if (!isDigit(s.charAt(i))) {
                return false;
            }
        }
        return true;
    }

    public static boolean isDigit(char c) {
        int d = c - '0';
        return d >= 0 && d <= 9;
    }
}
