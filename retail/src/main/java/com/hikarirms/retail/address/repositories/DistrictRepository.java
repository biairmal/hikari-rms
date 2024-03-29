package com.hikarirms.retail.address.repositories;

import com.hikarirms.retail.address.entities.District;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface DistrictRepository extends JpaRepository<District, String> {

    @Query("SELECT p FROM District p " +
            "WHERE (p.name ILIKE CONCAT('%',:name,'%') OR :name is null)" +
            " AND (p.regencyCode=:regencyCode OR :regencyCode is null)")
    Page<District> findByParams(String name, String regencyCode, Pageable pageable);

}
