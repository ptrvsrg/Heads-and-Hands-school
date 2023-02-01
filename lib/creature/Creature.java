package creature;

import creature.exception.*;
import random.RandomUtility;

abstract public class Creature
{
    public static final int MAX_ATTACK = 20;
    public static final int MAX_DEFENSE = 20;
    private final int attack;
    private final int defense;
    protected final int maxHealth;
    private final int minDamage;
    private final int maxDamage;
    protected int currentHealth;

    public Creature(int attack,
                    int defense,
                    int maxHealth,
                    int minDamage,
                    int maxDamage)
            throws AttackParamException,
                   DefenseParamException,
                   MinDamageParamException,
                   MaxDamageParamException,
                   MaxHealthParamException
    {
        if (attack <= 0 || attack > MAX_ATTACK)
            throw new AttackParamException();
        if (defense <= 0 || defense > MAX_DEFENSE)
            throw new DefenseParamException();
        if (minDamage <= 0)
            throw new MinDamageParamException();
        if (minDamage > maxDamage)
            throw new MaxDamageParamException();
        if (maxHealth <= 0)
            throw new MaxHealthParamException();

        this.attack = attack;
        this.defense = defense;
        this.minDamage = minDamage;
        this.maxDamage = maxDamage;
        this.maxHealth = this.currentHealth = maxHealth;
    }

    public final int getAttack()
    {
        return attack;
    }

    public final int getDefense()
    {
        return defense;
    }

    public final int getMinDamage()
    {
        return minDamage;
    }

    public final int getMaxDamage()
    {
        return maxDamage;
    }

    public final int getMaxHealth()
    {
        return maxHealth;
    }

    public final int getCurrentHealth()
    {
        return currentHealth;
    }

    public final boolean isDead()
    {
        return currentHealth <= 0;
    }

    private int calculateAttackModifier(Creature opponent)
    {
        return Math.max(attack - opponent.defense + 1,
                        1);
    }

    public void attack(Creature opponent)
    {
        if (isDead())
            throw new AttackingDeadException();
        if (opponent.isDead())
            throw new AttackedDeadException();

        int attackModifier = calculateAttackModifier(opponent);

        for (int i = 0; i < attackModifier; ++i)
        {
            if (RandomUtility.randomInt(1, 6) >= 5)
            {
                int damage = RandomUtility.randomInt(minDamage,
                                                     maxDamage);
                opponent.currentHealth = Math.max(opponent.currentHealth - damage,
                                                  0);
                return;
            }
        }
    }

    public abstract void heal();
}