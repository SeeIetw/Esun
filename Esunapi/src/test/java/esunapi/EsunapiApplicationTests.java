package esunapi;

import esunapi.domain.Term;
import esunapi.mapper.RecordMapper;
import esunapi.mapper.TermMapper;
import esunapi.service.ITermService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;
import java.util.Map;

@SpringBootTest
class EsunapiApplicationTests {
    @Autowired
    private TermMapper termMapper;
    @Autowired
    private ITermService termService;
    @Autowired
    private RecordMapper recordMapper;


    @Test
    void contextLoads() {
        Term newTerm = new Term();
        newTerm.setTermName("螢幕");
        termService.save(newTerm);
    }

    @Test
    void contextLoads2() {
        System.out.println(recordMapper.CountByTerms());
    }

}
