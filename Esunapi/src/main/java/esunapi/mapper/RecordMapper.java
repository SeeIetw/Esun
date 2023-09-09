package esunapi.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import esunapi.domain.Record;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import java.util.List;
import java.util.Map;

@Mapper
public interface RecordMapper extends BaseMapper<Record> {
    @Select("SELECT t.termId, t.termName, COUNT(r.termId) as sum " +
            "FROM terms t LEFT OUTER " +
            "JOIN records r ON t.termId = r.termId " +
            "GROUP BY t.termId, t.termName")
    List<Map<String, Object>> CountByTerms();
}
