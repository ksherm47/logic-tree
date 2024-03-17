package util;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.annotations.Expose;
import lombok.Getter;

import java.io.FileReader;
import java.io.IOException;
import java.io.Reader;

public final class Settings {
    private static final Gson GSON = new GsonBuilder()
            .excludeFieldsWithModifiers()
            .excludeFieldsWithoutExposeAnnotation()
            .create();
    private static final String DEFAULT_SETTINGS_PATH = "settings.json";
    public static final double DEFAULT_AND_PROB = 0.2;
    public static final double DEFAULT_OR_PROB = 0.2;
    public static final double DEFAULT_XOR_PROB = 0.2;
    public static final double DEFAULT_NOT_PROB = 0.2;

    @Getter @Expose private static Long seed;
    @Getter @Expose private static Integer depth;
    @Getter @Expose private static Double andProb = DEFAULT_AND_PROB;
    @Getter @Expose private static Double orProb = DEFAULT_OR_PROB;
    @Getter @Expose private static Double xorProb = DEFAULT_XOR_PROB;
    @Getter @Expose private static Double notProb = DEFAULT_NOT_PROB;

    private Settings() {}

    public static void init() {
        init(DEFAULT_SETTINGS_PATH);
    }

    public static void init(String settingsPath) {
        try (Reader fileReader = new FileReader(settingsPath)) {
            GSON.fromJson(fileReader, Settings.class);
        } catch (IOException ex) {
            System.out.println(ex.getMessage());
        }
    }
}
