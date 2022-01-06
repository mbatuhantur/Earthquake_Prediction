import net.sf.javaml.clustering.Clusterer;
import net.sf.javaml.clustering.KMeans;
import net.sf.javaml.core.Dataset;
import net.sf.javaml.tools.data.FileHandler;

import javax.swing.*;
import java.awt.*;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.io.*;


public class Main extends JFrame{


    public static void main(String[] args) throws IOException {

        Dataset file = FileHandler.loadDataset(new File("C:\\Users\\Batuhan Tur\\Desktop\\newone\\son1.csv"),-1,",");
        Clusterer cs = new KMeans(3);
        Dataset[] clusters = cs.cluster(file);

        double [] longitude0 = new double[clusters[0].size()];
        double [] longitude1 = new double[clusters[1].size()];
        double [] longitude2 = new double[clusters[2].size()];
        //double [] longitude3 = new double[clusters[3].size()];


        double [] latitude0 = new double[clusters[0].size()];
        double [] latitude1 = new double[clusters[1].size()];
        double [] latitude2 = new double[clusters[2].size()];
        //double [] latitude3 = new double[clusters[3].size()];




           for (int index = 0; index < clusters[0].size(); index++) {

               longitude0[index] = clusters[0].get(index).get(0);
               latitude0[index]  = clusters[0].get(index).get(1);

           }
        for (int index = 0; index < clusters[1].size(); index++) {

            longitude1[index] = clusters[1].get(index).get(0);
            latitude1[index]  = clusters[1].get(index).get(1);

        }

        for (int index = 0; index < clusters[2].size(); index++) {

            longitude2[index] = clusters[2].get(index).get(0);
            latitude2[index]  = clusters[2].get(index).get(1);

        }
        /*for (int index = 0; index < clusters[3].size(); index++) {

            boylamlar3[index] = clusters[3].get(index).get(0);
            enlemler3[index]  = clusters[3].get(index).get(1);

        }*/

          Normalizasyon normal = new Normalizasyon();



        latitude0 = normal.AddNormalization(latitude0,940,1);
        latitude1 = normal.AddNormalization(latitude1,940,1);
        latitude2 = normal.AddNormalization(latitude2,940,1);
        //enlemler3 = normal.AddNormalization(enlemler3,940,1);



        longitude0 =normal.AddNormalization(longitude0,1815,1);
        longitude1 =normal.AddNormalization(longitude1,1815,1);
        longitude2 =normal.AddNormalization(longitude2,1815,1);
        //boylamlar3=normal.AddNormalization(boylamlar3,1815,1);





        Frame fm =new Frame("Map");
        fm.addWindowListener(new WindowAdapter() {
            @Override
            public void windowClosing(WindowEvent e) {
                System.exit(0);
            }
        });

        fm.add(new JLabel(new ImageIcon("C:\\Users\\Batuhan Tur\\Desktop\\Deprem Analizi\\img.png")));
        fm.pack();
        fm.setVisible(true);
        Graphics g = fm.getGraphics();
        fm.setResizable(false);


        for (int index = 0; index< latitude0.length; index++){

            System.out.println("Scan:");
            System.out.println(longitude0[index]+"-"+ latitude0[index]);
            System.out.println("Write:");
            System.out.println((int) longitude0[index]+":"+(int) latitude0[index]);

            g.setColor(Color.DARK_GRAY);
                g.fillOval((int) longitude0[index],940-(int) latitude0[index],6,6);}
        for (int index = 0; index< latitude1.length; index++){


                g.setColor(Color.blue);
            g.fillOval((int) longitude1[index],940-(int) latitude1[index],6,6);}
        for (int index = 0; index< latitude2.length; index++){

                g.setColor(Color.green);
            g.fillOval((int) longitude2[index],940-(int) latitude2[index],6,6);}

       /* for (int index = 0; index<enlemler3.length;index++){


            g.fillOval((int) boylamlar3[index],940-(int)enlemler3[index],6,6);}
*/

    }


}
