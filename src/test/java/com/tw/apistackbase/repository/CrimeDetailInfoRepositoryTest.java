package com.tw.apistackbase.repository;

import com.tw.apistackbase.entity.CrimeDetailInfo;
import com.tw.apistackbase.entity.LawCase;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit.jupiter.SpringExtension;

@ExtendWith(SpringExtension.class)
@SpringBootTest
public class CrimeDetailInfoRepositoryTest {

    @Autowired
    private CrimeDetailInfoRepository crimeDetailInfoRepository;

    @Test
    public void test_should_return_crimeDetailInfo_when_find_by_id() {
        //given
        Long id =crimeDetailInfoRepository.saveAndFlush(new CrimeDetailInfo("主观bbb","客观")).getCrimeDetailId();
        //when
        CrimeDetailInfo crimeDetailInfo = crimeDetailInfoRepository.findById(id).get();
        //then
        Assertions.assertEquals("主观bbb", crimeDetailInfo.getSubInfoDes());
    }
    @Test
    public void test_should_return_exception_when_property_is_null() {
        //given
        CrimeDetailInfo crimeDetailInfo = new CrimeDetailInfo();
        //when
        //then
        Assertions.assertThrows(RuntimeException.class,()->{
            crimeDetailInfoRepository.saveAndFlush(crimeDetailInfo);
        });
    }


}
