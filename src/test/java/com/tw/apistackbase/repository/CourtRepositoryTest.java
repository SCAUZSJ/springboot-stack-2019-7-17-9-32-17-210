package com.tw.apistackbase.repository;

import com.tw.apistackbase.entity.Court;
import com.tw.apistackbase.entity.Procurator;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@ExtendWith(SpringExtension.class)
@SpringBootTest
public class CourtRepositoryTest {

    @Autowired
    private CourtRepository courtRepository;

    @Test
    public void test_should_return_court_when_find_by_id() {
        //given
        Long id =courtRepository.saveAndFlush(new Court("第一法院")).getCourtId();
        //when
        Court court = courtRepository.findById(id).get();
        //then
        Assertions.assertEquals("第一法院", court.getName());
    }
    @Test
    public void test_should_return_exception_when_property_is_null() {
        //given
        Court court = new Court();
        //when
        //then
        Assertions.assertThrows(RuntimeException.class,()->{
            courtRepository.saveAndFlush(court);
        });
    }
    @Test
    public void test_should_return_court_when_save_() {
        //given
        Long id =courtRepository.saveAndFlush(new Court("第一法院")).getCourtId();
        Court court = new Court("检察院");

        List<Procurator> procurator = new ArrayList<>();
        procurator.add(new Procurator("检察官A"));
        procurator.add(new Procurator("检察官B"));
        court.setProcurators(procurator);
        //when
        Court court2 = courtRepository.save(court);
        //then
        Assertions.assertEquals("检察官A", court2.getProcurators().get(0).getName());
    }
}
