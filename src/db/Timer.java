package db;

import java.sql.Timestamp;
import java.util.Calendar;

public class Timer {
	private Calendar calendar;
	
	public Timer(){
		calendar = Calendar.getInstance();
	}

	public Timestamp getTimeStamp(){		
		java.util.Date now = calendar.getTime();
		
		java.sql.Timestamp currentTimestamp = new java.sql.Timestamp(now.getTime());
		return currentTimestamp;
	}	
}
