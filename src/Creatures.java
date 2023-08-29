public abstract class Creatures {

    int ID;
    int damage;
    int health;
    int coin;
    String name;
    int effect;

    Creatures(int ID, int damage, int health, int coin, String name, int effect){
        this.ID=ID;
        this.damage=damage;
        this.health=health;
        this.coin=coin;
        this.name=name;
        this.effect=effect;
    }
}
