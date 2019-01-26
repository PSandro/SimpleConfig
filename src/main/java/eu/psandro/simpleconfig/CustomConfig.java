package eu.psandro.simpleconfig;

import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import org.yaml.snakeyaml.DumperOptions;
import org.yaml.snakeyaml.Yaml;

import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.nio.charset.Charset;
import java.nio.file.Files;
import java.util.*;

@RequiredArgsConstructor
public class CustomConfig {

    private static final Charset CHARSET = Charset.forName("UTF-8");

    private Map<String, Object> config = new HashMap<>();
    private final @NonNull Set<Entry> queue = new HashSet<>();
    private final Yaml yaml = createYaml();
    private final @NonNull File file;

    public void loadConfig() throws IOException {
        final String data = new String(Files.readAllBytes(this.file.toPath()), CHARSET);
        this.config = yaml.load(data);
    }

    public void loadConfig(@NonNull InputStream is) {
        this.config = yaml.load(is);
    }

    public String saveConfigToString() {
        return ConfigSerializer.serialize(this.queue, this.yaml);
    }
    public void clear() {
        this.config.clear();
        this.queue.clear();
    }

    public void saveConfig() throws IOException {
        final byte[] bytes = this.saveConfigToString().getBytes(CHARSET);
        this.file.getParentFile().mkdirs();
        this.file.createNewFile();
        Files.write(this.file.toPath(), bytes);
    }

    public void set(@NonNull Entry... entries) {
        for (Entry entry : entries) {
            this.config.put(entry.getKey(), entry.getValue());
            this.queue.add(entry);
        }
    }

    public Map<String, Object> getEntries() {
        return this.config;
    }

    public <E> E get(String key, Class<E> type) {
        return (E) this.config.get(key);
    }


    public Optional<Entry> findInQueue(final @NonNull String key) {
        return this.queue.stream().filter(entry -> entry.matchesKey(key)).findAny();
    }

    private static Yaml createYaml() {
        final DumperOptions options = new DumperOptions();
        options.setDefaultFlowStyle(DumperOptions.FlowStyle.BLOCK);
        options.setPrettyFlow(false);
        options.setIndent(2);
        return new Yaml(options);
    }
}
