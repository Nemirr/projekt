package pl.szraj.indywidualny.Controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.view.RedirectView;
import pl.szraj.indywidualny.Entity.Multimedia;
import pl.szraj.indywidualny.Entity.User;
import pl.szraj.indywidualny.Entity.Wycieczka;
import pl.szraj.indywidualny.Repository.WycieczkaRepository;
import pl.szraj.indywidualny.Service.MultimediaService;
import pl.szraj.indywidualny.Service.UserService;

import java.security.Principal;
import java.util.ArrayList;
import java.util.List;

@Controller
public class WycieczkiController {


    WycieczkaRepository wycieczkaRepository;
    MultimediaService multimediaService;
    UserService userService;


    public WycieczkiController(WycieczkaRepository wycieczkaRepository, MultimediaService multimediaService, UserService userService) {
        this.wycieczkaRepository = wycieczkaRepository;
        this.multimediaService = multimediaService;
        this.userService = userService;
    }

    @GetMapping("/Wycieczki/{id}")
    public String getDetails(@PathVariable String id, Model model) {
        Wycieczka wycieczka = wycieczkaRepository.findByIdWycieczki(Long.parseLong(id));
        model.addAttribute("wycieczka", wycieczka);


        List<Multimedia> zdjecia = multimediaService.findAll();
        List<Multimedia> zd = new ArrayList<>();
        for (Multimedia m : zdjecia) {
            if (m.getIdWycieczki() == (wycieczka.getIdWycieczki())) {
                zd.add(m);
            }
        }
        if (zd.stream().count() == 6) {
            model.addAttribute("button", false);
        } else {
            model.addAttribute("button", true);
        }
        model.addAttribute("zdjecia", zd);
        return "Wycieczki/Szczegoly";
    }

    @GetMapping("/Wycieczki/Lista")
    public String getList(Model model,Principal principal) {
        List<Wycieczka> wycieczkaList = wycieczkaRepository.findAll();
        model.addAttribute("wycieczki", wycieczkaList);
        if(principal!=null) {
        User user = userService.findUserByName(principal.getName());

            model.addAttribute("user", user);
        } else {
            model.addAttribute("user",new User());
        }
        return "Wycieczki/Lista";
    }


    @PostMapping("/Wycieczki/DodajZdjecie")
    public RedirectView dodajZdjecie(@RequestParam("file") MultipartFile file, @ModelAttribute("Wycieczka") Wycieczka wycieczka) {

        if (!file.isEmpty()) {
            multimediaService.dodajZdjecie(wycieczka, file);
        }
        return new RedirectView("/Index");
    }

    @GetMapping("/Wycieczki/DodajWycieczke")
    public String addRecipe(Model model) {
        model.addAttribute("Wycieczka", new Wycieczka());
        return "Wycieczki/DodajWycieczke";
    }

    @PostMapping("/Wycieczki/DodajWycieczke")
    public RedirectView dodajWycieczke(@ModelAttribute("Wycieczka") Wycieczka wycieczka, Principal principal) {
        User user = userService.findUserByName(principal.getName());
        wycieczka.setIdUzytkownika(user.getIDuser());
        wycieczkaRepository.save(wycieczka);

        return new RedirectView("/Index");
    }


}



