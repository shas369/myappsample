class Card {
     
       public static final int SPADE   = 4;
       public static final int HEART   = 3;
       public static final int CLUB    = 2;
       public static final int DIAMOND = 1;
 
       private static final String[] Suit = {"*", "Hearts", "Clubs", "Spades", "Diamonds"};
       private static final String[] Rank = {"*", "*", "Ace", "2", "3", "4", "5", "6", "7", "8", "9", "10", "Jack", "Queen", "King"};    
 
       private int cardSuit;
       private int cardRank;
 
       public Card( int suit, int rank ) {
          if ( rank == 1 )
             cardRank = 14;     // Give Ace the rank 14
          else
             cardRank = (int) rank;
 
          cardSuit = (int) suit;
       }
 
       public int suit() {
          return ( this.cardSuit );     
       }
 
       public String suitStr() {
          return( this.Suit[ this.cardSuit ] );  
       }
 
       public int rank() {
          return ( this.cardRank );
       }
 
       public String rankStr() {
          return ( Rank[ this.cardRank ] );
       }
 
       public String toString() {
          return ( Rank[ this.cardRank ] + " of "+ Suit[ this.cardSuit ] );
       }
    }

class DeckOfCards {
       public static final int NEWCARDS = 52;
       private Card[] deckOfCards;         // Contains all 52 cards
       private int currentCard;            // deal THIS card in deck
 
       public DeckOfCards( ) {
          deckOfCards = new Card[ NEWCARDS ];
          int i = 0;
 
          for (int suit = Card.DIAMOND; suit <= Card.SPADE; suit++)
             for ( int rank = 1; rank <= 13; rank++ )
                 deckOfCards[i++] = new Card(suit, rank);
                 currentCard = 0;
       }
      //shuffle(n): shuffle the deck
       public void shuffle(int n) {
          int i, j, k;
 
          for ( k = 0; k < n; k++ ){ 
          i = (int) ( NEWCARDS * Math.random() );  // Pick 2 random cards
          j = (int) ( NEWCARDS * Math.random() );  // in the deck
           
          //swap these randomly picked cards
          Card temp = deckOfCards[i];
          deckOfCards[i] = deckOfCards[j];
          deckOfCards[j] = temp;
          }
          currentCard = 0;   // Reset current card to deal
       }
        
       //deal(): deal deckOfCards[currentCard] out
       public Card deal() {
           
          if (currentCard < NEWCARDS) {
             return ( deckOfCards[currentCard++] );
          }
          else{
             System.out.println("Out of cards error");
             return ( null );  // Error;
          }
       }
 
       public String toString() {
          String s = "";
          int k;
          k = 0;
           
          for ( int i = 0; i < 4; i++ ) {        
              for ( int j = 1; j <= 13; j++ )
                 s += (deckOfCards[k++] + " ");
                 s += "\n";
         }
          return (s);
       }
    }
public class CardGame {
    public static void main (String [] args) { 
         
        DeckOfCards deck = new DeckOfCards();
        //call shuffle
        deck.shuffle(1000);
        
         Card b;
        
         b = deck.deal();
         System.out.println("Deal a card: " + b);
        
    }
}  