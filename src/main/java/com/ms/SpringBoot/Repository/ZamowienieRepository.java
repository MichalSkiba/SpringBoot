package com.ms.SpringBoot.Repository;

import com.ms.SpringBoot.Model.Zamowienia;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository("zamowienieRepository")
public interface ZamowienieRepository extends JpaRepository<Zamowienia, Long > {
}
