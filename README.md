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

Users will select a threshold value, which will be used to convert an image to grayscale and then to a binary format.
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

