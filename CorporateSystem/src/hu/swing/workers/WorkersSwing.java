package hu.swing.workers;

import java.awt.Dimension;
import java.awt.Font;
import java.awt.Image;
import java.io.File;
import java.io.FileInputStream;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;

import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.ImageIcon;
import javax.swing.JFileChooser;
import javax.swing.JOptionPane;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.filechooser.FileNameExtensionFilter;
import javax.swing.table.DefaultTableModel;

@SuppressWarnings("serial")
public class WorkersSwing extends javax.swing.JFrame {
	private javax.swing.JButton jBtn_Choose_Image, jBtn_First, jBtn_Insert, jBtn_Last, jBtn_Next, jBtn_Previous,
			jBtn_Update, jBtn_Delete;
	private javax.swing.JLabel jLbl_ID, jLbl_Name, jLbl_identification, jLbl_AddDate, jLbl_ExitDate, jLbl_SigCard,
			jLbl_HomeAddress, jLbl_TaxCard, jLbl_SocialSecurityCard, jLbl_Choose_Image, jLbl_image;
	private javax.swing.JTextField txt_HomeAddress, txt_SigCard, txt_TaxCard, txt_SocialSecurityCard, txt_id, txt_name,
			txt_identification;
	private com.toedter.calendar.JDateChooser txt_AddDate, txt_ExitDate;
	private javax.swing.JTable JTable_Products;
	private javax.swing.JPanel jPanel1;
	private javax.swing.JScrollPane jScrollPane1;
	static final String JDBC_DRIVER = "com.mysql.jdbc.Driver";
	static final String DB_URL = "jdbc:mysql://localhost/zrt";
	static final String USER = "root";
	static final String PASS = "12345";
	String ImgPath = null;
	int pos = 0;

