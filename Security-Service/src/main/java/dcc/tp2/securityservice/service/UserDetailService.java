package dcc.tp2.securityservice.service;

import dcc.tp2.securityservice.feignClient.AdministratorFeign;
import dcc.tp2.securityservice.feignClient.UserFeignClient;
import dcc.tp2.securityservice.model.Administrator;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

@Service
public class UserDetailService implements UserDetailsService {

    private final UserFeignClient userFeignClient;
    private final AdministratorFeign administratorFeign;

    public UserDetailService(UserFeignClient userFeignClient, AdministratorFeign administratorFeign) {
        this.userFeignClient = userFeignClient;
        this.administratorFeign = administratorFeign;
    }

 /*   @Override
    public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {
        dcc.tp2.securityservice.model.User user = userFeignClient.getUserCredentials(email);
        Collection<GrantedAuthority> authorities = new ArrayList<>();
        authorities.add(new SimpleGrantedAuthority("Guest"));
        return new User(user.getNom() + ' ' + user.getPrenom(), user.getPassword(), authorities);
    }*/

    @Override
    public UserDetails loadUserByUsername(String combinedUsername) throws UsernameNotFoundException {
        String[] parts = combinedUsername.split(":");
        if (parts.length != 2) {
            throw new UsernameNotFoundException("Invalid username format. Expected format: email:type");
        }

        String email = parts[0];
        String userType = parts[1];
        System.out.println("DANS USER DETAIL ");
        Administrator administrator = new Administrator();

        if (userType.equals("Receptionist")) {
            System.out.println("YES Receptionist");
            administrator = administratorFeign.getAdministrator(email);

        }

        if (userType.equals("Admin")) {
            System.out.println("YES Admin");
            administrator = administratorFeign.getAdministrator(email);
            System.out.println(administrator);
        }

        Collection<GrantedAuthority> authorities = new ArrayList<>();
        authorities.add(new SimpleGrantedAuthority(administrator.getRole()));

        return new User(administrator.getNom()+" "+administrator.getPrenom() , "{noop}" + administrator.getPassword(), authorities);
    }

}


