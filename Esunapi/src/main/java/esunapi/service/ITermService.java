package esunapi.service;

import com.baomidou.mybatisplus.extension.service.IService;
import esunapi.domain.Term;

public interface ITermService extends IService<Term> {
    boolean deletedbyId(Integer termId);
}
