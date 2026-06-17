package com.hemebiotech.analytics;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class AnalyticsCounterTest {

    @Test
    void main_shouldRunWithoutExceptions() {
        assertDoesNotThrow(() -> AnalyticsCounter.main(new String[]{}));
    }
}
