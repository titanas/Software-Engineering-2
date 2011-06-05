package psi_2;

public class Designer extends RoleDecorator {

    public Designer(Worker decoratedWorker) {
        super(decoratedWorker);
    }
    @Override
    public String work() {
        return super.decoratedWorker.work() + super.separator + "PROJEKTAVIMAS";
    }

    public float salary() {
        return super.decoratedWorker.salary() + 350.0f;
    }

    @Override
    public String subjects() {
        return super.decoratedWorker.subjects() + super.separator + "UML";
    }
}