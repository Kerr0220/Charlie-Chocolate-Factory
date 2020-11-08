package team.charliechocolatefactory.machine.specified;

import team.charliechocolatefactory.machine.functiondetail.TransportMachine;

/**
 * @author Yuan.Cai
 * @project chocolateFactory
 * @classname CommercialVehicle
 * @description TODO
 * @date 2020/11/8 19:54
 */
public class Van extends TransportMachine {
    public Van(String type, String machineNum)
    {
        super(type,machineNum,15,0.8,150);
    }

    public Van(String type, String machineNum, double age)
    {
        super(type,machineNum,age,15,0.8,150);
    }
}
