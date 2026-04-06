package com.dreamsiteco.jobportal.company.service;

import com.dreamsiteco.jobportal.dto.CompanyDto;
import com.dreamsiteco.jobportal.entity.Company;

import java.util.List;

public interface ICompanyService {

    List<CompanyDto> getAllCompanies();
}
