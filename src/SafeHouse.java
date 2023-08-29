public class SafeHouse {
    Character character;
    int health;

    SafeHouse(Character character){
        this.character=character;
    }
    public void healthFill(){
        if(character.ID==1) health=21;
        if(character.ID==2) health=18;
        if(character.ID==3) health=24;
    }
}
