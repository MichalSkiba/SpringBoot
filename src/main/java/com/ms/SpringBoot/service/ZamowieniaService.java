package com.ms.SpringBoot.service;

import com.ms.SpringBoot.Model.Zamowienia;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface ZamowieniaService {

    public List<Zamowienia> findAll();

    public  void saveZamowienia(Zamowienia zamowienia);

    public Page<Zamowienia> findAllPages(Pageable pageable);
}
