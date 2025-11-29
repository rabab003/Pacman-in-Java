import javax.swing.JFrame;

public class App {
    public static void main(String[] args) throws Exception {
        int rowCOunt = 21;
        int columnCOunt = 19 ;
        int tileSize = 32;
        int boardWidth = columnCOunt * tileSize;
        int boardHeight = rowCOunt * tileSize;

        JFrame frame = new JFrame("Pac Man");
        frame.setVisible(true);
        frame.setSize(boardWidth,boardHeight);
        frame.setLocationRelativeTo(null);
        frame.setResizable(false);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

    }
}
