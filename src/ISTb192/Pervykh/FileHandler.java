package ISTb192.Pervykh;

import java.io.*;

public class FileHandler {

    public static void addFile(String[] str, String name){
        try (BufferedWriter bw = new BufferedWriter(new FileWriter(name+".txt"))){
            str[3] = str[3].replace("[", "");
            str[3] = str[3].replace("]", "");
            bw.write(str[0]);
            bw.newLine();
            bw.write(str[1]);
            bw.newLine();
            bw.write(str[2]);
            bw.newLine();
            bw.write(str[3]);
        } catch (FileNotFoundException e) {
            System.out.println("Плохое имя файла");
        } catch (IOException e) {
            System.out.println("Ошибка записи");
        }
    }

    public static String[] fromFile(String name){
        String[] str = new String[4];
        int i = 0;
        try {
            FileReader fr = new FileReader(name+".txt");
            BufferedReader reader = new BufferedReader(fr);
            String line = reader.readLine();
            while (line != null) {
                str[i] = line;
                i++;
                System.out.println(line);
                line = reader.readLine();
            }
        } catch (FileNotFoundException e) {
            System.out.println("Плохое имя файла");
        } catch (IOException e) {
            System.out.println("Ошибка записи");
        }
        return str;
    }

    public static void addByte(int[] arr, int size, String name){
        try(DataOutputStream dos = new DataOutputStream(new FileOutputStream(name+".bin"))){
            dos.writeInt(size);
            if(size > 0){
                for (int i = 0; i < size; i++){
                    dos.writeInt(arr[i]);
                }
            }
        } catch (FileNotFoundException e) {
            System.out.println("Плохое имя файла");
        } catch (IOException e) {
            System.out.println("Ошибка записи");
        }
    }

    public static void fromByte(String name) {
        try(DataInputStream dos = new DataInputStream(new FileInputStream(name+".bin")))
        {
            int size =dos.readInt();
            int[] arr = new int[size];
            System.out.println("Исходный массив:");
            if(size > 0) {
                for (int i = 0; i < size; i++){
                    System.out.println(dos.readInt());
                }
            }
        } catch (FileNotFoundException e) {
            System.out.println("Плохое имя файла");
        } catch (IOException e) {
            System.out.println("Ошибка чтения");
        }
    }
}
