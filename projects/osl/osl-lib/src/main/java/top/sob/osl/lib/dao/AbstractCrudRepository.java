package top.sob.osl.lib.dao;

import lombok.NonNull;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.Collections;
import java.util.LinkedList;
import java.util.Map;
import java.util.concurrent.atomic.AtomicInteger;

@Repository
public abstract class AbstractCrudRepository<T, ID> implements CrudRepository<Map.Entry<ID, T>, ID> {

    @Override
    public long count() {
        var cnt = new AtomicInteger();
        findAll().forEach(t -> cnt.incrementAndGet());
        return cnt.get();
    }

    @Override
    public <S extends Map.Entry<ID, T>> @NonNull Iterable<S> saveAll(@NonNull Iterable<S> entities) {
        var lst = new LinkedList<S>();
        for (var e : entities)
            lst.add(save(e));
        return Collections.unmodifiableList(lst);
    }

    @Override
    public boolean existsById(@NonNull ID id) {
        return findById(id).isPresent();
    }

    @Override
    public @NonNull Iterable<Map.Entry<ID, T>> findAllById(@NonNull Iterable<ID> ids) {
        var lst = new LinkedList<Map.Entry<ID, T>>();
        for (var id : ids)
            findById(id).ifPresent(lst::add);
        return Collections.unmodifiableList(lst);
    }

    @Override
    public void deleteAllById(@NonNull Iterable<? extends ID> ids) {
        for (var id : ids)
            deleteById(id);
    }

    @Override
    public void deleteAll(@NonNull Iterable<? extends Map.Entry<ID, T>> entities) {
        for (var e : entities)
            delete(e);
    }
}
