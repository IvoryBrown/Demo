package hu.swing.company;

import java.awt.Color;
import java.awt.Font;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

import javax.swing.BorderFactory;
import javax.swing.JOptionPane;
import javax.swing.SwingConstants;
import javax.swing.border.Border;
import javax.swing.border.TitledBorder;
import javax.swing.table.DefaultTableModel;

import hu.settings.CenterWindow;
import hu.swing.workers.WorkersSwing;

@SuppressWarnings("serial")
public class CompanySwing extends javax.swing.JFrame {
	private javax.swing.JLabel jLblPartnerName, jLblCompanyName, jLblCountry, jLblZipCodeCity, jLblStreetHouseNumber,
			jLblEmail, jLblLandlinePhone, jLblMobilePhone, jLblAccountNumber, jLblBanksName, jLblAdministratorName,
			jLblComment, jLblPartnerCode;
	private javax.swing.JTextField txtPartnerName, txtCompanyName, txtCountry, txtZipCode, txtCity, txtHouseNumber,
			txtStreet, txtEmail, txtLandlinePhone, txtMobilPhone, txtAccountNumber, txtBanksName, txtAdministratorName,
			txtComment, txtSearch, txtPartnerCode;
	private javax.swing.JButton jBtnNewPartner, jBtnDeletePartner, jBtnBack, jBtnEditor, jBtnSearch, jBtnFirst,
			jBtnLast, jBtnPrevious, jBtnNext;
	private javax.swing.JLabel jLblLabelA, jLblLabelB, jLblLabelC;
	private javax.swing.JPanel jPanel1;
	private javax.swing.JTable JTable_Products;
	private javax.swing.JScrollPane scrollPane_1;

	static final String JDBC_DRIVER = "com.mysql.jdbc.Driver";
	static final String DB_URL = "jdbc:mysql://localhost/zrt";
	static final String USER = "root";
	static final String PASS = "12345";
	int pos = 0;

	public CompanySwing() {
		super("Megrendelő");
		initComponents();
		Show_Products_In_JTable();
	}

	public Connection getConnection() {
		Connection con = null;
		try {
			Class.forName(JDBC_DRIVER);
			con = DriverManager.getConnection(DB_URL, USER, PASS);
			return con;
		} catch (SQLException ex) {
			Logger.getLogger(CompanySwing.class.getName()).log(Level.SEVERE, null, ex);
			return null;
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
			return null;
		}
	}

	public boolean checkInputs() {
		
		
		if (txtAccountNumber.getText() == null || txtAdministratorName.getText() == null
				|| txtBanksName.getText() == null || txtCity.getText() == null || txtComment.getText() == null
				|| txtCompanyName.getText() == null || txtCountry.getText() == null || txtEmail.getText() == null
				|| txtHouseNumber.getText() == null || txtLandlinePhone == null || txtMobilPhone.getText() == null
				|| txtPartnerCode.getText() == null || txtPartnerName.getText() == null || txtStreet.getText() == null
				|| txtZipCode.getText() == null) {
			return false;
		} else {
			try {
				return true;
			} catch (Exception ex) {
				return false;
			}
		}

	}

	public ArrayList<CompanyConfig> getProductList() {
		ArrayList<CompanyConfig> productList = new ArrayList<CompanyConfig>();
		Connection con = getConnection();
		String QUERY = "SELECT * FROM company";
		Statement st;
		ResultSet rs;
		try {
			st = con.createStatement();
			rs = st.executeQuery(QUERY);
			CompanyConfig product;
			while (rs.next()) {
				product = new CompanyConfig(rs.getInt("partner_code"), rs.getString("partner_name"),
						rs.getString("company_name"), rs.getString("country"), rs.getInt("zip_code"),
						rs.getString("city"), rs.getString("street"), rs.getInt("house_number"), rs.getString("email"),
						rs.getInt("landline_phone"), rs.getInt("mobile_phone"), rs.getInt("account_number"),
						rs.getString("banks_name"), rs.getString("administrator_name"), rs.getString("comment"));
				productList.add(product);
			}
		} catch (SQLException ex) {
			Logger.getLogger(CompanyConfig.class.getName()).log(Level.SEVERE, null, ex);
		}
		return productList;
	}

