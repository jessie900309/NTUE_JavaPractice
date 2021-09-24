import java.awt.*;
import java.awt.event.*;
public class calculate_window extends Frame implements ActionListener{
    static calculate_window Window = new calculate_window();
    private static Panel ShowBlock=new Panel(new GridLayout(1,1));
    private static Panel ResultBlock =new Panel(new GridLayout(1,1));
    private static Panel LastBlock=new Panel(new GridLayout(1,1));
    private static Panel FuncBlock =new Panel(new GridLayout(4,1));
    private static Panel BtnBlock =new Panel(new GridLayout(4,3));
    //基本數字按鈕
    static Button btn_0 = new Button("0");
    static Button btn_1 = new Button("1");
    static Button btn_2 = new Button("2");
    static Button btn_3 = new Button("3");
    static Button btn_4 = new Button("4");
    static Button btn_5 = new Button("5");
    static Button btn_6 = new Button("6");
    static Button btn_7 = new Button("7");
    static Button btn_8 = new Button("8");
    static Button btn_9 = new Button("9");
    static Button btn_float = new Button(".");
    static Button btn_clean = new Button("c");
    //基本運算按鈕
    private static int funct;
    static Button btn_add = new Button("+");
    static Button btn_subtract = new Button("-");
    static Button btn_multiply = new Button("×");
    static Button btn_divide = new Button("÷");
    //結果顯示欄位
    private static boolean hasUsed = false;
    private static boolean floatUsed = false;
    private static int floatCount = 1;
    private static double Lastresult = 0;
    private static double result = 0;
    private static double Number1 = 0;
    private static double Number2 = 0;
    private static Label ANS = new Label(Double.toString(result),Label.RIGHT);
    private static Label LastANS = new Label(" last answer : "+Lastresult,Label.LEFT);
    static Button btn_result = new Button("=");
    //主函式
    public static void main(String arg[]){
        //視窗狀態
        Window.setVisible(true);
        Window.setLocation(200,100);
        Window.setSize(350,500);
        Window.setBackground(new Color(255,245,238));
        Window.setResizable(false);
        Window.setLayout(null);
        Window.addWindowListener(new WindowAdapter() {
            @Override
            public void windowClosing(WindowEvent e) {
                System.exit(0);
            }
        });
        //按鈕設計
        btn_add.setBackground(new Color(255, 255, 224));
        btn_subtract.setBackground(new Color(255, 255, 224));
        btn_multiply.setBackground(new Color(255, 255, 224));
        btn_divide.setBackground(new Color(255, 255, 224));
        btn_result.setBackground(new Color(255, 239, 219));
        btn_9.setBackground(new Color(255, 228, 225));
        btn_8.setBackground(new Color(255, 228, 225));
        btn_7.setBackground(new Color(255, 228, 225));
        btn_6.setBackground(new Color(255,193,193));
        btn_5.setBackground(new Color(255,193,193));
        btn_4.setBackground(new Color(255,193,193));
        btn_3.setBackground(new Color(238, 180, 180));
        btn_2.setBackground(new Color(238, 180, 180));
        btn_1.setBackground(new Color(238, 180, 180));
        btn_0.setBackground(new Color(205, 155, 155));
        btn_float.setBackground(new Color(205, 155, 155));
        btn_clean.setBackground(new Color(205, 155, 155));
        //版面配置_ShowBlock顯示結果
        ShowBlock.setBounds(20,40,310,50);
        ShowBlock.setBackground(new Color(250, 219, 237));
        ShowBlock.add(ANS);
        //版面配置_基本數字
        BtnBlock.setBounds(20,95,250,300);
        BtnBlock.add(btn_9);BtnBlock.add(btn_8);BtnBlock.add(btn_7);
        BtnBlock.add(btn_6);BtnBlock.add(btn_5);BtnBlock.add(btn_4);
        BtnBlock.add(btn_3);BtnBlock.add(btn_2);BtnBlock.add(btn_1);
        BtnBlock.add(btn_clean);BtnBlock.add(btn_0);BtnBlock.add(btn_float);
        //版面配置_運算符號
        FuncBlock.setBounds(270,95,60,300);
        FuncBlock.add(btn_add);FuncBlock.add(btn_subtract);
        FuncBlock.add(btn_multiply);FuncBlock.add(btn_divide);
        //版面配置_等於
        ResultBlock.setBounds(20,400,310,30);
        ResultBlock.add(btn_result);
        //版面配置_紀錄
        LastBlock.setBounds(20,440,310,30);
        LastBlock.setBackground(new Color(255, 250, 150));
        LastBlock.add(LastANS);
        //事件監聽
        btn_0.addActionListener(Window);
        btn_1.addActionListener(Window);
        btn_2.addActionListener(Window);
        btn_3.addActionListener(Window);
        btn_4.addActionListener(Window);
        btn_5.addActionListener(Window);
        btn_6.addActionListener(Window);
        btn_7.addActionListener(Window);
        btn_8.addActionListener(Window);
        btn_9.addActionListener(Window);
        btn_float.addActionListener(Window);
        btn_result.addActionListener(Window);
        btn_add.addActionListener(Window);
        btn_subtract.addActionListener(Window);
        btn_multiply.addActionListener(Window);
        btn_divide.addActionListener(Window);
        btn_clean.addActionListener(Window);
        //最終顯示
        Window.add(ShowBlock);
        Window.add(BtnBlock);
        Window.add(FuncBlock);
        Window.add(ResultBlock);
        Window.add(LastBlock);
    }
    //按鈕觸發動作
    @Override
    public void actionPerformed(ActionEvent e)
            throws NumberFormatException,ArithmeticException {
        Button btnState = (Button) e.getSource();
        //清除上一輪的結果
        if(hasUsed) {
            Lastresult = result;
            LastANS.setText(" last answer : "+Lastresult);
            Number1 = Number2 = result = funct = 0;
            floatCount = 1;
            hasUsed = floatUsed = false;
            ANS.setText(Double.toString(0));
        }
        //紀錄按下的按鈕
        try{
            //歸0
            if(btnState==btn_clean){
                Number1 = Number2 = result = funct = 0;
                floatCount = 1;
                hasUsed = floatUsed = false;
                ANS.setText(Double.toString(0));
            }
            //按下運算符號後先存第一個數字
            else if(btnState==btn_add){
                funct=1;
                save_Num1();
            }
            else if(btnState==btn_subtract){
                funct=2;
                save_Num1();
            }
            else if(btnState==btn_multiply){
                funct=3;
                save_Num1();
            }
            else if(btnState==btn_divide){
                funct=4;
                save_Num1();
            }
            else if(btnState == btn_result){
                //存第二個數字
                save_Num2 ();
                //運算並輸出結果
                switch(funct){
                    case 1: result = Number1 + Number2;break;
                    case 2: result = Number1 - Number2;break;
                    case 3: result = Number1 * Number2;break;
                    case 4: result = Number1 / Number2;break;
                    default: //啥都不做
                }
                ANS.setText(Double.toString(result));
                hasUsed = true;
            }
            //數字處理
            if(floatUsed){
                if(btnState == btn_0) printFloat(btn_0);
                else if(btnState == btn_1) printFloat(btn_1);
                else if(btnState == btn_2) printFloat(btn_2);
                else if(btnState == btn_3) printFloat(btn_3);
                else if(btnState == btn_4) printFloat(btn_4);
                else if(btnState == btn_5) printFloat(btn_5);
                else if(btnState == btn_6) printFloat(btn_6);
                else if(btnState == btn_7) printFloat(btn_7);
                else if(btnState == btn_8) printFloat(btn_8);
                else if(btnState == btn_9) printFloat(btn_9);
                else if(btnState == btn_float){}
            }
            else {
                if(btnState == btn_0) printMath(btn_0);
                else if(btnState == btn_1) printMath(btn_1);
                else if(btnState == btn_2) printMath(btn_2);
                else if(btnState == btn_3) printMath(btn_3);
                else if(btnState == btn_4) printMath(btn_4);
                else if(btnState == btn_5) printMath(btn_5);
                else if(btnState == btn_6) printMath(btn_6);
                else if(btnState == btn_7) printMath(btn_7);
                else if(btnState == btn_8) printMath(btn_8);
                else if(btnState == btn_9) printMath(btn_9);
                //第一次按下小數點
                else if(btnState == btn_float){
                    floatUsed = true;
                    ANS.setText(Double.toString(result));
                    // Debug
                    // System.out.println("Now result = "+result);
                }
            }
        }
        //捕捉例外並歸零
        catch(NumberFormatException OAO){
            ANS.setText("Error");
            System.out.println(OAO);
            Number1 = Number2 = result = funct = 0;
            hasUsed = false;
        }
        catch(ArithmeticException OHO){
            ANS.setText("ERROR : 被除數不能為0");
            System.out.println(OHO);
            Number1 = Number2 = result = funct = 0;
            hasUsed = false;
        }
    }
    //紀錄數字(組合數字)並顯示
    private void printMath(Button btnState){
        if(result==0) ANS.setText(btnState.getLabel());
        else ANS.setText(Double.toString(Double.parseDouble(ANS.getText()+btnState.getLabel())));
        result = Double.parseDouble(ANS.getText());
        System.out.println("Now result = "+result);
    }
    private void printFloat(Button btnState){
        double floatNum = Double.parseDouble(btnState.getLabel());
        for (int i=0; i<floatCount; i++){
            floatNum = floatNum*0.1;
        }floatCount++;
        result = result + floatNum;
        ANS.setText(Double.toString(result));
    }
    //按完運算符號把第一組數值儲存起來
    private void save_Num1 (){
        Number1 = Double.parseDouble(ANS.getText());
        ANS.setText(Double.toString(0)); result = 0;
        floatUsed = false;
    }
    //按完等號把第二組數值儲存起來
    private void save_Num2 (){
        Number2 = Double.parseDouble(ANS.getText());
        floatUsed = false;
    }
}
