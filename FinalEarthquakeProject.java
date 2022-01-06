package classifaction;
import org.datavec.api.records.reader.RecordReader;
import org.datavec.api.records.reader.impl.csv.CSVRecordReader;
import org.datavec.api.split.FileSplit;
import org.deeplearning4j.datasets.datavec.RecordReaderDataSetIterator;
import org.deeplearning4j.nn.conf.MultiLayerConfiguration;
import org.deeplearning4j.nn.conf.NeuralNetConfiguration;
import org.deeplearning4j.nn.conf.layers.DenseLayer;
import org.deeplearning4j.nn.conf.layers.OutputLayer;
import org.deeplearning4j.nn.multilayer.MultiLayerNetwork;
import org.deeplearning4j.nn.weights.WeightInit;
import org.deeplearning4j.optimize.listeners.ScoreIterationListener;
import org.nd4j.evaluation.classification.Evaluation;
import org.nd4j.linalg.activations.Activation;
import org.nd4j.linalg.api.ndarray.INDArray;
import org.nd4j.linalg.dataset.DataSet;
import org.nd4j.linalg.dataset.SplitTestAndTrain;
import org.nd4j.linalg.dataset.api.iterator.DataSetIterator;
import org.nd4j.linalg.learning.config.Sgd;
import org.nd4j.linalg.lossfunctions.LossFunctions;


import java.io.File;
import java.io.IOException;

/**
 *
 * @author Batuhan Tur Team çiçero
 */

public class FinalEarthquakeProject {
    public static void main(String[] args) throws IOException,InterruptedException{
        int labelIndex = 5;
        int numberOfClasses = 5;
        int batchSize = 8500;

        // trainin data
        RecordReader read = new CSVRecordReader(0,',');
        read.initialize(new FileSplit(new File("C:\\Users\\Batuhan Tur\\Desktop\\dl4j-examples\\dl4j-examples\\src\\main\\java\\classifaction\\FinalDataSet.csv")));

        DataSetIterator iterator = new RecordReaderDataSetIterator(read,batchSize,labelIndex, numberOfClasses);
        DataSet data = iterator.next();



        SplitTestAndTrain Xtrain_xtest = data.splitTestAndTrain(0.70);
        data.shuffle();

        DataSet trainData = Xtrain_xtest.getTrain();
        DataSet testData = Xtrain_xtest.getTest();



        final int numberOfInputs = 5;
        int numberOfOutput = 5;
        long seed = 6;


        System.out.println("Building Model..");
        MultiLayerConfiguration conf = new NeuralNetConfiguration.Builder()
                .seed(seed)
                .activation(Activation.TANH)
                .weightInit(WeightInit.XAVIER)
                .updater(new Sgd(1))
                .l2(1e-100)
                .list()
                .layer(new DenseLayer.Builder().nIn(numberOfInputs).nOut(5)
                        .build())
                .layer(new DenseLayer.Builder().nIn(5).nOut(5)
                        .build())
                .layer(new DenseLayer.Builder().nIn(5).nOut(5)
                        .build())
                .layer( new OutputLayer.Builder(LossFunctions.LossFunction.NEGATIVELOGLIKELIHOOD)
                        .activation(Activation.SOFTMAX) //Override the global TANH activation with softmax for this layer
                        .nIn(5).nOut(numberOfOutput).build())

                .build();

        //System.out.println(conf.toJson());
        MultiLayerNetwork model = new MultiLayerNetwork(conf);
        model.init();
        model.setListeners(new ScoreIterationListener(100));
        for(int i=0; i<1000; i++ ) {
            model.fit(trainData);
            //Thread.sleep(1000);
            //System.out.println("Evaluate model...");

            //System.out.println(X_test);
        }
        Evaluation evalation = new Evaluation(5);
        /*while(iterator.hasNext()){*/
        //DataSet t = iterator.next();
        INDArray output = model.output(testData.getFeatures());
        evalation.eval(testData.getLabels(), output);
        System.out.println(evalation.stats());
        //}

        //System.out.println(model.predict(test_read.));

        // PREDICTION

        /*Double [] values = new Double[] {40.05,35.80,10.0,3.2};

        int y;
        y = model.predict(values);
        System.out.println(y);*/


        /*double a = model.score(trainData);

        System.out.println(a);*/
        System.out.println("Testing Count:"+ testData.labelCounts());
        System.out.println("Training Count:"+ trainData.labelCounts());
        System.out.println("4 is Super Earthquakes");
        System.out.println("3 is Great Earthquakes");
        System.out.println("2 is Small Earthquakes");
        System.out.println("1 is Moderate Earthquakes");
        System.out.println("0 is Major Eearthquakes");

    }
}
