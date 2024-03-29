package com.hikarirms.retail.address.repositories;

import com.hikarirms.retail.address.entities.Regency;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface RegencyRepository extends JpaRepository<Regency, String> {

    @Query("SELECT p FROM Regency p " +
            "WHERE (p.name ILIKE CONCAT('%',:name,'%') OR :name is null)" +
            " AND (p.provinceCode=:provinceCode OR :provinceCode is null)")
    Page<Regency> findByParams(String name, String provinceCode, Pageable pageable);

}
