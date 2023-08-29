import java.util.Random;

public class Place {
    String name;
    Monster monster;
    boolean item;
    Character character;

    Place(String name, Monster monster, boolean item){
        this.monster=monster;
        this.name=name;
        this.item=item;
    }

    public int monsterNumber(){
        Random rand = new Random();
        int number = rand.nextInt(3)+1;
        return number;
    }
    public void battleTrophy(Character character, int i, Monster monster){
        System.out.println(" ");
        System.out.println(i+". " + monster.name);
        System.out.println("---------");
        System.out.println("Player health:" + character.health + " / Monster health:" + monster.health);
        int temp=monster.health;
        Random rand = new Random();
        int number = rand.nextInt(2);
        if(number==0){
            System.out.println("=You make the first move.=\n==Your damage: " + character.effect + "\n===Monster's damage: " + monster.effect);
            while(monster.health>0 && character.health>0){
                monster.health-=character.effect;
                if(monster.health<=0 || character.health<=0) {
                    System.out.println("Monster health:" + monster.health + " / Player health:" + character.health);
                    break;
                }
                character.health-=monster.effect;
                System.out.println("Monster health:" + monster.health + " / Player health:" + character.health);
            }
        }
        if(number==1){
            System.out.println(monster.name + " makes the first move.=\n==Your damage: " + character.effect + "\n===Monster's damage: " + monster.effect);
            while(monster.health>0 && character.health>0){
                character.health-=monster.effect;
                if(monster.health<=0 || character.health<=0) {
                    System.out.println("Player health:" + character.health + " / Monster health:" + monster.health);
                    break;
                }
                monster.health-=character.effect;
                System.out.println("Player health:" + character.health + " / Monster health:" + monster.health);
            }
        }

        System.out.println("Player health:" + character.health + " / Monster health:" + monster.health);
        System.out.println("---------");
        monster.health=temp;
    }

    public void snakeItemDraw(Character character, Monster c1, Monster c2, Monster c3, Monster c4, Place place){
        Random rand = new Random();
        int wheel = rand.nextInt(100)+1;
        if(wheel>0 && wheel<=45){ // nothing
            System.out.println("You didn't win anything. :(");
        }
        if(wheel>45 && wheel<=60){ // weapon
            int wpn = rand.nextInt(100)+1;
            if(wpn>0 && wpn<=20){ // rifle
                character.effect=character.damage+7;
                System.out.println("You won rifle. :)");
            }
            if(wpn>20 && wpn<=50){ // sword
                character.effect=character.damage+3;
                System.out.println("You won sword. :)");

            }
            if(wpn>50 && wpn<=100){ // gun
                character.effect=character.damage+2;
                System.out.println("You won gun. :)");

            }
            place.item=true;

        }
        if(wheel>60 && wheel<=75){ // armor
            int armr = rand.nextInt(100)+1;
            if(armr>0 && armr<=20){ // heavy
                c1.effect=0;
                c2.effect=0;
                c3.effect=c3.damage-5;
                if(c4.damage-5>=0){
                    c4.effect=c4.damage-5;
                }
                else{
                    c4.effect=0;
                }
                System.out.println("You won heavy armor. :)");
            }
            if(armr>20 && armr<=50){ // mid
                c1.effect=c1.damage-3;
                c2.effect=c2.damage-3;
                c3.effect=c3.damage-3;
                c4.effect=c4.damage-3;
                System.out.println("You won mid armor. :)");
            }
            if(armr>50 && armr<=100){ // light
                c1.effect=c1.damage-1;
                c2.effect=c2.damage-1;
                c3.effect=c3.damage-1;
                c4.effect=c4.damage-1;
                System.out.println("You won light armor. :)");
            }
            place.item=true;
        }
        if(wheel>75 && wheel<=100){ // coin
            int cn = rand.nextInt(100)+1;
            if(cn>0 && cn<=20){ // 10 coin
                character.coin=character.coin+10;
                System.out.println("You won 10 coin. :)");
            }
            if(cn>20 && cn<=50){ // 5 coin
                character.coin=character.coin+5;
                System.out.println("You won 5 coin. :)");
            }
            if(cn>50 && cn<=100){ // 1 coin
                character.coin=character.coin+1;
                System.out.println("You won 1 coin. :)");
            }
            place.item=true;
        }
    }
}
