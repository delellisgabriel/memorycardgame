
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

  int boardWidth = columns * cardWidth;
  int boardheight = rows * cardHeight;

  JFrame frame = new JFrame("Pokemon Match Cards");
  JLabel textLabel = new JLabel();
  JPanel textPanel = new JPanel();
  JPanel boardPanel = new JPanel();

  int errorCount = 0;
  ArrayList<JButton> board;

  MatchCards() {
    setupCards();
    shuffleCards();

    // frame.setVisible(true);
    frame.setSize(boardWidth, boardheight);
    frame.setLocationRelativeTo(null);
    frame.setResizable(false);
    frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

    textLabel.setFont(new Font("Arial", Font.PLAIN, 20));
    textLabel.setHorizontalAlignment(JLabel.CENTER);
    textLabel.setText("Errors " + Integer.toString(errorCount));

    textPanel.setPreferredSize(new Dimension(boardWidth, 30));
    textPanel.add(textLabel);
    frame.add(textPanel, BorderLayout.NORTH);

    // card game board
    board = new ArrayList<>();
    boardPanel.setLayout(new GridLayout(rows, columns));
    for (int i = 0; i < cardSet.size(); i++) {
      JButton tile = new JButton();
      tile.setPreferredSize(new Dimension(cardWidth, cardHeight));
      tile.setOpaque(true);
      tile.setIcon(cardSet.get(i).cardImageIcon);
      tile.setFocusable(false);
      board.add(tile);
      boardPanel.add(tile);
    }
    frame.add(boardPanel);

    frame.pack();
    frame.setVisible(true);
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