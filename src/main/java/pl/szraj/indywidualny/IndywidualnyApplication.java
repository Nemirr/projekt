package pl.szraj.indywidualny;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import pl.szraj.indywidualny.Entity.User;
import pl.szraj.indywidualny.Service.MultimediaService;
import pl.szraj.indywidualny.Service.UserService;
import pl.szraj.indywidualny.Service.WycieczkaService;

@SpringBootApplication
public class IndywidualnyApplication {

    public static void main(String[] args) {
        SpringApplication.run(IndywidualnyApplication.class, args);
    }


}
