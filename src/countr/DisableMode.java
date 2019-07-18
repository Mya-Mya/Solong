package countr;

public class DisableMode implements CountrStrategy {
    @Override
    public void disposeIncrease() {

    }

    @Override
    public int getCounter() {
        return 0;
    }

    @Override
    public void disposeReset() {

    }
}
