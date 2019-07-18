package solong;

import java.util.ArrayList;

public class Solong {
    private ArrayList<Byte> value;
    public static final byte charToFig(char d){
        switch (d){
            case'0':return 0;
            case'1':return 1;
            case'2':return 2;
            case'3':return 3;
            case'4':return 4;
            case'5':return 5;
            case'6':return 6;
            case'7':return 7;
            case'8':return 8;
            case'9':return 9;
        }
        throw new IllegalArgumentException("数字以外入れんなバカ");
    }


    public int getR(){
        int result=0;
        for(Byte d:value){
            result=result*10+d;
        }
        return result;
    }

    public Solong(String value){
        setValue(value);
    }
    public Solong(){
        setValue("0");
    }
    public void setValue(ArrayList<Byte>value){
        while(value.size()>=2){
            if(value.get(0)!=0)break;
            value.remove(0);
        }
        this.value=value;
    }
    public void setValue(String value){
        value=value.replaceAll("[^\\d]","");
        ArrayList<Byte>result=new ArrayList<>();
        for(char c:value.toCharArray()){
            result.add(charToFig(c));
        }
        setValue(result);
    }
    public ArrayList<Byte> getValue(){
        return value;
    }
    public String getValueByString(){
        StringBuilder sb=new StringBuilder();
        for(Byte d:value){
            sb.append(d);
        }
        String result=sb.toString();
        return result;
    }
    public String toString(){
        return getValueByString();
    }
    public int getDigits(){
        return value.size();
    }

    static int oldf,newf,kuriagari,d;
    static boolean fChanged=false;
    public static final ArrayList<Byte> disposeKuriagari(int[]value){
        //value[1]~value[end]の繰り上がり処理
        /*int*/ oldf=0;/*int*/ newf=0;/*int*/ kuriagari=0;/*boolean*/ fChanged=false;
        for(/*int*/ d=value.length-1;d>=1;d--){
            fChanged=kuriagari!=0;
            oldf=value[d]+kuriagari;
            newf=oldf;
            kuriagari=0;
            if(oldf>=10){
                fChanged=true;
                kuriagari=oldf/10; newf=oldf-kuriagari*10;
            }
            if(fChanged) {value[d]=newf;}
        }

        int mostleft=value[0]+kuriagari;

        //value[0]=mostleftの繰り上がり処理
        ArrayList<Integer> overleft=new ArrayList<>();
        if(mostleft>=10){
            kuriagari=mostleft/10; newf=mostleft-kuriagari*10;
            mostleft=newf;

            //overleftの繰り上がり処理
            while(kuriagari>=10){
                oldf=kuriagari;
                kuriagari=oldf/10;newf=oldf-kuriagari*10;
                overleft.set(0,newf);
            }
            overleft.add(0,kuriagari);
        }

        // - overleft[begin]~[end] - mostleft - value[1]~[end] - の順番となっている
        ArrayList<Byte> bytes=new ArrayList<>();
        for(Integer i:overleft)bytes.add(i.byteValue());
        bytes.add((byte) mostleft);
        for(d=1;d<value.length;d++)bytes.add((byte) value[d]);
        return bytes;
    }

}
