import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.Objects;
import javax.imageio.ImageIO;
import javax.swing.*;

class RealImage extends JPanel implements Image {
    private String fileName;
    int x,y,width,height;
    private BufferedImage image = null;

    public RealImage(String fileName) {
        this.fileName = fileName;
        try {
            System.out.println("Loading image");
            image = ImageIO.read(Objects.requireNonNull(getClass().getResourceAsStream(this.fileName)));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    @Override
    public int[] getDimensions() {
        return new int[]{this.image.getWidth(), this.image.getHeight()};
    }

    @Override
    public void draw(int x, int y) {
        this.x=x;
        this.y=y;
        repaint();
        System.out.println("Drawing image");
    }

    public void paint(Graphics g) {
        int[]dims = getDimensions();
        System.out.println("paint");
        g.drawImage(this.image, this.x, this.y, dims[0], dims[1], null);
    }
}