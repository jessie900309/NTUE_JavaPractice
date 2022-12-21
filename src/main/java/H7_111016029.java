/*
H7_111016029.java
(1) �@�̩m�W�ξǸ�. �Y�ѦҥL�H�{����g, �Х[����Ъ̩m�W�ξǸ�
    �@�̩m�W�G�\�ʺ�
    �@�̾Ǹ��G111016029
    �O�_��СG�O

(2) �{������ɪ��ާ@����
    ���`�N -- �sĶ�ɽШϥ�UTF-8��Big-5�A�Y�X�{�L�k�sĶ�����νЦۦ�B�z�S��r����
    Window�p��L�{��
    �]�t�Ʀr0~9�B�p���I�B���t��
    �[�B��B���B���B����B�ڸ��B����ȡB�˼ơB�ʤ���B���� 
    �M����B�^����
    �H�μƭȭp�⵲�G�Ϋe��h�p����v
    

(3) �ŦX�������зǤΦ۵����o������, �`�N: �����ɷ|�ѦҦ���T, �ХJ�ӥ��T��g
    �{�����N�q�B�i�H���� -- +20%
    �䴩��ƹB�� -- +30%
    �䴩�p�ƹB�� -- +25%
    �]�t�Ҧ��\�� -- +25%
    �{���ɮ׿�ӳW�w�R�W
    �D�{���}�l�]�t�@�̡B�ާ@�����βŦX�������зǵ���T
    ���A�����
    ����100%

(4) �Y�ѦҥL�H�{��, �л������P���a��μW�[���\��
    �L

(5) ��L���Q�����������, �Ҧp�W�S���\�൥
    �Y����ܹB�⵲�G
    �䴩�A����J�䴩���t��
    �䴩��L��J�⦡(��������L�����I���奻��)
    �䴩�奻�ؿ�J�⦡
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
        UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());    //�ޤJ�t��UI
        new calculatorApplication().load(); //���J
    }
}

class calculatorApplication extends JFrame {    //�إ߮ج[
    void load() {   //���J
        this.frameInitialization();     //�ج[��l��
        this.appAreaInitialization();   //���O��l��
    }

    void frameInitialization() {    //�ج[��l��
        calculatorApplication.setDefaultLookAndFeelDecorated(true);     //�]�w�̤j�ƫ��s�\��
        this.setVisible(true);                                          //�]���i��
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);            //�]�w�������s�\��
        this.setBounds(480,270,420,600);                                //�]�w��l�ج[�j�p�Y�Ұʦ�m
        this.setMinimumSize(new Dimension(420,600));                    //�]�w�ج[�̤p�j�p
        this.setTitle("Calculator");                                    //�]�w���D�W��
        this.add(appArea);                                              //�[�J���O
    }

    void appAreaInitialization() {      //���O��l��

        appArea.setLayout(appAreaLayout);   //�]�w���O�޲z��
        txtArea.setLayout(txtAreaLayout);
        btnArea.setLayout(btnAreaLayout);

        this.txtAreaInitialization();       //�������O��l��
        this.btnAreaInitialization();

        appArea.addKeyListener(new keyBoardListener());     //�[�J��L��ť
        txtArea.addKeyListener(new keyBoardListener());
        btnArea.addKeyListener(new keyBoardListener());

        btnArea.setFocusable(true);     //�]�w�i����J�I
        btnArea.setFocusable(true);
        btnArea.setFocusable(true);

        appArea.requestFocus();     //����J�I
        txtArea.requestFocus();
        btnArea.requestFocus();

        appArea.add(txtArea);               //�[�J���O
        appArea.add(btnArea);
    }

    void txtAreaInitialization() {  //���O��l��

        history_1.setOpaque(false);     //�N��r�س]���z��
        history_2.setOpaque(false);
        operator.setOpaque(false);
        result.setOpaque(false);

        history_1.setHorizontalAlignment(JTextField.RIGHT);     //�]�w��r�a�k���
        history_2.setHorizontalAlignment(JTextField.RIGHT);
        operator.setHorizontalAlignment(JTextField.RIGHT);
        result.setHorizontalAlignment(JTextField.RIGHT);

        history_1.setFont(historyFont);     //�]�w�r���P��ܮ榡
        history_2.setFont(historyFont);
        operator.setFont(resultFont);
        result.setFont(resultFont);

        history_1.setEditable(false);       //�]�����i�s��
        history_2.setEditable(false);
        result.setEditable(false);

        txtArea.add(history_2);             //�N��r�إ[�J���O
        txtArea.add(history_1);
        txtArea.add(operator);
        txtArea.add(result);

        operator.addActionListener(e -> {       //��r�بƥ��ť
            operator_str = operator.getText();
            computingModule();
            updateDisplay();
        });
        updateDisplay();
    }

    void  btnAreaInitialization() {     //���O��l��

        btnArea.add(pi);                //�N���s�[�J���O
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

        pi.setFont(btnFont);                //�]�w�r���P��ܮ榡
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

        pi.addActionListener(btnListener);              //�]�w���s�ƥ��ť
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

    class btnListener implements ActionListener {   //�إ߫��s�ƥ��ť���O
        @Override
        public void actionPerformed (ActionEvent e) {           //���p�⤧���s
            if (e.getSource() == pi) {                          //pi
                operator_str += "p";
            } else if (e.getSource() == eulerNumber) {          //�שԼ�
                operator_str += "e";
            } else if (e.getSource() == reset) {                //Clear
                operator_str = "0";
                result_str = "0";
                result_double = 0;
            } else if (e.getSource() == delete) {               //�^����
                operator_str = operator_str.replaceFirst(".$","");
            } else if (e.getSource() == left_bracket) {         //���A��
                operator_str += "(";
            } else if (e.getSource() == right_bracket) {        //�k�A��
                operator_str += ")";
            } else if (e.getSource() == square) {               //����
                operator_str += "^";
            } else if (e.getSource() == root) {                 //�ڸ�
                operator_str += "r";
            } else if (e.getSource() == divided) {              //����
                operator_str += "/";
            } else if (e.getSource() == times) {                //����
                operator_str += "*";
            } else if (e.getSource() == minus) {                //�
                operator_str += "-";
            } else if (e.getSource() == plus) {                 //�[��
                operator_str += "+";
            } else if (e.getSource() == sign) {                 //���t��
                operator_str += "~";
            } else if (e.getSource() == execute) {              //����
                history_2.setText(history_1.getText());
                history_1.setText(operator_str+" = "+result_str);
                operator_str = "0";
                result_str = "0";
            } else if (e.getSource() == point) {                //�p���I
                operator_str += ".";
            } else if (e.getSource() == val_0) {                //�Ʀr0~9
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
            if (operator_str.length() >1 && operator_str.startsWith("0") && operator_str.charAt(1) != '.') {     //�Ŧr�����
                operator_str = operator_str.substring(1);
            }
            computingModule();      //�p��Ҷ�
            if (e.getSource() == fraction) {                                    //�˼�
                history_2.setText(history_1.getText());
                history_1.setText(operator_str + " = " + result_str);
                result_double = 1.0/result_double;
                operator_str = Double.toString(result_double);
                result_str = operator_str;
            } else if (e.getSource() == absVal) {                               //�����
                history_2.setText(history_1.getText());
                history_1.setText(operator_str + " = " + result_str);
                if (result_double < 0) {        //�P�_���t
                    result_double *= -1;
                    operator_str = Double.toString(result_double);
                    result_str = operator_str;
                }
            } else if (e.getSource() == percent) {                              //�ʤ���
                history_2.setText(history_1.getText());
                history_1.setText(operator_str + " = " + result_str);
                result_double = result_double / 100.0;
                operator_str = Double.toString(result_double);
                result_str = operator_str;
            }
            updateDisplay();        //��s���
            appArea.requestFocus(); //�N�J�I����
            txtArea.requestFocus();
            btnArea.requestFocus();
        }
    }

    class keyBoardListener extends KeyAdapter {     //��L��ť
        @Override
        public void keyPressed(KeyEvent e){
            if (e.getKeyCode() == KeyEvent.VK_BACK_SPACE) {
                operator_str = operator_str.replaceFirst(".$","");
            } else if (e.getKeyCode() == '(' || e.getKeyCode() == KeyEvent.VK_RIGHT_PARENTHESIS || (e.getModifiers() == 1 && e.getKeyCode() == 57)) {   //���A��
                operator_str += "(";
            } else if (e.getKeyCode() == ')' || e.getKeyCode() == KeyEvent.VK_LEFT_PARENTHESIS || (e.getModifiers() == 1 && e.getKeyCode() == 48)) {    //�k�A��
                operator_str += ")";
            } else if (e.getKeyCode() == '^' || e.getKeyCode() == KeyEvent.VK_CIRCUMFLEX || (e.getModifiers() == 1 && e.getKeyCode() == 54)) {      //����
                operator_str += "^";
            } else if (e.getKeyCode() == 'r' || e.getKeyCode() == KeyEvent.VK_R) {      //�ڸ�
                operator_str += "r";
            } else if (e.getKeyCode() == '/' || e.getKeyCode() == KeyEvent.VK_SLASH) {      //��
                operator_str += "/";
            } else if (e.getKeyCode() == '*' || e.getKeyCode() == KeyEvent.VK_ASTERISK || (e.getModifiers() == 1 && e.getKeyCode() == 56)) {        //��
                operator_str += "*";
            } else if (e.getKeyCode() == '-' || e.getKeyCode() == KeyEvent.VK_MINUS) {      //��
                operator_str += "-";
            } else if (e.getKeyCode() == '+' || e.getKeyCode() == KeyEvent.VK_PLUS || (e.getModifiers() == 1 && e.getKeyCode() == 61)) {        //�[
                operator_str += "+";
            } else if (e.getKeyCode() == '~' || e.getKeyCode() == KeyEvent.VK_DEAD_TILDE) {     //�t��
                operator_str += "~";
            } else if (e.getKeyCode() == KeyEvent.VK_ENTER) {       //�^��
                history_2.setText(history_1.getText());
                history_1.setText(operator_str+" = "+result_str);
                operator_str = "0";
                result_str = "0";
            } else if (e.getKeyChar() == '.' || e.getKeyCode() == KeyEvent.VK_PERIOD) {     //�p���I
                operator_str += ".";
            } else if ((e.getKeyChar() == '0' || e.getKeyCode() == KeyEvent.VK_0) && e.getModifiers() == 0 ) {      //�Ʀr
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
            computingModule();      //�p��Ҷ�
            updateDisplay();        //��s���
        }
    }

    void computingModule() {        //�p��Ҷ�
        boolean unKnowChar = false;
        String tOperator_str = String.copyValueOf(operator_str.toCharArray());  //�ާ@���ܼ�
        StringBuilder postOperator = new StringBuilder();                       //��Ǫ�ܦ��x�s�I
        Stack<Character> oprTmp = new Stack<>();                                //�Ÿ���

        try {   //��������
            //��h:�̤��p��̥~���̡A��l�X��
            for (int i = 0, m = tOperator_str.length(); i < m; i++) {   //Ū�����Ǧ�
                if (tOperator_str.charAt(i) == '(') {           //���A��
                    oprTmp.push(tOperator_str.charAt(i));
                } else if (tOperator_str.charAt(i) == ')') {    //�k�A��
                    postOperator.append(" ");
                    while (oprTmp.peek() != '(' && !oprTmp.isEmpty()) {     //�X��
                        postOperator.append(oprTmp.pop());
                        postOperator.append(" ");
                    }
                    oprTmp.pop();   //����


                } else if (tOperator_str.charAt(i) == '+' || tOperator_str.charAt(i) == '-') {      //�[�
                    postOperator.append(" ");
                    while (!oprTmp.isEmpty()) {         //�X��
                        if (oprTmp.peek() == '(') {
                            break;
                        } else {
                            postOperator.append(oprTmp.pop());
                            postOperator.append(" ");
                        }
                    }
                    oprTmp.push(tOperator_str.charAt(i));       //����

                } else if (tOperator_str.charAt(i) == '*' || tOperator_str.charAt(i) == '/') {      //������
                    postOperator.append(" ");
                    while (!oprTmp.isEmpty()) {         //�X��
                        if (oprTmp.peek() == '+' || oprTmp.peek() == '-' || oprTmp.peek() == '(') {
                            break;
                        } else {
                            postOperator.append(oprTmp.pop());
                            postOperator.append(" ");
                        }
                    }
                    oprTmp.push(tOperator_str.charAt(i));       //����

                } else if (tOperator_str.charAt(i) == 'r') {        //�ڸ�
                    postOperator.append(" ");
                    while (!oprTmp.isEmpty()) {     //�X��
                        if (oprTmp.peek() == 'r' || oprTmp.peek() == 's') {
                            postOperator.append(oprTmp.pop());
                            postOperator.append(" ");
                        } else {
                            break;
                        }
                    }
                    oprTmp.push(tOperator_str.charAt(i));       //����

                } else if (tOperator_str.charAt(i) == '^') {        //����
                    postOperator.append(" ");
                    oprTmp.push(tOperator_str.charAt(i));       //�u���׳̰���������

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
                        tOperator_str.charAt(i) == '.') {       //�Ʀr
                    postOperator.append(tOperator_str.charAt(i));       //����

                } else {
                    unKnowChar = true;
                }
            }
            postOperator.append(" ");
            while (!oprTmp.isEmpty()) {     //��X�Ÿ���
                postOperator.append(oprTmp.pop());
                postOperator.append(" ");
            }
        } catch (Exception e) {
            System.out.println("Error:"+e.getMessage());
        }

        String[] postTmp;       //��Ǫ�ܦ�����x�s�I
        Stack<Double> valTmp = new Stack<>();       //�Ʀr��

        postOperator = new StringBuilder(postOperator.toString().replaceAll("  ", " "));        //�Ů�B�z�A�h�Ů�אּ��Ů�H��K���
        if (postOperator.toString().startsWith(" ")) {                                          //�����e��Ů�
            postOperator = new StringBuilder(postOperator.substring(1));
        }
        if (postOperator.toString().endsWith(" ")) {
            postOperator = new StringBuilder(postOperator.toString().replaceFirst(".$", ""));
        }
        postTmp = postOperator.toString().split(" ");       //�����ܦ�

        try {       //�B��
            //��h:�Ʀr���̡A�J��Ÿ��̾ڴX���X�̭p��A�N���G��^�̤�
            for (int i = 0, m = postTmp.length; i < m; i++) {   //Ū����ǩ��

                if ((postTmp[i].charAt(0) >= '0' && postTmp[i].charAt(0) <= '9')) {     //�Ʀr
                    valTmp.push(Double.parseDouble(postTmp[i]));

                } else if (postTmp[i].charAt(0) == '~') {       //�t��
                    postTmp[i] = "-" + postTmp[i].substring(1);
                    valTmp.push(Double.parseDouble(postTmp[i]));
                } else if (postTmp[i].equals("e")) {        //�ѩԼ�
                    valTmp.push(E);
                } else if (postTmp[i].equals("p")) {        //pi
                    valTmp.push(PI);
                } else {        //�B���
                    double v1, v2, v3;
                    if (postTmp[i].equals("+")) {       //�[
                        v2 = valTmp.pop();
                        v1 = valTmp.pop();
                        v3 = v1 + v2;
                        valTmp.push(v3);
                    } else if (postTmp[i].equals("-")) {    //��
                        v2 = valTmp.pop();
                        v1 = valTmp.pop();
                        v3 = v1 - v2;
                        valTmp.push(v3);
                    } else if (postTmp[i].equals("*")) {    //��
                        v2 = valTmp.pop();
                        v1 = valTmp.pop();
                        v3 = v1 * v2;
                        valTmp.push(v3);
                    } else if (postTmp[i].equals("/")) {    //��
                        v2 = valTmp.pop();
                        v1 = valTmp.pop();
                        v3 = v1 / v2;
                        valTmp.push(v3);
                    } else if (postTmp[i].equals("^")) {    //����
                        v2 = valTmp.pop();
                        v1 = valTmp.pop();
                        v3 = Math.pow(v1, v2);
                        valTmp.push(v3);
                    } else if (postTmp[i].equals("r")) {    //�ڸ�
                        v1 = valTmp.pop();
                        v3 = Math.sqrt(v1);
                        valTmp.push(v3);
                    }
                }
            }
            result_double = valTmp.pop();   //���G
        } catch (Exception e) {
            System.out.println("Error:"+e.getMessage());
        }
        if (valTmp.isEmpty()) {     //�N���G��X
            result_str = Double.toString(result_double);
        } else {        //�B�⤸�P�B��l�ƥؤ���
            result_str = "NaN";
        }
    }
    void updateDisplay() {      //��s���
        if(operator_str.isEmpty()||operator_str.equals("0")) operator.setText("0");
        else {
            String tmp = String.copyValueOf(operator_str.toCharArray());
            tmp = tmp.replaceAll("~","-");
            tmp = tmp.replaceAll("p","�k");
            tmp = tmp.replaceAll("r","��");
            operator.setText(tmp);
        }
        result.setText("= "+result_str);
    }
    //����إ�
    String operator_str = "0";                              //���ǹB�⦡�x�s�I
    String result_str = "0";                                //���G�x�s�I
    double result_double = 0;
    final double PI = 3.14159265;                           //pi
    final double E  = 2.71828183;                           //�שԼ�

    JPanel appArea = new JPanel(true);                      //�D���O
    JPanel btnArea = new JPanel(true);                      //���s���O
    JPanel txtArea = new JPanel(true);                      //��r�ح��O

    GridLayout appAreaLayout = new GridLayout(2,1);         //�D���O�޲z��
    GridLayout btnAreaLayout = new GridLayout(7,4);         //���s���O�޲z��
    GridLayout txtAreaLayout = new GridLayout(4,1);         //��r�ح��O�޲z��

    btnListener btnListener = new btnListener();            //���s��ť��
    Font btnFont = new Font("Calibri",Font.PLAIN,24);       //���s�r���P��ܮ榡
    JButton percent = new JButton("%");                     //���s
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
    
    Font resultFont = new Font("Calibri",Font.BOLD,20);     //���G�r���P��ܮ榡
    Font historyFont = new Font("Calibri",Font.PLAIN,20);   //���v�����r���P��ܮ榡
    JTextField history_1 = new JTextField();                //��r��
    JTextField history_2 = new JTextField();
    JTextField operator = new JTextField();
    JTextField result = new JTextField();
}