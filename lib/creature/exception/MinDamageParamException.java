package creature.exception;

public class MinDamageParamException
    extends Exception
{
    public MinDamageParamException()
    {
        super("Param \"minDamage\" must be positive");
    }
}
