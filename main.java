import java.io.IOException;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Scanner;
import java.util.ArrayList;

public class main {
    public static int calc(int num, int num2, String str) {
        switch (str) {
            case "+" -> {
                return num + num2;
            }
            case "-" -> {
                return num - num2;
            }
            case "*" -> {
                return num * num2;
            }
            case "/" -> {
                return num / num2;
            }
        }
        System.out.println("Строка не является математической операцией");
        return 0;
    }

    public static boolean isNumeric(String str) {
        try {
            Integer.parseInt(str);
            return true;
        } catch (NumberFormatException e) {
            return false;
        }
    }

    public static String input() {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Введите пример: ");
        return scanner.nextLine();
    }

    public static void main(String[] args) {
        HashMap<String, Integer> rim_dct = new HashMap<>();
        rim_dct.put("I", 1);
        rim_dct.put("II", 2);
        rim_dct.put("III", 3);
        rim_dct.put("IV", 4);
        rim_dct.put("V", 5);
        rim_dct.put("VI", 6);
        rim_dct.put("VII", 7);
        rim_dct.put("VIII", 8);
        rim_dct.put("IX", 9);
        rim_dct.put("X", 10);

        String[] user_str = input().split(" ");
        if (user_str.length != 3) {
            try {
                throw new IOException();
            } catch (IOException e) {
                System.out.println("Ошибка ввода");
            }
        } else if (isNumeric(user_str[0]) && isNumeric(user_str[2])) {
            int first_number = Integer.parseInt(user_str[0]);
            int second_number = Integer.parseInt(user_str[2]);
            if (first_number > 10 || second_number > 10 || first_number <= 0 || second_number <= 0)  {
                try {
                    throw new IOException();
                } catch (IOException e) {
                    System.out.println("цифры от 1 до 10");
                }
            } else {
                String naked = user_str[1];
                int result = calc(first_number, second_number, naked);
                System.out.println(result);
            }
        } else if (rim_dct.containsKey(user_str[0]) && rim_dct.containsKey(user_str[2])) {
            int first_number = rim_dct.get(user_str[0]);
            int second_number = rim_dct.get(user_str[2]);
            String naked = user_str[1];
            int result = calc(first_number, second_number, naked);
            if (result < 0) {
                try {
                    throw new IOException();
                } catch (IOException e) {
                    System.out.println("Ошибка. В римской системе нет отрицательных чисел");
                }
            } else {
                String[] keys = rim_dct.keySet().toArray(new String[0]);
                int index = 0;
                for (int i = 0; i < keys.length; i++) {
                    if (rim_dct.get(keys[i]) == result) {
                        index = i;
                        break;
                    }
                }
                String resultStr = keys[index];
                System.out.println(resultStr);
            }
        } else {
            try {
                throw new IOException();
            } catch (IOException e) {
                System.out.println("Ошибка. Разные цифры");
            }
        }
    }
}
