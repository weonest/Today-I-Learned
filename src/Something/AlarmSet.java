package Something;


public class AlarmSet {


    private int time;
    private int minute;
    private boolean ring;

    public int getTime() {
        return time;
    }

    public void setTime(int time) {
        if (time > 24) {
            try {
                Exception e = new Exception();
                throw e;
            } catch (Exception e) {
                System.out.println("24 이하의 숫자를 입력해 주세요.");
            }
        } else {
            this.time = time;
        }
    }

    public int getMinute() {
        return minute;
    }

    public void setMinute(int minute) {
        if ( minute > 60) {
            try {
                Exception e = new Exception();
                throw e;
            } catch (Exception e) {
                System.out.println("60 이하의 숫자를 입력해 주세요.");
            }
        }
        this.minute = minute;
    }

    public boolean isRing() {
        return ring;
    }

    public void setRing(boolean ring) {
        this.ring = ring;
        System.out.println("띠리리리리리리링");
    }
}

