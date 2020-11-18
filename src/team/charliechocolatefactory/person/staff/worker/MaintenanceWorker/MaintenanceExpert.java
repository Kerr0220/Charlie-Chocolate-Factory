package team.charliechocolatefactory.person.staff.worker.MaintenanceWorker;

import team.charliechocolatefactory.person.Person;
import team.charliechocolatefactory.scene.staffarea.StaffArea;

/**
 * @author Zheng
 * @project chocolateFactory
 * @classname MaintenanceExpert
 * @description the Concrete Handler of Chain of Responsibility
 * @date 2020/11/14 19:16
 */
public class MaintenanceExpert extends MaintenanceWorker{
    public MaintenanceExpert(String name, int age, Person.Sex sex, int salary, StaffArea department) {
        super(name, age, sex, salary, department);
    }

    @Override
    public void work() {
        System.out.println("The maintenance expert" + this.name + "is working.");
    }

    @Override
    public void rest() {
        System.out.println("The maintenance expert" + this.name + "goes to rest.");
    }


    public boolean handleRequest(double attritionRate) {
        if (attritionRate <= 1.0) {
            work();
            return true;
        } else {
            if (getNext() != null) {
                if (getNext().handleRequest(attritionRate)) {
                    return true;
                } else {
                    return false;
                }
            } else {
                System.out.println("This machine is broken! Cannot be repaired!");
                return false;
            }
        }
    }
}