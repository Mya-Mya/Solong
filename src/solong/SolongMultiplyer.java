package solong;

import countr.Countr;

import java.beans.Transient;
import java.util.Arrays;
import java.util.ArrayList;

/*
 * Solong型同士のかけ算を行う。
 * 演算中にInteger及び行列のようなデータ構造を使用する都合で、使用制限が生じる。
 * 安全に利用できる桁数条件：どちらも26,512,143桁以内（Integer.MAX_VALUE/81）
 * 利用できる桁数条件：どちらも2,147,483,647桁以内（Integer.MAX_VALUE/1)
 * */
public class SolongMultiplyer implements Solongcalculator {
    public SolongMultiplyer() {
    }

    private static int m, n, i, j, vai;

    /*
    * 配列読み込みの関係で、桁数の少ないほうをaに指定して*/
    @Override
    public Solong execute(Solong a, Solong b) {
        ArrayList<Byte> vaa = a.getValue();

        m = vaa.size();
        int[] va = new int[m];
        for (i = 0; i < m; i++) va[i] = vaa.get(i);

        ArrayList<Byte> vbb = b.getValue();

        n = vbb.size();
        int[] vb = new int[n];
        for ( i = 0; i < n; i++) vb[i] = vbb.get(i);

        int[] resultArray = new int[m + n - 1];

        //インド式及び筆算式
        for ( i = 0; i < m; i++) {
            vai = va[i];
            for (j = 0; j < n; j++) {
                resultArray[i + j] += vai * vb[j];
            }
        }

        Solong result = new Solong();//TODO: ボトルネック
        result.setValue(Solong.disposeKuriagari(resultArray));
        return result;
    }
}
