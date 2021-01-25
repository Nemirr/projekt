package pl.szraj.indywidualny.Entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Multimedia {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    Long idMultimedi;

    Long IdWycieczki;

    String lokalizacja;

    public Multimedia(Long idWycieczki, String lokalizacja) {
        IdWycieczki = idWycieczki;
        this.lokalizacja = lokalizacja;
    }

    public Multimedia() {
    }

    public Long getIdMultimedi() {
        return idMultimedi;
    }

    public void setIdMultimedi(Long idMultimedi) {
        this.idMultimedi = idMultimedi;
    }

    public Long getIdWycieczki() {
        return IdWycieczki;
    }

    public void setIdWycieczki(Long idWycieczki) {
        IdWycieczki = idWycieczki;
    }

    public String getLokalizacja() {
        return lokalizacja;
    }

    public void setLokalizacja(String lokalizacja) {
        this.lokalizacja = lokalizacja;
    }
}
