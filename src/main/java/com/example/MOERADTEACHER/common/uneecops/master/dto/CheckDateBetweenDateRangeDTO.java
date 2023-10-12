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
public class CheckDateBetweenDateRangeDTO {
	private LocalDate dateToValidate;
	private LocalDate rangeStartDate;
	private LocalDate rangeEndDate;

	/**
	 * @param dateToValidate
	 * @param rangeStartDate
	 * @param rangeEndDate
	 */
	public CheckDateBetweenDateRangeDTO(LocalDate dateToValidate, LocalDate rangeStartDate, LocalDate rangeEndDate) {
		super();
		Objects.requireNonNull(dateToValidate, " DateToValidate can not be null ");
		Objects.requireNonNull(rangeStartDate, " rangeStartDate can not be null ");
		Objects.requireNonNull(rangeEndDate, " rangeEndDate can not be null ");
		this.dateToValidate = dateToValidate;
		this.rangeStartDate = rangeStartDate;
		this.rangeEndDate = rangeEndDate;
	}

	/**
	 * @return the dateToValidate
	 */
	public LocalDate getDateToValidate() {
		return dateToValidate;
	}

	/**
	 * @return the rangeStartDate
	 */
	public LocalDate getRangeStartDate() {
		return rangeStartDate;
	}

	/**
	 * @return the rangeEndDate
	 */
	public LocalDate getRangeEndDate() {
		return rangeEndDate;
	}

	@Override
	public String toString() {
		return "CheckDateBetweenDateRangeDTO [dateToValidate=" + dateToValidate + ", rangeStartDate=" + rangeStartDate + ", rangeEndDate=" + rangeEndDate + "]";
	}
}
