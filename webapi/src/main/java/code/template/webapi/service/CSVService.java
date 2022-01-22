package code.template.webapi.service;

import java.io.FileReader;
import java.util.ArrayList;
import java.util.List;
import com.opencsv.CSVReader;
import com.opencsv.CSVReaderBuilder;
import org.springframework.stereotype.Service;
import code.template.webapi.entity.TradeData;

@Service
public class CSVService {

    public List<TradeData> readTradeData(String inputFilePath) {
        List<TradeData> records = new ArrayList<TradeData>();

        try (CSVReader csvReader = new CSVReaderBuilder(new FileReader(inputFilePath)).withSkipLines(1).build()) {
            String[] values = null;
            while ((values = csvReader.readNext()) != null) {

                TradeData record = new TradeData(
                        values[0],
                        values[1],
                        values[2],
                        Integer.parseInt(values[3]));

                records.add(record);
            }
        } catch (Exception ex) {
            System.out.println(ex.toString());
        }

        return records;
    }
}