	public void Show_Products_In_JTable() {
		ArrayList<CompanyConfig> list = getProductList();
		DefaultTableModel model = (DefaultTableModel) JTable_Products.getModel();
		model.setRowCount(0);
		Object[] row = new Object[2];
		for (int i = 0; i < list.size(); i++) {
			// row[0] = list.get(i).getId_partner_code();
			row[0] = list.get(i).getPartner_name();
			// row[2] = list.get(i).getCompany_name();
			// row[3] = list.get(i).getCountry();
			// row[4] = list.get(i).getZip_code();
			// row[5] = list.get(i).getCity();
			// row[6] = list.get(i).getStreet();
			// row[7] = list.get(i).getHouse_number();
			// row[8] = list.get(i).getEmail();
			// row[9] = list.get(i).getLandline_phone();
			// row[10] = list.get(i).getMobile_phone();
			// row[11] = list.get(i).getAccount_number();
			// row[12] = list.get(i).getBanks_name();
			// row[13] = list.get(i).getAdministrator_name();
			// row[13] = list.get(i).getComment();
			model.addRow(row);
		}
	}

	public void ShowItem(int index) {
		txtPartnerCode.setText(Integer.toString(getProductList().get(index).getId_partner_code()));
		txtPartnerName.setText(getProductList().get(index).getPartner_name());
		txtAccountNumber.setText(Integer.toString(getProductList().get(index).getAccount_number()));
		txtAdministratorName.setText(getProductList().get(index).getAdministrator_name());
		txtBanksName.setText(getProductList().get(index).getBanks_name());
		txtCity.setText(getProductList().get(index).getCity());
		txtComment.setText(getProductList().get(index).getComment());
		txtCompanyName.setText(getProductList().get(index).getCompany_name());
		txtCountry.setText(getProductList().get(index).getCountry());
		txtEmail.setText(getProductList().get(index).getEmail());
		txtHouseNumber.setText(Integer.toString(getProductList().get(index).getHouse_number()));
		txtLandlinePhone.setText(Integer.toString(getProductList().get(index).getLandline_phone()));
		txtMobilPhone.setText(Integer.toString(getProductList().get(index).getMobile_phone()));
		txtStreet.setText(getProductList().get(index).getStreet());
		txtZipCode.setText(Integer.toString(getProductList().get(index).getZip_code()));
	}

