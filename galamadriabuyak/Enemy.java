package galamadriabuyak;

public class Enemy extends Character implements IEnemy {
    
    // Constructor
    
    public Enemy() {
        super();
    }
    
    // COMMANDS
    
    public void performTurn(Game game){
        for (int i = alea(0,2) ; i < this.getHand().getSize() ; i++){
            this.getHand().getCard(i).applyEffects(game);
        }
    }
    
    // Outils
    
    /**
     * Return a random number in range of [min, max] 
     */
    private int alea(int min,int max) {
        return min + (int) (Math.random() * (max - min + 1));
    }  
}