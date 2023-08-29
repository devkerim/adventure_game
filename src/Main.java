import java.util.Random;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws Exception {

        Character Samurai = new Character (1,5,21,15, "Samurai", 5);
        Character Archer = new Character (2,7,18,20, "Archer", 7);
        Character Knight = new Character (3,8,24,5, "Knight", 8);
        Character Gamer = new Character(0, 0, 0, 0, "Gamer", 0);

        Monster Zombie = new Monster (1,3,10,4, "Zombie", 3);
        Monster Vampire = new Monster (2,4,14,7, "Vampire", 4);
        Monster Bear = new Monster (3,7,20,12, "Bear", 7);
        Monster Snake = new Monster (4, Monster.damageDraw(), 12, 0, "Snake", 6);

        Place Cave = new Place ("Cave", Zombie, false);
        Place Jungle = new Place ("Jungle", Vampire, false);
        Place River = new Place ("River", Bear, false);
        Place Mine = new Place ("Mine", Snake, false);
        Place Battle = new Place ("Battle", Zombie, false);

        Store store = new Store();

        System.out.println("Select a Character:");
        System.out.println("-----------------");
        System.out.println("Samurai (1), Archer (2), Knight (3)");
        Scanner input = new Scanner(System.in);
        int selectedChar = input.nextInt();
        if(selectedChar==1) Gamer=Samurai;
        if(selectedChar==2) Gamer=Archer;
        if(selectedChar==3) Gamer=Knight;

        while(Gamer.health>0){
            System.out.println("Select the place you want to go:");
            System.out.println("--------------------------------");
            System.out.println("Cave (1), Jungle (2), River (3), Mine (4), Store (5), Safe House (6)");
            int selectedPlace = input.nextInt();
            if(selectedPlace==1) {
                Battle=Cave;
                if(Cave.item){
                    System.out.println("=========");
                    System.out.println("Item was earned from this section before.");
                    System.out.println("Complete other sections.");
                    System.out.println("=========");
                    continue;
                }
                int number = Battle.monsterNumber();
                System.out.println(number + " Zombie appeared, Fight (1) or Escape (2)");
                int fightOrEscape=input.nextInt();
                if(fightOrEscape==2) {
                    continue;
                }
                for(int i=1;i<=number;i++){
                    if(Gamer.health>0){
                        Battle.battleTrophy(Gamer, i, Zombie);
                    }
                    else{
                        break;
                    }
                    if(Gamer.health>0) {
                        Gamer.coin+=4;
                        System.out.println("You earned 4 coin.");
                        System.out.println("Total coin: " + Gamer.coin);
                        System.out.println("=========");
                    }
                }
                if(Gamer.health>0){
                    Cave.item=true;
                    System.out.println("Item earned.");
                }

                if(isWin(Cave, Jungle, River, Mine)){
                    break;
                }
            }
            else if(selectedPlace==2) {
                Battle=Jungle;
                if(Jungle.item){
                    System.out.println("=========");
                    System.out.println("Item was earned from this section before.");
                    System.out.println("Complete other sections.");
                    System.out.println("=========");
                    continue;
                }
                int number = Battle.monsterNumber();
                System.out.println(number + " Vampire appeared, Fight (1) or Escape (2)");
                int fightOrEscape=input.nextInt();
                if(fightOrEscape==2) {
                    continue;
                }
                for(int i=1;i<=number;i++){
                    if(Gamer.health>0){
                        Battle.battleTrophy(Gamer, i, Vampire);
                    }
                    else{
                        break;
                    }
                    if(Gamer.health>0) {
                        Gamer.coin+=7;
                        System.out.println("You earned 7 coin.");
                        System.out.println("Total coin: " + Gamer.coin);
                        System.out.println("=========");
                    }
                }
                if(Gamer.health>0){
                    Jungle.item=true;
                    System.out.println("Item earned.");
                }
                if(isWin(Cave, Jungle, River, Mine)){
                    break;
                }
            }
            else if(selectedPlace==3) {
                Battle=River;
                if(River.item){
                    System.out.println("=========");
                    System.out.println("Item was earned from this section before.");
                    System.out.println("Complete other sections.");
                    System.out.println("=========");
                    continue;
                }
                int number = Battle.monsterNumber();
                System.out.println(number + " Bear appeared, Fight (1) or Escape (2)");
                int fightOrEscape=input.nextInt();
                if(fightOrEscape==2) {
                    continue;
                }
                for(int i=1;i<=number;i++){
                    if(Gamer.health>0){
                        Battle.battleTrophy(Gamer, i, Bear);
                    }
                    else{
                        break;
                    }
                    if(Gamer.health>0) {
                        Gamer.coin+=12;
                        System.out.println("You earned 12 coin.");
                        System.out.println("Total coin: " + Gamer.coin);
                        System.out.println("=========");
                    }
                }
                if(Gamer.health>0){
                    River.item=true;
                    System.out.println("Item earned.");
                    System.out.println(" ");
                }
                if(isWin(Cave, Jungle, River, Mine)){
                    break;
                }
            }
            else if(selectedPlace==4){
                Battle=Mine;
                if(Battle.item){
                    System.out.println("=========");
                    System.out.println("Item was earned from this section before.");
                    System.out.println("Complete other sections.");
                    System.out.println("=========");
                    continue;
                }
                Random rand = new Random();
                int number = rand.nextInt(5)+1;
                System.out.println(number + " Snake appeared, Fight (1) or Escape (2)");
                int fightOrEscape=input.nextInt();
                if(fightOrEscape==2) {
                    continue;
                }
                for(int i=1;i<=number;i++){
                    if(Gamer.health>0){
                        Battle.battleTrophy(Gamer, i, Snake);
                    }
                    else{
                        break;
                    }
                    if(Gamer.health>0) {
                        Battle.snakeItemDraw(Gamer, Zombie, Vampire, Bear, Snake, Battle);
                        System.out.println("Total coin: " + Gamer.coin);
                        System.out.println("=========");
                    }
                }
                if(Gamer.health>0){
                    Mine.item=true;
                }
                if(isWin(Cave, Jungle, River, Mine)){
                    break;
                }
            }
            else if(selectedPlace==5){
                System.out.println("Which one do you want to buy? Weapon (1) / Armor (2)");
                int buy = input.nextInt();
                store.trade(Gamer, buy, Zombie, Vampire, Bear, Snake);
                System.out.println("Remaining coin: " + Gamer.coin);
            }
            else if(selectedPlace==6){
                Gamer.healthFill();
                System.out.println("Health filled. Health status: " + Gamer.health);
            }
            else {
                System.out.println("Please enter a valid option:");
            }
        }

        if(Gamer.health<=0) {
            System.out.println("============");
            System.out.println(":( :( YOU LOST THE GAME :( :(");
            System.out.println("============");
            System.out.println("FINAL SITUATION:");
            System.out.println("Player health: " + Gamer.health);
            System.out.println("Player wallet: " + Gamer.coin);
            input.close();
        }
        else {
            System.out.println("============");
            System.out.println("---### YOU WON THE GAME ###---");
            System.out.println("============");
            System.out.println("FINAL SITUATION:");
            System.out.println("Player health: " + Gamer.health);
            System.out.println("Player wallet: " + Gamer.coin);
            input.close();
        }
    }

    static boolean isWin(Place Cave, Place Jungle, Place River, Place Mine) {
        if(Cave.item==true && Jungle.item==true && River.item==true && Mine.item==true){
            return true;
        }else{
            System.out.println((Cave.item==true) ? "Cave item +++" : "Cave item ---");
            System.out.println((Jungle.item==true) ? "Jungle item +++" : "Jungle item ---");
            System.out.println((River.item==true) ? "River item +++" : "River item ---");
            System.out.println((Mine.item==true) ? "Mine item +++" : "Mine item ---");
            return false;
        }
    }
}