package util;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import java.io.IOException;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.Mockito.*;
import static util.Constants.SUCCESS_CSV;
import static util.StringManipulation.*;

public class StringManipulationTest {

    static String input;

    @BeforeAll
    public static void init() throws IOException {
        input = "test string";
    }

    @Test
    public static void test_alternate_case() {
        String expected = "TeSt StRiNg";
        String output = alternateCase(input);
        assertEquals(expected, output);
    }

    @Test
    public static void test_convert_to_csv_file() {
        String[] inputArr = input.split("");
        String expectedOutput = "h,e,l,l,o, ,w,o,r,l,d";
        assertEquals(expectedOutput, convertToCSV(inputArr));
    }

    @Test
    public static void test_invalid_numeric_input() {
        String num = "223";
        assertTrue(checkIsNumeric(input));
    }

    @Test
    public void test_csv_file_creation() {
        String expectedOutput = SUCCESS_CSV;
        assertEquals(expectedOutput, createCSVFile(input));
    }

    @Test
    public void test_void_method_call_to_manipulate_string() {
        StringManipulation mockManipulation = mock(StringManipulation.class);
        manipulateString(input);
        verify(mockManipulation, times(1)).manipulateString(anyString());
    }
}
