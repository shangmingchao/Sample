package cn.frank.sample.utils;

import android.text.format.DateUtils;

public class TimeUtils {

    public static String formatRelativeTimeSpan(long time) {
        return DateUtils.getRelativeTimeSpanString(time).toString();
    }
}
