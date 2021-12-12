package of.samiron.patterns.visitor;

/**
 * Created by samir on 4/9/2017.
 */
public class Banana extends Fruit{
    public Banana(String s) {
        super(s);
    }

    @Override
    public void accept(FruitPartitioner partitioner) {
        partitioner.visit(this);
    }
}
