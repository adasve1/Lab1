import java.awt.*;
        import java.awt.image.BufferedImage;
        import java.io.File;
        import java.io.IOException;
import java.util.ArrayList;
import javax.imageio.ImageIO;
        import javax.swing.*;

// This panel represent the animated part of the view with the car images.

public class DrawPanel extends JPanel{

    private Point frameSize;
    private Point picSize;


    // Just a single image, TODO: Generalize
    ArrayList<MotorVehicle> vehicles;
    ArrayList<BufferedImage> vehicleImages;
    // To keep track of a single cars position
    ArrayList<Point> vehiclePosition;



    // TODO: Make this general for all cars
    void moveit(ArrayList<MotorVehicle> vehicles){
        this.vehicles=vehicles;
        /*vehicle.setPosition(x,y);
        volvoPoint.x = x;
        volvoPoint.y = y;
        scaniaPoint.x = x;
        scaniaPoint.y = y+100;*/
    }

   /* void currentImage(MotorVehicle vehicle){
        vehicleImage=vehicle.getImage();
    }*/

    // Initializes the panel and reads the images
    public DrawPanel(int x, int y) {
        this.frameSize = new Point(x,y);
        this.setDoubleBuffered(true);
        this.setPreferredSize(new Dimension(x, y));
        this.setBackground(Color.orange);
      /*  this.vehicles =  vehicles;
        for (MotorVehicle vehicle : vehicles){
            vehicleImages.add(vehicle.getImage());
            vehiclePosition.add(new Point((int) vehicle.getXPosition(),(int) vehicle.getYPosition()));
        }*/
        /*// Print an error message in case file is not found with a try/catch block
        try {
            // You can remove the "pics" part if running outside of IntelliJ and
            // everything is in the same main folder.
            // volvoImage = ImageIO.read(new File("Volvo240.jpg"));

            // Rememember to rightclick src New -> Package -> name: pics -> MOVE *.jpg to pics.
            // if you are starting in IntelliJ.
            volvoImage = ImageIO.read(DrawPanel.class.getResourceAsStream("pics/Volvo240.jpg"));
            scaniaImage = ImageIO.read(DrawPanel.class.getResourceAsStream("pics/Scania.jpg"));
            this.picSize = new Point(volvoImage.getWidth(),volvoImage.getHeight());
        } catch (IOException ex)
        {
            ex.printStackTrace();
        }*/

    }

    public Point getFrameSize() {
        return this.frameSize;

    }

    public Point getPicSize() {
        return this.picSize;
    }

    // This method is called each time the panel updates/refreshes/repaints itself
    // TODO: Change to suit your needs.
    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);//TODO loop to draw out every vehicle
        for (MotorVehicle vehicle : vehicles){

            g.drawImage(vehicle.getImage(),(int) vehicle.getXPosition(),(int) vehicle.getYPosition(), null); // see javadoc for more info on the parameters


        }
    }
}