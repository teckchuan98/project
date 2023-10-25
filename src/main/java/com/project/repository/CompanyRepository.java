package com.project.repository;

import com.project.entity.Company;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface CompanyRepository extends JpaRepository<Company, Long> {
    @Query(value = "SELECT Company FROM company WHERE name = :companyName", nativeQuery = true)
    Company findByName(@Param("companyName") String name);

    @Modifying
    @Query(value = "DELETE FROM company WHERE name = :companyName", nativeQuery = true)
    void deleteByName(@Param("companyName") String name);

}
