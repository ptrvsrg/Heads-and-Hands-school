package creature;

import creature.exception.*;

public class PlayerFactory
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
        return new Player(attack,
                          defense,
                          maxHealth,
                          minDamage,
                          maxDamage);
    }
}

