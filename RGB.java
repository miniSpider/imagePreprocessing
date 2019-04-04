public class RGB {
    public static int getR(int in) {
        return (int)(in >> 16) & 0xff;
    }
    public static int getG(int in) {
        return (int)(in >> 8) & 0xff;
    }
    public static int getB(int in) {
        return (int)(in) & 0xff;
    }
    public static int toRGB(int r,int g,int b) {
        return (int)((((r << 8)|g) << 8)|b);
    }
}
