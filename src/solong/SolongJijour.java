package solong;

import java.util.ArrayList;

public class SolongJijour implements Solongcalculator {
    private static int m, i, j, vai;

    /*
     * 二乗する専用の計算機
     * @param a 二乗したい数値
     * @param b null指定で構わない
     * */
    @Override
    public Solong execute(Solong a, Solong b) {
        ArrayList<Byte> vaa = a.getValue();
        m = vaa.size();
        int[] va = new int[m];
        for (i = 0; i < m; i++) va[i] = vaa.get(i);

        int[] resultArray = new int[m * 2 - 1];

        /*二乗の際は、インド式の掛け算表にすると数の並びは対角線に対し線対称となる*/
        //掛け算表の半分（対角線を含まない）を求め2倍する
        for (i = 1; i < m; i++) {
            vai = va[i] * 2;//プログラム最適化のためにここで2倍する
            for (j = 0; j < i; j++) {
                resultArray[i + j] += vai * va[j];
            }
        }
        //対角線を求め追加する
        for (i = 0; i < m; i++) {
            resultArray[i * 2] += va[i] * va[i];
        }

        Solong result = new Solong();
        result.setValue(Solong.disposeKuriagari(resultArray));
        return result;
    }
}