	@SuppressWarnings({ "static-access" })
	private void initComponents() {
		this.getContentPane().setBackground(new Color(204, 255, 255));
		this.setSize(1300, 750);
		new CenterWindow().centerWindow(this);
		this.getContentPane().setLayout(null);
		this.setVisible(true);

		jPanel1 = new javax.swing.JPanel();
		jPanel1.setBackground(new Color(204, 255, 255));

		jBtnNewPartner = new javax.swing.JButton("Új partner");
		jBtnNewPartner.setBounds(1175, 11, 99, 34);
		this.getContentPane().add(jBtnNewPartner);
		jBtnNewPartner.addActionListener(new java.awt.event.ActionListener() {
			public void actionPerformed(java.awt.event.ActionEvent evt) {
				Btn_InsertActionPerformed(evt);
			}
		});

		jBtnDeletePartner = new javax.swing.JButton("Törlés");
		jBtnDeletePartner.setBounds(1175, 56, 99, 34);
		this.getContentPane().add(jBtnDeletePartner);
		jBtnDeletePartner.addActionListener(new java.awt.event.ActionListener() {
			public void actionPerformed(java.awt.event.ActionEvent evt) {
				jButton3ActionPerformed(evt);
			}
		});

		jBtnBack = new javax.swing.JButton("Vissza");
		jBtnBack.setBounds(1175, 666, 99, 34);
		this.getContentPane().add(jBtnBack);

		jBtnEditor = new javax.swing.JButton("Szerkesztés");
		jBtnEditor.setBounds(1044, 56, 112, 34);
		this.getContentPane().add(jBtnEditor);
		jBtnEditor.addActionListener(new java.awt.event.ActionListener() {
			public void actionPerformed(java.awt.event.ActionEvent evt) {
				jButton2ActionPerformed(evt);
			}
		});

		jBtnFirst = new javax.swing.JButton("");
		jBtnFirst.setBounds(457, 151, 28, 66);
		this.getContentPane().add(jBtnFirst);
		jBtnFirst.addActionListener(new java.awt.event.ActionListener() {
			public void actionPerformed(java.awt.event.ActionEvent evt) {
				Btn_FirstActionPerformed(evt);
			}
		});

		jBtnPrevious = new javax.swing.JButton("");
		jBtnPrevious.setBounds(457, 280, 28, 34);
		this.getContentPane().add(jBtnPrevious);
		jBtnPrevious.addActionListener(new java.awt.event.ActionListener() {
			public void actionPerformed(java.awt.event.ActionEvent evt) {
				Btn_PreviousActionPerformed(evt);
			}
		});

		jBtnNext = new javax.swing.JButton("");
		jBtnNext.setBounds(457, 500, 28, 34);
		this.getContentPane().add(jBtnNext);
		jBtnNext.addActionListener(new java.awt.event.ActionListener() {
			public void actionPerformed(java.awt.event.ActionEvent evt) {
				Btn_NextActionPerformed(evt);
			}
		});

		jBtnLast = new javax.swing.JButton("");
		jBtnLast.setBounds(457, 598, 28, 66);
		this.getContentPane().add(jBtnLast);
		jBtnLast.addActionListener(new java.awt.event.ActionListener() {
			public void actionPerformed(java.awt.event.ActionEvent evt) {
				Btn_LastActionPerformed(evt);
			}
		});

		jBtnSearch = new javax.swing.JButton("");
		jBtnSearch.setBounds(398, 70, 53, 20);
		this.getContentPane().add(jBtnSearch);

		jLblLabelA = new javax.swing.JLabel();
		Border a = BorderFactory.createLineBorder(Color.DARK_GRAY);
		a = BorderFactory.createTitledBorder(a, "Partner adatok", TitledBorder.CENTER, TitledBorder.TOP);
		jLblLabelA.setBorder(a);
		jLblLabelA.setBounds(495, 39, 670, 625);
		this.getContentPane().add(jLblLabelA);

		jLblLabelB = new javax.swing.JLabel();
		Border b = BorderFactory.createLineBorder(Color.DARK_GRAY);
		b = BorderFactory.createTitledBorder(b, "", TitledBorder.CENTER, TitledBorder.TOP);
		jLblLabelB.setBorder(b);
		jLblLabelB.setBounds(507, 56, 527, 595);
		this.getContentPane().add(jLblLabelB);

		jLblLabelC = new javax.swing.JLabel();
		Border c = BorderFactory.createLineBorder(Color.DARK_GRAY);
		c = BorderFactory.createTitledBorder(c, "Keresés", TitledBorder.CENTER, TitledBorder.TOP);
		jLblLabelC.setBorder(c);
		jLblLabelC.setBounds(10, 39, 452, 74);
		this.getContentPane().add(jLblLabelC);

		jLblPartnerName = new javax.swing.JLabel("Partner név:");
		jLblPartnerName.setHorizontalAlignment(SwingConstants.LEFT);
		jLblPartnerName.setFont(new Font("Tahoma", Font.BOLD, 14));
		jLblPartnerName.setBounds(517, 66, 130, 24);
		this.getContentPane().add(jLblPartnerName);

		jLblCompanyName = new javax.swing.JLabel("Megrendelő név:");
		jLblCompanyName.setHorizontalAlignment(SwingConstants.LEFT);
		jLblCompanyName.setFont(new Font("Tahoma", Font.BOLD, 14));
		jLblCompanyName.setBounds(517, 101, 130, 24);
		this.getContentPane().add(jLblCompanyName);

		jLblCountry = new javax.swing.JLabel("Ország:");
		jLblCountry.setHorizontalAlignment(SwingConstants.LEFT);
		jLblCountry.setFont(new Font("Tahoma", Font.BOLD, 14));
		jLblCountry.setBounds(517, 136, 130, 24);
		this.getContentPane().add(jLblCountry);

		jLblZipCodeCity = new javax.swing.JLabel("Irányítósz. Város:");
		jLblZipCodeCity.setHorizontalAlignment(SwingConstants.LEFT);
		jLblZipCodeCity.setFont(new Font("Tahoma", Font.BOLD, 14));
		jLblZipCodeCity.setBounds(517, 171, 130, 24);
		this.getContentPane().add(jLblZipCodeCity);

		jLblStreetHouseNumber = new javax.swing.JLabel("Utca Házszám:");
		jLblStreetHouseNumber.setHorizontalAlignment(SwingConstants.LEFT);
		jLblStreetHouseNumber.setFont(new Font("Tahoma", Font.BOLD, 14));
		jLblStreetHouseNumber.setBounds(517, 206, 130, 24);
		this.getContentPane().add(jLblStreetHouseNumber);

		jLblEmail = new javax.swing.JLabel("Email:");
		jLblEmail.setHorizontalAlignment(SwingConstants.LEFT);
		jLblEmail.setFont(new Font("Tahoma", Font.BOLD, 14));
		jLblEmail.setBounds(517, 241, 130, 24);
		this.getContentPane().add(jLblEmail);

		jLblLandlinePhone = new javax.swing.JLabel("Vezetékes Telefon:");
		jLblLandlinePhone.setHorizontalAlignment(SwingConstants.LEFT);
		jLblLandlinePhone.setFont(new Font("Tahoma", Font.BOLD, 14));
		jLblLandlinePhone.setBounds(517, 276, 130, 24);
		this.getContentPane().add(jLblLandlinePhone);

		jLblMobilePhone = new javax.swing.JLabel("Mobil:");
		jLblMobilePhone.setHorizontalAlignment(SwingConstants.LEFT);
		jLblMobilePhone.setFont(new Font("Tahoma", Font.BOLD, 14));
		jLblMobilePhone.setBounds(517, 311, 130, 24);
		this.getContentPane().add(jLblMobilePhone);

		jLblAccountNumber = new javax.swing.JLabel("Számlaszám:");
		jLblAccountNumber.setHorizontalAlignment(SwingConstants.LEFT);
		jLblAccountNumber.setFont(new Font("Tahoma", Font.BOLD, 14));
		jLblAccountNumber.setBounds(517, 346, 130, 24);
		this.getContentPane().add(jLblAccountNumber);

		jLblBanksName = new javax.swing.JLabel("Bank:");
		jLblBanksName.setHorizontalAlignment(SwingConstants.LEFT);
		jLblBanksName.setFont(new Font("Tahoma", Font.BOLD, 14));
		jLblBanksName.setBounds(517, 381, 130, 24);
		this.getContentPane().add(jLblBanksName);

		jLblAdministratorName = new javax.swing.JLabel("Ügyintéző:");
		jLblAdministratorName.setHorizontalAlignment(SwingConstants.LEFT);
		jLblAdministratorName.setFont(new Font("Tahoma", Font.BOLD, 14));
		jLblAdministratorName.setBounds(517, 416, 130, 24);
		this.getContentPane().add(jLblAdministratorName);

		jLblComment = new javax.swing.JLabel("Megjegyzés:");
		jLblComment.setHorizontalAlignment(SwingConstants.LEFT);
		jLblComment.setFont(new Font("Tahoma", Font.BOLD, 14));
		jLblComment.setBounds(517, 548, 130, 24);
		this.getContentPane().add(jLblComment);

		jLblPartnerCode = new javax.swing.JLabel("Partner kód: ");
		jLblPartnerCode.setHorizontalAlignment(SwingConstants.LEFT);
		jLblPartnerCode.setFont(new Font("Tahoma", Font.BOLD, 14));
		jLblPartnerCode.setBounds(517, 451, 130, 24);
		this.getContentPane().add(jLblPartnerCode);

		txtPartnerName = new javax.swing.JTextField();
		txtPartnerName.setBounds(657, 70, 362, 20);
		txtPartnerName.setColumns(10);
		this.getContentPane().add(txtPartnerName);

		txtCompanyName = new javax.swing.JTextField();
		txtCompanyName.setColumns(10);
		txtCompanyName.setBounds(657, 105, 362, 20);
		this.getContentPane().add(txtCompanyName);

		txtCountry = new javax.swing.JTextField();
		txtCountry.setColumns(10);
		txtCountry.setBounds(657, 140, 362, 20);
		this.getContentPane().add(txtCountry);

		txtZipCode = new javax.swing.JTextField();
		txtZipCode.setColumns(10);
		txtZipCode.setBounds(657, 171, 80, 20);
		this.getContentPane().add(txtZipCode);

		txtCity = new javax.swing.JTextField();
		txtCity.setColumns(10);
		txtCity.setBounds(753, 171, 266, 20);
		this.getContentPane().add(txtCity);

		txtHouseNumber = new javax.swing.JTextField();
		txtHouseNumber.setColumns(10);
		txtHouseNumber.setBounds(939, 210, 80, 20);
		this.getContentPane().add(txtHouseNumber);

		txtStreet = new javax.swing.JTextField();
		txtStreet.setColumns(10);
		txtStreet.setBounds(657, 210, 266, 20);
		this.getContentPane().add(txtStreet);

		txtEmail = new javax.swing.JTextField();
		txtEmail.setColumns(10);
		txtEmail.setBounds(657, 245, 362, 20);
		this.getContentPane().add(txtEmail);

		txtLandlinePhone = new javax.swing.JTextField();
		txtLandlinePhone.setColumns(10);
		txtLandlinePhone.setBounds(657, 280, 362, 20);
		this.getContentPane().add(txtLandlinePhone);

		txtMobilPhone = new javax.swing.JTextField();
		txtMobilPhone.setColumns(10);
		txtMobilPhone.setBounds(657, 315, 362, 20);
		this.getContentPane().add(txtMobilPhone);

		txtAccountNumber = new javax.swing.JTextField();
		txtAccountNumber.setColumns(10);
		txtAccountNumber.setBounds(657, 346, 362, 20);
		this.getContentPane().add(txtAccountNumber);

		txtBanksName = new javax.swing.JTextField();
		txtBanksName.setColumns(10);
		txtBanksName.setBounds(657, 381, 362, 20);
		this.getContentPane().add(txtBanksName);

		txtAdministratorName = new javax.swing.JTextField();
		txtAdministratorName.setColumns(10);
		txtAdministratorName.setBounds(657, 416, 362, 20);
		this.getContentPane().add(txtAdministratorName);

		txtComment = new javax.swing.JTextField();
		txtComment.setHorizontalAlignment(SwingConstants.LEFT);
		txtComment.setColumns(10);
		txtComment.setBounds(657, 552, 362, 85);
		this.getContentPane().add(txtComment);

		txtSearch = new javax.swing.JTextField();
		txtSearch.setColumns(10);
		txtSearch.setBounds(21, 70, 367, 20);
		this.getContentPane().add(txtSearch);

		txtPartnerCode = new javax.swing.JTextField();
		txtPartnerCode.setColumns(10);
		txtPartnerCode.setBounds(657, 455, 189, 20);
		this.getContentPane().add(txtPartnerCode);

		scrollPane_1 = new javax.swing.JScrollPane();
		scrollPane_1.setBounds(10, 124, 434, 540);
		this.getContentPane().add(scrollPane_1);

		JTable_Products = new javax.swing.JTable();
		JTable_Products
				.setModel(new javax.swing.table.DefaultTableModel(new Object[][] {}, new String[] { "Partner név" }));
		JTable_Products.addMouseListener(new java.awt.event.MouseAdapter() {
			public void mouseClicked(java.awt.event.MouseEvent evt) {
				JTable_ProductsMouseClicked(evt);
			}
		});
		scrollPane_1.setViewportView(JTable_Products);
	}

