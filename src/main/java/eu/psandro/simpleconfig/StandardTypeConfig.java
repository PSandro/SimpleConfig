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

    /**
     * Get a boolean value from the loaded config.
     *
     * @param key The key for the config entry.
     * @return the value matching to this key or null.
     */

    public boolean getBoolean(@NonNull String key) {
        return super.get(key, Boolean.TYPE);
    }

    /**
     * Get a boolean value from the loaded config.
     *
     * @param key The key for the config entry.
     * @param def The value that should be returned if there is no config entry.
     * @return the value matching to this key or the fallback parameter def
     */
    public boolean getBoolean(@NonNull String key, boolean def) {
        return super.config.containsKey(key) ? super.get(key, Boolean.TYPE) : def;
    }

    /**
     * Get a string value from the loaded config.
     *
     * @param key The key for the config entry.
     * @return the value matching to this key or null.
     */
    public String getString(@NonNull String key) {
        return super.get(key, String.class);
    }

    /**
     * Get a string value from the loaded config.
     *
     * @param key The key for the config entry.
     * @param def The value that should be returned if there is no config entry.
     * @return the value matching to this key or the fallback parameter def
     */
    public String getString(@NonNull String key, @NonNull String def) {
        return super.config.containsKey(key) ? super.get(key, String.class) : def;
    }

    /**
     * Get a integer value from the loaded config.
     *
     * @param key The key for the config entry.
     * @return the value matching to this key or null.
     */
    public int getInteger(@NonNull String key) {
        return super.get(key, Integer.TYPE);
    }

    /**
     * Get a integer value from the loaded config.
     *
     * @param key The key for the config entry.
     * @param def The value that should be returned if there is no config entry.
     * @return the value matching to this key or the fallback parameter def
     */
    public int getInteger(@NonNull String key, int def) {
        return super.config.containsKey(key) ? super.get(key, Integer.TYPE) : def;
    }

    /**
     * Get a double value from the loaded config.
     *
     * @param key The key for the config entry.
     * @return the value matching to this key or null.
     */
    public double getDouble(@NonNull String key) {
        return super.get(key, Double.TYPE);
    }

    /**
     * Get a double value from the loaded config.
     *
     * @param key The key for the config entry.
     * @param def The value that should be returned if there is no config entry.
     * @return the value matching to this key or the fallback parameter def
     */
    public double getDouble(@NonNull String key, double def) {
        return super.config.containsKey(key) ? super.get(key, Double.TYPE) : def;
    }

    /**
     * Get a List<Integer> value from the loaded config.
     *
     * @param key The key for the config entry.
     * @return the value matching to this key or null.
     */
    public List<Integer> getIntegerList(@NonNull String key) {
        return (List<Integer>) super.get(key, List.class);
    }

    /**
     * Get a List<Integer>  value from the loaded config.
     *
     * @param key The key for the config entry.
     * @param def The value that should be returned if there is no config entry.
     * @return the value matching to this key or the fallback parameter def
     */
    public List<Integer> getIntegerList(@NonNull String key, @NonNull List<Integer> def) {
        return super.config.containsKey(key) ? (List<Integer>) super.get(key, List.class) : def;
    }
}
