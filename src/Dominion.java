import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

class Card {
  String name;

  Card(String name) {
    this.name = name;
  }

  void play() {
    System.out.println("Playing " + name);
  }
}

class DominionGame {
  List<Card> deck;
  List<Card> hand;

  DominionGame(List<Card> initialDeck) {
    deck = new ArrayList<>(initialDeck);
    hand = new ArrayList<>();
    shuffleDeck();
    drawInitialHand();
  }

  void shuffleDeck() {
    Collections.shuffle(deck);
  }

  void drawInitialHand() {
    for (int i = 0; i < 5; i++) {
      drawCard();
    }
  }

  void drawCard() {
    if (!deck.isEmpty()) {
      Card drawnCard = deck.remove(0);
      hand.add(drawnCard);
    }
  }

  void playCard(int index) {
    if (index >= 0 && index < hand.size()) {
      Card playedCard = hand.remove(index);
      playedCard.play();
    }
  }

  void printHand() {
    System.out.println("Current Hand:");
    for (int i = 0; i < hand.size(); i++) {
      System.out.println(i + ": " + hand.get(i).name);
    }
    System.out.println();
  }
}

public class Dominion {
  public static void main(String[] args) {
    List<Card> initialDeck = new ArrayList<>();
    initialDeck.add(new Card("Copper"));
    initialDeck.add(new Card("Silver"));
    initialDeck.add(new Card("Gold"));

    DominionGame game = new DominionGame(initialDeck);

    game.printHand();
    game.playCard(0);

    game.drawCard();
    game.printHand();
  }
}
