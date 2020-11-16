package ISTb192.Pervykh;

import java.util.Scanner;

public class Input {
    // Ввод и проверка строки  для задачи 2
    public static String inputVerPr2(){
        Scanner sc = new Scanner(System.in);
        String str;
        System.out.println("Введите строку: (Буквы, цифры, запятая, точка и пробел.)");
        str = sc.nextLine();
        while (!str.matches("[A-Za-z0-9,. ]+")){
            System.out.println("Неправильный ввод, повторите ввод.(Буквы, цифры, запятая, точка и пробел.)");
            str = sc.nextLine();
        }
        return str;
    }

    // Ввод целого числа
    public static int inputVer(){
        Scanner sc = new Scanner(System.in);
        int scan;
        do {
            while (!sc.hasNextInt()) {
                System.out.println("Это не число!");
                sc.next();
            }
            scan = sc.nextInt();
        } while ((scan % 1) != 0);// Если эквивалентно целому числу.
        return scan;
    }
}



/*while ((n != 0) && (n != 10)){
            System.out.println("Неправильное условие, повторите ввод (> 0 || < 10):");
            s = sc.nextLine();
            s1 = s.split(" ");
            if (s1[0].equals(">")){moreThan = 1;}
            else {moreThan = 2;}
            n = Integer.parseInt(s1[1]);
        }*/