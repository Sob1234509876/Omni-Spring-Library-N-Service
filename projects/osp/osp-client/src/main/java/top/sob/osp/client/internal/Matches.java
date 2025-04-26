package top.sob.osp.client.internal;

import top.sob.osp.app.annotation.Plugin;

import java.util.Map;

public class Matches {
    public static boolean match(Object plugin, Map<String, String> meta) {
        var a = plugin.getClass().getAnnotation(Plugin.class);

        if (a == null) return false;

        return meta.get("name").equals(a.name()) && meta.get("version").equals(a.version());
    }
}
