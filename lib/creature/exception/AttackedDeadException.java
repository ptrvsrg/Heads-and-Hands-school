package creature.exception;

public class AttackedDeadException
    extends Exception
{
    public AttackedDeadException()
    {
        super("Dead creature is being tried to attack");
    }
}
