package com.dreamsiteco.jobportal.repository;

import com.dreamsiteco.jobportal.entity.Company;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository  //Optional but just good for readablity Springs Knows this is a Repository as we are extending JpaRepository

public interface CompanyRepository extends JpaRepository<Company, Long>
{

}
