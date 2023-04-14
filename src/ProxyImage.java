import java.awt.*;

public class ProxyImage implements myImage{
    private Image loaded=null;
    RealImage realImage;
    ProxyImage(String path){
        realImage= new RealImage(path);
    }

    @Override
    public Image load() {
        if (loaded==null)
            loaded = realImage.load();
        return loaded;
    }
}
