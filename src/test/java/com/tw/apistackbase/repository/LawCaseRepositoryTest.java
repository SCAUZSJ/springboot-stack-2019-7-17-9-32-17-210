package com.tw.apistackbase.repository;

import com.tw.apistackbase.entity.Court;
import com.tw.apistackbase.entity.CrimeDetailInfo;
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
import java.util.ArrayList;
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
    @Test
    public void test_should_return_lawCases_when_find_all_by_name() {
        //given
        lawCaseRepository.saveAndFlush(new LawCase("行窃",new Timestamp(System.currentTimeMillis())));
        lawCaseRepository.saveAndFlush(new LawCase("赌博",new Timestamp(System.currentTimeMillis())));
        lawCaseRepository.saveAndFlush(new LawCase("赌博",new Timestamp(System.currentTimeMillis())));
        //when
        List<LawCase> lawCases = lawCaseRepository.findLawCasesByName("赌博");
        //then
        Assertions.assertEquals(2, lawCases.size());

    }
    @Test
    public void test_should_return_lawCases_when_find_all_order_by_desc() {
        //given
        lawCaseRepository.saveAndFlush(new LawCase("行窃",new Timestamp(System.currentTimeMillis()-10000)));
        lawCaseRepository.saveAndFlush(new LawCase("赌博",new Timestamp(System.currentTimeMillis()-200000)));
        lawCaseRepository.saveAndFlush(new LawCase("飙车",new Timestamp(System.currentTimeMillis())));
        //when
        List<LawCase> lawCases = lawCaseRepository.findByOrderByHappenTimeDesc();
        //then
        Assertions.assertEquals("飙车", lawCases.get(0).getName());
    }

    @Test
    public void test_should_return_lawCase_with_detailInfo_when_find_by_id() {
        //given
        LawCase lawCase = new LawCase("行窃",new Timestamp(System.currentTimeMillis()));
        lawCase.setCrimeDetailInfo(new CrimeDetailInfo("主观","客观"));
        Long id =lawCaseRepository.saveAndFlush(lawCase).getCaseId();
        //when
        LawCase lawCase2 = lawCaseRepository.findById(id).get();
        //then
        Assertions.assertEquals("客观", lawCase2.getCrimeDetailInfo().getObjInfoDes());

    }
    @Test
    public void test_should_return_lawCase_with_detailInfo_when_update() {
        //given
        LawCase lawCase = new LawCase("刑事",new Timestamp(System.currentTimeMillis()));
        lawCase = lawCaseRepository.saveAndFlush(lawCase);
        //when
        lawCase.setCrimeDetailInfo(new CrimeDetailInfo("主观_刑事","客观_刑事"));
        LawCase lawCase1 = lawCaseRepository.saveAndFlush(lawCase);
        //then
        Assertions.assertEquals("客观_刑事", lawCase1.getCrimeDetailInfo().getObjInfoDes());

    }


    @Test
    public void test_should_return_lawCase_with_court_when_find_by_id() {
        //given
        LawCase lawCase = new LawCase("行窃",new Timestamp(System.currentTimeMillis()));
        lawCase.setCourt(new Court("法院A"));
        Long id =lawCaseRepository.saveAndFlush(lawCase).getCaseId();
        //when
        LawCase lawCase2 = lawCaseRepository.findById(id).get();
        //then
        Assertions.assertEquals("法院A", lawCase2.getCourt().getName());

    }
}
