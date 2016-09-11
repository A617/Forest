package edu.nju.service.test;

import edu.nju.service.RecordService;
import edu.nju.service.vo.RecordVO;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import javax.annotation.Resource;
import java.util.List;

/**
 * Created by tjDu on 2016/9/11.
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {"classpath:spring-mybatis.xml"})
public class RecordServiceTest {
    @Resource
    private RecordService service;

    @Test
    public void testGetUserRecords() {
        List<RecordVO> vos = service.getUserRecords("oraisdy");
        for (RecordVO vo : vos) {
            System.out.println(vo.getTime());
        }
    }
}
