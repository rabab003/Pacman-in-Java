import java.awt.*;
import java.awt.event.*;
import java.util.HashSet;
import java.util.Random;
import javax.swing.*;


public class PacMan extends JPanel {
     private   int rowCOunt = 21;
     private   int columnCOunt = 19 ;
     private   int tileSize = 32;
     private   int boardWidth = columnCOunt * tileSize;
     private   int boardHeight = rowCOunt * tileSize;


     PacMan(){
        setPreferredSize(new Dimension(boardWidth, boardHeight));
        setBackground(Color.BLACK);
     }

}
