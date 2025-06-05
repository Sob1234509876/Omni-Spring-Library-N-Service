package top.sob.osa.server.service;

import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import top.sob.osa.server.dao.mongo.MongoUserDao;

import java.util.Map;

@Service
@Data
@NoArgsConstructor
@RequiredArgsConstructor
public class MongoUserDetailsService implements UserDetailsService {

    @NonNull
    MongoUserDao mongoUserDao;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        return mongoUserDao.findById(username).map(Map.Entry::getValue).orElseThrow(() -> new UsernameNotFoundException(username));
    }
}
