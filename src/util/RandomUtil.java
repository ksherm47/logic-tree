package util;

import java.util.Date;
import java.util.Random;

public final class RandomUtil {

    private static Random random;

    public static void init() {
        init(null);
    }

    public static void init(Long seed) {
        random = new Random(seed == null ? new Date().getTime() : seed);
    }

    public static Random getRandomInstance() {
        if (random == null) {
            throw new RuntimeException("No seed has been initialized, use RandomUtil.init() to set");
        }
        return random;
    }
}
