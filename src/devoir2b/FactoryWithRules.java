package devoir2b;

import javax.swing.*;

public class FactoryWithRules implements Factory {

    private Rules rules;
    private Mediator m;

    public FactoryWithRules(Rules rules){
        this.rules = rules;
        if(rules.ordinal() == 1){
            m = new AdminMediator();
        }else{
            m = new DefaultMediator();
        }
    }

    @Override
    public AbstractButton[][] createButtons() {
        AbstractButton grid[][] = new AbstractButton[NUM_ROW][NUM_COLUMN];


        for (int i = 0; i < NUM_COLUMN; i++) {
                ButtonGroup col = new ButtonGroup();

            for (int j = 0; j < NUM_ROW; j++) {
                JToggleButton button = new JToggleButton();

                m.addButton(button);    //mediator setup

                if(rules.ordinal() == 0){
                    col.add(button);    //default rules setup
                }

                grid[j][i] = button;    //addition to view
            }
        }
        return grid;
    }

}
