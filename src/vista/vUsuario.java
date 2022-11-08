package vista;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.management.modelmbean.InvalidTargetObjectTypeException;
import javax.swing.JButton;
import java.awt.Font;
import javax.swing.border.BevelBorder;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

import dao.daoUsuario;
import modelo.Usuario;

import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.awt.event.ActionEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.Toolkit;
import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;

public class vUsuario extends JFrame {

	private JPanel contentPane;
	int fila = -1;
	private JTextField txtUser;
	private JTable tblUsuarios;
	private JLabel lblID;
	private JButton btnAgregar;
	private JButton btnEliminar;
	private JButton btnEditar;
	private JButton btnBorrar;
	private JScrollPane scrollPane;
	daoUsuario dao = new daoUsuario();
	DefaultTableModel modelo = new DefaultTableModel();
	ArrayList<Usuario> lista = new ArrayList<Usuario>();
	Usuario usuario;
	private JComboBox comboBox;
	private JComboBox cboGrupo;
	private JComboBox cboMunicipio;

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

	public void limpiar() {
		txtUser.setText("");
		txtCarrera.setText("");
		txtNombre.setText("");
	}
	
	public vUsuario() {
		setIconImage(Toolkit.getDefaultToolkit().getImage(vUsuario.class.getResource("/img/Java.jpg")));
		setTitle("CRUD USUARIO");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 617, 448);
		setLocationRelativeTo(null);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		JLabel lblNewLabel = new JLabel("ID");
		lblNewLabel.setFont(new Font("Nirmala UI", Font.BOLD, 19));
		lblNewLabel.setBounds(38, 11, 46, 23);
		contentPane.add(lblNewLabel);

		lblID = new JLabel("1");
		lblID.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblID.setBounds(164, 17, 46, 14);
		contentPane.add(lblID);

		JLabel lblNewLabel_1 = new JLabel("MUNICIPIO");
		lblNewLabel_1.setFont(new Font("Nirmala UI", Font.BOLD, 19));
		lblNewLabel_1.setBounds(295, 130, 114, 21);
		contentPane.add(lblNewLabel_1);

		txtUser = new JTextField();
		txtUser.setBounds(439, 14, 121, 25);
		contentPane.add(txtUser);
		txtUser.setColumns(10);

		JLabel lblNewLabel_1_1 = new JLabel("CARRERA");
		lblNewLabel_1_1.setFont(new Font("Nirmala UI", Font.BOLD, 19));
		lblNewLabel_1_1.setBounds(37, 60, 129, 19);
		contentPane.add(lblNewLabel_1_1);

		JLabel lblNewLabel_1_2 = new JLabel("NOMBRE");
		lblNewLabel_1_2.setFont(new Font("Nirmala UI", Font.BOLD, 19));
		lblNewLabel_1_2.setBounds(298, 16, 86, 23);
		contentPane.add(lblNewLabel_1_2);

