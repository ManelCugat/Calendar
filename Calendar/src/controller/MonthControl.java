package controller;


import java.awt.event.*;

import model.Month;
import view.UIMonth;


public class MonthControl {
	
	MonthControlYear mcy;
	MonthControlMonth mcm;
	MonthControlWindow mcw;
	Month month;
	UIMonth uiMonth;
	
	public MonthControl(Month month) {
		
		this.month=month;
		mcy =  new MonthControlYear();
		mcm =  new MonthControlMonth();
		mcw = new MonthControlWindow();
		uiMonth = new UIMonth(this);
		uiMonth.drawMonthFirstTime(month);
		
	}
	
	public MonthControl () {
		

		mcy =  new MonthControlYear();
		mcm =  new MonthControlMonth();
		
	}
	
	public MonthControlYear getMonthControlYear() {
		
		return mcy;
	
	}
	
	public MonthControlMonth getMonthControlMonth() {
		
		return mcm;
	}
	
	public MonthControlWindow getMonthControlWindow() {
		
		return mcw;
		
	}
	
	
	private class MonthControlYear implements ActionListener{
		
		public MonthControlYear() {
			
		}
		
		public void actionPerformed(ActionEvent e) {
			
			
			int year = Integer.parseInt(uiMonth.getYearText().getText());
			
			String bp = e.getActionCommand();
			
			if (bp.equals("<")){
				
				year--;
		
			}else year++;
			
			String m = uiMonth.getMonthText().getText();
			int mes = month.monthToInt(m);
			Month newMonth = new Month (mes,year);
			uiMonth.drawUpdate(newMonth);
			
		}

		
	}
	
	private class MonthControlMonth implements ActionListener{
		
		public MonthControlMonth() {
			
		}

		public void actionPerformed(ActionEvent e) {

			int year = Integer.parseInt(uiMonth.getYearText().getText());
			String m = uiMonth.getMonthText().getText();
			int mes = month.monthToInt(m);
			String bp = e.getActionCommand();
			
			if (bp.equals("<")){
				
				mes --;
				
				if (mes<0){
					
					mes = 11;
					year--;
				
				} 	
			
			}
					
				
			if (bp.equals(">")) {
				
				mes ++;
					
				if (mes>11) {
					
					mes = 0;
					year++;
				
				}
			}
			
			Month newMonth = new Month (mes,year);
			uiMonth.drawUpdate(newMonth);
			
		}
		
	}
		
		
	private class MonthControlWindow implements WindowListener{


		public void windowActivated(WindowEvent e) {
				
			System.out.println("VENTANA ABIERTA");
			
		}

		public void windowClosed(WindowEvent e) {}
		public void windowClosing(WindowEvent e) {}
		public void windowDeactivated(WindowEvent e) {}
		public void windowDeiconified(WindowEvent e) {}
		public void windowIconified(WindowEvent e) {}
		public void windowOpened(WindowEvent e) {}
		
	
	}
		
		
		
	}
	

