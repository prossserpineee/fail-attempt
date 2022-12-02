import java.util.Scanner;
import java.util.regex.*;
public class lab_2_2 {
    public static void main(String[] args){
        System.out.println("Введите пароль");
        Scanner in = new Scanner(System.in);
        Pattern password_pattern1 = Pattern.compile("^[A-Za-z0-9_]{8,}$");
        Pattern password_pattern2 = Pattern.compile("[A-Z]");
        Pattern password_pattern3 = Pattern.compile("[a-z]");
        Pattern password_pattern4 = Pattern.compile("[0-9]");
        while (true) {
            String password_str = in.nextLine();
            Matcher matcher_password1 = password_pattern1.matcher(password_str);
            Matcher matcher_password2 = password_pattern2.matcher(password_str);
            Matcher matcher_password3 = password_pattern3.matcher(password_str);
            Matcher matcher_password4 = password_pattern4.matcher(password_str);
            if (matcher_password1.matches() && matcher_password2.find() && matcher_password3.find() && matcher_password4.find()) {
                System.out.println("Пароль надежен");
                break;
            } else {
                System.out.println("Пароль ненадежен. Повторите ввод");
            }
        }
    }
}