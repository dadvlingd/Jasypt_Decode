package com.example.Jasypt;

import org.jasypt.encryption.pbe.StandardPBEStringEncryptor;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Jasypt {


    public static String decryptor(String cryptoPassword, String encodeText) {
        StandardPBEStringEncryptor decryptor = new StandardPBEStringEncryptor();
        decryptor.setPassword(cryptoPassword);
        return decryptor.decrypt(encodeText);
    }

    public static String encryptor(String cryptoPassword, String text) {
        StandardPBEStringEncryptor encryptor = new StandardPBEStringEncryptor();
        encryptor.setPassword(cryptoPassword);
        return encryptor.encrypt(text);
    }
    private static void placeComponents(JPanel panel) {
        panel.setLayout(null);

        // 创建一个标签
        JLabel cipherLabel = new JLabel("密文:");
        cipherLabel.setBounds(10, 20, 80, 25);
        panel.add(cipherLabel);

        // 创建一个文本域用于用户输入
        JTextField cipherText = new JTextField(20);
        cipherText.setBounds(50, 20, 280, 25);
        panel.add(cipherText);
        JLabel keyLabel = new JLabel("密钥:");
        keyLabel.setBounds(10, 50, 80, 25);
        panel.add(keyLabel);

        JTextField keyText = new JTextField(20);
        keyText.setBounds(50, 50, 280, 25);
        panel.add(keyText);

        // 创建一个按钮
        JButton decodeButton = new JButton("decode");
        decodeButton.setBounds(10, 80, 80, 25);
        panel.add(decodeButton);
        JButton encodeButton = new JButton("encode");
        encodeButton.setBounds(100, 80, 80, 25);
        panel.add(encodeButton);

        // 创建一个标签显示消息
        JLabel plainLabel = new JLabel("明文：");
        plainLabel.setBounds(10, 110, 80, 25);
        panel.add(plainLabel);

        JTextField plainText = new JTextField(20);
        plainText.setBounds(50, 110, 280, 25);
        panel.add(plainText);
        JLabel zuozheLabel = new JLabel("作者：yuday");
        zuozheLabel.setBounds(10, 230, 120, 25);
        panel.add(zuozheLabel);

        // 添加按钮点击事件
        decodeButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String cipher = cipherText.getText();
                String key = keyText.getText();
                try {
                    plainText.setText(decryptor(key, cipher));
                }catch (Exception t){
                    plainText.setText("解密失败！可能密钥或密文错误！");
                }

            }
        });
        encodeButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String plain = plainText.getText();
                String key = keyText.getText();
                cipherText.setText(encryptor(key, plain));
            }
        });
    }

    public static void main(String[] args) {

        try {
            // 创建一个 JFrame 实例
            JFrame frame = new JFrame("jasypt");
            frame.setSize(400, 300);
            frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

            // 创建一个 JPanel 实例
            JPanel panel = new JPanel();
            frame.add(panel);
            placeComponents(panel);

            // 设置框架可见
            frame.setVisible(true);


        } catch (Exception e) {
            e.printStackTrace();
        }

    }
}

