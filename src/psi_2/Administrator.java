package psi_2;

public class Administrator extends RoleDecorator {
    
    public Administrator(Worker decoratedWorker) {
        super(decoratedWorker);
    }

    @Override
    public String work() {
        return super.decoratedWorker.work() + super.separator + "PRIEŽIŪRA";
    }

    public float salary() {
        return super.decoratedWorker.salary() + 250.0f;
    }

    @Override
    public String subjects() {
        return super.decoratedWorker.subjects() + super.separator + "ADMIN_KURSAI";
    }
}