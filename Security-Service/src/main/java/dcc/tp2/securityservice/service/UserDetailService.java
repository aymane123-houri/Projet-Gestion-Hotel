package dcc.tp2.securityservice.service;

import dcc.tp2.securityservice.feignClient.UserFeignClient;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Collection;

@Service
public class UserDetailService implements UserDetailsService {

    private final UserFeignClient userFeignClient;

    public UserDetailService(UserFeignClient userFeignClient) {
        this.userFeignClient = userFeignClient;
    }

    @Override
    public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {
        dcc.tp2.securityservice.model.User user = userFeignClient.getUserCredentials(email);
        Collection<GrantedAuthority> authorities = new ArrayList<>();
        authorities.add(new SimpleGrantedAuthority("Guest"));
        return new User(user.getNom() + ' ' + user.getPrenom(), user.getPassword(), authorities);
    }

}
