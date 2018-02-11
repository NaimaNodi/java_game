package mygame;

//IMPORT STATEMENTS HAVE BEEN USED FOR USING DIFFERENT CLASSES
import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Rectangle;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Random;
import javax.swing.Timer;
import javax.imageio.ImageIO;
import javax.swing.JFrame;

//TWO INTERFACES HAVE BEEN USED FOR USER INTERFACE ON THE GAME
public class MinionsQuest implements ActionListener, KeyListener {
	public static MinionsQuest minionsquest; /*THE VARIABLE "minionsquest" HAVE BEEN DECLARED "static",
												SO THAT WE CAN CALL IT BEFORE CREATING ANY OTHER OBJECT &
												TO SAVE MEMORY AS FOR EACH "static" USED TAKES ONE COMMON MEMEORY TO ALLOCATE
												*/
	
	public final int WIDTH=1000, HEIGHT=600; //WINDOW THAT WOULD BE A PLATFORM FOR THE GAME IS DECLARED "final" SO THAT IT CANNOT BE CHANGED
	
	public SubMini submini; //VARIABLE FOR THE CLASS "SubMini" TO "repaint" THE CLASS "MinionsQuest"
	
	public Rectangle minion; //TO  ACCESS THE "minion" THAT WILL  TRAVEL
	
	public ArrayList<Rectangle> columns; //"ArrayList" Class HAVE BEEN TAKEN TO STORE THE SEQUENCE OF THE "columns" VARIABLE UNDER IT
	
	public int ticks,yMotion,score; //THESE VARIABLES HAVE BEEN TAKEN TO ACCESS THE MOTION OF "minion" ON THE Y-axis & COUNT THE SCORES RESPECTIVELY
	
	public boolean GameOver,Started; //THESE BOOLEAN VARIABLES CONTROL THE STARTING AND FINISHING
	
	private BufferedImage Im; //"BufferedImage" IS A CLASS THAT CONTROLS THE IMAGES OUT OF THE JAVA TO INSERT IN THE CODE BY "Im" VARIABLE

	public Random rand; //"Random" IS A CLASS THAT HAVE BEEN USED TO CREATE DIFFERENT SIZE's "columns" USNIG "rand" VARIABLE
	
	JFrame jframe; //"JFrame" CLASS HAVE BEEN TAKEN TO USE "JFrame" AS THE USER INTERFACE AND "jframe" IS THE REFERENCE OF IT
	
	public MinionsQuest() //CONSTRUCTOR OF THE MAIN CLASS
	{
		jframe=new JFrame(); //MEMORY HAVE BEEN ALLOCATED FOR "JFrame" USING "new"
		Timer timer=new Timer(1,(ActionListener) this); //"Timer" CLASS HAVE BEEN TAKEN TO SCHEDULE THE TASK & CONTROL THE TIMING TO REPAINT ACCORDING TO ACTION
		
		submini=new SubMini(); //MEMORY HAVE BEEN ALLOCATED FOR "SubMini" USING "new"
		rand=new Random(); //MEMORY HAVE BEEN ALLOCATED FOR "Random" USING "new"
		
		jframe.add(submini); //ADDED "submini" IN "jframe"
		jframe.setTitle("Minion's Quest!"); //ADDED A TITLE OF THE GAME IN "jframe"
		jframe.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); //THIS FUNCTION ENABLES TO CLOSE THE WINDOW WHENEVER WE CLICK TO EXIT
		jframe.setSize(WIDTH, HEIGHT); //SIZE OF THE WINDOW HAVE BEEN SET IN "jframe"
		jframe.addKeyListener(this); //ADDED "KeyListener" IN "jframe"
		jframe.setResizable(false); //"setResizable" HAVE BEEN DECLARED "false" SO THAT THE WINDOW CANNOT BE RESIZED BY THE USER
		jframe.setVisible(true); //"setVisible" HAVE BEEN DECLARED "true" SO THAT USER CAN SEE THE WINDOW
		
		minion=new Rectangle(WIDTH/2-10,HEIGHT/2-10,40,40); //MEMORY HAVE BEEN ALLOCATED FOR "minion" AND IT's SIZE HAVE BEEN CREATED
		columns=new ArrayList<Rectangle>(); //MEMORY HAVE BEEN ALLOCATED FOR "columns" AND ASSIGNED "ArrayList<Rectangle>()" TO IT
		
		addColumn(true); //THIS HAVE BEEN USED TO ADD "columns" "true" IN THE WINDOW
		
