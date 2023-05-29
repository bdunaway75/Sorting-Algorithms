
import java.awt.*;


// explicit import of every Java class we use from the Swing package:
import javax.swing.JComponent;
import javax.swing.JFrame;

public class View extends JComponent {
    JFrame aJFrame;
    int[][] arr;
    int rows;
    int cols;

    public View(){
        aJFrame = new JFrame();
        aJFrame.add(this);
        aJFrame.setSize(1920, 1080);
        aJFrame.setVisible( true );
        aJFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }

    public void getDataAndVisualizeIt(int[][]arr, int rows, int cols) {
        this.arr = arr;
        this.rows = rows;
        this.cols = cols;
        this.repaint();
    }
    public void paintComponent(Graphics pGraphics) {
        System.out.println("here is paintComponent()");
        super.paintComponent(pGraphics);

        for(int i = 0; i < cols ; i++){
            for(int j = 0; j < rows; j++) {
                if(arr[i][j] < 0){
                    pGraphics.setColor(new Color(- arr[i][j], 0, 0));
                }
                else if(arr[i][j] > 0){
                    pGraphics.setColor(new Color(0,  arr[i][j], 0));
                }
                else {
                    pGraphics.setColor(new Color(0,  0, 0));
                }

                pGraphics.fillRect(j, i , 1, 1);

            }
        }
    } // end of paintComponent()
}