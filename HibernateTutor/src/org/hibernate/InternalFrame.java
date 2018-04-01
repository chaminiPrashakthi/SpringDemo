package org.hibernate;

import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import javax.swing.table.DefaultTableModel;

import org.hibernate.cfg.Configuration;

public class InternalFrame {
	private JFrame frmEmployeeDetails;
	private JTextField textField;
	private JLabel lblMobile;
	private JTextField textField_1;
	private JLabel lblEmail;
	private JTextField textField_2;
	private JLabel lblId;
	private JTextField textField_3;
	private JLabel lblEmployeeDetails;
	private JButton btnSave;
	private JButton btnDelete;
	private String column[] = { "ID", "NAME", "MOBILE", "EMAIL" };
	private JTable table;
	private JScrollPane pane;
	private static DefaultTableModel tableModel;
	private ArrayList<Employee> EmployeeList;

	public InternalFrame() {
		initialize();
		getDataToTable();
		setDataToTable(EmployeeList);
	}

	private void getDataToTable() {

		Configuration cfg = new Configuration();
		cfg.configure("Hibernate.cfg.xml");
		SessionFactory ss = cfg.buildSessionFactory();
		Session s = ss.openSession();
		Query q = s.createQuery("from Employee");
		EmployeeList = new ArrayList<Employee>(q.list());
		System.out.println(q);
		s.close();
	}

	public void viewWindow() {
		try {
			InternalFrame window = new InternalFrame();
			window.frmEmployeeDetails.setVisible(true);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 */
	private void initialize() {

		frmEmployeeDetails = new JFrame();
		frmEmployeeDetails.setTitle("Employee Details");
		frmEmployeeDetails.setBounds(100, 100, 450, 300);
		frmEmployeeDetails.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		GridBagLayout gridBagLayout = new GridBagLayout();
		gridBagLayout.columnWidths = new int[] { 0, 0, 0, 0, 0 };
		gridBagLayout.rowHeights = new int[] { 0, 0, 0, 0, 0, 0, 0, 0, 0 };
		gridBagLayout.columnWeights = new double[] { 0.0, 0.0, 0.0, 1.0, Double.MIN_VALUE };
		gridBagLayout.rowWeights = new double[] { 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, Double.MIN_VALUE };
		frmEmployeeDetails.getContentPane().setLayout(gridBagLayout);

		lblEmployeeDetails = new JLabel("Employee Details");
		GridBagConstraints gbc_lblEmployeeDetails = new GridBagConstraints();
		gbc_lblEmployeeDetails.anchor = GridBagConstraints.EAST;
		gbc_lblEmployeeDetails.insets = new Insets(0, 0, 5, 5);
		gbc_lblEmployeeDetails.gridx = 2;
		gbc_lblEmployeeDetails.gridy = 1;
		frmEmployeeDetails.getContentPane().add(lblEmployeeDetails, gbc_lblEmployeeDetails);

		lblId = new JLabel("Id:");
		GridBagConstraints gbc_lblId = new GridBagConstraints();
		gbc_lblId.anchor = GridBagConstraints.EAST;
		gbc_lblId.insets = new Insets(0, 0, 5, 5);
		gbc_lblId.gridx = 2;
		gbc_lblId.gridy = 3;
		frmEmployeeDetails.getContentPane().add(lblId, gbc_lblId);

		textField_3 = new JTextField();
		GridBagConstraints gbc_textField_3 = new GridBagConstraints();
		gbc_textField_3.anchor = GridBagConstraints.WEST;
		gbc_textField_3.insets = new Insets(0, 0, 5, 0);
		gbc_textField_3.gridx = 3;
		gbc_textField_3.gridy = 3;
		frmEmployeeDetails.getContentPane().add(textField_3, gbc_textField_3);
		textField_3.setColumns(10);

		JLabel lblName = new JLabel("Name:");
		GridBagConstraints gbc_lblName = new GridBagConstraints();
		gbc_lblName.anchor = GridBagConstraints.EAST;
		gbc_lblName.insets = new Insets(0, 0, 5, 5);
		gbc_lblName.gridx = 2;
		gbc_lblName.gridy = 4;
		frmEmployeeDetails.getContentPane().add(lblName, gbc_lblName);

		textField = new JTextField();
		GridBagConstraints gbc_textField = new GridBagConstraints();
		gbc_textField.insets = new Insets(0, 0, 5, 0);
		gbc_textField.anchor = GridBagConstraints.WEST;
		gbc_textField.gridx = 3;
		gbc_textField.gridy = 4;
		frmEmployeeDetails.getContentPane().add(textField, gbc_textField);
		textField.setColumns(10);

		lblMobile = new JLabel("Mobile:");
		GridBagConstraints gbc_lblMobile = new GridBagConstraints();
		gbc_lblMobile.anchor = GridBagConstraints.EAST;
		gbc_lblMobile.insets = new Insets(0, 0, 5, 5);
		gbc_lblMobile.gridx = 2;
		gbc_lblMobile.gridy = 5;
		frmEmployeeDetails.getContentPane().add(lblMobile, gbc_lblMobile);

		textField_1 = new JTextField();
		GridBagConstraints gbc_textField_1 = new GridBagConstraints();
		gbc_textField_1.insets = new Insets(0, 0, 5, 0);
		gbc_textField_1.anchor = GridBagConstraints.WEST;
		gbc_textField_1.gridx = 3;
		gbc_textField_1.gridy = 5;
		frmEmployeeDetails.getContentPane().add(textField_1, gbc_textField_1);
		textField_1.setColumns(10);

		lblEmail = new JLabel("Email:");
		GridBagConstraints gbc_lblEmail = new GridBagConstraints();
		gbc_lblEmail.anchor = GridBagConstraints.EAST;
		gbc_lblEmail.insets = new Insets(0, 0, 5, 5);
		gbc_lblEmail.gridx = 2;
		gbc_lblEmail.gridy = 6;
		frmEmployeeDetails.getContentPane().add(lblEmail, gbc_lblEmail);

		textField_2 = new JTextField();
		GridBagConstraints gbc_textField_2 = new GridBagConstraints();
		gbc_textField_2.insets = new Insets(0, 0, 5, 0);
		gbc_textField_2.anchor = GridBagConstraints.WEST;
		gbc_textField_2.gridx = 3;
		gbc_textField_2.gridy = 6;
		frmEmployeeDetails.getContentPane().add(textField_2, gbc_textField_2);
		textField_2.setColumns(10);

		btnSave = new JButton("Save");
		GridBagConstraints gbc_btnSave = new GridBagConstraints();
		gbc_btnSave.insets = new Insets(0, 0, 0, 5);
		gbc_btnSave.gridx = 2;
		gbc_btnSave.gridy = 7;
		frmEmployeeDetails.getContentPane().add(btnSave, gbc_btnSave);
		btnSave.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				Configuration cfg = new Configuration();
				cfg.configure("Hibernate.cfg.xml");
				SessionFactory ss = cfg.buildSessionFactory();
				Session s = ss.openSession();
				Transaction tx = s.beginTransaction();
				Employee EMP = new Employee();
				EMP.setName(textField.getText());
				EMP.setId(Integer.valueOf(textField_3.getText()));
				EMP.setMobile(Integer.valueOf(textField_1.getText()));
				EMP.setEmail(textField_2.getText());
				s.save(EMP);
				s.flush();
				tx.commit();
				s.close();

			}
		});

