package creature.exception;

public class MaxHealthParamException
    extends Exception
{
    public MaxHealthParamException()
    {
        super("Param \"maxHealth\" must be positive");
    }
}
