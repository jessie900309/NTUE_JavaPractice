/*
H7_111016029.java
(1) 作者姓名及學號. 若參考他人程式改寫, 請加註原創者姓名及學號
    作者姓名：許晉綸
    作者學號：111016029
    是否原創：是

(2) 程式執行時的操作說明
    ※注意 -- 編譯時請使用UTF-8或Big-5，若出現無法編譯之情形請自行處理特殊字元※
    Window小算盤程式
    包含數字0~9、小數點、正負號
    加、減、乘、除、次方、根號、絕對值、倒數、百分比、等於 
    清空鍵、回車鍵
    以及數值計算結果及前兩則計算歷史
    

(3) 符合的評分標準及自評應得的分數, 注意: 評分時會參考此資訊, 請仔細正確填寫
    程式有意義且可以執行 -- +20%
    支援整數運算 -- +30%
    支援小數運算 -- +25%
    包含所有功能 -- +25%
    程式檔案遵照規定命名
    主程式開始包含作者、操作說明及符合的評分標準等資訊
    有適當註解
    應拿100%

(4) 若參考他人程式, 請說明不同的地方或增加的功能
    無

(5) 其他有利於評分的說明, 例如獨特的功能等
    即時顯示運算結果
    支援括號輸入支援正負數
    支援鍵盤輸入算式(直接按鍵盤不須點擊文本框)
    支援文本框輸入算式
*/
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.util.Stack;

public class H7_111016029 {
    public static void main(String[] args) throws ClassNotFoundException,InstantiationException,IllegalAccessException,UnsupportedLookAndFeelException{
        UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());    //引入系統UI
        new calculatorApplication().load(); //載入
    }
}

class calculatorApplication extends JFrame {    //建立框架
    void load() {   //載入
        this.frameInitialization();     //框架初始化
        this.appAreaInitialization();   //面板初始化
    }

