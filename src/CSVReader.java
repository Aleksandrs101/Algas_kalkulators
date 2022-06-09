import java.io.*;
import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class CSVReader {

    public static void main(String[] args) throws IOException {
        String path ="C:\\Users\\aozolins\\OneDrive - Emergn Ltd\\Darbvirsma\\algaCSV.csv";
        String[][] myNumbers = new String[15][5];
        int count = 30;
        int i = 0;
        File file = new File(path);
        System.out.println(path);
        Scanner inputStream;
        inputStream = new Scanner(file);
        while (inputStream.hasNextLine()) {
            String line = inputStream.nextLine();
            if(line==null) {
                break;
            }
            else {
                myNumbers[i] = line.split(";");
            }
            i++;
//System.out.println(line);
        }
//        for (i = 0; i < myNumbers.length; ++i) {
//            for (int j = 0; j < myNumbers[i].length; ++j) {
//                System.out.println(myNumbers[i][j]);
//            }
            System.out.println("pirma vertiba "+myNumbers[0][1]);
        }

    }

//        String line = "";
//        String[] values = new String[1];
//        try {
//            BufferedReader br = new BufferedReader(new FileReader(path));
//            while ((line = br.readLine()) != null) {
//                values = line.split(";");
//                //System.out.println(Arrays.toString(values));
//                for (String number: values) {
//                    System.out.println(number);
//            }
//
//            // for each loop for (int number: numbers) {
//
//        }   // for each loop
//            System.out.println(" ");
//            System.out.println(values[3]);
//    } catch(
//    IOException e)
//
//    {
//        e.printStackTrace();
//        System.out.println("asd");
//    }
//}}
//
