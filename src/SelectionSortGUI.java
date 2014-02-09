import javax.swing.*;
import java.awt.*;
import java.awt.geom.Rectangle2D;
import java.util.concurrent.locks.*;
import java.util.Random;


public class SelectionSortGUI extends JComponent
{
    private SelectionSorter sorter;

    public SelectionSortGUI()
    {
        int[] values = randomIntArray(30, 300);
        sorter = new SelectionSorter(values, this);
    }

    private int[] randomIntArray(int size, int maxVal)
    {
        int[] arr = new int[size];
        Random rand = new Random();
        for(int i=0; i<size; i++)
        {
            arr[i] = rand.nextInt(maxVal);
            System.out.println(arr[i]);
        }
        return arr;
    }

    public void paintComponent(Graphics g)
    {
        Graphics2D g2 = (Graphics2D) g;
        sorter.draw(g2);
    }

    public void startAnimation()
    {
        class AnimationRunnable implements Runnable
        {
            public void run()
            {
                try
                {
                    sorter.sort();
                }
                catch(InterruptedException exception)
                {
                    System.out.println("Interrupted.");
                }
            }
        }
        Runnable r = new AnimationRunnable();
        Thread t = new Thread(r);
        t.start();
    }


    // Inner class to do the actual sorting
    private class SelectionSorter
    {
        private int[] arr;
        private JComponent comp;
        private Lock sortStateLock;
        private int markedPosition = -1;
        private int alreadySorted = -1;
        private static final int DELAY = 100;

        
        public SelectionSorter(int[] array, JComponent pComp)
        {
            arr = array;
            sortStateLock = new ReentrantLock();
            comp = pComp;
        }

        public void sort() throws InterruptedException
        {
            for(int i=0; i<arr.length -1; i++)
            {
                int minPos = minimumPosition(i);
                sortStateLock.lock();
                try
                {
                    swap(minPos, i);
                    alreadySorted = i;
                }
                finally
                {
                    sortStateLock.unlock();
                }
                pause(2);
            }   
        }

        private int minimumPosition(int from) throws InterruptedException
        {
            int minPos = from;
            for(int i=from+1; i<arr.length; i++)
            {
                sortStateLock.lock();
                try
                {
                    if(arr[i] < arr[minPos])
                    {
                        minPos = i;
                    }
                    markedPosition = i;
                }
                finally
                {
                    sortStateLock.unlock();
                }
                pause(2);
            }
            return minPos;
        }

        private void swap(int i, int j)
        {
            int temp = arr[i];
            arr[i] = arr[j];
            arr[j] = temp;
        }

        public void draw(Graphics2D g2)
        {
            sortStateLock.lock();
            try
            {
                int deltaX = comp.getWidth() / arr.length;
                for(int i=0; i<arr.length; i++)
                {
                    if(i == markedPosition)
                    {
                        g2.setColor(Color.RED);
                    }
                    else if(i <= alreadySorted)
                    {
                        g2.setColor(Color.CYAN);
                    }
                    else
                    {
                        g2.setColor(Color.BLACK);
                    }
                    g2.draw(new Rectangle2D.Double(i*deltaX, 0, 2, arr[i]));
                }
            }
            finally
            {
                sortStateLock.unlock();
            }
        }

        public void pause(int steps) throws InterruptedException
        {
            comp.repaint();
            Thread.sleep(steps * DELAY);
        }



    }

    public static void main(String args[])
    {
        JFrame frame = new JFrame();
        frame.setSize(300, 400);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setTitle("Selection Sort");

        SelectionSortGUI comp = new SelectionSortGUI();
        frame.add(comp, BorderLayout.CENTER);

        frame.setVisible(true);
        comp.startAnimation();
    }
}
