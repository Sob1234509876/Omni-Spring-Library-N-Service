package top.sob.osa.server.service;

import org.springframework.security.core.userdetails.UserDetails;

@FunctionalInterface
public interface UserInitializerService {

    UserDetails init(String username, String encPassword);

}
