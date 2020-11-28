package test.DesignPatternTest;


import team.charliechocolatefactory.scene.decorator.*;
import team.charliechocolatefactory.scene.publicarea.ExhibitionRoom;
import team.charliechocolatefactory.scene.publicarea.ExperienceRoom;
import team.charliechocolatefactory.scene.decorator.DecoratorComponent;
import java.util.Scanner;
/**
 * @author TT
 * @project chocolateFactory
 * @classname DecoratorTest
 * @description This is decorator test
 * @date 2020/11/24 19:55
 */
public class DecoratorTest {
    public static void main(String[] args){
        System.out.println("—————————————-------------------------------------———— Test[Decorator]Pattern —————————————-------------------------------------————");
        System.out.println("please choose the residence you want to build:");
        System.out.println("**              1 --- villa                 **");
        System.out.println("**              2 --- flat                  **");
        DecoratorComponent residence ;

        int i;
        while(true) {
            try {
                Scanner reader=new Scanner(System.in);
                i = reader.nextInt();
                if (i == 1) {
                    /**
                     * create a villa without decorations
                     */
                    residence = new Villa();
                    break;
                }
                else if (i == 2) {
                    /**
                     * create a flat without decorations
                     */
                    residence = new Flat();
                    break;
                }
                else{
                    System.out.println("Invalid Input, Please input again.\n");
                }
            } catch (Exception e) {
                System.out.print("Invalid Input, Please input again.\n");
            }
        }
        int fh=0;
        int cac=0;
        int m=0;
        while(true){
            try {
                System.out.println("--------------------Choose options------------------");
                System.out.println("**      1 --- Add an fire hydrant                 **");
                System.out.println("**      2 --- Add a central air condition         **");
                System.out.println("**      3 --- Add a monitor                       **");
                System.out.println("**      4 --- Show the current price of the house **");
                System.out.println("**      5 --- Exit                                **");
                System.out.println("----------------------------------------------------");
//                System.out.print("请选择操作[1 增加一个消防栓 | 2 增加一个中央空调 | 3 增加一个监视器 | 4 显示建筑当前造价 | 5 退出]");
                Scanner reader=new Scanner(System.in);
                i = reader.nextInt();

                if(i == 1){
                    /**
                     * add an fire hydrant
                     */
                    fh++;
                    residence = new FireHydrant(residence);
                }
                else if(i == 2){
                    /**
                     * add a central air condition
                     */
                    cac++;
                    residence = new CentralAirCondition(residence);
                }
                else if(i == 3){
                    /**
                     * add a monitor
                     */
                    m++;
                    residence = new Monitor(residence);
                }
                else if(i == 4){
                    /**
                     * show the current price of the house
                     */
                    System.out.print(residence.getDescription()+", with ");
                    if(fh>1){
                        System.out.print(fh+" fire hydrants");
                        if (cac>0)
                            System.out.print(", ");
                        if (cac==0&&m!=0)
                        {
                            System.out.print(", and ");
                        }
                        if (cac!=0&&m==0)
                        {
                            System.out.print("and ");
                        }
                    }

                    else if(fh==1){
                        System.out.print("1 fire hydrant");
                        if (cac>0)
                            System.out.print(", ");
                        if (cac==0&&m!=0)
                        {
                            System.out.print(", and ");
                        }
                        if (cac!=0&&m==0)
                        {
                            System.out.print("and ");
                        }
                    }

                    if(cac>1){
                        System.out.print(cac+" central air conditions");
                        if (m>0)
                        {
                            System.out.print(", and ");
                        }
                    }

                    else if(cac==1){
                        System.out.print("1 central air condition");
                        if (m>0)
                            System.out.print(", and ");
                    }

                    if(m>1)
                        System.out.print(m+" monitors");
                    else if(m==1)
                        System.out.print("1 monitor");

                    System.out.println(", the price is " + residence.getBuildCost());
                }
                else if(i == 5){
                    fh=0;
                    cac=0;
                    m=0;

                    break;
                }
                else{
                    System.out.print("Invalid Input, Please input again.\n");
                }
            } catch (Exception e) {
                System.out.print("Invalid Input, Please input again.\n");
            }
        }

//        //创建一个未加装饰地接待中心
//        Residence receptionCenter = new ReceptionCenter();
//        System.out.print(receptionCenter.getDescription());
//        System.out.println("，其价格为" + receptionCenter.getCost());
//        //给接待中心添加红外报警器
//        receptionCenter = new InfraredAlarm(receptionCenter);
//        System.out.print(receptionCenter.getDescription());
//        System.out.println("，其价格为" + receptionCenter.getCost() + '\n');
//
//
//        //创建一个未加装饰的豪宅
//        Residence villa = new Villa();
//        System.out.print(villa.getDescription());
//        System.out.println("，其价格为" + villa.getCost());
//        //给豪宅添加中央空调
//        villa = new CentralAirCondition(villa);
//        //给豪宅添加监视器
//        villa = new Monitor(villa);
//        System.out.print(villa.getDescription());
//        System.out.println("，其价格为" + villa.getCost() + '\n');
//        System.out.println("---------------------------------");

        System.out.println("—————————————---------------------------------------------- End ————------—————————-------------------------------------————");
    }
}