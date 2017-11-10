package Presentacion;
import java.util.*;
import java.io.*;
import javax.swing.*;
import java.awt.*;
import java.awt.Event.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
public class EnLineaGUI extends JFrame  {
	int widthM ;
	int heightM;
	JMenu nuevo;
	JMenu abrir ;
	JMenuItem abrirComo;
	JMenuItem salvar;
	JMenu refrescar;
	JButton fresh;
	JMenu salvarComo;
	JMenuItem salir;
	Container contenedor;
	JButton boton;
	JButton tablero[][]= new JButton[10][10]; 
	JRadioButton Basico;
	JRadioButton Avanzado;
	JMenu bG;
	JTextField NLineas;
	JLabel textoN;
	int turno=0;
	Color primario = new Color(46,134,193);
	Color secundario = new Color(46,204,113);
	JButton Aceptar;
	int NLinea=4;
	private EnLineaGUI(){
		Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
		widthM = (int)screenSize.getWidth();
		heightM = (int)screenSize.getHeight();
	}
	
	public static  void main(String[] args){
		EnLineaGUI EnLineaGUI = new EnLineaGUI();
		EnLineaGUI.prepararElementos();
		EnLineaGUI.prepararAcciones();
		EnLineaGUI.refrescar();
		EnLineaGUI.setVisible(true);
		
		

		
	}
	
	public void prepararElementos(){
		this.setTitle("EnLinea");
		this.setSize(this.widthM/2,this.heightM/2 );
		centre();
		prepareElementosMenu();
		prepararElementosTablero();

	}
	public void prepararElementosTablero(){
		contenedor= this.getContentPane();
		contenedor.setLayout(new GridLayout(10,10,5,5));
		Color azulC = new Color(41,128,185);
		for(int i=0;i<10;i++){
			for(int j=0;j<10;j++){
	
				tablero[i][j]=new JButton();
				tablero[i][j].setBackground(new Color(254,254,254));
				contenedor.add(tablero[i][j]);
			
			
			}
		}

	}
	
	
	private void prepararAcciones() {
       setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
       Basico.addActionListener(new ActionListener(){
		
    	   public void actionPerformed(ActionEvent arg0) {
    		   
			
    	   }
    	   
    	   
    	   
    	   
    	   
    	   
       });
       Avanzado.addActionListener(new ActionListener(){

	
		public void actionPerformed(ActionEvent e) {
		
			elecionC();
		}
    	   
    	   
    	   
    	   
    	   
    	   
       });
       for(int i=0;i<10;i++){
    	   for(int j=0;j<10;j++){
    	   tablero[i][j].addActionListener(new ActionListener(){

		
			public void actionPerformed(ActionEvent ev) {
				for(int i=0;i<10;i++){
					for(int j=0;j<10;j++){
						if(tablero[i][j]==ev.getSource()){
							int coordenada = buscarfilaGame(j);
							elegirColor(tablero[coordenada][j]);
							
						
						
						}
					
					}
				}
			}
    		   
    		   
    		   
    		   
    	   });
    	   
    	   
    	   }
       }
       
   		Aceptar.addActionListener(new ActionListener(){

		
			public void actionPerformed(ActionEvent arg0) {
				NLinea = Integer.parseInt(NLineas.getText());
				
			}
   			
   			
   			
   			
   			
   			
   			
   		});
        salir.addActionListener(new ActionListener(){
        	public void actionPerformed(ActionEvent e){
        		salgaB();
        		
        		
        	}
 
        	
        });
        salvar.addActionListener(new ActionListener(){
        	public void actionPerformed(ActionEvent e){
        		guardar();
        		
        		
        		
        	}

        });
        abrirComo.addActionListener(new ActionListener(){

			
			public void actionPerformed(ActionEvent e) {
				abrirArchivo();
				
			}

        	
        });
        addWindowListener(new WindowAdapter() {
            
            public void windowClosing(WindowEvent evt) {
                salga();
            }
        });
        
       
    }
	 
