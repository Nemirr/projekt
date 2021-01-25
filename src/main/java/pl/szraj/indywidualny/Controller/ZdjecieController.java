package pl.szraj.indywidualny.Controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import pl.szraj.indywidualny.Entity.Multimedia;
import pl.szraj.indywidualny.Service.MultimediaService;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;

@RestController
public class ZdjecieController {

    MultimediaService multimediaService;

    public ZdjecieController(MultimediaService multimediaService) {
        this.multimediaService = multimediaService;
    }
    @GetMapping("zdjecia/{id}")
    public byte[] zdjecie(@PathVariable String id) throws IOException {
        Multimedia multimedia = multimediaService.findById(Long.parseLong(id));
        File file = new File(multimedia.getLokalizacja());
        return Files.readAllBytes(file.toPath());
    }
}
