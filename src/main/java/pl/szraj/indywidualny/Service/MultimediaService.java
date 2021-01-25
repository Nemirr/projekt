package pl.szraj.indywidualny.Service;

import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;
import pl.szraj.indywidualny.Entity.Multimedia;
import pl.szraj.indywidualny.Entity.Wycieczka;
import pl.szraj.indywidualny.Repository.MultimediaRepository;

import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;

@Service
public class MultimediaService {
MultimediaRepository multimediaRepository;

    public MultimediaService(MultimediaRepository multimediaRepository) {
        this.multimediaRepository = multimediaRepository;
    }

    private void dodaj(Wycieczka wycieczka, Path path){
        Multimedia multimedia = new Multimedia(wycieczka.getIdWycieczki(),path.toString());
        multimediaRepository.save(multimedia);
    }


    public void dodajZdjecie(Wycieczka wycieczka, MultipartFile file) {
        try {
            String folder = "src\\main\\resources\\zdjecia\\";
            Path path = Paths.get(folder + wycieczka.getIdWycieczki() + file.getOriginalFilename());
            Files.write(path, file.getBytes());
            dodaj(wycieczka,path);
        } catch (Exception e) {
            e.getMessage();
        }
    }

    public Multimedia findById(Long id){
        return multimediaRepository.findByIdMultimedi(id);
    }



    public List<Multimedia> findAll(){
        return multimediaRepository.findAll();
    }
}
