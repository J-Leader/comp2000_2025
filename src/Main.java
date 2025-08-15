import java.awt.Dimension;
import java.awt.Graphics;

import javax.swing.JFrame;
import javax.swing.JPanel;

public class Main extends JFrame {
    public static void main(String[] args) throws Exception {
      Main window = new Main();
      window.run();
    }

    class Canvas extends JPanel { // Canvas Class
      public Canvas() { // Constructor
        setPreferredSize(new Dimension(720, 720));
      }

     

    @Override
    public void paint(Graphics g) {
	  Cell initialCell = new Cell(35, 35, 10, 10);
    Grid Grid = new Grid(20, 20, initialCell);
        Grid.paint(g);

      }
    }

 class Cell{ // Cell Class for rectangles
        public Cell(int width, int height, int xPos, int yPos)//Constructor
        {
          cellWidth = width;
          cellHeight = height;
          cellXPos = xPos;
          cellYPos = yPos;

        }
        int cellWidth;
        int cellHeight;
        int cellXPos;
        int cellYPos;

        public void paint(Graphics g){
          g.setColor(java.awt.Color.BLACK);
          g.drawRect(cellXPos, cellYPos, cellWidth, cellHeight);
        }

      }

class Grid{ //Grid Class
        public Grid(int rows, int columns, Cell cell) //Constructor, takes amount of rows and columns and what kind of cells it should be using.
        {
          gridNumRows = rows;
          gridNumColumns = columns;
          gridCellTemplate = cell;
        }
        int gridNumRows;
        int gridNumColumns;
        Cell gridCellTemplate;
        Cell gridCell;

        int offset = 10;

        public void paint(Graphics g)
        {
          g.setColor(java.awt.Color.BLACK);
          for(int x =0;x < gridNumRows;x++){
          for(int y =0; y<gridNumColumns; y++){
            gridCell = new Cell(gridCellTemplate.cellWidth, gridCellTemplate.cellHeight,  offset + x*gridCellTemplate.cellWidth,  offset + y*gridCellTemplate.cellHeight);
            gridCell.paint(g);
          }


        }
        }


      }


    private Main() {
      this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
      Canvas canvas = new Canvas();
      this.setContentPane(canvas);
      this.pack();
      this.setVisible(true);
    }

    public void run() {
      while(true){
        repaint();
      }
    }


}
