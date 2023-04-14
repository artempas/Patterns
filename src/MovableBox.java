import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class MovableBox extends JPanel implements MouseListener, MouseMotionListener {

    private int x, y, width, height, dist_from_0_x, dist_from_0_y;
    private boolean isDragging;
    private Image image;
    private myImage proxyImage;

    public MovableBox(int x, int y, int width, int height, myImage proxyImage) {
        this.x = x;
        this.y = y;
        this.width = width;
        this.height = height;
        this.proxyImage=proxyImage;
        addMouseListener(this);
        addMouseMotionListener(this);
    }


    public void paintComponent(Graphics g) {
        super.paintComponent(g);
        g.setColor(Color.RED);
        g.drawRect(x, y, width, height);
        if (image != null) {
            g.drawImage(image, x, y, width, height, null);
        }
    }

    public boolean containsPoint(int x, int y) {
        return (x >= this.x && x <= this.x + width && y >= this.y && y <= this.y + height);
    }

    public void mouseDragged(MouseEvent e) {
        if (isDragging) {
            x = e.getX()-dist_from_0_x;
            y = e.getY()-dist_from_0_y;
            repaint();
        }
    }

    public void mouseClicked(MouseEvent e) {
        if (e.getClickCount() == 2 && containsPoint(e.getX(), e.getY())) {
            image=proxyImage.load();
            repaint();
        }
    }

    public void mousePressed(MouseEvent e) {
        if (containsPoint(e.getX(), e.getY())) {
            isDragging = true;
            dist_from_0_x=e.getX()-x;
            dist_from_0_y=e.getY()-y;
        }
    }

    public void mouseReleased(MouseEvent e) {
        isDragging = false;
    }

    public void mouseEntered(MouseEvent e) {}

    public void mouseExited(MouseEvent e) {}

    public void mouseMoved(MouseEvent e) {}

}