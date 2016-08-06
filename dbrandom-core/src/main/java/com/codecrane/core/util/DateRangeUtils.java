package com.codecrane.core.util;

import java.util.Calendar;
import java.util.Date;

/**
 * Created by crane on 16/6/11.
 */
public class DateRangeUtils {
    /**
     * 时间范围：年
     */
    public static final int YEAR = 1;

    /**
     * 时间范围：季度
     */
    public static final int QUARTER = 2;

    /**
     * 时间范围：月
     */
    public static final int MONTH = 3;

    /**
     * 时间范围：旬
     */
    public static final int TENDAYS = 4;

    /**
     * 时间范围：周
     */
    public static final int WEEK = 5;

    /**
     * 时间范围：日
     */
    public static final int DAY = 6;

    /* 基准时间 */
    private Date fiducialDate = null;

    private Calendar cal = null;

    private DateRangeUtils(Date fiducialDate) {
        if (fiducialDate != null) {
            this.fiducialDate = fiducialDate;
        } else {
            this.fiducialDate = new Date(System.currentTimeMillis());
        }

        this.cal = Calendar.getInstance();
        this.cal.setTime(this.fiducialDate);
        this.cal.set(Calendar.HOUR_OF_DAY, 0);
        this.cal.set(Calendar.MINUTE, 0);
        this.cal.set(Calendar.SECOND, 0);
        this.cal.set(Calendar.MILLISECOND, 0);

        this.fiducialDate = this.cal.getTime();
    }

    /**
     * 获取DateHelper实例
     *
     * @param fiducialDate 基准时间
     * @return Date
     */
    public static DateRangeUtils getInstance(Date fiducialDate) {
        return new DateRangeUtils(fiducialDate);
    }

    /**
     * 获取DateHelper实例, 使用当前时间作为基准时间
     *
     * @return Date
     */
    public static DateRangeUtils getInstance() {
        return new DateRangeUtils(null);
    }

    /**
     * 获取年的第一天
     *
     * @param offset 偏移量
     * @return Date
     */
    public Date getFirstDayOfYear(int offset) {
        cal.setTime(this.fiducialDate);
        cal.set(Calendar.YEAR, cal.get(Calendar.YEAR) + offset);
        cal.set(Calendar.MONTH, Calendar.JANUARY);
        cal.set(Calendar.DAY_OF_MONTH, 1);
        return cal.getTime();
    }

    /**
     * 获取年的最后一天
     *
     * @param offset 偏移量
     * @return Date
     */
    public Date getLastDayOfYear(int offset) {
        cal.setTime(this.fiducialDate);
        cal.set(Calendar.YEAR, cal.get(Calendar.YEAR) + offset);
        cal.set(Calendar.MONTH, Calendar.DECEMBER);
        cal.set(Calendar.DAY_OF_MONTH, 31);
        return cal.getTime();
    }

    /**
     * 获取季度的第一天
     *
     * @param offset 偏移量
     * @return Date
     */
    public Date getFirstDayOfQuarter(int offset) {
        cal.setTime(this.fiducialDate);
        cal.add(Calendar.MONTH, offset * 3);
        int mon = cal.get(Calendar.MONTH);
        if (mon >= Calendar.JANUARY && mon <= Calendar.MARCH) {
            cal.set(Calendar.MONTH, Calendar.JANUARY);
            cal.set(Calendar.DAY_OF_MONTH, 1);
        }
        if (mon >= Calendar.APRIL && mon <= Calendar.JUNE) {
            cal.set(Calendar.MONTH, Calendar.APRIL);
            cal.set(Calendar.DAY_OF_MONTH, 1);
        }
        if (mon >= Calendar.JULY && mon <= Calendar.SEPTEMBER) {
            cal.set(Calendar.MONTH, Calendar.JULY);
            cal.set(Calendar.DAY_OF_MONTH, 1);
        }
        if (mon >= Calendar.OCTOBER && mon <= Calendar.DECEMBER) {
            cal.set(Calendar.MONTH, Calendar.OCTOBER);
            cal.set(Calendar.DAY_OF_MONTH, 1);
        }
        return cal.getTime();
    }

    public Date getYesterday() {
        long time = this.fiducialDate.getTime() - 60 * 60 * 24 * 1000;
        return new Date(time);
    }

    public Date getTomorrow() {
        long time = this.fiducialDate.getTime() + 60 * 60 * 24 * 1000;
        return new Date(time);
    }

