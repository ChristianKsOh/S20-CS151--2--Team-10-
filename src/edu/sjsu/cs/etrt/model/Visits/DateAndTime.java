package edu.sjsu.cs.etrt.model.Visits;

public class DateAndTime implements Comparable<DateAndTime>{
	public static final boolean AM=false;
	public static final boolean PM=false;
	private int month;
	private int day;
	private int year;
	private int hour;
	private int minute;
	private boolean isPM;
	
	/**
	 * Represents the date and time. Able to individually retrieve and variable and 
	 * implemented a compareTo method.
	 * @param month Integer representing a month from 1 to 12.
	 * @param day Integer representing a day from 1 to 31.
	 * @param year Integer representing a year in yyyy format.
	 * @param hour Integer representing the hour from 1-12.
	 * @param minute Integer representing a minute from 1-59.
	 * @param period Use DateAndTime.AM ot DateAndTime.PM to represent the period of time.
	 */
	public DateAndTime(int month, int day, int year, int hour, int minute, boolean period) {
		this.month=month;
		this.day=day;
		this.year=year;
		this.hour=hour;
		this.minute=minute;
		isPM=PM;
	}
	
	/**
	 * Returns the month of the date.
	 * @return month.
	 */
	public int getMonth() {
		return month;
	}
	
	/**
	 * Returns the day of the date.
	 * @return day.
	 */
	public int getDay() {
		return day;
	}
	
	/**
	 * Returns the year of the date.
	 * @return year.
	 */
	public int getYear() {
		return year;
	}
	
	/**
	 * Returns the hour of time in 12-hour format.
	 * @return hour.
	 */
	public int getHour() {
		return hour;
	}
	
	/**
	 * Gives the hour in a 24-hour format rather 
	 * than in a 12-hour format.
	 * @return hour in 24-hour format.
	 */
	public int getHourIn24HourFormat() {
		int add=0;
		if(isPM) add=12;
		return hour+add;
	}
	
	/**
	 * Returns the minutes of the time.
	 * @return minutes.
	 */
	public int getMinutes() {
		return minute;
	}
	
	/**
	 * Returns the time period in String format.
	 * @return Time period (as a String).
	 */
	public String getPeriod() {
		if(isPM) {
			return "PM";
		}
		return "AM";
	}
	
	/**
	 * Changes just the date.
	 * @param month Integer representing a month from 1 to 12.
	 * @param day Integer representing a day from 1 to 31.
	 * @param year Integer representing a year in yyyy format.
	 */
	public void setDate(int month,int day,int year) {
		this.month=month;
		this.day=day;
		this.year=year;
	}
	
	/**
	 * Changes just the time.
	 * @param hour Integer representing the hour from 1-12.
	 * @param minute Integer representing a minute from 1-59.
	 * @param period Use DateAndTime.AM ot DateAndTime.PM to represent the period of time.
	 */
	public void setTime(int hour,int minutes, boolean period) {
		this.hour=hour;
		this.minute=minutes;
		this.isPM=period;
	}
	
	@Override
	public int hashCode() {
		return month+day+year+getHourIn24HourFormat()+minute;
	}

	@Override
	/**
	 * Compares based on date first before time.
	 */
	public int compareTo(DateAndTime that) {
		if(year==that.getYear()) {
			if(month==that.getMonth()) {
				if(day==that.getDay()) {
					if(this.getHourIn24HourFormat()==that.getHourIn24HourFormat()) {
						if(minute==that.getMinutes()) {
							return 0;
						}
						return (int)Math.signum(minute-that.getMinutes());
					}
					return (int)Math.signum(this.getHourIn24HourFormat()-that.getHourIn24HourFormat());
				}
				return (int)Math.signum(day-that.getDay());
			}
			return (int)Math.signum(month-that.getMonth());
		}
		return (int)Math.signum(year-that.getYear());
	}
	
	@Override
	public boolean equals(Object that) {
		if(this==that) return true;
		if(!(that instanceof DateAndTime)) return false;
		if(this.getClass() != that.getClass()) return false;
		return compareTo((DateAndTime)that)==0;
	}
}
