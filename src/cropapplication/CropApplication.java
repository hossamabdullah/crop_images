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
        for(File file: files){
            Image  img = new ImageIcon(file.getAbsolutePath()).getImage();
            BufferedImage bufferedImage = new BufferedImage(img.getWidth(null), img.getHeight(null),
            BufferedImage.TYPE_INT_RGB);

            Graphics g = bufferedImage.createGraphics();
            g.drawImage(img, 0, 0, null);
            g.dispose();

            BufferedImage bufimg = cropImage(bufferedImage);
            
            file.delete();
            try {
                ImageIO.write(bufimg, "png", new File(file.getAbsolutePath()));
            } catch (IOException ex) {
                Logger.getLogger(CropApplication.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }
    
    private static BufferedImage cropImage(BufferedImage src) {
      BufferedImage dest = src.getSubimage(0, 107, 2559, 1355);
      return dest; 
   }
}
