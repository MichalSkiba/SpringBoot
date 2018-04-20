package com.ms.SpringBoot.service.impl;

import com.ms.SpringBoot.Model.Magazyn;
import com.ms.SpringBoot.Repository.MagazynRepository;
import com.ms.SpringBoot.service.MagazynService;
import org.springframework.beans.factory.annotation.Autowired;

public class MagazynServiceImpl implements MagazynService {

    @Autowired
    MagazynRepository magazynRepository;

    @Override
    public void saveMagazyn(Magazyn magazyn) {
        magazynRepository.save(magazyn);
    }
}