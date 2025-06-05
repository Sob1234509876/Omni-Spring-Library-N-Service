package top.sob.osa.client.service;

import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import top.sob.osl.lib.util.Pair;

import java.util.Map;
import java.util.Objects;
import java.util.Optional;

@Data
@NoArgsConstructor
@RequiredArgsConstructor
@Service
public class OsaTemplate {

    @NonNull
    RestTemplate rest;

    @NonNull
    String osaUrl;

    public boolean register(@NonNull String username, @NonNull String password) {
        var res = rest.getForObject(osaUrl + "/register", boolean.class, Map.of("username", username, "password", password));
        return Boolean.TRUE.equals(res);
    }

    @SuppressWarnings("unchecked")
    public @NonNull Map.Entry<String, UserDetails> save(@NonNull Map.Entry<String, UserDetails> entity) {
        var res = rest.getForObject(osaUrl + "/system/save", Pair.class, Map.of("entity", entity));
        return Objects.requireNonNull(res);
    }

    @SuppressWarnings("unchecked")
    public @NonNull Optional<Map.Entry<String, UserDetails>> findById(@NonNull String s) {
        var res = rest.getForObject(osaUrl + "/public/find-by-id", Optional.class, Map.of("s", s));
        return Objects.requireNonNull(res);
    }

    @SuppressWarnings("unchecked")
    public @NonNull Iterable<Map.Entry<String, UserDetails>> findAll() {
        var res = rest.getForObject(osaUrl + "/public/find-all", Iterable.class);
        return Objects.requireNonNull(res);
    }

    public void deleteById(@NonNull String s) {
        rest.getForObject(osaUrl + "/system/delete-by-id", Void.class, Map.of("s", s));
    }

    public void delete(Map.@NonNull Entry<String, UserDetails> entity) {
        rest.getForObject(osaUrl + "/system/delete", Void.class, Map.of("entity", entity));
    }

    public void deleteAll() {
        rest.getForObject(osaUrl + "/system/delete-all", Void.class);
    }

    public long count() {
        var res = rest.getForObject(osaUrl + "/public/count", Long.class);
        return Objects.requireNonNull(res);
    }

    @SuppressWarnings("unchecked")
    public @NonNull Iterable<Map.Entry<String, UserDetails>> saveAll(@NonNull Iterable<Map.Entry<String, UserDetails>> entities) {
        var res = rest.getForObject(osaUrl + "/system/save-given", Iterable.class, Map.of("entities", entities));
        return Objects.requireNonNull(res);
    }

    public boolean existsById(@NonNull String id) {
        var res = rest.getForObject(osaUrl + "/public/exists-by-id", Boolean.class, Map.of("id", id));
        return Boolean.TRUE.equals(res);
    }

    @SuppressWarnings("unchecked")
    public @NonNull Iterable<Map.Entry<String, UserDetails>> findAllById(@NonNull Iterable<String> ids) {
        var res = rest.getForObject(osaUrl + "/public/find-all-by-id", Iterable.class, Map.of("ids", ids));
        return Objects.requireNonNull(res);
    }

    public void deleteAllById(@NonNull Iterable<? extends String> ids) {
        rest.getForObject(osaUrl + "/system/delete-all-by-id", Void.class, Map.of("ids", ids));
    }

    public void deleteAll(@NonNull Iterable<? extends Map.Entry<String, UserDetails>> entities) {
        rest.getForObject(osaUrl + "/system/delete-given", Void.class, Map.of("entities", entities));
    }
}
