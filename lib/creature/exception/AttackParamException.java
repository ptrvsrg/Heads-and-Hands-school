package creature.exception;

public class AttackParamException
    extends Exception
{
    public AttackParamException()
    {
        super("Params \"attack\" must be in the range [ 1; 20 ]");
    }
}
