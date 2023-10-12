/**
 * 
 */
package com.example.MOERADTEACHER.common.uneecops.master.dto;

import java.time.LocalDate;
import java.util.Objects;

/**
 * @author UTL0874
 * May 5, 2023  |  2:05:20 PM
 */
public class CheckTwoDateRangeOverlapsDTO {
	private LocalDate range_1_StartDate;
	private LocalDate range_1_EndDate;
	
	private LocalDate range_2_StartDate;
	private LocalDate range_2_EndDate;

	/**
	 * @param dateToValidate
	 * @param rangeStartDate
	 * @param rangeEndDate
	 */
	public CheckTwoDateRangeOverlapsDTO(LocalDate range_1_StartDate,LocalDate range_1_EndDate, LocalDate range_2_StartDate, LocalDate range_2_EndDate) {
		super();
		Objects.requireNonNull(range_1_StartDate, " range_1_StartDate  can not be null ");
		Objects.requireNonNull(range_1_EndDate, " range_1_EndDate can not be null ");
		Objects.requireNonNull(range_2_StartDate, " range_2_StartDate can not be null ");
		Objects.requireNonNull(range_2_EndDate, " range_2_EndDate can not be null ");
		this.range_1_StartDate = range_1_StartDate;
		this.range_1_EndDate = range_1_EndDate;
		this.range_2_StartDate = range_2_StartDate;
		this.range_2_EndDate = range_2_EndDate;
	}

	/**
	 * @return the range_1_StartDate
	 */
	public LocalDate getRange_1_StartDate() {
		return range_1_StartDate;
	}

	/**
	 * @param range_1_StartDate the range_1_StartDate to set
	 */
	public void setRange_1_StartDate(LocalDate range_1_StartDate) {
		this.range_1_StartDate = range_1_StartDate;
	}

	/**
	 * @return the range_1_EndDate
	 */
	public LocalDate getRange_1_EndDate() {
		return range_1_EndDate;
	}

	/**
	 * @param range_1_EndDate the range_1_EndDate to set
	 */
	public void setRange_1_EndDate(LocalDate range_1_EndDate) {
		this.range_1_EndDate = range_1_EndDate;
	}

	/**
	 * @return the range_2_StartDate
	 */
	public LocalDate getRange_2_StartDate() {
		return range_2_StartDate;
	}

	/**
	 * @param range_2_StartDate the range_2_StartDate to set
	 */
	public void setRange_2_StartDate(LocalDate range_2_StartDate) {
		this.range_2_StartDate = range_2_StartDate;
	}

	/**
	 * @return the range_2_EndDate
	 */
	public LocalDate getRange_2_EndDate() {
		return range_2_EndDate;
	}

	/**
	 * @param range_2_EndDate the range_2_EndDate to set
	 */
	public void setRange_2_EndDate(LocalDate range_2_EndDate) {
		this.range_2_EndDate = range_2_EndDate;
	}

	@Override
	public String toString() {
		return "CheckTwoDateRangeOverlapsDTO [range_1_StartDate=" + range_1_StartDate + ", range_1_EndDate=" + range_1_EndDate + ", range_2_StartDate=" + range_2_StartDate + ", range_2_EndDate=" + range_2_EndDate + "]";
	}

}
