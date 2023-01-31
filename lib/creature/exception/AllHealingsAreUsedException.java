package creature.exception;

public class AllHealingsAreUsedException
    extends Exception
{
    public AllHealingsAreUsedException()
    {
        super("All healing attempts have already been used");
    }
}
