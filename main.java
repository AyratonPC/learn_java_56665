import java.io.IOException;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Scanner;

public class main {
    public static int exam_user_str(int num, int num2, String str) {
        if (str.equals("+")) {
            return num + num2;
        } else if (str.equals("-")) {
            return num - num2;
        } else if (str.equals("*")) {
            return num * num2;
        } else if (str.equals("/")) {
            return num / num2;
        }
        System.out.println("Строка не является математической операцией");
        return 0;
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
        System.out.println(Arrays.toString(user_str));
        if (user_str.length != 3) {
            try {
                throw new IOException();
            } catch (IOException e) {
                System.out.println("Ошибка ввода");
            }
        } else if () {
            try {
                throw new IOException();
            } catch (IOException e) {
                System.out.println("Ошибка. Разные цифры");
            }
        } else {
            if (!rim_dct.containsKey(user_str[0])) {
                int first_number = Integer.parseInt(user_str[0]);
                int second_number = Integer.parseInt(user_str[2]);
                String naked = user_str[1];
                int result = exam_user_str(first_number, second_number, naked);
                System.out.println(result);
            } else {
                int first_number = rim_dct.get(user_str[0]);
                int second_number = rim_dct.get(user_str[2]);
                String naked = user_str[1];
                int result = exam_user_str(first_number, second_number, naked);
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
            }
        }
    }
}


