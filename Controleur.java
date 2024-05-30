import java.awt.*;
import java.awt.event.ActionEvent;
import java.util.ArrayList;
import java.util.List;

import javax.security.auth.x500.X500Principal;
import javax.swing.*;
import javax.swing.table.DefaultTableCellRenderer;

public class Controleur {
	private Jeu jeu = new Jeu();
	private List<List<Object>> tabScore = new ArrayList<>();
	private List<JLabel> deLabels = new ArrayList<>();
	private JLabel carteLabel;
	private JPanel mainPanel ; 

	private static final int IMAGE_WIDTH = 204;
	private static final int IMAGE_HEIGHT = 310;
	private static final int DE_IMAGE_SIZE = 100;
	private static final Dimension BUTTON_SIZE = new Dimension(150, 50);

	public Controleur() 
	{
		JFrame frame = new JFrame("Mille Sabords");
		Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();

		JPanel panel1 = createPanel1();
		JPanel panel2 = createPanel2();
		JPanel panel3 = createPanel3();
		JPanel panel4 = createPanel4();

		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setSize(screenSize.width, screenSize.height);
		frame.add(createMainPanel(panel1, panel2, panel3, panel4));
		frame.setVisible(true);
	}

	private JPanel createMainPanel(JPanel panel1, JPanel panel2, JPanel panel3, JPanel panel4) {
		mainPanel = new JPanel() 
		{
			protected void paintComponent(Graphics g) 
			{
				super.paintComponent(g);
				ImageIcon imageIcon = new ImageIcon("images/fond.jpg");
				g.drawImage(imageIcon.getImage(), 0, 0, getWidth(), getHeight(), this);
			}
		};
		mainPanel.setLayout(new GridLayout(2, 2));
		mainPanel.add(panel1);
		mainPanel.add(panel2);
		mainPanel.add(panel3);
		mainPanel.add(panel4);
		return mainPanel;
	}

	private JPanel createPanel1() {
		JPanel panel1 = new JPanel(new GridLayout(2, 2));
		panel1.setOpaque(false);
	
		for (Joueur joueur : jeu.getJoueurs()) {
			List<Object> joueurInfo = new ArrayList<>();
			joueurInfo.add(joueur.getNom());
			joueurInfo.add(joueur.getScore());
			tabScore.add(joueurInfo);
		}
	
		String[] columnNames = {"Nom", "Score", "Actif"};
		Object[][] data = getTableData();
	
		JTable table = new JTable(data, columnNames) {
			public boolean isCellEditable(int row, int column) {
				return false;
			}
		};
	
		table.setOpaque(false);
		table.setFillsViewportHeight(true);
		table.setDefaultRenderer(Object.class, new HighlightRenderer());
	
		JScrollPane scrollPane = new JScrollPane(table);
		scrollPane.setOpaque(false);
		scrollPane.getViewport().setOpaque(false);
		scrollPane.setBorder(BorderFactory.createEmptyBorder());
	
		panel1.add(scrollPane);
		return panel1;
	}
	


	private JPanel createPanel2() 
	{
		JPanel panel2 = new JPanel(new BorderLayout());
		panel2.setOpaque(false);

		JLabel scoreLabel = new JLabel(resizeImageIcon(new ImageIcon("images/Score.jpg"), IMAGE_WIDTH, IMAGE_HEIGHT));
		scoreLabel.setPreferredSize(new Dimension(IMAGE_WIDTH, IMAGE_HEIGHT));
		panel2.add(scoreLabel, BorderLayout.EAST);

		carteLabel = new JLabel(resizeImageIcon(new ImageIcon("images/" + this.jeu.getCarte().getSymbole()), IMAGE_WIDTH, IMAGE_HEIGHT));
		carteLabel.setPreferredSize(new Dimension(IMAGE_WIDTH, IMAGE_HEIGHT));
		panel2.add(carteLabel, BorderLayout.WEST);

		if (!this.jeu.getPioche().isEmpty()) 
		{
			JLabel piocheLabel = new JLabel(resizeImageIcon(new ImageIcon("images/dos.jpg"), IMAGE_WIDTH, IMAGE_HEIGHT));
			piocheLabel.setPreferredSize(new Dimension(IMAGE_WIDTH, IMAGE_HEIGHT));
			panel2.add(piocheLabel, BorderLayout.CENTER);
		} 
		else 
		{
			JLabel emptyLabel = new JLabel("Pioche vide");
			panel2.add(emptyLabel,BorderLayout.CENTER);
		}

		return panel2;
	}

