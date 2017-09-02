package hu.swing.company;

import java.awt.Color;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.border.Border;
import javax.swing.border.TitledBorder;

import hu.settings.CenterWindow;
import java.awt.Font;
import javax.swing.SwingConstants;
import javax.swing.JTextField;

@SuppressWarnings("serial")
public class CompanySwing extends javax.swing.JFrame {
	private JLabel jLblPartnerName, jLblCompanyName, jLblCountry, jLblZipCodeCity, jLblStreetHouseNumber, jLblEmail,
			jLblLandlinePhone, jLblMobilePhone, jLblAccountNumber, jLblBanksName, jLblAdministratorName, jLblComment;
	private JTextField txtPartnerName, txtCompanyName, txtCountry, txtZipCode, txtCity, txtHouseNumber, txtStreet,
			txtEmail, txtLandlinePhone, txtMobilPhone, txtAccountNumber, txtBanksName, txtAdministratorName, txtComment;
	private JButton jBtnNewPartner, jBtnDeletePartner, jBtnBack, jBtnSzerkeszts;
	private JLabel jLblLabelA, jLblLabelB;

	public CompanySwing() {
		super("Megrendelő");
		initComponents();
	}

	@SuppressWarnings({ "static-access" })
	private void initComponents() {
		this.setSize(1300, 750);
		new CenterWindow().centerWindow(this);
		this.getContentPane().setLayout(null);
		this.setVisible(true);

		jBtnNewPartner = new JButton("Új partner");
		jBtnNewPartner.setBounds(1175, 11, 99, 34);
		getContentPane().add(jBtnNewPartner);

		jBtnDeletePartner = new JButton("Törlés");
		jBtnDeletePartner.setBounds(1175, 56, 99, 34);
		getContentPane().add(jBtnDeletePartner);

		jBtnBack = new JButton("Vissza");
		jBtnBack.setBounds(1175, 666, 99, 34);
		getContentPane().add(jBtnBack);

		jLblLabelA = new JLabel();
		Border a = BorderFactory.createLineBorder(Color.DARK_GRAY);
		a = BorderFactory.createTitledBorder(a, "Partner adatok", TitledBorder.CENTER, TitledBorder.TOP);
		jLblLabelA.setBorder(a);
		jLblLabelA.setBounds(495, 39, 670, 625);
		getContentPane().add(jLblLabelA);

		jLblLabelB = new JLabel();
		Border b = BorderFactory.createLineBorder(Color.DARK_GRAY);
		b = BorderFactory.createTitledBorder(b, "", TitledBorder.CENTER, TitledBorder.TOP);
		jLblLabelB.setBorder(b);
		jLblLabelB.setBounds(507, 56, 527, 595);
		getContentPane().add(jLblLabelB);

		jBtnSzerkeszts = new JButton("Szerkesztés");
		jBtnSzerkeszts.setBounds(1044, 56, 112, 34);
		getContentPane().add(jBtnSzerkeszts);

		jLblPartnerName = new JLabel("Partner név:");
		jLblPartnerName.setHorizontalAlignment(SwingConstants.LEFT);
		jLblPartnerName.setFont(new Font("Tahoma", Font.BOLD, 14));
		jLblPartnerName.setBounds(517, 66, 130, 24);
		getContentPane().add(jLblPartnerName);

		jLblCompanyName = new JLabel("Megrendelő név:");
		jLblCompanyName.setHorizontalAlignment(SwingConstants.LEFT);
		jLblCompanyName.setFont(new Font("Tahoma", Font.BOLD, 14));
		jLblCompanyName.setBounds(517, 101, 130, 24);
		getContentPane().add(jLblCompanyName);

		jLblCountry = new JLabel("Ország:");
		jLblCountry.setHorizontalAlignment(SwingConstants.LEFT);
		jLblCountry.setFont(new Font("Tahoma", Font.BOLD, 14));
		jLblCountry.setBounds(517, 136, 130, 24);
		getContentPane().add(jLblCountry);

		txtPartnerName = new JTextField();
		txtPartnerName.setBounds(657, 70, 362, 20);
		getContentPane().add(txtPartnerName);
		txtPartnerName.setColumns(10);

		txtCompanyName = new JTextField();
		txtCompanyName.setColumns(10);
		txtCompanyName.setBounds(657, 105, 362, 20);
		getContentPane().add(txtCompanyName);

		txtCountry = new JTextField();
		txtCountry.setColumns(10);
		txtCountry.setBounds(657, 140, 362, 20);
		getContentPane().add(txtCountry);

		jLblZipCodeCity = new JLabel("Irányítósz. Város:");
		jLblZipCodeCity.setHorizontalAlignment(SwingConstants.LEFT);
		jLblZipCodeCity.setFont(new Font("Tahoma", Font.BOLD, 14));
		jLblZipCodeCity.setBounds(517, 171, 130, 24);
		getContentPane().add(jLblZipCodeCity);

		txtZipCode = new JTextField();
		txtZipCode.setColumns(10);
		txtZipCode.setBounds(657, 171, 80, 20);
		getContentPane().add(txtZipCode);

		txtCity = new JTextField();
		txtCity.setColumns(10);
		txtCity.setBounds(753, 171, 266, 20);
		getContentPane().add(txtCity);

		jLblStreetHouseNumber = new JLabel("Utca Házszám:");
		jLblStreetHouseNumber.setHorizontalAlignment(SwingConstants.LEFT);
		jLblStreetHouseNumber.setFont(new Font("Tahoma", Font.BOLD, 14));
		jLblStreetHouseNumber.setBounds(517, 206, 130, 24);
		getContentPane().add(jLblStreetHouseNumber);

		txtHouseNumber = new JTextField();
		txtHouseNumber.setColumns(10);
		txtHouseNumber.setBounds(939, 210, 80, 20);
		getContentPane().add(txtHouseNumber);

		txtStreet = new JTextField();
		txtStreet.setColumns(10);
		txtStreet.setBounds(657, 210, 266, 20);
		getContentPane().add(txtStreet);

		jLblEmail = new JLabel("Email:");
		jLblEmail.setHorizontalAlignment(SwingConstants.LEFT);
		jLblEmail.setFont(new Font("Tahoma", Font.BOLD, 14));
		jLblEmail.setBounds(517, 241, 130, 24);
		getContentPane().add(jLblEmail);

		txtEmail = new JTextField();
		txtEmail.setColumns(10);
		txtEmail.setBounds(657, 245, 362, 20);
		getContentPane().add(txtEmail);

		jLblLandlinePhone = new JLabel("Vezetékes Telefon:");
		jLblLandlinePhone.setHorizontalAlignment(SwingConstants.LEFT);
		jLblLandlinePhone.setFont(new Font("Tahoma", Font.BOLD, 14));
		jLblLandlinePhone.setBounds(517, 276, 130, 24);
		getContentPane().add(jLblLandlinePhone);

		jLblMobilePhone = new JLabel("Mobil:");
		jLblMobilePhone.setHorizontalAlignment(SwingConstants.LEFT);
		jLblMobilePhone.setFont(new Font("Tahoma", Font.BOLD, 14));
		jLblMobilePhone.setBounds(517, 311, 130, 24);
		getContentPane().add(jLblMobilePhone);

		txtLandlinePhone = new JTextField();
		txtLandlinePhone.setColumns(10);
		txtLandlinePhone.setBounds(657, 280, 362, 20);
		getContentPane().add(txtLandlinePhone);

		txtMobilPhone = new JTextField();
		txtMobilPhone.setColumns(10);
		txtMobilPhone.setBounds(657, 315, 362, 20);
		getContentPane().add(txtMobilPhone);

		jLblAccountNumber = new JLabel("Számlaszám:");
		jLblAccountNumber.setHorizontalAlignment(SwingConstants.LEFT);
		jLblAccountNumber.setFont(new Font("Tahoma", Font.BOLD, 14));
		jLblAccountNumber.setBounds(517, 346, 130, 24);
		getContentPane().add(jLblAccountNumber);

		jLblBanksName = new JLabel("Bank:");
		jLblBanksName.setHorizontalAlignment(SwingConstants.LEFT);
		jLblBanksName.setFont(new Font("Tahoma", Font.BOLD, 14));
		jLblBanksName.setBounds(517, 381, 130, 24);
		getContentPane().add(jLblBanksName);

		jLblAdministratorName = new JLabel("Ügyintéző:");
		jLblAdministratorName.setHorizontalAlignment(SwingConstants.LEFT);
		jLblAdministratorName.setFont(new Font("Tahoma", Font.BOLD, 14));
		jLblAdministratorName.setBounds(517, 416, 130, 24);
		getContentPane().add(jLblAdministratorName);

		txtAccountNumber = new JTextField();
		txtAccountNumber.setColumns(10);
		txtAccountNumber.setBounds(657, 346, 362, 20);
		getContentPane().add(txtAccountNumber);

		txtBanksName = new JTextField();
		txtBanksName.setColumns(10);
		txtBanksName.setBounds(657, 381, 362, 20);
		getContentPane().add(txtBanksName);

		txtAdministratorName = new JTextField();
		txtAdministratorName.setColumns(10);
		txtAdministratorName.setBounds(657, 416, 362, 20);
		getContentPane().add(txtAdministratorName);

		jLblComment = new JLabel("Megjegyzés:");
		jLblComment.setHorizontalAlignment(SwingConstants.LEFT);
		jLblComment.setFont(new Font("Tahoma", Font.BOLD, 14));
		jLblComment.setBounds(517, 548, 130, 24);
		getContentPane().add(jLblComment);

		txtComment = new JTextField();
		txtComment.setColumns(10);
		txtComment.setBounds(657, 552, 362, 85);
		getContentPane().add(txtComment);
	}
}
