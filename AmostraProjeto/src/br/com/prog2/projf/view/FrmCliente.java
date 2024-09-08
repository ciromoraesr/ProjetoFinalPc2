package br.com.prog2.projf.view;

import java.awt.Color;
import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.List;

import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JButton;
import javax.swing.JFormattedTextField;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.ListSelectionModel;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;
import javax.swing.text.MaskFormatter;

import br.com.prog2.projf.controller.ClienteController;
import br.com.prog2.projf.model.Cliente;

public class FrmCliente extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane1;
	private JTable tblConsulta;
	private JTextField txtCod;
	private JTextField txtNome;
	private JTextField txtRg;
	private JTextField txtEnd;
	private JTextField txtBair;
	private JTextField txtCid;
	private JTextField txtEst;
	private JTextField txtCep;
	private JLabel lblMensagem;
	private JFormattedTextField txtBirth;
	private MaskFormatter mascaraData = null;
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					FrmCliente frame = new FrmCliente();
					frame.setLocationRelativeTo(null);
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}
	private void pesquisar() {
		List<Cliente> listaClientes = new ArrayList<>();
		ClienteController cc = new ClienteController();
		listaClientes = cc.listarTodos(); 
		DefaultTableModel tbm = (DefaultTableModel)tblConsulta.getModel();

		
		for (int i = tbm.getRowCount() - 1; i >= 0; i--) {
		    tbm.removeRow(i);
		}

		int i = 0;
		for (Cliente cliente : listaClientes) {
		    tbm.addRow(new String[1]); 
		    
		    tblConsulta.setValueAt(cliente.getCodCliente(), i, 0);
		    tblConsulta.setValueAt(cliente.getNomeCliente(), i, 1);
		    tblConsulta.setValueAt(cliente.getRgCliente(), i, 2);
		    tblConsulta.setValueAt(cliente.getEnderecoCliente(), i, 3);
		    tblConsulta.setValueAt(cliente.getBairroCliente(), i, 4);
		    tblConsulta.setValueAt(cliente.getCidadeCliente(), i, 5);
		    tblConsulta.setValueAt(cliente.getEstadoCliente(), i, 6);
		    tblConsulta.setValueAt(cliente.getCEPCliente(), i, 7);
		    tblConsulta.setValueAt(cliente.getNascimentoCliente(), i, 8);
		    
		    i++;
		}
	}

	/**
	 * Create the frame.
	 */
	
	public FrmCliente() {
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 730, 463);
		
		
		
		contentPane1 = new JPanel();
		contentPane1.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane1);
		
		JPanel panel = new JPanel();
		
		JPanel panel_1 = new JPanel();
		
		JPanel panel_2 = new JPanel();
		GroupLayout gl_contentPane1 = new GroupLayout(contentPane1);
		gl_contentPane1.setHorizontalGroup(
			gl_contentPane1.createParallelGroup(Alignment.LEADING)
				.addGroup(Alignment.TRAILING, gl_contentPane1.createSequentialGroup()
					.addContainerGap()
					.addGroup(gl_contentPane1.createParallelGroup(Alignment.TRAILING)
						.addComponent(panel, Alignment.LEADING, GroupLayout.DEFAULT_SIZE, 654, Short.MAX_VALUE)
						.addComponent(panel_1, Alignment.LEADING, GroupLayout.DEFAULT_SIZE, 654, Short.MAX_VALUE)
						.addComponent(panel_2, GroupLayout.DEFAULT_SIZE, 654, Short.MAX_VALUE))
					.addContainerGap())
		);
		gl_contentPane1.setVerticalGroup(
			gl_contentPane1.createParallelGroup(Alignment.TRAILING)
				.addGroup(gl_contentPane1.createSequentialGroup()
					.addComponent(panel, GroupLayout.DEFAULT_SIZE, 98, Short.MAX_VALUE)
					.addPreferredGap(ComponentPlacement.UNRELATED)
					.addComponent(panel_1, GroupLayout.PREFERRED_SIZE, 46, GroupLayout.PREFERRED_SIZE)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(panel_2, GroupLayout.PREFERRED_SIZE, 207, GroupLayout.PREFERRED_SIZE)
					.addContainerGap())
		);
		
		JScrollPane scrollPane = new JScrollPane();
		GroupLayout gl_panel_2 = new GroupLayout(panel_2);
		gl_panel_2.setHorizontalGroup(
			gl_panel_2.createParallelGroup(Alignment.LEADING)
				.addGroup(Alignment.TRAILING, gl_panel_2.createSequentialGroup()
					.addContainerGap()
					.addComponent(scrollPane, GroupLayout.DEFAULT_SIZE, 674, Short.MAX_VALUE)
					.addContainerGap())
		);
		gl_panel_2.setVerticalGroup(
			gl_panel_2.createParallelGroup(Alignment.TRAILING)
				.addGroup(gl_panel_2.createSequentialGroup()
					.addContainerGap()
					.addComponent(scrollPane, GroupLayout.DEFAULT_SIZE, 187, Short.MAX_VALUE)
					.addContainerGap())
		);
		
		tblConsulta = new JTable();
		tblConsulta.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		tblConsulta.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
		        
				
		        int row = tblConsulta.rowAtPoint(e.getPoint());
		        System.out.println(row);
		        
		        if (row >= 0) {
		            DefaultTableModel model = (DefaultTableModel) tblConsulta.getModel();

		            
		            if (model.getColumnCount() >= 9) {
		                try {
		                    
		                    String codCliente = model.getValueAt(row, 0) != null ? model.getValueAt(row, 0).toString() : "";
		                    String nomeCliente = model.getValueAt(row, 1) != null ? model.getValueAt(row, 1).toString() : "";
		                    String rgCliente = model.getValueAt(row, 2) != null ? model.getValueAt(row, 2).toString() : "";
		                    String enderecoCliente = model.getValueAt(row, 3) != null ? model.getValueAt(row, 3).toString() : "";
		                    String bairroCliente = model.getValueAt(row, 4) != null ? model.getValueAt(row, 4).toString() : "";
		                    String cidadeCliente = model.getValueAt(row, 5) != null ? model.getValueAt(row, 5).toString() : "";
		                    String estadoCliente = model.getValueAt(row, 6) != null ? model.getValueAt(row, 6).toString() : "";
		                    String cepCliente = model.getValueAt(row, 7) != null ? model.getValueAt(row, 7).toString() : "";
		                    String nascimentoCliente = model.getValueAt(row, 8) != null ? model.getValueAt(row, 8).toString() : "";

		                    
		                    txtCod.setText(codCliente);
		                    txtNome.setText(nomeCliente);
		                    txtRg.setText(rgCliente);
		                    txtEnd.setText(enderecoCliente);
		                    txtBair.setText(bairroCliente);
		                    txtCid.setText(cidadeCliente);
		                    txtEst.setText(estadoCliente);
		                    txtCep.setText(cepCliente);
		                    txtBirth.setText(nascimentoCliente);
		                } catch (IndexOutOfBoundsException ex) {
		                    
		                    JOptionPane.showMessageDialog(null, "Error: Invalido");
		                }
		            }
		        } else {
		            JOptionPane.showMessageDialog(null, "Error: No row selected.");
		        }
		    }
		});
		tblConsulta.setModel(new DefaultTableModel(
				new Object[][] {},
			    new String[] {
			        "Código", "Nome", "RG", "Endereco", "Bairro", "Cidade", "Estado", "CEP", "Nascimento"
			    }
			) {
			    // Define which columns are editable
			    boolean[] columnEditables = new boolean[] {
			        false, // For "Código"
			        false, // For "Nome"
			        false, // For "RG"
			        false, // For "Endereco"
			        false, // For "Bairro"
			        false, // For "Cidade"
			        false, // For "Estado"
			        false, // For "CEP"
			        false  // For "Nascimento"
			    };

			    @Override
			    public boolean isCellEditable(int row, int column) {
			       
			        if (column < 0 || column >= columnEditables.length) {
			            return false;
			        }
			        return columnEditables[column];
			    }
			});
		tblConsulta.getColumnModel().getColumn(0).setResizable(false);
		scrollPane.setViewportView(tblConsulta);
		panel_2.setLayout(gl_panel_2);
		
		JButton btnNewButton = new JButton("Inserir");
		btnNewButton.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				
				Cliente c = new Cliente();
				ClienteController cc = new ClienteController();
				int x = (Integer.parseInt(txtCod.getText()));
				List<Cliente> listaClientes = new ArrayList<>();
				listaClientes = cc.listarTodos();
				
				int cond = 0;
				for(int i = 0; i < listaClientes.size(); i++) {
					if(listaClientes.get(i).getCodCliente() == x) {
						cond = 1;
					}
				}
				if(cond == 1) {
					lblMensagem.setText("Esse cliente já foi inserido");
				}else {
					c.setCodCliente(x);
					c.setNomeCliente(txtNome.getText());
					c.setRgCliente(txtRg.getText());
					c.setEnderecoCliente(txtEnd.getText());
					c.setBairroCliente(txtBair.getText());
					c.setCidadeCliente(txtCid.getText());
					c.setEstadoCliente(txtEst.getText());
					c.setCEPCliente(txtCep.getText());
					c.setNascimentoCliente(java.sql.Date.valueOf(txtBirth.getText()));
					lblMensagem.setText(cc.inserir(c));
					pesquisar();
				}
			}
		});
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				
			}
		});
		
		JButton btnNewButton_1 = new JButton("Alterar");
		btnNewButton_1.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				List<Cliente> listaClientes = new ArrayList<>();
				Cliente cliente = new Cliente();
				ClienteController cc = new ClienteController();
				listaClientes = cc.listarTodos();
				int x = Integer.parseInt(txtCod.getText());
				int cond = 0;
				for(int i = 0; i < listaClientes.size(); i++) {
					if(listaClientes.get(i).getCodCliente() == x) {
						cond = 1;
					}
				}
				
					
				if(cond == 0) {
					lblMensagem.setText("Esse cliente ainda não foi inserido");
				}else {
					cliente.setCodCliente(x);
					
					cliente.setNomeCliente(txtNome.getText());
					cliente.setRgCliente(txtRg.getText());
					cliente.setEnderecoCliente(txtEnd.getText());
					cliente.setBairroCliente(txtBair.getText());
					cliente.setCidadeCliente(txtCid.getText());
					cliente.setEstadoCliente(txtEst.getText());
					cliente.setCEPCliente(txtCep.getText());
	
					
					cliente.setNascimentoCliente(java.sql.Date.valueOf(txtBirth.getText()));
	
					
					lblMensagem.setText(cc.alterar(cliente));
					pesquisar();
				}

			}
		});
		
		JButton btnNewButton_2 = new JButton("Excluir");
		btnNewButton_2.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				Cliente c = new Cliente();
				ClienteController cc = new ClienteController();
				int x = (Integer.parseInt(txtCod.getText()));
				List<Cliente> listaClientes = new ArrayList<>();
				int cond = 0;
				for(int i = 0; i < listaClientes.size(); i++) {
					if(listaClientes.get(i).getCodCliente() == x) {
						cond = 1;
					}
				}
				if(cond == 0) {
					lblMensagem.setText("Esse cliente não está na lista");
				}
				else {
					c.setCodCliente(x);
					Object [] opcoes = {"Sim", "Nao"};
					int i = JOptionPane.showOptionDialog(null,
							"Deseja excluir esse cliente: "+txtNome.getText()+"?","Exclusão",
							JOptionPane.YES_NO_OPTION,JOptionPane.QUESTION_MESSAGE, null,
							opcoes, opcoes[0]);
					if(JOptionPane.YES_OPTION == i){
						lblMensagem.setText(cc.excluir(c));
						pesquisar();
						}
				}
			}
		});
		
		JButton btnNewButton_3 = new JButton("Pesquisar");
		btnNewButton_3.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				List<Cliente> listaClientes = new ArrayList<>();
				
				ClienteController cc = new ClienteController();
				listaClientes = cc.listarTodos(); // Adjust this method to fetch all clients
				DefaultTableModel tbm = (DefaultTableModel)tblConsulta.getModel();

				// Clear the table before adding new rows
				for (int i = tbm.getRowCount() - 1; i >= 0; i--) {
				    tbm.removeRow(i);
				}

				int i = 0;
				for (Cliente cliente : listaClientes) {
				    tbm.addRow(new String[1]); // Add a new empty row for each client
				    
				    tblConsulta.setValueAt(cliente.getCodCliente(), i, 0);
				    tblConsulta.setValueAt(cliente.getNomeCliente(), i, 1);
				    tblConsulta.setValueAt(cliente.getRgCliente(), i, 2);
				    tblConsulta.setValueAt(cliente.getEnderecoCliente(), i, 3);
				    tblConsulta.setValueAt(cliente.getBairroCliente(), i, 4);
				    tblConsulta.setValueAt(cliente.getCidadeCliente(), i, 5);
				    tblConsulta.setValueAt(cliente.getEstadoCliente(), i, 6);
				    tblConsulta.setValueAt(cliente.getCEPCliente(), i, 7);
				    tblConsulta.setValueAt(cliente.getNascimentoCliente(), i, 8);
				    
				    i++;
				}

				
			}
		});
		btnNewButton_3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		
		JButton btnNewButton_4 = new JButton("Limpar");
		btnNewButton_4.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				txtCod.setText("");
				txtNome.setText("");
				txtRg.setText("");
				txtCid.setText("");
				txtEnd.setText("");
				txtBair.setText("");
				txtCep.setText("");
				txtEst.setText("");
				txtBirth.setText("");
				DefaultTableModel tbm = (DefaultTableModel)tblConsulta.getModel();
				for(int i = tbm.getRowCount()-1;i>=0;i--) {
					tbm.removeRow(i);
				}
			}
		});
		btnNewButton_4.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		
		JButton btnNewButton_5 = new JButton("Sair");
		btnNewButton_5.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				FrmCliente.this.dispose();
			}
		});
		GroupLayout gl_panel_1 = new GroupLayout(panel_1);
		gl_panel_1.setHorizontalGroup(
			gl_panel_1.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panel_1.createSequentialGroup()
					.addContainerGap()
					.addComponent(btnNewButton)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(btnNewButton_1)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(btnNewButton_2)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(btnNewButton_3)
					.addPreferredGap(ComponentPlacement.RELATED, 204, Short.MAX_VALUE)
					.addComponent(btnNewButton_4)
					.addGap(18)
					.addComponent(btnNewButton_5)
					.addGap(20))
		);
		gl_panel_1.setVerticalGroup(
			gl_panel_1.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panel_1.createSequentialGroup()
					.addContainerGap()
					.addGroup(gl_panel_1.createParallelGroup(Alignment.BASELINE)
						.addComponent(btnNewButton_2)
						.addComponent(btnNewButton_1)
						.addComponent(btnNewButton)
						.addComponent(btnNewButton_3)
						.addComponent(btnNewButton_5)
						.addComponent(btnNewButton_4))
					.addContainerGap(12, Short.MAX_VALUE))
		);
		panel_1.setLayout(gl_panel_1);
		
		txtCod = new JTextField();
		txtCod.setColumns(10);
		
		JLabel lblNewLabel = new JLabel("Código");
		
		txtNome = new JTextField();
		txtNome.setColumns(10);
		
		JLabel lblNome = new JLabel("Nome");
		
		txtRg = new JTextField();
		txtRg.setColumns(10);
		
		JLabel lblNewLabel_1 = new JLabel("RG");
		
		txtEnd = new JTextField();
		txtEnd.setColumns(10);
		
		JLabel lblNewLabel_2 = new JLabel("Endereço");
		
		txtBair = new JTextField();
		txtBair.setColumns(10);
		
		txtCid = new JTextField();
		txtCid.setColumns(10);
		
		JLabel lblBairro = new JLabel("Bairro");
		
		JLabel lblCidade = new JLabel("Cidade");
		
		txtEst = new JTextField();
		txtEst.setColumns(10);
		
		txtCep = new JTextField();
		txtCep.setColumns(10);
		
		JLabel lblNewLabel_2_1 = new JLabel("Estado");
		
		JLabel lblNewLabel_2_1_1 = new JLabel("Data \r\nde Nascimento");
		
		JLabel lblNewLabel_2_1_2 = new JLabel("CEP");
		
		lblMensagem = new JLabel("Mensagem:");
		lblMensagem.setForeground(new Color(0, 0, 255));
		lblMensagem.setBackground(new Color(0, 0, 255));
		
		
		
		try {
			mascaraData = new MaskFormatter("####-##-##");
			} catch (ParseException e) {
			System.err.println(e.getMessage());
			}
		txtBirth = new JFormattedTextField(mascaraData);
		
		JLabel lblNewLabel_3 = new JLabel("Ano-Mês-Dia");
		lblNewLabel_3.setForeground(new Color(255, 0, 0));
		
		GroupLayout gl_panel = new GroupLayout(panel);
		gl_panel.setHorizontalGroup(
			gl_panel.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panel.createSequentialGroup()
					.addGroup(gl_panel.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_panel.createSequentialGroup()
							.addContainerGap()
							.addGroup(gl_panel.createParallelGroup(Alignment.TRAILING)
								.addComponent(lblNome, GroupLayout.PREFERRED_SIZE, 33, GroupLayout.PREFERRED_SIZE)
								.addComponent(lblNewLabel_1, GroupLayout.PREFERRED_SIZE, 33, GroupLayout.PREFERRED_SIZE)
								.addComponent(lblNewLabel, GroupLayout.PREFERRED_SIZE, 34, GroupLayout.PREFERRED_SIZE))
							.addPreferredGap(ComponentPlacement.RELATED)
							.addGroup(gl_panel.createParallelGroup(Alignment.LEADING, false)
								.addComponent(txtNome, GroupLayout.DEFAULT_SIZE, 142, Short.MAX_VALUE)
								.addComponent(txtCod)
								.addComponent(txtRg, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
							.addGap(18)
							.addGroup(gl_panel.createParallelGroup(Alignment.LEADING)
								.addComponent(lblNewLabel_2)
								.addComponent(lblBairro, GroupLayout.PREFERRED_SIZE, 33, GroupLayout.PREFERRED_SIZE)
								.addGroup(gl_panel.createSequentialGroup()
									.addPreferredGap(ComponentPlacement.RELATED)
									.addComponent(lblCidade, GroupLayout.PREFERRED_SIZE, 61, GroupLayout.PREFERRED_SIZE)))
							.addGap(18)
							.addGroup(gl_panel.createParallelGroup(Alignment.LEADING, false)
								.addComponent(txtCid, Alignment.TRAILING)
								.addComponent(txtEnd, Alignment.TRAILING)
								.addComponent(txtBair, Alignment.TRAILING, GroupLayout.DEFAULT_SIZE, 142, Short.MAX_VALUE))
							.addGap(18)
							.addGroup(gl_panel.createParallelGroup(Alignment.LEADING)
								.addComponent(lblNewLabel_2_1_1)
								.addComponent(lblNewLabel_2_1_2, GroupLayout.PREFERRED_SIZE, 45, GroupLayout.PREFERRED_SIZE)
								.addComponent(lblNewLabel_2_1, GroupLayout.PREFERRED_SIZE, 45, GroupLayout.PREFERRED_SIZE)))
						.addGroup(gl_panel.createSequentialGroup()
							.addContainerGap()
							.addComponent(lblMensagem, GroupLayout.PREFERRED_SIZE, 347, GroupLayout.PREFERRED_SIZE)))
					.addPreferredGap(ComponentPlacement.RELATED)
					.addGroup(gl_panel.createParallelGroup(Alignment.LEADING, false)
						.addComponent(txtCep, GroupLayout.DEFAULT_SIZE, 142, Short.MAX_VALUE)
						.addComponent(txtEst, GroupLayout.DEFAULT_SIZE, 142, Short.MAX_VALUE)
						.addComponent(txtBirth)
						.addComponent(lblNewLabel_3, GroupLayout.DEFAULT_SIZE, 79, Short.MAX_VALUE))
					.addContainerGap(GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
		);
		gl_panel.setVerticalGroup(
			gl_panel.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panel.createSequentialGroup()
					.addContainerGap()
					.addGroup(gl_panel.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_panel.createSequentialGroup()
							.addGroup(gl_panel.createParallelGroup(Alignment.BASELINE)
								.addComponent(lblNewLabel)
								.addComponent(txtCod, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
							.addGap(18)
							.addGroup(gl_panel.createParallelGroup(Alignment.BASELINE)
								.addComponent(lblNome)
								.addComponent(txtNome, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
							.addPreferredGap(ComponentPlacement.UNRELATED)
							.addGroup(gl_panel.createParallelGroup(Alignment.BASELINE)
								.addComponent(txtRg, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
								.addComponent(lblNewLabel_1)))
						.addGroup(gl_panel.createParallelGroup(Alignment.TRAILING)
							.addGroup(gl_panel.createSequentialGroup()
								.addComponent(txtEst, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
								.addGap(18)
								.addComponent(txtCep, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
								.addGap(29))
							.addGroup(gl_panel.createParallelGroup(Alignment.LEADING)
								.addGroup(gl_panel.createSequentialGroup()
									.addGroup(gl_panel.createParallelGroup(Alignment.BASELINE)
										.addComponent(txtEnd, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
										.addComponent(lblNewLabel_2)
										.addComponent(lblNewLabel_2_1))
									.addGap(18)
									.addGroup(gl_panel.createParallelGroup(Alignment.BASELINE)
										.addComponent(txtBair, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
										.addComponent(lblNewLabel_2_1_2))
									.addPreferredGap(ComponentPlacement.UNRELATED)
									.addGroup(gl_panel.createParallelGroup(Alignment.BASELINE)
										.addComponent(txtCid, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
										.addComponent(lblCidade)
										.addComponent(lblNewLabel_2_1_1)
										.addComponent(txtBirth, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)))
								.addGroup(gl_panel.createSequentialGroup()
									.addGap(38)
									.addComponent(lblBairro)))))
					.addGroup(gl_panel.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_panel.createSequentialGroup()
							.addGap(18)
							.addComponent(lblMensagem))
						.addGroup(gl_panel.createSequentialGroup()
							.addPreferredGap(ComponentPlacement.RELATED)
							.addComponent(lblNewLabel_3)))
					.addContainerGap(11, Short.MAX_VALUE))
		);
		panel.setLayout(gl_panel);
		contentPane1.setLayout(gl_contentPane1);
	}
}