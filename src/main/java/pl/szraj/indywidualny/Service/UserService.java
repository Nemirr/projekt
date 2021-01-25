package pl.szraj.indywidualny.Service;

import org.springframework.stereotype.Service;
import pl.szraj.indywidualny.Entity.User;
import pl.szraj.indywidualny.Repository.UserRepository;

@Service
public class UserService {
    private UserRepository userRepository;

    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }
    public User findUserByName(String name){
        return userRepository.findByLogin(name);
    }
    public User findUserByLogin(String name) { return userRepository.findByLogin(name);}
    public void saveUser(User user){ userRepository.save(user);}
    public long wszyscy(){
        return userRepository.count();
    }
}