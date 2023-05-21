import java.awt.*;
import java.awt.event.*;
class MyCalc implements ActionListener,WindowListener
{
        String op1,op2,op;
        Frame f;
        Button b[];
        Label l;
        Panel p;
        int k;
        MyCalc()
        {
            int i;
            f=new Frame();
            b=new Button[17];
            l=new Label("0");
            l.setFont(new Font("Forte",1,24));
            p=new Panel();
            p.setLayout(new GridLayout(4,4));
            for(i=0;i<10;i++)
            {
                b[i]=new Button(""+i);
                b[i].addActionListener(this);
                p.add(b[i]);
            }
            b[10]=new Button("+");
            b[11]=new Button("-");
            b[12]=new Button("*");
            b[13]=new Button("/");
            b[14]=new Button("=");
            b[15]=new Button("OFF");
            b[16]=new Button("clear");
            b[16].addActionListener(this);
                for(i=10;i<16;i++)
                {
                    b[i].addActionListener(this);
                    p.add(b[i]);
                }
                f.add(l,BorderLayout.NORTH);
                f.add(p);
                f.addWindowListener(this);
                f.add(b[16],BorderLayout.SOUTH);
                f.setVisible(true);
                f.setSize(300,300);
            }
        public static void main(String[] args)
            {
                MyCalc c=new MyCalc();
            }
        public void actionPerformed(ActionEvent e)
            {
                Button bt=(Button)e.getSource();
                if(bt==b[0]||bt==b[1]||bt==b[2]||bt==b[3]||bt==b[4])
                {//operands
                    if(k==0)
                    {
                        l.setText(bt.getLabel());
                        k=1;
                    }
                    else
                    l.setText(l.getText()+bt.getLabel());   
                }
                if(bt==b[5]||bt==b[6]||bt==b[7]||bt==b[8]||bt==b[9])
                {//operands
                    if(k==0)
                    {
                        l.setText(bt.getLabel());
                        k=1;
                    }
                    else
                    l.setText(l.getText()+bt.getLabel());   
                }
                if(bt==b[10]||bt==b[11]||bt==b[12]||bt==b[13])
                {//Operators
                    op=bt.getLabel();
                    op1=l.getText();
                    k=0;
                }
                if(bt==b[14])
                {//Equals
                    op2=l.getText();
                    calc();
                }
                if(bt==b[15])
                {//Enable Disable
                    String s=bt.getLabel();
                    if(s.equals("OFF"))
                    {
                        for(int i=0;i<15;i++)
                        b[i].setEnabled(false);
                        bt.setLabel("ON");
                    }
                    else
                    {
                        for(int i=0;i<15;i++)
                        b[i].setEnabled(true);
                        bt.setLabel("OFF");
                    }
                } 
                if(bt==b[16])
                {
                    //BAckspace
                    String s=l.getText();
                    if(s.length()==1)
                    {
                        l.setText("0");
                        k=0;
                    }
                    if(s.length()>1)
                    {
                        s=s.substring(0,s.length()-1);
                        l.setText(s);
                    }
                }
            }
        void calc()
            {
                float a,b,c;
                a=Float.parseFloat(op1);
                b=Float.parseFloat(op2);
                if(op.equals("+"))
                    c=a+b;
                else if(op.equals("-"))
                    c=a-b;
                else if(op.equals("*"))
                    c=a*b;
                else
                    c=a/b;
                l.setText(""+c);
            }
            public void windowClosing(WindowEvent e)
            {
                f.dispose();
            }
            
        public void windowOpened(WindowEvent e)
            {
                
            }
            
        public void windowClosed(WindowEvent e)
            {

            }
            
        public void windowIconified(WindowEvent e)
            {

            }
            
        public void windowDeiconified(WindowEvent e)
            {

            }
            
        public void windowActivated(WindowEvent e)
            {

            }
            
        public void windowDeactivated(WindowEvent e)
            {

            }
}