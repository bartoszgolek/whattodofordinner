package biz.golek.whattodofordinner.utils;

/**
 * Created by bg on 09.02.16.
 */
public class FlagHelper {
    public static boolean flagIsSet(int position, int value)
    {
        return (value | (1 << position)) == value;
    }

    public static int setFlag(int position, int value)
    {
        return value | (1 << position);
    }

    public static int unsetFlag(int position, int value)
    {
        return value & ~(1 << position);
    }
}
