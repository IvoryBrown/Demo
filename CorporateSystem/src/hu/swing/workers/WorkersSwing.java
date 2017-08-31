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

public class WorkersSwing extends javax.swing.JFrame {
	private javax.swing.JButton Btn_Choose_Image;
	private javax.swing.JButton Btn_First;
	private javax.swing.JButton jButtonInsert;
	private javax.swing.JButton Btn_Last;
	private javax.swing.JButton Btn_Next;
	private javax.swing.JButton Btn_Previous;

	private javax.swing.JTable JTable_Products;
	private javax.swing.JButton jButtonUpdate;
	private javax.swing.JButton jButtonDelete;
	private javax.swing.JLabel jLabelID;
	private javax.swing.JLabel jLabelNev;
	private javax.swing.JLabel jLabelAzonosito;
	private javax.swing.JLabel jLabelBelepes;
	private javax.swing.JLabel jLabelKilepes;
	private javax.swing.JLabel jLabelFenykep;
	private javax.swing.JPanel jPanel1;
	private javax.swing.JScrollPane jScrollPane1;
	private javax.swing.JLabel lbl_image;
	private com.toedter.calendar.JDateChooser txt_AddDate;
	private com.toedter.calendar.JDateChooser txt_ExitDate;
	private javax.swing.JTextField txt_id;
	private javax.swing.JTextField txt_name;
	private javax.swing.JTextField txt_identification;

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
				|| txt_ExitDate.getDate() == null) {
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
		Image img2 = img.getScaledInstance(lbl_image.getWidth(), lbl_image.getHeight(), Image.SCALE_SMOOTH);
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
						rs.getString("exit_date"), rs.getBytes("image"));
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
		Object[] row = new Object[5];
		for (int i = 0; i < list.size(); i++) {
			row[0] = list.get(i).getId();
			row[1] = list.get(i).getName();
			row[2] = list.get(i).getIdentification();
			row[3] = list.get(i).getAddDate();
			row[4] = list.get(i).getExitDate();
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
		lbl_image.setIcon(ResizeImage(null, getProductList().get(index).getImage()));
	}

	private void initComponents() {
		jPanel1 = new javax.swing.JPanel();
		jLabelID = new javax.swing.JLabel();
		jLabelNev = new javax.swing.JLabel();
		jLabelAzonosito = new javax.swing.JLabel();
		jLabelBelepes = new javax.swing.JLabel();
		jLabelKilepes = new javax.swing.JLabel();
		jLabelFenykep = new javax.swing.JLabel();
		txt_name = new javax.swing.JTextField();
		txt_id = new javax.swing.JTextField();
		txt_identification = new javax.swing.JTextField();
		txt_AddDate = new com.toedter.calendar.JDateChooser();
		txt_ExitDate = new com.toedter.calendar.JDateChooser();
		lbl_image = new javax.swing.JLabel();
		lbl_image.setEnabled(false);
		jScrollPane1 = new javax.swing.JScrollPane();
		JTable_Products = new javax.swing.JTable();
		Btn_Choose_Image = new javax.swing.JButton();
		jButtonUpdate = new javax.swing.JButton();
		jButtonDelete = new javax.swing.JButton();
		jButtonInsert = new javax.swing.JButton();
		Btn_First = new javax.swing.JButton();
		Btn_Previous = new javax.swing.JButton();
		Btn_Last = new javax.swing.JButton();
		Btn_Next = new javax.swing.JButton();

		getContentPane().setLayout(null);
		this.setPreferredSize(new Dimension(1300, 750));
		this.setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

		jPanel1.setBackground(new java.awt.Color(255, 255, 204));

		jLabelID.setFont(new java.awt.Font("Tahoma", 1, 18));
		jLabelID.setText("ID:");

		jLabelNev.setFont(new java.awt.Font("Tahoma", 1, 18));
		jLabelNev.setText("Név:");

		jLabelAzonosito.setFont(new java.awt.Font("Tahoma", 1, 18));
		jLabelAzonosito.setText("Azonosító:");

		jLabelBelepes.setFont(new java.awt.Font("Tahoma", 1, 18));
		jLabelBelepes.setText("Belépés:");

		jLabelKilepes.setFont(new Font("Tahoma", 1, 18));
		jLabelKilepes.setText("Kilépés:");

		jLabelFenykep.setFont(new java.awt.Font("Tahoma", 1, 18));
		jLabelFenykep.setText("Fénykép:");

		txt_name.setFont(new java.awt.Font("Tahoma", 1, 14));
		txt_name.setPreferredSize(new java.awt.Dimension(59, 50));

		txt_id.setFont(new java.awt.Font("Tahoma", 1, 14));
		txt_id.setEnabled(false);
		txt_id.setPreferredSize(new java.awt.Dimension(59, 50));

		txt_identification.setFont(new java.awt.Font("Tahoma", 1, 14));
		txt_identification.setPreferredSize(new java.awt.Dimension(59, 50));

		txt_AddDate.setDateFormatString("yyyy-MM-dd");
		txt_AddDate.setFont(new java.awt.Font("Tahoma", 1, 11));

		txt_ExitDate.setDateFormatString("yyyy-MM-dd");
		txt_ExitDate.setFont(new Font("Tahoma", 1, 11));

		lbl_image.setBackground(new java.awt.Color(204, 255, 255));
		lbl_image.setOpaque(true);

		JTable_Products.setModel(new javax.swing.table.DefaultTableModel(new Object[][] {

		}, new String[] { "ID", "Név", "Azonosító", "Belépés", "Kilépés", "Lakcím", "Sig", "Adószám", "Tajszám" }));
		JTable_Products.addMouseListener(new java.awt.event.MouseAdapter() {
			public void mouseClicked(java.awt.event.MouseEvent evt) {
				JTable_ProductsMouseClicked(evt);
			}
		});
		jScrollPane1.setViewportView(JTable_Products);

		Btn_Choose_Image.setFont(new java.awt.Font("Tahoma", 1, 12));
		Btn_Choose_Image.setText("Választás");
		Btn_Choose_Image.addActionListener(new java.awt.event.ActionListener() {
			public void actionPerformed(java.awt.event.ActionEvent evt) {
				Btn_Choose_ImageActionPerformed(evt);
			}
		});

		jButtonUpdate.setFont(new java.awt.Font("Tahoma", 1, 14));
		// jButtonUpdate.setIcon(new
		// javax.swing.ImageIcon("Image\\Workers\\updatebutton.png"));
		jButtonUpdate.setText("frissítés");
		jButtonUpdate.setIconTextGap(15);
		jButtonUpdate.addActionListener(new java.awt.event.ActionListener() {
			public void actionPerformed(java.awt.event.ActionEvent evt) {
				jButton2ActionPerformed(evt);
			}
		});

		jButtonDelete.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
		// jButton3.setIcon(new
		// javax.swing.ImageIcon(getClass().getResource("icons/delete.png")));
		jButtonDelete.setText("Delete");
		jButtonDelete.setIconTextGap(15);
		jButtonDelete.addActionListener(new java.awt.event.ActionListener() {
			public void actionPerformed(java.awt.event.ActionEvent evt) {
				jButton3ActionPerformed(evt);
			}
		});

		jButtonInsert.setFont(new java.awt.Font("Tahoma", 1, 14));
		// Btn_Insert.setIcon(new
		// javax.swing.ImageIcon(getClass().getResource("icons/add.png")));
		jButtonInsert.setText("Új");
		jButtonInsert.setIconTextGap(15);
		jButtonInsert.addActionListener(new java.awt.event.ActionListener() {
			public void actionPerformed(java.awt.event.ActionEvent evt) {
				Btn_InsertActionPerformed(evt);
			}
		});

		Btn_First.setFont(new java.awt.Font("Tahoma", 1, 14));
		// Btn_First.setIcon(new
		// javax.swing.ImageIcon(getClass().getResource("icons/first.png")));
		Btn_First.setText("First");
		Btn_First.setIconTextGap(15);
		Btn_First.addActionListener(new java.awt.event.ActionListener() {
			public void actionPerformed(java.awt.event.ActionEvent evt) {
				Btn_FirstActionPerformed(evt);
			}
		});

		Btn_Previous.setFont(new java.awt.Font("Tahoma", 1, 14));
		// Btn_Previous.setIcon(
		// new
		// javax.swing.ImageIcon(getClass().getResource("icons/previous.png")));
		Btn_Previous.setText("Previous");
		Btn_Previous.setIconTextGap(15);
		Btn_Previous.addActionListener(new java.awt.event.ActionListener() {
			public void actionPerformed(java.awt.event.ActionEvent evt) {
				Btn_PreviousActionPerformed(evt);
			}
		});

		Btn_Last.setFont(new java.awt.Font("Tahoma", 1, 14));
		// Btn_Last.setIcon(new
		// javax.swing.ImageIcon(getClass().getResource("icons/last.png")));
		Btn_Last.setText("Last");
		Btn_Last.setIconTextGap(15);
		Btn_Last.addActionListener(new java.awt.event.ActionListener() {
			public void actionPerformed(java.awt.event.ActionEvent evt) {
				Btn_LastActionPerformed(evt);
			}
		});

		Btn_Next.setFont(new java.awt.Font("Tahoma", 1, 14));
		// Btn_Next.setIcon(new
		// javax.swing.ImageIcon(getClass().getResource("icons/next.png")));
		Btn_Next.setText("Next");
		Btn_Next.setIconTextGap(15);
		Btn_Next.addActionListener(new java.awt.event.ActionListener() {
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
				.addGroup(gl_jPanel1.createParallelGroup(Alignment.TRAILING).addComponent(jLabelFenykep)
						.addComponent(jLabelID).addComponent(jLabelNev).addComponent(jLabelBelepes)
						.addComponent(jLabelAzonosito)
						.addComponent(jLabelKilepes, GroupLayout.PREFERRED_SIZE, 77, GroupLayout.PREFERRED_SIZE))
				.addGap(10)
				.addGroup(gl_jPanel1.createParallelGroup(Alignment.TRAILING).addGroup(gl_jPanel1.createSequentialGroup()
						.addComponent(Btn_Choose_Image, GroupLayout.PREFERRED_SIZE, 227, GroupLayout.PREFERRED_SIZE)
						.addPreferredGap(ComponentPlacement.RELATED, 93, Short.MAX_VALUE).addComponent(jButtonInsert)
						.addGap(60).addComponent(jButtonUpdate).addGap(41).addComponent(jButtonDelete).addGap(51)
						.addComponent(Btn_First).addGap(43).addComponent(Btn_Next).addGap(18).addComponent(Btn_Previous)
						.addGap(51).addComponent(Btn_Last, GroupLayout.PREFERRED_SIZE, 95, GroupLayout.PREFERRED_SIZE)
						.addGap(32))
						.addGroup(Alignment.LEADING, gl_jPanel1.createSequentialGroup().addGroup(gl_jPanel1
								.createParallelGroup(Alignment.LEADING)
								.addGroup(gl_jPanel1.createSequentialGroup().addGroup(gl_jPanel1
										.createParallelGroup(Alignment.LEADING)
										.addComponent(lbl_image, GroupLayout.PREFERRED_SIZE, 227,
												GroupLayout.PREFERRED_SIZE)
										.addGroup(gl_jPanel1.createParallelGroup(Alignment.TRAILING, false)
												.addComponent(txt_id, Alignment.LEADING, GroupLayout.DEFAULT_SIZE,
														GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
												.addComponent(txt_name, Alignment.LEADING, GroupLayout.DEFAULT_SIZE,
														125, Short.MAX_VALUE)))
										.addGap(55))
								.addComponent(txt_identification, GroupLayout.PREFERRED_SIZE, 125,
										GroupLayout.PREFERRED_SIZE)
								.addComponent(txt_AddDate, GroupLayout.PREFERRED_SIZE, 125, GroupLayout.PREFERRED_SIZE)
								.addComponent(txt_ExitDate, GroupLayout.PREFERRED_SIZE, 125,
										GroupLayout.PREFERRED_SIZE))
								.addPreferredGap(ComponentPlacement.RELATED, 9, Short.MAX_VALUE)
								.addComponent(jScrollPane1, GroupLayout.PREFERRED_SIZE, 836, GroupLayout.PREFERRED_SIZE)
								.addContainerGap()))));
		gl_jPanel1
				.setVerticalGroup(gl_jPanel1.createParallelGroup(Alignment.TRAILING).addGroup(gl_jPanel1
						.createSequentialGroup().addGroup(gl_jPanel1
								.createParallelGroup(
										Alignment.LEADING)
								.addGroup(gl_jPanel1.createSequentialGroup().addGap(20)
										.addGroup(gl_jPanel1.createParallelGroup(Alignment.BASELINE)
												.addComponent(txt_id, GroupLayout.PREFERRED_SIZE, 31,
														GroupLayout.PREFERRED_SIZE)
												.addComponent(jLabelID))
										.addPreferredGap(ComponentPlacement.RELATED)
										.addGroup(gl_jPanel1.createParallelGroup(Alignment.BASELINE)
												.addComponent(txt_name, GroupLayout.PREFERRED_SIZE, 30,
														GroupLayout.PREFERRED_SIZE)
												.addComponent(jLabelNev))
										.addGap(6)
										.addGroup(gl_jPanel1.createParallelGroup(Alignment.BASELINE)
												.addComponent(txt_identification, GroupLayout.PREFERRED_SIZE, 30,
														GroupLayout.PREFERRED_SIZE)
												.addComponent(jLabelAzonosito))
										.addPreferredGap(ComponentPlacement.RELATED)
										.addGroup(gl_jPanel1.createParallelGroup(Alignment.LEADING)
												.addComponent(txt_AddDate, GroupLayout.PREFERRED_SIZE, 30,
														GroupLayout.PREFERRED_SIZE)
												.addComponent(jLabelBelepes))
										.addPreferredGap(ComponentPlacement.RELATED)
										.addGroup(gl_jPanel1.createParallelGroup(Alignment.LEADING)
												.addComponent(jLabelKilepes).addComponent(txt_ExitDate,
														GroupLayout.PREFERRED_SIZE, 29, GroupLayout.PREFERRED_SIZE)))
								.addGroup(gl_jPanel1.createSequentialGroup().addContainerGap().addComponent(
										jScrollPane1, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE,
										GroupLayout.PREFERRED_SIZE)))
						.addPreferredGap(ComponentPlacement.RELATED, 180, Short.MAX_VALUE)
						.addGroup(gl_jPanel1.createParallelGroup(Alignment.BASELINE)
								.addComponent(Btn_Last, GroupLayout.PREFERRED_SIZE, 40, GroupLayout.PREFERRED_SIZE)
								.addComponent(Btn_Previous, GroupLayout.PREFERRED_SIZE, 40, GroupLayout.PREFERRED_SIZE)
								.addComponent(Btn_Next, GroupLayout.PREFERRED_SIZE, 40, GroupLayout.PREFERRED_SIZE)
								.addComponent(Btn_First, GroupLayout.PREFERRED_SIZE, 40, GroupLayout.PREFERRED_SIZE)
								.addComponent(jButtonDelete, GroupLayout.PREFERRED_SIZE, 40, GroupLayout.PREFERRED_SIZE)
								.addComponent(jButtonUpdate, GroupLayout.PREFERRED_SIZE, 40, GroupLayout.PREFERRED_SIZE)
								.addComponent(jButtonInsert, GroupLayout.PREFERRED_SIZE, 40, GroupLayout.PREFERRED_SIZE)
								.addComponent(Btn_Choose_Image, GroupLayout.PREFERRED_SIZE, 36,
										GroupLayout.PREFERRED_SIZE))
						.addGap(42))
						.addGroup(gl_jPanel1.createSequentialGroup().addContainerGap(445, Short.MAX_VALUE)
								.addGroup(gl_jPanel1.createParallelGroup(Alignment.LEADING).addComponent(jLabelFenykep)
										.addComponent(lbl_image, GroupLayout.PREFERRED_SIZE, 167,
												GroupLayout.PREFERRED_SIZE))
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
			lbl_image.setIcon(ResizeImage(path, null));
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
						"INSERT INTO workers(name,identification,entry_date,exit_date,image)" + "values(?,?,?,?,?) ");
				ps.setString(1, txt_name.getText());
				ps.setString(2, txt_identification.getText());
				SimpleDateFormat addDateFormat = new SimpleDateFormat("yyyy-MM-dd");
				String addDate = addDateFormat.format(txt_AddDate.getDate());
				ps.setString(3, addDate);
				SimpleDateFormat exitDateFormat = new SimpleDateFormat("yyyy-MM-dd");
				String exitDate = exitDateFormat.format(txt_ExitDate.getDate());
				ps.setString(4, exitDate);
				InputStream img = new FileInputStream(new File(ImgPath));
				ps.setBlob(5, img);
				ps.executeUpdate();
				Show_Products_In_JTable();
				JOptionPane.showMessageDialog(null, "Data Inserted");
			} catch (Exception ex) {
				JOptionPane.showMessageDialog(null, ex.getMessage());
			}
		} else {
			JOptionPane.showMessageDialog(null, "One Or More Field Are Empty");
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
							+ ", entry_date = ?, exit_date=? WHERE id = ?";
					ps = con.prepareStatement(UpdateQuery);
					ps.setString(1, txt_name.getText());
					ps.setString(2, txt_identification.getText());
					SimpleDateFormat addDateFormat = new SimpleDateFormat("yyyy-MM-dd");
					String addDate = addDateFormat.format(txt_AddDate.getDate());
					SimpleDateFormat exitDateFormat = new SimpleDateFormat("yyyy-MM-dd");
					String exitDate = exitDateFormat.format(txt_ExitDate.getDate());
					ps.setString(3, addDate);
					ps.setString(4, exitDate);
					ps.setInt(5, Integer.parseInt(txt_id.getText()));
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
							+ ", entry_date = ?,exit_date=?, image = ? WHERE id = ?";
					ps = con.prepareStatement(UpdateQuery);
					ps.setString(1, txt_name.getText());
					ps.setString(2, txt_identification.getText());
					SimpleDateFormat addDateFormat = new SimpleDateFormat("yyyy-MM-dd");
					String addDate = addDateFormat.format(txt_AddDate.getDate());
					SimpleDateFormat exitDateFormat = new SimpleDateFormat("yyyy-MM-dd");
					String exitDate = exitDateFormat.format(txt_ExitDate.getDate());
					ps.setString(3, addDate);
					ps.setString(4, exitDate);
					ps.setBlob(5, img);
					ps.setInt(6, Integer.parseInt(txt_id.getText()));
					ps.executeUpdate();
					Show_Products_In_JTable();
					JOptionPane.showMessageDialog(null, "Sikeres Frissítés");
				} catch (Exception ex) {
					JOptionPane.showMessageDialog(null, ex.getMessage());
				}
			}
		} else {
			JOptionPane.showMessageDialog(null, "One Or More Fields Are Empty Or Wrong");
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