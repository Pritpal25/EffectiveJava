package chapter4.item16;

// No ability to change representation or take action when fields accessed since the fields are public.
public class PublicImmutableTime {
    private static final int HOURS_IN_A_DAY = 24;
    private static final int MINUTES_IN_A_HOUR = 60;

    // Sometimes okay to expose fields in public classes ONLY if they are immutable.
    public final int hour;
    public final int minute;

    //// Enforcing invariants
    public PublicImmutableTime(int hour, int minute) {
        if(hour < 0 || hour > HOURS_IN_A_DAY) {
            throw new IllegalArgumentException("Hour : " + hour);
        }

        if(minute < 0  || minute > MINUTES_IN_A_HOUR) {
            throw new IllegalArgumentException("Minute : " + minute);
        }

        this.hour = hour;
        this.minute = minute;
    }
}
