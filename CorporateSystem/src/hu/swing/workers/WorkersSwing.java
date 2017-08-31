package hu.swing.workers;

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

	public WorkersSwing() {
		initComponents();
		Show_Products_In_JTable();
	}

	String ImgPath = null;
	int pos = 0;

	// Function To Connect To MySQL Database
	public Connection getConnection() {
		Connection con = null;

		try {
			Class.forName("com.mysql.jdbc.Driver");
			con = DriverManager.getConnection("jdbc:mysql://localhost:3306/zrt", "root", "12345");
			return con;
		} catch (SQLException ex) {
			Logger.getLogger(WorkersSwing.class.getName()).log(Level.SEVERE, null, ex);
			return null;
		} catch (ClassNotFoundException e) {
			// TODO Automatikusan előállított elfogási blokk
			e.printStackTrace();
			return null;
		}
	}

	// Check Input Fields
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

	// Function To Resize The Image To Fit Into JLabel
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

	// Display Data In JTable:
	// 1 - Fill ArrayList With The Data

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

	// 2 - Populate The JTable

	public void Show_Products_In_JTable() {
		ArrayList<WorkersConfig> list = getProductList();
		DefaultTableModel model = (DefaultTableModel) JTable_Products.getModel();
		// clear jtable content
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

	// Show Data In Inputs
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

	/**
	 * This method is called from within the constructor to initialize the form.
	 * WARNING: Do NOT modify this code. The content of this method is always
	 * regenerated by the Form Editor.
	 */
	@SuppressWarnings("unchecked")
	// <editor-fold defaultstate="collapsed" desc="Generated Code">
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

		setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

		jPanel1.setBackground(new java.awt.Color(255, 255, 204));

		jLabelID.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
		jLabelID.setText("ID:");

		jLabelNev.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
		jLabelNev.setText("Név:");

		jLabelAzonosito.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
		jLabelAzonosito.setText("Azonosító:");

		jLabelBelepes.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
		jLabelBelepes.setText("Belépés:");

		jLabelKilepes.setFont(new Font("Tahoma", 1, 18));
		jLabelKilepes.setText("Kilépés:");

		jLabelFenykep.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
		jLabelFenykep.setText("Fénykép:");

		txt_name.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
		txt_name.setPreferredSize(new java.awt.Dimension(59, 50));

		txt_id.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
		txt_id.setEnabled(false);
		txt_id.setPreferredSize(new java.awt.Dimension(59, 50));

		txt_identification.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
		txt_identification.setPreferredSize(new java.awt.Dimension(59, 50));

		txt_AddDate.setDateFormatString("yyyy-MM-dd");
		txt_AddDate.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N

		txt_ExitDate.setDateFormatString("yyyy-MM-dd");
		txt_ExitDate.setFont(new Font("Tahoma", Font.BOLD, 11));

		lbl_image.setBackground(new java.awt.Color(204, 255, 255));
		lbl_image.setOpaque(true);

		JTable_Products.setModel(new javax.swing.table.DefaultTableModel(new Object[][] {

		}, new String[] { "ID", "Név", "Azonosító", "Belépés", "Kilépés" }));
		JTable_Products.addMouseListener(new java.awt.event.MouseAdapter() {
			public void mouseClicked(java.awt.event.MouseEvent evt) {
				JTable_ProductsMouseClicked(evt);
			}
		});
		jScrollPane1.setViewportView(JTable_Products);

		Btn_Choose_Image.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
		Btn_Choose_Image.setText("Választás");
		Btn_Choose_Image.addActionListener(new java.awt.event.ActionListener() {
			public void actionPerformed(java.awt.event.ActionEvent evt) {
				Btn_Choose_ImageActionPerformed(evt);
			}
		});

		jButtonUpdate.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
		// jButton2.setIcon(new
		// javax.swing.ImageIcon(getClass().getResource("/JAVA_VIDEOS_TUTORIALS/icons/Renew.png")));
		// // NOI18N
		jButtonUpdate.setText("Update");
		jButtonUpdate.setIconTextGap(15);
		jButtonUpdate.addActionListener(new java.awt.event.ActionListener() {
			public void actionPerformed(java.awt.event.ActionEvent evt) {
				jButton2ActionPerformed(evt);
			}
		});

		jButtonDelete.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
		// jButton3.setIcon(new
		// javax.swing.ImageIcon(getClass().getResource("/JAVA_VIDEOS_TUTORIALS/icons/delete.png")));
		// // NOI18N
		jButtonDelete.setText("Delete");
		jButtonDelete.setIconTextGap(15);
		jButtonDelete.addActionListener(new java.awt.event.ActionListener() {
			public void actionPerformed(java.awt.event.ActionEvent evt) {
				jButton3ActionPerformed(evt);
			}
		});

		jButtonInsert.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
		// Btn_Insert.setIcon(new
		// javax.swing.ImageIcon(getClass().getResource("/JAVA_VIDEOS_TUTORIALS/icons/add.png")));
		// // NOI18N
		jButtonInsert.setText("Új");
		jButtonInsert.setIconTextGap(15);
		jButtonInsert.addActionListener(new java.awt.event.ActionListener() {
			public void actionPerformed(java.awt.event.ActionEvent evt) {
				Btn_InsertActionPerformed(evt);
			}
		});

		Btn_First.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
		// Btn_First.setIcon(new
		// javax.swing.ImageIcon(getClass().getResource("/JAVA_VIDEOS_TUTORIALS/icons/first.png")));
		// // NOI18N
		Btn_First.setText("First");
		Btn_First.setIconTextGap(15);
		Btn_First.addActionListener(new java.awt.event.ActionListener() {
			public void actionPerformed(java.awt.event.ActionEvent evt) {
				Btn_FirstActionPerformed(evt);
			}
		});

		Btn_Previous.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
		// Btn_Previous.setIcon(
		// new
		// javax.swing.ImageIcon(getClass().getResource("/JAVA_VIDEOS_TUTORIALS/icons/previous.png")));
		// // NOI18N
		Btn_Previous.setText("Previous");
		Btn_Previous.setIconTextGap(15);
		Btn_Previous.addActionListener(new java.awt.event.ActionListener() {
			public void actionPerformed(java.awt.event.ActionEvent evt) {
				Btn_PreviousActionPerformed(evt);
			}
		});

		Btn_Last.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
		// Btn_Last.setIcon(new
		// javax.swing.ImageIcon(getClass().getResource("/JAVA_VIDEOS_TUTORIALS/icons/last.png")));
		// // NOI18N
		Btn_Last.setText("Last");
		Btn_Last.setIconTextGap(15);
		Btn_Last.addActionListener(new java.awt.event.ActionListener() {
			public void actionPerformed(java.awt.event.ActionEvent evt) {
				Btn_LastActionPerformed(evt);
			}
		});

		Btn_Next.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
		// Btn_Next.setIcon(new
		// javax.swing.ImageIcon(getClass().getResource("/JAVA_VIDEOS_TUTORIALS/icons/next.png")));
		// // NOI18N
		Btn_Next.setText("Next");
		Btn_Next.setIconTextGap(15);
		Btn_Next.addActionListener(new java.awt.event.ActionListener() {
			public void actionPerformed(java.awt.event.ActionEvent evt) {
				Btn_NextActionPerformed(evt);
			}
		});

		javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
		jPanel1Layout
				.setHorizontalGroup(jPanel1Layout.createParallelGroup(Alignment.LEADING)
						.addGroup(jPanel1Layout.createSequentialGroup().addGroup(jPanel1Layout
								.createParallelGroup(
										Alignment.LEADING)
								.addGroup(jPanel1Layout.createSequentialGroup().addGap(33)
										.addGroup(jPanel1Layout.createParallelGroup(Alignment.TRAILING)
												.addComponent(jLabelBelepes).addComponent(jLabelID)
												.addComponent(jLabelNev).addComponent(jLabelAzonosito)
												.addComponent(jLabelFenykep).addComponent(jLabelKilepes,
														GroupLayout.PREFERRED_SIZE, 77, GroupLayout.PREFERRED_SIZE))
										.addPreferredGap(ComponentPlacement.UNRELATED)
										.addGroup(
												jPanel1Layout
														.createParallelGroup(Alignment.LEADING).addGroup(
																jPanel1Layout
																		.createSequentialGroup()
																		.addGroup(jPanel1Layout
																				.createParallelGroup(Alignment.LEADING)
																				.addComponent(Btn_Choose_Image,
																						GroupLayout.DEFAULT_SIZE, 227,
																						Short.MAX_VALUE)
																				.addComponent(
																						txt_id,
																						GroupLayout.PREFERRED_SIZE, 109,
																						GroupLayout.PREFERRED_SIZE)
																				.addComponent(lbl_image,
																						GroupLayout.DEFAULT_SIZE, 227,
																						Short.MAX_VALUE)
																				.addGroup(jPanel1Layout
																						.createParallelGroup(
																								Alignment.TRAILING,
																								false)
																						.addComponent(txt_AddDate,
																								Alignment.LEADING,
																								GroupLayout.DEFAULT_SIZE,
																								125, Short.MAX_VALUE)
																						.addComponent(txt_ExitDate,
																								Alignment.LEADING,
																								GroupLayout.DEFAULT_SIZE,
																								125, Short.MAX_VALUE)
																						.addComponent(txt_name,
																								Alignment.LEADING,
																								GroupLayout.DEFAULT_SIZE,
																								GroupLayout.DEFAULT_SIZE,
																								Short.MAX_VALUE)
																						.addComponent(
																								txt_identification,
																								Alignment.LEADING,
																								GroupLayout.DEFAULT_SIZE,
																								GroupLayout.DEFAULT_SIZE,
																								Short.MAX_VALUE)))
																		.addGap(98))
														.addGroup(jPanel1Layout.createSequentialGroup()
																.addComponent(txt_ExitDate, GroupLayout.PREFERRED_SIZE,
																		125, GroupLayout.PREFERRED_SIZE)
																.addPreferredGap(ComponentPlacement.RELATED)))
										.addComponent(jScrollPane1, GroupLayout.PREFERRED_SIZE,
												GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
								.addGroup(jPanel1Layout.createSequentialGroup().addContainerGap()
										.addComponent(jButtonInsert).addGap(10).addComponent(jButtonUpdate)
										.addPreferredGap(ComponentPlacement.UNRELATED).addComponent(jButtonDelete)
										.addGap(45).addComponent(Btn_First).addPreferredGap(ComponentPlacement.RELATED)
										.addComponent(Btn_Next).addPreferredGap(ComponentPlacement.RELATED)
										.addComponent(Btn_Previous).addPreferredGap(ComponentPlacement.UNRELATED)
										.addComponent(Btn_Last)))
								.addContainerGap()));
		jPanel1Layout
				.setVerticalGroup(jPanel1Layout.createParallelGroup(Alignment.TRAILING)
						.addGroup(jPanel1Layout
								.createSequentialGroup().addGroup(jPanel1Layout.createParallelGroup(
										Alignment.LEADING)
										.addGroup(jPanel1Layout.createSequentialGroup()
												.addGap(20).addGroup(jPanel1Layout
														.createParallelGroup(Alignment.LEADING)
														.addComponent(txt_id, GroupLayout.PREFERRED_SIZE, 40,
																GroupLayout.PREFERRED_SIZE)
														.addComponent(jLabelID))
												.addGap(9)
												.addGroup(jPanel1Layout.createParallelGroup(Alignment.LEADING)
														.addComponent(txt_name, GroupLayout.PREFERRED_SIZE, 40,
																GroupLayout.PREFERRED_SIZE)
														.addComponent(jLabelNev))
												.addGap(14)
												.addGroup(jPanel1Layout.createParallelGroup(Alignment.LEADING)
														.addComponent(jLabelAzonosito).addComponent(txt_identification,
																GroupLayout.PREFERRED_SIZE, 40,
																GroupLayout.PREFERRED_SIZE))
												.addGroup(jPanel1Layout.createParallelGroup(Alignment.LEADING)
														.addGroup(jPanel1Layout.createSequentialGroup().addGap(21)
																.addComponent(jLabelBelepes))
														.addGroup(jPanel1Layout.createSequentialGroup()
																.addPreferredGap(ComponentPlacement.UNRELATED)
																.addComponent(txt_AddDate, GroupLayout.PREFERRED_SIZE,
																		41, GroupLayout.PREFERRED_SIZE)))
												.addGroup(jPanel1Layout.createParallelGroup(Alignment.LEADING)
														.addGroup(jPanel1Layout.createSequentialGroup().addGap(18)
																.addComponent(txt_ExitDate, GroupLayout.PREFERRED_SIZE,
																		41, GroupLayout.PREFERRED_SIZE))
														.addGroup(jPanel1Layout.createSequentialGroup().addGap(27)
																.addComponent(jLabelKilepes, GroupLayout.PREFERRED_SIZE,
																		22, GroupLayout.PREFERRED_SIZE))))
										.addGroup(jPanel1Layout.createSequentialGroup().addContainerGap().addComponent(
												jScrollPane1, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE,
												GroupLayout.PREFERRED_SIZE)))
								.addPreferredGap(ComponentPlacement.RELATED, 111, Short.MAX_VALUE)
								.addGroup(jPanel1Layout.createParallelGroup(Alignment.TRAILING)
										.addGroup(jPanel1Layout.createSequentialGroup()
												.addComponent(Btn_Choose_Image, GroupLayout.PREFERRED_SIZE, 36,
														GroupLayout.PREFERRED_SIZE)
												.addGap(82))
										.addGroup(jPanel1Layout.createSequentialGroup()
												.addGroup(jPanel1Layout.createParallelGroup(Alignment.BASELINE)
														.addComponent(jButtonInsert, GroupLayout.PREFERRED_SIZE, 40,
																GroupLayout.PREFERRED_SIZE)
														.addComponent(jButtonUpdate, GroupLayout.PREFERRED_SIZE, 40,
																GroupLayout.PREFERRED_SIZE)
														.addComponent(jButtonDelete, GroupLayout.PREFERRED_SIZE, 40,
																GroupLayout.PREFERRED_SIZE)
														.addComponent(Btn_First, GroupLayout.PREFERRED_SIZE, 40,
																GroupLayout.PREFERRED_SIZE)
														.addComponent(Btn_Next, GroupLayout.PREFERRED_SIZE, 40,
																GroupLayout.PREFERRED_SIZE)
														.addComponent(Btn_Previous, GroupLayout.PREFERRED_SIZE, 40,
																GroupLayout.PREFERRED_SIZE)
														.addComponent(Btn_Last, GroupLayout.PREFERRED_SIZE, 40,
																GroupLayout.PREFERRED_SIZE))
												.addContainerGap())))
						.addGroup(jPanel1Layout.createSequentialGroup().addContainerGap(364, Short.MAX_VALUE)
								.addGroup(jPanel1Layout.createParallelGroup(Alignment.LEADING)
										.addComponent(jLabelFenykep).addComponent(lbl_image, GroupLayout.PREFERRED_SIZE,
												167, GroupLayout.PREFERRED_SIZE))
								.addGap(136)));
		jPanel1.setLayout(jPanel1Layout);

		javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
		getContentPane().setLayout(layout);
		layout.setHorizontalGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING).addComponent(
				jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE));
		layout.setVerticalGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING).addComponent(
				jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE));

		pack();
	}// </editor-fold>

	// Button Browse Image From Your Computer
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

	// Button Insert Data Into MySQL Database
	// 1 - Check If The imgPath Is Not Null And The Inputs Are Not Empty
	// 2 - Insert The Data
	private void Btn_InsertActionPerformed(java.awt.event.ActionEvent evt) {
		if (checkInputs() && ImgPath != null) {
			try {
				Connection con = getConnection();
				PreparedStatement ps = con.prepareStatement(
						"INSERT INTO workers(name,identification,entry_date,exit_date,image)" + "values(?,?,?,?,?) ");
				ps.setString(1, txt_name.getText());
				ps.setString(2, txt_identification.getText());

				SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
				String addDate = dateFormat.format(txt_AddDate.getDate());
				ps.setString(3, addDate);
				SimpleDateFormat dateFormat1 = new SimpleDateFormat("yyyy-MM-dd");
				String exitDate = dateFormat1.format(txt_ExitDate.getDate());
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

		// only for test
		System.out.println("Name => " + txt_name.getText());
		System.out.println("identification => " + txt_identification.getText());
		System.out.println("Image => " + ImgPath);
	}

	// Button Update Data From MySQL Database
	// 1 - Check If Inputs Is Not Null
	// If The imgPath Is Not Null Update Also The Image
	// else don't update the Image
	// 2 - Update The Data
	private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {

		if (checkInputs() && txt_id.getText() != null) {
			String UpdateQuery = null;
			PreparedStatement ps = null;
			Connection con = getConnection();

			// update without image
			if (ImgPath == null) {
				try {
					UpdateQuery = "UPDATE workers SET name = ?, identification = ?"
							+ ", entry_date = ?, exit_date=? WHERE id = ?";
					ps = con.prepareStatement(UpdateQuery);

					ps.setString(1, txt_name.getText());
					ps.setString(2, txt_identification.getText());

					SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
					String addDate = dateFormat.format(txt_AddDate.getDate());

					ps.setString(3, addDate);

					ps.setInt(4, Integer.parseInt(txt_id.getText()));

					ps.executeUpdate();
					Show_Products_In_JTable();
					JOptionPane.showMessageDialog(null, "Product Updated");

				} catch (SQLException ex) {
					Logger.getLogger(WorkersSwing.class.getName()).log(Level.SEVERE, null, ex);
				}

			}
			// update With Image
			else {
				try {
					InputStream img = new FileInputStream(new File(ImgPath));

					UpdateQuery = "UPDATE products SET name = ?, price = ?" + ", add_date = ?, image = ? WHERE id = ?";

					ps = con.prepareStatement(UpdateQuery);

					ps.setString(1, txt_name.getText());
					ps.setString(2, txt_identification.getText());

					SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
					String addDate = dateFormat.format(txt_AddDate.getDate());

					ps.setString(3, addDate);

					ps.setBlob(4, img);

					ps.setInt(5, Integer.parseInt(txt_id.getText()));

					ps.executeUpdate();
					Show_Products_In_JTable();
					JOptionPane.showMessageDialog(null, "Product Updated");

				} catch (Exception ex) {
					JOptionPane.showMessageDialog(null, ex.getMessage());
				}
			}
		} else {
			JOptionPane.showMessageDialog(null, "One Or More Fields Are Empty Or Wrong");
		}

	}

	// Button Delete The Data From MySQL Database
	private void jButton3ActionPerformed(java.awt.event.ActionEvent evt) {

		if (!txt_id.getText().equals("")) {
			try {
				Connection con = getConnection();
				PreparedStatement ps = con.prepareStatement("DELETE FROM products WHERE id = ?");
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

	// JTable Mouse Clicked
	// Display The Selected Row Data Into JTextFields
	// And The Image Into JLabel
	private void JTable_ProductsMouseClicked(java.awt.event.MouseEvent evt) {

		int index = JTable_Products.getSelectedRow();
		ShowItem(index);

	}

	// Button First Show The First Record
	private void Btn_FirstActionPerformed(java.awt.event.ActionEvent evt) {
		pos = 0;
		ShowItem(pos);
	}

	// Button Last Show The Last Record
	private void Btn_LastActionPerformed(java.awt.event.ActionEvent evt) {
		pos = getProductList().size() - 1;
		ShowItem(pos);
	}

	// Button Next Show The Next Record
	private void Btn_NextActionPerformed(java.awt.event.ActionEvent evt) {

		pos++;

		if (pos >= getProductList().size()) {
			pos = getProductList().size() - 1;
		}

		ShowItem(pos);

	}

	// Button Previous Show The Previous Record
	private void Btn_PreviousActionPerformed(java.awt.event.ActionEvent evt) {

		pos--;

		if (pos < 0) {
			pos = 0;
		}

		ShowItem(pos);

	}

	public void Start() {
		/* Set the Nimbus look and feel */
		// <editor-fold defaultstate="collapsed" desc=" Look and feel setting
		// code (optional) ">
		/*
		 * If Nimbus (introduced in Java SE 6) is not available, stay with the
		 * default look and feel. For details see
		 * http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.
		 * html
		 */
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
		// </editor-fold>

		/* Create and display the form */
		java.awt.EventQueue.invokeLater(new Runnable() {
			public void run() {
				new WorkersSwing().setVisible(true);
			}
		});

	}
}