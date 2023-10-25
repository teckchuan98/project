package com.project.service;

import com.project.entity.Company;
import com.project.repository.CompanyRepository;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class CompanyService {
    private final CompanyRepository companyRepository;

    public void addCompany(String companyName){
        Company company = new Company();
        company.setName(companyName);
        companyRepository.save(company);
    }

    public List<Company> getAllCompany(){
        return companyRepository.findAll();
    }

    public Company getCompanyByName(String companyName){
        return companyRepository.findByName(companyName);
    }

    @Transactional
    public void deleteCompany(String companyName){
        companyRepository.deleteByName(companyName);
    }
}
