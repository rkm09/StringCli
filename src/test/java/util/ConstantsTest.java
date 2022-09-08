package util;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertNotNull;
import static util.Constants.*;

public class ConstantsTest {
    @Test
    public void test_constants() {
        assertNotNull(INVALID_STR);
        assertNotNull(SUCCESS_CSV);
        assertNotNull(CSV_FILE_NAME);
    }
}
