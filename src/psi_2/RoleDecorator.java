package psi_2;

abstract public class RoleDecorator implements Worker {
    protected Worker decoratedWorker;
    protected String separator = " | ";

    public RoleDecorator(Worker decoratedWorker) {
        this.decoratedWorker = decoratedWorker;
    }

    public void setDecoratedWorker (Worker decoratedWorker) {
        this.decoratedWorker = decoratedWorker;
    }

    public String work() {
        return decoratedWorker.work();
    }

    public float workTime() {
        return decoratedWorker.salary();
    }

    public String subjects() {
        return decoratedWorker.subjects();
    }

    public static boolean hasRoles(Worker worker) {
        if (worker instanceof RoleDecorator)
            return true;
        else return false;
    }

    public static Worker getRole(Worker worker, String role) {
        Worker currentWorker = worker;
        while(hasRoles(currentWorker)){
            RoleDecorator decorator = (RoleDecorator) currentWorker;
            if (decorator.getClass().getSimpleName().compareTo(role) == 0) {
                return currentWorker;

            } else {
                currentWorker = decorator.decoratedWorker;
            }
        }       
        return worker;
    }

    public static Worker removeRole(Worker worker, String role) {
        Worker currentWorker = worker;
        Worker resultWorker = currentWorker;
        Worker pastWorker = null;
        while(hasRoles(currentWorker)){
            RoleDecorator decorator = (RoleDecorator) currentWorker;             
            if (decorator.getClass().getSimpleName().compareTo(role) == 0) {
                if (pastWorker == null) {
                    pastWorker = null;
                    currentWorker = decorator.decoratedWorker;
                    resultWorker = currentWorker;
                } else {
                    RoleDecorator pastDecorator = (RoleDecorator) pastWorker;
                    pastDecorator.setDecoratedWorker(decorator.decoratedWorker);    
                    currentWorker = decorator.decoratedWorker;
                }
            } else {
                pastWorker = currentWorker;
                currentWorker = decorator.decoratedWorker;
            }              
        }
        worker = resultWorker;
        return resultWorker;
    }

    public static RoleDecorator removeRole(RoleDecorator decorator, String role) {
        RoleDecorator currentDecorator = decorator;
        RoleDecorator resultDecorator = currentDecorator;
        RoleDecorator pastDecorator = null;
        while(currentDecorator != null){
            if (currentDecorator.getClass().getSimpleName().compareTo(role) == 0) {
                if (pastDecorator == null) {
                    if (currentDecorator.decoratedWorker instanceof RoleDecorator) {
                        currentDecorator = (RoleDecorator) currentDecorator.decoratedWorker;
                    } else {
                        currentDecorator = null;
                    }
                    pastDecorator = null;
                    resultDecorator = currentDecorator;
                } else {
                    pastDecorator.setDecoratedWorker(decorator.decoratedWorker);
                    if (currentDecorator.decoratedWorker instanceof RoleDecorator) {
                        pastDecorator = currentDecorator;
                        currentDecorator = (RoleDecorator) currentDecorator.decoratedWorker;
                    } else {
                        currentDecorator = null;
                        resultDecorator = currentDecorator;
                    }    
                }
            } else {
                if (currentDecorator.decoratedWorker instanceof RoleDecorator) {
                    pastDecorator = currentDecorator;
                    currentDecorator = (RoleDecorator) currentDecorator.decoratedWorker;
                } else {
                    currentDecorator = null;
                }
            }
        }
        return resultDecorator;
    }
}