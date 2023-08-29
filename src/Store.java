import java.util.Scanner;

public class Store {
    Character character;
    Monster monster;

    Scanner input = new Scanner(System.in);

    public void trade(Character character, int buy, Monster c1, Monster c2, Monster c3, Monster c4){
        if(buy==1){
            buyWeapon(character);
        }
        if(buy==2){
            buyArmor(character, c1, c2, c3, c4);
        }
    }

    public void buyWeapon(Character character){
        System.out.println("Which one? Gun(1)[25 P], Sword(2)[35 P], Rifle(3)[45 P]");
        System.out.println("Wallet: " + character.coin);
        int buy = input.nextInt();
        if(buy==1 && character.coin>=25){
            character.effect=character.damage+2;
            character.coin-=25;
            System.out.println("Gun bought. Damage (+2): " + character.effect);
        }
        else if(buy==2 && character.coin>=35){
            character.effect=character.damage+3;
            character.coin-=35;
            System.out.println("Sword bought. Damage (+3): " + character.effect);
        }
        else if(buy==3 && character.coin>=45){
            character.effect=character.damage+7;
            character.coin-=45;
            System.out.println("Rifle bought. Damage (+7): " + character.effect);
        }
        else{
            System.out.println("You didn't buy any weapon!");
        }
    }

    public void buyArmor(Character character, Monster c1, Monster c2, Monster c3, Monster c4){
        System.out.println("Which one? Light(1)[15 P], Mid(2)[25 P], Heavy(3)[40 P]");
        System.out.println("Wallet: " + character.coin);
        int buy = input.nextInt();
        if(buy==1 && character.coin>=15){
            c1.effect=c1.damage-1;
            c2.effect=c2.damage-1;
            c3.effect=c3.damage-1;
            c4.effect=c4.damage-1;
            System.out.println("Light armor bought. Blocking Power (+1)");
            character.coin-=15;
        }
        else if(buy==2 && character.coin>=25){
            c1.effect=c1.damage-3;
            c2.effect=c2.damage-3;
            c3.effect=c3.damage-3;
            if(c4.damage-3>=0){
                c4.effect=c4.damage-3;
            }
            else{
                c4.effect=0;
            }
            System.out.println("Mid armor bought. Blocking Power (+3)");
            character.coin-=25;
        }
        else if(buy==3 && character.coin>=40){
            c1.effect=0;
            c2.effect=0;
            c3.effect=c3.damage-5;
            if(c4.damage-5>=0){
                c4.effect=c4.damage-5;
            }
            else{
                c4.effect=0;
            }
            System.out.println("Heavy armor bought. Blocking Power (+5)");
            character.coin-=40;
        }
        else{
            System.out.println("You didn't buy any armor!");
        }
    }
}
