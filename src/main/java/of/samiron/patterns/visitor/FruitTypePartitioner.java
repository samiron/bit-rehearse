package of.samiron.patterns.visitor;

/**
 * Created by samir on 4/9/2017.
 */
public class FruitTypePartitioner extends FruitPartitioner {

    @Override
    public void visit(Apple a) {
        this.apples.add(a);
    }

    @Override
    public void visit(Orange a) {
        this.oranges.add(a);
    }

    @Override
    public void visit(Banana a) {
        this.bananas.add(a);
    }
}
