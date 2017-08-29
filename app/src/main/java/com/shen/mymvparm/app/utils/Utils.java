package com.shen.mymvparm.app.utils;

import android.content.Context;

import com.shen.mymvparm.R;

import java.text.SimpleDateFormat;

/**
 * Created by shenwangqiang on 2017/8/28.
 */
public class Utils {
    public static final long MINUTE_Millis = 60 * 1000;
    public static final long HOUR_Millis = 60 * MINUTE_Millis;
    public static final long DAY_Millis = 24 * HOUR_Millis;
    public static final long WEEK_Millis = 7 * DAY_Millis;

    public static String getTime(Context context, long time) {
        long current = System.currentTimeMillis();
        long interval = current - time;
        if (interval > 0) {
            if (interval < MINUTE_Millis) {
                return context.getString(R.string.just);
            } else if (interval < HOUR_Millis) {
                return context.getString(R.string.interval_minute, interval / MINUTE_Millis);
            } else if (interval < DAY_Millis) {
                return context.getString(R.string.interval_hour, interval / HOUR_Millis);
            } else if (interval < WEEK_Millis) {
                return context.getString(R.string.interval_day, interval / DAY_Millis);
            }
        }
        return getTimeStr(time);
    }


    public static String getTimeStr(long time) {
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy年MM月dd日 HH:mm");
        String str = dateFormat.format(time);
        return str;
    }
}
