package ss.week5;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class MapUtil {
    public static <K, V> boolean isOneOnOne(Map<K, V> map) {
        return map.entrySet().size() == new HashSet<>(map.values()).size();
    }
    public static <K, V> 
           boolean isSurjectiveOnRange(Map<K, V> map, Set<V> range) {
        return new HashSet<>(map.values()).size() == range.size();
    }
    public static <K, V> Map<V, Set<K>> inverse(Map<K, V> map) {
        Map<V, Set<K>> inverseMap = new HashMap<>();

        map.keySet().forEach(key -> {
            V value = map.get(key);
            Set<K> keys = inverseMap.containsKey(value) ? inverseMap.get(value) : new HashSet<>();
            keys.add(key);

            inverseMap.put(value, keys);
        });

        return inverseMap;
	}

	// @Requires isOneOnOne(map)
	public static <K, V> Map<V, K> inverseBijection(Map<K, V> map) {
        Map<V, K> inverseMap = new HashMap<>();

        map.keySet().forEach(key -> {
            inverseMap.put(map.get(key), key);
        });

        return inverseMap;
	}
	public static <K, V, W> boolean compatible(Map<K, V> f, Map<V, W> g) {
        Set<V> allKeys = new HashSet<>(g.keySet());
        allKeys.addAll(f.values());

        return allKeys.size() == g.keySet().size();
	}

	// @Requires compatible(f, g)
	public static <K, V, W> Map<K, W> compose(Map<K, V> f, Map<V, W> g) {
        Map<K, W> composedMap = new HashMap<>();

        f.keySet().forEach(key -> {
            composedMap.put(key, g.get(f.get(key)));
        });

        return composedMap;
	}
}
