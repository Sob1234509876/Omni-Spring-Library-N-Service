package top.sob.osl.lib.util;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;

import java.util.Map;

@SuppressWarnings("unused")
@Getter
@NoArgsConstructor
@RequiredArgsConstructor
public class Pair<K, V> implements Map.Entry<K, V> {
    @NonNull
    K key;

    @NonNull
    V value;

    public K setKey(@NonNull K key) {
        var old = getKey();
        this.key = key;
        return old;
    }

    @Override
    public V setValue(V value) {
        var old = getValue();
        this.value = value;
        return old;
    }
}
