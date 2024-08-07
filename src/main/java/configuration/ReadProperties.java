package configuration;

import java.io.IOException;
import java.util.Properties;

public class ReadProperties {
    private static final Properties properties;

    static {
        properties = new Properties();
        try {
            properties.load(ReadProperties.class.getClassLoader().getResourceAsStream("config.properties"));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static String getUrl() {
        return properties.getProperty("url");
    }

    public static String browserName() {
        return properties.getProperty("browser");
    }

    public static String usernameStandard() {
        return properties.getProperty("username_standard");
    }
    public static String usernameLockedOut() {
        return properties.getProperty("username_locked_out");
    }
    public static String usernameProblem() {
        return properties.getProperty("username_problem");
    }
    public static String usernamePerformanceGlitch() {
        return properties.getProperty("username_performance_glitch");
    }
    public static String usernameError() {
        return properties.getProperty("username_error");
    }
    public static String usernameVisual() {
        return properties.getProperty("username_visual");
    }

    public static String password() {
        return properties.getProperty("password");
    }

    public static boolean isHeadless() {
        return properties.getProperty("headless").equalsIgnoreCase("true");
    }
}