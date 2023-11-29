import java.awt.*;
import java.awt.event.*;

class MyCanvas extends Canvas implements MouseListener, MouseMotionListener{
    int x, y;
    int px, py;
    int xx, yy;
    int ow, oh;
    int red, green, blue;
    int width  = 700, height = 600;
    int mode;
    Image img = null;
    Graphics gc = null;
    Dimension d;
    SmpScrollbar ss;

    MyCanvas(DrawingApp obj){
        mode = 0;
        this.setSize(width, height);
        addMouseListener(this);
        addMouseMotionListener(this);
    }

    public void update(Graphics g){
        paint(g);
    }
    
    public void paint(Graphics g){
        d = getSize();
        if(img == null){
            img = createImage(d.width, d.height);
        }
        if(gc == null){
            gc = img.getGraphics();
        }

        switch(mode){
            case 1:
                gc.drawLine(px, py, x, y);
                break;
            case 2:
                gc.drawLine(px, py, x, y);
                break;
            case 3:
                gc.drawRect(px, py, ow, oh);
                break;
            case 4:
                gc.fillRect(px, py, ow, oh);
                break;
            case 5:
                gc.drawOval(px, py, ow, oh);
                break;
            case 6:
                gc.fillOval(px, py, ow, oh);
                break;
            case 7:
                gc.setColor(Color.white);
                gc.clearRect(x, y, px, py);
                break;
            case 8:
                gc.setColor(new Color(red, green, blue));
                break;
        }

        g.drawImage(img, 0, 0, this);
    }

    public void mouseClicked(MouseEvent e){
        switch(mode){
            case 7:
                x = 0;
                y = 0;
                px = 700;
                py = 600;
                repaint();
                break;
            case 8:
                SmpScrollbar ss = new SmpScrollbar();
                ss.setVisible(true);

                red = ss.red;
                green = ss.green;
                blue = ss.blue;
                break;
        }
    }
    public void mouseEntered(MouseEvent e){}
    public void mouseExited(MouseEvent e){}
    public void mousePressed(MouseEvent e){
        switch(mode){
            case 1:
                x = e.getX();
                y = e.getY();
                break;
            case 2:
            case 3:
            case 4:
            case 5:
            case 6:
                px = e.getX();
                py = e.getY();
                break;
        }
    }
    public void mouseReleased(MouseEvent e){
        switch(mode){
            case 2:
                x = e.getX();
                y = e.getY();
                /*if(px>x && py<y){
                    xx = x;
                    x = px;
                    px = xx;
                }*/
                repaint();
                break;
            case 3:
            case 4:
            case 5:
            case 6:
                x = e.getX();
                y = e.getY();
                if(px > x){
                    xx = x;
                    x = px;
                    px = xx;
                }
                ow = x-px;
                if(py > y){
                    yy = y;
                    y = py;
                    py = yy;
                }
                oh = y-py;
                repaint();
                break;
        }
    }

    public void mouseDragged(MouseEvent e){
        switch(mode){
            case 1:
            px = x;
            py = y;
            x = e.getX();
            y = e.getY();
            repaint();
            break;
        }
    }
    public void mouseMoved(MouseEvent e){}
}
