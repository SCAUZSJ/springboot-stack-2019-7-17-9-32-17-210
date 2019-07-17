package com.tw.apistackbase.repository;

import com.tw.apistackbase.entity.LawCase;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit.jupiter.SpringExtension;


import java.sql.Timestamp;
import java.util.List;

@ExtendWith(SpringExtension.class)
@SpringBootTest
public class LawCaseRepositoryTest {

    @Autowired
    private LawCaseRepository lawCaseRepository;

    @Test
    public void test_should_return_lawCase_when_find_by_id() {
        //given
         Long id =lawCaseRepository.saveAndFlush(new LawCase("行窃",new Timestamp(System.currentTimeMillis()))).getCaseId();
        //when
        LawCase lawCase = lawCaseRepository.findById(id).get();
        //then
        Assertions.assertEquals("行窃", lawCase.getName());

    }
    @Test
    public void test_should_return_lawCase_when_find_by_name() {
        //given
        lawCaseRepository.saveAndFlush(new LawCase("行窃",new Timestamp(System.currentTimeMillis())));
        //when
        LawCase lawCase = lawCaseRepository.findByName("行窃");
        //then
        Assertions.assertEquals("行窃", lawCase.getName());

    }

    @Test
    public void test_should_return_lawCases_when_find_all() {
        //given
        lawCaseRepository.saveAndFlush(new LawCase("行窃",new Timestamp(System.currentTimeMillis())));
        lawCaseRepository.saveAndFlush(new LawCase("赌博",new Timestamp(System.currentTimeMillis())));
        //when
        List<LawCase> lawCases = lawCaseRepository.findAll();
        //then
        Assertions.assertEquals(2, lawCases.size());

    }
    @Test
    public void test_should_return__when_delete_by_id() {
        //given
        Long id = lawCaseRepository.saveAndFlush(new LawCase("行窃",new Timestamp(System.currentTimeMillis()))).getCaseId();
        lawCaseRepository.saveAndFlush(new LawCase("赌博",new Timestamp(System.currentTimeMillis())));
        //when
        lawCaseRepository.deleteById(id);
        List<LawCase> lawCases = lawCaseRepository.findAll();
        //then
        Assertions.assertEquals(1, lawCases.size());

    }
}
