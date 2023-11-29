import java.awt.*;
import java.awt.event.*;

public class SmpScrollbar extends Frame implements AdjustmentListener{
    Label lb1, lb2, lb3, lb4;
    Scrollbar sbar1, sbar2, sbar3, sbar4;
    String s1 = "", s2 = "";
    int red = 0, green = 0, blue = 0;
    Panel p_north = new Panel();

    SmpScrollbar(){
        super("Widget Test");
        this.setSize(400, 400);

        this.setLayout(new BorderLayout());
        p_north.setLayout(new GridLayout(8,1));

        lb1 = new Label("value", Label.CENTER);
        p_north.add(lb1);

        sbar1 = new Scrollbar(Scrollbar.HORIZONTAL, 50, 10, 0, 200);
        sbar1.addAdjustmentListener(this);
        p_north.add(sbar1);

        lb2 = new Label("red", Label.CENTER);
        p_north.add(lb2);

        sbar2 = new Scrollbar(Scrollbar.HORIZONTAL, 0, 1, 0, 256);
        sbar2.addAdjustmentListener(this);
        p_north.add(sbar2);

        lb3 = new Label("green", Label.CENTER);
        p_north.add(lb3);

        sbar3 = new Scrollbar(Scrollbar.HORIZONTAL, 0, 1, 0, 256);
        sbar3.addAdjustmentListener(this);
        p_north.add(sbar3);

        lb4 = new Label("blue", Label.CENTER);
        p_north.add(lb4);

        sbar4 = new Scrollbar(Scrollbar.HORIZONTAL, 0, 1, 0, 256);
        sbar4.addAdjustmentListener(this);
        p_north.add(sbar4);

        this.add(p_north, BorderLayout.NORTH);

        this.setVisible(true);
    }

    public void adjustmentValueChanged(AdjustmentEvent e){
        Scrollbar sbar = (Scrollbar)e.getAdjustable();
        if(sbar == sbar1){
            s1 = "value of scrollbar1 : " + sbar1.getValue();
        }
        if(sbar == sbar2 || sbar == sbar3 || sbar == sbar4){
            red = sbar2.getValue();
            green = sbar3.getValue();
            blue = sbar4.getValue();
            s2 = "Red : " + red + "Green : " + green + "Blue : " + blue;
        }
        repaint();
    }

    public void paint(Graphics g){
        g.setColor(new Color(red, green, blue));
        g.fillRect(10, 100, getSize().width=20, getSize().height-160);

        g.setColor(Color.BLACK);
        g.drawString(s1, 10, getSize().height-20);
        g.drawString(s2, 10, getSize().height-35);
    }
}
