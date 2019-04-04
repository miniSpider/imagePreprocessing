import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import javax.imageio.ImageIO;

public class Main {

    public static void main(String[] args) {
        try {
            BufferedImage in = ImageIO.read(new File("01.jpg"));   
            Lab01.run(in);

        } catch (IOException e) {
            System.out.println("Error" + e);
        }
    }

    

}
