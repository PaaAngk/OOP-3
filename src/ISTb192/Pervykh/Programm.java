package ISTb192.Pervykh;

public class Programm {
    static void Programm1() {
        Digit pr1 = new Digit(30);
        System.out.println("Данный ряд:");
        pr1.Print(pr1.naturalRyadx2(30));// Создание натурального ряда
        System.out.println();
        System.out.println("Четные: ");
        pr1.Print(pr1.p1(30, 1));// Вывод четных элементов массива pr1
        System.out.println();
        System.out.println("Нечетные: ");
        pr1.Print(pr1.p1(30, 2));// Вывод нечетных элементов массива pr1
    }
    static void Programm2(String str1) {
        Sentenc str = new Sentenc(str1);// Объявляю объект str класса Sentenc
        str.inp2Symb(65, 91);
        str.inp2Symb(48, 58);
        str.inp1Symb(32, "Пробел");
        str.inp1Symb(44, "Запятая");
        str.inp1Symb(46, "Точка");
    }
    static void Programm3(int msize, String cond, int[] mas) {
        int n, moreThan;
        Digit digi = new Digit(mas);
        Sentenc str = new Sentenc(cond);

        moreThan = str.moreThan();// Определение знака больше или меньше в веденной строке
        n = str.numStr();// Определения числа в введенной строке

        System.out.println("Множество чисел удовлетворяющие условию: ");
        digi.printMass(moreThan, n, msize);
    }
}
