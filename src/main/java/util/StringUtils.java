package util;

import java.util.Random;

public class StringUtils {
    String SALTCHARS = "ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz";
    String numbers = "1234567890";
    Random rnd = new Random();

    public String generateRandomText(int length) {
        StringBuilder stringBuilder = new StringBuilder();
        for (int i = 0; i < length; ++i) {
            int i1 = rnd.nextInt(SALTCHARS.length());
            stringBuilder.append(SALTCHARS.charAt(i1));
        }
        return stringBuilder.toString();
    }
    public String generateRandomAlfaNumeric(int length) {
        StringBuilder stringBuilder = new StringBuilder();
        for (int i = 0; i < length; ++i) {
            int i1 = rnd.nextInt(SALTCHARS.length());
            stringBuilder.append(SALTCHARS.charAt(i1));
        }
        return stringBuilder.toString();
    }
}
