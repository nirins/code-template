package code.template.webapi.service;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

import org.springframework.core.env.Environment;
import org.springframework.stereotype.Service;

import code.template.webapi.entity.InputFile;
import code.template.webapi.entity.ServiceResult;
import code.template.webapi.entity.TradeData;
import code.template.webapi.repository.TradeDataRepository;

@Service
public class TradeDataService {

    public List<InputFile> listInputFiles(Environment env) {
        List<InputFile> inputFiles = new ArrayList<InputFile>();
        String path_income = env.getProperty("path_income");
        String path_bond = env.getProperty("path_bond");
        List<String> inputPaths = new ArrayList<String>(List.of(
                path_income,
                path_bond));

        for (String path : inputPaths) {
            File[] files = new File(path).listFiles();
            for (File file : files) {
                if (file.isFile()) {
                    inputFiles.add(new InputFile(path, file.getName()));
                }
            }
        }

        return inputFiles;
    }

    public ServiceResult loadInputFiles(Environment env, TradeDataRepository tradeDataRepository) {
        tradeDataRepository.deleteAll();
        int count = 0;
        List<InputFile> inputFiles = listInputFiles(env);
        for (InputFile file : inputFiles) {
            List<TradeData> trades = new CSVService().readTradeData(file.getFullPath());
            tradeDataRepository.saveAll(trades);
            count += trades.size();
        }
        return new ServiceResult("OK", String.format("Success: %d records loaded", count));
    }
}
