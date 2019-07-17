package com.tw.apistackbase.repository;

import com.tw.apistackbase.entity.Procurator;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit.jupiter.SpringExtension;

@ExtendWith(SpringExtension.class)
@SpringBootTest
public class ProcuratorRepositoryTest {

    @Autowired
    private ProcuratorRepository procuratorRepository;

    @Test
    public void test_should_return_procurator_when_find_by_id() {
        //given
        Long id =procuratorRepository.saveAndFlush(new Procurator("检察官")).getProcuratorId();
        //when
        Procurator procurator = procuratorRepository.findById(id).get();
        //then
        Assertions.assertEquals("检察官", procurator.getName());
    }

}
