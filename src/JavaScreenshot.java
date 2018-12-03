
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Rectangle;
import java.awt.Robot;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;
import java.io.File;
import javax.imageio.ImageIO;
import javax.swing.*;

public class JavaScreenshot extends JFrame implements ActionListener {

    JButton b;//Reference of Button component of Swing

    public JavaScreenshot() {
        this.setVisible(true);
        this.setLayout(null);
        b = new JButton("Click Here");
        b.setBounds(380, 290, 120, 60);// It changes layout related information and takes x-coordinate,y-coordinate,width and height as the parameters
        b.setBackground(Color.blue);
        b.setVisible(true);
        b.addActionListener(this);// Adding ActionListener on the Button
        add(b);
        setSize(1000, 700);// sets the width & height of the window
    }

    @Override
    public void actionPerformed(ActionEvent e)//This method is invoked when an action occurs 
    {
        if (e.getSource() == b) //It matches the object on which the event occurred
        {
            this.dispose();
            try {
                Thread.sleep(1000);
                Toolkit tk = Toolkit.getDefaultToolkit();//Toolkit class returns the default toolkit
                Dimension d = tk.getScreenSize();
//Dimension class object stores width & height of the toolkit screen
// toolkit.getScreenSize() determines the size of the screen
                Rectangle rec = new Rectangle(0, 0, d.width, d.height);  //Creates a Rectangle with screen dimensions, here we are capturing the entire screen,if you want you can change it accordingly	(i.e you can also capture a particular area on the screen)	                                   
                Robot ro = new Robot(); //a very important class to capture the screen image
                BufferedImage img = ro.createScreenCapture(rec);
//createScreenCapture() method takes Rectangle class instance as argument and returns BufferedImage
                File f;
                f = new File("myimage.jpg"); // File class is used to write the above generated buffered image to a file
                ImageIO.write(img, "jpg", f);
//ImageIO is an API which is used to convert BufferedImage to a png/jpg image	    
            } catch (Exception ex) {
                System.out.println(ex.getMessage());
            }
        }
    }

    public static void main(String[] args) {
        JavaScreenshot obj = new JavaScreenshot();


    }
}
