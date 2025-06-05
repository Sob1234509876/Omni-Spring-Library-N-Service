package top.sob.osl.lib.util;

import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.Collection;

@Data
@NoArgsConstructor
@RequiredArgsConstructor
public class BeanUser implements UserDetails {

    @NonNull
    Collection<? extends GrantedAuthority> authorities;

    @NonNull
    String password;

    @NonNull
    String username;

    boolean accountNonExpired;

    boolean accountNonLocked;

    boolean credentialsNonExpired;

    boolean enabled;

}
