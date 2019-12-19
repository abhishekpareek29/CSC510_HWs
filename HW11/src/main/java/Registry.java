import java.util.HashMap;

public class Registry {
    private static HashMap<String, HashMap<String, NamedObject>> registry;

    static {
        registry = new HashMap<String, HashMap<String, NamedObject>>();
    }

    public static void add(String category, NamedObject namedObject) {
        if (!registry.containsKey(category)) {
            registry.put(category, new HashMap<String, NamedObject>());
        }
        registry.get(category).put(namedObject.getName(), namedObject);
    }

    public static NamedObject get(String category, String name) {
        return registry.get(category).get(name);
    }
}
