package graphicseditor ;
import java.awt.Font;
import javax.swing.*;
import java.awt.event.*;
import java.awt.print.PrinterException;
import java.io.*;
import javax.swing.event.UndoableEditEvent;
import javax.swing.event.UndoableEditListener;
import javax.swing.filechooser.FileNameExtensionFilter;
import javax.swing.undo.UndoManager;
public  class GraphicsEditor extends JFrame implements ActionListener,Runnable{
    JMenuBar mb1;
    JMenu mFile,mEdit,mView,mInsert;
    JMenuItem mNew, mopen,mSave,mSaveas,mRename,mDownload,mPrint,mExit;
    JMenuItem mUndo,mRedo,mPaste,mSelectall,mCopy,mCut;
    JMenuItem mShowprintLayout,mShowoutline,mShowSectionbreaks;
    JMenuItem mImage,mTable,mChart,mPhoto,mCamera,mDrive,mPie,mLine,mColumn;
    JTextArea textArea= new JTextArea();
    UndoManager manager=new UndoManager();
    Thread t1;
     
      public void run()
      {
          for(;;){//infinity loop
            try{
                  setTitle("GraphicsEditor"+"   "+new java.util.Date().toString());
                  t1.sleep(1000);
               }
              catch(Exception ex){
                  }
                }  
      }
    public GraphicsEditor() {
        t1=new Thread(this);//new not create reffrence thread 
        t1.start();//reffrence create in memory and start thread
        setBounds(100,100,800,600);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        
        ImageIcon icon = new ImageIcon(getClass().getResource("images.png"));
        setIconImage(icon.getImage());
        
        mb1=new JMenuBar();
        
        mFile=new JMenu("File");
        mEdit=new JMenu("Edit");
        mView=new JMenu("View");
        mInsert=new JMenu("Insert");
        mImage=new JMenu("Image");
        mChart=new JMenu("Chart");

        mNew=new JMenuItem("New");
        mopen=new JMenuItem("open");
        mSave=new JMenuItem("Save");
        mSaveas=new JMenuItem("Save as");
        mRename=new JMenuItem("Rename");
        mDownload=new JMenuItem("Download");
        mPrint=new JMenuItem("Print");
        mExit=new JMenuItem("Exit");

        mUndo=new JMenuItem("Undo");
        mRedo=new JMenuItem("Redo");
        mPaste=new JMenuItem("Paste");
        mSelectall=new JMenuItem("Select all");
        mCopy=new JMenuItem("Copy");
        mCut=new JMenuItem("Cut");
        
        mShowprintLayout =new JMenuItem("Show print Layout");
        mShowoutline=new JMenuItem("Show outline");
        mShowSectionbreaks= new JMenuItem("Show Section breaks");
        
        mTable=new JMenuItem("Table");
         
        mPhoto=new JMenuItem("Photo");
        mCamera=new JMenuItem("Camera");
        mDrive=new JMenuItem("Drive");
          
        mPie=new JMenuItem("Pie");
        mLine=new JMenuItem("Line");
        mColumn=new JMenuItem("Column");
        
        mFile.add(mNew);
        mFile.add(mopen);
        mFile.add(mSave);
        mFile.add(mSaveas);
        mFile.add(mRename);
        mFile.add(mDownload);
        mFile.add(mPrint);
        mFile.add(mExit);
      
        mEdit.add(mUndo);
        mEdit.add(mRedo);
        mEdit.add(mPaste);
        mEdit.add(mSelectall);
        mEdit.add(mCopy);
        mEdit.add(mCut);
        
        mView.add(mShowprintLayout);
        mView.add(mShowoutline);
        mView.add(mShowSectionbreaks);
       
        mInsert.add(mImage);
        mInsert.add(mTable);
        mInsert.add(mChart);
       
        mImage.add(mPhoto);
        mImage.add(mCamera);
        mImage.add(mDrive);
       
        mChart.add(mPie);
        mChart.add(mLine);
        mChart.add(mColumn);
       
        setJMenuBar(mb1);
        mb1.add(mFile);
        mb1.add(mEdit);
        mb1.add(mView);
        mb1.add(mInsert);
        
        JScrollPane js=new JScrollPane(textArea);
        add(js);
        js.setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_NEVER);
        js.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED);
        js.setBorder(BorderFactory.createEmptyBorder());
        
        textArea.setFont(new Font(Font.SANS_SERIF,Font.PLAIN,20));
        textArea.setLineWrap(true);
        textArea.setWrapStyleWord(true);
       
        mNew.addActionListener(this);
        mopen.addActionListener(this);
        mSave.addActionListener(this);
        mSaveas.addActionListener(this);
        mRename.addActionListener(this);
        mDownload.addActionListener(this);
        mPrint.addActionListener(this);
        mExit.addActionListener(this);
        
        mUndo.addActionListener(this);
        mRedo.addActionListener(this);
        mPaste.addActionListener(this);
        mSelectall.addActionListener(this);
        mCopy.addActionListener(this);
        mCut.addActionListener(this);
      
        mShowprintLayout.addActionListener(this);
        mShowoutline.addActionListener(this);
        mShowSectionbreaks.addActionListener(this);
      
        mImage.addActionListener(this);
        mTable.addActionListener(this);
        mChart.addActionListener(this);
      
        mPhoto.addActionListener(this);
        mCamera.addActionListener(this);
        mDrive.addActionListener(this);
       
        mPie.addActionListener(this);
        mLine.addActionListener(this);
        mColumn.addActionListener(this);
        
        mNew.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_N,KeyEvent.CTRL_DOWN_MASK));
        mCut.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_X,KeyEvent.CTRL_DOWN_MASK));
        mopen.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_O,KeyEvent.CTRL_DOWN_MASK));
        mCopy.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_C,KeyEvent.CTRL_DOWN_MASK));
        mPaste.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_V,KeyEvent.CTRL_DOWN_MASK));
        mSave.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_S,KeyEvent.CTRL_DOWN_MASK));
        mUndo.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_Z,KeyEvent.CTRL_DOWN_MASK));
        mRedo.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_Y,KeyEvent.CTRL_DOWN_MASK));
        mPrint.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_P,KeyEvent.CTRL_DOWN_MASK));
        mExit.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_F2,KeyEvent.ALT_DOWN_MASK));
        mRename.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_R,KeyEvent.CTRL_DOWN_MASK));
        mDownload.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_J,KeyEvent.CTRL_DOWN_MASK));
        mSelectall.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_A,KeyEvent.CTRL_DOWN_MASK));
      
    textArea.getDocument().addUndoableEditListener(new UndoableEditListener()
        {
            public void undoableEditHappened(UndoableEditEvent e){
                manager.addEdit(e.getEdit());
            }
        });
    }
     public void actionPerformed(ActionEvent e){
         if(e.getActionCommand().equalsIgnoreCase("New")){
            textArea.setText(null);
         }
         
         if(e.getActionCommand().equalsIgnoreCase("Open")){ 
           JFileChooser fileChooser =new JFileChooser();
           FileNameExtensionFilter textFilter=new FileNameExtensionFilter("Only Text Files(.txt)","txt");
           fileChooser.setAcceptAllFileFilterUsed(false);
           fileChooser.addChoosableFileFilter(textFilter);
           
           int action= fileChooser.showOpenDialog(null);
           
           if(action!= JFileChooser.APPROVE_OPTION){
               return;
           }
           else{
               try{
                   BufferedReader reader =new BufferedReader(new FileReader(fileChooser.getSelectedFile()));
                   textArea.read(reader,null);
                  }catch(IOException ex){
                   ex.printStackTrace();
                  }
               }
         }
         
          if(e.getActionCommand().equalsIgnoreCase("Save"))
          {
            JFileChooser fileChooser= new JFileChooser();
            FileNameExtensionFilter textFilter=new FileNameExtensionFilter("Only text File(.txt)","txt");
            fileChooser.setAcceptAllFileFilterUsed(false);
            fileChooser.addChoosableFileFilter(textFilter);
              
            int action =fileChooser.showSaveDialog(null);
            if(action!=JFileChooser.APPROVE_OPTION)
              {
                return;
              }else{
                  String fileName=fileChooser.getSelectedFile().getAbsolutePath().toString();
                  if(!fileName.contains(".txt"))
                      fileName=fileName+".txt";
                  try{
                      BufferedWriter writer=new BufferedWriter(new FileWriter (fileName));
                      textArea.write(writer);
                     }catch(IOException ex){
                      ex.printStackTrace();
                     }
                   }
          }
          
           if(e.getActionCommand().equalsIgnoreCase("Exit")){
              System.exit(0);
             }
           
           if(e.getActionCommand().equalsIgnoreCase("Cut")){
                textArea.cut();
             }
           
           if(e.getActionCommand().equalsIgnoreCase("Copy")){
                textArea.copy();
             }
           
           if(e.getActionCommand().equalsIgnoreCase("Paste")){
                 textArea.paste();
             }
           
           if(e.getActionCommand().equalsIgnoreCase("Select all")){
                  textArea.selectAll();
             }
           
           if(e.getActionCommand().equalsIgnoreCase("Exit")){
               System.exit(0);
             }
           
           if(e.getActionCommand().equalsIgnoreCase("Undo")){
                 manager.undo();
             }
           
           if(e.getActionCommand().equalsIgnoreCase("Redo")){
               manager.redo();
             }
           
           if(e.getActionCommand().equalsIgnoreCase("Print")){
                     try{
                         textArea.print();
                     }catch(PrinterException ex){
          // Logger.getLogger(GraphicsEditor.class.getName()).log(Level.SEVERE,null,ex);
                     }
                }
      }
           public static void main(String args[])throws Exception{
          UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
             new GraphicsEditor().setVisible(true);
         } 
}
