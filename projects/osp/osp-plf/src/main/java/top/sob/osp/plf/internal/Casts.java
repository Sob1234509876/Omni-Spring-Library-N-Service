package top.sob.osp.plf.internal;

import lombok.SneakyThrows;

import java.net.URI;
import java.net.URL;

public class Casts {

    @SneakyThrows
    public static URL toURL(URI uri) {
        return uri.toURL();
    }
}
