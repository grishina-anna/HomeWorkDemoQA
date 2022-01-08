package guru.qa.docs;

import com.google.gson.JsonParseException;

import static guru.qa.utils.RandomUtils.getRandomString;

public class RamdomUtilExample {
    public static void main(String[] args) {
        System.out.println(getRandomString(10));
    }
}
