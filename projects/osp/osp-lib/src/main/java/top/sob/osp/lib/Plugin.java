package top.sob.osp.lib;

import java.util.Map;

public interface Plugin {
    String getName();

    String getVersion();

    Map<?, ?> getProperties();
}
