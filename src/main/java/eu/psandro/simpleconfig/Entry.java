package eu.psandro.simpleconfig;

import lombok.*;

@Data
@EqualsAndHashCode
public class Entry<E> {

    private @NonNull E value;
    private final @NonNull String key;
    private String comment;

    public boolean matchesKey(String other) {
        return this.key.equals(other);
    }

    public boolean hasComment() {
        return this.comment != null && !this.comment.isEmpty();
    }


}
