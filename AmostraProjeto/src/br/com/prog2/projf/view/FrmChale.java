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


import br.com.prog2.projf.controller.ChaleController;

import br.com.prog2.projf.model.Chale;


public class FrmChale extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane1;
	private JTable tblConsulta;
	private JTextField txtCod;
	private JTextField txtLoc;
	private JTextField txtBaixa;
	private JTextField txtCap;
	private JLabel lblMensagem;
	
	private JTextField txtAlta;
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					FrmChale frame = new FrmChale();
					frame.setLocationRelativeTo(null);
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}
	private void pesquisar() {
		List<Chale> listaChales = new ArrayList<>();
		ChaleController ccl = new ChaleController();
		listaChales = ccl.listarTodos(); 
		DefaultTableModel tbm = (DefaultTableModel)tblConsulta.getModel();

		
		for (int i = tbm.getRowCount() - 1; i >= 0; i--) {
		    tbm.removeRow(i);
		}

		int i = 0;
		for (Chale cl : listaChales) {
		    tbm.addRow(new String[1]); 
		    
		    tblConsulta.setValueAt(cl.getCodChale(), i, 0);
		    tblConsulta.setValueAt(cl.getLocalizacao(), i, 1);
		    tblConsulta.setValueAt(cl.getCapacidade(), i, 2);
		    tblConsulta.setValueAt(cl.getValorAltaEstacao(), i, 3);
		    tblConsulta.setValueAt(cl.getValorBaixaEstacao(), i, 4);
		
		    
		    i++;
		}
	}

	/**
	 * Create the frame.
	 */
	
	public FrmChale() {
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

		            
		            if (model.getColumnCount() >= 5) {
		                try {
		                    
		                	String codChale = model.getValueAt(row, 0) != null ? model.getValueAt(row, 0).toString() : "";
		                	String locChale = model.getValueAt(row, 1) != null ? model.getValueAt(row, 1).toString() : "";
		                	String baixaChale = model.getValueAt(row, 2) != null ? model.getValueAt(row, 2).toString() : "";
		                	String capChale = model.getValueAt(row, 3) != null ? model.getValueAt(row, 3).toString() : "";
		                	String altaChale = model.getValueAt(row, 4) != null ? model.getValueAt(row, 4).toString() : "";

		                	// Setting values in the respective text fields
		                	txtCod.setText(codChale);
		                	txtLoc.setText(locChale);
		                	txtBaixa.setText(baixaChale);
		                	txtCap.setText(capChale);
		                	txtAlta.setText(altaChale);

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
			        "Código", "Localização", "Capacidade", "Valor Baixa Est.", "Valor Alta Est."
			    }
			) {
			    
			    boolean[] columnEditables = new boolean[] {
			        false, // 
			        false, // 
			        false, // 
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
				
				Chale chale = new Chale();
				ChaleController cc = new ChaleController();
				int x = (Integer.parseInt(txtCod.getText()));
				List<Chale> listaChales = new ArrayList<>();
				listaChales = cc.listarTodos();
				
				int cond = 0;
				for(int i = 0; i < listaChales.size(); i++) {
				    if(listaChales.get(i).getCodChale() == x) {
				        cond = 1;
				    }
				}
				

				if(cond == 1) {
				    lblMensagem.setText("Esse chale já foi inserido");
				} else {
				    chale.setCodChale(x);
				    chale.setLocalizacao(txtLoc.getText());
				    chale.setValorBaixaEstacao(Double.parseDouble(txtBaixa.getText()));
				    chale.setCapacidade(Integer.parseInt(txtCap.getText()));
				    chale.setValorAltaEstacao(Double.parseDouble(txtAlta.getText()));
				    
				    
				    lblMensagem.setText(cc.inserir(chale));
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
				List<Chale> listaChales = new ArrayList<>();
				Chale chale = new Chale();
				ChaleController cc = new ChaleController();
				listaChales = cc.listarTodos();
				int x = Integer.parseInt(txtCod.getText());
				int cond = 0;
				for (int i = 0; i < listaChales.size(); i++) {
				    if (listaChales.get(i).getCodChale() == x) {
				        cond = 1;
				    }
				}

				if (cond == 0) {
				    lblMensagem.setText("Esse chale ainda não foi inserido");
				} else {
				    chale.setCodChale(x);
				    chale.setLocalizacao(txtLoc.getText());
				    chale.setCapacidade(Integer.parseInt(txtCap.getText()));
				    chale.setValorBaixaEstacao(Double.parseDouble(txtBaixa.getText()));
				    chale.setValorAltaEstacao(Double.parseDouble(txtAlta.getText()));

				    lblMensagem.setText(cc.alterar(chale));
				    pesquisar();
				}


			}
		});
		
		JButton btnNewButton_2 = new JButton("Excluir");
		btnNewButton_2.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				Chale c = new Chale();
				ChaleController cc = new ChaleController();
				int x = (Integer.parseInt(txtCod.getText()));
				List<Chale> listaChales = new ArrayList<>();
				listaChales = cc.listarTodos();
				int cond = 0;
				for(int i = 0; i < listaChales.size(); i++) {
					
					if(listaChales.get(i).getCodChale() == x) {
						cond = 1;
					}
				}
				if(cond == 0) {
					lblMensagem.setText("Esse chalé não está na lista");
				}
				else {
					c.setCodChale(x);
					Object [] opcoes = {"Sim", "Nao"};
					int i = JOptionPane.showOptionDialog(null,
							"Deseja excluir esse chalé: "+Integer.parseInt(txtCod.getText())+"?","Exclusão",
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
				List<Chale> listaChales = new ArrayList<>();
				
				ChaleController cc = new ChaleController();
				listaChales = cc.listarTodos(); 
				DefaultTableModel tbm = (DefaultTableModel)tblConsulta.getModel();

				// Clear the table before adding new rows
				for (int i = tbm.getRowCount() - 1; i >= 0; i--) {
				    tbm.removeRow(i);
				}

				int i = 0;
				for (Chale chale : listaChales) {
				    tbm.addRow(new String[1]); 
				    
				    tblConsulta.setValueAt(chale.getCodChale(), i, 0);
				    tblConsulta.setValueAt(chale.getLocalizacao(), i, 1);
				    tblConsulta.setValueAt(chale.getCapacidade(), i, 2);
				    tblConsulta.setValueAt(chale.getValorBaixaEstacao(), i, 3);
				    tblConsulta.setValueAt(chale.getValorAltaEstacao(), i, 4);
				    
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
				
				txtLoc.setText("");
				txtBaixa.setText("");
				txtAlta.setText("");
				
				txtCap.setText("");
				
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
				FrmChale.this.dispose();
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
		
		JLabel lblBaixa = new JLabel("Valor Alta Estação");
		
		txtLoc = new JTextField();
		txtLoc.setColumns(10);
		
		JLabel lblNewLabel_2 = new JLabel("Localização");
		
		txtBaixa = new JTextField();
		txtBaixa.setColumns(10);
		
		txtCap = new JTextField();
		txtCap.setColumns(10);
		
		JLabel lblNewLabel_2_1 = new JLabel("Capacidade");
		
		lblMensagem = new JLabel("Mensagem:");
		lblMensagem.setForeground(new Color(0, 0, 255));
		lblMensagem.setBackground(new Color(0, 0, 255));
		
		
		
	
		
		txtAlta = new JTextField();
		txtAlta.setColumns(10);
		
		JLabel lblValorAltaEstao = new JLabel("Valor Baixa Estação");
		
		GroupLayout gl_panel = new GroupLayout(panel);
		gl_panel.setHorizontalGroup(
			gl_panel.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panel.createSequentialGroup()
					.addContainerGap()
					.addGroup(gl_panel.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_panel.createSequentialGroup()
							.addPreferredGap(ComponentPlacement.RELATED, 9, Short.MAX_VALUE)
							.addGroup(gl_panel.createParallelGroup(Alignment.TRAILING, false)
								.addGroup(gl_panel.createSequentialGroup()
									.addComponent(lblNewLabel, GroupLayout.PREFERRED_SIZE, 56, GroupLayout.PREFERRED_SIZE)
									.addPreferredGap(ComponentPlacement.RELATED, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
									.addComponent(txtCod, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
									.addGap(18)
									.addComponent(lblNewLabel_2)
									.addGap(40))
								.addGroup(gl_panel.createSequentialGroup()
									.addComponent(lblBaixa)
									.addPreferredGap(ComponentPlacement.UNRELATED)
									.addComponent(txtAlta, GroupLayout.PREFERRED_SIZE, 96, GroupLayout.PREFERRED_SIZE)
									.addGap(18)
									.addComponent(lblValorAltaEstao, GroupLayout.PREFERRED_SIZE, 90, GroupLayout.PREFERRED_SIZE)
									.addGap(4)))
							.addGroup(gl_panel.createParallelGroup(Alignment.LEADING)
								.addGroup(gl_panel.createSequentialGroup()
									.addComponent(txtLoc, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
									.addGap(18)
									.addComponent(lblNewLabel_2_1, GroupLayout.PREFERRED_SIZE, 70, GroupLayout.PREFERRED_SIZE))
								.addComponent(txtBaixa, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)))
						.addComponent(lblMensagem, GroupLayout.PREFERRED_SIZE, 347, GroupLayout.PREFERRED_SIZE))
					.addGap(27)
					.addComponent(txtCap, GroupLayout.PREFERRED_SIZE, 142, GroupLayout.PREFERRED_SIZE)
					.addGap(56))
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
							.addGap(18)
							.addComponent(lblBaixa))
						.addGroup(gl_panel.createParallelGroup(Alignment.TRAILING)
							.addGroup(gl_panel.createSequentialGroup()
								.addComponent(txtCap, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
								.addGap(66))
							.addGroup(gl_panel.createSequentialGroup()
								.addGroup(gl_panel.createParallelGroup(Alignment.BASELINE)
									.addComponent(txtLoc, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
									.addComponent(lblNewLabel_2)
									.addComponent(lblNewLabel_2_1))
								.addGap(18)
								.addGroup(gl_panel.createParallelGroup(Alignment.BASELINE)
									.addComponent(lblValorAltaEstao)
									.addComponent(txtBaixa, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
									.addComponent(txtAlta, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
								.addGap(28))))
					.addGap(18)
					.addComponent(lblMensagem)
					.addContainerGap(11, Short.MAX_VALUE))
		);
		panel.setLayout(gl_panel);
		contentPane1.setLayout(gl_contentPane1);
	}
}