package pl.szraj.indywidualny.Service;

import org.springframework.stereotype.Service;
import pl.szraj.indywidualny.Entity.Wycieczka;
import pl.szraj.indywidualny.Repository.WycieczkaRepository;

@Service
public class WycieczkaService {
WycieczkaRepository wycieczkaRepository;

public Wycieczka findByID(Long id){
    return wycieczkaRepository.findByIdWycieczki(id);

}

public long wszystkie(){
    return wycieczkaRepository.count();
}


}
