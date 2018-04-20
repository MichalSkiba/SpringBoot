package com.ms.SpringBoot.Model;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.sql.Date;

@Entity
@Table(name = "magazyn")
public class Magazyn {

        @Id
        @GeneratedValue(strategy = GenerationType.AUTO)
        @Column(name = "id")
        @NotNull
        private int id;

        @NotNull
        private int idZamowienia;

        @NotNull
        private String nrZamowienia;

        @NotNull
        private int iloscZamowiona;

        @NotNull
        private int iloscPrzyjeta;

        @NotNull
        private Date dataPrzyjecia;

        @NotNull
        private String osoba;

        @Transient
        private String operacja;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getIdZamowienia() {
        return idZamowienia;
    }

    public void setIdZamowienia(int idZamowienia) {
        this.idZamowienia = idZamowienia;
    }

    public String getNrZamowienia() {
        return nrZamowienia;
    }

    public void setNrZamowienia(String nrZamowienia) {
        this.nrZamowienia = nrZamowienia;
    }

    public int getIloscZamowiona() {
        return iloscZamowiona;
    }

    public void setIloscZamowiona(int iloscZamowiona) {
        this.iloscZamowiona = iloscZamowiona;
    }

    public int getIloscPrzyjeta() {
        return iloscPrzyjeta;
    }

    public void setIloscPrzyjeta(int iloscPrzyjeta) {
        this.iloscPrzyjeta = iloscPrzyjeta;
    }

    public Date getDataPrzyjecia() {
        return dataPrzyjecia;
    }

    public void setDataPrzyjecia(Date dataPrzyjecia) {
        this.dataPrzyjecia = dataPrzyjecia;
    }

    public String getOsoba() {
        return osoba;
    }

    public void setOsoba(String osoba) {
        this.osoba = osoba;
    }

    public String getOperacja() {
        return operacja;
    }

    public void setOperacja(String operacja) {
        this.operacja = operacja;
    }
}
