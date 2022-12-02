import java.util.regex.*;
import java.util.Scanner;
public class lab_2_1 {

    public static void main(String[] args) {
        System.out.println("Введите дату рождения в формате dd/mm/yyyy: ");
        Scanner in = new Scanner(System.in);
        String text = in.nextLine();
        Pattern pattern1 = Pattern.compile("^\\d{2}/\\d{2}/\\d{4}$");
        Pattern pattern2 = Pattern.compile("\\d{2}");
        Pattern month31 = Pattern.compile("^(0[1-9]|[12][0-9]|3[01])/(0[1-9]|1[012])/(19\\d{2}|[2-9]\\d{3})$");
        Pattern month30 = Pattern.compile("^(0[1-9]|[12][0-9]|30)/(0[1-9]|1[012])/(19\\d{2}|[2-9]\\d{3})$");
        Pattern month29 = Pattern.compile("^(0[1-9]|[12][0-9])/(02)/(19\\d{2}|[2-9]\\d{3})$");
        Pattern month28 = Pattern.compile("^(0[1-9]|[12][0-8])/(02)/(19\\d{2}|[2-9]\\d{3})$");
        Matcher matcher1 = pattern1.matcher(text);
        Matcher matcher2 = pattern2.matcher(text);
        Matcher matcher31 = month31.matcher(text);
        Matcher matcher30 = month30.matcher(text);
        Matcher matcher29 = month29.matcher(text);
        Matcher matcher28 = month28.matcher(text);
        String month = "", year = "";
        if (!matcher1.matches()){
            System.out.println("Введенное выражение не соответствует заданному формату даты dd/mm/yyyy");
        }
        else {
            if (matcher31.matches()) {
                int count = 1;
                while (matcher2.find()) {
                    if (count == 2) {
                        month = matcher2.group();
                    }
                    if (count == 3 || count == 4) {
                        year = year + matcher2.group();
                    }
                    count++;
                }
            }
            switch (month) {
                case "01", "03", "05", "07", "08", "10", "12":
                    if (!matcher31.matches()) {
                        System.out.println("Введенное выражение не является датой");
                    } else {
                        System.out.println("Введенное выражение является датой");
                    }
                    break;
                case "04", "06", "09", "11":
                    if (!matcher30.matches()) {
                        System.out.println("Введенное выражение не является датой");
                    } else {
                        System.out.println("Введенное выражение является датой");
                    }
                    break;
                case "02":
                    if (Integer.parseInt(year) % 4 == 0) {
                        if (!matcher29.matches()) {
                            System.out.println("Введенное выражение не является датой");
                        } else {
                            System.out.println("Введенное выражение является датой");
                        }
                    }
                    else {
                        if (!matcher28.matches()) {
                            System.out.println("Введенное выражение не является датой");
                        } else {
                            System.out.println("Введенное выражение является датой");
                        }
                    }
                    break;
                default:
                    System.out.println("Введенное выражение не является датой");
            }}
        }
    }