	private void Btn_InsertActionPerformed(java.awt.event.ActionEvent evt) {
		if (checkInputs() == true) {
			try {
				Connection con = getConnection();
				PreparedStatement INSERTINTO = con.prepareStatement(
						"INSERT INTO company(partner_code,partner_name,company_name,country,zip_code,city,"
								+ "street,house_number,email,landline_phone,mobile_phone,account_number,"
								+ "banks_name,administrator_name,comment)" + "values(?,?,?,?,?,?,?,?,?,?,?,?,?,?,?) ");
				INSERTINTO.setString(1, txtPartnerCode.getText());
				INSERTINTO.setString(2, txtPartnerName.getText());
				INSERTINTO.setString(3, txtCompanyName.getText());
				INSERTINTO.setString(4, txtCountry.getText());
				INSERTINTO.setString(5, txtZipCode.getText());
				INSERTINTO.setString(6, txtCity.getText());
				INSERTINTO.setString(7, txtStreet.getText());
				INSERTINTO.setString(8, txtHouseNumber.getText());
				INSERTINTO.setString(9, txtEmail.getText());
				INSERTINTO.setString(10, txtLandlinePhone.getText());
				INSERTINTO.setString(11, txtMobilPhone.getText());
				INSERTINTO.setString(12, txtAccountNumber.getText());
				INSERTINTO.setString(13, txtBanksName.getText());
				INSERTINTO.setString(14, txtAdministratorName.getText());
				INSERTINTO.setString(15, txtComment.getText());
				INSERTINTO.executeUpdate();
				Show_Products_In_JTable();
				JOptionPane.showMessageDialog(null, "Adatok beillesztve");
			} catch (Exception ex) {
				JOptionPane.showMessageDialog(null, "Sikertelen beillesztés: " + ex.getMessage());
			}
		} else {
			JOptionPane.showMessageDialog(null, "Egy vagy több mező üres");
		}

		System.out.println("1 =>" + txtPartnerCode.getText());
		System.out.println("2 =>" + txtPartnerName.getText());
		System.out.println("3 =>" + txtCompanyName.getText());
		System.out.println("4 =>" + txtCountry.getText());
		System.out.println("5 =>" + txtZipCode.getText());
		System.out.println("6 =>" + txtCity.getText());
		System.out.println("7 =>" + txtStreet.getText());
		System.out.println("8 =>" + txtHouseNumber.getText());
		System.out.println("9 =>" + txtEmail.getText());
		System.out.println("10 =>" + txtLandlinePhone.getText());
		System.out.println("11 =>" + txtMobilPhone.getText());
		System.out.println("12 =>" + txtAccountNumber.getText());
		System.out.println("13 =>" + txtBanksName.getText());
		System.out.println("14 =>" + txtAdministratorName.getText());
		System.out.println("15 =>" + txtComment.getText());

		System.out.println("Csekk=>: " + checkInputs());

	}

