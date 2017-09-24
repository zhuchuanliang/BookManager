package com.java1234.view;

import java.awt.EventQueue;

import javax.swing.JInternalFrame;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.JTextArea;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.border.LineBorder;

import com.java1234.dao.BookTypeDao;
import com.java1234.model.BookType;
import com.java1234.util.DbUtil;
import com.java1234.util.StringUtil;

import javax.swing.JButton;
import javax.swing.ImageIcon;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.awt.event.ActionEvent;

public class BookTypeAddInterFrm extends JInternalFrame {
	private JTextField bookTypeNameTxt;
	private JTextArea bookTypeDescTxt;
	private DbUtil dbUtil=new DbUtil();
	private BookTypeDao bookTypeDao=new BookTypeDao();

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					BookTypeAddInterFrm frame = new BookTypeAddInterFrm();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public BookTypeAddInterFrm() {
		setClosable(true);
		setIconifiable(true);
		setTitle("\u56FE\u4E66\u7C7B\u522B\u6DFB\u52A0");
		setBounds(100, 100, 450, 300);
		
		JLabel label = new JLabel("\u56FE\u4E66\u7C7B\u522B\u540D\u79F0\uFF1A");
		
		JLabel label_1 = new JLabel("\u56FE\u4E66\u7C7B\u522B\u63CF\u8FF0\uFF1A");
		
		bookTypeNameTxt = new JTextField();
		bookTypeNameTxt.setColumns(10);
		
		bookTypeDescTxt = new JTextArea();
		
		JButton btnNewButton = new JButton("\u6DFB\u52A0");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				bookTypeAddActionPerformed(e);
			}

		
		});
		btnNewButton.setIcon(new ImageIcon(BookTypeAddInterFrm.class.getResource("/images/add.png")));
		
		JButton btnNewButton_1 = new JButton("\u91CD\u7F6E");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				resetValueActionPerformed(e);
			}
		});
		btnNewButton_1.setIcon(new ImageIcon(BookTypeAddInterFrm.class.getResource("/images/reset.png")));
		GroupLayout groupLayout = new GroupLayout(getContentPane());
		groupLayout.setHorizontalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup()
					.addGap(50)
					.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
						.addComponent(label)
						.addComponent(label_1))
					.addGap(30)
					.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
						.addComponent(bookTypeDescTxt, GroupLayout.DEFAULT_SIZE, 201, Short.MAX_VALUE)
						.addComponent(bookTypeNameTxt, GroupLayout.DEFAULT_SIZE, 6, Short.MAX_VALUE))
					.addGap(69))
				.addGroup(groupLayout.createSequentialGroup()
					.addGap(147)
					.addComponent(btnNewButton)
					.addGap(48)
					.addComponent(btnNewButton_1)
					.addContainerGap(125, Short.MAX_VALUE))
		);
		groupLayout.setVerticalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup()
					.addGap(34)
					.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
						.addComponent(label)
						.addComponent(bookTypeNameTxt, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addGap(18)
					.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
						.addComponent(label_1)
						.addComponent(bookTypeDescTxt, GroupLayout.PREFERRED_SIZE, 114, GroupLayout.PREFERRED_SIZE))
					.addPreferredGap(ComponentPlacement.RELATED, 29, Short.MAX_VALUE)
					.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
						.addComponent(btnNewButton)
						.addComponent(btnNewButton_1))
					.addGap(31))
		);
		getContentPane().setLayout(groupLayout);
		bookTypeDescTxt.setBorder(new LineBorder(new java.awt.Color(127,157,185),1,false));

	}
	//图书类别添加事件
	private void bookTypeAddActionPerformed(ActionEvent evt) {
	 String bookTypeName=this.bookTypeNameTxt.getText();
	 String bookTypeDesc=this.bookTypeDescTxt.getText();
	 if(StringUtil.isEmpty(bookTypeName)){
		 JOptionPane.showMessageDialog(null, "图书类别名称不能为空");
		 return;
	 }
	 BookType bookType=new BookType(bookTypeName,bookTypeDesc);
	 Connection con=null;
	 
	 try{
		 con=dbUtil.getCon();
		 int n=bookTypeDao.add(con, bookType);
		 if(n==1){
			 JOptionPane.showMessageDialog(null, "图书类别添加成功");
			 resetValue();
		 }else{
			 JOptionPane.showMessageDialog(null, "图书类别添加失败");
		 }
	 }catch(Exception e){
		 e.printStackTrace();
		 JOptionPane.showMessageDialog(null, "图书类别添加失败");
	 }finally{
		 try {
			dbUtil.closeCon(con);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	 }
		
	}
	private void resetValueActionPerformed(ActionEvent e){
		this.resetValue();
	}
	//重置表单
	private void resetValue(){
		this.bookTypeNameTxt.setText("");
		this.bookTypeDescTxt.setText("");
	}
}
