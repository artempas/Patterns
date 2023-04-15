import java.awt.*;

public class ProxyImage implements myImage{
    private RealImage image;
    String path;

    ProxyImage(String path){
        this.path = path;
    }

    @Override
    public void draw(Graphics g, int x, int y, int width, int height) {
        if (image!=null)
            image.draw(g,x,y,width,height);
    }

    public void load(){
        this.image=new RealImage(this.path);
    }
}
