package galamadriabuyak;

import java.util.Stack;
import java.lang.Math;

public class Deck implements IDeck {
    
    // ATTRIBUTES
    
    private int size;
    private Stack<ICard> deck;
    
    // CONSTRUCTORS
    
    public Deck() {
        size = 0;
        deck = new Stack<>();
    }
    
    // REQUESTS
    
    public int getSize() {
        return size;
    }
    
    // COMMANDS
    
    public void addCard(ICard c) {
        if (c == null) {
            throw new AssertionError();
        }
        
        deck.push(c);
        size += 1;
    }
    
    public void rmTopCard() {
        if (getSize() <= 0) {
            throw new AssertionError();
        }
        
        deck.pop();
        size -= 1;
    }
    
    public void drawCard(IHand hand) {
        if (hand == null || getSize() <= 0
            || hand.getSize() >= IHand.MAX_SIZE) {
                throw new AssertionError();
            }
            
        hand.addCard(deck.pop());
        size -= 1;
    }
    
    public void shuffleDeck() {
        if (size < 0) {
            throw new AssertionError();
        }
        int random_factor = 7;
        Stack<ICard>[] bufStack = new Stack[random_factor];
        
        //Initializing stacks.
        for (int i = 0; i < random_factor; ++i) {
            bufStack[i] = new Stack<>();
        }
        
        //  Splitting the deck in random_factor stacks
        //  Card by card we randomly choose one of the stack and 
        //  pushing in the card.
        while (!deck.empty()) {
            bufStack[alea(0, random_factor - 1)].push(deck.pop());
        }
        
        //  Assembling all the stacks in one deck.
        for (int i = 0; i < random_factor; ++i) {
            while (!bufStack[i].empty()) {
                deck.push(bufStack[i].pop());
            }
        }
    }

    public void randomFill(int n, final ICard[] possibleCards) {
        if (n <= 0 || n > MAX_SIZE - getSize()) {
            throw new AssertionError();
        }
        if (possibleCards == null || possibleCards.length == 0) {
            throw new AssertionError();
        }

        for (int i = 0; i < n; i++) {
            addCard(possibleCards[alea(0, possibleCards.length - 1)]);
        }
    }

    // TOOLS
    
    /**
     * Returns a random number between a and b inclusive.
     * @pre
     *     0 <= a <= b
     * @post
     *     a <= result <= b
     */
    private static int alea(int a, int b) {
        assert (a >= 0) && (b >= a);
        return a + (int) (Math.random() * (b - a + 1));
    }
}
