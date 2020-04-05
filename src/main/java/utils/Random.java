package utils;

public class Random {
    private static String arr = "abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ0123456789";

    public static String getRandomName() {
        StringBuffer stringBuffer = new StringBuffer();
        for (int i = 0; i < 25; i++) {
            stringBuffer.append(arr.charAt((int) (Math.random() * 62)));
        }
        return stringBuffer.toString();
    }
}
