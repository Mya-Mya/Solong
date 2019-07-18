package countr;

public class EnableMode implements CountrStrategy {
    int counter;
    public EnableMode(){
        disposeReset();
    }
    @Override
    public void disposeIncrease() {
        counter++;
    }

    @Override
    public int getCounter() {
        return counter;
    }

    @Override
    public void disposeReset() {
        counter=0;
    }
}
