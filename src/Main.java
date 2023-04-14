import javax.swing.*;

import java.awt.*;
import java.io.File;
import java.io.IOException;

import static javax.imageio.ImageIO.read;

public class Main {
    public static void main(String[] args) throws IOException {
        JFrame frame = new JFrame("Movable Box");
        MovableBox box = new MovableBox(350, 250, 300, 300, new ProxyImage("/home/artempas/IdeaProjects/Patterns/image.jpeg"));
        frame.add(box);
        frame.setSize(1500, 1000);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setVisible(true);

    }

}
