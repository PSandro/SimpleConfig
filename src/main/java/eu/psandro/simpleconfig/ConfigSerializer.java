package eu.psandro.simpleconfig;

import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import org.yaml.snakeyaml.Yaml;

import java.util.Map;
import java.util.Set;
import java.util.regex.Pattern;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 * @author PSandro on 26.01.19
 */
@RequiredArgsConstructor
public class ConfigSerializer {

    private static final int INDENT_UNIT = 2;
    private static final String PATH_SEPARATOR_STRING = ".";
    private static final String PATH_SEPERATOR_QUOTED = Pattern.quote(PATH_SEPARATOR_STRING);

    public static String serialize(Set<Entry> data, Yaml yaml) {
        if (data.isEmpty()) return yaml.dump(null);

        final Stream<Entry> dataStream = data.stream();
        final String rawYaml = generateYaml(
                data.stream().collect(Collectors.toMap(Entry::getKey, Entry::getValue))
                , yaml);
        final StringBuilder fileData = new StringBuilder();
        int currentIndents = 0;
        String key = "";


        for (final String line : rawYaml.split("\n")) {
            if (line.isEmpty()) continue;

            int indent = getIndents(line);
            int indents = indent / INDENT_UNIT;

            String indentText = indent > 0 ? line.substring(0, indent) : "";
            if (indents <= currentIndents) {

                String[] array = key.split(PATH_SEPERATOR_QUOTED);
                int backspace = currentIndents - indents + 1;
                key = join(array, array.length - backspace);
            }

            String separator = key.length() > 0 ? PATH_SEPARATOR_STRING : "";
            String lineKey = line.contains(":") ? line.split(Pattern.quote(":"))[0] : line;
            key += separator + lineKey.substring(indent);

            currentIndents = indents;

            final String finalKey = key;
            dataStream.filter(entry -> entry.matchesKey(finalKey)).findAny().ifPresent(match -> {
                final String comment = buildComment(match, indentText);
                fileData.append(comment).append('\n');
            });

            fileData.append(line).append('\n');
        }
        return fileData.toString();
    }

    private static String buildComment(Entry entry, String indent) {
        return indent + "# " + entry.getComment();
    }

    private static String generateYaml(@NonNull Map<String, Object> data, @NonNull Yaml yaml) {
        return yaml.dump(data);
    }

    private static int getIndents(final String line) {
        int count = 0;
        for (int i = 0; i < line.length(); i++) {
            if (line.charAt(i) == ' ') count++;
            else break;
        }
        return count;
    }

    private static String join(String[] array, int length) {
        String[] copy = new String[length];
        System.arraycopy(array, 0, copy, 0, length);
        return String.join(PATH_SEPARATOR_STRING, copy);
    }


}
