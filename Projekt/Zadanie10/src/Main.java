import javax.swing.*;
import java.awt.event.*;
import java.awt.*;
import java.awt.geom.*;

class Cegielka extends Rectangle2D.Float{

    Cegielka(int x, int y){

        this.x = x;
        this.y = y;
        this.width = 60;
        this.height = 10;
    }


}

class Kulka extends Ellipse2D.Float
{
    Plansza p;
    int dx,dy;

    Kulka(Plansza p,int x,int y,int dx,int dy)
    {
        this.x=x;
        this.y=y;
        this.width=10;
        this.height=10;

        this.p=p;
        this.dx=dx;
        this.dy=dy;
    }

    void nextKrok()
    {
        x+=dx;
        y+=dy;

        if(getMinX()<0 || getMaxX()>p.getWidth())  dx=-dx;
        if(getMinY()<0 || getMaxY()>p.getHeight()) dy=-dy;

        p.repaint();
        Toolkit.getDefaultToolkit().sync();
    }
}

class SilnikKulki extends Thread
{
    Kulka a;
    Belka b;
    Cegielka[] cegielki;
    int points;
    JLabel score;
    SilnikKulki(Kulka a, Belka b, Cegielka[] cegielki, JLabel score)
    {
        this.a=a;
        this.b=b;
        this.cegielki=cegielki;
        this.score = score;
        start();
    }

    public void CheckCollisionSpod(Kulka a){
        if (a.getY() + a.height > 330){
            score.setText("Lose");
            stop();
        }
    }
    // cw 9.1
    public void CheckCollisionBelka(Kulka a, Belka b){

        if (a.intersects(b))
        {
            if (a.x < b.x){
                a.dx = -a.dx;
            }
            else if (a.x > b.x + b.width){
                a.dx = -a.dx;
            }
            else{
                // Przy kolizji zmieniamy kierunek kulki w gore
                a.dy = -a.dy;
            }
        }
    }


    public void CheckCollisionCegielki(Kulka a, Cegielka[] cegielki) {

        for (int i = 0; i < 16; i++) {
            if (a.intersects(cegielki[i])) {
                double overlapX = Math.min(a.getMaxX() - cegielki[i].getMinX(), cegielki[i].getMaxX() - a.getMinX());
                double overlapY = Math.min(a.getMaxY() - cegielki[i].getMinY(), cegielki[i].getMaxY() - a.getMinY());

                if (overlapX < overlapY) {
                    // Kolizja z bokiem cegielki - zmiana kierunku kulki w bok
                    a.dx = -a.dx;
                } else {
                    // Przy kolizji zmieniamy kierunek kulki w gore
                    a.dy = -a.dy;
                }

                // Usuwanie cegielki z ekranu
                cegielki[i].x = -50;
                cegielki[i].y = -50;

                // Zliczanie punktów
                points += 1;
                score.setText(String.valueOf(points));

                if (score.getText().equals("16")) {
                    score.setText("Winner!");
                    stop();
                }
            }
        }
    }


    public void run()
    {
        try
        {
            while(true)
            {
                a.nextKrok();
                CheckCollisionBelka(a, b);
                CheckCollisionCegielki(a, cegielki);
                CheckCollisionSpod(a);
                sleep(5); // frame cap

            }
        }
        catch(InterruptedException e){}
    }
}

class Belka extends Rectangle2D.Float
{
    Belka(int x)
    {
        this.x=x;
        this.y=270;
        this.width=60;
        this.height=10;
    }

    void setX(int x)
    {
        this.x=x;
    }
}

class Plansza extends JPanel implements MouseMotionListener
{
    Belka b;
    Kulka a;
    SilnikKulki s;
    Cegielka[] cegielki = new Cegielka[16]; // Lista instancji klasy Cegielka
    JLabel score = new JLabel("0");

    Plansza()
    {
        super();
        addMouseMotionListener(this);

        b=new Belka(200);
        a=new Kulka(this,200,200,1,1);

        // cw 9.2
        // Wypielnianie listy ciegielek nowymi instancjami
        for (int i = 0; i < 4; i++) {cegielki[i] = new Cegielka(50+i*70, 50);}
        for (int i = 4; i < 8; i++) {cegielki[i] = new Cegielka(50+(i-4)*70, 65);}
        for (int i = 8; i < 12; i++) {cegielki[i] = new Cegielka(50+(i-8)*70, 80);}
        for (int i = 12; i < 16; i++) {cegielki[i] = new Cegielka(50+(i-12)*70, 95);}

        // cw 9.3 Zlicznie punktow
        // Label na wynik
        //JLabel jlabel = new JLabel("Score: ");
        //jlabel.setFont(new Font("Verdana",1,20));
        //add(jlabel);

        // Zmieniajacy sie wynik
        score = new JLabel("0");
        score.setFont(new Font("Verdana", 1, 20));
        add(score);

        s=new SilnikKulki(a, b, cegielki, score);

    }

    public void paintComponent(Graphics g)
    {
        super.paintComponent(g);
        Graphics2D g2d=(Graphics2D)g;

        g2d.fill(a);
        g2d.fill(b);

        // Wypelnianie cegielek
        // Osobne kolory
        g2d.setColor(new Color(0, 0, 0));
        for (int i = 0; i < 4; i++){
            g2d.fill(cegielki[i]);
        }
        g2d.setColor(new Color(51, 51, 51));
        for (int i = 4; i < 8; i++){
            g2d.fill(cegielki[i]);
        }

        g2d.setColor(new Color(110, 110, 110));
        for (int i = 8; i < 12; i++){
            g2d.fill(cegielki[i]);
        }

        g2d.setColor(new Color(154, 154, 154));
        for (int i = 12; i < 16; i++){
            g2d.fill(cegielki[i]);
        }
    }

    public void mouseMoved(MouseEvent e)
    {
        b.setX(e.getX()-50);
        repaint();
    }

    public void mouseDragged(MouseEvent e)
    {

    }
}

class Program {
    public static void main(String[] args) {
        javax.swing.SwingUtilities.invokeLater(new Runnable() {
            public void run() {
                utworzOkno();
            }
        });
    }

    private static void utworzOkno() {
        JFrame jf = new JFrame("Arkanoid");
        jf.setSize(400, 370);
        jf.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        JMenuBar menuBar = new JMenuBar();
        JMenu menu = new JMenu("Menu");
        JMenuItem nowaGra = new JMenuItem("Nowa Gra");
        JMenuItem zakoncz = new JMenuItem("Zakończ");

        nowaGra.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                rozpocznijGre();
            }
        });

        zakoncz.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                System.exit(0);
            }
        });

        menu.add(nowaGra);
        menu.add(zakoncz);
        menuBar.add(menu);

        jf.setJMenuBar(menuBar);

        jf.setVisible(true);
    }

    private static void rozpocznijGre() {
        Plansza p = new Plansza();
        JFrame jf = new JFrame();
        jf.add(p);

        jf.setTitle("Arkanoid");
        jf.setSize(400, 370);
        jf.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        jf.setVisible(true);
    }
}