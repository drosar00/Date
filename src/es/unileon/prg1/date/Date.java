package es.unileon.prg1.date;

public class Date {
	private int day;
	private int month;
	private int year;

	// Constructor mal programado: Permite crear fechas no validas
	public Date(int day, int month, int year){
		setYear(year);
		setMonth(month);
		setDay(day);
	}

	public int getYear(){
		return this.year;
	}

	public int getMonth(){
		return this.month;
	}

	public int getDay(){
		return this.day;
	}
	
	void setYear(int year){
		this.year=year;
	}

	void setMonth(int month){
		if(isMonthOK(month)) {
			this.month=month;
			} else incorrectDate();
	}

	void setDay(int day){
		if(isDayOfMonthOK(day)) {
		this.day=day;
		} else incorrectDate();
	}

	boolean isSameYear(Date another){
		if ( this.year == another.getYear() ){
			return true;
		}
		return false;
	}

	boolean isSameMonth(Date another){
		if ( this.month == another.getMonth() ){
			return true;
		}
		return false;
	}

	boolean isSameDay(Date another){
		if ( this.day == another.getDay() ){
			return true;
		}
		return false;
	}

	boolean isSameDate(Date another){
		if ( isSameDay(another )&& isSameMonth(another) && isSameYear(another)){
			return true;
		}
		return false;
	}

	String getMonthName(){
	  String name="";

	  switch(this.month){
	    case 1:
	    	name= "Enero";
	    	break;
	    case 2:
	    	name="Febrero";
	    	break;
			case 3:
				name="Marzo";
				break;
			case 4:
				name="Abril";
				break;
			case 5:
				name="Mayo";
				break;
			case 6:
				name="Junio";
				break;
			case 7:
				name="Julio";
				break;
			case 8:
				name="Agosto";
				break;
			case 9:
				name="Septiembre";
				break;
			case 10:
				name="Octubre";
				break;
			case 11:
				name="Noviembre";
				break;
			case 12:
				name="Diciembre";
				break;
	  }
	  return name;
	  }

		boolean isDayOfMonthOK(int day){
		boolean ok=false;

		 switch(this.month){
			 case 1:
			 case 3:
			 case 5:
			 case 7:
			 case 8:
			 case 10:
			 case 12:
			 	if (1<=day&&day<=31){
					ok=true;
			 	}
				else ok=false;
				break;
			case 4:
			case 6:
			case 9:
			case 11:
				if(1<=day&&day<=30){
					ok=true;
				}
				else ok=false;
				break;
			case 2:
				if(1<=day&&day<=28){
					ok=true;
				}
				else ok=false;
				break;
		 }
		return ok;
		}
		
		boolean isMonthOK(int month){
			boolean ok=false;
				if(1<=month&&month<=12) {
					ok=true;
				}
			return ok;
			}
		
		void incorrectDate(){
			if (this.month==0) {
				this.month=12;
				System.out.println("El mes introducido no fue correcto y se cambio por Diciembre");
			}
			if (this.day==0) {
				this.day=21;
				System.out.println("El dia introducido no fue correcto y se cambio por el 21");
			}
		}

		String getSeason(){
			String season="";

			switch(this.month){
				case 1:
					season="Invierno";
					break;
				case 2:
					season="Invierno";
					break;
				case 3:
					if(this.day<21) {
					season="Invierno";
					} else season ="Primavera";
					break;
				case 4:
					season="Primavera";
					break;
				case 5:
					season="Primavera";
					break;
				case 6:
					if(this.day<21) {
					season="Primavera";
					} else season="Verano";
					break;
				case 7:
					season="Verano";
					break;
				case 8:
					season="Verano";
					break;
				case 9:
					if(this.day<21) {
					season="Verano";
					} else season="Otoño";
					break;
				case 10:
					season="Otoño";
					break;
				case 11:
					season="Otoño";
					break;
				case 12:
					if(this.day<21) {
					season="Otoño";
					} else season="Invierno";
					break;
			}
			return season;
		}

		String monthsLeft(){
		  StringBuilder months;
		  months = new StringBuilder();
		  int month=this.month;
		  for(int i=this.month+1; i<=12; i++){
			  setMonth(i);
			  months.append(this.getMonthName()+"\n");
		  }
		  setMonth(month);
		  return months.toString();
		}

		void datesUntilEndMonth(){
			int day=this.day;
			
			if(this.month==2){
				for(int i=this.day+1; i<=28; i++){
					this.day++;
					printDate();
				}
			}else if (this.month==4||this.month==6||this.month==9||this.month==11){
				for(int i=this.day+1; i<=30; i++){
					this.day++;
					printDate();
				}
			} else {
				for(int i=this.day+1; i<=31; i++){
					this.day++;
					printDate();
				}
			}
			this.day=day;
		}

		String monthWithTheSameNumberOfDays(){
			StringBuilder months;
			months = new StringBuilder();

		 switch(this.month){
			 case 1:
			 case 3:
			 case 5:
			 case 7:
			 case 8:
			 case 10:
			 case 12:
			 	months.append("Enero\nMarzo\nMayo\nJulio\nAgosto\nOctubre\nDiciembre\n");
				break;
			case 4:
			case 6:
			case 9:
			case 11:
				months.append("Abril\nJunio\nSeptiembre\nNoviembre\n");
				break;
			case 2:
				months.append("Febrero\n");
				break;
		 }
		return months.toString();
		}

