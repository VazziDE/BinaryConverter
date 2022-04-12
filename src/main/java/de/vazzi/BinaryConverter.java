package de.vazzi;

import java.util.ArrayList;
import java.util.Scanner;

public class BinaryConverter {

    public static ArrayList<Integer> binaryList = new ArrayList<Integer>();

    public static void main(String[] args) {
        initBinaryList();
        Scanner scanner = new Scanner(System.in);
        while (scanner.hasNextLine()) {
            String input = scanner.nextLine();
            String wantedNumber = input.split(" ")[0];
            if (isNumeric(wantedNumber)) {
                if (wantedNumber.length() < 10) {
                    if (Integer.parseInt(wantedNumber) <= 1073741824) {
                        System.out.println("Your input: " + wantedNumber);
                        convertToBinary(Integer.parseInt(wantedNumber));
                    } else {
                        System.out.println("Reached Maximum Number of 1073741824");
                    }
                } else {
                    System.out.println("Input length can be longer then 9");
                }
            } else {
                System.out.println("Input is not a number");
            }
        }
    }

    public static void initBinaryList() {
        int last = 1;
        binaryList.add(1);
        for (int i = 0; i < 30; i++) {
            last = Math.multiplyExact(last, 2);
            binaryList.add(last);
        }
    }

    public static void convertToBinary(Integer targetInt) {

        int total = 0;
        StringBuilder binary = new StringBuilder();

        for (int i = binaryList.size(); i > 0; i--) {
            if (total + binaryList.get(i - 1) <= targetInt) {
                binary.append("1");
                total += binaryList.get(i - 1);
                //Used Int: binaryList.get(i - 1))
            } else {
                if (!binary.toString().equals("")) {
                    binary.append("0");
                }
            }
        }
        System.out.println("Binary Result: " + binary);

    }

    public static boolean isNumeric(String target) {
        for (char c : target.toCharArray()) {
            if (!Character.isDigit(c)) return false;
        }
        return true;
    }

}
