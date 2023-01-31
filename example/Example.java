import game.*;

public class Example
{
    public static void main(String[] args)
    {
        try
        {
            Game game = new Game();
            game.launch();
        }
        catch(Exception ex)
        {
            System.out.println(ex.getMessage());
        }
    }
}
