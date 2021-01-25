package pl.szraj.indywidualny.Repository;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import pl.szraj.indywidualny.Entity.User;

@Repository
public interface UserRepository extends JpaRepository<User,Long> {
    User findByLogin(String name);

}