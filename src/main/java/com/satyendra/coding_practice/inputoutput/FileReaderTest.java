package inputoutput;

import java.io.*;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

public class FileReaderTest {
    public FileReaderTest(String s) {
    }

    public static void main(String[] args) throws IOException {
        try {
            FileReader fileReader = new FileReader("/Users/satyendra.kumar/Downloads/output000.txt");
            BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
            reader.readLine();
            int i;
            while((i = fileReader.read()) != -1) {
                System.out.print((char)i);
            }
            fileReader.close();
        } catch (Exception e) {
            throw e;
        }

    }

    private int calculateMinTime(List<Integer> devTime, List<Integer> integrationTime) {
        List<Node> list = new ArrayList<>();

        for(int i =0 ; i < devTime.size() ; i++) {
            list.add(new Node(devTime.get(i), integrationTime.get(i)));
        }

        Collections.sort(list, new Comparator<Node>() {
            @Override
            public int compare(Node o1, Node o2) {
                return o1.dev - o2.dev;
            }
        });

        int sum = 0 ;
        for(int i = 0 ; i < integrationTime.size() ; i++) {
            sum += integrationTime.get(i);
        }
        return 0;
    }

    static class Node {
        int dev;
        int integration;
        Node(int dev, int integration) {
            this.dev = dev;
            this.integration = integration;
        }

    }
}
