package top.sob.osl.lib.dao.mongo;

import lombok.*;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.stereotype.Repository;
import top.sob.osl.lib.dao.AbstractCrudRepository;
import top.sob.osl.lib.internal.UnsafeGenerics;
import top.sob.osl.lib.util.Pair;

import java.util.Map;
import java.util.Optional;

@Data
@EqualsAndHashCode(callSuper = true)
@NoArgsConstructor
@RequiredArgsConstructor
@Repository
public abstract class AbstractMongoCrudRepository<T, ID> extends AbstractCrudRepository<T, ID> {

    public static final String ID_KEY_NAME = "key";

    @NonNull
    MongoTemplate mongo;

    @Override
    public <S extends Map.Entry<ID, T>> @NonNull S save(@NonNull S entity) {
        return mongo.save(entity);
    }

    @Override
    public @NonNull Optional<Map.Entry<ID, T>> findById(@NonNull ID id) {
        var crit = Criteria.where(ID_KEY_NAME).is(id);
        var res = mongo.find(Query.query(crit), Pair.class);
        if (res.isEmpty()) return Optional.empty();
        return Optional.of(UnsafeGenerics.cast(res.get(0)));
    }

    @Override
    public @NonNull Iterable<Map.Entry<ID, T>> findAll() {
        return UnsafeGenerics.cast(mongo.findAll(Pair.class));
    }

    @Override
    public long count() {
        var crit = Criteria.where(ID_KEY_NAME).exists(true);
        return mongo.count(Query.query(crit), Pair.class);
    }

    @Override
    public void deleteById(@NonNull ID id) {
        var crit = Criteria.where(ID_KEY_NAME).is(id);
        mongo.remove(Query.query(crit), Pair.class);
    }

    @Override
    public void delete(Map.@NonNull Entry<ID, T> entity) {
        mongo.remove(entity);
    }

    @Override
    public void deleteAll() {
        var crit = Criteria.where(ID_KEY_NAME).exists(true);
        mongo.remove(Query.query(crit), Pair.class);
    }
}
