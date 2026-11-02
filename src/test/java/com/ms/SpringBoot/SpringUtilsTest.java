package com.ms.SpringBoot;

import com.ms.SpringBoot.utils.SpringUtils;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class SpringUtilsTest {
    @Test void handlesNullAndEmptyValues() {
        assertTrue(SpringUtils.isEmpty(null));
        assertTrue(SpringUtils.isEmpty(""));
        assertFalse(SpringUtils.isEmpty("abc"));
    }
}
