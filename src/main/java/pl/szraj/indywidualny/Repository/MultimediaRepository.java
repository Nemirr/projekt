package pl.szraj.indywidualny.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import pl.szraj.indywidualny.Entity.Multimedia;

@Repository
public interface MultimediaRepository extends JpaRepository<Multimedia,Long> {
    public Multimedia findByIdMultimedi(Long id);


}
