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
}
