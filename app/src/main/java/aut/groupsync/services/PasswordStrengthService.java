package aut.groupsync.services;

public class PasswordStrengthService {

    public int getPasswordStrength(String temp) {
        int length = 0, uppercase = 0, lowercase = 0, digits = 0, symbols = 0, bonus = 0, requirements = 0;

        int lettersonly = 0, numbersonly = 0, cuc = 0, clc = 0;

        length = temp.length();
        for (int i = 0; i < temp.length(); i++) {
            if (Character.isUpperCase(temp.charAt(i)))
                uppercase++;
            else if (Character.isLowerCase(temp.charAt(i)))
                lowercase++;
            else if (Character.isDigit(temp.charAt(i)))
                digits++;

            symbols = length - uppercase - lowercase - digits;

        }

        for (int j = 1; j < temp.length() - 1; j++) {
            if (Character.isDigit(temp.charAt(j)))
                bonus++;

        }

        for (int k = 0; k < temp.length(); k++) {

            if (Character.isUpperCase(temp.charAt(k))) {
                k++;

                if (k < temp.length()) {
                    if (Character.isUpperCase(temp.charAt(k))) {
                        cuc++;
                        k--;
                    }
                }
            }
        }

        for (int l = 0; l < temp.length(); l++) {
            if (Character.isLowerCase(temp.charAt(l))) {
                l++;

                if (l < temp.length()) {

                    if (Character.isLowerCase(temp.charAt(l))) {

                        clc++;
                        l--;

                    }

                }

            }

        }

        if (length > 7) {
            requirements++;
        }

        if (uppercase > 0) {
            requirements++;
        }

        if (lowercase > 0) {
            requirements++;
        }

        if (digits > 0) {
            requirements++;
        }

        if (symbols > 0) {
            requirements++;
        }

        if (bonus > 0) {
            requirements++;
        }

        if (digits == 0 && symbols == 0) {
            lettersonly = 1;
        }

        if (lowercase == 0 && uppercase == 0 && symbols == 0) {
            numbersonly = 1;
        }

        int Total = (length * 4) + ((length - uppercase) * 2)
                + ((length - lowercase) * 2) + (digits * 4) + (symbols * 6)
                + (bonus * 2) + (requirements * 2) - (lettersonly * length * 2)
                - (numbersonly * length * 3) - (cuc * 2) - (clc * 2);



        if (Total < 30) {
            return Total - 15;
        } else if (Total >= 40 && Total < 50) {
            return Total - 20;
        } else if (Total >= 56 && Total < 70) {
            return Total - 25;
        } else if (Total >= 76) {
            return Total - 30;
        } else {
            return Total - 20;
        }
    }
}