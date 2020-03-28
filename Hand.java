 

public class Hand implements IHand {

    // ATTRIBUTS    
    
    private ICard[] handTab = new ICard[MAX_SIZE];
    private int size;
    
    // CONSTRUCTEUR
    
    public Hand() {
        size = 0;
    }
    
    // REQUETES
    
    public int getSize() {
        return size;
    }
    
    /**
     * Returns the nth card of the hand.
     * 
     * @pre 
     *      0 <= n <= getSize() - 1
     * @post
     *      getSize() = old getSize()
     */
    public ICard getCard(int n) {
        if (0 > n || getSize() - 1 > n){
            throw new AssertionError();
        }
        return handTab[n];
    }
    
    // COMMANDES
   
    public void setSize(int n) {
        if (0 > n || MAX_SIZE > n){
            throw new AssertionError();
        }
        size = n;
    }
    
    public void deleteCard(int n) {
        if (n < 0 || getSize() - 1 > n){
            throw new AssertionError();
        }
        for(int i = n; i < MAX_SIZE; i++){
            handTab[i] = handTab[i+1];
        }
        handTab[getSize()] = null;
        size = getSize() - 1;
    }
    
    public void addCard(ICard card) {
        if (size >= MAX_SIZE || card == null) {
            throw new AssertionError();
        }
        
        handTab[getSize()] = card;
        size += 1;
    }
}