	private int  buscarfilaGame(int j){
		Color blanco = new Color(254,254,254);
		for(int i=0;i<10;i++){
			if(!tablero[i][j].getBackground().equals(blanco)){
				return i-1;
				
				
				
				
			}
			
			
			
		}
		return 9;
		
		
		
	}
    private void salga(){
        if (JOptionPane.showConfirmDialog(rootPane, "¿Desea realmente salir del sistema?",
                "Salir del sistema", JOptionPane.YES_NO_OPTION) == JOptionPane.YES_OPTION)
        	setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    } 
    
    private void salgaB(){
        if (JOptionPane.showConfirmDialog(rootPane, "¿Desea realmente salir del sistema?",
                "Salir del sistema", JOptionPane.YES_NO_OPTION) == JOptionPane.YES_OPTION)
        	System.exit(0);
    }
    private void elecionC(){
    	JOptionPane.showMessageDialog(null,"Elige color Usuario 1");
    	Color color=JColorChooser.showDialog(this,"Select a color",new Color(0,0,0));
    	primario = color;
    	JOptionPane.showMessageDialog(null,"Elige color Usuario 2");
    	Color color2=JColorChooser.showDialog(this,"Select a color",new Color(0,0,0));
    	secundario = color2;
    	
    	
    }
    private void elegirColor(JButton boton){    
    	
    	if(turno==0){
    	boton.setBackground(primario);
    	turno=1;
    	}
    	else {
    		boton.setBackground(secundario);
    		turno =0;
    	}
    	contadorP();
    	contadorS();
    	this.setVisible(true);
    	
    	
    	
    }
    
    private void abrirArchivo(){
    	 JFileChooser Chooser = new JFileChooser();
    	 TextField textField = new TextField();
         Chooser.setMultiSelectionEnabled(true);
         Chooser.setFileSelectionMode(JFileChooser.FILES_ONLY);
         int result = Chooser.showDialog(this,"Open/Save");
         if(result == JFileChooser.APPROVE_OPTION)
         {
             File file = Chooser.getSelectedFile();
            
			textField.setText(file.getAbsolutePath());
          }

  
    }
    
    private void refrescar(){
    	fresh.addActionListener(new ActionListener(){

	
			public void actionPerformed(ActionEvent arg0) {
				Color blancoC = new Color(254,254,254);
		    	for(int i=0;i<10;i++){
		    		for(int j=0;j<10;j++){
		    			tablero[i][j].setBackground(blancoC);
		    		
		    		}
		    	}
		    	
				
			}

		
    		
    		
    		
    		
    	});
    	this.setVisible(true);
    	
    	
    	
    	
    }
    
    private void contadorP(){
    	for(int i=0;i<10;i++){
    		for(int j=0;j<10;j++){
    			if(tablero[i][j].getBackground().equals(primario)){
    				if(Horizontal(i,j,primario)==NLinea || Vertical(i,j,primario)==NLinea || DiagonalD(i,j,primario)==NLinea || DiagonalI(i,j,primario)==NLinea){
    					JOptionPane.showMessageDialog(null, "El Jugador 1 ha ganado Felicitaciones!!!");
    					refrescar();
    					break;
    					
    					
    				}
    				
    				
    			}
    			
    			
    		}
    		
    		
    	}
    	
    	
    
    }
    private void contadorS(){
    	for(int i=0;i<10;i++){
    		for(int j=0;j<10;j++){
    			if(tablero[i][j].getBackground().equals(secundario)){
    				if(Horizontal(i,j,secundario)==NLinea || Vertical(i,j,secundario)==NLinea || DiagonalD(i,j,secundario)==NLinea || DiagonalI(i,j,secundario)==NLinea){
    					JOptionPane.showMessageDialog(null, "El Jugador 2 ha ganado Felicitaciones!!!");
    					refrescar();
    					break;
    					
    					
    				}
    				
    				
    			}
    			
    			
    		}
    		
    		
    	}
    	
    	
    	
    	
    	
    	
    	
    }
    
    
    
    
    
    
    private int Horizontal(int i,int j,Color type){
    	int conta=0;
    	for(int h=j;h<10;h++){
    		if(tablero[i][h].getBackground().equals(type))conta++;
    		else break;
    		
    	}
    	for(int h=j;h>=0;h--){
    		if(tablero[i][h].getBackground().equals(type))conta++;
    		else break;
    		
    	}
    	return conta-1;
    	
    	
    	
    }
    private int Vertical(int i,int j,Color type){
    	int conta=0;
    	for(int h=i;h<10;h++){
    		if(tablero[h][j].getBackground().equals(type))conta++;
    		else break;
    		
    	}
    	for(int h=j;h>=0;h--){
    		if(tablero[h][j].getBackground().equals(type))conta++;
    		else break;
    		
    	}
    	return conta;
    	
    	
    	
    }
    private int DiagonalD(int i,int j,Color type){
    	int conta=0;
    	int h=i;
    	int k=j;
    	for(;;){
    	
    		if(h>=10 || k<=0)break;
    		else if(tablero[h++][k--].getBackground().equals(type))conta++;
        	else break;
    			
    			
    	}
    	h=i;
    	k=j;	
    		
    	for(;;){
        	
    		if(h<=0 || k>=10)break;
    		else if(tablero[h--][k++].getBackground().equals(type))conta++;
        	else break;
    			
    			
    	}
    	
    		
    	
    	return conta-1;
    	
    	
    	
    	
    }
    
    
    
