public class Lc1106hard {
    int idx = 0;
    public boolean parseBoolExpr(String expression) {
        return solve(expression);
    }

    private boolean solve(String exp) {
        char ch = exp.charAt(idx);

        // Case 1: literal
        if (ch == 't') {
            idx++;
            return true;
        }
        if (ch == 'f') {
            idx++;
            return false;
        }

        // Case 2: operator
        char op = ch;
        idx += 2; // skip operator and '('

        boolean result = (op == '&') ? true : false;

        while (exp.charAt(idx) != ')') {
            boolean val = solve(exp);

            if (op == '&') result &= val;
            else if (op == '|') result |= val;
            else if (op == '!') result = !val;

            if (exp.charAt(idx) == ',') idx++; // skip comma
        }

        idx++; // skip ')'
        return result;
    }
}
