public class Calc {
    static Main main = new Main();
    static String exp1 = main.exp;
    static Converter converter = new Converter();
    static String[] actions = {"+", "-", "/", "*"};
    static String[] regexActions = {"\\+", "-", "/", "\\*"};
    static String[] data;
    static int actionIndex = -1;

    public static String[] arithmeticOperation() throws Exception {//Определяет арифметическое действие
        for (int i = 0; i < actions.length; i++) {
            if (exp1.contains(actions[i])) {
                actionIndex = i;
                break;
            }
        }
        if (actionIndex == -1) {
            throw new Exception("Строка не является математической операцией");
        }
        data = exp1.replaceAll("\\s", "").split(regexActions[actionIndex]);
        if (data.length < 3) {
            return data;
        } else {
            throw new Exception("Формат математической операции не удовлетворяет заданию - два операнда и один оператор");
        }
    }

    public static String calc(String input) throws Exception {
        arithmeticOperation();
        boolean isRoman1 = converter.isRoman(data[0]);
        boolean isRoman2 = converter.isRoman(data[1]);
        if (isRoman1 != isRoman2) {
            throw new Exception("Используются одновременно разные системы счисления");
        }
        int a = isRoman1 ? converter.romanToInt(data[0]) : Integer.parseInt(data[0]);
        int b = isRoman2 ? converter.romanToInt(data[1]) : Integer.parseInt(data[1]);
        if (a >= 1 && a <= 10 && b >= 1 && b <= 10) {
            int result = switch (actions[actionIndex]) {
                case "+" -> a + b;
                case "-" -> a - b;
                case "*" -> a * b;
                default -> a / b;
            };
            if (isRoman1) {
                System.out.println(converter.intToRoman(result));
                if (result < 0) {
                    throw new Exception("Число меньше 1");
                }
            } else {
                System.out.println(result);
            }
        } else {
            throw new Exception("Числа больше 10 или меньше 1");
        }
        return input;
    }
}






