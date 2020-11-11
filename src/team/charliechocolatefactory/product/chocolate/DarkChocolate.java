package team.charliechocolatefactory.product.chocolate;

import team.charliechocolatefactory.rawmaterial.CocoaBean;
import team.charliechocolatefactory.rawmaterial.Water;
import team.charliechocolatefactory.scene.Scene;

/**
 * @author Kerr
 * @project chocolateFactory
 * @classname DarkChocolate
 * @description this is dark chocolate
 * @date 2020/11/8 15:15
 */
public class DarkChocolate extends Chocolate{

// constructor
    /**
     * @param loc
     */
    public DarkChocolate( Scene loc) {
        super("Dark chocolate", loc, 18,10, 0.78);
        this.initIngredientList();
    }

    /**
     * initialize the ingredient list of dark chocolate.
     */
    @Override
    protected void initIngredientList() {
        super.ingredientList.add(new CocoaBean());
        super.ingredientList.add(new Water());
    }

    /**
     * override the toString method
     * @return
     */
    @Override
    public String toString(){
        return "subclass : DarkChocolate";
    }
}
