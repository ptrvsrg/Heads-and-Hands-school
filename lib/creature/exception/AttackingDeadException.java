package creature.exception;

public class AttackingDeadException
    extends Exception
{
    public AttackingDeadException()
    {
        super("Dead creature is trying to attack");
    }
}
