package esunapi.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import esunapi.domain.Term;
import esunapi.mapper.TermMapper;
import esunapi.service.IRecordService;
import esunapi.service.ITermService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.RequestBody;

@Transactional
@Service
public class TermServiceImpl extends ServiceImpl<TermMapper, Term> implements ITermService {
    @Autowired
    IRecordService recordService;
    @Autowired
    TermMapper termMapper;
    public boolean deletedbyId(Integer termId){
        return recordService.deletedByTermId(termId)&&termMapper.deleteById(termId)>0;
    }
}
