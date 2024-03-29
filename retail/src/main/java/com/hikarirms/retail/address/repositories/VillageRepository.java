package com.hikarirms.retail.address.repositories;

import com.hikarirms.retail.address.entities.Village;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface VillageRepository extends JpaRepository<Village, String> {

    @Query("SELECT p FROM Village p " +
            "WHERE (p.name ILIKE CONCAT('%',:name,'%') OR :name is null)" +
            " AND (p.districtCode=:districtCode OR :districtCode is null)")
    Page<Village> findByParams(String name, String districtCode, Pageable pageable);

}