    /**
     * 获取季度的最后一天
     *
     * @param offset 偏移量
     * @return Date
     */
    public Date getLastDayOfQuarter(int offset) {
        cal.setTime(this.fiducialDate);
        cal.add(Calendar.MONTH, offset * 3);

        int mon = cal.get(Calendar.MONTH);
        if (mon >= Calendar.JANUARY && mon <= Calendar.MARCH) {
            cal.set(Calendar.MONTH, Calendar.MARCH);
            cal.set(Calendar.DAY_OF_MONTH, 31);
        }
        if (mon >= Calendar.APRIL && mon <= Calendar.JUNE) {
            cal.set(Calendar.MONTH, Calendar.JUNE);
            cal.set(Calendar.DAY_OF_MONTH, 30);
        }
        if (mon >= Calendar.JULY && mon <= Calendar.SEPTEMBER) {
            cal.set(Calendar.MONTH, Calendar.SEPTEMBER);
            cal.set(Calendar.DAY_OF_MONTH, 30);
        }
        if (mon >= Calendar.OCTOBER && mon <= Calendar.DECEMBER) {
            cal.set(Calendar.MONTH, Calendar.DECEMBER);
            cal.set(Calendar.DAY_OF_MONTH, 31);
        }
        return cal.getTime();
    }

    /**
     * 获取月的最后一天
     *
     * @param offset 偏移量
     * @return Date
     */
    public Date getFirstDayOfMonth(int offset) {
        cal.setTime(this.fiducialDate);
        cal.add(Calendar.MONTH, offset);
        cal.set(Calendar.DAY_OF_MONTH, 1);
        return cal.getTime();
    }

    /**
     * 获取月的最后一天
     *
     * @param offset 偏移量
     * @return Date
     */
    public Date getLastDayOfMonth(int offset) {
        cal.setTime(this.fiducialDate);
        cal.add(Calendar.MONTH, offset + 1);
        cal.set(Calendar.DAY_OF_MONTH, 1);
        cal.add(Calendar.DAY_OF_MONTH, -1);
        return cal.getTime();
    }

    /**
     * 获取旬的第一天
     *
     * @param offset 偏移量
     * @return Date
     */
    public Date getFirstDayOfTendays(int offset) {
        cal.setTime(this.fiducialDate);
        int day = cal.get(Calendar.DAY_OF_MONTH);
        if (day >= 21) {
            day = 21;
        } else if (day >= 11) {
            day = 11;
        } else {
            day = 1;
        }

        if (offset > 0) {
            day = day + 10 * offset;
            int monOffset = day / 30;
            day = day % 30;
            cal.add(Calendar.MONTH, monOffset);
            cal.set(Calendar.DAY_OF_MONTH, day);
        } else {
            int monOffset = 10 * offset / 30;
            int dayOffset = 10 * offset % 30;
            if ((day + dayOffset) > 0) {
                day = day + dayOffset;
            } else {
                monOffset = monOffset - 1;
                day = day - dayOffset - 10;
            }
            cal.add(Calendar.MONTH, monOffset);
            cal.set(Calendar.DAY_OF_MONTH, day);
        }
        return cal.getTime();
    }

    /**
     * 获取旬的最后一天
     *
     * @param offset 偏移量
     * @return Date
     */
    public Date getLastDayOfTendays(int offset) {
        Date date = getFirstDayOfTendays(offset + 1);
        cal.setTime(date);
        cal.add(Calendar.DAY_OF_MONTH, -1);
        return cal.getTime();
    }

    /**
     * 获取周的第一天(MONDAY)
     *
     * @param offset 偏移量
     * @return Date
     */
    public Date getFirstDayOfWeek(int offset) {
        cal.setTime(this.fiducialDate);
        cal.add(Calendar.DAY_OF_MONTH, offset * 7);
        cal.set(Calendar.DAY_OF_WEEK, Calendar.MONDAY);
        return cal.getTime();
    }

    /**
     * 获取周的最后一天(SUNDAY)
     *
     * @param offset 偏移量
     * @return Date
     */
    public Date getLastDayOfWeek(int offset) {
        cal.setTime(this.fiducialDate);
        cal.add(Calendar.DAY_OF_MONTH, offset * 7);
        cal.set(Calendar.DAY_OF_WEEK, Calendar.MONDAY);
        cal.add(Calendar.DAY_OF_MONTH, 6);
        return cal.getTime();
    }

    /**
     * 获取指定时间范围的第一天
     *
     * @param dateRangeType 时间范围类型
     * @param offset        偏移量
     * @return Date
     */
    public Date getFirstDate(int dateRangeType, int offset) {
        return null;
    }

    /**
     * 获取指定时间范围的最后一天
     *
     * @param dateRangeType 时间范围类型
     * @param offset        偏移量
     * @return Date
     */
    public Date getLastDate(int dateRangeType, int offset) {
        return null;
    }

    /**
     * 根据日历的规则，为基准时间添加指定日历字段的时间量
     *
     * @param field  日历字段, 使用Calendar类定义的日历字段常量
     * @param offset 偏移量
     * @return Date
     */
    public Date add(int field, int offset) {
        cal.setTime(this.fiducialDate);
        cal.add(field, offset);
        return cal.getTime();
    }

    /**
     * 根据日历的规则，为基准时间添加指定日历字段的单个时间单元
     *
     * @param field 日历字段, 使用Calendar类定义的日历字段常量
     * @param up    指定日历字段的值的滚动方向。true:向上滚动 / false:向下滚动
     * @return Date
     */
    public Date roll(int field, boolean up) {
        cal.setTime(this.fiducialDate);
        cal.roll(field, up);
        return cal.getTime();
    }

}
