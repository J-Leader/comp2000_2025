import java.awt.Dimension;
import java.awt.Graphics;

import javax.swing.JFrame;
import javax.swing.JPanel;

public class Main extends JFrame {
    public static void main(String[] args) throws Exception {
      Main window = new Main();
      window.run();
    }

    class Canvas extends JPanel {
      public Canvas() {
        setPreferredSize(new Dimension(720, 720));
      }

      @Override
    public void paint(Graphics g) {
      int gridDimensions = 35;

	  g.setColor(java.awt.Color.BLACK);
	  g.drawRect(10, 10, 700, 700);
        for(int x = 10; x<710; x+=gridDimensions){
          for(int y =10; y<710; y+=gridDimensions){
            g.drawRect(x, y, gridDimensions, gridDimensions);
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
