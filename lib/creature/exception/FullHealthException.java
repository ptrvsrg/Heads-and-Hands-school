package creature.exception;

public class FullHealthException
    extends RuntimeException
{
    public FullHealthException()
    {
        super("Creature is completely healthy, it dont need healing");
    }
}
