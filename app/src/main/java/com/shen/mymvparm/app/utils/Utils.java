package com.shen.mymvparm.app.utils;

import android.content.Context;

import com.shen.mymvparm.R;

import java.sql.Date;
import java.text.SimpleDateFormat;

/**
 * Created by shenwangqiang on 2017/8/28.
 */
public class Utils {

    public static String getTime(Context context, long time){
        long current  = System.currentTimeMillis();
        long interval = current - time;
        if(interval>0){
            if(interval<60*1000){
                return context.getString(R.string.just);
            } else if(interval<60*60*1000){
                return context.getString(R.string.interval_minute,interval/60000);
            } else if(interval<24*60*6000){
                return context.getString(R.string.interval_hour,interval/(60*60000));
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
