package com.example.demo.utils;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

/**
 * @author lengon
 * @ClassName: DateUtils
 * @Description: 时间类操作
 * @date 2016年1月18日 上午11:49:39
 */
public class DateUtils {

	public static final String DAY_FORMAT = "yyyyMMdd";
	public static final String DAY_FORMAT1 = "yyyy-MM-dd";
	public static final String HOUR_FORMAT = "yyyyMMddHH";
	public static final String MINUTE_FORMAT = "yyyyMMddHHmm";
	public static final String SECOND_FORMAT = "yyyyMMddHHmmss";
	public static final String SECOND_FORMAT1 = "yyyy-MM-dd HH:mm:ss";

	public static final int DAY_IN_MILLSECOND = 1000 * 3600 * 24;
	public static final int HOUR_IN_MILLSECOND = 1000 * 3600;
	public static final int MINUTE_IN_MILLSECOND = 1000 * 60;
	public static final int MINUTE_IN_SECOND = 60;
	public static final int DAY_IN_SECOND = 3600 * 24;
	public static final int HOUR_IN_SECOND = 3600;

	public static String buildTodayStr() {
		SimpleDateFormat sdf = new SimpleDateFormat(DAY_FORMAT);
		Date date = new Date();
		try {
			String time = sdf.format(date);
			return time;
		} catch (Exception ex) {
		}
		return null;
	}

	public static String buildNowStr(String format) {
		SimpleDateFormat sdf = new SimpleDateFormat(format);
		Date date = new Date();
		try {
			String time = sdf.format(date);
			return time;
		} catch (Exception ex) {
		}
		return null;
	}

	/**
	 * 
	 * @Title: futureDay
	 * @Description: 未来的第几天的string
	 * @param start
	 * @param day
	 *            (负号表示过去几天)
	 * @return
	 */
	public static String futureDay(String start, String format, int day) {
		SimpleDateFormat sdf = new SimpleDateFormat(format);
		long startTime;
		try {
			startTime = sdf.parse(start).getTime();
			long endTime = startTime + ((long) DAY_IN_MILLSECOND * day);
			return sdf.format(new Date(endTime));
		} catch (ParseException e) {
			e.printStackTrace();
		}
		return null;
	}

	public static List<String> buildHourTimes(String startTime, String endTime, String format) {
		SimpleDateFormat sdf = new SimpleDateFormat(format);
		try {
			long startTimeMillus = sdf.parse(startTime).getTime();
			long endTimeMillus = sdf.parse(endTime).getTime();
			if (endTimeMillus < startTimeMillus) {
				return null;
			}

			List<String> hours = new ArrayList<String>();

			while (endTimeMillus >= startTimeMillus) {
				hours.add(sdf.format(new Date(startTimeMillus)));
				startTimeMillus += HOUR_IN_MILLSECOND;
			}
			return hours;
		} catch (Exception ex) {
		}
		return null;

	}

	public static List<String> buildTimes(String startTime, String endTime, String format, long timeGap) {
		SimpleDateFormat sdf = new SimpleDateFormat(format);
		try {
			long startTimeMillus = sdf.parse(startTime).getTime();
			long endTimeMillus = sdf.parse(endTime).getTime();
			if (endTimeMillus < startTimeMillus) {
				return null;
			}

			List<String> hours = new ArrayList<String>();

			while (endTimeMillus >= startTimeMillus) {
				hours.add(sdf.format(new Date(startTimeMillus)));
				startTimeMillus += timeGap;
			}
			return hours;
		} catch (Exception ex) {
		}
		return null;

	}

	public static List<String> buildDayTimes(String startTime, String endTime, String format) {
		SimpleDateFormat sdf = new SimpleDateFormat(format);
		try {
			long startTimeMillus = sdf.parse(startTime).getTime();
			long endTimeMillus = sdf.parse(endTime).getTime();
			if (endTimeMillus < startTimeMillus) {
				return null;
			}

			List<String> hours = new ArrayList<String>();

			while (endTimeMillus >= startTimeMillus) {
				hours.add(sdf.format(new Date(startTimeMillus)));
				startTimeMillus += DAY_IN_MILLSECOND;
			}
			return hours;
		} catch (Exception ex) {
		}
		return null;

	}

	/**
	 * 
	 * @Title: futureHour
	 * @Description: 未来的第几小时的string
	 * @param start
	 *            (负号表示过去几小时)
	 * @return
	 */
	public static String futureHour(String start, String format, int hour) {
		SimpleDateFormat sdf = new SimpleDateFormat(format);
		long startTime;
		try {
			startTime = sdf.parse(start).getTime();
			long endTime = startTime + ((long) HOUR_IN_MILLSECOND * hour);
			return sdf.format(new Date(endTime));
		} catch (ParseException e) {
			e.printStackTrace();
		}
		return null;
	}

	/**
	 * 
	 * @Title: futureHour
	 * @Description: 未来的第几分钟的string
	 * @param start
	 * @param format
	 * @param minute
	 * @return
	 */
	public static String futureMinute(String start, String format, int minute) {
		SimpleDateFormat sdf = new SimpleDateFormat(format);
		long startTime;
		try {
			startTime = sdf.parse(start).getTime();
			long endTime = startTime + ((long) MINUTE_IN_MILLSECOND * minute);
			return sdf.format(new Date(endTime));
		} catch (ParseException e) {
			e.printStackTrace();
		}
		return null;
	}

