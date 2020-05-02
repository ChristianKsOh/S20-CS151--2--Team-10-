package Visits;

public class DateAndTime implements Comparable<DateAndTime>{
	public static final boolean AM=false;
	public static final boolean PM=false;
	private int month;
	private int day;
	private int year;
	private int hour;
	private int minute;
	private boolean isPM;
	
	public DateAndTime(int month, int day, int year, int hour, int minute, boolean period) {
		this.month=month;
		this.day=day;
		this.year=year;
		this.hour=hour;
		this.minute=minute;
		isPM=PM;
	}
	
	public int getMonth() {
		return month;
	}
	public int getDay() {
		return day;
	}
	public int getYear() {
		return year;
	}
	public int getHour() {
		return hour;
	}
	public int getHourIn24HourFormat() {
		int add=0;
		if(isPM) add=12;
		return hour+add;
	}
	public int getMinutes() {
		return minute;
	}
	public String getPeriod() {
		if(isPM) {
			return "PM";
		}
		return "AM";
	}
	
	public void setDate(int month,int day,int year) {
		this.month=month;
		this.day=day;
		this.year=year;
	}
	public void setTime(int hour,int minutes, boolean period) {
		this.hour=hour;
		this.minute=minutes;
		this.isPM=period;
	}
	
	public int hashCode() {
		return month+day+year+getHourIn24HourFormat()+minute;
	}

	@Override
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
}
