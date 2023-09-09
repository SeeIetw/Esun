package esunapi.service;

import com.baomidou.mybatisplus.extension.service.IService;
import esunapi.domain.Record;

import java.util.List;
import java.util.Map;

public interface IRecordService extends IService<Record> {
    List<Map<String, Object>> CountByTerms();
    Boolean deletedByTermId(Integer termId);
    boolean save(List<Record> records);
}
