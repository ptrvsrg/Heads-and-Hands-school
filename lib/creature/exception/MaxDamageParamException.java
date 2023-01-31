package creature.exception;

public class MaxDamageParamException
    extends Exception
{
    public MaxDamageParamException()
    {
        super("Param \"maxDamage\" must be greater than or equal to param \"minDamage\"");
    }
}
