package pl.firaanki;

import junit.framework.TestCase;

import java.util.*;

public class NetworkTest extends TestCase {

    public void testStartNetwork() {

        Network network = new Network(new int[]{4, 9, 7, 3}, -1, 1);
        Map<double[], double[]> data = FileHandler.getFile("iris.data").read();

        ArrayList<Map.Entry<double[], double[]>> dataList = new ArrayList<>(data.entrySet());
        ArrayList<Map.Entry<double[], double[]>> trainData = new ArrayList<>();
        ArrayList<Map.Entry<double[], double[]>> testData = new ArrayList<>();

        Collections.shuffle(dataList);
        int trainCount = 60;

        for (int i = 0; i < trainCount; i++) {
            trainData.add(dataList.get(i));
        }
        for (int i = trainCount; i < 150; i++) {
            testData.add(dataList.get(i));
        }

        network.online(trainData);
        network.testNetwork(testData);
    }

    public void testAutoencoder() {
        Map<double[], double[]> patternsMap = new HashMap<>();
        patternsMap.put(new double[]{1, 0, 0, 0}, new double[]{1, 0, 0, 0});
        patternsMap.put(new double[]{0, 1, 0, 0}, new double[]{0, 1, 0, 0});
        patternsMap.put(new double[]{0, 0, 1, 0}, new double[]{0, 0, 1, 0});
        patternsMap.put(new double[]{0, 0, 0, 1}, new double[]{0, 0, 0, 1});
        ArrayList<Map.Entry<double[], double[]>> patterns = new ArrayList<>(patternsMap.entrySet());

        Network network = new Network(new int[]{4, 2, 4}, 0, 1);
        network.offline(patterns, 0.9);


    }
}