	public WorkersSwing() {
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
			Logger.getLogger(WorkersSwing.class.getName()).log(Level.SEVERE, null, ex);
			return null;
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
			return null;
		}
	}

	public boolean checkInputs() {
		if (txt_name.getText() == null || txt_identification.getText() == null || txt_AddDate.getDate() == null
				|| txt_ExitDate.getDate() == null || txt_HomeAddress.getText() == null || txt_SigCard.getText() == null
				|| txt_TaxCard.getText() == null || txt_SocialSecurityCard.getText() == null) {
			return false;
		} else {
			try {
				Float.parseFloat(txt_identification.getText());
				return true;
			} catch (Exception ex) {
				return false;
			}
		}
	}

	public ImageIcon ResizeImage(String imagePath, byte[] pic) {
		ImageIcon myImage = null;
		if (imagePath != null) {
			myImage = new ImageIcon(imagePath);
		} else {
			myImage = new ImageIcon(pic);
		}
		Image img = myImage.getImage();
		Image img2 = img.getScaledInstance(jLbl_image.getWidth(), jLbl_image.getHeight(), Image.SCALE_SMOOTH);
		ImageIcon image = new ImageIcon(img2);
		return image;
	}

	public ArrayList<WorkersConfig> getProductList() {
		ArrayList<WorkersConfig> productList = new ArrayList<WorkersConfig>();
		Connection con = getConnection();
		String query = "SELECT * FROM workers";
		Statement st;
		ResultSet rs;
		try {
			st = con.createStatement();
			rs = st.executeQuery(query);
			WorkersConfig product;
			while (rs.next()) {
				product = new WorkersConfig(rs.getInt("id"), rs.getString("name"),
						Float.parseFloat(rs.getString("identification")), rs.getString("entry_date"),
						rs.getString("exit_date"), rs.getString("home_address"), rs.getString("id_card"),
						rs.getInt("tax_card"), rs.getInt("social_security_card"), rs.getBytes("image"));
				productList.add(product);
			}
		} catch (SQLException ex) {
			Logger.getLogger(WorkersSwing.class.getName()).log(Level.SEVERE, null, ex);
		}
		return productList;
	}

	public void Show_Products_In_JTable() {
		ArrayList<WorkersConfig> list = getProductList();
		DefaultTableModel model = (DefaultTableModel) JTable_Products.getModel();
		model.setRowCount(0);
		Object[] row = new Object[9];
		for (int i = 0; i < list.size(); i++) {
			row[0] = list.get(i).getId();
			row[1] = list.get(i).getName();
			row[2] = list.get(i).getIdentification();
			row[3] = list.get(i).getAddDate();
			row[4] = list.get(i).getExitDate();
			row[5] = list.get(i).getHomeAddress();
			row[6] = list.get(i).getIdCard();
			row[7] = list.get(i).getTaxCard();
			row[8] = list.get(i).getSocialSecurityCard();
			model.addRow(row);
		}
	}

	public void ShowItem(int index) {
		txt_id.setText(Integer.toString(getProductList().get(index).getId()));
		txt_name.setText(getProductList().get(index).getName());
		txt_identification.setText(Float.toString(getProductList().get(index).getIdentification()));
		try {
			Date addDate = null;
			Date exitDate = null;
			addDate = new SimpleDateFormat("yyyy-MM-dd").parse((String) getProductList().get(index).getAddDate());
			txt_AddDate.setDate(addDate);
			exitDate = new SimpleDateFormat("yyyy-MM-dd").parse((String) getProductList().get(index).getAddDate());
			txt_ExitDate.setDate(exitDate);
		} catch (ParseException ex) {
			Logger.getLogger(WorkersSwing.class.getName()).log(Level.SEVERE, null, ex);
		}
		txt_HomeAddress.setText(getProductList().get(index).getHomeAddress());
		txt_SigCard.setText(getProductList().get(index).getIdCard());
		txt_TaxCard.setText(Integer.toString(getProductList().get(index).getTaxCard()));
		txt_SocialSecurityCard.setText(Integer.toString(getProductList().get(index).getSocialSecurityCard()));
		jLbl_image.setIcon(ResizeImage(null, getProductList().get(index).getImage()));
	}

	private void initComponents() {
		jBtn_Choose_Image = new javax.swing.JButton();
		jBtn_Update = new javax.swing.JButton();
		jBtn_Delete = new javax.swing.JButton();
		jBtn_Insert = new javax.swing.JButton();
		jBtn_First = new javax.swing.JButton();
		jBtn_Previous = new javax.swing.JButton();
		jBtn_Last = new javax.swing.JButton();
		jBtn_Next = new javax.swing.JButton();
		jLbl_ID = new javax.swing.JLabel();
		jLbl_Name = new javax.swing.JLabel();
		jLbl_identification = new javax.swing.JLabel();
		jLbl_AddDate = new javax.swing.JLabel();
		jLbl_ExitDate = new javax.swing.JLabel();
		jLbl_Choose_Image = new javax.swing.JLabel();
		jLbl_image = new javax.swing.JLabel();
		jLbl_HomeAddress = new javax.swing.JLabel();
		jLbl_SigCard = new javax.swing.JLabel();
		jLbl_TaxCard = new javax.swing.JLabel();
		jLbl_SocialSecurityCard = new javax.swing.JLabel();
		txt_name = new javax.swing.JTextField();
		txt_id = new javax.swing.JTextField();
		txt_HomeAddress = new javax.swing.JTextField();
		txt_SigCard = new javax.swing.JTextField();
		txt_TaxCard = new javax.swing.JTextField();
		txt_SocialSecurityCard = new javax.swing.JTextField();
		txt_identification = new javax.swing.JTextField();
		txt_AddDate = new com.toedter.calendar.JDateChooser();
		txt_ExitDate = new com.toedter.calendar.JDateChooser();
		jPanel1 = new javax.swing.JPanel();
		jScrollPane1 = new javax.swing.JScrollPane();
		JTable_Products = new javax.swing.JTable();

		this.setPreferredSize(new Dimension(1300, 750));
		this.setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
		jPanel1.setBackground(new java.awt.Color(255, 255, 204));

		jLbl_ID.setFont(new java.awt.Font("Tahoma", 1, 18));
		jLbl_ID.setText("ID:");
		jLbl_Name.setFont(new java.awt.Font("Tahoma", 1, 18));
		jLbl_Name.setText("Név:");
		jLbl_identification.setFont(new java.awt.Font("Tahoma", 1, 18));
		jLbl_identification.setText("Azonosító:");
		jLbl_AddDate.setFont(new java.awt.Font("Tahoma", 1, 18));
		jLbl_AddDate.setText("Belépés:");
		jLbl_ExitDate.setFont(new Font("Tahoma", 1, 18));
		jLbl_ExitDate.setText("Kilépés:");
		jLbl_HomeAddress.setFont(new Font("Tahoma", 1, 18));
		jLbl_HomeAddress.setText("Lakcím:");
		jLbl_SigCard.setFont(new Font("Tahoma", 1, 18));
		jLbl_SigCard.setText("Szig. Szám:");
		jLbl_TaxCard.setFont(new Font("Tahoma", 1, 18));
		jLbl_TaxCard.setText("Adoszám:");
		jLbl_SocialSecurityCard.setFont(new Font("Tahoma", 1, 18));
		jLbl_SocialSecurityCard.setText("Tajszám:");
		jLbl_Choose_Image.setFont(new java.awt.Font("Tahoma", 1, 18));
		jLbl_Choose_Image.setText("Fénykép:");

		txt_id.setFont(new java.awt.Font("Tahoma", 1, 14));
		txt_id.setEnabled(false);
		txt_id.setPreferredSize(new java.awt.Dimension(59, 50));
		txt_name.setFont(new java.awt.Font("Tahoma", 1, 14));
		txt_name.setPreferredSize(new java.awt.Dimension(59, 50));
		txt_identification.setFont(new java.awt.Font("Tahoma", 1, 14));
		txt_identification.setPreferredSize(new java.awt.Dimension(59, 50));
		txt_AddDate.setFont(new java.awt.Font("Tahoma", 1, 11));
		txt_AddDate.setDateFormatString("yyyy-MM-dd");
		txt_ExitDate.setFont(new Font("Tahoma", 1, 11));
		txt_ExitDate.setDateFormatString("yyyy-MM-dd");
		txt_HomeAddress.setFont(new Font("Tahoma", 1, 14));
		txt_HomeAddress.setPreferredSize(new Dimension(59, 50));
		txt_SigCard.setFont(new Font("Tahoma", 1, 14));
		txt_SigCard.setPreferredSize(new Dimension(59, 50));
		txt_TaxCard.setFont(new Font("Tahoma", 1, 14));
		txt_TaxCard.setPreferredSize(new Dimension(59, 50));
		txt_SocialSecurityCard.setFont(new Font("Tahoma", 1, 14));
		txt_SocialSecurityCard.setPreferredSize(new Dimension(59, 50));
		jLbl_image.setBackground(new java.awt.Color(204, 255, 255));
		jLbl_image.setOpaque(true);

		JTable_Products.setModel(new javax.swing.table.DefaultTableModel(new Object[][] {}, new String[] { "ID", "Név",
				"Azonosító", "Belépés", "Kilépés", "Lakcím", "Szig. Szám", "Adószám", "Tajszám" }));
		JTable_Products.addMouseListener(new java.awt.event.MouseAdapter() {
			public void mouseClicked(java.awt.event.MouseEvent evt) {
				JTable_ProductsMouseClicked(evt);
			}
		});
		jScrollPane1.setViewportView(JTable_Products);

		jBtn_Choose_Image.setFont(new java.awt.Font("Tahoma", 1, 12));
		jBtn_Choose_Image.setText("Választás");
		jBtn_Choose_Image.addActionListener(new java.awt.event.ActionListener() {
			public void actionPerformed(java.awt.event.ActionEvent evt) {
				Btn_Choose_ImageActionPerformed(evt);
			}
		});

		jBtn_Update.setFont(new java.awt.Font("Tahoma", 1, 14));
		// jButtonUpdate.setIcon(new
		// javax.swing.ImageIcon("Image\\Workers\\updatebutton.png"));
		jBtn_Update.setText("frissítés");
		jBtn_Update.setIconTextGap(15);
		jBtn_Update.addActionListener(new java.awt.event.ActionListener() {
			public void actionPerformed(java.awt.event.ActionEvent evt) {
				jButton2ActionPerformed(evt);
			}
		});

		jBtn_Delete.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
		// jButton3.setIcon(new
		// javax.swing.ImageIcon(getClass().getResource("icons/delete.png")));
		jBtn_Delete.setText("Delete");
		jBtn_Delete.setIconTextGap(15);
		jBtn_Delete.addActionListener(new java.awt.event.ActionListener() {
			public void actionPerformed(java.awt.event.ActionEvent evt) {
				jButton3ActionPerformed(evt);
			}
		});

		jBtn_Insert.setFont(new java.awt.Font("Tahoma", 1, 14));
		// Btn_Insert.setIcon(new
		// javax.swing.ImageIcon(getClass().getResource("icons/add.png")));
		jBtn_Insert.setText("Új");
		jBtn_Insert.setIconTextGap(15);
		jBtn_Insert.addActionListener(new java.awt.event.ActionListener() {
			public void actionPerformed(java.awt.event.ActionEvent evt) {
				Btn_InsertActionPerformed(evt);
			}
		});

		jBtn_First.setFont(new java.awt.Font("Tahoma", 1, 14));
		// Btn_First.setIcon(new
		// javax.swing.ImageIcon(getClass().getResource("icons/first.png")));
		jBtn_First.setText("First");
		jBtn_First.setIconTextGap(15);
		jBtn_First.addActionListener(new java.awt.event.ActionListener() {
			public void actionPerformed(java.awt.event.ActionEvent evt) {
				Btn_FirstActionPerformed(evt);
			}
		});

		jBtn_Previous.setFont(new java.awt.Font("Tahoma", 1, 14));
		// Btn_Previous.setIcon(
		// new
		// javax.swing.ImageIcon(getClass().getResource("icons/previous.png")));
		jBtn_Previous.setText("Previous");
		jBtn_Previous.setIconTextGap(15);
		jBtn_Previous.addActionListener(new java.awt.event.ActionListener() {
			public void actionPerformed(java.awt.event.ActionEvent evt) {
				Btn_PreviousActionPerformed(evt);
			}
		});

		jBtn_Last.setFont(new java.awt.Font("Tahoma", 1, 14));
		// Btn_Last.setIcon(new
		// javax.swing.ImageIcon(getClass().getResource("icons/last.png")));
		jBtn_Last.setText("Last");
		jBtn_Last.setIconTextGap(15);
		jBtn_Last.addActionListener(new java.awt.event.ActionListener() {
			public void actionPerformed(java.awt.event.ActionEvent evt) {
				Btn_LastActionPerformed(evt);
			}
		});

		jBtn_Next.setFont(new java.awt.Font("Tahoma", 1, 14));
		// Btn_Next.setIcon(new
		// javax.swing.ImageIcon(getClass().getResource("icons/next.png")));
		jBtn_Next.setText("Next");
		jBtn_Next.setIconTextGap(15);
		jBtn_Next.addActionListener(new java.awt.event.ActionListener() {
			public void actionPerformed(java.awt.event.ActionEvent evt) {
				Btn_NextActionPerformed(evt);
			}
		});
		javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
		layout.setHorizontalGroup(layout.createParallelGroup(Alignment.LEADING).addGroup(Alignment.TRAILING,
				layout.createSequentialGroup().addContainerGap().addComponent(jPanel1, GroupLayout.DEFAULT_SIZE, 1284,
						Short.MAX_VALUE)));
		layout.setVerticalGroup(layout.createParallelGroup(Alignment.LEADING).addGroup(Alignment.TRAILING,
				layout.createSequentialGroup().addContainerGap().addComponent(jPanel1, GroupLayout.DEFAULT_SIZE, 711,
						Short.MAX_VALUE)));
		getContentPane().setLayout(layout);

		GroupLayout gl_jPanel1 = new GroupLayout(jPanel1);
		gl_jPanel1.setHorizontalGroup(gl_jPanel1.createParallelGroup(Alignment.LEADING).addGroup(gl_jPanel1
				.createSequentialGroup().addGap(33)
				.addGroup(gl_jPanel1.createParallelGroup(Alignment.TRAILING).addComponent(jLbl_Choose_Image)
						.addComponent(jLbl_ID).addComponent(jLbl_Name).addComponent(jLbl_identification)
						.addComponent(jLbl_HomeAddress).addComponent(jLbl_TaxCard).addComponent(jLbl_SigCard)
						.addComponent(jLbl_AddDate).addComponent(jLbl_ExitDate).addComponent(jLbl_SocialSecurityCard,
								GroupLayout.PREFERRED_SIZE, 87, GroupLayout.PREFERRED_SIZE))
				.addGap(10)
				.addGroup(gl_jPanel1.createParallelGroup(Alignment.LEADING)
						.addComponent(jLbl_image, GroupLayout.PREFERRED_SIZE, 227, GroupLayout.PREFERRED_SIZE)
						.addGroup(gl_jPanel1.createSequentialGroup().addGroup(gl_jPanel1
								.createParallelGroup(Alignment.LEADING)
								.addGroup(gl_jPanel1.createParallelGroup(Alignment.TRAILING, false)
										.addComponent(txt_id, Alignment.LEADING, GroupLayout.DEFAULT_SIZE,
												GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
										.addComponent(txt_name, Alignment.LEADING, GroupLayout.DEFAULT_SIZE, 125,
												Short.MAX_VALUE))
								.addComponent(txt_identification, GroupLayout.PREFERRED_SIZE, 125,
										GroupLayout.PREFERRED_SIZE)
								.addComponent(txt_AddDate, GroupLayout.PREFERRED_SIZE, 125, GroupLayout.PREFERRED_SIZE)
								.addComponent(txt_ExitDate, GroupLayout.PREFERRED_SIZE, 125, GroupLayout.PREFERRED_SIZE)
								.addComponent(txt_HomeAddress, GroupLayout.PREFERRED_SIZE, 125,
										GroupLayout.PREFERRED_SIZE)
								.addComponent(txt_SigCard, GroupLayout.PREFERRED_SIZE, 125, GroupLayout.PREFERRED_SIZE)
								.addComponent(txt_TaxCard, GroupLayout.PREFERRED_SIZE, 125, GroupLayout.PREFERRED_SIZE)
								.addComponent(txt_SocialSecurityCard, GroupLayout.PREFERRED_SIZE, 125,
										GroupLayout.PREFERRED_SIZE)
								.addComponent(jBtn_Choose_Image, GroupLayout.PREFERRED_SIZE, 227,
										GroupLayout.PREFERRED_SIZE))
								.addGap(18)
								.addGroup(gl_jPanel1.createParallelGroup(Alignment.TRAILING)
										.addGroup(gl_jPanel1.createSequentialGroup()
												.addComponent(jBtn_Insert, GroupLayout.PREFERRED_SIZE, 112,
														GroupLayout.PREFERRED_SIZE)
												.addPreferredGap(ComponentPlacement.RELATED)
												.addComponent(jBtn_Update, GroupLayout.PREFERRED_SIZE, 108,
														GroupLayout.PREFERRED_SIZE)
												.addPreferredGap(ComponentPlacement.RELATED)
												.addComponent(jBtn_Delete, GroupLayout.PREFERRED_SIZE, 108,
														GroupLayout.PREFERRED_SIZE)
												.addPreferredGap(ComponentPlacement.RELATED, 74, Short.MAX_VALUE)
												.addComponent(jBtn_First, GroupLayout.PREFERRED_SIZE, 103,
														GroupLayout.PREFERRED_SIZE)
												.addPreferredGap(ComponentPlacement.RELATED)
												.addComponent(jBtn_Next, GroupLayout.PREFERRED_SIZE, 98,
														GroupLayout.PREFERRED_SIZE)
												.addPreferredGap(ComponentPlacement.RELATED)
												.addComponent(jBtn_Previous, GroupLayout.PREFERRED_SIZE, 103,
														GroupLayout.PREFERRED_SIZE)
												.addPreferredGap(ComponentPlacement.RELATED)
												.addComponent(jBtn_Last, GroupLayout.PREFERRED_SIZE, 116,
														GroupLayout.PREFERRED_SIZE)
												.addGap(32))
										.addGroup(gl_jPanel1
												.createSequentialGroup().addComponent(jScrollPane1,
														GroupLayout.DEFAULT_SIZE, 874, Short.MAX_VALUE)
												.addContainerGap()))))));
		gl_jPanel1
				.setVerticalGroup(gl_jPanel1.createParallelGroup(Alignment.TRAILING).addGroup(gl_jPanel1
						.createSequentialGroup().addGroup(gl_jPanel1
								.createParallelGroup(
										Alignment.LEADING)
								.addGroup(gl_jPanel1.createSequentialGroup().addGap(20)
										.addGroup(gl_jPanel1.createParallelGroup(Alignment.BASELINE)
												.addComponent(txt_id, GroupLayout.PREFERRED_SIZE, 31,
														GroupLayout.PREFERRED_SIZE)
												.addComponent(jLbl_ID))
										.addPreferredGap(ComponentPlacement.RELATED)
										.addGroup(gl_jPanel1.createParallelGroup(Alignment.BASELINE)
												.addComponent(txt_name, GroupLayout.PREFERRED_SIZE, 30,
														GroupLayout.PREFERRED_SIZE)
												.addComponent(jLbl_Name))
										.addGap(6)
										.addGroup(gl_jPanel1.createParallelGroup(Alignment.BASELINE)
												.addComponent(txt_identification, GroupLayout.PREFERRED_SIZE, 30,
														GroupLayout.PREFERRED_SIZE)
												.addComponent(jLbl_identification))
										.addPreferredGap(ComponentPlacement.RELATED)
										.addGroup(gl_jPanel1.createParallelGroup(Alignment.LEADING)
												.addComponent(txt_AddDate, GroupLayout.PREFERRED_SIZE, 30,
														GroupLayout.PREFERRED_SIZE)
												.addComponent(jLbl_AddDate))
										.addPreferredGap(ComponentPlacement.RELATED)
										.addGroup(gl_jPanel1.createParallelGroup(Alignment.LEADING)
												.addComponent(txt_ExitDate, GroupLayout.PREFERRED_SIZE, 29,
														GroupLayout.PREFERRED_SIZE)
												.addComponent(jLbl_ExitDate))
										.addPreferredGap(ComponentPlacement.RELATED)
										.addGroup(gl_jPanel1.createParallelGroup(Alignment.LEADING)
												.addComponent(jLbl_HomeAddress, GroupLayout.PREFERRED_SIZE, 22,
														GroupLayout.PREFERRED_SIZE)
												.addComponent(txt_HomeAddress, GroupLayout.PREFERRED_SIZE, 30,
														GroupLayout.PREFERRED_SIZE))
										.addPreferredGap(ComponentPlacement.RELATED)
										.addGroup(gl_jPanel1.createParallelGroup(Alignment.BASELINE)
												.addComponent(txt_SigCard, GroupLayout.PREFERRED_SIZE, 30,
														GroupLayout.PREFERRED_SIZE)
												.addComponent(jLbl_SigCard, GroupLayout.PREFERRED_SIZE, 22,
														GroupLayout.PREFERRED_SIZE))
										.addPreferredGap(ComponentPlacement.RELATED)
										.addGroup(gl_jPanel1.createParallelGroup(Alignment.BASELINE)
												.addComponent(txt_TaxCard, GroupLayout.PREFERRED_SIZE, 30,
														GroupLayout.PREFERRED_SIZE)
												.addComponent(jLbl_TaxCard, GroupLayout.PREFERRED_SIZE, 22,
														GroupLayout.PREFERRED_SIZE))
										.addPreferredGap(ComponentPlacement.RELATED)
										.addGroup(gl_jPanel1.createParallelGroup(Alignment.LEADING)
												.addComponent(jLbl_SocialSecurityCard, GroupLayout.PREFERRED_SIZE, 22,
														GroupLayout.PREFERRED_SIZE)
												.addComponent(txt_SocialSecurityCard, GroupLayout.PREFERRED_SIZE, 30,
														GroupLayout.PREFERRED_SIZE)))
								.addGroup(gl_jPanel1.createSequentialGroup().addContainerGap().addComponent(
										jScrollPane1, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE,
										GroupLayout.PREFERRED_SIZE)))
						.addPreferredGap(ComponentPlacement.RELATED, 180, Short.MAX_VALUE)
						.addGroup(gl_jPanel1.createParallelGroup(Alignment.BASELINE)
								.addComponent(jBtn_Last, GroupLayout.PREFERRED_SIZE, 40, GroupLayout.PREFERRED_SIZE)
								.addComponent(jBtn_Next, GroupLayout.PREFERRED_SIZE, 40, GroupLayout.PREFERRED_SIZE)
								.addComponent(jBtn_First, GroupLayout.PREFERRED_SIZE, 40, GroupLayout.PREFERRED_SIZE)
								.addComponent(jBtn_Choose_Image, GroupLayout.PREFERRED_SIZE, 36,
										GroupLayout.PREFERRED_SIZE)
								.addComponent(jBtn_Previous, GroupLayout.PREFERRED_SIZE, 40, GroupLayout.PREFERRED_SIZE)
								.addComponent(jBtn_Insert, GroupLayout.PREFERRED_SIZE, 40, GroupLayout.PREFERRED_SIZE)
								.addComponent(jBtn_Update, GroupLayout.PREFERRED_SIZE, 40, GroupLayout.PREFERRED_SIZE)
								.addComponent(jBtn_Delete, GroupLayout.PREFERRED_SIZE, 40, GroupLayout.PREFERRED_SIZE))
						.addGap(42))
						.addGroup(gl_jPanel1.createSequentialGroup().addContainerGap(445, Short.MAX_VALUE)
								.addGroup(gl_jPanel1.createParallelGroup(Alignment.LEADING)
										.addComponent(jLbl_Choose_Image).addComponent(jLbl_image,
												GroupLayout.PREFERRED_SIZE, 167, GroupLayout.PREFERRED_SIZE))
								.addGap(88)));
		jPanel1.setLayout(gl_jPanel1);
		pack();
	}

	private void Btn_Choose_ImageActionPerformed(java.awt.event.ActionEvent evt) {
		JFileChooser file = new JFileChooser();
		file.setCurrentDirectory(new File(System.getProperty("user.home")));
		FileNameExtensionFilter filter = new FileNameExtensionFilter("*.images", "jpg", "png");
		file.addChoosableFileFilter(filter);
		int result = file.showSaveDialog(null);
		if (result == JFileChooser.APPROVE_OPTION) {
			File selectedFile = file.getSelectedFile();
			String path = selectedFile.getAbsolutePath();
			jLbl_image.setIcon(ResizeImage(path, null));
			ImgPath = path;
		} else {
			System.out.println("No File Selected");
		}
	}

	private void Btn_InsertActionPerformed(java.awt.event.ActionEvent evt) {
		if (checkInputs() && ImgPath != null) {
			try {
				Connection con = getConnection();
				PreparedStatement ps = con.prepareStatement(
						"INSERT INTO workers(name,identification,entry_date,exit_date,home_address,id_card,tax_card,social_security_card,image)"
								+ "values(?,?,?,?,?,?,?,?,?) ");
				ps.setString(1, txt_name.getText());
				ps.setString(2, txt_identification.getText());
				SimpleDateFormat addDateFormat = new SimpleDateFormat("yyyy-MM-dd");
				String addDate = addDateFormat.format(txt_AddDate.getDate());
				ps.setString(3, addDate);
				SimpleDateFormat exitDateFormat = new SimpleDateFormat("yyyy-MM-dd");
				String exitDate = exitDateFormat.format(txt_ExitDate.getDate());
				ps.setString(4, exitDate);
				ps.setString(5, txt_HomeAddress.getText());
				ps.setString(6, txt_SigCard.getText());
				ps.setString(7, txt_TaxCard.getText());
				ps.setString(8, txt_SocialSecurityCard.getText());
				InputStream img = new FileInputStream(new File(ImgPath));
				ps.setBlob(9, img);
				ps.executeUpdate();
				Show_Products_In_JTable();
				JOptionPane.showMessageDialog(null, "Adatok beillesztve");
			} catch (Exception ex) {
				JOptionPane.showMessageDialog(null, ex.getMessage());
			}
		} else {
			JOptionPane.showMessageDialog(null, "Egy vagy több mező üres");
		}

		System.out.println("Name =>" + txt_name.getText());
		System.out.println("identification => " + txt_identification.getText());
		System.out.println("Image => " + ImgPath);
	}

	private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {
		if (checkInputs() && txt_id.getText() != null) {
			String UpdateQuery = null;
			PreparedStatement ps = null;
			Connection con = getConnection();
			if (ImgPath == null) {
				try {
					UpdateQuery = "UPDATE workers SET name = ?, identification = ?"
							+ ", entry_date = ?, exit_date = ?, home_address = ?, id_card = ?, tax_card = ?, social_security_card = ?, WHERE id = ?";
					ps = con.prepareStatement(UpdateQuery);
					ps.setString(1, txt_name.getText());
					ps.setString(2, txt_identification.getText());
					SimpleDateFormat addDateFormat = new SimpleDateFormat("yyyy-MM-dd");
					String addDate = addDateFormat.format(txt_AddDate.getDate());
					SimpleDateFormat exitDateFormat = new SimpleDateFormat("yyyy-MM-dd");
					String exitDate = exitDateFormat.format(txt_ExitDate.getDate());
					ps.setString(3, addDate);
					ps.setString(4, exitDate);
					ps.setString(5, txt_HomeAddress.getText());
					ps.setString(6, txt_SigCard.getText());
					ps.setString(7, txt_TaxCard.getText());
					ps.setString(8, txt_SocialSecurityCard.getText());
					ps.setInt(9, Integer.parseInt(txt_id.getText()));
					ps.executeUpdate();
					Show_Products_In_JTable();
					JOptionPane.showMessageDialog(null, "Sikeres Frissítés");
				} catch (SQLException ex) {
					Logger.getLogger(WorkersSwing.class.getName()).log(Level.SEVERE, null, ex);
				}
			} else {
				try {
					InputStream img = new FileInputStream(new File(ImgPath));
					UpdateQuery = "UPDATE workers SET name = ?, identification = ?"
							+ ", entry_date = ?, exit_date = ?, home_address = ?, id_card = ?, tax_card = ?, social_security_card = ?, image = ? WHERE id = ?";
					ps = con.prepareStatement(UpdateQuery);
					ps.setString(1, txt_name.getText());
					ps.setString(2, txt_identification.getText());
					SimpleDateFormat addDateFormat = new SimpleDateFormat("yyyy-MM-dd");
					String addDate = addDateFormat.format(txt_AddDate.getDate());
					SimpleDateFormat exitDateFormat = new SimpleDateFormat("yyyy-MM-dd");
					String exitDate = exitDateFormat.format(txt_ExitDate.getDate());
					ps.setString(3, addDate);
					ps.setString(4, exitDate);
					ps.setString(5, txt_HomeAddress.getText());
					ps.setString(6, txt_SigCard.getText());
					ps.setString(7, txt_TaxCard.getText());
					ps.setString(8, txt_SocialSecurityCard.getText());
					ps.setBlob(9, img);
					ps.setInt(10, Integer.parseInt(txt_id.getText()));
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
		if (!txt_id.getText().equals("")) {
			try {
				Connection con = getConnection();
				PreparedStatement ps = con.prepareStatement("DELETE FROM workers WHERE id = ?");
				int id = Integer.parseInt(txt_id.getText());
				ps.setInt(1, id);
				ps.executeUpdate();
				Show_Products_In_JTable();
				JOptionPane.showMessageDialog(null, "Product Deleted");
			} catch (SQLException ex) {
				Logger.getLogger(WorkersSwing.class.getName()).log(Level.SEVERE, null, ex);
				JOptionPane.showMessageDialog(null, "Product Not Deleted");
			}
		} else {
			JOptionPane.showMessageDialog(null, "Product Not Deleted : No Id To Delete");
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
				new WorkersSwing().setVisible(true);
			}
		});
	}
}