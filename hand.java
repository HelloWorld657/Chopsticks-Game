import java.awt.Graphics2D;
import java.awt.RenderingHints;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import javax.imageio.ImageIO;

public class hand {
    private int fingers;
    private BufferedImage image;
    private int topbottom;

    public hand(int top) {
        fingers = 1;
        topbottom = top;
        if (topbottom == 2) {
            loadImage("Counting1.png");
        } else if (topbottom == 1) {
            loadImage("Counting1top.png");
        }
    }

    public int getFingers() {
        return fingers;
    }

    public BufferedImage getImage() {
        return image;
    }

    public void addFingers(int n) {
        fingers += n;

        if (fingers >= 5) {
            fingers = 0;
        } else if (fingers < 0) {
            fingers = 0;
        }
        if (topbottom == 2) {

        if (fingers == 0) {
            loadImage("Counting0.png");
        } else if (fingers == 1) {
            loadImage("Counting1.png");
        } else if (fingers == 2) {
            loadImage("Counting2.png");
        } else if (fingers == 3) {
            loadImage("Counting3.png");
        } else if (fingers == 4) {
            loadImage("Counting4.png");
        }
        } else if (topbottom == 1) {
            if (fingers == 0) {
                loadImage("Counting0top.png");
            } else if (fingers == 1) {
                loadImage("Counting1top.png");
            } else if (fingers == 2) {
                loadImage("Counting2top.png");
            } else if (fingers == 3) {
                loadImage("Counting3top.png");
            } else if (fingers == 4) {
                loadImage("Counting4top.png");
            }
        }
    }


    private void loadImage(String fileName) {
        try {
            BufferedImage original = ImageIO.read(new File(fileName));
            image = scaleByHalf(original);
        } catch (IOException e) {
            System.out.println("Could not load " + fileName);
            e.printStackTrace();
        }
    }

    private BufferedImage scaleByHalf(BufferedImage original) {
        int newWidth = Math.max(1, original.getWidth() / 2);
        int newHeight = Math.max(1, original.getHeight() / 2);

        BufferedImage scaled = new BufferedImage(newWidth, newHeight, BufferedImage.TYPE_INT_ARGB);
        Graphics2D g2d = scaled.createGraphics();
        g2d.setRenderingHint(RenderingHints.KEY_INTERPOLATION, RenderingHints.VALUE_INTERPOLATION_BILINEAR);
        g2d.setRenderingHint(RenderingHints.KEY_RENDERING, RenderingHints.VALUE_RENDER_QUALITY);
        g2d.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
        g2d.drawImage(original, 0, 0, newWidth, newHeight, null);
        g2d.dispose();

        return scaled;
    }
}