		btnAgregar = new JButton("Agregar");
		btnAgregar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					if (txtUser.getText().equals("") || txtCarrera.getText().equals("")
							|| txtNombre.getText().equals("")) {
						JOptionPane.showMessageDialog(null, "CAMPOS VACIOS ");
						return;
					}
					Usuario user = new Usuario();
					user.setUser(txtUser.getText());
					user.setPassword(txtCarrera.getText());
					user.setNombre(txtNombre.getText());
					if (dao.insertarUsuario(user)) {
						actualizarTabla();
						limpiar();
						JOptionPane.showMessageDialog(null, "SE AGREGO CORRECTAMENTE");
					} else {
						JOptionPane.showMessageDialog(null, "ERROR");
					}
				} catch (Exception ex) {
					JOptionPane.showMessageDialog(null, "ERROR");
				}
			}

		});
		btnAgregar.setBorder(new BevelBorder(BevelBorder.RAISED, null, null, null, null));
		btnAgregar.setFont(new Font("Imprint MT Shadow", Font.ITALIC, 17));
		btnAgregar.setBounds(22, 187, 106, 31);
		contentPane.add(btnAgregar);

		btnEditar = new JButton("Editar");
		btnEditar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					if (txtUser.getText().equals("") || txtCarrera.getText().equals("")
							|| txtNombre.getText().equals("")) {
						JOptionPane.showMessageDialog(null, "CAMPOS VACIOS ");
						return;
					}					
					usuario.setUser(txtUser.getText());
					usuario.setPassword(txtCarrera.getText());
					usuario.setNombre(txtNombre.getText());
					if (dao.editarUsuario(usuario)) {
						actualizarTabla();
						limpiar();
						JOptionPane.showMessageDialog(null, "SE ACTUALIZO  CORRECTAMENTE");
					} else {
						JOptionPane.showMessageDialog(null, "ERROR");
					}
				} catch (Exception e2) {
					JOptionPane.showMessageDialog(null, "ERROR");
				}
			}
		});
		btnEditar.setBorder(new BevelBorder(BevelBorder.RAISED, null, null, null, null));
		btnEditar.setFont(new Font("Imprint MT Shadow", Font.ITALIC, 17));
		btnEditar.setBounds(308, 187, 89, 31);
		contentPane.add(btnEditar);

		btnEliminar = new JButton("Eliminar");
		btnEliminar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					int opcion = JOptionPane.showConfirmDialog(null, "¿ESTA SEGURO DE ELIMINAR ESTE USUARIO?","ELIMINAR USUARIO",JOptionPane.YES_NO_OPTION);
					if (opcion == 0) {
						if (dao.EliminarUsuario(lista.get(fila).getId())) {
							actualizarTabla();
							JOptionPane.showMessageDialog(null, "SE ELIMINO CORRECTAMENTE");
						} else {
							JOptionPane.showMessageDialog(null, "ERROR");
						}
					}
				} catch (Exception ex) {
					JOptionPane.showMessageDialog(null, "ERROR");
				}
			}
		});
		btnEliminar.setBorder(new BevelBorder(BevelBorder.RAISED, null, null, null, null));
		btnEliminar.setFont(new Font("Imprint MT Shadow", Font.ITALIC, 17));
		btnEliminar.setBounds(159, 187, 103, 31);
		contentPane.add(btnEliminar);

		btnBorrar = new JButton("Borrar");
		btnBorrar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				limpiar();
			}
		});
		btnBorrar.setBorder(new BevelBorder(BevelBorder.RAISED, null, null, null, null));
		btnBorrar.setFont(new Font("Imprint MT Shadow", Font.ITALIC, 17));
		btnBorrar.setBounds(429, 187, 89, 31);
		contentPane.add(btnBorrar);

		scrollPane = new JScrollPane();
		scrollPane.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
			}
		});
		scrollPane.setBounds(22, 240, 556, 158);
		contentPane.add(scrollPane);

		tblUsuarios = new JTable();
		tblUsuarios.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				fila = tblUsuarios.getSelectedRow();	
				usuario=lista.get(fila);
				lblID.setText("" + lista.get(fila).getId());
				txtUser.setText(usuario.getUser());
				txtCarrera.setText(usuario.getPassword());
				txtNombre.setText(usuario.getNombre());
			}
		});
		tblUsuarios.setModel(new DefaultTableModel(
				new Object[][] { { null, null, null, null }, { null, null, null, null }, { null, null, null, null }, },
				new String[] { "New column", "New column", "New column", "New column" }));
		scrollPane.setViewportView(tblUsuarios);

		modelo.addColumn("ID");
		modelo.addColumn("USER");
		modelo.addColumn("PASSWORD");
		modelo.addColumn("NOMBRE");
		tblUsuarios.setModel(modelo);
		
		JLabel lblNewLabel_1_1_1 = new JLabel("GRUPO");
		lblNewLabel_1_1_1.setFont(new Font("Nirmala UI", Font.BOLD, 19));
		lblNewLabel_1_1_1.setBounds(303, 80, 94, 19);
		contentPane.add(lblNewLabel_1_1_1);
		
		cboGrupo = new JComboBox();
		cboGrupo.setBounds(439, 68, 121, 41);
		contentPane.add(cboGrupo);
		
		cboMunicipio = new JComboBox();
		cboMunicipio.setModel(new DefaultComboBoxModel(new String[] {"Ecatepec", "Tecamac", "Zumpango"}));
		cboMunicipio.setBounds(439, 129, 121, 41);
		contentPane.add(cboMunicipio);
		
		comboBox = new JComboBox();
		comboBox.setBounds(22, 90, 144, 41);
		contentPane.add(comboBox);
		actualizarTabla();
	}

	public void actualizarTabla() {
		while (modelo.getRowCount() > 0) {
			modelo.removeRow(0);
		}
		lista = dao.fetchUsuarios();
		for (Usuario u : lista) {
			Object o[] = new Object[4];
			o[0] = u.getId();
			o[1] = u.getUser();
			o[2] = u.getPassword();
			o[3] = u.getNombre();
			modelo.addRow(o);
		}
		tblUsuarios.setModel(modelo);
	}
}
