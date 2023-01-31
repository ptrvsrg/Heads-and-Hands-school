package creature;

import creature.exception.*;

public interface FactoryMethod
{
    Creature create(int attack,
                    int defense,
                    int max_health,
                    int min_damage,
                    int max_damage)
            throws MaxHealthParamException,
                   MaxDamageParamException,
                   MinDamageParamException,
                   AttackParamException,
                   DefenseParamException;
}
