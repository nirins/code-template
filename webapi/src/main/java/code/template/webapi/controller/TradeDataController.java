package code.template.webapi.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import code.template.webapi.entity.InputFile;
import code.template.webapi.entity.ServiceResult;
import code.template.webapi.entity.TradeData;
import code.template.webapi.repository.TradeDataRepository;
import code.template.webapi.service.TradeDataService;

@RestController
public class TradeDataController {

    @Autowired
    private Environment env;

    @Autowired
    private TradeDataService tradeDataService;

    @Autowired
    private TradeDataRepository tradeDataRepository;

    @GetMapping("/list-input-files")
    public List<InputFile> listInputFiles() {
        return tradeDataService.listInputFiles(env);
    }

    @PostMapping("/load-input-files")
    public ServiceResult loadInputFiles() {
        return tradeDataService.loadInputFiles(env, tradeDataRepository);
    }

    @GetMapping("/get-tradedata")
    public List<TradeData> getTradeDatas() {
        List<TradeData> trades = tradeDataRepository.findAll();
        return trades;
    }
}
