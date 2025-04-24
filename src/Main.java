import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        try {
            String input = scanner.nextLine(); // читаю строку
            String result = calc(input); // метод
            System.out.println(result); // результат
        } catch (Exception e) {
            System.out.println("throws Exception");
        }
    }

    public static String calc(String input) throws Exception {
        // тут туплю спрашивала чат gpt
        input = input.replace(" ", "");

        // Ищем оператор
        char operator = 0;
        int operatorIndex = -1;

        for (int i = 0; i < input.length(); i++) {
            char c = input.charAt(i);
            if (c == '+' || c == '-' || c == '*' || c == '/') {
                operator = c;
                operatorIndex = i;
                break;
            }
        }

        // Если оператор не найден — ошибка
        if (operatorIndex == -1) {
            throw new Exception();
        }

        // Получаем левое и правое число
        String left = input.substring(0, operatorIndex);
        String right = input.substring(operatorIndex + 1);

        int a = Integer.parseInt(left);
        int b = Integer.parseInt(right);

        // Проверка диапазона
        if (a < 1 || a > 10 || b < 1 || b > 10) {
            throw new Exception();
        }

        int result = 0;

        // Выполняем операцию
        if (operator == '+') {
            result = a + b;
        } else if (operator == '-') {
            result = a - b;
        } else if (operator == '*') {
            result = a * b;
        } else if (operator == '/') {
            result = a / b;
        } else {
            throw new Exception();
        }

        return String.valueOf(result);
    }
}



