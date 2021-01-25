package pl.szraj.indywidualny.Entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.util.Date;

@Entity
public class Wycieczka {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    Long idWycieczki;

    String start;
    String meta;
    String wojewodztwo;
    String data;
    int dlugosc;

    long idUzytkownika;

    public long getIdUzytkownika() {
        return idUzytkownika;
    }

    public void setIdUzytkownika(long idUzytkownika) {
        this.idUzytkownika = idUzytkownika;
    }

    public Long getIdWycieczki() {
        return idWycieczki;
    }

    public void setIdWycieczki(Long idWycieczki) {
        this.idWycieczki = idWycieczki;
    }

    public String getStart() {
        return start;
    }

    public void setStart(String start) {
        this.start = start;
    }

    public String getMeta() {
        return meta;
    }

    public void setMeta(String meta) {
        this.meta = meta;
    }

    public String getWojewodztwo() {
        return wojewodztwo;
    }

    public void setWojewodztwo(String wojewodztwo) {
        this.wojewodztwo = wojewodztwo;
    }

    public String getData() {
        return data;
    }

    public void setData(String data) {
        String[] e = data.split(" ");
        this.data = e[0];
    }

    public int getDlugosc() {
        return dlugosc;
    }

    public void setDlugosc(int dlugosc) {
        this.dlugosc = dlugosc;
    }

    public Wycieczka(String start, String meta, String wojewodztwo, String data, int dlugosc) {
        this.start = start;
        this.meta = meta;
        this.wojewodztwo = wojewodztwo;
        this.data = data;
        this.dlugosc = dlugosc;
    }

    public Wycieczka() {
    }
}
