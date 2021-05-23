package utils;

import com.opencsv.CSVWriter;
import io.qameta.allure.Step;

import java.io.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;

public class CsvWorker {

    @Step
    public static void writeToCSVFile(String firstName, String secondName, String email, String password, boolean append) throws IOException {
        String[] data = new String[]{firstName,secondName, email, password};
        String pathToCSV = "src/test/java/data/Users.csv";
        try (CSVWriter write = new CSVWriter(
                new FileWriter(pathToCSV, append),
                '‡',
                CSVWriter.NO_QUOTE_CHARACTER,
                CSVWriter.DEFAULT_ESCAPE_CHARACTER,
                CSVWriter.DEFAULT_LINE_END
        )) {
            write.writeNext(data);
        }
    }

    public static Iterator<Object[]> parseCsvData(String pathToCSV) throws IOException {
        File file = new File(pathToCSV);
        ArrayList<Object[]> data = new ArrayList<>();
        try (BufferedReader input = new BufferedReader(new FileReader(file))) {
            String line;
            while ((line = input.readLine()) != null) {
                String[] temp = line.split("‡");
                List<Object> array = new ArrayList<>(Arrays.asList(temp));
                data.add(array.toArray());
            }
        }
        return data.iterator();
    }
}
