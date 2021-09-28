package datafiles;

import com.fasterxml.jackson.dataformat.csv.CsvMapper;
import com.fasterxml.jackson.dataformat.csv.CsvSchema;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import java.io.FileInputStream;
import java.io.FileReader;
import java.io.IOException;
import java.io.Reader;
import java.util.Iterator;
import java.util.Map;
import java.util.TreeMap;

public class TestDataReader {

    public FileInputStream fis = null;
    public XSSFWorkbook workbook = null;
    private static String ctKey;

    public TestDataReader() {
    }


    public String getCtKey() {
        return ctKey;
    }

    public void setCtKey(String ctKey) {
        TestDataReader.ctKey = ctKey;
    }


    public static Map<String, Map<String, String>> getCSVData(char seperator, String FileName, int primaryKeyIndex)
            throws IOException {

        //Create one object of Map type which hold another String (Key-Column as Key) and Map as as value.( for each row corresponding key and values).
        Map<String, Map<String, String>> CSVData = new TreeMap<String, Map<String, String>>();
        Map<String, String> keyVals = null;

        //Load CSV file in Reader class to parse CSV Data // arquivo CSV
        Reader reader = new FileReader("src/test/resources/DataFiles/Massa.csv");

        //Identify CSV separator (comma delimitor, pipe separated etc.) Create Iterator to iterate each CSV row over column and row.
        Iterator<Map<String, String>> iterator = new CsvMapper().readerFor(Map.class)
                .with(CsvSchema.emptySchema().withHeader().withColumnSeparator(seperator).withoutQuoteChar())
                .readValues(reader);

        //Iterate iterator up to each row and put values in step 4 Map i.e CSVData.
        while (iterator.hasNext()) {
            keyVals = iterator.next();
            Object[] keys = keyVals.keySet().toArray();
            CSVData.put(keyVals.get(keys[primaryKeyIndex]), keyVals);
        }
        //Return the CSVData Map as parse Data.
        return CSVData;
    }


    public String getDt(String ct, String colName) {

        //map which holds data in Key (String) and values(Map- Column Name as Key and Value).
        Map<String, Map<String, String>> CSV;

        try {

            //calling the getCSVData method passing the parse CSV Data
            CSV = getCSVData(';', "ParseCsv", 0);

            //Iterate above collections over each Key
            Iterator<String> keys = CSV.keySet().iterator();

            while (keys.hasNext()) {
                String primaryKey = keys.next();

                //Get value using CT name and column Name
                if (primaryKey.equals(ct)) {

                    //if value were found, then return column value
                    return CSV.get(primaryKey).get(colName).toString();
                }
            }

        } catch (IOException e) {

        }
        return "NOT FOUND";
    }

    public String getDt(String colName) {

        //map which holds data in Key (String) and values(Map- Column Name as Key and Value).
        Map<String, Map<String, String>> CSV;

        try {

            //calling the getCSVData method passing the parse CSV Data
            CSV = getCSVData(';', "ParseCsv", 0);

            //Iterate above collections over each Key
            Iterator<String> keys = CSV.keySet().iterator();

            while (keys.hasNext()) {
                String primaryKey = keys.next();


                //Get value using CT name and column Name
                if (primaryKey.equals(getCtKey())) {

                    //if value were found, then return column value
                    return CSV.get(primaryKey).get(colName).toString();
                }
            }

        } catch (IOException e) {

        }
        return "NOT FOUND";
    }

}
