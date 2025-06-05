package top.sob.osa.server.service;

import lombok.*;
import org.springframework.data.repository.CrudRepository;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import top.sob.osl.lib.dao.AbstractCrudRepository;
import top.sob.osl.lib.util.Pair;

import java.util.Map;
import java.util.Optional;

@EqualsAndHashCode(callSuper = true)
@Service
@Data
@NoArgsConstructor
@RequiredArgsConstructor
public class OsaServerService extends AbstractCrudRepository<UserDetails, String> {

    @NonNull
    PasswordEncoder passwordEncoder;

    @NonNull
    CrudRepository<Map.Entry<String, UserDetails>, String> userDao;

    @NonNull
    UserInitializerService userInitializerService;

    public boolean register(@NonNull String username, @NonNull String password) {
        if (userDao.existsById(username))
            return false;

        var encP = passwordEncoder.encode(password);
        var user = userInitializerService.init(username, encP);
        userDao.save(new Pair<>(username, user));

        return true;
    }

    @Override
    public <S extends Map.Entry<String, UserDetails>> @NonNull S save(@NonNull S entity) {
        return userDao.save(entity);
    }

    @Override
    public @NonNull Optional<Map.Entry<String, UserDetails>> findById(@NonNull String s) {
        return userDao.findById(s);
    }

    @Override
    public @NonNull Iterable<Map.Entry<String, UserDetails>> findAll() {
        return userDao.findAll();
    }

    @Override
    public void deleteById(@NonNull String s) {
        userDao.deleteById(s);
    }

    @Override
    public void delete(Map.@NonNull Entry<String, UserDetails> entity) {
        userDao.delete(entity);
    }

    @Override
    public void deleteAll() {
        userDao.deleteAll();
    }
}
