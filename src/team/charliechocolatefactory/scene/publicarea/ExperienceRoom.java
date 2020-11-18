package team.charliechocolatefactory.scene.publicarea;

import team.charliechocolatefactory.supplement.HandmadeTool;
import team.charliechocolatefactory.supplement.HandmadeToolFactory;

/**
 * @author Ngae Zeh-ghau
 * @project chocolateFactory
 * @classname ExperienceRoom
 * @description Designed for visitors to experience making chocolate.
 * @date 2020/11/18 10:13
 */
public class ExperienceRoom extends PublicArea {

    private HandmadeTool tool = HandmadeToolFactory.getHandMadeTool();

    /**
     * constructor of ExperienceRoom
     */
    public ExperienceRoom(String location, double cost, double area, int maxNumber) {
        super(location, cost, area, maxNumber);
    }

    /**
     * @return the tool
     */
    public HandmadeTool getTool() {
        return tool;
    }

    /**
     * Get description of tool in this room.
     * 
     * @return description
     */
    public String getToolDescription() {
        return tool.getDescription();
    }

    /**
     * Set description of tool in this room. This is a part of COW pattern.
     * 
     * @return description
     */
    public void setToolDescription(String description) {
        if (tool.getRefCount() > 1 || tool == HandmadeToolFactory.getDefaultHandmadeTool()) {
            tool.deref();
            tool = new HandmadeTool(tool);
        }
        tool.setDescription(description);
    }

    /**
     * Tests of COW pattern.
     */
    public static void main(String[] args) {
        // HandmadeToolFactory.reset();

        ExperienceRoom[] rooms = new ExperienceRoom[3];

        // The following lines should print one line of "New Handmade Tool!".
        for (int i = 0; i < rooms.length; i++) {
            rooms[i] = new ExperienceRoom("10" + Integer.toString(i + 1), 1, 1, 1);
        }
        // The following line should print "true".
        System.out.println(rooms[0].getTool() == rooms[1].getTool());
        // The following line should print "Copy Handmade Tool!"
        rooms[1].setToolDescription("Tool in 102.");
        // The following line should print "false".
        System.out.println(rooms[0].getTool() == rooms[1].getTool());
        // The following line should print "true".
        System.out.println(rooms[0].getTool() == rooms[2].getTool());
        // The following lines should both print "Copy Handmade Tool!"
        rooms[0].setToolDescription("Tool in 101.");
        rooms[2].setToolDescription("Tool in 101.");
        // The following line should print 0.
        System.out.println(HandmadeToolFactory.getDefaultHandmadeTool().getRefCount());
    }

}
