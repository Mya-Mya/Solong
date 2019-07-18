import countr.Countr;
import solong.*;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.*;

public class Main {

    public static void main(String[] args) {
        //System.out.println(new SolongJijour().execute(new Solong("2634325"),null));
        //System.exit(0);
        ArrayList<Double> log = new ArrayList<>();
        Solongcalculator calculator=new SolongPower();

        for (int i = 0; i < 10; i++) {
            long start = 0;
            long end = 0;
            Solong result;

            Solong a = new Solong();
            Solong b = new Solong();
//            System.out.println("\n一つ目の値aは");
//            a.setValue(new Scanner(System.in).next());
            a.setValue("31415926535897932384626433832");
//            System.out.println(a.getDigits()+"桁");
//            System.out.println("二つ目の値bは");
//            b.setValue(new Scanner(System.in).next());
            b.setValue("100");
//            System.out.println(b.getDigits()+"桁");
            System.out.println("a^2=");

            start = System.currentTimeMillis();
            result = calculator.execute(a, b);
            end = System.currentTimeMillis();

//            Countr.inst().show();
//            Countr.inst().reset();

//            System.out.println(result.toString());
            System.out.println(result.getDigits() + "桁 " + (end - start) + "mill秒");

//            writeText(result.toString(),"計算結果.txt");
            log.add((double) (end - start));
        }
        System.out.println("平均時間は" + getMean(log));
    }

    static void writeText(String text, String title) {
        File file = new File(title);
        FileWriter fileWriter;
        try {
            fileWriter = new FileWriter(file);
            fileWriter.write(text);
            fileWriter.close();
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    static double getMean(ArrayList<Double> value) {
        if (value.size() <= 3) return 0;
        double max = value.get(0);
        double min = value.get(0);
        double sum = 0;
        for (Double v : value) {
            if (v > max) max = v;
            if (v < min) min = v;
            sum += v;
        }
        sum -= (min + max);
        return (double) sum / (double) (value.size() - 2);
    }

}
/*
31415926535897932384626433832の100乗でテストしてる
 */