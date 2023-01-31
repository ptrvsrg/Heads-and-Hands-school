package game;

import creature.*;
import creature.exception.*;
import random.RandomUtility;
import java.util.Scanner;

public class Game
{
    private Creature createCreature(FactoryMethod factory)
            throws AttackParamException,
                   DefenseParamException,
                   MaxHealthParamException,
                   MaxDamageParamException,
                   MinDamageParamException
   {
        int attack = RandomUtility.randomInt(1, Creature.MAX_ATTACK);
        int defense = RandomUtility.randomInt(1, Creature.MAX_DEFENSE);
        int maxHealth = RandomUtility.randomInt(1, 100);
        int minDamage = RandomUtility.randomInt(1, 20);
        int maxDamage = RandomUtility.randomInt(minDamage, 20);

        return factory.create(attack,
                              defense,
                              maxHealth,
                              minDamage,
                              maxDamage);
    }

    private void printCreatureProperty(Creature creature)
    {
        System.out.println("\tAttack: " + creature.getAttack());
        System.out.println("\tDefense: " + creature.getDefense());
        System.out.println("\tMax health: " + creature.getMaxHealth());
        System.out.println("\tDamage: " + creature.getMinDamage() + "-" + creature.getMaxDamage());
    }

    private void printHelp()
    {
        System.out.println("Available command:");
        System.out.println("\tattack - player and monster exchange blows, monster hits first");
        System.out.println("\theal - player heals, but monster continues to attack");
    }

    public void launch()
            throws MaxHealthParamException,
                   MaxDamageParamException,
                   MinDamageParamException,
                   AttackParamException,
                   DefenseParamException
    {
        System.out.println("Creating player...");
        PlayerFactory playerFactory = new PlayerFactory();
        Creature player = createCreature(playerFactory);

        System.out.println("Player characteristics:");
        printCreatureProperty(player);

        System.out.println("Creating monster...");
        MonsterFactory monsterFactory = new MonsterFactory();
        Creature monster = createCreature(monsterFactory);

        System.out.println("Monster characteristics:");
        printCreatureProperty(monster);

        System.out.println("Your battle begins...");
        processCommand(player,
                       monster);

        if (monster.isDead())
            System.out.println("Player won");
        else if (player.isDead())
            System.out.println("Monster won");
    }

    private void processCommand(Creature player,
                                Creature monster)
    {
        Scanner scanner = new Scanner(System.in);
        while (true)
        {
            String command = scanner.next();
            try
            {
                switch (command)
                {
                    case "help" -> printHelp();
                    case "attack" ->
                    {
                        monster.attack(player);
                        player.attack(monster);
                        System.out.println("Player health: " + player.getCurrentHealth());
                        System.out.println("Monster health: " + monster.getCurrentHealth());
                    }
                    case "heal" ->
                    {
                        player.heal();
                        monster.attack(player);
                        System.out.println("Player health: " + player.getCurrentHealth());
                        System.out.println("Monster health: " + monster.getCurrentHealth());
                    }
                    default ->
                    {
                        System.err.println("Unrecognized command");
                        printHelp();
                    }
                }
            }
            catch (AllHealingsAreUsedException ex)
            {
                System.err.println(ex.getLocalizedMessage());
            }
            catch (AttackingDeadException |
                   AttackedDeadException ex)
            {
                break;
            }
        }

        scanner.close();
    }
}
