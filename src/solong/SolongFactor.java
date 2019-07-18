package solong;

import java.util.Arrays;

public class SolongFactor implements Solongcalculator {
    /*
    * @param a 階乗したい数
    * @param b 未使用
    * */
    @Override
    public Solong execute(Solong a, Solong b) {
        int allStep=a.getR();
        Solong result=new Solong("1");
        Solongcalculator multiplyer=new SolongMultiplyer();
        for(int i=2;i<=allStep;i++){
            result=multiplyer.execute(result,new Solong(Integer.toString(i)));
        }
        return result;
    }
}
