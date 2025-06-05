package top.sob.osa.server.service;

import org.springframework.security.core.userdetails.UserDetails;
import top.sob.osl.lib.util.BeanUser;

public class DefaultUserInitializerService implements UserInitializerService {
    @Override
    public UserDetails init(String username, String encPassword) {
        var tmp = new BeanUser();
        tmp.setUsername(username);
        tmp.setPassword(encPassword);
        return tmp;
    }
}
