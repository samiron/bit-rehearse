package of.samiron.hackerrank;// you can also use imports, for example:
// import java.util.*;

import java.util.*;

// you can write to stdout for debugging purposes, e.g.
// System.out.println("this is a debug message");

class CalenderSchedule {

    private static final Integer[] START_MINUTES = {0, 1440, 1440 * 2, 1440 * 3, 1440 * 4, 1440 * 5, 1440 * 6};
    private HashMap<Integer, ArrayList<Meeting>> calender = new HashMap<>();

    class Meeting {
        int day; // 0 - 6
        int startMinute;
        int endMinute;
        String startTime;
        String endTime;

        public void setStartMinute(String startM) {
            this.startMinute = parseTime(startM);
        }

        public void setEndMinute(String endM) {
            this.endMinute = parseTime(endM);
        }

        private int parseTime(String t) {
            int hour = Integer.parseInt(t.substring(0, 2));
            int minute = Integer.parseInt(t.substring(3, 5));
            return START_MINUTES[this.day] + hour * 60 + minute;
        }
    }


    /**
     Questions:
     - Will every day must have a meeting?
     - Can I assume that the day in the first line is the start of the week?
     **/
    public int solution(String S) {
        // write your code in Java SE 8

        calender.clear();

        for(String s : S.split("\n")) {
            Meeting m = parseMeeting(s);

            if(!calender.containsKey(m.day)) {
                calender.put(m.day, new ArrayList<>());
            }
            calender.get(m.day).add(m);
        }

        // The sorting was missing
        for(Integer k : calender.keySet()) {
            calender.get(k).sort(Comparator.comparingInt(m -> m.startMinute));
        }

        int maxDuration = 0;

        int currentMinute = 0;

        for(int days = 0 ; days < 7 ; days ++) {
            for(Meeting m : calender.get(days)) {
                int freeTime = m.startMinute - currentMinute;
                if(freeTime > maxDuration) {
                    maxDuration = freeTime;
                }
                currentMinute = m.endMinute;
            }
        }


        return maxDuration;


    }

    private Meeting parseMeeting(String line) {
        Meeting m = new Meeting();
        m.day = dayNumber(line.substring(0, 3));
        m.setStartMinute(line.substring(4, 9));
        m.setEndMinute(line.substring(10, 15));
        return m;
    }

    /**
     If I assume the week always starts at Monday,
     and the given string just gives the calender schedule without maintaining the order of the days.

     **/
    private int dayNumber(String day) {
        if(day.equals("Mon")) return 0;
        if(day.equals("Tue")) return 1;
        if(day.equals("Wed")) return 2;
        if(day.equals("Thu")) return 3;
        if(day.equals("Fri")) return 4;
        if(day.equals("Sat")) return 5;
        if(day.equals("Sun")) return 6;
        return -1;
    }

    public static void main(String[] args) {
        String input  = "Sun 10:00-20:00\nFri 05:00-10:00\nFri 16:30-23:50\nSat 10:00-24:00\nSun 01:00-04:00\nSat 02:00-06:00\nTue 03:30-18:15\nTue 19:00-20:00\nWed 04:25-15:14\nWed 15:14-22:40\nThu 00:00-23:59\nMon 05:00-13:00\nMon 15:00-21:00";
        System.out.println(new CalenderSchedule().solution(input));
    }
}


