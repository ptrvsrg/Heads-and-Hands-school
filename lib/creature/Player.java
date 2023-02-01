package creature;

import creature.exception.*;

class Player
        extends Creature
{
    public static final int MAX_HEALING_COUNT = 3;
    private int currentHealingCount;

    public Player(int attack,
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

        currentHealingCount = 0;
    }

    @Override
    public void heal()
    {
        if (currentHealth == maxHealth)
            throw new FullHealthException();

        if (currentHealingCount >= MAX_HEALING_COUNT)
            throw new AllHealingsAreUsedException();

        ++currentHealingCount;
        currentHealth = Math.min(currentHealth + (maxHealth / 2),
                                 maxHealth);
    }
}
