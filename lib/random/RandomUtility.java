package random;

public class RandomUtility
{
    public static int randomInt(int min,
                                int max)
            throws IllegalArgumentException
    {
        if (min > max)
            throw new IllegalArgumentException("Param \"max\" " +
                                               "must be greater than or equal to param \"min\"");

        return (int) (Math.random() * (max - min + 1)) + min;
    }
}