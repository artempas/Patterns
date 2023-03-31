import java.awt.*;
import java.awt.image.BufferedImage;

class ImageProxy implements Image  {
    private String fileName;
    private RealImage realImage;

    public ImageProxy(String fileName) {
        this.fileName = fileName;
    }

    @Override
    public int[] getDimensions() {
        if (this.realImage==null){
            this.realImage = new RealImage(fileName);
        }
        return this.realImage.getDimensions();
    }

    public Component getComponent(){
        if (this.realImage==null){
            this.realImage = new RealImage(fileName);
        }
        return this.realImage;
    }

    @Override
    public void draw(int x, int y) {
        if (realImage == null) {
            realImage = new RealImage(fileName);
        }
        realImage.draw(x, y);
    }
}