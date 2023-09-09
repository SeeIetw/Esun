package esunapi.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import esunapi.domain.Term;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface TermMapper extends BaseMapper<Term> {
}
