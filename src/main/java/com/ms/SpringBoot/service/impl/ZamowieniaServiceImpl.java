package com.ms.SpringBoot.service.impl;

import com.ms.SpringBoot.Model.Magazyn;
import com.ms.SpringBoot.Model.Role;
import com.ms.SpringBoot.Model.User;
import com.ms.SpringBoot.Model.Zamowienia;
import com.ms.SpringBoot.Repository.MagazynRepository;
import com.ms.SpringBoot.Repository.RoleRepository;
import com.ms.SpringBoot.Repository.UserRepository;
import com.ms.SpringBoot.Repository.ZamowienieRepository;
import com.ms.SpringBoot.service.UserService;
import com.ms.SpringBoot.service.ZamowieniaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Arrays;
import java.util.HashSet;
import java.util.List;

@Service("zamowieniaService")
@Transactional
public class ZamowieniaServiceImpl implements ZamowieniaService {

	@Autowired
	private ZamowienieRepository zamowienieRepository;

	@Autowired
	private MagazynRepository magazynRepository;

	@Override
	public List<Zamowienia> findAll() {
		List<Zamowienia> zamoList = null;
		zamoList = zamowienieRepository.findAll();
		return zamoList;
	}

	@Override
	public void saveZamowienia(Zamowienia zamowienia) {
		zamowienieRepository.save(zamowienia);

		Magazyn magazyn = new Magazyn();
		magazyn.setIdZamowienia(zamowienia.getId());
		magazyn.setNrZamowienia(zamowienia.getNrZamowienia());
		magazyn.setIloscZamowiona(zamowienia.getIloscZamowiona());
		magazyn.setIloscPrzyjeta(zamowienia.getIloscPrzyjeta());
		magazyn.setDataPrzyjecia(zamowienia.getDataZamowienia());
		magazyn.setOsoba("Michał");

		magazynRepository.save(magazyn);

	}

	@Override
	public Page<Zamowienia> findAllPages(Pageable pageable) {
		Page<Zamowienia> pages = zamowienieRepository.findAll(pageable);
		return pages;
	}


}
