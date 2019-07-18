package countr;

import java.util.*;

public class Countr {
    private static Countr ourInstance = new Countr();
    public static Countr inst() {
        return ourInstance;
    }

    private CountrStrategy currentMode;
    private CountrStrategy enableMode=new EnableMode();
    private CountrStrategy disableMode=new DisableMode();
    private List<String> comments=new ArrayList<>();
    private Countr() {
        setEnable(true);
        currentMode.disposeReset();
    }
    public void increase(){
        currentMode.disposeIncrease();
    }
    public void addComment(String comment){
        StringBuilder sb=new StringBuilder();
        sb.append(currentMode.getCounter());
        sb.append(":");
        sb.append(comment);
        comments.add(sb.toString());
    }

    public void show(){
        StringBuilder sb=new StringBuilder();
        sb.append("---start---\n");
        for(String c:comments){
            sb.append(c);
            sb.append("\n");
        }
        sb.append(currentMode.getCounter());
        sb.append("\n");
        sb.append("---end---\n");

        System.out.println(sb.toString());
    }
    public void reset(){
        currentMode.disposeReset();
        comments.clear();
    }
    public void setEnable(boolean countable){
        currentMode=countable?enableMode:disableMode;
    }
}
