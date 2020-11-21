package team.charliechocolatefactory.scene.staffarea.manufacturingarea.AssemblyLine;

import team.charliechocolatefactory.product.chocolate.Chocolate;
import team.charliechocolatefactory.product.chocolate.MilkChocolate;

/**
 * @author Zeus Lee
 * @project chocolateFactory
 * @classname MilkChocolateFactory
 * @description TODO
 * @date 2020/11/15 16:46
 */
public class MilkChocolateAssemblyLine extends ChocolatesMachineAssemblyLine {

    /**
     * Specific return, milk chocolate factory can only return milk chocolate
     * @return  MilkChocolate;
     */
    @Override
    public Chocolate getChocolate() {
        return new MilkChocolate();
    }
}
