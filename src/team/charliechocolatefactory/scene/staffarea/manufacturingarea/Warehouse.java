package team.charliechocolatefactory.scene.staffarea.manufacturingarea;

import org.omg.Messaging.SyncScopeHelper;
import team.charliechocolatefactory.person.staff.Manager;
import team.charliechocolatefactory.person.staff.worker.utilityworker.UtilityWorker;

import javax.swing.plaf.synth.SynthSpinnerUI;
import java.util.HashMap;

/**
 * @author Y.C.Young
 * @project chocolateFactory
 * @classname Warehouse
 * @description Warehouse for storing raw material and production
 * @date 2020/11/9 20:04
 */
public class Warehouse extends ManufacturingArea {

    protected HashMap<String, Double> materialAmount;
    protected HashMap<String, Integer> productionAmount;

    public Warehouse(String location, double cost, double area) {
        this(location, cost, area, null);
    }

    public Warehouse(String location, double cost, double area, Manager newManager) {
        super(location, cost, area, newManager);
        materialAmount = new HashMap<String, Double>();
        productionAmount = new HashMap<String, Integer>();
    }

    /**
     * @return name of the scene as a String
     */
    @Override
    public String toString() {
        return "warehouse";
    }


    /**
     * when other class needs to use material, the method will be invoked to modify amount of the material
     *
     * @param type   type of the material to be used (String)
     * @param amount amount of the material needed (Double)
     */
    public void useMaterial(String type, Double amount) {
        if (!materialAmount.containsKey(type)) {
            System.out.println("There is no such kind material");
        } else if (materialAmount.get(type) < amount) {
            System.out.println("Amount of the material is not enough");
        } else {
            materialAmount.put(type, materialAmount.get(type) - amount);
        }
    }

    /**
     * add the amount of material
     *
     * @param type   type of the material to be added (String)
     * @param amount amount of the material added (Double)
     */
    public void addMaterial(String type, Double amount) {
        if (materialAmount.containsKey(type)) {
            materialAmount.put(type, amount + materialAmount.get(type));
        } else {
            System.out.println("The kind doesn't exist");
        }
    }

    /**
     * create a new kind of material in the warehouse
     *
     * @param kind new kind of material
     */
    public void createMaterialKind(String kind) {
        if (materialAmount.containsKey(kind)) {
            System.out.println("The kind exists.");
        } else {
            materialAmount.put(kind, 0.0);
        }
    }

    /**
     * get the amount of each kind of material
     *
     * @return the map shows the amount of each kind of material
     */
    public HashMap<String, Double> getMaterialList() {
        return new HashMap<String, Double>(materialAmount);
    }

    /**
     * Visitor Pattern: accept a utility worker to maintenance the scene
     *
     * @param worker the utility worker
     */
    @Override
    public void accept(UtilityWorker worker) {
        worker.visit(this);
    }

}
