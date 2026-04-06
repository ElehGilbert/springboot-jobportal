package com.dreamsiteco.jobportal.service.impl;

import com.dreamsiteco.jobportal.dto.CompanyDto;
import com.dreamsiteco.jobportal.entity.Company;
import com.dreamsiteco.jobportal.repository.CompanyRepository;
import com.dreamsiteco.jobportal.service.ICompanyService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;


@Service
@RequiredArgsConstructor //Mentioning this, Lombok is going to generate a contructor by taking all the final marked fields as an input like this " private final ICompanyService companyService;"
public class CompanyServiceImpl implements ICompanyService {

    //We want to make a call direct to the database
    private final CompanyRepository companyRepository;

//    @Autowired
//    public CompanyServiceImpl(CompanyRepository companyRepository) {
//        this.companyRepository = companyRepository;
//    }



    @Override
    public List<CompanyDto> getAllCompanies() {
List<Company> companyList = companyRepository.findAll();
     return    companyList.stream().map(this::transformToDto).collect(Collectors.toList());

    }





    //The DTO mapper Logic
    private CompanyDto transformToDto(Company company){
        return new CompanyDto(company.getId(),company.getName(),company.getLogo()
                ,company.getIndustry(),company.getSize(),company.getRating(),company.getLocations(), company.getEmployees(),
                company.getDescription(), company.getFounded(), company.getWebsite(), company.getCreatedAt());
    }
}
