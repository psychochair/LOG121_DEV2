package devoir2b;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

public class DefaultMediator implements Mediator, ActionListener {

    private ArrayList<JToggleButton> liste = new ArrayList<>();
    private boolean maxNumberReached = false;

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
            if(maxNumberReached){
                abstractButton.setSelected(false);
            }else{
                maxNumberReached = true;
            }

        }else{
            maxNumberReached = false    ;
        }
    }
}