/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package config;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import java.util.Map;

/**
 *
 * @author Administrator
 */
public class AppUtils {

    public static final String DEFAULT_PATERN = "dd/MM/yyyy HH:mm:ss";
    public static final String DATE_ONLY_PATTERN = "dd/MM/yyyy";
    public static final String DATE_PATTERN = "yyyy-MM-dd";
    public static final String TIME_PATTERN = "HH:mm";
    public static final String DATE_LONG_PATERN = "yyyyMM";
    public static final String DATE_YEAR_PATERN = "yyyy";

    public static String getTimeFromDate(Date time) {
        DateFormat formatter = new SimpleDateFormat(TIME_PATTERN);
        return formatter.format(time);
    }

    public static Date addDate(int distance) {
        Date now = new Date();
        Calendar c = Calendar.getInstance();
        c.setTime(now);
        c.add(Calendar.DATE, distance);
        return c.getTime();
    }

    public static Date addDate(Date anchorDate, int distance) {
        Calendar c = Calendar.getInstance();
        c.setTime(anchorDate);
        c.add(Calendar.DATE, distance);
        return c.getTime();
    }

    public static Date addMonth(Date anchorDate, int distance) {
        Calendar c = Calendar.getInstance();
        c.setTime(anchorDate);
        c.add(Calendar.MONTH, distance);
        return c.getTime();
    }

    public static String parseString(Object object) {
        if (object == null) {
            return "";
        }
        return String.valueOf(object);
    }

    public static Float parseFloat(Object object) {
        if (object == null) {
            return 0F;
        }
        Float ret = 0F;
        try {
            ret = Float.parseFloat(parseString(object));
        } catch (Exception e) {

        }
        return ret;
    }

    public static Double parseDouble(Object object) {
        if (object == null) {
            return 0D;
        }
        Double ret = 0D;
        try {
            ret = Double.parseDouble(parseString(object));
        } catch (Exception e) {

        }
        return ret;
    }

    public static Integer parseInt(Object object) {
        if (object == null) {
            return 0;
        }
        Integer ret = 0;
        try {
            ret = Integer.parseInt(parseString(object));
        } catch (Exception ex) {

        }
        return ret;
    }

    public static Short parseShort(Object object) {
        if (object == null) {
            return 0;
        }
        Short ret = 0;
        try {
            ret = Short.parseShort(parseString(object));
        } catch (Exception ex) {

        }
        return ret;
    }

    public static Long parseLong(Object object) {
        if (object == null) {
            return 0L;
        }
        Long ret = 0L;
        try {
            ret = Long.parseLong(parseString(object));
        } catch (Exception ex) {

        }
        return ret;
    }

    public static boolean checkAdminRequestHeader(String adminId, Integer roleId, Integer gymId, Integer branchId) {
        if (roleId == null || gymId == null || branchId == null) {
            return false;
        }
        return true;
    }

    public static Date parseDate(String s) throws ParseException {
        return parseDate(s, DEFAULT_PATERN);
    }

    public static Date clearTimeOfDate(Date date) {
        Calendar cal = Calendar.getInstance();
        cal.setTime(date);
        cal.set(Calendar.HOUR_OF_DAY, 0);
        cal.set(Calendar.MINUTE, 0);
        cal.set(Calendar.SECOND, 0);
        cal.set(Calendar.MILLISECOND, 0);
        return cal.getTime();
    }

    public static Date parseDate(String s, String pattern) throws ParseException {
        if (s == null || s.trim().length() == 0) {
            throw new ParseException("string for parse is null", 1);
        }
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat(pattern);
        Date date = simpleDateFormat.parse(s);
        return date;
    }

    public static String formatDate(long datetime) {
        return formatDate(new Date(datetime), DEFAULT_PATERN);
    }

    public static String formatDate(Date d, String patern) throws NullPointerException, IllegalArgumentException {
        if (d == null) {
            return null;
        }
        return new SimpleDateFormat(patern).format(d);
    }

    public static List<Integer> getListIdFromString(String listid) {
        return getListIdFromString(listid, ",");
    }

    public static List<Integer> getListIdFromString(String listid, String slim) {
        List<Integer> result = new ArrayList<Integer>();
        if (listid != null && listid.length() > 0) {
            String[] ids = listid.split(slim);
            for (String id : ids) {
                result.add(parseInt(id));
            }
        }
        return result;
    }

    public static Integer getDefault(Integer integer, int defaultVal) {
        return integer == null ? defaultVal : integer;
    }

    public static Float getDefault(Float f, float defaultVal) {
        return f == null ? defaultVal : f;
    }

    public static Long getDefault(Long l, long defaultVal) {
        return l == null ? defaultVal : l;
    }

    public static Double getDefault(Double d, double defaultVal) {
        return d == null ? defaultVal : d;
    }

    public static boolean isEmpty(List<Object> list) {
        return list == null || list.isEmpty();
    }

    public static boolean isEmpty(Map<Object, Object> map) {
        return map == null || map.isEmpty();
    }

    public static boolean isNullOrEmpty(String s) {
        return s == null || s.length() == 0;
    }
}
