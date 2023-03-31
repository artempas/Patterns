import javax.swing.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class main {
    public static void main(String[] args) {
        ImageProxy image = new ImageProxy("image.jpeg");
        JFrame frame = new JFrame();
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        int[] dims = {500, 600};
        frame.setSize(dims[0]+100, dims[1]+100);
        frame.setResizable(false);
        frame.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                frame.add(image.getComponent());
                image.draw(0,0);
            }
        });
        frame.setVisible(true);
    }

}
