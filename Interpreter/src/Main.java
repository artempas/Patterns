
interface Expression {
    String interpret(String input);
}

class SpaceCorrector implements Expression {

    public String interpret(String input) {
        return input.replaceAll(" +", " ");
    }
}

class DashCorrector implements Expression {

    public String interpret(String input) {
        return input.replace("-", "—");
    }
}

class QuotesCorrector implements Expression {

    public String interpret(String input) {
        StringBuilder result = new StringBuilder();
        boolean openQuote = true;

        for (char c : input.toCharArray()) {
            if (c == '“' || c == '”') {
                if (openQuote) {
                    result.append('«');
                } else {
                    result.append('»');
                }
                openQuote = !openQuote;
            } else {
                result.append(c);
            }
        }

        return result.toString();
    }
}

class BracketCorrector implements Expression {

    public String interpret(String input) {
        return input.replaceAll("\\(\\s+", "(")
                .replaceAll("\\s+\\)", ")")
                .replaceAll("\\s+,", ",")
                .replaceAll("\\s+\\.", ".");
    }
}

class NewLineCorrector implements Expression {

    public String interpret(String input) {
        return input.replaceAll("\n\n+", "\n");
    }
}

public class Main implements Expression {

    private final Expression[] expressions;

    public Main() {
        expressions = new Expression[] {
                new SpaceCorrector(),
                new DashCorrector(),
                new QuotesCorrector(),
                new BracketCorrector(),
                new NewLineCorrector()
        };
    }

    public String interpret(String input) {
        for (Expression expression : expressions) {
            input = expression.interpret(input);
        }
        return input;
    }

    public static void main(String[] args) {
        Main interpreter = new Main();
        String input = """
        Это текст с лишним  количеством   пробелов, где используются дефисы (-) вместо тире (—), 
        используются "кавычки" вместо «кавычек», а также имеются ненужные пробелы ( например, перед запятой ). 

        Также наблюдается  множественный переход на   новую   строку. 
        """;

        System.out.print(interpreter.interpret(input));
    }
}