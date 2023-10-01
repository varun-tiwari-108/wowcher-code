/**
 * 
 */
package com.wowcher.code.speakingclock.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.wowcher.code.speakingclock.Exception.TimeConversionException;
import com.wowcher.code.speakingclock.Model.SpeakingClock;
import com.wowcher.code.speakingclock.Service.SpeakingClockServiceMidDayOrNightService;

/**
 * @author Varun Tiwari
 *
 */

/*
 * This is the controller with the end-point to tell if the provided time is
 * Mid-night, Mid-day or None of the two.
 */

@RestController
@RequestMapping("/speaking-clock/mid")
public class SpeakingClockMidDayOrNightController {

	@Autowired
	private SpeakingClockServiceMidDayOrNightService speakingClockServiceMidDayOrNightService;

	@GetMapping("/{time}")
	public ResponseEntity<?> convertTimeToWords(@PathVariable String time) {
		try {
			SpeakingClock speakingClock = speakingClockServiceMidDayOrNightService.convertTimeToWords(time);
			return ResponseEntity.ok(speakingClock);
		} catch (TimeConversionException tce) {
			return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(tce.getMessage());
		} catch (Exception ex) {
			return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("An exception has occured");
		}
	}
}
