package view;


import java.awt.*;
import javax.swing.*;

import controller.MonthControl;
import model.Month;

public class UIMonth {
	
	private MonthControl mc;
	private JFrame marco;
	private JPanel laminaPrincipal;
	private JPanel laminaSuperior;
	private JPanel laminaInferior;
	JTextField yearText;
	JTextField monthText;
	

	public UIMonth (MonthControl mc) {

		this.mc=mc;
	}
	
	public void drawMonthFirstTime (Month month) {

		generarVentana();
		generarOpcionesSuperiores(laminaSuperior);
		monthText.setText(month.getMesesAno()[month.getMonth()]);
		yearText.setText(Integer.toString(month.getYear()));
		generarCuadriculaMes (laminaInferior,month);
		marco.add(laminaPrincipal);
		visualizarVentana ();

	}
	
	public void drawUpdate(Month month) {
		
		monthText.setText(month.getMesesAno()[month.getMonth()]);
		yearText.setText(Integer.toString(month.getYear()));
		generarCuadriculaMes (laminaInferior,month);
		marco.add(laminaPrincipal);
		visualizarVentana ();
		
	}
	

	private void generarVentana () {
		
		marco = new JFrame("Calendario");
		marco.setBounds(300, 300, 220, 200);		
		laminaPrincipal = new JPanel();
		laminaPrincipal.setLayout(new BorderLayout());
		laminaSuperior = new JPanel();
		laminaSuperior.setBackground(Color.LIGHT_GRAY);
		laminaInferior = new JPanel();
		laminaPrincipal.add(laminaSuperior, BorderLayout.NORTH);
		laminaPrincipal.add(laminaInferior, BorderLayout.CENTER);
		
	}
	
	
	private void generarOpcionesSuperiores(JPanel laminaSuperior) {
		
		Dimension preferredSize = new Dimension (15,20);
		FlowLayout fl = new FlowLayout();
		laminaSuperior.setLayout(fl);
		
		JButton botonFlechaIzquierda = new JButton("<");
		yearText = new JTextField ("",3);
		yearText.setEditable(false);
		yearText.setHorizontalAlignment(JTextField.CENTER);
		JButton botonFlechaDerecha = new JButton(">");
		
		botonFlechaIzquierda.addActionListener(mc.getMonthControlYear());
		botonFlechaDerecha.addActionListener(mc.getMonthControlYear());
		
		JButton botonFlechaIzquierda2 = new JButton("<");
		monthText = new JTextField ("",6);
		monthText.setEditable(false);
		monthText.setHorizontalAlignment(JTextField.CENTER);
		JButton botonFlechaDerecha2 = new JButton(">");
		
		botonFlechaIzquierda2.addActionListener(mc.getMonthControlMonth());
		botonFlechaDerecha2.addActionListener(mc.getMonthControlMonth());
		
		botonFlechaIzquierda.setPreferredSize(preferredSize);
		botonFlechaDerecha.setPreferredSize(preferredSize);
		botonFlechaIzquierda2.setPreferredSize(preferredSize);
		botonFlechaDerecha2.setPreferredSize(preferredSize);
		
		laminaSuperior.add(botonFlechaIzquierda);
		laminaSuperior.add(yearText);
		laminaSuperior.add(botonFlechaDerecha);
		
		laminaSuperior.add(botonFlechaIzquierda2);
		laminaSuperior.add(monthText);
		laminaSuperior.add(botonFlechaDerecha2);
		
	}
	
	
	private void generarCuadriculaMes (JPanel laminaInferior, Month month) {
		
		GridLayout grid = new GridLayout(7,7);
		laminaInferior.removeAll();
		laminaInferior.setLayout(grid);
		laminaInferior.setComponentOrientation(ComponentOrientation.LEFT_TO_RIGHT);
		generarMes(laminaInferior, month);
		
		
	}
	
	private void generarMes (JPanel laminaInferior, Month month) {
		
		for (String a:month.monthToDraw()) {
			
			JTextField tf = new JTextField(a,1);
			tf.setEditable(false);
			tf.setHorizontalAlignment(JTextField.CENTER);
			
			if (month.isCourrentMonth()&&month.toDay().equals(a)) {
				
				tf.setForeground(Color.RED);
				
			};
			
			laminaInferior.add(tf);
			
		}
		
	}
	
	private void visualizarVentana () {
		
		marco.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		marco.setVisible(true);
		marco.addWindowListener(mc.getMonthControlWindow());
		
	}
	

	
	

	
	public JTextField getYearText() {
		return yearText;
	}

	public void setYearText(JTextField monthText) {
		this.yearText = monthText;
	}
	
	public JTextField getMonthText() {
		return monthText;
	}

	public void setMonthText(JTextField monthText) {
		this.monthText = monthText;
	}

}