	private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {
		if (checkInputs() && txtPartnerCode.getText() != null) {
			String UPDATEQUERY = null;
			PreparedStatement ps = null;
			Connection con = getConnection();
			if (txtComment == null) {
				try {
					UPDATEQUERY = "UPDATE company SET partner_name = ?, company_name = ?"
							+ ", country = ?, zip_code = ?, city = ?, street = ?, house_number = ?, email = ?"
							+ ", landline_phone = ?, mobile_phone = ?, account_number = ?, banks_name = ?"
							+ ", administrator_name = ?, comment = ? WHERE partner_code = ?";
					ps = con.prepareStatement(UPDATEQUERY);
					ps.setString(1, txtPartnerCode.getText());
					ps.setString(2, txtPartnerName.getText());
					ps.setString(3, txtCompanyName.getText());
					ps.setString(4, txtCountry.getText());
					ps.setString(5, txtZipCode.getText());
					ps.setString(6, txtCity.getText());
					ps.setString(7, txtStreet.getText());
					ps.setString(8, txtHouseNumber.getText());
					ps.setString(9, txtEmail.getText());
					ps.setString(10, txtLandlinePhone.getText());
					ps.setString(11, txtMobilPhone.getText());
					ps.setString(12, txtAccountNumber.getText());
					ps.setString(13, txtBanksName.getText());
					ps.setString(14, txtAdministratorName.getText());
					ps.setString(15, txtComment.getText());
					ps.executeUpdate();
					Show_Products_In_JTable();
					JOptionPane.showMessageDialog(null, "Sikeres Frissítés");
				} catch (SQLException ex) {
					Logger.getLogger(WorkersSwing.class.getName()).log(Level.SEVERE, null, ex);
				}
			} else {
				try {
					UPDATEQUERY = "UPDATE company SET partner_name = ?, company_name = ?"
							+ ", country = ?, zip_code = ?, city = ?, street = ?, house_number = ?, email = ?"
							+ ", landline_phone = ?, mobile_phone = ?, account_number = ?, banks_name = ?"
							+ ", administrator_name = ?, comment = ? WHERE partner_code = ?";
					ps = con.prepareStatement(UPDATEQUERY);
					ps = con.prepareStatement(UPDATEQUERY);
					ps.setString(1, txtPartnerCode.getText());
					ps.setString(2, txtPartnerName.getText());
					ps.setString(3, txtCompanyName.getText());
					ps.setString(4, txtCountry.getText());
					ps.setString(5, txtZipCode.getText());
					ps.setString(6, txtCity.getText());
					ps.setString(7, txtStreet.getText());
					ps.setString(8, txtHouseNumber.getText());
					ps.setString(9, txtEmail.getText());
					ps.setString(10, txtLandlinePhone.getText());
					ps.setString(11, txtMobilPhone.getText());
					ps.setString(12, txtAccountNumber.getText());
					ps.setString(13, txtBanksName.getText());
					ps.setString(14, txtAdministratorName.getText());
					ps.setString(15, txtComment.getText());
					ps.executeUpdate();
					Show_Products_In_JTable();
					JOptionPane.showMessageDialog(null, "Sikeres Frissítés");
				} catch (Exception ex) {
					JOptionPane.showMessageDialog(null, ex.getMessage());
				}
			}
		} else {
			JOptionPane.showMessageDialog(null, "Egy vagy több mező üres vagy rossz");
		}
	}

