package esunapi.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import esunapi.domain.Record;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import java.util.List;
import java.util.Map;

@Mapper
public interface RecordMapper extends BaseMapper<Record> {
    @Select("CALL GetTermSum()")
    List<Map<String, Object>> CountByTerms();
}
