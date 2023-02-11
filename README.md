# CPIT380 Course Project
The aim of this project is to create an application that enables users to edit pictures, audio and videos.
## Group Members
- Rakan Adnan Salama  / 2037276
- Fahad Hamad Alsifri / 1743998
- 
-
-
## Using & Implementing Our Project :
This YouTube video will guide you on how to download and implement our project. It provides step-by-step instructions to help you get set up and running quickly.


## Main Menu:
<p align="center">
  <img width="432" height="471" src="https://user-images.githubusercontent.com/98660298/218203921-270da3ad-8219-4c99-81b6-891e6606c4ad.PNG">
</p>
In the main menu, users can choose which section they want to edit by pressing the corresponding button.

## 1- Color change: 
![ChangeColors](https://user-images.githubusercontent.com/98660298/218205120-033d527b-5fc8-44e5-8a01-8cc40e0727ca.gif)
- Users can customize the RGB colors of their choice by clicking on the color box, adjusting the slider to the desired amount, and selecting whether to increase or decrease the color value. Once they've adjusted the colors to their liking, they can click the "Apply" button to apply the changes.
- Users can remove red from the picture by clicking on the 'Clear red' button.
- Users can remove green from the picture by clicking on the 'Clear green' button.
- Users can remove blue from the picture by clicking on the 'Clear blue' button.
- Users can adjust the darkness of the image by clicking the "Darken" button.
- Users can adjust the brightness of the picture by clicking on the "Brighter" button.
######  Change red,green,blue colors using sliders code:

     private void jButton20ActionPerformed(java.awt.event.ActionEvent evt) {                                          
        double red = -1;
        double green = -1;
        double blue = -1;
        if (jCheckBox1.isSelected()) {
            red = jSlider1.getValue();
            if (jComboBox1.getSelectedIndex() == 0) {
                red = 1 + (red / 100);
            } else if (jComboBox1.getSelectedIndex() == 1) {
                red = 1 - (red / 100);
            }
        }
        if (jCheckBox2.isSelected()) {
            green = jSlider2.getValue();
            if (jComboBox1.getSelectedIndex() == 0) {
                green = 1 + (green / 100);
            } else if (jComboBox1.getSelectedIndex() == 1) {
                green = 1 - (green / 100);
            }
        }
        if (jCheckBox3.isSelected()) {
            blue = jSlider3.getValue();
            if (jComboBox1.getSelectedIndex() == 0) {
                blue = 1 + (blue / 100);
            } else if (jComboBox1.getSelectedIndex() == 1) {
                blue = 1 - (blue / 100);
            }
        }

        Pixel[] pixelArray = picObj.getPixels();
        double value = 0;
        for (Pixel pixelObj : pixelArray) {
            if (red != -1.0) {
                value = pixelObj.getRed();
                pixelObj.setRed((int) (value * red));
            }
            if (green != -1.0) {
                value = pixelObj.getGreen();
                pixelObj.setGreen((int) (value * green));
            }
            if (blue != -1.0) {
                value = pixelObj.getBlue();
                pixelObj.setBlue((int) (value * blue));
            }

        }
        Image img = (picObj.getImage()).getScaledInstance(jLabel2.getWidth(), jLabel2.getHeight(), Image.SCALE_SMOOTH);
        icon = new ImageIcon(img);
        jLabel2.setIcon(icon);
    }   
###### Clear red code:
    private void jButton15ActionPerformed(java.awt.event.ActionEvent evt) {                                          
        Pixel[] pixelArray = picObj.getPixels();
        for (Pixel pixelObj : pixelArray) {
            pixelObj.setRed(0);
        }
        Image img = (picObj.getImage()).getScaledInstance(jLabel2.getWidth(), jLabel2.getHeight(), Image.SCALE_SMOOTH);
        icon = new ImageIcon(img);
        jLabel2.setIcon(icon);
    }
###### Clear green code:
    private void jButton16ActionPerformed(java.awt.event.ActionEvent evt) {                                          
        Pixel[] pixelArray = picObj.getPixels();
        for (Pixel pixelObj : pixelArray) {
            pixelObj.setGreen(0);
        }
        Image img = (picObj.getImage()).getScaledInstance(jLabel2.getWidth(), jLabel2.getHeight(), Image.SCALE_SMOOTH);
        icon = new ImageIcon(img);
        jLabel2.setIcon(icon);
    } 
 
###### Clear blue code:
    private void jButton17ActionPerformed(java.awt.event.ActionEvent evt) {                                          
        Pixel[] pixelArray = picObj.getPixels();
        for (Pixel pixelObj : pixelArray) {
            pixelObj.setBlue(0);
        }
        Image img = (picObj.getImage()).getScaledInstance(jLabel2.getWidth(), jLabel2.getHeight(), Image.SCALE_SMOOTH);
        icon = new ImageIcon(img);
        jLabel2.setIcon(icon);
    }
###### Darker code:
    private void jButton18ActionPerformed(java.awt.event.ActionEvent evt) {                                          
        Pixel[] pixelArray = picObj.getPixels();
        Color color = null;
        for (Pixel pixelArray1 : pixelArray) {
            color = pixelArray1.getColor();
            color = color.darker();
            pixelArray1.setColor(color);
        }
        Image img = (picObj.getImage()).getScaledInstance(jLabel2.getWidth(), jLabel2.getHeight(), Image.SCALE_SMOOTH);
        icon = new ImageIcon(img);
        jLabel2.setIcon(icon);
    }  
###### Brighter code:
    private void jButton19ActionPerformed(java.awt.event.ActionEvent evt) {                                          
        Pixel[] pixelArray = picObj.getPixels();
        Color color = null;
        for (Pixel pixelArray1 : pixelArray) {
            color = pixelArray1.getColor();
            color = color.brighter();
            pixelArray1.setColor(color);
        }
        Image img = (picObj.getImage()).getScaledInstance(jLabel2.getWidth(), jLabel2.getHeight(), Image.SCALE_SMOOTH);
        icon = new ImageIcon(img);
        jLabel2.setIcon(icon);
    } 
## 2- Copy and Crop: 
![giphy](https://user-images.githubusercontent.com/98660298/218214144-4244addc-8db6-4fb4-b5ec-043ad199ecbb.gif)

Users can crop any part of the picture by selecting the starting point and the ending point with two clicks. The first click will mark the beginning of the cropping area and the second click will mark the end of the cropping area.
 ###### Crop code:
    private void jButton46ActionPerformed(java.awt.event.ActionEvent evt) {                                          
        // cropping
        JFrame parent = new JFrame();
        JOptionPane.showMessageDialog(parent, "Please click on two points in the image");
        jLabel1.addMouseListener(new MouseAdapter() {
            int numOfClicks = 0;
            int x1;
            int x2;
            int y1;
            int y2;

            @Override
            public void mouseClicked(MouseEvent e) {
                numOfClicks++;
                if (numOfClicks == 1) {
                    x1 = e.getX();
                    y1 = e.getY();

                } else if (numOfClicks == 2) {
                    x2 = e.getX();
                    y2 = e.getY();
                    // call the crop method with both cordinates.

                    double W = (picObj.getWidth() * 1.00 / jLabel1.getWidth());
                    double H = (picObj.getHeight() * 1.00 / jLabel1.getHeight());

                    x1 = (int) (W * x1);
                    x2 = (int) (W * x2);
                    y1 = (int) (H * y1);
                    y2 = (int) (H * y2);

                    Picture newPic = new Picture(picObj.getWidth(), picObj.getHeight());

                    Pixel sourcePixel;
                    Pixel targetPixel;

                    for (int i = x1; i < x2; i++) {
                        for (int j = y1; j < y2; j++) {
                            sourcePixel = picObj.getPixel(i, j);
                            targetPixel = newPic.getPixel(i, j);
                            targetPixel.setColor(sourcePixel.getColor());
                        }

                    }
                    picObj = newPic;
                    numOfClicks = 0;
                    jLabel1.removeMouseListener(this);
                    Image img = (picObj.getImage()).getScaledInstance(jLabel2.getWidth(), jLabel2.getHeight(), Image.SCALE_SMOOTH);
                    icon = new ImageIcon(img);
                    jLabel2.setIcon(icon);
                }
            }
        });


    } 
## 3- Convert RGB to Gray Scale Image: 
![giphy (1)](https://user-images.githubusercontent.com/98660298/218218375-285900c8-f507-492e-b5e7-b5952454ac1a.gif)

By pressing the "Convert to Gray Scale" button, users can change the colors of the picture to gray.
######   Convert RGB to Gray Scale Image code:

    private void jButton21ActionPerformed(java.awt.event.ActionEvent evt) {                                          
        //Convert To Gray Scale
        Pixel[] pixels = picObj.getPixels();
        int avg;
        for (Pixel pixel1 : pixels) {
            avg = (int) ((pixel1.getRed() + pixel1.getGreen() + pixel1.getBlue()) / 3);
            Color grayColor = new Color(avg, avg, avg);
            pixel1.setColor(grayColor);
        }
        Image img = (picObj.getImage()).getScaledInstance(jLabel2.getWidth(), jLabel2.getHeight(), Image.SCALE_SMOOTH);
        icon = new ImageIcon(img);
        jLabel2.setIcon(icon);
    }     
## 4- Convert Gray scale to Binary Image using thresholding technique 
![giphy (2)](https://user-images.githubusercontent.com/98660298/218220105-c1059513-3ed7-404b-94cb-1d8c005bbed6.gif)

Users will select a threshold value, which will be used to convert an image to grayscale and then to a binary Image.
######   Convert Gray scale to Binary Image using thresholding technique code:

    private void jButton22ActionPerformed(java.awt.event.ActionEvent evt) {                                          
        String threshold = JOptionPane.showInputDialog(null, "Please Enter the size: ");
        Pixel[] pixels = picObj.getPixels();
        int avg;
        for (Pixel pixel1 : pixels) {
            avg = (int) ((pixel1.getRed() + pixel1.getGreen() + pixel1.getBlue()) / 3);
            Color grayColor = new Color(avg, avg, avg);
            pixel1.setColor(grayColor);
        }
        int AVG;
        Picture target = new Picture(picObj.getWidth(), picObj.getHeight());
        for (int x = 0; x < picObj.getWidth(); x++) {
            for (int y = 0; y < picObj.getHeight(); y++) {
                AVG = (int) Math.abs(picObj.getPixel(x, y).getAverage());
                if (AVG < Integer.parseInt(threshold)) {
                    target.getPixel(x, y).setColor(Color.BLACK);
                }
            }
        }

        picObj = target;
        Image img = (picObj.getImage()).getScaledInstance(jLabel2.getWidth(), jLabel2.getHeight(), Image.SCALE_SMOOTH);
        icon = new ImageIcon(img);
        jLabel2.setIcon(icon);
    } 

## 5- Convert and RGB image to HSV colored image
When users press the button "convert to HSV" the values of the pixels will be converted from RGB into HSV . The output will be the same. 

######   Convert and RGB image to HSV colored image code:

    private void jButton23ActionPerformed(java.awt.event.ActionEvent evt) {                                          
        //hsv
        Image img = (picObj.getImage()).getScaledInstance(jLabel1.getWidth(), jLabel1.getHeight(), Image.SCALE_SMOOTH);
        BufferedImage rgbImage = new BufferedImage(img.getWidth(null), img.getHeight(null), BufferedImage.TYPE_INT_RGB);
        BufferedImage hsvImage = new BufferedImage(rgbImage.getWidth(), rgbImage.getHeight(), BufferedImage.TYPE_INT_RGB);
        for (int x = 0; x < rgbImage.getWidth(); x++) {
            for (int y = 0; y < rgbImage.getHeight(); y++) {
                Color rgb = new Color(rgbImage.getRGB(x, y));
                int r = rgb.getRed();
                int g = rgb.getGreen();
                int b = rgb.getBlue();
                int max = Math.max(r, Math.max(g, b));
                int min = Math.min(r, Math.min(g, b));
                float h = 0, s = 0, v = max / 255f;
                int delta = max - min;
                if (max != 0) {
                    s = delta / (float) max;
                }
                if (delta != 0) {
                    if (r == max) {
                        h = (g - b) / (float) delta;
                    } else if (g == max) {
                        h = 2 + (b - r) / (float) delta;
                    } else {
                        h = 4 + (r - g) / (float) delta;
                    }
                    h /= 6;
                    if (h < 0) {
                        h++;
                    }
                }
                int hsv = ((int) (h * 255)) | ((int) (s * 255)) | (int) (v * 255);
                hsvImage.setRGB(x, y, hsv);
            }
        }
        Graphics2D bGr = hsvImage.createGraphics();
        bGr.drawImage(img, 0, 0, null);
        bGr.dispose();
        File outputfile = new File("Tmp\\HSV.png");
        try {
            ImageIO.write(hsvImage, "png", outputfile);
        } catch (IOException ex) {
            Logger.getLogger(PictureEditor.class.getName()).log(Level.SEVERE, null, ex);
        }
        Picture s = new Picture("Tmp\\HSV.png");
        img = (s.getImage()).getScaledInstance(jLabel2.getWidth(), jLabel2.getHeight(), Image.SCALE_SMOOTH);
        icon = new ImageIcon(img);
        jLabel2.setIcon(icon);

    } 
    
## 6- Blending Two or more images:
![giphy (3)](https://user-images.githubusercontent.com/98660298/218222780-733e3af9-4ed6-4705-a83f-f11ead54f575.gif)

Users can blend 2 or more picture into one picture by pressing the button "Blending".

######   Blending Two or more images code:

     private void jButton47ActionPerformed(java.awt.event.ActionEvent evt) {                                          
        // blending
        String fileName2 = FileChooser.pickAFile();
        Picture picture1 = new Picture(fileName2);
        Image img = (picture1.getImage()).getScaledInstance(jLabel1.getWidth(), jLabel1.getHeight(), Image.SCALE_SMOOTH);
        BufferedImage bimage = new BufferedImage(img.getWidth(null), img.getHeight(null), BufferedImage.TYPE_INT_ARGB);
        Graphics2D bGr = bimage.createGraphics();
        bGr.drawImage(img, 0, 0, null);
        bGr.dispose();
        File outputfile = new File("Tmp\\blend2.png");
        try {
            ImageIO.write(bimage, "png", outputfile);
        } catch (IOException ex) {
            Logger.getLogger(PictureEditor.class.getName()).log(Level.SEVERE, null, ex);
        }
        Picture picture2 = new Picture("Tmp\\blend2.png");
        Picture TargetPicture = new Picture(picObj.getWidth() + picture2.getWidth(), picObj.getHeight() + picture2.getHeight());

        Pixel pic1;
        Pixel pic2;
        Pixel targetPixel;
        int sourceX = 0;
        int targetX = 0;
        for (; sourceX < 150; sourceX++, targetX++) {
            for (int sourceY = 0, targetY = 0; sourceY < picObj.getHeight(); sourceY++, targetY++) {
                pic1 = picObj.getPixel(sourceX, sourceY);
                targetPixel = TargetPicture.getPixel(targetX, targetY);
                targetPixel.setColor(pic1.getColor());

            }
        }
        for (; sourceX < picObj.getWidth(); sourceX++, targetX++) {
            for (int sourceY = 0, targetY = 0; sourceY < picObj.getHeight(); sourceY++, targetY++) {
                pic1 = picObj.getPixel(sourceX, sourceY);
                pic2 = picture2.getPixel(sourceX - 150, sourceY);
                targetPixel = TargetPicture.getPixel(targetX, targetY);
                Color b = new Color((int) (pic1.getRed() * 0.5 + pic2.getRed() * 0.5), (int) (pic1.getGreen() * 0.5 + pic2.getGreen() * 0.5), (int) (pic1.getBlue() * 0.5 + pic2.getBlue() * 0.5));
                targetPixel.setColor(b);
            }
        }
        int tmpx = 0;
        int tmpy = 0;
        sourceX = sourceX - 150;
        for (; sourceX < picture2.getWidth(); sourceX++, targetX++) {
            for (int sourceY = 0, targetY = 0; sourceY < picture2.getHeight(); sourceY++, targetY++) {
                pic2 = picture2.getPixel(sourceX, sourceY);
                targetPixel = TargetPicture.getPixel(targetX, targetY);
                targetPixel.setColor(pic2.getColor());
                tmpy = targetY;
            }
            tmpx = targetX;
        }

        Pixel tmpc = null;
        Pixel targetPixel1 = null;
        Picture TargetPicture1 = new Picture(tmpx, tmpy);
        for (int i = 0; i < tmpx; i++) {
            for (int j = 0; j < tmpy; j++) {
                tmpc = TargetPicture.getPixel(i, j);
                targetPixel1 = TargetPicture1.getPixel(i, j);
                targetPixel1.setColor(tmpc.getColor());
            }
        }
        picObj = TargetPicture1;
        Image img1 = (picObj.getImage()).getScaledInstance(jLabel2.getWidth(), jLabel2.getHeight(), Image.SCALE_SMOOTH);
        icon = new ImageIcon(img1);
        jLabel2.setIcon(icon);
    } 
## 7 + 8- Left,right,180 rotations:

![giphy (4)](https://user-images.githubusercontent.com/98660298/218223667-f0c9f452-e6ed-45c2-8891-8a08f8fd9ad8.gif)

Pressing "Left Rotations" allows users to rotate the selected picture to the left, while "Right Rotations" rotates it to the right. For a 180-degree rotation, press the button "Rotation by 180".

######   Left Rotation code:
    private void jButton24ActionPerformed(java.awt.event.ActionEvent evt) {                                          
        //Left Rotation
        Picture sourcePicture = picObj;
        Picture TargetPicture = new Picture(sourcePicture.getHeight(), sourcePicture.getWidth());
        Pixel sourcePixel;
        Pixel targetPixel;
        int targetX, targetY = 0;
        for (int sourceX = 0; sourceX < sourcePicture.getWidth(); sourceX++) {
            for (int sourceY = 0; sourceY < sourcePicture.getHeight(); sourceY++) {
                sourcePixel = sourcePicture.getPixel(sourceX, sourceY);
                targetX = sourceY;
                targetY = sourcePicture.getWidth() - 1 - sourceX;
                targetPixel = TargetPicture.getPixel(targetX, targetY);
                targetPixel.setColor(sourcePixel.getColor());
            }
        }
        Image img = (TargetPicture.getImage()).getScaledInstance(jLabel2.getWidth(), jLabel2.getHeight(), Image.SCALE_SMOOTH);
        icon = new ImageIcon(img);
        jLabel2.setIcon(icon);
        picObj = TargetPicture;
    } 
    
######   Right Rotation code:

    private void jButton26ActionPerformed(java.awt.event.ActionEvent evt) {                                          
        //Right Rotation
        Picture sourcePicture = picObj;
        Picture TargetPicture = new Picture(sourcePicture.getHeight(), sourcePicture.getWidth());
        Pixel sourcePixel;
        Pixel targetPixel;
        int targetX, targetY = 0;
        for (int sourceX = 0; sourceX < sourcePicture.getWidth(); sourceX++) {
            for (int sourceY = 0; sourceY < sourcePicture.getHeight(); sourceY++) {
                sourcePixel = sourcePicture.getPixel(sourceX, sourceY);
                targetX = sourcePicture.getHeight() - 1 - sourceY;
                targetY = sourceX;
                targetPixel = TargetPicture.getPixel(targetX, targetY);
                targetPixel.setColor(sourcePixel.getColor());
            }
        }
        Image img = (TargetPicture.getImage()).getScaledInstance(jLabel2.getWidth(), jLabel2.getHeight(), Image.SCALE_SMOOTH);
        icon = new ImageIcon(img);
        jLabel2.setIcon(icon);
        picObj = TargetPicture;
    }
    
 ######   180 degree Rotation code:
     private void jButton25ActionPerformed(java.awt.event.ActionEvent evt) {                                          
        // Rotation 180
        Picture sourcePicture = picObj;
        Picture TargetPicture = new Picture(sourcePicture.getWidth(), sourcePicture.getHeight());
        Pixel sourcePixel;
        Pixel targetPixel;
        int targetX, targetY = 0;
        for (int sourceX = 0; sourceX < sourcePicture.getWidth(); sourceX++) {
            for (int sourceY = 0; sourceY < sourcePicture.getHeight(); sourceY++) {
                sourcePixel = sourcePicture.getPixel(sourceX, sourceY);
                targetX = sourcePicture.getWidth() - 1 - sourceX;
                targetY = sourcePicture.getHeight() - 1 - sourceY;
                targetPixel = TargetPicture.getPixel(targetX, targetY);
                targetPixel.setColor(sourcePixel.getColor());
            }
        }
        Image img = (TargetPicture.getImage()).getScaledInstance(jLabel2.getWidth(), jLabel2.getHeight(), Image.SCALE_SMOOTH);
        icon = new ImageIcon(img);
        jLabel2.setIcon(icon);
        picObj = TargetPicture;
    } 
 


