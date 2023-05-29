import java.awt.*;
import java.util.Random;
import javax.swing.JComponent;
import javax.swing.JFrame;

public class Sorting extends JComponent {
    int[] arr;
    int max;

    public Sorting(int max) {
        this.max = max;
        Random r = new Random();
        arr = new int[max];
        for (int i = 0; i < max; i++) {
            arr[i] = r.nextInt(900);
        }
    }

    public void getDataAndVisualizeIt() throws InterruptedException {
        // Perform insertion sort and visualize the sorting process
        int n = arr.length;
        for (int j = 1; j < n; j++) {
            for (int i = j; i >= 1; i--) {
                if (arr[i - 1] > arr[i]) {
                    int tmp = arr[i - 1];
                    arr[i - 1] = arr[i];
                    arr[i] = tmp;
                    this.repaint();
                    // Pause for a short duration to visualize each step of the sorting process
                    java.util.concurrent.TimeUnit.MILLISECONDS.sleep(1);
                }
            }
        }
    }

    public void paintComponent(Graphics pGraphics) {
        // Draw the sorted array as a bar graph
        super.paintComponent(pGraphics);
        Color lForegroundColor = new Color(0, 0, 0);
        pGraphics.setColor(lForegroundColor);
        pGraphics.setFont(new Font("SansSerif", Font.BOLD, 20));
        pGraphics.drawString("Insertion Sort", 500, 920);
        for (int i = 0; i < max; i++) {
            pGraphics.fillRect(i * 5, 900, 2, -arr[i]);
        }
    }

    public static void main(String[] args) throws InterruptedException {
        Sorting theMainJComponent = new Sorting(200);

        JFrame aJFrame = new JFrame();
        aJFrame.add(theMainJComponent);
        aJFrame.setSize(1050, 1000);
        aJFrame.setVisible(true);
        aJFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        theMainJComponent.getDataAndVisualizeIt();
    }
}