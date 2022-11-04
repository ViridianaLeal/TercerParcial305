package vista;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.Font;
import javax.swing.border.BevelBorder;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

import dao.daoUsuario;
import modelo.Usuario;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class vUsuario extends JFrame {

	private JPanel contentPane;
	private JTextField txtUser;
	private JTextField txtPassword;
	private JTextField txtNombre;
	private JTable tblUsuarios;
	private JLabel lblID;
	private JButton btnAgregar;
	private JButton btnEliminar;
	private JButton btnEditar;
	private JButton btnBorrar;
	private JScrollPane scrollPane;
	daoUsuario dao=new daoUsuario();

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					vUsuario frame = new vUsuario();
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
	public vUsuario() {
		setTitle("CRUD USUARIO");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 566, 448);
		setLocationRelativeTo(null);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("ID");
		lblNewLabel.setFont(new Font("Nirmala UI", Font.BOLD, 19));
		lblNewLabel.setBounds(25, 32, 46, 23);
		contentPane.add(lblNewLabel);
		
		lblID = new JLabel("1");
		lblID.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblID.setBounds(164, 40, 46, 14);
		contentPane.add(lblID);
		
		JLabel lblNewLabel_1 = new JLabel("USUARIO");
		lblNewLabel_1.setFont(new Font("Nirmala UI", Font.BOLD, 19));
		lblNewLabel_1.setBounds(25, 66, 86, 21);
		contentPane.add(lblNewLabel_1);
		
		txtUser = new JTextField();
		txtUser.setBounds(164, 67, 169, 20);
		contentPane.add(txtUser);
		txtUser.setColumns(10);
		
		JLabel lblNewLabel_1_1 = new JLabel("PASSWORD");
		lblNewLabel_1_1.setFont(new Font("Nirmala UI", Font.BOLD, 19));
		lblNewLabel_1_1.setBounds(25, 100, 129, 23);
		contentPane.add(lblNewLabel_1_1);
		
		txtPassword = new JTextField();
		txtPassword.setColumns(10);
		txtPassword.setBounds(164, 97, 169, 20);
		contentPane.add(txtPassword);
		
		JLabel lblNewLabel_1_2 = new JLabel("NOMBRE");
		lblNewLabel_1_2.setFont(new Font("Nirmala UI", Font.BOLD, 19));
		lblNewLabel_1_2.setBounds(25, 131, 86, 23);
		contentPane.add(lblNewLabel_1_2);
		
		txtNombre = new JTextField();
		txtNombre.setColumns(10);
		txtNombre.setBounds(164, 136, 169, 20);
		contentPane.add(txtNombre);
		
		btnAgregar = new JButton("Agregar");
		btnAgregar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					Usuario user=new Usuario();
					user.setUser(txtUser.getText());
					user.setPassword(txtPassword.getText());
					user.setNombre(txtNombre.getText());
					if(dao.insertarUsuario(user)) {
						JOptionPane.showMessageDialog(null, "SE AGREGO CORRECTAMENTE");
					}else {
						JOptionPane.showMessageDialog(null, "ERROR");
					}
				}catch(Exception ex) {
					JOptionPane.showMessageDialog(null, "ERROR");
				}
			}
		});
		btnAgregar.setBorder(new BevelBorder(BevelBorder.RAISED, null, null, null, null));
		btnAgregar.setFont(new Font("Imprint MT Shadow", Font.ITALIC, 17));
		btnAgregar.setBounds(22, 187, 106, 23);
		contentPane.add(btnAgregar);
		
		btnEditar = new JButton("Editar");
		btnEditar.setBorder(new BevelBorder(BevelBorder.RAISED, null, null, null, null));
		btnEditar.setFont(new Font("Imprint MT Shadow", Font.ITALIC, 17));
		btnEditar.setBounds(283, 187, 89, 23);
		contentPane.add(btnEditar);
		
		btnEliminar = new JButton("Eliminar");
		btnEliminar.setBorder(new BevelBorder(BevelBorder.RAISED, null, null, null, null));
		btnEliminar.setFont(new Font("Imprint MT Shadow", Font.ITALIC, 17));
		btnEliminar.setBounds(159, 187, 103, 23);
		contentPane.add(btnEliminar);
		
		btnBorrar = new JButton("Borrar");
		btnBorrar.setBorder(new BevelBorder(BevelBorder.RAISED, null, null, null, null));
		btnBorrar.setFont(new Font("Imprint MT Shadow", Font.ITALIC, 17));
		btnBorrar.setBounds(404, 187, 89, 23);
		contentPane.add(btnBorrar);
		
		scrollPane = new JScrollPane();
		scrollPane.setBounds(22, 240, 503, 158);
		contentPane.add(scrollPane);
		
		tblUsuarios = new JTable();
		tblUsuarios.setModel(new DefaultTableModel(
			new Object[][] {
				{null, null, null, null},
				{null, null, null, null},
				{null, null, null, null},
			},
			new String[] {
				"New column", "New column", "New column", "New column"
			}
		));
		scrollPane.setViewportView(tblUsuarios);
	}
}
