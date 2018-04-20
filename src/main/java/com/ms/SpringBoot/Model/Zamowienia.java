package com.ms.SpringBoot.Model;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.sql.Date;

@Entity
@Table(name = "zamowienia")
public class Zamowienia {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id")
    @NotNull
    private int id;

    @Column(name = "nr_zamowienia")
    @NotNull
    private String nrZamowienia;

    @Column(name = "data_zamowienia")
    @NotNull
    private Date dataZamowienia;

    @Column(name = "ilosc_zamowiona")
    @NotNull
    private int iloscZamowiona;

    @Column(name = "data_przyjecia")
    private Date dataPrzyjecia;

    @Column(name= "ilosc_przyjeta")
    private int iloscPrzyjeta;

    @Column(name = "kompletne")
    @NotNull
    private String kompletne;

    @Transient
    private String operacja;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNrZamowienia() {
        return nrZamowienia;
    }

    public void setNrZamowienia(String nrZamowienia) {
        this.nrZamowienia = nrZamowienia;
    }

    public Date getDataZamowienia() {
        return dataZamowienia;
    }

    public void setDataZamowienia(Date dataZamowienia) {
        this.dataZamowienia = dataZamowienia;
    }

    public int getIloscZamowiona() {
        return iloscZamowiona;
    }

    public void setIloscZamowiona(int iloscZamowiona) {
        this.iloscZamowiona = iloscZamowiona;
    }

    public Date getDataPrzyjecia() {
        return dataPrzyjecia;
    }

    public void setDataPrzyjecia(Date dataPrzyjecia) {
        this.dataPrzyjecia = dataPrzyjecia;
    }

    public int getIloscPrzyjeta() {
        return iloscPrzyjeta;
    }

    public void setIloscPrzyjeta(int iloscPrzyjeta) {
        this.iloscPrzyjeta = iloscPrzyjeta;
    }

    public String getKompletne() {
        return kompletne;
    }

    public void setKompletne(String kompletne) {
        this.kompletne = kompletne;
    }

    public String getOperacja() {
        return operacja;
    }

    public void setOperacja(String operacja) {
        this.operacja = operacja;
    }
}