		btnDelete = new JButton("Delete");
		GridBagConstraints gbc_btnDelete = new GridBagConstraints();
		gbc_btnDelete.gridx = 3;
		gbc_btnDelete.gridy = 7;
		gbc_btnDelete.insets = new Insets(0, 0, 5, 5);
		frmEmployeeDetails.getContentPane().add(btnDelete, gbc_btnDelete);
		btnDelete.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent arg0) {
				int selectedRow = table.getSelectedRow();
				int valueToDelete = (int) table.getModel().getValueAt(selectedRow, 0);
				Configuration cfg = new Configuration();
				cfg.configure("Hibernate.cfg.xml");
				SessionFactory ss = cfg.buildSessionFactory();
				Session s = ss.openSession();
				Transaction tx = s.beginTransaction();
				Query query = s.createQuery("delete from Employee where Id = :Id");
				query.setParameter("Id", valueToDelete);
				query.executeUpdate();
		        tx.commit();
				System.out.println(query);
				s.close();
			}
		});

		tableModel = new DefaultTableModel(column, 0);
		table = new JTable(tableModel);
		pane = new JScrollPane(table);
		GridBagConstraints gbc_table = new GridBagConstraints();
		gbc_table.gridx = 2;
		gbc_table.gridy = 8;
		gbc_table.insets = new Insets(0, 0, 5, 5);
		frmEmployeeDetails.getContentPane().add(pane, gbc_table);
		table.getSelectionModel().addListSelectionListener(new ListSelectionListener() {

			@Override
			public void valueChanged(ListSelectionEvent e) {
				setFields(EmployeeList);
			}
		});
	}

	public void setDataToTable(List<Employee> employee) {
		tableModel.setRowCount(0);
		Iterator<Employee> itr = employee.iterator();
		while (itr.hasNext()) {
			Employee emp = (Employee) itr.next();
			tableModel.addRow(new Object[] { emp.getId(), emp.getName(), emp.getMobile(), emp.getEmail() });
		}
		tableModel.fireTableDataChanged();
	}

	private void setFields(List<Employee> employeeDetails) {
		Iterator<Employee> itr = employeeDetails.iterator();
		while (itr.hasNext()) {
			Employee EMP = (Employee) itr.next();
			textField.setText(EMP.getName());
			// textField_3.setText(EMP.getId());
			textField_2.setText(EMP.getEmail());
			// textField_1.setText(Integer.valueOf(EMP.getMobile()));
		}
	}

}
