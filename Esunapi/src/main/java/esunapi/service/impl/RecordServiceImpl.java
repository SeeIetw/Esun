package esunapi.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import esunapi.domain.Record;
import esunapi.exception.FormNotMatchException;
import esunapi.exception.NoInputException;
import esunapi.exception.NoSelectionException;
import esunapi.mapper.RecordMapper;
import esunapi.service.IRecordService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Map;
import java.util.regex.Pattern;


@Transactional
@Service
public class RecordServiceImpl extends ServiceImpl<RecordMapper, Record> implements IRecordService {
    @Autowired
    private RecordMapper recordMapper;

    public List<Map<String, Object>> CountByTerms() {
        return recordMapper.CountByTerms();
    }
    public Boolean deletedByTermId(Integer termId){
        LambdaQueryWrapper<Record> wrapper = new LambdaQueryWrapper<>();
        wrapper.eq(Record::getTermId, termId);
        if(recordMapper.selectList(wrapper).size()==0){
            return true;
        }else {
            return recordMapper.delete(wrapper)>0;
        }
    }


    public boolean save(List<Record> records) {
        boolean flag = true;
        Pattern pattern = Pattern.compile("^[a-zA-Z]+$");
        if(records.size()==0){
            throw new NoSelectionException();
        }

        String userName = records.get(0).getUserName();

        if(userName.isEmpty()){
            throw new NoInputException();
        }
        if(userName.length()>=20 || !pattern.matcher(userName).matches()){
            throw new FormNotMatchException();
        }

        for (Record record:records) {
            if(!super.save(record)){
                flag = false;
            }
        }
        return flag;
    }
}
