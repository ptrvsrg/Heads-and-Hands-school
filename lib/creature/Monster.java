package creature;

import creature.exception.*;

class Monster
        extends Creature
{
    public Monster(int attack,
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
        super(attack,
              defense,
              maxHealth,
              minDamage,
              maxDamage);
    }

    @Override
    public void heal()
    {
        throw new UnsupportedOperationException("Unsupported operation");
    }
}