    private int DiagonalI(int i,int j,Color type){
    	int conta=0;
    	int h=i;
    	int k=j;
    	for(;;){
    	
    		if(h>=10 || k>=10)break;
    		else if(tablero[h++][k++].getBackground().equals(type))conta++;
        	else break;
    			
    			
    	}
    	h=i;
    	k=j;
    		
    	for(;;){
        	
    		if(h<=0 || k<=0)break;
    		else if(tablero[h--][k--].getBackground().equals(type))conta++;
        	else break;
    			
    			
    	}
    	
    		
    	
    	return conta-1;
    	

    	
    	
    	
    	
    	
    	
    	
    	
    }
    private void guardar(){
    	String filename = JOptionPane.showInputDialog("Name this file");
    	JFileChooser saveFile = new JFileChooser(); 
    	saveFile.setSelectedFile(new File(filename));
    	
    	BufferedWriter writer;
        int sf = saveFile.showSaveDialog(null);
        if(sf == JFileChooser.APPROVE_OPTION){
            try {
                writer = writer = new BufferedWriter(new FileWriter(saveFile.getSelectedFile()));
                
                writer.close();
                JOptionPane.showMessageDialog(null, "File has been saved","File Saved",JOptionPane.INFORMATION_MESSAGE);
               

            } catch (IOException e) {
                e.printStackTrace();
            }
        }else if(sf == JFileChooser.CANCEL_OPTION){
            JOptionPane.showMessageDialog(null, "File save has been canceled");
        }
    	
    }

	private void prepareElementosMenu(){
		JMenuBar barraMenu = new JMenuBar();
		this.setJMenuBar(barraMenu);
		nuevo = new JMenu("Nuevo");
		barraMenu.add(nuevo);
		abrir = new JMenu("Abrir");
		salvar = new JMenuItem("Salvar");
		abrirComo = new JMenuItem("Abrir");
		
		abrir.add(salvar);
		abrir.add(abrirComo);
		barraMenu.add(abrir);
		salvarComo = new JMenu("Salvar Como");
		salir = new JMenuItem("Salir");
		salvarComo.add(salir);
		barraMenu.add(salvarComo);
		
		fresh = new JButton("Oprime aqui para refrescar la pagina!!");
		fresh.setBackground(new Color(52,73,94));
		fresh.setForeground(new Color(254,254,254));
		
		barraMenu.add(fresh);
		Basico = new JRadioButton("Dos colores");
	    Avanzado = new JRadioButton("Multicolor");

	    barraMenu.add(Basico);
	    barraMenu.add(Avanzado);
		NLineas = new JTextField("4");
		textoN = new JLabel("   Digita el numero de lineas con la cual deseas Jugar: ");
		textoN.setForeground(new Color(52,73,94));
		barraMenu.add(textoN);
		barraMenu.add(NLineas);
		Aceptar = new JButton("Aceptar");
		Aceptar.setBackground(new Color(52,73,94));
		Aceptar.setForeground(new Color(254,254,254));
		barraMenu.add(Aceptar);
		
		
		
		
	}
	
	public void centre(){
		
		this.setLocation((int)(((widthM)-this.getSize().getWidth())/2),(int) (((heightM)-this.getSize().getHeight()))/2);
		
		
	}
	
}
