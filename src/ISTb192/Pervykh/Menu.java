package ISTb192.Pervykh;

import java.io.*;
import java.util.*;

public class Menu {
    private static String strPr2;
    private static int msize;
    private static String cond;
    private static int[] mas;

    public static void start() {
        menuMain();
    }

    public static int readChoice() {
        Scanner sc = new Scanner(System.in);
        int read = -1;
        try {
            read = Integer.parseInt(sc.nextLine());
        }
        catch (NumberFormatException ex){
            System.out.println("Введите толко значение пунктов меню.");
            read = readChoice();
        }
        return read;
    }

    public static void setVar(){
        Scanner sc = new Scanner(System.in);
        strPr2 = Input.inputVerPr2();

        System.out.println("Введите длину множества чисел: ");
        msize = Input.inputVer();

        System.out.println("Введите условие Ваше услови, > 0 || < 10: ");
        cond = sc.nextLine();

        int[] mas = new int[msize];
        System.out.println("Введите элементы массива: ");
        for (int i = 0; i < msize; i++) {
            System.out.println("Элемент " + (i+1) + " массива: ");
            mas[i] = Input.inputVer();
        }
        setMas(mas);
    }

    private static void menuMain() {
        Scanner sc = new Scanner(System.in);
        int choice = -1;
        do{
            try {
                System.out.println("Главное меню");
                System.out.println("1 - Ввести данные из файла");
                System.out.println("2 - Задать данные");
                System.out.println("3 - Сохранить данные в файл");
                System.out.println("4 - Выполнить программы");
                System.out.println("5 - Работа с байтовыми данными");
                System.out.println("6 - Постановка задач");
                System.out.println("0 - Выйти");
                choice = readChoice();
                switch (choice){
                    case 1:
                        System.out.println("Введите имя txt файла");
                        String name = sc.nextLine();
                        String[] str = FileHandler.fromFile(name);
                        strPr2 = str[0];
                        try {
                            msize = Integer.parseInt(str[1]);
                        } catch (NumberFormatException xe) {
                            System.out.println("Неверный ввод размера массива");
                        }
                        cond = str[2];
                        int[] mas = new int[msize];
                        String[] items = str[3].split(", ");
                        for (int i = 0; i < msize; i++) {
                            try {
                                mas[i] = Integer.parseInt(items[i]);
                            } catch (NumberFormatException nfe) {
                                System.out.println("Неверный ввод размера массива");
                            }
                        }
                        setMas(mas);
                        break;
                    case 2:
                        setVar();
                        break;
                    case 3:
                        String[] str1 = new String[4];
                        str1[0] = strPr2;
                        str1[1] = Integer.toString(msize);
                        str1[2] = cond;
                        str1[3] = Arrays.toString(Menu.mas);
                        System.out.println("Введите имя txt файла");
                        String names = sc.nextLine();
                        FileHandler.addFile(str1, names);
                        break;
                    case 4:
                        menu();
                        break;
                    case 5:
                        menuByte();
                        break;
                    case 6:
                        System.out.println("Постановка задач");
                        System.out.println("1 - Сгенерируйте числовой ряд длиной 30 элементов, представляющий квадраты чисел \n натурального ряда. Сформируйте из полученных значений два массива: один с четными \n значениями, другой с нечетными.");
                        System.out.println("2 - Подсчитайте, какие символы наиболее часто встречаются в пред-ложении.");
                        System.out.println("3 - Выберите из множества числа, удовлетворяющие условию, введен-ному в виде строке при запуске программы (“>0” или “<10”).");
                        break;
                    case 0:
                        choice = 0;
                    default:
                        System.out.println("Введите толко значение пунктов меню.");
                }
            }
            catch (NullPointerException ex){
               System.out.println("Вначале задайте данные");
            }
        }
        while (choice != 0);
    }
    private static void menu() {
        Scanner sc = new Scanner(System.in);
        int choice = -1;
        do{
            try {
                System.out.println();
                System.out.println("Выполнение программ");
                System.out.println("1 - Выполнить 1 программу");
                System.out.println("2 - Выполнить 2 программу");
                System.out.println("3 - Выполнить 3 программу");
                System.out.println("0 - Назад");
                choice = readChoice();
                switch (choice){
                    case 1:
                        Programm.Programm1();
                        break;
                    case 2:
                        Programm.Programm2(strPr2);
                        break;
                    case 3:
                        Programm.Programm3(msize, cond, mas);
                        break;
                    case 0:
                        menuMain();
                        break;
                    default:
                        System.out.println("Введите толко значение пунктов меню.");
                }
            }
            catch (NullPointerException ex){
                System.out.println("Вначале задайте данные");
            }
        }
        while (choice != 0);
    }

    private static void menuByte() {
        Scanner sc = new Scanner(System.in);
        int choice = -1;
        do{
            try {
                System.out.println();
                System.out.println("Работа с байтовыми данными");
                System.out.println("1 - Задать и сохранить файл");
                System.out.println("2 - Считать и вывести файл");
                System.out.println("0 - Назад");
                choice = readChoice();
                switch (choice){
                    case 1:
                        System.out.println("Введите имя файла");
                        String filename = sc.nextLine();
                        System.out.println("Введите длину множества чисел: ");
                        msize = Input.inputVer();
                        int[] mas = new int[msize];
                        System.out.println("Введите элементы массива: ");
                        for (int i = 0; i < msize; i++) {
                            System.out.println("Элемент " + (i+1) + " массива: ");
                            mas[i] = Input.inputVer();
                        }
                        FileHandler.addByte(mas, msize, filename);
                        System.out.println("Сохранено!");
                        break;
                    case 2:
                        System.out.println("Введите имя файла");
                        String name = sc.nextLine();
                        FileHandler.fromByte(name);
                        break;
                    case 0:
                        menuMain();
                        break;
                    default:
                        System.out.println("Введите толко значение пунктов меню.");
                }
            }
            catch (NullPointerException ex){
                System.out.println("Вначале задайте данные");
            }
        }
        while (choice != 0);
    }

    public static void setMas(int[] mas) {
        Menu.mas = mas;
    }
}
