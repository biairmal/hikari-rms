package com.hikarirms.retail.address.repositories;

import com.hikarirms.retail.address.entities.Province;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface ProvinceRepository extends JpaRepository<Province, String> {

    @Query("SELECT p FROM Province p " +
            "WHERE (p.name ILIKE CONCAT('%',:name,'%') OR :name is null)")
    Page<Province> findByParams(String name, Pageable pageable);

}