		 int numberDaysSinceFirstDayYear(){
			 int days=0;
			 switch(this.month){
			    case 1:
			    	days=this.day;
			    	break;
			    case 2:
			    	days=this.day+31;
			    	break;
					case 3:
						days=this.day+31+28;
						break;
					case 4:
						days=this.day+31+28+31;
						break;
					case 5:
						days=this.day+31+28+31+30;
						break;
					case 6:
						days=this.day+31+28+31+30+31;
						break;
					case 7:
						days=this.day+31+28+31+30+31+30;
						break;
					case 8:
						days=this.day+31+28+31+30+31+30+31;
						break;
					case 9:
						days=this.day+31+28+31+30+31+30+31+31;
						break;
					case 10:
						days=this.day+31+28+31+30+31+30+31+31+30;
						break;
					case 11:
						days=this.day+31+28+31+30+31+30+31+31+30+31;
						break;
					case 12:
						days=this.day+31+28+31+30+31+30+31+31+30+31+30;
						break;
			  }
			 
			 return days;
	 	}
		 
		 int countAttemptsToRandomDateEqualsToGivenDoWhile() {
			 int count=0;
			 Date random = new Date(1,1,this.year);
			 do {
				random.month=((int)Math.floor(Math.random()*(12-1+1)+1));
				random.day=((int)Math.floor(Math.random()*(31-1+1)+1));
				count++;
			 } while(this.day!=random.getDay()||this.month!=random.getMonth());
			 
			 return count;
		 }

		 int countAttemptsToRandomDateEqualsToGivenWhile() {
			 int count=0;
			 Date random = new Date(0, 0, 0);
			 while(this.day!=random.getDay()||this.month!=random.getMonth()) {
				random.month=((int)Math.floor(Math.random()*(12-1+1)+1));
				random.day=((int)Math.floor(Math.random()*(31-1+1)+1));
				count++;
			 }
			 return count;
		 }
		 
		 String dayOfTheWeek(String day) {
			 int days=0;
			 String[] week = new String[7];
			 switch(day) {
			 case "Lunes":
				 week[0]="Lunes";
				 week[1]="Martes";
				 week[2]="Miercoles";
				 week[3]="Jueves";
				 week[4]="Viernes";
				 week[5]="Sabado";
				 week[6]="Domingo";
				 break;
			 case "Martes":
				 week[0]="Martes";
				 week[1]="Miercoles";
				 week[2]="Jueves";
				 week[3]="Viernes";
				 week[4]="Sabado";
				 week[5]="Domingo";
				 week[6]="Lunes";
				 break;
			 case "Miercoles":
				 week[0]="Miercoles";
				 week[1]="Jueves";
				 week[2]="Viernes";
				 week[3]="Sabado";
				 week[4]="Domingo";
				 week[5]="Lunes";
				 week[6]="Martes";
				 break;
			 case "Jueves":
				 week[0]="Jueves";
				 week[1]="Viernes";
				 week[2]="Sabado";
				 week[3]="Domingo";
				 week[4]="Lunes";
				 week[5]="Martes";
				 week[6]="Miercoles";
				 break;
			 case "Viernes":
				 week[0]="Viernes";
				 week[1]="Sabado";
				 week[2]="Domingo";
				 week[3]="Lunes";
				 week[4]="Martes";
				 week[5]="Miercoles";
				 week[6]="Jueves";
				 break;
			 case "Sabado":
				 week[0]="Sabado";
				 week[1]="Domingo";
				 week[2]="Lunes";
				 week[3]="Martes";
				 week[4]="Miercoles";
				 week[5]="Jueves";
				 week[6]="Viernes";
				 break;
			 case "Domingo":
				 week[0]="Domingo";
				 week[1]="Lunes";
				 week[2]="Martes";
				 week[3]="Miercoles";
				 week[4]="Jueves";
				 week[5]="Viernes";
				 week[6]="Sabado";
				 break;
			 }
			 switch(this.month){
			    case 1:
			    	days=this.day;
			    	break;
			    case 2:
			    	days=this.day+31;
			    	break;
					case 3:
						days=this.day+31+28;
						break;
					case 4:
						days=this.day+31+28+31;
						break;
					case 5:
						days=this.day+31+28+31+30;
						break;
					case 6:
						days=this.day+31+28+31+30+31;
						break;
					case 7:
						days=this.day+31+28+31+30+31+30;
						break;
					case 8:
						days=this.day+31+28+31+30+31+30+31;
						break;
					case 9:
						days=this.day+31+28+31+30+31+30+31+31;
						break;
					case 10:
						days=this.day+31+28+31+30+31+30+31+31+30;
						break;
					case 11:
						days=this.day+31+28+31+30+31+30+31+31+30+31;
						break;
					case 12:
						days=this.day+31+28+31+30+31+30+31+31+30+31+30;
						break;
			  }
			 
			 return week[days%7-1];
		 }
		 
		void printDate(){
			System.out.println(this.toString());
		}


	public String toString(){
		return this.day + "/" + this.month + "/" + this.year;
	}

}
