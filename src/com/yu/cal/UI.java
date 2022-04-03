package com.yu.cal;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.*;

public class UI extends JFrame {

    private final JPanel contentPane;
    private final JTextField displaytf;
    private final JPanel PanelBtn_0;
    private final JPanel panel_3;
    private final JPanel PanelNum;
    private final JPanel PanelZero;
    private final JPanel PanelNum_Natural;
    private final JPanel PanelOper;
    private final JPanel PanelAns;
    private final JPanel PanelAns_0;

    private final String[] NUMS = {"7", "8", "9", "4", "5", "6", "1", "2", "3", "0", "."};
    /**
     * 计算器上的功能键的显示名字
     */
    private final String[] OPER = {"/", "*", "-", "+", "%", "1%x", "="};
    /**
     * 计算器左边的M的显示名字
     */
    private final String[] M = {"MC", "MR", "MS", "M+", "M-", "BS", "CE", "C", "±", "√"};
    /**
     * 计算器上键的按钮
     */
    private final JButton[] nums = new JButton[NUMS.length];
    /**
     * 计算器上的功能键的按钮
     */
    private final JButton[] oper = new JButton[OPER.length];
    /**
     * 计算器左边的M的按钮
     */
    private final JButton[] m = new JButton[M.length];

    private final InputHandler handleinput;


    /**
     * Create the frame.
     */
    public UI() {

        setTitle("JCalculator");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setBounds(100, 100, 450, 300);
        contentPane = new JPanel();
        contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
        contentPane.setLayout(new BorderLayout(5, 5));
        setContentPane(contentPane);

        displaytf = new JTextField();
        displaytf.setEditable(false);
        displaytf.setText("0");
        contentPane.add(displaytf, BorderLayout.NORTH);
        displaytf.setColumns(10);
        displaytf.setHorizontalAlignment(JTextField.RIGHT);

        JPanel PanelBtn = new JPanel();
        contentPane.add(PanelBtn, BorderLayout.CENTER);
        PanelBtn.setLayout(new BorderLayout(5, 5));

        JPanel PanelM = new JPanel();
        PanelBtn.add(PanelM, BorderLayout.NORTH);
        PanelM.setLayout(new GridLayout(2, 5, 5, 5));

        PanelBtn_0 = new JPanel();
        PanelBtn.add(PanelBtn_0, BorderLayout.CENTER);
        PanelBtn_0.setLayout(new BorderLayout(5, 5));

        panel_3 = new JPanel();
        PanelBtn_0.add(panel_3, BorderLayout.EAST);
        panel_3.setLayout(new BorderLayout(5, 5));

        PanelOper = new JPanel();
        panel_3.add(PanelOper, BorderLayout.WEST);
        PanelOper.setLayout(new GridLayout(4, 1, 5, 5));

        PanelAns = new JPanel();
        panel_3.add(PanelAns, BorderLayout.EAST);
        PanelAns.setLayout(new BorderLayout(5, 5));

        PanelAns_0 = new JPanel();
        PanelAns.add(PanelAns_0, BorderLayout.NORTH);
        PanelAns_0.setLayout(new GridLayout(2, 1, 5, 5));

        PanelNum = new JPanel();
        PanelBtn_0.add(PanelNum, BorderLayout.CENTER);
        PanelNum.setLayout(new BorderLayout(5, 5));

        PanelZero = new JPanel();
        PanelNum.add(PanelZero, BorderLayout.SOUTH);
        PanelZero.setLayout(new BorderLayout(5, 5));

        PanelNum_Natural = new JPanel();
        PanelNum.add(PanelNum_Natural, BorderLayout.CENTER);
        PanelNum_Natural.setLayout(new GridLayout(3, 3, 5, 5));

        handleinput = new InputHandler(displaytf);

//		添加按钮到面板上并添加触发器
//		功能键
        for (int i = 0; i < M.length; i++) {
            m[i] = new JButton(M[i]);
            PanelM.add(m[i]);
            m[i].addActionListener(handleinput);
        }
//		数字键
        for (int i = 0; i < NUMS.length; i++) {
            nums[i] = new JButton(NUMS[i]);
            if (i < 9) {
                nums[i].setBackground(Color.white);
                PanelNum_Natural.add(nums[i]);
            } else if (i == 9) {
                nums[i].setBackground(Color.white);
                PanelZero.add(nums[i], "Center");
            } else {
                PanelZero.add(nums[i], "East");

            }
            nums[i].addActionListener(handleinput);
        }
//		运算符键
        for (int i = 0; i < OPER.length; i++) {
            oper[i] = new JButton(OPER[i]);
            if (i < 4) {
                PanelOper.add(oper[i]);
            } else if (i < 6) {
                PanelAns_0.add(oper[i]);
            } else {
                PanelAns.add(oper[i], "Center");

            }

            oper[i].addActionListener(handleinput);
        }
        pack();
    }


}
