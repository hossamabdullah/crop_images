/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cropapplication;

import java.awt.Graphics;
import java.awt.Image;
import java.awt.Rectangle;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.imageio.ImageIO;
import javax.swing.ImageIcon;

/**
 *
 * @author HossamEldeen
 */
public class CropApplication {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        File dir = new File("C:\\Data\\Screenshots\\new");
        File[] files = dir.listFiles();
        for (File file : files) {
            BufferedImage bufferedImage = convertFileToBufferedImage(file);
            BufferedImage bufimg = cropImage(bufferedImage, 0, 107, 2559, 1355);
            file.delete();
            saveFile(bufimg, "png", file.getAbsolutePath());
        }
    }

    private static BufferedImage convertFileToBufferedImage(File file) {
        Image img = new ImageIcon(file.getAbsolutePath()).getImage();
        BufferedImage bufferedImage = new BufferedImage(img.getWidth(null), img.getHeight(null),
                BufferedImage.TYPE_INT_RGB);

        Graphics g = bufferedImage.createGraphics();
        g.drawImage(img, 0, 0, null);
        g.dispose();
        return bufferedImage;
    }

    private static void saveFile(BufferedImage bufImg, String ext, String path) {
        try {
            ImageIO.write(bufImg, ext, new File(path));
        } catch (IOException ex) {
            Logger.getLogger(CropApplication.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    private static BufferedImage cropImage(BufferedImage src, int startX, int startY, int width, int height) {
        BufferedImage dest = src.getSubimage(startX, startY, width, height);
        return dest;
    }
}
