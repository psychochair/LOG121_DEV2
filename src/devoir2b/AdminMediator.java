package devoir2b;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

public class AdminMediator implements Mediator, ActionListener {

    private ArrayList<JToggleButton> liste = new ArrayList<>();
    private int toggledButtons = 0;

    public final int MAX = 10;

    @Override
    public void addButton(JToggleButton button) {
        liste.add(button);
        button.addActionListener(this);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        AbstractButton abstractButton = (AbstractButton) e.getSource();
        boolean selected = abstractButton.getModel().isSelected();

        if(selected){
            toggledButtons++;

            if(toggledButtons > MAX){
                abstractButton.setSelected(false);
                toggledButtons--;
            }

        }else{
            toggledButtons--;
        }
    }
}
