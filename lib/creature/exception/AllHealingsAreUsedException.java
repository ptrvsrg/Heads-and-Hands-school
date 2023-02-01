package creature.exception;

public class AllHealingsAreUsedException
    extends RuntimeException
{
    public AllHealingsAreUsedException()
    {
        super("All healing attempts have already been used");
    }
}
