package ch15;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.*;

public class Exercise15_9 extends Frame {
    String fileName;
    TextArea content;
    MenuBar mb;
    Menu mFile;
    MenuItem miNew, miOpen, miSaveAs, miExit;

    Exercise15_9(String title) {
        super(title);
        content = new TextArea();
        add(content);

        // MenuBar > Menu > MenuItem
        mb = new MenuBar();
        mFile = new Menu("File");

        miNew = new MenuItem("New");
        miOpen = new MenuItem("Open");
        miSaveAs = new MenuItem("Save As...");
        miExit = new MenuItem("Exit");

        mFile.add(miNew);       // Menu에 MenuItem 추가
        mFile.add(miOpen);
        mFile.add(miSaveAs);
        mFile.addSeparator();   // 메뉴 분리선
        mFile.add(miExit);

        mb.add(mFile);          // MenuBar에 Menu 추가
        setMenuBar(mb);         // Frame에 MenuBar 포함
        
        // 이벤트 핸들러 등록
        MyHandler handler = new MyHandler();
        miNew.addActionListener(handler);
        miOpen.addActionListener(handler);
        miSaveAs.addActionListener(handler);
        miExit.addActionListener(handler);

        setSize(300, 200);
        setVisible(true);
    }

    // 선택한 파일의 내용을 읽어서 TextArea에 표시
    void fileOpen(String fileName) {
        InputStreamReader isr = null;
        BufferedReader br = null;
        StringWriter sw = null;

        try {
            isr = new InputStreamReader(new FileInputStream(fileName), "utf-8");
            br = new BufferedReader(isr);
            sw = new StringWriter();

            String line = "";

            while ((line = br.readLine()) != null) {
                sw.write(line);
                sw.write('\n');
            }

            content.setText(sw.toString());
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try{
                if (br != null)
                    br.close();
            }catch(IOException e) { }
        }
    }

    // TextArea의 내용을 지정된 파일에 저장
    void saveAs(String fileName) {
        OutputStreamWriter osw = null;
        BufferedWriter bw = null;
        try {
            osw = new OutputStreamWriter(new FileOutputStream(fileName), "utf-8");
            bw = new BufferedWriter(osw);

            bw.write(content.getText());
        } catch (IOException e) {
            e.printStackTrace();
        }finally {
            try{
                if(bw != null)
                    bw.close();
            }catch(IOException e) {}
        }
    }
    
    public static void main(String[] args) {
        Exercise15_9 mainWin = new Exercise15_9("Text Editor");
    }

    // MenuItem 별 처리 동작
    class MyHandler implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            String command = e.getActionCommand();

            if (command.equals("New")) {
                content.setText("");                    // 메모장 초기화
            } else if (command.equals("Open")) {
                FileDialog fileOpen = new FileDialog(Exercise15_9.this, "파일열기");

                fileOpen.setVisible(true);
                fileName = fileOpen.getDirectory() + fileOpen.getFile();
                System.out.println(fileName);
                fileOpen(fileName);
            } else if (command.equals("Save As...")) {
                FileDialog fileSave = new FileDialog(Exercise15_9.this, "파일저장", FileDialog.SAVE);
                fileSave.setVisible(true);
                fileName = fileSave.getDirectory() + fileSave.getFile();
                System.out.println(fileName);

                saveAs(fileName);
            } else if (command.equals("Exit")) {
                System.exit(0);
            }
        }
    }
}