	private void jButton3ActionPerformed(java.awt.event.ActionEvent evt) {
		if (!txtPartnerCode.getText().equals("")) {
			try {
				Connection con = getConnection();
				PreparedStatement DELETE = con.prepareStatement("DELETE FROM company WHERE partner_code = ?");
				int id = Integer.parseInt(txtPartnerCode.getText());
				DELETE.setInt(1, id);
				DELETE.executeUpdate();
				Show_Products_In_JTable();
				JOptionPane.showMessageDialog(null, "Sikeres törlés");
			} catch (SQLException ex) {
				Logger.getLogger(WorkersSwing.class.getName()).log(Level.SEVERE, null, ex);
				JOptionPane.showMessageDialog(null, "Sikertelen törlés");
			}
		} else {
			JOptionPane.showMessageDialog(null, "Sikertelen törlés : Nincs ID a törléshez");
		}
	}

	private void JTable_ProductsMouseClicked(java.awt.event.MouseEvent evt) {
		int index = JTable_Products.getSelectedRow();
		ShowItem(index);
	}

	private void Btn_FirstActionPerformed(java.awt.event.ActionEvent evt) {
		pos = 0;
		ShowItem(pos);
	}

	private void Btn_LastActionPerformed(java.awt.event.ActionEvent evt) {
		pos = getProductList().size() - 1;
		ShowItem(pos);
	}

