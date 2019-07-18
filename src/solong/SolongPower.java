package solong;

import java.util.ArrayList;

public class SolongPower implements Solongcalculator {
    private static Solongcalculator multiplyer = new SolongMultiplyer();
    private static Solongcalculator jijour=new SolongJijour();

    /*指数に関してややこしい処理をしている
     * */
    @Override
    public Solong execute(Solong a, Solong b) {
        String powBinary = Integer.toBinaryString(b.getR());//指数を2進数で表す
        int powBinaryLength=powBinary.length();
        ArrayList<Solong> multipleQue = new ArrayList<>();//全ての(a^(2^N))

        if (powBinary.charAt(powBinaryLength-1)=='1') {
            multipleQue.add(a);
        }
        for (int i = powBinaryLength - 2; i >= 0; i--) {
            //捜査対象とする指数の位が上がるにつれ該当する項は2乗
            a=jijour.execute(a,null);
            if (powBinary.charAt(i) == '1') {
                multipleQue.add(a);
            }
        }

        Solong result;
        if(multipleQue.size()!=0){
            result=multipleQue.get(0);
            multipleQue.remove(0);
        } else{
            result=new Solong("1");
        }
        for (Solong s : multipleQue) {
            result = multiplyer.execute(result,s);
        }
        return result;
    }

}
