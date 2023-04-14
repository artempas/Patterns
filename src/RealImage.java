import java.awt.*;
import java.io.File;
import java.io.IOException;

import static javax.imageio.ImageIO.read;

public class RealImage implements myImage{
    private final String path;

    RealImage(String path){
        this.path=path;
    }
    public Image load() {
        try {
            return read(new File("/home/artempas/IdeaProjects/Patterns/image.jpeg"));
        } catch (IOException e){
            System.out.println(e);
            return null;
        }
    }
}
