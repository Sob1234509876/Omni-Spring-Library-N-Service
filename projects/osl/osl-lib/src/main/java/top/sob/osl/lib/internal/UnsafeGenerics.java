package top.sob.osl.lib.internal;

public class UnsafeGenerics {
    @SuppressWarnings("unchecked")
    public static <T, R> R cast(T t) {
        return (R) t;
    }
}
