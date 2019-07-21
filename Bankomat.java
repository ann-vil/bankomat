package ru.project.ann;

import java.util.Scanner;
import java.io.IOException;
import java.io.*;

/*
    ==========================================================================================================
    Это моя первая практическая работа, ранее ни разу не применяла на практике теоретические знания основ Java.
    Пожалуйста, не судите строго.
    Оставляю только работающую часть (частично в коментариях оставила недоработанные куски).
    Допустим что у нас есть общий пин для доступа к любой карте.
    ===========================================================================================================
*/

public class Bankomat{

    private static Scanner in;
    private static float balance;
    private static int anotherOperation;
    private static int pin;


    public static void main (String args[]){
        in = new Scanner (System.in);
        cardNumber();
        pincode();
        operation();
    }


    private static void cardNumber() {

        int size = 16;
        String array [] = new String [size];

       /* String str = in.nextInt();
        String [] subStr;
        String delimeter = "-";
*/
        System.out.println("Введите номер карты: \n"); //после каждой цыфры нажимать Enter
        for (int i = 0; i < size; i++) {
            array[i] = in.nextLine();
        }

        System.out.print("Номер Вашей карты: ");
        for (int i = 0; i < 4; i++) {
            System.out.print(array[i]);
        }
        System.out.print("-");

        for (int i = 4; i < 8; i++) {
            System.out.print(array[i]);
        }
        System.out.print("-");

        for (int i = 8; i < 12; i++) {
            System.out.print(array[i]);
        }
        System.out.print("-");

        for (int i = 12; i < size; i++) {
            System.out.print(array[i]);
        }
        System.out.println();

    }



    private static void pincode() {
        int rightPin = 1234;
        System.out.println("Введите пин-код: \n");
        pin = in.nextInt();

/*      DataFile user = new DataFile();
        user.enterCode();

 */
        while (pin != rightPin) {
                System.out.println("Неверный пин-код. Попробуйте еще раз.\n");
                pin = in.nextInt();
            }
        System.out.println("Доступ к счету получен.\n");
    }



    private static void operation() {
        int choice;
        float limit = 1000000;

        System.out.println("Выберите необходимую операцию");
        System.out.println("1. Просмотр баланса");
        System.out.println("2. Снятие наличных");
        System.out.println("3. Пополнение баланса");
        System.out.println("4. Выход");

        choice = in.nextInt();

        switch(choice) {
            case 1:
                System.out.println("Ваш баланс "+balance+"$\n");
                anotherOperation();
                break;

            case 2:
                float summa;
                System.out.println("Укажите сумму, которую Вы хотите снять: ");
                summa = in.nextFloat();
                if (summa > balance || summa >= limit){
                    System.out.println("Недостаточно средств на счете\n\n");
                    anotherOperation();
                }
                else {
                    balance = balance - summa;
                    System.out.println("Вы сняли со счета "+summa+"$.\nВаш баланс "+balance+"$\n");
                    anotherOperation();
                }
                break;

            case 3:
                float popolnenie;
                System.out.println("Введите сумму для пополнения баланса: ");
                popolnenie = in.nextFloat();
                if (popolnenie == 0 || popolnenie > limit) {
                    System.out.println("Неверно введенная сумма\n\n");
                    anotherOperation();
                }
                else {
                    balance = balance + popolnenie;
                    System.out.println("Вы пополнили счет на "+popolnenie+"$.\nВаш баланс "+balance+"$\n");
                    anotherOperation();
                }
                break;

            case 4:
                System.out.println("Операция завершена.");
                break;

            default:
                System.out.println("Неверно выбранная операция.\nПовторите попытку.");
                anotherOperation();
                break;

        }

    }
    private static void anotherOperation(){
        System.out.println("Введите:\n1. Для выбора операции;\n2. Для выхода");
        anotherOperation = in.nextInt();
        if (anotherOperation == 1){
            operation();
        }
        else if (anotherOperation == 2) {
            System.out.println("Операция завершена.");
        }
        else {
            System.out.println("Неверно введенные данные.\nПовторите попытку.");
            anotherOperation();
        }
    }
}

/*
class DataFile {
    private static Scanner in;
    public void enterCode()  {
        File file = new File("DataFile.txt");
        try {
            PrintWriter writer = new PrintWriter( new BufferedWriter (new FileWriter(file, true)));

            writer.println(in.nextLine());
            writer.flush();
            writer.close();
        }
        catch (IOException ex){
            ex.printStackTrace();
        }
    }
    public void readCode() {
        try {
            DataInputStream findCode = new DataInputStream(new FileInputStream("DataFile.txt"));
            byte[] info = new byte[1000];
            while (findCode.available() != 0) {
                int count = findCode.read(info);
                if (count >= 0) {
                    System.out.println(new String(info));
                }
            }

        } catch (IOException ex) {
            ex.printStackTrace();
        }
    }
}

--------------------------------
public class Client {
    Client client = new Client ();
    String account;



    if номер катры не найден в файле {
        записать в файл новый номер карты и баланс
        balance = 0;
    }
    else {
        balance = выбрать из файла соответствующее значение
    }
}
-----------------------------------------
*/