		timer.start(); //THIS STARTS THE "timer" TO THE WINDOW
	}
	
	public void addColumn(boolean start) //THIS METHOD HAVE BEEN USED TO ADD "columns" TO THE GAME WINDOW AND IT TAKES THE BOOLEAN VALUE AS PARAMETER
	{
		int space=300; //"space" BETWEEN EACH "columns"
		int width=80; //"width" OF THE "columns"
		int height=50+rand.nextInt(80); //RANDOM "height" OF THE "columns"
		
		//EACH "columns" HAVE BEEN ADDED HORIZONTALLY VARYING "height" OF LESS 1 FROM PREVIOUS ONE
		columns.add(new Rectangle(WIDTH+width+columns.size()*300,HEIGHT - height - 120, width, height)); 
		columns.add(new Rectangle(WIDTH+width+(columns.size()-1)*300,0,width,HEIGHT-height-space));

	}
	
	/*THIS METHOD HAVE BEEN USED TO PAINT THE "columns" USNIG THE "ImageIO", THAT READS THE FILE
	 AND ALLOCATED MEMORY FOR IT AND ADDED DIFFERENT IMAGES TO DIFFERNT "columns".
	 IT WILL THROW "IOException", THAT HAVE BEEN HANDLED USING "try-catch-finally" BLOCK
	 AND ALSO "Graphics" CLASS HAVE BEEN USED TO DRAW THAT IMAGE ON THE WINDOW
	 */
	public void paintColumn(Graphics g, Rectangle column)
	{
		try{
			Im=ImageIO.read(new File("C:\\Users\\User\\Desktop\\MINION\\Pics\\jaVa.png"));
			g.drawImage(Im,column.x,column.y,column.width,column.height,jframe);
			
			Im=ImageIO.read(new File("C:\\Users\\User\\Desktop\\MINION\\Pics\\1.png"));
			g.drawImage(Im,column.x+100,column.y,column.width,column.height,jframe);
			
			try{
				Im=ImageIO.read(new File("C:\\Users\\User\\Desktop\\MINION\\Pics\\4.png"));
				g.drawImage(Im,column.x+200,column.y,column.width,column.height,jframe);
			
				Im=ImageIO.read(new File("C:\\Users\\User\\Desktop\\MINION\\Pics\\5.png"));
				g.drawImage(Im,column.x+300,column.y,column.width,column.height,jframe);
			
				try{
					Im=ImageIO.read(new File("C:\\Users\\User\\Desktop\\MINION\\Pics\\6.png"));
					g.drawImage(Im,column.x+400,column.y,column.width,column.height,jframe);
			
					Im=ImageIO.read(new File("C:\\Users\\User\\Desktop\\MINION\\Pics\\15.png"));
					g.drawImage(Im,column.x+500,column.y,column.width,column.height,jframe);
			
			
					try{
						Im=ImageIO.read(new File("C:\\Users\\User\\Desktop\\MINION\\Pics\\17.png"));
						g.drawImage(Im,column.x+600,column.y,column.width,column.height,jframe);
				
						Im=ImageIO.read(new File("C:\\Users\\User\\Desktop\\MINION\\Pics\\multi.png"));
						g.drawImage(Im,column.x+700,column.y,column.width,column.height,jframe);
				
						}
						finally{}
					}
				finally{}
			}
			finally{}
		}
		
		catch(IOException e){
			e.printStackTrace();
		}
		catch(Exception e){
			
		}
	}

	//THIS METHOD CONTROLS THE JUMP STATEMENT OF "minion"
	public  void jump()
	{
		if(GameOver)
		{
			minion=new Rectangle(WIDTH/2-10,HEIGHT/2-10,40,40);
			columns.clear();
			yMotion=0;
			score=0;
			
			addColumn(true);
			
			GameOver=false;
		}
		
		if(!Started)
		{
			Started=true;
		}
		else if(!GameOver)
		{
			if(yMotion>0)
			{
				yMotion=0;
			}
			yMotion -=10;
		}
	}
	
	//THIS METHOD HAVE BEEN USED FOR PERFORMING ACCORDING TO USER ACTION
	public void actionPerformed(ActionEvent e)
	{
		int speed=15;
		ticks++;
		
		//THIS STATEMENT CONTROLS THE SPEED OF WINDOW ACCORDING TO COLUMN SIZE
		if(Started)
		{
		for(int i=0; i<columns.size();i++)
		{
			Rectangle column=columns.get(i);
			column.x-=speed;
		}
		
		//THIS STATEMENT CONTROLS THE "minion's" MOTION ON THE Y-axis
		if(ticks%2==0 && yMotion<15)
		{
			yMotion+=2;
		}
		
		//THIS STATEMENT CONTROLS THE COLUMN's REPEATATION SO THAT THEY DON'T OVERRIDE 
		for(int i=0; i<columns.size();i++)
		{
			Rectangle column=columns.get(i);
			
			if(column.x + column.width < 0)
			{
				columns.remove(column);
				
				if(column.y==0){
				addColumn(false);
				}
			}
		}
		
		minion.y+=yMotion;
		
		//HERE IF THE "minion" PASSES COLUMNS THEN "score" WILL BE COUNT
		for(Rectangle column : columns)
		{
			if(column.y==0 &&  minion.x+minion.width/2 > column.x + column.width/2-10 && minion.x + minion.width/2 < column.x+column.width/2+10)
			{
				score+=10;
			}
			
			/*THESE STATEMENTS CONTROLS IF THE "minion" "intersects" WITH THE COLUMN,
			 THEN GAME WILL BE OVER
			 */
			
			if(column.intersects(minion))
			{
				GameOver=true;
				
				if(minion.x <= column.x){
				
				minion.x = column.x - minion.width;
				}
				else
				{
					if(column.y != 0)
					{
						minion.y = column.y - minion.height;
					}
					else if(minion.y < column.height)
					{
						minion.y = column.height;
					}
				}
			}
		}
		
		/*THESE TWO IF STATEMENTS CONTROL IF THE "minion" GOES OUT OF THE WINDOW,
		 THEN GAME WILL BE OVER
		 */
		
		if(minion.y>HEIGHT-120 || minion.y<0)
		{
			GameOver=true;
		}
		if(minion.y+yMotion>=HEIGHT-120)
		{
			minion.y=HEIGHT-120-minion.height;
		}
		}
		
		submini.repaint();
	}
	
	/*THIS METHOD HAVE BEEN USED FOR PAINTING THE BASE OF THE GAME, BACKGROUND AND MINION
	  USING ImageIO FILE READER AND USING GRAPHICS's OBJECT "g", SET THE FONT AND COLOR OF THE STRINGS:
	  "Click to start!", "Game Over", "Score" RESPECTIVELY
	 */
	public void repaint(Graphics g) {
		
		//FOR PAINTING THE BACKGROUND
		try{
			Im=ImageIO.read(new File("C:\\Users\\User\\Desktop\\MINION\\Pics\\bleh.jpg"));
			g.drawImage(Im,0, 0, WIDTH, HEIGHT,jframe);
		}
		catch(IOException e)
		{e.printStackTrace();
					
		}
		
		//FOR PAINTING THE LOWER LINE BOARDER
		g.setColor(Color.orange);
		g.fillRect(0, HEIGHT-120, WIDTH, 120);
		
		//FOR PAINTING THE 2nd LOWER LINE BOARDER
		g.setColor(Color.green.darker());
		g.fillRect(0, HEIGHT-120, WIDTH, 20);
		
		//FOR PAINTING THE MINION
		try{
			Im=ImageIO.read(new File("C:\\Users\\User\\Desktop\\MINION\\Pics\\min2.jpg"));
			g.drawImage(Im,minion.x,minion.y,minion.width,minion.height,jframe);
		}
		catch(IOException e)
		{e.printStackTrace();
					
		}
		
		//CALL OF THE METHOD "paintColumn"
		for(Rectangle column : columns)
		{
			paintColumn(g,column);
		}

		/*SETS THE FONT AND COLORS OF THE STRINGS AND PRINTS THIS UNDER THE REQUIRED CONDITIONS
		 */
		g.setColor(Color.white);
		g.setFont(new Font("Arial",1,100) );
		
		if(!Started)
		{
			g.drawString("Click to start!", 75, HEIGHT/2-50);
		}
		
		if(GameOver)
		{
			g.drawString("Game Over!", 100, HEIGHT/2-50);
			columns.clear();
		}
	
		if(!GameOver && Started)
		{
			g.setColor(Color.RED);
			g.setFont(new Font("Arial",1,50));
			g.drawString(String.valueOf("Score: "+score),20,60);
		}
	}

	//CALL OF THE CONTRUCTOR
	public static void NewScreen()
	{
		minionsquest=new MinionsQuest();
	}

	/*THIS METHOD UNDER "KeyListener" CONTROLS THE JUMP OF THE MINION BY CALLING THE METHOD "jump()",
	EACH TIME USERS PRESS THE SPACE KEY
	*/
	public void keyReleased(KeyEvent e) {
		if(e.getKeyCode()==KeyEvent.VK_SPACE)
		{
			jump();
		}
		
	}

	public void keyTyped(KeyEvent e) {
		
	}

	public void keyPressed(KeyEvent e) {
		
	}
	
}
