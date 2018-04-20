package com.ms.SpringBoot.Repository;

import com.ms.SpringBoot.Model.Magazyn;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository("magazynRepository")
public interface MagazynRepository extends JpaRepository<Magazyn, Long>{
}
