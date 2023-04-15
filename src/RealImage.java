import java.awt.*;
import java.io.File;
import java.io.IOException;

import static javax.imageio.ImageIO.read;

public class RealImage implements myImage{

    Image image;
    RealImage(String path){
        try {
            this.image=read(new File(path));
        } catch (IOException e){
            System.out.println(e);
        }
    }

    @Override
    public void draw(Graphics g, int x, int y, int width, int height) {
        g.drawImage(image, x, y, width, height, null);
    }
}
