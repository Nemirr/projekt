package pl.szraj.indywidualny.Service;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import pl.szraj.indywidualny.Entity.User;
import pl.szraj.indywidualny.Security.MyUserDetails;

@Service
public class MyUserDetailsService implements UserDetailsService {

    private UserService userService;

    @Autowired
    public MyUserDetailsService(UserService userService) {
        this.userService = userService;
    }

    @Override
    public UserDetails loadUserByUsername(String s) throws UsernameNotFoundException {
        User user = userService.findUserByName(s);
        if (user != null) {
            return new MyUserDetails(user);
        } else {
            throw new UsernameNotFoundException("User with name " + s + " not found");
        }
    }
}