    void frameInitialization() {    //框架初始化
        calculatorApplication.setDefaultLookAndFeelDecorated(true);     //設定最大化按鈕功能
        this.setVisible(true);                                          //設為可見
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);            //設定關閉按鈕功能
        this.setBounds(480,270,420,600);                                //設定初始框架大小即啟動位置
        this.setMinimumSize(new Dimension(420,600));                    //設定框架最小大小
        this.setTitle("Calculator");                                    //設定標題名稱
        this.add(appArea);                                              //加入面板
    }

    void appAreaInitialization() {      //面板初始化

        appArea.setLayout(appAreaLayout);   //設定面板管理器
        txtArea.setLayout(txtAreaLayout);
        btnArea.setLayout(btnAreaLayout);

        this.txtAreaInitialization();       //內部面板初始化
        this.btnAreaInitialization();

        appArea.addKeyListener(new keyBoardListener());     //加入鍵盤監聽
        txtArea.addKeyListener(new keyBoardListener());
        btnArea.addKeyListener(new keyBoardListener());

        btnArea.setFocusable(true);     //設定可獲取焦點
        btnArea.setFocusable(true);
        btnArea.setFocusable(true);

        appArea.requestFocus();     //獲取焦點
        txtArea.requestFocus();
        btnArea.requestFocus();

        appArea.add(txtArea);               //加入面板
        appArea.add(btnArea);
    }

    void txtAreaInitialization() {  //面板初始化

        history_1.setOpaque(false);     //將文字框設為透明
        history_2.setOpaque(false);
        operator.setOpaque(false);
        result.setOpaque(false);

        history_1.setHorizontalAlignment(JTextField.RIGHT);     //設定文字靠右顯示
        history_2.setHorizontalAlignment(JTextField.RIGHT);
        operator.setHorizontalAlignment(JTextField.RIGHT);
        result.setHorizontalAlignment(JTextField.RIGHT);

        history_1.setFont(historyFont);     //設定字型與顯示格式
        history_2.setFont(historyFont);
        operator.setFont(resultFont);
        result.setFont(resultFont);

        history_1.setEditable(false);       //設為不可編輯
        history_2.setEditable(false);
        result.setEditable(false);

        txtArea.add(history_2);             //將文字框加入面板
        txtArea.add(history_1);
        txtArea.add(operator);
        txtArea.add(result);

        operator.addActionListener(e -> {       //文字框事件監聽
            operator_str = operator.getText();
            computingModule();
            updateDisplay();
        });
        updateDisplay();
    }

    void  btnAreaInitialization() {     //面板初始化

        btnArea.add(pi);                //將按鈕加入面板
        btnArea.add(eulerNumber);
        btnArea.add(reset);
        btnArea.add(delete);
        btnArea.add(absVal);
        btnArea.add(percent);
        btnArea.add(square);
        btnArea.add(root);
        btnArea.add(fraction);
        btnArea.add(left_bracket);
        btnArea.add(right_bracket);
        btnArea.add(divided);
        btnArea.add(val_7);
        btnArea.add(val_8);
        btnArea.add(val_9);
        btnArea.add(times);
        btnArea.add(val_4);
        btnArea.add(val_5);
        btnArea.add(val_6);
        btnArea.add(minus);
        btnArea.add(val_1);
        btnArea.add(val_2);
        btnArea.add(val_3);
        btnArea.add(plus);
        btnArea.add(sign);
        btnArea.add(val_0);
        btnArea.add(point);
        btnArea.add(execute);

        pi.setFont(btnFont);                //設定字型與顯示格式
        eulerNumber.setFont(btnFont);
        reset.setFont(btnFont);
        delete.setFont(btnFont);
        percent.setFont(btnFont);
        absVal.setFont(btnFont);
        left_bracket.setFont(btnFont);
        right_bracket.setFont(btnFont);
        fraction.setFont(btnFont);
        square.setFont(btnFont);
        root.setFont(btnFont);
        divided.setFont(btnFont);
        times.setFont(btnFont);
        minus.setFont(btnFont);
        plus.setFont(btnFont);
        sign.setFont(btnFont);
        point.setFont(btnFont);
        execute.setFont(btnFont);
        val_0.setFont(btnFont);
        val_1.setFont(btnFont);
        val_2.setFont(btnFont);
        val_3.setFont(btnFont);
        val_4.setFont(btnFont);
        val_5.setFont(btnFont);
        val_6.setFont(btnFont);
        val_7.setFont(btnFont);
        val_8.setFont(btnFont);
        val_9.setFont(btnFont);

        pi.addActionListener(btnListener);              //設定按鈕事件監聽
        eulerNumber.addActionListener(btnListener);
        reset.addActionListener(btnListener);
        delete.addActionListener(btnListener);
        percent.addActionListener(btnListener);
        absVal.addActionListener(btnListener);
        square.addActionListener(btnListener);
        root.addActionListener(btnListener);
        fraction.addActionListener(btnListener);
        left_bracket.addActionListener(btnListener);
        right_bracket.addActionListener(btnListener);
        divided.addActionListener(btnListener);
        times.addActionListener(btnListener);
        minus.addActionListener(btnListener);
        plus.addActionListener(btnListener);
        sign.addActionListener(btnListener);
        point.addActionListener(btnListener);
        execute.addActionListener(btnListener);
        val_0.addActionListener(btnListener);
        val_1.addActionListener(btnListener);
        val_2.addActionListener(btnListener);
        val_3.addActionListener(btnListener);
        val_4.addActionListener(btnListener);
        val_5.addActionListener(btnListener);
        val_6.addActionListener(btnListener);
        val_7.addActionListener(btnListener);
        val_8.addActionListener(btnListener);
        val_9.addActionListener(btnListener);
    }

    class btnListener implements ActionListener {   //建立按鈕事件監聽類別
        @Override
        public void actionPerformed (ActionEvent e) {           //須計算之按鈕
            if (e.getSource() == pi) {                          //pi
                operator_str += "p";
            } else if (e.getSource() == eulerNumber) {          //尤拉數
                operator_str += "e";
            } else if (e.getSource() == reset) {                //Clear
                operator_str = "0";
                result_str = "0";
                result_double = 0;
            } else if (e.getSource() == delete) {               //回車鍵
                operator_str = operator_str.replaceFirst(".$","");
            } else if (e.getSource() == left_bracket) {         //左括號
                operator_str += "(";
            } else if (e.getSource() == right_bracket) {        //右括號
                operator_str += ")";
            } else if (e.getSource() == square) {               //次方
                operator_str += "^";
            } else if (e.getSource() == root) {                 //根號
                operator_str += "r";
            } else if (e.getSource() == divided) {              //除號
                operator_str += "/";
            } else if (e.getSource() == times) {                //乘號
                operator_str += "*";
            } else if (e.getSource() == minus) {                //減號
                operator_str += "-";
            } else if (e.getSource() == plus) {                 //加號
                operator_str += "+";
            } else if (e.getSource() == sign) {                 //正負號
                operator_str += "~";
            } else if (e.getSource() == execute) {              //等於
                history_2.setText(history_1.getText());
                history_1.setText(operator_str+" = "+result_str);
                operator_str = "0";
                result_str = "0";
            } else if (e.getSource() == point) {                //小數點
                operator_str += ".";
            } else if (e.getSource() == val_0) {                //數字0~9
                operator_str += "0";
            } else if (e.getSource() == val_1) {
                operator_str += "1";
            } else if (e.getSource() == val_2) {
                operator_str += "2";
            } else if (e.getSource() == val_3) {
                operator_str += "3";
            } else if (e.getSource() == val_4) {
                operator_str += "4";
            } else if (e.getSource() == val_5) {
                operator_str += "5";
            } else if (e.getSource() == val_6) {
                operator_str += "6";
            } else if (e.getSource() == val_7) {
                operator_str += "7";
            } else if (e.getSource() == val_8) {
                operator_str += "8";
            } else if (e.getSource() == val_9) {
                operator_str += "9";
            }
            if (operator_str.length() >1 && operator_str.startsWith("0") && operator_str.charAt(1) != '.') {     //空字串顯示
                operator_str = operator_str.substring(1);
            }
            computingModule();      //計算模塊
            if (e.getSource() == fraction) {                                    //倒數
                history_2.setText(history_1.getText());
                history_1.setText(operator_str + " = " + result_str);
                result_double = 1.0/result_double;
                operator_str = Double.toString(result_double);
                result_str = operator_str;
            } else if (e.getSource() == absVal) {                               //絕對值
                history_2.setText(history_1.getText());
                history_1.setText(operator_str + " = " + result_str);
                if (result_double < 0) {        //判斷正負
                    result_double *= -1;
                    operator_str = Double.toString(result_double);
                    result_str = operator_str;
                }
            } else if (e.getSource() == percent) {                              //百分比
                history_2.setText(history_1.getText());
                history_1.setText(operator_str + " = " + result_str);
                result_double = result_double / 100.0;
                operator_str = Double.toString(result_double);
                result_str = operator_str;
            }
            updateDisplay();        //更新顯示
            appArea.requestFocus(); //將焦點返還
            txtArea.requestFocus();
            btnArea.requestFocus();
        }
    }

    class keyBoardListener extends KeyAdapter {     //鍵盤監聽
        @Override
        public void keyPressed(KeyEvent e){
            if (e.getKeyCode() == KeyEvent.VK_BACK_SPACE) {
                operator_str = operator_str.replaceFirst(".$","");
            } else if (e.getKeyCode() == '(' || e.getKeyCode() == KeyEvent.VK_RIGHT_PARENTHESIS || (e.getModifiers() == 1 && e.getKeyCode() == 57)) {   //左括號
                operator_str += "(";
            } else if (e.getKeyCode() == ')' || e.getKeyCode() == KeyEvent.VK_LEFT_PARENTHESIS || (e.getModifiers() == 1 && e.getKeyCode() == 48)) {    //右括號
                operator_str += ")";
            } else if (e.getKeyCode() == '^' || e.getKeyCode() == KeyEvent.VK_CIRCUMFLEX || (e.getModifiers() == 1 && e.getKeyCode() == 54)) {      //次方
                operator_str += "^";
            } else if (e.getKeyCode() == 'r' || e.getKeyCode() == KeyEvent.VK_R) {      //根號
                operator_str += "r";
            } else if (e.getKeyCode() == '/' || e.getKeyCode() == KeyEvent.VK_SLASH) {      //除
                operator_str += "/";
            } else if (e.getKeyCode() == '*' || e.getKeyCode() == KeyEvent.VK_ASTERISK || (e.getModifiers() == 1 && e.getKeyCode() == 56)) {        //乘
                operator_str += "*";
            } else if (e.getKeyCode() == '-' || e.getKeyCode() == KeyEvent.VK_MINUS) {      //減
                operator_str += "-";
            } else if (e.getKeyCode() == '+' || e.getKeyCode() == KeyEvent.VK_PLUS || (e.getModifiers() == 1 && e.getKeyCode() == 61)) {        //加
                operator_str += "+";
            } else if (e.getKeyCode() == '~' || e.getKeyCode() == KeyEvent.VK_DEAD_TILDE) {     //負號
                operator_str += "~";
            } else if (e.getKeyCode() == KeyEvent.VK_ENTER) {       //回車
                history_2.setText(history_1.getText());
                history_1.setText(operator_str+" = "+result_str);
                operator_str = "0";
                result_str = "0";
            } else if (e.getKeyChar() == '.' || e.getKeyCode() == KeyEvent.VK_PERIOD) {     //小數點
                operator_str += ".";
            } else if ((e.getKeyChar() == '0' || e.getKeyCode() == KeyEvent.VK_0) && e.getModifiers() == 0 ) {      //數字
                operator_str += "0";
            } else if ((e.getKeyChar() == '1' || e.getKeyCode() == KeyEvent.VK_1) && e.getModifiers() == 0 ) {
                operator_str += "1";
            } else if ((e.getKeyChar() == '2' || e.getKeyCode() == KeyEvent.VK_2) && e.getModifiers() == 0 ) {
                operator_str += "2";
            } else if ((e.getKeyChar() == '3' || e.getKeyCode() == KeyEvent.VK_3) && e.getModifiers() == 0 ) {
                operator_str += "3";
            } else if ((e.getKeyChar() == '4' || e.getKeyCode() == KeyEvent.VK_4) && e.getModifiers() == 0 ) {
                operator_str += "4";
            } else if ((e.getKeyChar() == '5' || e.getKeyCode() == KeyEvent.VK_5) && e.getModifiers() == 0 ) {
                operator_str += "5";
            } else if ((e.getKeyChar() == '6' || e.getKeyCode() == KeyEvent.VK_6) && e.getModifiers() == 0 ) {
                operator_str += "6";
            } else if ((e.getKeyChar() == '7' || e.getKeyCode() == KeyEvent.VK_7) && e.getModifiers() == 0 ) {
                operator_str += "7";
            } else if ((e.getKeyChar() == '8' || e.getKeyCode() == KeyEvent.VK_8 && e.getModifiers() == 0 )) {
                operator_str += "8";
            } else if ((e.getKeyChar() == '9' || e.getKeyCode() == KeyEvent.VK_9 && e.getModifiers() == 0 )) {
                operator_str += "9";
            }
            if (operator_str.length() >1 && operator_str.startsWith("0") && operator_str.charAt(1) != '.') {
                operator_str = operator_str.substring(1);
            }
            computingModule();      //計算模塊
            updateDisplay();        //更新顯示
        }
    }

    void computingModule() {        //計算模塊
        boolean unKnowChar = false;
        String tOperator_str = String.copyValueOf(operator_str.toCharArray());  //操作用變數
        StringBuilder postOperator = new StringBuilder();                       //後序表示式儲存點
        Stack<Character> oprTmp = new Stack<>();                                //符號棧

        try {   //中序轉後序
            //原則:棧內小於棧外壓棧，其餘出棧
            for (int i = 0, m = tOperator_str.length(); i < m; i++) {   //讀取中序式
                if (tOperator_str.charAt(i) == '(') {           //左括號
                    oprTmp.push(tOperator_str.charAt(i));
                } else if (tOperator_str.charAt(i) == ')') {    //右括號
                    postOperator.append(" ");
                    while (oprTmp.peek() != '(' && !oprTmp.isEmpty()) {     //出棧
                        postOperator.append(oprTmp.pop());
                        postOperator.append(" ");
                    }
                    oprTmp.pop();   //壓棧


                } else if (tOperator_str.charAt(i) == '+' || tOperator_str.charAt(i) == '-') {      //加減號
                    postOperator.append(" ");
                    while (!oprTmp.isEmpty()) {         //出棧
                        if (oprTmp.peek() == '(') {
                            break;
                        } else {
                            postOperator.append(oprTmp.pop());
                            postOperator.append(" ");
                        }
                    }
                    oprTmp.push(tOperator_str.charAt(i));       //壓棧

                } else if (tOperator_str.charAt(i) == '*' || tOperator_str.charAt(i) == '/') {      //乘除號
                    postOperator.append(" ");
                    while (!oprTmp.isEmpty()) {         //出棧
                        if (oprTmp.peek() == '+' || oprTmp.peek() == '-' || oprTmp.peek() == '(') {
                            break;
                        } else {
                            postOperator.append(oprTmp.pop());
                            postOperator.append(" ");
                        }
                    }
                    oprTmp.push(tOperator_str.charAt(i));       //壓棧

                } else if (tOperator_str.charAt(i) == 'r') {        //根號
                    postOperator.append(" ");
                    while (!oprTmp.isEmpty()) {     //出棧
                        if (oprTmp.peek() == 'r' || oprTmp.peek() == 's') {
                            postOperator.append(oprTmp.pop());
                            postOperator.append(" ");
                        } else {
                            break;
                        }
                    }
                    oprTmp.push(tOperator_str.charAt(i));       //壓棧

                } else if (tOperator_str.charAt(i) == '^') {        //次方
                    postOperator.append(" ");
                    oprTmp.push(tOperator_str.charAt(i));       //優先度最高直接壓棧

                } else if (tOperator_str.charAt(i) == '0' ||
                        tOperator_str.charAt(i) == '1' ||
                        tOperator_str.charAt(i) == '2' ||
                        tOperator_str.charAt(i) == '3' ||
                        tOperator_str.charAt(i) == '4' ||
                        tOperator_str.charAt(i) == '5' ||
                        tOperator_str.charAt(i) == '6' ||
                        tOperator_str.charAt(i) == '7' ||
                        tOperator_str.charAt(i) == '8' ||
                        tOperator_str.charAt(i) == '9' ||
                        tOperator_str.charAt(i) == '~' ||
                        tOperator_str.charAt(i) == 'e' ||
                        tOperator_str.charAt(i) == 'p' ||
                        tOperator_str.charAt(i) == '.') {       //數字
                    postOperator.append(tOperator_str.charAt(i));       //壓棧

                } else {
                    unKnowChar = true;
                }
            }
            postOperator.append(" ");
            while (!oprTmp.isEmpty()) {     //輸出符號棧
                postOperator.append(oprTmp.pop());
                postOperator.append(" ");
            }
        } catch (Exception e) {
            System.out.println("Error:"+e.getMessage());
        }

        String[] postTmp;       //後序表示式拆分儲存點
        Stack<Double> valTmp = new Stack<>();       //數字棧

        postOperator = new StringBuilder(postOperator.toString().replaceAll("  ", " "));        //空格處理，多空格改為單空格以方便拆分
        if (postOperator.toString().startsWith(" ")) {                                          //移除前後空格
            postOperator = new StringBuilder(postOperator.substring(1));
        }
        if (postOperator.toString().endsWith(" ")) {
            postOperator = new StringBuilder(postOperator.toString().replaceFirst(".$", ""));
        }
        postTmp = postOperator.toString().split(" ");       //拆分表示式

        try {       //運算
            //原則:數字壓棧，遇到符號依據幾元出棧計算，將結果放回棧內
            for (int i = 0, m = postTmp.length; i < m; i++) {   //讀取後序拆分

                if ((postTmp[i].charAt(0) >= '0' && postTmp[i].charAt(0) <= '9')) {     //數字
                    valTmp.push(Double.parseDouble(postTmp[i]));

                } else if (postTmp[i].charAt(0) == '~') {       //負號
                    postTmp[i] = "-" + postTmp[i].substring(1);
                    valTmp.push(Double.parseDouble(postTmp[i]));
                } else if (postTmp[i].equals("e")) {        //由拉數
                    valTmp.push(E);
                } else if (postTmp[i].equals("p")) {        //pi
                    valTmp.push(PI);
                } else {        //運算符
                    double v1, v2, v3;
                    if (postTmp[i].equals("+")) {       //加
                        v2 = valTmp.pop();
                        v1 = valTmp.pop();
                        v3 = v1 + v2;
                        valTmp.push(v3);
                    } else if (postTmp[i].equals("-")) {    //減
                        v2 = valTmp.pop();
                        v1 = valTmp.pop();
                        v3 = v1 - v2;
                        valTmp.push(v3);
                    } else if (postTmp[i].equals("*")) {    //乘
                        v2 = valTmp.pop();
                        v1 = valTmp.pop();
                        v3 = v1 * v2;
                        valTmp.push(v3);
                    } else if (postTmp[i].equals("/")) {    //除
                        v2 = valTmp.pop();
                        v1 = valTmp.pop();
                        v3 = v1 / v2;
                        valTmp.push(v3);
                    } else if (postTmp[i].equals("^")) {    //次方
                        v2 = valTmp.pop();
                        v1 = valTmp.pop();
                        v3 = Math.pow(v1, v2);
                        valTmp.push(v3);
                    } else if (postTmp[i].equals("r")) {    //根號
                        v1 = valTmp.pop();
                        v3 = Math.sqrt(v1);
                        valTmp.push(v3);
                    }
                }
            }
            result_double = valTmp.pop();   //結果
        } catch (Exception e) {
            System.out.println("Error:"+e.getMessage());
        }
        if (valTmp.isEmpty()) {     //將結果輸出
            result_str = Double.toString(result_double);
        } else {        //運算元與運算子數目不符
            result_str = "NaN";
        }
    }
    void updateDisplay() {      //更新顯示
        if(operator_str.isEmpty()||operator_str.equals("0")) operator.setText("0");
        else {
            String tmp = String.copyValueOf(operator_str.toCharArray());
            tmp = tmp.replaceAll("~","-");
            tmp = tmp.replaceAll("p","π");
            tmp = tmp.replaceAll("r","√");
            operator.setText(tmp);
        }
        result.setText("= "+result_str);
    }
    //物件建立
    String operator_str = "0";                              //中序運算式儲存點
    String result_str = "0";                                //結果儲存點
    double result_double = 0;
    final double PI = 3.14159265;                           //pi
    final double E  = 2.71828183;                           //尤拉數

    JPanel appArea = new JPanel(true);                      //主面板
    JPanel btnArea = new JPanel(true);                      //按鈕面板
    JPanel txtArea = new JPanel(true);                      //文字框面板

    GridLayout appAreaLayout = new GridLayout(2,1);         //主面板管理器
    GridLayout btnAreaLayout = new GridLayout(7,4);         //按鈕面板管理器
    GridLayout txtAreaLayout = new GridLayout(4,1);         //文字框面板管理器

    btnListener btnListener = new btnListener();            //按鈕監聽器
    Font btnFont = new Font("Calibri",Font.PLAIN,24);       //按鈕字型與顯示格式
    JButton percent = new JButton("%");                     //按鈕
    JButton pi = new JButton("pi");
    JButton eulerNumber = new JButton("e");
    JButton reset = new JButton("C");
    JButton delete = new JButton("Back");
    JButton square = new JButton("^");
    JButton fraction = new JButton("1/X");
    JButton absVal = new JButton("|X|");
    JButton left_bracket = new JButton("(");
    JButton right_bracket = new JButton(")");
    JButton root = new JButton("root");
    JButton plus = new JButton("+");
    JButton minus = new JButton("-");
    JButton times = new JButton("*");
    JButton divided = new JButton("/");
    JButton sign = new JButton("+/-");
    JButton point = new JButton(".");
    JButton val_1 = new JButton("1");
    JButton val_2 = new JButton("2");
    JButton val_3 = new JButton("3");
    JButton val_4 = new JButton("4");
    JButton val_5 = new JButton("5");
    JButton val_6 = new JButton("6");
    JButton val_7 = new JButton("7");
    JButton val_8 = new JButton("8");
    JButton val_9 = new JButton("9");
    JButton val_0 = new JButton("0");
    JButton execute = new JButton("=");
    
    Font resultFont = new Font("Calibri",Font.BOLD,20);     //結果字型與顯示格式
    Font historyFont = new Font("Calibri",Font.PLAIN,20);   //歷史紀錄字型與顯示格式
    JTextField history_1 = new JTextField();                //文字框
    JTextField history_2 = new JTextField();
    JTextField operator = new JTextField();
    JTextField result = new JTextField();
}