package com.tw.apistackbase.repository;

import com.tw.apistackbase.entity.LawCase;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface LawCaseRepository extends JpaRepository<LawCase, Long> {

    LawCase findByName(String name);
    List<LawCase>  findLawCasesByName(String name);

}
