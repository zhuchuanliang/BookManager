package com.java1234.view;

import java.awt.EventQueue;
import java.sql.Connection;
import java.sql.ResultSet;

import javax.swing.JInternalFrame;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.LayoutStyle.ComponentPlacement;

import com.java1234.dao.BookDao;
import com.java1234.dao.BookTypeDao;
import com.java1234.model.Book;
import com.java1234.model.BookType;
import com.java1234.util.DbUtil;
import com.java1234.util.StringUtil;

import javax.swing.JRadioButton;
import javax.swing.ButtonGroup;
import javax.swing.JTextArea;
import javax.swing.JComboBox;
import javax.swing.JButton;
import javax.swing.ImageIcon;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class BookAddInterFrm extends JInternalFrame {
	private JTextField bookNameTxt;
	private JTextField authorTxt;
	private final ButtonGroup buttonGroup = new ButtonGroup();
	private JTextField priceTxt;
	private DbUtil dbUtil=new DbUtil();
	private BookTypeDao bookTypeDao=new BookTypeDao();
	private JComboBox bookTypeJcb;
	private JTextArea bookDescTxt;
    private JRadioButton manJrb;
    private JRadioButton femaleJrb;
    private BookDao bookDao=new BookDao();
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					BookAddInterFrm frame = new BookAddInterFrm();
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
	public BookAddInterFrm() {
		setIconifiable(true);
		setClosable(true);
		setTitle("\u56FE\u4E66\u6DFB\u52A0");
		setBounds(100, 100, 637, 420);
		
		JLabel lblNewLabel = new JLabel("\u56FE\u4E66\u540D\u79F0\uFF1A");
		
		bookNameTxt = new JTextField();
		bookNameTxt.setColumns(10);
		
		JLabel label = new JLabel("\u56FE\u4E66\u4F5C\u8005\uFF1A");
		
		authorTxt = new JTextField();
		authorTxt.setColumns(10);
		
		JLabel label_1 = new JLabel("\u4F5C\u8005\u6027\u522B\uFF1A");
		
		manJrb = new JRadioButton("\u7537");
		buttonGroup.add(manJrb);
		manJrb.setSelected(true);
		
		femaleJrb = new JRadioButton("\u5973");
		buttonGroup.add(femaleJrb);
		
		JLabel label_2 = new JLabel("\u56FE\u4E66\u4EF7\u683C\uFF1A");
		
		priceTxt = new JTextField();
		priceTxt.setColumns(10);
		
		JLabel label_3 = new JLabel("\u56FE\u4E66\u63CF\u8FF0\uFF1A");
		
		bookDescTxt = new JTextArea();
		
		JLabel label_4 = new JLabel("\u56FE\u4E66\u7C7B\u522B\uFF1A");
		
		bookTypeJcb = new JComboBox();
		
		JButton button = new JButton("\u6DFB\u52A0");
		button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				bookAddActionPerformed(e);
			}
		});
		button.setIcon(new ImageIcon(BookAddInterFrm.class.getResource("/images/add.png")));
		
		JButton button_1 = new JButton("\u91CD\u7F6E");
		button_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				resetValueActionPerformed(e);
			}
		});
		button_1.setIcon(new ImageIcon(BookAddInterFrm.class.getResource("/images/reset.png")));
		GroupLayout groupLayout = new GroupLayout(getContentPane());
		groupLayout.setHorizontalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup()
					.addGap(41)
					.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
						.addGroup(groupLayout.createSequentialGroup()
							.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
								.addGroup(groupLayout.createSequentialGroup()
									.addComponent(lblNewLabel, GroupLayout.PREFERRED_SIZE, 60, GroupLayout.PREFERRED_SIZE)
									.addPreferredGap(ComponentPlacement.RELATED)
									.addComponent(bookNameTxt, GroupLayout.PREFERRED_SIZE, 133, GroupLayout.PREFERRED_SIZE))
								.addGroup(groupLayout.createParallelGroup(Alignment.TRAILING)
									.addGroup(Alignment.LEADING, groupLayout.createSequentialGroup()
										.addPreferredGap(ComponentPlacement.RELATED)
										.addComponent(label_4)
										.addGap(18)
										.addComponent(bookTypeJcb, GroupLayout.PREFERRED_SIZE, 70, GroupLayout.PREFERRED_SIZE))
									.addGroup(Alignment.LEADING, groupLayout.createSequentialGroup()
										.addComponent(label_1)
										.addPreferredGap(ComponentPlacement.RELATED)
										.addComponent(manJrb)
										.addPreferredGap(ComponentPlacement.RELATED)
										.addComponent(femaleJrb))))
							.addGap(26)
							.addGroup(groupLayout.createParallelGroup(Alignment.LEADING, false)
								.addGroup(groupLayout.createSequentialGroup()
									.addComponent(label)
									.addPreferredGap(ComponentPlacement.RELATED)
									.addComponent(authorTxt, GroupLayout.PREFERRED_SIZE, 135, GroupLayout.PREFERRED_SIZE))
								.addGroup(groupLayout.createSequentialGroup()
									.addComponent(label_2)
									.addPreferredGap(ComponentPlacement.RELATED)
									.addComponent(priceTxt))))
						.addGroup(groupLayout.createSequentialGroup()
							.addPreferredGap(ComponentPlacement.RELATED)
							.addComponent(label_3)
							.addPreferredGap(ComponentPlacement.UNRELATED)
							.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
								.addGroup(groupLayout.createSequentialGroup()
									.addGap(64)
									.addComponent(button)
									.addGap(56)
									.addComponent(button_1))
								.addComponent(bookDescTxt, GroupLayout.PREFERRED_SIZE, 408, GroupLayout.PREFERRED_SIZE))))
					.addContainerGap(102, Short.MAX_VALUE))
		);
		groupLayout.setVerticalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup()
					.addGap(36)
					.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblNewLabel)
						.addComponent(bookNameTxt, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addComponent(label)
						.addComponent(authorTxt, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addGap(30)
					.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
						.addComponent(label_1)
						.addComponent(manJrb)
						.addComponent(femaleJrb)
						.addComponent(label_2)
						.addComponent(priceTxt, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addGap(33)
					.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
						.addComponent(label_4)
						.addComponent(bookTypeJcb, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addGap(28)
					.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
						.addComponent(bookDescTxt, GroupLayout.PREFERRED_SIZE, 131, GroupLayout.PREFERRED_SIZE)
						.addComponent(label_3))
					.addPreferredGap(ComponentPlacement.RELATED, 34, Short.MAX_VALUE)
					.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
						.addComponent(button_1)
						.addComponent(button))
					.addContainerGap())
		);
		getContentPane().setLayout(groupLayout);
		fillBookType();

	}
	
	//重置事件处理
	private  void resetValueActionPerformed(ActionEvent e) {
		this.resetValue();
		
	}

	//图书添加事件处理
	private void bookAddActionPerformed(ActionEvent evt) {
		String bookName=this.bookNameTxt.getText();
		String author=this.authorTxt.getText();
		String price=this.priceTxt.getText();
		String bookDesc=this.bookDescTxt.getText();
		if(StringUtil.isEmpty(bookName)){
			JOptionPane.showMessageDialog(null, "图书名称不能为空");
			return;
		}
		if(StringUtil.isEmpty(author)){
			JOptionPane.showMessageDialog(null, "图书作者不能为空");
			return;
		}
		if(StringUtil.isEmpty(price)){
			JOptionPane.showMessageDialog(null, "图书价格不能为空");
			return;
		}
		//获取性别
		String sex="";
		if(manJrb.isSelected()){
			sex="男";
		}else if(femaleJrb.isSelected()){
			sex="女";
		}
		//获取bookType
		BookType bookType=(BookType) bookTypeJcb.getSelectedItem();
		int bookTypeId=bookType.getId();
		Book book=new Book(bookName, author, sex, Float.parseFloat(price), bookTypeId, bookDesc);
		//调用数据库
		Connection con=null;
		try{
			con=dbUtil.getCon();
			int addNum=bookDao.add(con,book);
			if(addNum==1){
				JOptionPane.showMessageDialog(null, "图书添加成功");
				resetValue();
			}else{
				JOptionPane.showMessageDialog(null, "图书添加失败");
			}
			
		}catch(Exception e){
			e.printStackTrace();
			JOptionPane.showMessageDialog(null, "图书添加失败");
		}finally{
			try {
				dbUtil.closeCon(con);
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}
	//重置表单
	private void resetValue(){
		this.bookNameTxt.setText("");
		this.authorTxt.setText("");
		this.priceTxt.setText("");
		this.manJrb.setSelected(true);
		this.bookDescTxt.setText("");
		if(this.bookTypeJcb.getItemCount()>0){
			this.bookTypeJcb.setSelectedIndex(0);
		}
		
	}

	private void fillBookType(){
		Connection con=null;
		BookType bookType=null;
		try{
			con=dbUtil.getCon();
			ResultSet rs=bookTypeDao.list(con,new BookType());
			while(rs.next()){
				bookType=new BookType();
				bookType.setId(rs.getInt("id"));
				bookType.setBookTypeName(rs.getString("bookTypeName"));
				this.bookTypeJcb.addItem(bookType);
			}
		}catch(Exception e){
			e.printStackTrace();
		}
		
	}
	
}
