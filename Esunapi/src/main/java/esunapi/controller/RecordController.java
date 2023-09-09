package esunapi.controller;

import esunapi.controller.util.Result;
import esunapi.domain.Record;
import esunapi.service.IRecordService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;


@RestController
@RequestMapping("/records")
public class RecordController {
    @Autowired
    private IRecordService recordService;

    @GetMapping
    public Result selectAll(){
        List<Record> records = recordService.list();
        Integer code = records != null ? 200 : 500;
        String msg = records != null ? "資料查詢成功" : "查無資料";
        return new Result(code, records, msg);
    }

    @GetMapping("/sum")
    public Result selectAllAndSum(){
        List<Map<String, Object>> data = recordService.CountByTerms();
        Integer code = data != null ? 200 : 500;
        String msg = data != null ? "資料查詢成功" : "查無資料";
        return new Result(code, data, msg);
    }

    @PostMapping
    public Result saveRecords(@RequestBody List<Record> records){
        boolean flag = recordService.save(records);
        return new Result(flag ? 200 : 500, flag, flag ? "投票成功" : "投票失敗");
    }

}
