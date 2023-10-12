package com.example.MOERADTEACHER.common.uneecops.master.utils;

import java.sql.Timestamp;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.Instant;
import java.time.LocalDate;
import java.time.ZoneId;
import java.util.Date;
import java.util.Objects;

import com.example.MOERADTEACHER.common.uneecops.master.dto.CheckDateBetweenDateRangeDTO;
import com.example.MOERADTEACHER.common.uneecops.master.dto.CheckTwoDateRangeOverlapsDTO;

public abstract class UneecopsDateUtils {

	public static Timestamp getCurrentTimeStamp() {
		Instant instance = Instant.now();
		Timestamp timestamp = Timestamp.from(instance);
		return timestamp;
	}

	public static boolean verifyDateBetweenDateRange(CheckDateBetweenDateRangeDTO objToValidate) {
		Objects.requireNonNull(objToValidate);
		if (objToValidate.getDateToValidate().isEqual(objToValidate.getRangeStartDate())
				| objToValidate.getDateToValidate().isEqual(objToValidate.getRangeEndDate())) {
			System.out.println("if The date " + objToValidate.getDateToValidate() + " equal the two dates");
			System.out.println(" if CheckDateBetweenDateRangeDTO object details are --> " + objToValidate.toString());
			return true;
		} else if (objToValidate.getDateToValidate().isAfter(objToValidate.getRangeStartDate())
				& objToValidate.getDateToValidate().isBefore(objToValidate.getRangeEndDate())) {
			System.out.println("The date " + objToValidate.getDateToValidate() + " lies between the two dates");
			System.out.println("CheckDateBetweenDateRangeDTO object details are --> " + objToValidate.toString());
			return true;
		} else {
			System.err.println(objToValidate.getDateToValidate() + " does not lie between the two dates");
			System.out.println("CheckDateBetweenDateRangeDTO object details are --> " + objToValidate.toString());
			return false;
		}
	}

	
	public static boolean validateTwoDateRangeOverlapping(CheckTwoDateRangeOverlapsDTO dto) {
		LocalDate s1 = dto.getRange_1_StartDate();
		LocalDate e1 = dto.getRange_1_EndDate();

		LocalDate s2 = dto.getRange_2_StartDate();
		LocalDate e2 = dto.getRange_2_EndDate();

		/*
		 * if (s1.isBefore(s2) && e1.isAfter(s2) || s1.isBefore(e2) && e1.isAfter(e2) ||
		 * s1.isBefore(s2) && e1.isAfter(e2) || s1.isAfter(s2) && e1.isBefore(e2) ||
		 * s1.equals(s2) && e1.equals(e2)) { System.out.print("They overlap"); return
		 * true; }
		 */
		if (s1.isBefore(e2) && e1.isAfter(s2) || s1.isBefore(e2) && e1.isAfter(s2) || s1.isBefore(s2) && e1.isAfter(e2)
				|| s1.isAfter(s2) && e1.isBefore(e2) || s1.equals(s2) && e1.equals(e2)) {
			System.out.print("They overlap ");
			return true;
		} else {
			System.out.print("They don't overlap");
			return false;
		}
	}

}
