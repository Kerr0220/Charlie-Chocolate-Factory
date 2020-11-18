package team.charliechocolatefactory.machine.milkchocproduction;

/**
 * @author Yuan.Cai
 * @project chocolateFactory
 * @classname ConcreteMilkMachine
 * @description This machine produces milk chocolate with CocoaBean=200, Sugar=10, Milk=1.
 * @date 2020/11/14 17:53
 */
public class ConcreteMilkMachine1 extends MilkChocMachine{
    public ConcreteMilkMachine1()
    {
        this.setMachineNum("001");
    }

    @Override
    public void useCocoaBean() {
        milkChocolate.setCocoaBeanNum(200.0);
        System.out.println("Use cocoaBeanNum = 200.0\n");
    }

    @Override
    public void useSugar() {
        milkChocolate.setSugarNum(10.0);
        System.out.println("Use sugarNum = 10.0\n");
    }

    @Override
    public void useMilk() {
        milkChocolate.setMilkNum(1.0);
        System.out.println("Use milkNum = 1.0\n");
    }

    public String toString() {
        return "class ConcreteMilkMachine1 extends MilkChocMachine";
    }
}