package com.loginPage;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import org.zkoss.zk.ui.Executions;
import org.zkoss.zk.ui.select.SelectorComposer;
import org.zkoss.zk.ui.select.annotation.Listen;
import org.zkoss.zk.ui.select.annotation.Wire;
import org.zkoss.zul.Button;
import org.zkoss.zul.Hlayout;
import org.zkoss.zul.Messagebox;
import org.zkoss.zul.Textbox;

public class Login extends SelectorComposer<Hlayout> {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public boolean checklogin() {
		int i = 0;
		try {
			Class.forName("com.mysql.jdbc.Driver");
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} // Setup the connection with the DB
		try {
			Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/hoang", "root",
					"hoangvnpro123@@");
			
			// Statements allow to issue SQL queries to the database ; that's why we need to create one.
			Statement statement = con.createStatement();
			
			// check data username
			ResultSet resultSet = statement.executeQuery("select  * from loginuser where username = '" + userName.getValue()+"' and password='" +password.getValue()+"';");
			if(resultSet.next()) {
				Messagebox.show("ok");
				i++;
			} else {
				Messagebox.show("moi nhap lai");
			}
		} catch (SQLException f) {
	Messagebox.show(f.toString());
		}
		if(i==1) {
			return true;
		} else {
			return false;
		}
	}
	MySQLConnection hoang =new MySQLConnection();
	
	@Wire
	Textbox userName, password;
	@Wire
	Button submitButton;

	@Listen("onClick=#submitButton")
	public void onClickSubmitButton() {
		if(checklogin()) {
			Executions.getCurrent().sendRedirect("./trangchu/trangchu.zul");
		}
	}
	
	@Listen("onOK=#userName,#password")
	public void onPressEnter() {
		onClickSubmitButton();
	}
	
}