	public static int dayGap(String start, String end, String startFormat, String endFormat) {
		SimpleDateFormat startSdf = new SimpleDateFormat(startFormat);
		SimpleDateFormat endSdf = new SimpleDateFormat(endFormat);
		long startTime;
		try {
			startTime = startSdf.parse(start).getTime();
			long endTime = endSdf.parse(end).getTime();
			return (int) ((endTime - startTime) / DAY_IN_MILLSECOND);
		} catch (ParseException e) {
			e.printStackTrace();
		}
		return -1;
	}

	public static int hourGap(String start, String end, String startFormat, String endFormat) {
		SimpleDateFormat startSdf = new SimpleDateFormat(startFormat);
		SimpleDateFormat endSdf = new SimpleDateFormat(endFormat);
		long startTime;
		try {
			startTime = startSdf.parse(start).getTime();
			long endTime = endSdf.parse(end).getTime();
			return (int) ((endTime - startTime) / HOUR_IN_MILLSECOND);
		} catch (ParseException e) {
			e.printStackTrace();
		}
		return -1;
	}

	public static int minuteGap(String start, String end, String startFormat, String endFormat) {
		SimpleDateFormat startSdf = new SimpleDateFormat(startFormat);
		SimpleDateFormat endSdf = new SimpleDateFormat(endFormat);
		long startTime;
		try {
			startTime = startSdf.parse(start).getTime();
			long endTime = endSdf.parse(end).getTime();
			return (int) ((endTime - startTime) / MINUTE_IN_MILLSECOND);
		} catch (ParseException e) {
			e.printStackTrace();
		}
		return -1;
	}

	public static long getTime(String time, String format) {
		SimpleDateFormat sdf = new SimpleDateFormat(format);
		try {
			return sdf.parse(time).getTime();
		} catch (ParseException e) {
			e.printStackTrace();
			return 0;
		}
	}

	public static String getTime(long time, String format) {
		SimpleDateFormat sdf = new SimpleDateFormat(format);
		try {
			return sdf.format(new Date(time));
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}

	public static String formatDataFromString(String time, String format) {
		SimpleDateFormat sdf = new SimpleDateFormat(format);
		try {
			return sdf.format(sdf.parse(time));
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}

	public static String formatDataFromString(Date time, String format) {
		SimpleDateFormat sdf = new SimpleDateFormat(format);
		try {
			return sdf.format(time);
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}

	/**
	 * 将字符串转换成指定的时间格式的字符串
	 * 
	 * @Title: getTimeString
	 * @Description: TODO
	 * @param time
	 *            yyyyMMddHHmmss
	 * @param format
	 * @return String
	 */
	public static String getTimeString(String time, String format) {
		SimpleDateFormat sdf = new SimpleDateFormat(format);
		SimpleDateFormat sdfTemp = new SimpleDateFormat(SECOND_FORMAT);
		try {
			return sdf.format(sdfTemp.parse(time));
		} catch (Exception e) {
//			LogUtils.error("convert date to String error:" + e);
		}
		return null;
	}

	/**
	 * 将字符串转换成指定的时间格式的字符串
	 * 
	 * @Title: getTimeString
	 * @Description: TODO
	 * @param time
	 *            yyyyMMddHHmmss
	 * @param format
	 * @return String
	 */
	public static String getTimeString(String time, String inFormat, String outFormat) {
		SimpleDateFormat inSdf = new SimpleDateFormat(inFormat);
		SimpleDateFormat outSdf = new SimpleDateFormat(outFormat);
		try {
			return outSdf.format(inSdf.parse(time));
		} catch (Exception e) {
//			LogUtils.error("convert date to String error:" + e);
		}
		return null;
	}

	public static Date formatDate(String dateStr) {
		Date date = null;

		try {
			SimpleDateFormat e = new SimpleDateFormat(MINUTE_FORMAT);
			date = e.parse(dateStr);
		} catch (Exception e) {
//			LogUtils.error("format date to String error:" + e);
		}

		return date;
	}

	public static String parseDate(Date date) {
		String str = "";

		try {
			SimpleDateFormat e = new SimpleDateFormat(MINUTE_FORMAT);
			str = e.format(date);
		} catch (Exception e) {
//			LogUtils.error("parse date to String error:" + e);
		}

		return str;
	}

	public static Date parseToDate(String timeStr, String formatStr) {
		Date date = null;
		try {
			SimpleDateFormat sf = new SimpleDateFormat(formatStr);
			date = sf.parse(timeStr);
		} catch (Exception e) {
//			LogUtils.error("format date to String error:" + e);
		}
		return date;
	}

	public static int getDayIndex(String timeStr) {
		long time = DateUtils.getTime(timeStr, DateUtils.DAY_FORMAT);
		Calendar startCal = Calendar.getInstance();
		startCal.setTimeInMillis(time);
		return startCal.get(Calendar.DAY_OF_YEAR);
	}

	public static String getDayStr(int index, String year) {
		long time = DateUtils.getTime(year, "yyyy");
		Calendar timeCal = Calendar.getInstance();
		timeCal.setTimeInMillis(time);
		timeCal.add(Calendar.DAY_OF_YEAR, index - 1);
		return DateUtils.getTime(timeCal.getTimeInMillis(), DateUtils.DAY_FORMAT);
	}

}

