import java.util.Random;

public class Monster extends Creatures{

    Monster(int ID, int damage, int health, int coin, String name, int effect) {
        super(ID, damage, health, coin, name, effect);
    }

    static int damageDraw(){
        Random rand = new Random();
        int dmg = rand.nextInt(4)+3;
        return dmg;
    }
}
