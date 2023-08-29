public class Character extends Creatures{

    Character(int ID, int damage, int health, int coin, String name, int effect) {
        super(ID, damage, health, coin, name, effect);
    }

    public void healthFill() {
        if(ID==1) health=21;
        if(ID==2) health=18;
        if(ID==3) health=24;
    }

}
