


import java.util.*;

public class Normalizasyon {

    double [] values;
    double new_max, new_min;
    double max,min;
    public double[] AddNormalization(double[] values, double new_max, double new_min){
        this.values = values;
        getMaxMin(values);
        this.new_min = new_min;
        this.new_max = new_max;
        double [] normalValues = new double[values.length];
        int counter =0;
        for (counter=0;counter<this.values.length;counter++){
//            System.out.println("Before:"+ );
            normalValues[counter]=normalise(values[counter]);
        }
        return normalValues;
    }
    public double normalise(double value){
        double result =  ((value-min)*(new_max - new_min)/(max-min))+ new_min;

        return result;
    }
    public void getMaxMin(double[] values){
        double[] a =values.clone();
        Arrays.sort(a);
        this.max = a[a.length-1];
        this.min = a[0];
    }
}
