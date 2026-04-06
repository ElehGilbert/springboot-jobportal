package com.dreamsiteco.jobportal.company.controller;

import com.dreamsiteco.jobportal.dto.CompanyDto;
import com.dreamsiteco.jobportal.company.service.ICompanyService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/companies")
@RequiredArgsConstructor //Mentioning this, Lombok is going to generate a contructor by taking all the final marked fields as an input like this " private final ICompanyService companyService;"
//@CrossOrigin(origins = {"http://localhost:5173/","*"}) //Idea to use for testing locally
public class CompanyController {

    private final ICompanyService companyService;

//    @Autowired//optional since we have just a single constructor
//    public CompanyController(ICompanyService companyService) {
//        this.companyService = companyService;
//    }

    @GetMapping(version = "1.0")
    public ResponseEntity<List> getAllCompanies(){
        List<CompanyDto> companyList = companyService.getAllCompanies();
        return  ResponseEntity.ok().body(companyList);

//        return ResponseEntity.ok().body("All Companies List");
    }







}
