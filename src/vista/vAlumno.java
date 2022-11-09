package vista;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.JComboBox;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import javax.swing.JButton;
import javax.swing.DefaultComboBoxModel;

public class vAlumno extends JFrame {

	private JPanel contentPane;
	private JTextField txtNombre;
	private JComboBox cboMunicipio;
	private JComboBox cboCarrera;
	private JComboBox cboGrupo;
	private JLabel lblID;
	private JScrollPane scrollPaneAlumno;
	private JTable tblAlumnos;
	private JButton btnAgregar;
	private JButton btnEditar;
	private JButton btnEliminar;
	DefaultTableModel modeloA = new DefaultTableModel();

	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					vAlumno frame = new vAlumno();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}



	public vAlumno() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 749, 336);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		lblID = new JLabel("1");
		lblID.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblID.setBounds(121, 32, 46, 14);
		contentPane.add(lblID);
		
		JLabel lblNewLabel = new JLabel("ID");
		lblNewLabel.setBounds(33, 34, 46, 14);
		contentPane.add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("NOMBRE");
		lblNewLabel_1.setBounds(33, 66, 60, 14);
		contentPane.add(lblNewLabel_1);
		
		JLabel lblNewLabel_2 = new JLabel("GRUPO");
		lblNewLabel_2.setBounds(33, 100, 46, 14);
		contentPane.add(lblNewLabel_2);
		
		JLabel lblNewLabel_3 = new JLabel("CARRERA");
		lblNewLabel_3.setBounds(33, 139, 83, 14);
		contentPane.add(lblNewLabel_3);
		
		JLabel lblNewLabel_4 = new JLabel("MUNICIPIO");
		lblNewLabel_4.setBounds(33, 176, 83, 14);
		contentPane.add(lblNewLabel_4);
		
		txtNombre = new JTextField();
		txtNombre.setBounds(121, 63, 131, 20);
		contentPane.add(txtNombre);
		txtNombre.setColumns(10);
		
		cboGrupo = new JComboBox();
		cboGrupo.setModel(new DefaultComboBoxModel(new String[] {"101", "102", "103", "104", "105", "106", "301", "302", "303", "304", "305", "306", "501", "502", "503", "504", "505", "506"}));
		cboGrupo.setBounds(121, 96, 131, 22);
		contentPane.add(cboGrupo);
		
		cboCarrera = new JComboBox();
		cboCarrera.setModel(new DefaultComboBoxModel(new String[] {"Programación", "Ventas", "Maquinas y herramientas"}));
		cboCarrera.setBounds(121, 135, 131, 22);
		contentPane.add(cboCarrera);
		
		cboMunicipio = new JComboBox();
		cboMunicipio.setModel(new DefaultComboBoxModel(new String[] {"Tecamac", "Ecatepec", "Tizayuca"}));
		cboMunicipio.setBounds(121, 172, 131, 22);
		contentPane.add(cboMunicipio);
		
		scrollPaneAlumno = new JScrollPane();
		scrollPaneAlumno.setBounds(281, 11, 430, 204);
		contentPane.add(scrollPaneAlumno);
		
		tblAlumnos = new JTable();
		tblAlumnos.setModel(new DefaultTableModel(
			new Object[][] {
				{null, null, null, null, null},
				{null, null, null, null, null},
				{null, null, null, null, null},
			},
			new String[] {
				"New column", "New column", "New column", "New column", "New column"
			}
		));
		scrollPaneAlumno.setViewportView(tblAlumnos);
		modeloA.addColumn("ID");
		modeloA.addColumn("NOMBRE");
		modeloA.addColumn("GRUPO");
		modeloA.addColumn("CARRERA");
		modeloA.addColumn("MUNICIPIO");
		tblAlumnos.setModel(modeloA);
		
		btnAgregar = new JButton("AGREGAR");
		btnAgregar.setBounds(96, 251, 89, 23);
		contentPane.add(btnAgregar);
		
		btnEditar = new JButton("EDITAR");
		btnEditar.setBounds(315, 251, 89, 23);
		contentPane.add(btnEditar);
		
		btnEliminar = new JButton("ELIMINAR");
		btnEliminar.setBounds(534, 251, 89, 23);
		contentPane.add(btnEliminar);
	}

}
