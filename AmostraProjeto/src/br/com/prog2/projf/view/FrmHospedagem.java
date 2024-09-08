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

import br.com.prog2.projf.controller.ChaleController;
import br.com.prog2.projf.controller.ClienteController;
import br.com.prog2.projf.controller.HospedagemController;
import br.com.prog2.projf.model.Chale;
import br.com.prog2.projf.model.Cliente;
import br.com.prog2.projf.model.Hospedagem;


public class FrmHospedagem extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane1;
	private JTable tblConsulta;
	private JTextField txtCod;
	private JTextField txtCodCha;
	private JTextField txtCodCli;
	private JLabel lblMensagem;
	private JLabel lblMensagemMax;
	private JTextField txtQtd;
	private JTextField txtDesc;
	private JTextField txtFinal;
	private JFormattedTextField txtDataIn;
	private JFormattedTextField txtDataOut;
	private MaskFormatter mascaraData = null;
	
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					FrmHospedagem frame = new FrmHospedagem();
					frame.setLocationRelativeTo(null);
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}
	private void pesquisar() {
		List<Hospedagem> listaHosp = new ArrayList<>();
		HospedagemController h = new HospedagemController();
		listaHosp = h.listarTodos(); 
		DefaultTableModel tbm = (DefaultTableModel)tblConsulta.getModel();

		

		
		
		
		
		
		
		
		
		for (int i = tbm.getRowCount() - 1; i >= 0; i--) {
		    tbm.removeRow(i);
		}

		int i = 0;
		for (Hospedagem hospedagem : listaHosp) {
		    tbm.addRow(new String[1]); 
		    
		    tblConsulta.setValueAt(hospedagem.getCodHospedagem(), i, 0);
		    tblConsulta.setValueAt(hospedagem.getCodChale(), i, 1);
		    tblConsulta.setValueAt(hospedagem.getCodCliente(), i, 2);
		    tblConsulta.setValueAt(hospedagem.getDataInicio(), i, 3);
		    tblConsulta.setValueAt(hospedagem.getDataFim(), i, 4);
		    tblConsulta.setValueAt(hospedagem.getQtdPessoas(), i, 5);
		    tblConsulta.setValueAt(hospedagem.getDesconto(), i, 6);
		    tblConsulta.setValueAt(hospedagem.getValorFinal(), i, 7);
		    
		    i++;
		}
	}

	/**
	 * Create the frame.
	 */
	
	public FrmHospedagem() {
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 773, 463);
		
		
		
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

		            
		            if (model.getColumnCount() >= 8) {
		                try {
		                    
		                	String codHospedagem = model.getValueAt(row, 0) != null ? model.getValueAt(row, 0).toString() : "";
		                	String codChale = model.getValueAt(row, 1) != null ? model.getValueAt(row, 1).toString() : "";
		                	String codCliente = model.getValueAt(row, 2) != null ? model.getValueAt(row, 2).toString() : "";
		                	String dataInicio = model.getValueAt(row, 3) != null ? model.getValueAt(row, 3).toString() : "";
		                	String dataFim = model.getValueAt(row, 4) != null ? model.getValueAt(row, 4).toString() : "";
		                	String qtdPessoas = model.getValueAt(row, 5) != null ? model.getValueAt(row, 5).toString() : "";
		                	String desconto = model.getValueAt(row, 6) != null ? model.getValueAt(row, 6).toString() : "";
		                	String valorFinal = model.getValueAt(row, 7) != null ? model.getValueAt(row, 7).toString() : "";

		                	txtCod.setText(codHospedagem);
		                	txtCodCha.setText(codChale);
		                	txtCodCli.setText(codCliente);
		                	txtDataIn.setText(dataInicio);
		                	txtDataOut.setText(dataFim);
		                	txtQtd.setText(qtdPessoas);
		                	txtDesc.setText(desconto);
		                	
		                	txtFinal.setText(valorFinal);


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
			        "Código", "Cod. Chalé", "Cód. Cliente", "Data Início", "Data Fim", "Qtd. de Pessoas", "Desconto", "Valor Final"
			    }
			) {
			    
			    boolean[] columnEditables = new boolean[] {
			        false, // 
			        false, // 
			        false, // 
			        false, 
			        false,
			        false,
			        false,
			        false
			      
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
				
				
				Hospedagem hospedagem = new Hospedagem();
				HospedagemController cc = new HospedagemController();
				int x = (Integer.parseInt(txtCod.getText()));
				List<Hospedagem> listaHosp = new ArrayList<>();
				listaHosp = cc.listarTodos();
				ClienteController c1 = new ClienteController();
				ChaleController c2 = new ChaleController();
				List<Chale> list2 = new ArrayList<>();
				List<Cliente> list1 = new ArrayList<>();
				list1 = c1.listarTodos();
				list2 = c2.listarTodos();
				int y = Integer.parseInt(txtCodCha.getText());
				int z = Integer.parseInt(txtCodCli.getText());
				int cond1 = 0;
				int cond2 = 0;
				
				for(int i =0; i < list1.size();i++) {
					if(list1.get(i).getCodCliente() == z) {
						cond1 = 1;
						
					}
				}
				int max = 0;
				for(int i =0; i < list2.size();i++) {
					if(list2.get(i).getCodChale() == y) {
						cond2 = 1;
						max = list2.get(i).getCapacidade();
					}
				}
				int cond = 0;
				for(int i = 0; i < listaHosp.size(); i++) {
				    if(listaHosp.get(i).getCodHospedagem() == x) {
				        cond = 1;
				    }
				}
				
				if(cond == 1) {
				    lblMensagem.setText("Esse hospedagem já foi inserido");
				}else if(cond1 == 0 & cond2 == 1) {
					lblMensagem.setText("O id_desse cliente não existe");
				}else if(cond2 == 1 & cond1 == 0) {
					lblMensagem.setText("O id desse chalé não existe");
				}else if(cond1 == 0 & cond2 == 0) {
					lblMensagem.setText("o id do chalé e do cliente não existem");
				}else if(max < Integer.parseInt(txtQtd.getText()) | max == 0) {
					lblMensagem.setText("O número de pessoas não é adequado para esse chalé");
					
				}
				
				
				else if(java.sql.Date.valueOf(txtDataOut.getText()).before(java.sql.Date.valueOf(txtDataIn.getText()))) {
					lblMensagem.setText("A data de Check-out precisa ser depois do check-in");
				}else if(java.sql.Date.valueOf(txtDataOut.getText()).equals(java.sql.Date.valueOf(txtDataIn.getText()))) {
					lblMensagem.setText("Data de saída e entrada não podem ser iguais");
				}
				
				
				else {
					
				    hospedagem.setCodHospedagem(x);
				    hospedagem.setCodChale(Integer.parseInt(txtCodCha.getText()));
				    hospedagem.setCodCliente(Integer.parseInt(txtCodCli.getText()));
				    hospedagem.setDesconto(Double.parseDouble(txtDesc.getText()));
				    hospedagem.setDataInicio(java.sql.Date.valueOf(txtDataIn.getText()));
				    hospedagem.setDataFim(java.sql.Date.valueOf(txtDataOut.getText()));
				    hospedagem.setQtdPessoas(Integer.parseInt(txtQtd.getText()));
				    hospedagem.setDesconto(Double.parseDouble(txtDesc.getText()));
				    lblMensagemMax.setText(Integer.toString(max));
				    
				    lblMensagem.setText(cc.inserir(hospedagem));
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
				List<Hospedagem> listaHosp = new ArrayList<>();
				Hospedagem hospedagem = new Hospedagem();
				HospedagemController cc = new HospedagemController();
				listaHosp = cc.listarTodos();
				int x = Integer.parseInt(txtCod.getText());
				int cond = 0;
				
				ClienteController c1 = new ClienteController();
				ChaleController c2 = new ChaleController();
				List<Chale> list2 = new ArrayList<>();
				List<Cliente> list1 = new ArrayList<>();
				list1 = c1.listarTodos();
				list2 = c2.listarTodos();
				int y = Integer.parseInt(txtCodCha.getText());
				int z = Integer.parseInt(txtCodCli.getText());
				int cond1 = 0;
				int cond2 = 0;
				for(int i =0; i < list1.size();i++) {
					if(list1.get(i).getCodCliente() == z) {
						cond1 = 1;
					}
				}
				int max = 0;
				for(int i =0; i < list2.size();i++) {
					if(list2.get(i).getCodChale() == y) {
						cond2 = 1;
						max = list2.get(i).getCapacidade();
					}
				}
				
				for (int i = 0; i < listaHosp.size(); i++) {
				    if (listaHosp.get(i).getCodHospedagem() == x) {
				        cond = 1;
				    }
				}

				if (cond == 0) {
				    lblMensagem.setText("Essa hospedagem ainda não foi inserida");
				} else if(cond1 == 0 & cond2 == 1) {
					lblMensagem.setText("O id_desse cliente não existe");
				}else if(cond2 == 1 & cond1 == 0) {
					lblMensagem.setText("O id desse chalé não existe");
				}else if(cond1 == 0 & cond2 == 0) {
					lblMensagem.setText("o id do chalé e do cliente não existem");
				}else if(max < Integer.parseInt(txtQtd.getText()) | max == 0) {
					lblMensagem.setText("O número de pessoas não é adequado para esse chalé");
					
				}else if(java.sql.Date.valueOf(txtDataOut.getText()).before(java.sql.Date.valueOf(txtDataIn.getText()))) {
					lblMensagem.setText("A data de Check-out precisa ser depois do check-in");
				}else if(java.sql.Date.valueOf(txtDataOut.getText()) == java.sql.Date.valueOf(txtDataIn.getText())) {
					lblMensagem.setText("Data de saída e entrada não podem ser iguais");
				}
				else {
					
				    hospedagem.setCodHospedagem(x);
				    hospedagem.setCodChale(Integer.parseInt(txtCodCha.getText()));
				    hospedagem.setCodCliente(Integer.parseInt(txtCodCli.getText()));
				    hospedagem.setDataInicio(java.sql.Date.valueOf(txtDataIn.getText()));
				    hospedagem.setDataFim(java.sql.Date.valueOf(txtDataOut.getText()));
				    hospedagem.setQtdPessoas(Integer.parseInt(txtQtd.getText()));
				    hospedagem.setDesconto(Double.parseDouble(txtDesc.getText()));
				    
				    lblMensagemMax.setText(Integer.toString(max));
				    lblMensagem.setText(cc.alterar(hospedagem));
				    pesquisar();
				}


			}
		});
		
		JButton btnNewButton_2 = new JButton("Excluir");
		btnNewButton_2.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				Hospedagem h = new Hospedagem();
				HospedagemController hh = new HospedagemController();
				int x = (Integer.parseInt(txtCod.getText()));
				List<Hospedagem> listaHosp = new ArrayList<>();
				listaHosp = hh.listarTodos();
				int cond = 0;
				for(int i = 0; i < listaHosp.size(); i++) {
					
					if(listaHosp.get(i).getCodHospedagem() == x) {
						cond = 1;
					}
				}
				if(cond == 0) {
					lblMensagem.setText("Essa hospedagem não existe");
				}
				else {
					h.setCodHospedagem(x);
					Object [] opcoes = {"Sim", "Nao"};
					int i = JOptionPane.showOptionDialog(null,
							"Deseja excluir essa hospedagem: "+Integer.parseInt(txtCod.getText())+"?","Exclusão",
							JOptionPane.YES_NO_OPTION,JOptionPane.QUESTION_MESSAGE, null,
							opcoes, opcoes[0]);
					if(JOptionPane.YES_OPTION == i){
						lblMensagem.setText(hh.excluir(h));
						pesquisar();
						}
				}
			}
		});
		
		JButton btnNewButton_3 = new JButton("Pesquisar");
		btnNewButton_3.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				List<Hospedagem> listaHosp = new ArrayList<>();
				
				HospedagemController cc = new HospedagemController();
				listaHosp = cc.listarTodos(); 
				DefaultTableModel tbm = (DefaultTableModel)tblConsulta.getModel();
				
				

				
				for (int i = tbm.getRowCount() - 1; i >= 0; i--) {
				    tbm.removeRow(i);
				}

				int i = 0;
				for (Hospedagem hospedagem : listaHosp) {
				    tbm.addRow(new String[1]); 
				    
				    tblConsulta.setValueAt(hospedagem.getCodHospedagem(), i, 0);
				    tblConsulta.setValueAt(hospedagem.getCodChale(), i, 1);
				    tblConsulta.setValueAt(hospedagem.getCodCliente(), i, 2);
				    tblConsulta.setValueAt(hospedagem.getDataInicio(), i, 3);
				    tblConsulta.setValueAt(hospedagem.getDataFim(), i, 4);
				    tblConsulta.setValueAt(hospedagem.getQtdPessoas(), i, 5);
				    tblConsulta.setValueAt(hospedagem.getDesconto(), i, 6);
				    tblConsulta.setValueAt(hospedagem.getValorFinal(), i, 7);
				    
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
				
				txtCodCha.setText("");
				txtCodCli.setText("");
				txtDataIn.setText("");
				txtDataOut.setText("");
				txtQtd.setText("");
				txtDesc.setText("");
				txtFinal.setText("");
				
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
				FrmHospedagem.this.dispose();
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
		
		txtCodCha = new JTextField();
		txtCodCha.setColumns(10);
		
		JLabel lblNewLabel_2 = new JLabel("Código Chalé");
		
		txtCodCli = new JTextField();
		txtCodCli.setColumns(10);
		
		JLabel lblNewLabel_2_1 = new JLabel("Código Cliente");
		
		lblMensagem = new JLabel("Mensagem:");
		lblMensagem.setForeground(new Color(0, 0, 255));
		lblMensagem.setBackground(new Color(0, 0, 255));
		try {
			mascaraData = new MaskFormatter("####-##-##");
			} catch (ParseException e) {
			System.err.println(e.getMessage());
		}
		
		txtDataIn = new JFormattedTextField(mascaraData);
		
		txtDataOut = new JFormattedTextField(mascaraData);
		
		JLabel lblDataCheckin = new JLabel("Data check-in");
		
		JLabel lblDataCheckout = new JLabel("Data check-out");
		
		txtQtd = new JTextField();
		txtQtd.setColumns(10);
		
		JLabel lblNewLabel_2_2 = new JLabel("Quantidade de Pessoas");
		
		JLabel lblMensagem_1 = new JLabel("Máx:");
		lblMensagem_1.setForeground(Color.BLUE);
		lblMensagem_1.setBackground(Color.BLUE);
		
		txtDesc = new JTextField();
		txtDesc.setColumns(10);
		
		JLabel lblNewLabel_2_1_1 = new JLabel("Desconto");
		
		lblMensagemMax = new JLabel("");
		lblMensagemMax.setForeground(Color.BLUE);
		lblMensagemMax.setBackground(Color.BLUE);
		
		txtFinal = new JTextField();
		txtFinal.setColumns(10);
		
		JLabel lblNewLabel_2_1_1_1 = new JLabel("VALOR FINAL");
		lblNewLabel_2_1_1_1.setForeground(new Color(255, 0, 0));
		
		GroupLayout gl_panel = new GroupLayout(panel);
		gl_panel.setHorizontalGroup(
			gl_panel.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panel.createSequentialGroup()
					.addContainerGap()
					.addGroup(gl_panel.createParallelGroup(Alignment.TRAILING)
						.addGroup(gl_panel.createSequentialGroup()
							.addGroup(gl_panel.createParallelGroup(Alignment.LEADING)
								.addGroup(gl_panel.createSequentialGroup()
									.addGroup(gl_panel.createParallelGroup(Alignment.LEADING)
										.addGroup(gl_panel.createParallelGroup(Alignment.TRAILING)
											.addComponent(lblNewLabel, GroupLayout.PREFERRED_SIZE, 56, GroupLayout.PREFERRED_SIZE)
											.addComponent(lblDataCheckin))
										.addComponent(lblDataCheckout, GroupLayout.PREFERRED_SIZE, 72, GroupLayout.PREFERRED_SIZE))
									.addGap(18)
									.addGroup(gl_panel.createParallelGroup(Alignment.LEADING)
										.addComponent(txtCod, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
										.addGroup(gl_panel.createSequentialGroup()
											.addGap(10)
											.addGroup(gl_panel.createParallelGroup(Alignment.LEADING)
												.addComponent(txtDataOut, GroupLayout.PREFERRED_SIZE, 74, GroupLayout.PREFERRED_SIZE)
												.addComponent(txtDataIn, GroupLayout.PREFERRED_SIZE, 74, GroupLayout.PREFERRED_SIZE))))
									.addGap(24)
									.addGroup(gl_panel.createParallelGroup(Alignment.TRAILING)
										.addComponent(lblNewLabel_2_2, GroupLayout.PREFERRED_SIZE, 112, GroupLayout.PREFERRED_SIZE)
										.addComponent(lblNewLabel_2, GroupLayout.PREFERRED_SIZE, 76, GroupLayout.PREFERRED_SIZE))
									.addGap(18)
									.addGroup(gl_panel.createParallelGroup(Alignment.LEADING)
										.addGroup(gl_panel.createSequentialGroup()
											.addComponent(txtQtd, GroupLayout.PREFERRED_SIZE, 44, GroupLayout.PREFERRED_SIZE)
											.addPreferredGap(ComponentPlacement.RELATED)
											.addComponent(lblMensagem_1, GroupLayout.PREFERRED_SIZE, 28, GroupLayout.PREFERRED_SIZE)
											.addPreferredGap(ComponentPlacement.UNRELATED)
											.addComponent(lblMensagemMax, GroupLayout.PREFERRED_SIZE, 28, GroupLayout.PREFERRED_SIZE))
										.addComponent(txtCodCha, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
									.addPreferredGap(ComponentPlacement.RELATED, 24, Short.MAX_VALUE)
									.addGroup(gl_panel.createParallelGroup(Alignment.LEADING)
										.addComponent(lblNewLabel_2_1, Alignment.TRAILING, GroupLayout.PREFERRED_SIZE, 70, GroupLayout.PREFERRED_SIZE)
										.addComponent(lblNewLabel_2_1_1, Alignment.TRAILING, GroupLayout.PREFERRED_SIZE, 70, GroupLayout.PREFERRED_SIZE))
									.addGap(18)
									.addGroup(gl_panel.createParallelGroup(Alignment.LEADING)
										.addComponent(txtDesc, GroupLayout.PREFERRED_SIZE, 142, GroupLayout.PREFERRED_SIZE)
										.addComponent(txtCodCli, GroupLayout.PREFERRED_SIZE, 142, GroupLayout.PREFERRED_SIZE)))
								.addComponent(lblMensagem, GroupLayout.PREFERRED_SIZE, 347, GroupLayout.PREFERRED_SIZE))
							.addContainerGap(11, Short.MAX_VALUE))
						.addGroup(gl_panel.createSequentialGroup()
							.addComponent(lblNewLabel_2_1_1_1, GroupLayout.PREFERRED_SIZE, 85, GroupLayout.PREFERRED_SIZE)
							.addGap(18)
							.addComponent(txtFinal, GroupLayout.PREFERRED_SIZE, 142, GroupLayout.PREFERRED_SIZE)
							.addContainerGap())))
		);
		gl_panel.setVerticalGroup(
			gl_panel.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panel.createSequentialGroup()
					.addContainerGap()
					.addGroup(gl_panel.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_panel.createSequentialGroup()
							.addGroup(gl_panel.createParallelGroup(Alignment.BASELINE)
								.addComponent(txtCod, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
								.addComponent(lblNewLabel))
							.addPreferredGap(ComponentPlacement.UNRELATED)
							.addGroup(gl_panel.createParallelGroup(Alignment.BASELINE)
								.addComponent(lblDataCheckin)
								.addComponent(txtDataIn, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
							.addGap(12)
							.addGroup(gl_panel.createParallelGroup(Alignment.BASELINE)
								.addComponent(lblDataCheckout)
								.addComponent(txtDataOut, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)))
						.addGroup(gl_panel.createSequentialGroup()
							.addGroup(gl_panel.createParallelGroup(Alignment.BASELINE)
								.addComponent(txtCodCha, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
								.addComponent(lblNewLabel_2)
								.addComponent(txtCodCli, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
								.addComponent(lblNewLabel_2_1))
							.addGap(18)
							.addGroup(gl_panel.createParallelGroup(Alignment.BASELINE)
								.addComponent(txtQtd, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
								.addComponent(lblNewLabel_2_2)
								.addComponent(lblMensagem_1)
								.addComponent(txtDesc, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
								.addComponent(lblNewLabel_2_1_1)
								.addComponent(lblMensagemMax))))
					.addGroup(gl_panel.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_panel.createSequentialGroup()
							.addPreferredGap(ComponentPlacement.RELATED, 25, Short.MAX_VALUE)
							.addComponent(lblMensagem)
							.addContainerGap())
						.addGroup(gl_panel.createSequentialGroup()
							.addGap(4)
							.addGroup(gl_panel.createParallelGroup(Alignment.BASELINE)
								.addComponent(txtFinal, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
								.addComponent(lblNewLabel_2_1_1_1))
							.addContainerGap())))
		);
		panel.setLayout(gl_panel);
		contentPane1.setLayout(gl_contentPane1);
	}
}