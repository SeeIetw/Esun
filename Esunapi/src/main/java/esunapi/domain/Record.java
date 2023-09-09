package esunapi.domain;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

@Data //for getter setter
@TableName("records")
public class Record {
    @TableId(type = IdType.AUTO)
    private Integer recordId ;
    private String userName;
    private Integer termId;
}
