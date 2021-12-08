package ch15;

import java.awt.*;
import java.awt.event.*;
import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;

// 대화내용을 파일에 저장할 수 있는 채팅 프로그램
public class ChatWin extends Frame {
    String nickname = "";
    TextArea ta = new TextArea();
    Panel p = new Panel();
    TextField tf = new TextField(30);
    Button bSave = new Button("저장");

    // Frame
    ChatWin(String nickname) {
        super("Chatting");
        this.nickname = nickname;

        setBounds(200, 100, 300, 200);

        p.setLayout(new FlowLayout());
        p.add(tf);
        p.add(bSave);

        add(ta, "Center");
        add(p, "South");

        // Frame 이벤트 핸들러
        addWindowListener(new WindowAdapter() {
            @Override
            public void windowClosing(WindowEvent e) {
                System.exit(0);
            }
        });
        
        // Button 이벤트 핸들러
        bSave.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // 저장 Dialog 표시
                FileDialog fileSave = new FileDialog(ChatWin.this, "파일저장", FileDialog.SAVE);
                fileSave.setVisible(true);
                String fileName = fileSave.getDirectory() + fileSave.getFile();
                saveAs(fileName);                   // 지정 디렉토리에 파일 저장
            }
        });

        EventHandler handler = new EventHandler();
        ta.addFocusListener(handler);               // TextArea 이벤트 핸들러 등록
        tf.addFocusListener(handler);
        tf.addActionListener(handler);

        ta.setText("#" + nickname + "님이 입장하셨습니다.");
        ta.setEditable(false);                      // TextArea는 채팅 내용 표시용

        setResizable(false);
        setVisible(true);
        tf.requestFocus();
    }

    // 대화내용 파일 저장
    void saveAs(String fileName) {
        FileWriter fw = null;               // 문자기반 스트림
        BufferedWriter bw = null;           // 문자기반 보조스트림

        try {
            fw = new FileWriter(fileName);  // 파일 경로로 스트림 생성
            bw = new BufferedWriter(fw);
            bw.write(ta.getText());         // 파일 쓰기
        } catch (IOException ie) {
            ie.printStackTrace();
        } finally {
            try{
                if(bw != null)
                    bw.close();
            } catch (IOException e) {}
        }
    }

    public static void main(String[] args) {
        if (args.length != 1) {
            System.out.println("USAGE : java ChatWin NICKNAME");
            System.exit(0);
        }

        new ChatWin(args[0]);       // Frame의 자식 클래스인 ChatWin에 nickname 전달
    }

    class EventHandler extends FocusAdapter implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            String msg = tf.getText();
            if("".equals(msg)) return;

            ta.append("\r\n" + nickname + ">" + msg);   // 닉네임 : 메시지 형태로 TextArea 에 표시
            tf.setText("");                             // TextField 리셋
        }

        public void focusGained(FocusEvent event) {
            tf.requestFocus();
        }
    }
}
