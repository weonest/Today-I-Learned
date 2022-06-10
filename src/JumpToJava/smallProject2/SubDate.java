package JumpToJava.smallProject2;

public class SubDate {
    public boolean isLeapYear(int year) {
        if (year % 400 == 0 ) return true;
        if (year % 100 == 0 ) return false;
        if (year % 4 == 0) return true;
        return false;
    }

    public int getYearDay(int year) {
        int result = 0;
        for (int i = 1; i < year; i++) {
             if (isLeapYear(i)) result += 366;
             else result += 365;
        }
        return result;
    }

    public final int[] monthDays = {
            31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31
    };

    public int getMonthDay(int month, boolean isLeap) {
        int result = 0;
        for (int i = 1; i < month; i++) {
            result += monthDays[i - 1];
        }
        if (isLeap && month > 2) result += 1; // 윤달이고 2월 이후면 총합에 +1
        return result;
    }

    public int getTotalDay(String date) {
        int year = Integer.parseInt(date.substring(0, 4));
        int month = Integer.parseInt(date.substring(4, 6));
        int day = Integer.parseInt(date.substring(6, 8));
        return getYearDay(year)
                + getMonthDay(month, isLeapYear(year))
                + day;
    }

    public int sub(int date1, int date2) {
        String dt1 = String.valueOf(date1);
        String dt2 = String.valueOf(date2);

        return Math.abs(getTotalDay(dt1) - getTotalDay(dt2));
    }

    public static void main(String[] args) {
        SubDate subDate = new SubDate();
        System.out.println(subDate.sub(20220610, 19980729));
    }
}

