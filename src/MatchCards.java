
import java.awt.*;
import java.util.ArrayList;
import javax.swing.*;

public class MatchCards {
  class Card {
    String cardName;
    ImageIcon cardImageIcon;

    Card(String cardName, ImageIcon cardImageIcon) {
      this.cardName = cardName;
      this.cardImageIcon = cardImageIcon;
    }

    @Override
    public String toString() {
      return cardName;
    }
  }

  String[] cardList = {
      "darkness",
      "double",
      "fairy",
      "fighting",
      "fire",
      "grass",
      "lightning",
      "metal",
      "psychic",
      "water"
  };

  int rows = 4;
  int columns = 5;
  int cardWidth = 90;
  int cardHeight = 128;

  ArrayList<Card> cardSet;
  ImageIcon cardBackImageIcon;

  MatchCards() {
    setupCards();
    shuffleCards();
  }

  void setupCards() {
    cardSet = new ArrayList<>();
    for (String cardName : cardList) {
      // load each card image
      Image cardImg = new ImageIcon(getClass().getResource("./img/" + cardName + ".jpg")).getImage();
      ImageIcon cardImageIcon = new ImageIcon(
          cardImg.getScaledInstance(cardWidth, cardHeight, java.awt.Image.SCALE_SMOOTH));

      // create card object and add to cardSet
      Card card = new Card(cardName, cardImageIcon);
      cardSet.add(card);
    }
    cardSet.addAll(cardSet);

    // load the back card image
    Image cardBackImg = new ImageIcon(getClass().getResource("./img/back.jpg")).getImage();
    cardBackImageIcon = new ImageIcon(
        cardBackImg.getScaledInstance(cardWidth, cardHeight, java.awt.Image.SCALE_SMOOTH));
  }

  void shuffleCards() {
    System.out.println(cardSet);
    // shuffle
    for (int i = 0; i < cardSet.size(); i++) {
      int j = (int) (Math.random() * cardSet.size()); // get random index
      // swap
      Card temp = cardSet.get(i);
      cardSet.set(i, cardSet.get(j));
      cardSet.set(j, temp);
    }
    System.out.println(cardSet);
  }
}