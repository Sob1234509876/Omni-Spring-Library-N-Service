package top.sob.osp.app.loader;

import lombok.extern.slf4j.Slf4j;
import top.sob.osp.app.annotation.Plugin;
import top.sob.osp.app.bean.PLD;
import top.sob.osp.app.internal.Casts;

import java.net.*;
import java.nio.file.Path;
import java.util.stream.Stream;

@Slf4j
public class AppClassLoader extends URLClassLoader {

    static URL[] cast(String[] paths) {
        return Stream.of(paths)
                .map(Path::of)
                .map(Path::toAbsolutePath)
                .map(Path::toUri)
                .map(Casts::toURL).toArray(URL[]::new);
    }

    public AppClassLoader(String[] path) {
        super(cast(path));
    }

    public Class<?> loadPluginClass(PLD description) throws ClassNotFoundException {
        var clazz = loadClass(description.getClazz());

        if (clazz.getAnnotation(Plugin.class) == null)
            throw new ClassNotFoundException(description.getClazz());

        return clazz;
    }
}
