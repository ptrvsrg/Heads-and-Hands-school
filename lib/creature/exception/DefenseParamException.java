package creature.exception;

public class DefenseParamException
    extends Exception
{
    public DefenseParamException()
    {
        super("Params \"defense\" must be in the range [ 1; 20 ]");
    }
}