	private JPanel createPanel3() 
	{
		JPanel panel3 = new JPanel(new GridLayout(2, 4));
		panel3.setOpaque(false);
		
		List<De> des = De.getDes();
		
		for (int i = 0; i < des.size(); i++) 
		{
			De de = des.get(i);
			JLabel deLabel = new JLabel(resizeImageIcon(new ImageIcon("images/" + de.getFace()), DE_IMAGE_SIZE, DE_IMAGE_SIZE));
			deLabel.setPreferredSize(new Dimension(DE_IMAGE_SIZE, DE_IMAGE_SIZE));
			deLabels.add(deLabel);
		
			int index = i;
			deLabel.addMouseListener(new java.awt.event.MouseAdapter() 
			{
				public void mouseClicked(java.awt.event.MouseEvent evt) 
				{
					De clickedDe = des.get(index);
					clickedDe.setVerrouille(!clickedDe.getVerrouille());
					updateDeLabelAppearance(deLabel, clickedDe);
				}
			});
		
			panel3.add(deLabel);
		}
		
		return panel3;
	}

	private JPanel createPanel4() 
	{
		JPanel panel4 = new JPanel(new BorderLayout());
		panel4.setOpaque(false);

		JButton lancerButton = new JButton("Lancer");
		JButton finDuTour = new JButton("Fin du tour");

		lancerButton.setPreferredSize(BUTTON_SIZE);
		lancerButton.addActionListener(e -> 
		{
			jeu.lancer();
			updateDeFaces();
		});

		finDuTour.setPreferredSize(BUTTON_SIZE);
		finDuTour.addActionListener(e -> 
		{
			jeu.finDuTour();
			updateTable();
			updateCarteLabel();
		});

		JPanel panelBoutons = new JPanel(new FlowLayout());
		panelBoutons.setOpaque(false);
		panelBoutons.add(lancerButton);
		panelBoutons.add(finDuTour);

		panel4.add(panelBoutons, BorderLayout.SOUTH);
		return panel4;
	}

	private ImageIcon resizeImageIcon(ImageIcon icon, int width, int height) 
	{
		Image image = icon.getImage().getScaledInstance(width, height, Image.SCALE_SMOOTH);
		return new ImageIcon(image);
	}

	private void updateDeFaces() 
	{
		List<De> des = jeu.getDes();
		for (int i = 0; i < des.size(); i++) 
		{
			De de = des.get(i);
			deLabels.get(i).setIcon(resizeImageIcon(new ImageIcon("images/" + de.getFace()), DE_IMAGE_SIZE, DE_IMAGE_SIZE));
		}
	}

	private void updateCarteLabel() 
	{
		ImageIcon newCarteIcon = new ImageIcon("images/" + this.jeu.getCarte().getSymbole());
		carteLabel.setIcon(resizeImageIcon(newCarteIcon, IMAGE_WIDTH, IMAGE_HEIGHT));
	}

	private void updateDeLabelAppearance(JLabel deLabel, De de) 
	{
		if (de.getVerrouille()) 
		{
			deLabel.setEnabled(false);
			deLabel.setIcon(resizeImageIcon(new ImageIcon("images/" + de.getFaceVerrouille()), DE_IMAGE_SIZE, DE_IMAGE_SIZE));
		} 
		else 
		{
			deLabel.setEnabled(true);
			deLabel.setIcon(resizeImageIcon(new ImageIcon("images/" + de.getFace()), DE_IMAGE_SIZE, DE_IMAGE_SIZE));
		}
	}


	private Object[][] getTableData() {
		Object[][] data = new Object[tabScore.size()][3];
		for (int i = 0; i < tabScore.size(); i++) 
		{
			data[i][0] = tabScore.get(i).get(0); 
			data[i][1] = tabScore.get(i).get(1);
			data[i][2] = jeu.getJoueurs().get(i) == jeu.getJoueurActif() ? "Oui" : "Non";
		}
		return data;
	}
	
	private void updateTable() 
	{
		Object[][] data = getTableData();
		JPanel panel1 = (JPanel) mainPanel.getComponent(0);
		JScrollPane scrollPane = (JScrollPane) panel1.getComponent(0);
		JTable table = (JTable) scrollPane.getViewport().getView();
		
		for (int i = 0; i < data.length; i++) 
		{
			for (int j = 0; j < data[i].length; j++) 
			{
				table.setValueAt(data[i][j], i, j);
			}
		}
	}
	

	public static void main(String[] args) 
	{
		new Controleur();
	}
}

class HighlightRenderer extends DefaultTableCellRenderer 
{
	public Component getTableCellRendererComponent(JTable table, Object value, boolean isSelected, boolean hasFocus, int row, int column) 
	{
		Component cell = super.getTableCellRendererComponent(table, value, isSelected, hasFocus, row, column);
		boolean isActive = "Oui".equals(table.getValueAt(row, 2));
		if (isActive) 
		{
			cell.setBackground(Color.YELLOW);
		} 
		else 
		{
			cell.setBackground(Color.WHITE);
		}
		return cell;
	}
}

