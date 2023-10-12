/**
 * 
 */
package com.example.MOERADTEACHER.common.uneecops.master.utils;

import java.text.ParseException;
import java.time.LocalDate;

import com.example.MOERADTEACHER.common.uneecops.master.dto.CheckTwoDateRangeOverlapsDTO;

/**
 * @author UTL0874 May 9, 2023 | 12:36:15 PM
 */
public class DateRangeOverlappingTest {

	/**
	 * @param args
	 * @throws ParseException
	 */
	public static void main(String[] args) throws ParseException {
		
		
		// case 1 
		LocalDate c1rs1 = LocalDate.of(2020, 1, 31);
		LocalDate c1re1 = LocalDate.of(2020, 12, 31);
		LocalDate c1rs2 = LocalDate.of(2020, 6, 30);
		LocalDate c1re2 = LocalDate.of(2021, 5, 30);
		CheckTwoDateRangeOverlapsDTO c1object = new CheckTwoDateRangeOverlapsDTO(c1rs1, c1re1, c1rs2, c1re2);
		boolean case1Reslut = UneecopsDateUtils.validateTwoDateRangeOverlapping(c1object);
		System.out.println(" case 1 result " + case1Reslut);
		
		
		// case 2
		LocalDate c2rs1 = LocalDate.of(2020, 1, 31);
		LocalDate c2re1 = LocalDate.of(2020, 12, 31);
		LocalDate c2rs2 = LocalDate.of(2019, 6, 30);
		LocalDate c2re2 = LocalDate.of(2020, 5, 30);
		CheckTwoDateRangeOverlapsDTO c2object = new CheckTwoDateRangeOverlapsDTO(c2rs1, c2re1, c2rs2, c2re2);
		boolean case2Reslut = UneecopsDateUtils.validateTwoDateRangeOverlapping(c2object);
		System.out.println(" case 2 result " + case2Reslut);
		
		// case 3
		LocalDate c3rs1 = LocalDate.of(2018, 1, 31);
		LocalDate c3re1 = LocalDate.of(2020, 12, 31);
		LocalDate c3rs2 = LocalDate.of(2019, 6, 30);
		LocalDate c3re2 = LocalDate.of(2019, 9, 30);
		CheckTwoDateRangeOverlapsDTO c3object = new CheckTwoDateRangeOverlapsDTO(c3rs1, c3re1, c3rs2, c3re2);
		boolean case3Reslut = UneecopsDateUtils.validateTwoDateRangeOverlapping(c3object);
		System.out.println(" case 3 result " + case3Reslut);
		
		// case 4
		LocalDate c4rs1 = LocalDate.of(2020, 1, 31);
		LocalDate c4re1 = LocalDate.of(2020, 12, 31);
		LocalDate c4rs2 = LocalDate.of(2019, 6, 30);
		LocalDate c4re2 = LocalDate.of(2021, 5, 30);
		CheckTwoDateRangeOverlapsDTO c4object = new CheckTwoDateRangeOverlapsDTO(c4rs1, c4re1, c4rs2, c4re2);
		boolean case4Reslut = UneecopsDateUtils.validateTwoDateRangeOverlapping(c4object);
		System.out.println(" case 4 result " + case4Reslut);

		// case 5 when both date range are same
		LocalDate rs1 = LocalDate.of(2020, 1, 8);
		LocalDate re1 = LocalDate.of(2020, 1, 8);
		LocalDate rs2 = LocalDate.of(2020, 1, 8);
		LocalDate re2 = LocalDate.of(2020, 1, 8);
		CheckTwoDateRangeOverlapsDTO checkTwoDateRangeOverlapsDTO = new CheckTwoDateRangeOverlapsDTO(rs1, re1, rs2, re2);
		boolean case5Reslut = UneecopsDateUtils.validateTwoDateRangeOverlapping(checkTwoDateRangeOverlapsDTO);
		System.out.println(" case 5 result " + case5Reslut);
	}

}
