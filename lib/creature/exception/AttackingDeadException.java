package creature.exception;

public class AttackingDeadException
    extends RuntimeException
{
    public AttackingDeadException()
    {
        super("Dead creature is trying to attack");
    }
}
