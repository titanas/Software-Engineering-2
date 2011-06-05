package psi_2;

public class Analyst extends RoleDecorator {
    public Analyst(Worker decoratedWorker) {
        super(decoratedWorker);
    }

    @Override
    public String work() {
        return super.decoratedWorker.work() + super.separator + "TESTAVIMAS";
    }

    public float salary() {
        return super.decoratedWorker.salary() + 450.0f;
    }

    @Override
    public String subjects() {
        return super.decoratedWorker.subjects() + super.separator + "SERFITIKATAS";
    }
}