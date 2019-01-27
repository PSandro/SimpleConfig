package eu.psandro.simpleconfig;

import lombok.NonNull;

import java.io.File;
import java.util.List;

/**
 * @author PSandro on 27.01.19
 * @project yamlcomment
 */
public class StandardTypeConfig extends CustomConfig {

    public StandardTypeConfig(@NonNull File file) {
        super(file);
    }

    public boolean getBoolean(@NonNull String key) {
        return super.get(key, Boolean.TYPE);
    }

    public boolean getBoolean(@NonNull String key, boolean def) {
        return super.config.containsKey(key) ? super.get(key, Boolean.TYPE) : def;
    }

    public String getString(@NonNull String key) {
        return super.get(key, String.class);
    }

    public String getString(@NonNull String key, @NonNull String def) {
        return super.config.containsKey(key) ? super.get(key, String.class) : def;
    }

    public int getInteger(@NonNull String key) {
        return super.get(key, Integer.TYPE);
    }

    public int getInteger(@NonNull String key, int def) {
        return super.config.containsKey(key) ? super.get(key, Integer.TYPE) : def;
    }

    public double getDouble(@NonNull String key) {
        return super.get(key, Double.TYPE);
    }

    public double getDouble(@NonNull String key, double def) {
        return super.config.containsKey(key) ? super.get(key, Double.TYPE) : def;
    }

    public List<Integer> getIntegerList(@NonNull String key) {
        return (List<Integer>) super.get(key, List.class);
    }

    public List<Integer> getIntegerList(@NonNull String key, @NonNull List<Integer> def) {
        return super.config.containsKey(key) ? (List<Integer>) super.get(key, List.class) : def;
    }
}
