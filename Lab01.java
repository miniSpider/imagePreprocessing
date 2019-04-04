import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import javax.imageio.ImageIO;

public class Lab01 {
    
    public static void run(BufferedImage in) {
        try {
            BufferedImage out = Lab01.negatyw(in);
            ImageIO.write(out,"jpg",new File("02.jpg"));
            out = Lab01.histnorm(in);
            ImageIO.write(out,"jpg",new File("01b.jpg"));
            out = Lab01.szarosciS(in);
            ImageIO.write(out,"jpg",new File("03.jpg"));
            out = Lab01.histnorm(out);
            ImageIO.write(out,"jpg",new File("03b.jpg"));
            out = Lab01.szarosciN(in);
            ImageIO.write(out,"jpg",new File("04.jpg"));
            out = Lab01.histnorm(out);
            ImageIO.write(out,"jpg",new File("04b.jpg"));
        } catch(IOException e) {
            System.out.println("W module Lab01 padło: " + e.toString());
        }
    }
    
    public static BufferedImage negatyw(BufferedImage in) {
        BufferedImage out = new BufferedImage(in.getWidth(), in.getHeight(),in.getType());
        int height,width;
        width = out.getWidth();
        height = out.getHeight();
        for (int i = 0; i < width; i++) {
            for (int j = 0; j < height; j++) {
				int red = 255 - RGB.getR(in.getRGB(i, j));
				int green = 255 - RGB.getG(in.getRGB(i, j));
				int blue = 255 - RGB.getB(in.getRGB(i, j));
				out.setRGB(i, j, RGB.toRGB(red, green, blue));
            }
        }
        return out;
    }
    
    public static BufferedImage szarosciS(BufferedImage in) {
        BufferedImage out = new BufferedImage(in.getWidth(), in.getHeight(),in.getType());
        int width,height;
        width = out.getWidth();
        height = out.getHeight();
        for (int i = 0; i < width; i++) {
            for (int j = 0; j < height; j++) {
				int grey = (RGB.getR(in.getRGB(i, j)) + RGB.getG(in.getRGB(i, j)) + RGB.getB(in.getRGB(i, j)))/3;
				out.setRGB(i, j, RGB.toRGB(grey, grey, grey));	
            }
        }
        return out;
    }
    public static BufferedImage szarosciN(BufferedImage in) {
        BufferedImage out = new BufferedImage(in.getWidth(), in.getHeight(),in.getType());
        int width,height;
        width = out.getWidth();
        height = out.getHeight();
        for (int i = 0; i < width; i++) {
            for (int j = 0; j < height; j++) {
				int c = (int)(0.3*RGB.getR(in.getRGB(i, j)) + 0.59*RGB.getG(in.getRGB(i, j)) + 0.11*RGB.getB(in.getRGB(i, j)));
				out.setRGB(i, j, RGB.toRGB(c, c, c));
            }
        }
        return out;
    }
    public static BufferedImage histnorm(BufferedImage in) {
        BufferedImage out = new BufferedImage(in.getWidth(), in.getHeight(),in.getType());
        int width, height;
        width = out.getWidth();
        height = out.getHeight();
		int minR = 255;
		int maxR = 0;
		int minG = 255;
		int maxG = 0;
		int minB = 255;
		int maxB = 0;
        for (int i = 0; i < width; i++) {
            for (int j = 0; j < height; j++) {
				if(RGB.getR(in.getRGB(i, j)) < minR){
					minR = RGB.getR(in.getRGB(i, j));					
				}
				if(RGB.getR(in.getRGB(i, j)) > maxR){
					maxR = RGB.getR(in.getRGB(i, j));
				}

				if(RGB.getG(in.getRGB(i, j)) < minG){
					minG = RGB.getG(in.getRGB(i, j));
				}
				if(RGB.getG(in.getRGB(i, j)) > maxG){
					maxG = RGB.getG(in.getRGB(i, j));
				}

				if(RGB.getB(in.getRGB(i, j)) < minB){
					minB = RGB.getB(in.getRGB(i, j));
				}
				if(RGB.getB(in.getRGB(i, j)) > maxB){
					maxB = RGB.getB(in.getRGB(i, j));
				}
             }
        }

        
        for (int i = 0; i < width; i++) {
            for (int j = 0; j < height; j++) {
				int r = ((RGB.getR(in.getRGB(i, j)) - minR) * 225)/(maxR - minR);
				int g = ((RGB.getG(in.getRGB(i, j)) - minG) * 225)/(maxG - minG);
				int b = ((RGB.getB(in.getRGB(i, j)) - minB) * 225)/(maxB - minB);         	
				out.setRGB(i, j, RGB.toRGB(r, g, b));
            }
        }
        return out;
    }
}

