package util;

import picocli.CommandLine;
import picocli.CommandLine.Parameters;

import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import static util.Constants.*;

public class StringManipulation implements Runnable {

    @Parameters(paramLabel = "input_string",description = "provide input string")
    String input;

    public static void main(String[] args) {
        CommandLine.run(new StringManipulation(), args);
    }

    @Override
    public void run() {
        checkForValidString(input);
    }
    public static void checkForValidString(String input) {
        if (input != null && !input.isEmpty() && !checkIsNumeric(input)) {
            manipulateString(input);
        } else {
            System.out.println(INVALID_STR);
        }
    }
    public static boolean checkIsNumeric(String input) {
        return input.matches("-?\\d+(\\.\\d+)?");
    }
    public static void manipulateString(String input) {
        System.out.println(input.toUpperCase());
        System.out.println(alternateCase(input));
        System.out.println(createCSVFile(input));
    }

    public static String alternateCase(String input) {
        String[] strArr = input.toLowerCase().split("");
        StringBuilder sb = new StringBuilder();
        for(int i = 0 ; i < strArr.length ; i++) {
            if(i%2==0) strArr[i] = strArr[i].toUpperCase();
            sb.append(strArr[i]);
        }
        return sb.toString();
    }

    public static String createCSVFile(String input) {
        File csvFile = new File(CSV_FILE_NAME);
        try(PrintWriter pw = new PrintWriter(csvFile)){
            pw.println(convertToCSV(input.split("")));
        } catch (IOException e) {
            e.printStackTrace();
        }
        return SUCCESS_CSV;
    }
    public static String convertToCSV(String[] strArr) {
        return Stream.of(strArr).collect(Collectors.joining(","));
    }
}
