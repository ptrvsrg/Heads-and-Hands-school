package creature;

import creature.exception.*;

public class MonsterFactory
        implements FactoryMethod
{
    @Override
    public Creature create(int attack,
                           int defense,
                           int maxHealth,
                           int minDamage,
                           int maxDamage)
            throws MaxHealthParamException,
                   MaxDamageParamException,
                   MinDamageParamException,
                   AttackParamException,
                   DefenseParamException
    {
        return new Monster(attack,
                           defense,
                           maxHealth,
                           minDamage,
                           maxDamage);
    }
}
