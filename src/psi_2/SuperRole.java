package psi_2;

//Rolių(bent vienos) funkcionalumas turi būti toks,
//kad jo realizavimas reikalautų tiesioginės sąveikos su
//pagrindinės esybės objektu -žr. 2 pavyzdį.

public class SuperRole extends RoleDecorator {
    public SuperRole(Worker decoratedWorker) {
        super(decoratedWorker);
    }

    @Override
    public String work() {
        return super.decoratedWorker.work() + super.separator + "SUPER_ROLE";
    }

    public float salary() {
        Worker worker = this.decoratedWorker;
        while (hasRoles(worker)) {
            RoleDecorator decorator = (RoleDecorator) worker;
            worker = decorator.decoratedWorker;
        }
        return super.decoratedWorker.salary() + worker.salary() * 10;
    }

    @Override
    public String subjects() {
        return super.decoratedWorker.subjects() + super.separator + "SUPER_SUBJECT";
    }

}
