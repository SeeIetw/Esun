package esunapi.controller;

import esunapi.controller.util.Result;
import esunapi.domain.Record;
import esunapi.domain.Term;
import esunapi.service.IRecordService;
import esunapi.service.ITermService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/terms")
public class TermController {
    @Autowired
    private ITermService termService;

    @GetMapping
    public Result selectAll(){
        List<Term> terms = termService.list();
        Integer code = terms != null ? 200 : 500;
        String msg = terms != null ? "資料查詢成功" : "查無資料";
        return new Result(code, terms, msg);
    }

    @PostMapping
    public Result save(@RequestBody Term term){
        boolean flag = termService.save(term);
        return new Result(flag ? 200 : 500, flag, flag ? "項目新增成功" : "項目新增失敗");
    }

    @DeleteMapping
    public Result deletedById(@RequestBody Term term){
        boolean flag = termService.deletedbyId(term.getTermId());
        return new Result(flag ? 200 : 500, flag, flag ? "項目刪除成功" : "項目刪除失敗");
    }
}
