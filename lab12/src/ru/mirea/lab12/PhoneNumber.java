package ru.mirea.lab12;

public class PhoneNumber {

    public PhoneNumber() {
    }

    public String ConvertNumber(String number) {
        if (number.charAt(0) == '8') {
            return "+7"
                    + number.substring(1, 4) + "-"
                    + number.substring(4, 7) + "-"
                    + number.substring(7);
        } else {
            int x = number.length() - 11;
            return "+"
                    + number.substring(1, x)
                    + number.substring(x , x + 2)
                    + number.substring(x + 2, x + 5) + "-"
                    + number.substring(x + 5, x + 8) + "-"
                    + number.substring(x + 7);
        }
    }

}
