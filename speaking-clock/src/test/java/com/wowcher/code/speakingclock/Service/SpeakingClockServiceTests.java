package com.wowcher.code.speakingclock.Service;

import com.wowcher.code.speakingclock.Exception.TimeConversionException;
import com.wowcher.code.speakingclock.Model.SpeakingClock;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class SpeakingClockServiceTests {

    private SpeakingClockService speakingClockService;

    @BeforeEach
    public void setUp() {
        speakingClockService = new SpeakingClockService();
    }

    @Test
    public void testValidTimeConversion() {
        SpeakingClock result = speakingClockService.convertTimeToWords("11:25");
        assertEquals("It's eleven twenty five", result.getTimeInWords());
    }

    @Test
    public void testInvalidTimeFormat() {
        TimeConversionException exception = assertThrows(TimeConversionException.class, () -> {
            speakingClockService.convertTimeToWords("12;45");
        });
        assertEquals("Invalid time format: 12;45", exception.getMessage());
    }

    @Test
    public void testNegativeHours() {
        TimeConversionException exception = assertThrows(TimeConversionException.class, () -> {
            speakingClockService.convertTimeToWords("-1:30");
        });
        assertEquals("Hour in time is invalid. Cannot exceed 24 or cannot be negative", exception.getMessage());
    }

    @Test
    public void testInvalidMinutes() {
        TimeConversionException exception = assertThrows(TimeConversionException.class, () -> {
            speakingClockService.convertTimeToWords("10:-30");
        });
        assertEquals("Minutes in time is invalid. Cannot exceed 60 or cannot be negative", exception.getMessage());
    }

    @Test
    public void testValidMinimumTime() {
        SpeakingClock result = speakingClockService.convertTimeToWords("00:00");
        assertEquals("It's zero", result.getTimeInWords());
    }

    @Test
    public void testValidMaximumTime() {
        SpeakingClock result = speakingClockService.convertTimeToWords("23:59");
        assertEquals("It's twenty three fifty nine", result.getTimeInWords());
    }

    @Test
    public void testInvalidHourAbove24() {
        TimeConversionException exception = assertThrows(TimeConversionException.class, () -> {
            speakingClockService.convertTimeToWords("25:30");
        });
        assertEquals("Hour in time is invalid. Cannot exceed 24 or cannot be negative", exception.getMessage());
    }

    @Test
    public void testInvalidMinutesAbove60() {
        TimeConversionException exception = assertThrows(TimeConversionException.class, () -> {
            speakingClockService.convertTimeToWords("12:61");
        });
        assertEquals("Minutes in time is invalid. Cannot exceed 60 or cannot be negative", exception.getMessage());
    }
}
