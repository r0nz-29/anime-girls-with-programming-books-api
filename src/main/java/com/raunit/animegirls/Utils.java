package com.raunit.animegirls;

import java.util.Random;

public class Utils {
    public static final String BASE_URL = "https://api.github.com/repos/cat-milk/Anime-Girls-Holding-Programming-Books";

    public static int randomIntBetween(int lower, int upper) {
        Random r = new Random();
        return r.nextInt(upper - lower) + lower;
    }
}
