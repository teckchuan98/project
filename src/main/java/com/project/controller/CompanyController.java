package com.project.controller;

import com.project.entity.Company;
import com.project.service.CompanyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@ResponseBody
public class CompanyController {
    @Autowired
    private CompanyService companyService;

    @PostMapping("/addCompany")
    public ResponseEntity<String> addCompany(@RequestParam String companyName){
        companyService.addCompany(companyName);
        return ResponseEntity.ok().body("Company Added Successfully");
    }

    @CrossOrigin(origins = "http://localhost:3000")
    @GetMapping("/getAllCompanies")
    public List<Company> getAllCompanies(){
        return companyService.getAllCompany();
    }

    @DeleteMapping("/deleteCompany")
    public String deleteCompany(@RequestParam String companyName){
        companyService.deleteCompany(companyName);
        return "Company Deleted";
    }
}