	private void Btn_NextActionPerformed(java.awt.event.ActionEvent evt) {
		pos++;
		if (pos >= getProductList().size()) {
			pos = getProductList().size() - 1;
		}
		ShowItem(pos);
	}

	private void Btn_PreviousActionPerformed(java.awt.event.ActionEvent evt) {
		pos--;
		if (pos < 0) {
			pos = 0;
		}
		ShowItem(pos);
	}

	public void Start() {
		try {
			for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
				if ("Nimbus".equals(info.getName())) {
					javax.swing.UIManager.setLookAndFeel(info.getClassName());
					break;
				}
			}
		} catch (ClassNotFoundException ex) {
			java.util.logging.Logger.getLogger(WorkersSwing.class.getName()).log(java.util.logging.Level.SEVERE, null,
					ex);
		} catch (InstantiationException ex) {
			java.util.logging.Logger.getLogger(WorkersSwing.class.getName()).log(java.util.logging.Level.SEVERE, null,
					ex);
		} catch (IllegalAccessException ex) {
			java.util.logging.Logger.getLogger(WorkersSwing.class.getName()).log(java.util.logging.Level.SEVERE, null,
					ex);
		} catch (javax.swing.UnsupportedLookAndFeelException ex) {
			java.util.logging.Logger.getLogger(WorkersSwing.class.getName()).log(java.util.logging.Level.SEVERE, null,
					ex);
		}
		java.awt.EventQueue.invokeLater(new Runnable() {
			public void run() {
				new CompanySwing().setVisible(true);
			}
		});
	}

}
