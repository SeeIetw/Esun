package esunapi.domain;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

@Data //for getter setter
@TableName("terms")
public class Term {
    @TableId(type = IdType.AUTO)
    private Integer termId;
    private String termName;
}
