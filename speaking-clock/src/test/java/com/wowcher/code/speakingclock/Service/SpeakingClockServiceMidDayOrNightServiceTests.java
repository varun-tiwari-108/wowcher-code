/**
 * 
 */
package com.wowcher.code.speakingclock.Service;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import com.wowcher.code.speakingclock.Model.SpeakingClock;

/**
 * @author Varun Tiwari
 *
 */
public class SpeakingClockServiceMidDayOrNightServiceTests {
	
	private SpeakingClockServiceMidDayOrNightService speakingClockServiceMidDayOrNightService;
	
	@BeforeEach
	public void setUp() {
		speakingClockServiceMidDayOrNightService = new SpeakingClockServiceMidDayOrNightService();
	}
	
	@Test
	public void testMidnightConversion() {
		SpeakingClock result = speakingClockServiceMidDayOrNightService.convertTimeToWords("00:00");
		assertEquals("It's Midnight", result.getTimeInWords());
	}
	
	@Test
	public void testMiddayConversion() {
		SpeakingClock result = speakingClockServiceMidDayOrNightService.convertTimeToWords("12:00");
		assertEquals("It's Midday", result.getTimeInWords());
	}
	
}
