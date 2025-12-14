import java.awt.*;
import java.awt.event.*;
import java.util.HashSet;
import java.util.Random;
import javax.swing.*;

public class PacMan extends JPanel {

   class BLock {
      int x;
      int y;
      int width;
      int height;
      Image image;

      int startX;
      int startY;

      Block(Image image, int x, int y, int width, int height){
         this.image = image;
         this.x = x;
         this.y = y;
         this.width = width;
         this.height= height;
         this.startX = x;
         this.startY = y;

         
      }

   }

   private int rowCOunt = 21;
   private int columnCOunt = 19;
   private int tileSize = 32;
   private int boardWidth = columnCOunt * tileSize;
   private int boardHeight = rowCOunt * tileSize;

   private Image wallImage;
   private Image blueGhost;
   private Image orangeGhost;
   private Image pinkGhost;
   private Image redGhost;

   private Image pacmanUp;
   private Image pacmanDown;
   private Image pacmanRight;
   private Image pacmanLeft;

   // X = wall, O = skip, P = pac man, ' ' = food
   // Ghosts: b = blue, o = orange, p = pink, r = red
   private String[] tileMap = {
         "XXXXXXXXXXXXXXXXXXX",
         "X        X        X",
         "X XX XXX X XXX XX X",
         "X                 X",
         "X XX X XXXXX X XX X",
         "X    X       X    X",
         "XXXX XXXX XXXX XXXX",
         "OOOX X       X XOOO",
         "XXXX X XXrXX X XXXX",
         "O       bpo       O",
         "XXXX X XXXXX X XXXX",
         "OOOX X       X XOOO",
         "XXXX X XXXXX X XXXX",
         "X        X        X",
         "X XX XXX X XXX XX X",
         "X  X    XPX    X  X",
         "XX X X XXXXX X X XX",
         "X    X   X   X    X",
         "X XXXXXX X XXXXXX X",
         "X                 X",
         "XXXXXXXXXXXXXXXXXXX"
   };

   HashSet<Block> walls;
   HashSet<Block> foods;
   HashSet<Block> ghosts;
   Block pacman;

   PacMan() {
      setPreferredSize(new Dimension(boardWidth, boardHeight));
      setBackground(Color.BLACK);

      // load images
      wallImage = new ImageIcon(getClass().getResource("./wall.png")).getImage();
      blueGhost = new ImageIcon(getClass().getResource("./blue_ghost.png")).getImage();
      orangeGhost = new ImageIcon(getClass().getResource("./orange_ghost.png")).getImage();
      pinkGhost = new ImageIcon(getClass().getResource("./pink_ghost.png")).getImage();
      redGhost = new ImageIcon(getClass().getResource("./red_ghost")).getImage();

      pacmanDown = new ImageIcon(getClass().getResource("./pacmanDown.png")).getImage();
      pacmanUp = new ImageIcon(getClass().getResource("./pacmanUp.png")).getImage();
      pacmanRight = new ImageIcon(getClass().getResource("./pacmanRight.png")).getImage();
      pacmanLeft = new ImageIcon(getClass().getResource("./pacmanLeft.png")).getImage();
   

      loadMap();
   
   }

   public void loadMap() {
      walls = new HashSet<Block>();
      foods = new HashSet<Block>();
      ghosts = new HashSet<Block>();

      for (int r = 0; r < rowCOunt; r++) {
         for (int c = 0; c < columnCOunt; c++) {
            String row = tileMap[r];
            char tileMapChar = row.charAt(c);

            int x = c * tileSize;
            int y = r * tileSize;

            if (tileMapChar == "x") { // block wall
               Block wall = new BLock(wallImage, x, y, tileSize, tileSize);
            } else if (tileMapChar == "b") { // blue ghost
               Block ghost = new Block(blueGhost, x, y, tileSize, tileSize);
               ghosts.add(ghost);

            } else if (tileMapChar == "o") { // orange ghost
               Block ghost = new Block(orangeGhost, x, y, tileSize, tileSize);
               ghosts.add(ghost);

            } else if (tileMapChar == 'p') { // pink ghost
               Block ghost = new Block(pinkGhostImage, x, y, tileSize, tileSize);
               ghosts.add(ghost);

            } else if (tileMapChar == 'r') { // red ghost
               Block ghost = new Block(redGhostImage, x, y, tileSize, tileSize);
               ghosts.add(ghost);
            } else if (tileMapChar == 'P') { // pacman
               pacman = new Block(pacmanRightImage, x, y, tileSize, tileSize);
            }
            else if (tileMapChar == ' ') { // food
               Block food = new Block(null, x + 14, y + 14, 4, 4);
               foods.add(food);
            }

         }
      }
   }

   public void paintComponent(Graphics g){
      super.paintComponent(g);
      draw(g);
   }

   public void draw(Graphics g){
      g.drawImage( pacman.image , pacman.x, pacman.y , pacman.height, null );
   }

   public void draw(Graphics g){
      g.drawImage(ghosts.image , ghost.x, ghost.y , ghost.width , ghost.height, null);

      for(Block ghost : ghosts){
         g.drawImage(ghost.image, ghost.x, ghost.y, ghost.width, ghost.height, null);
      }

      for(Block wall : walls){
         g.drawImage(wall.image, wall.x, wall.y, wall.width, wall.height, null);
      }

      for(Color.WHITE){
         for(Block food : foods){
            g.fillRect(food.x, food.y, food.width, food.height);
         }
      }      
      
   }

}


//31:50