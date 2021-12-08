package ch15;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.io.*;
import java.util.ArrayList;
import java.util.StringTokenizer;

// 파일로부터 한 줄씩 데이터를 읽어서 보여주는 프로그램
public class WordStudy extends Frame {
    Button first = new Button("<<");
    Button prev = new Button("<");
    Button next = new Button(">");
    Button last = new Button(">>");
    Panel buttons = new Panel();
    TextArea ta = new TextArea();
    ArrayList<String> wordList = new ArrayList<>();

    final String WORD_FILE = "word_data.txt";
    final String CR_LF = System.getProperty("line.separator");

    int pos = 0;

    WordStudy(String title) {
        super(title);

        // 컨트롤 추가
        buttons.add(first);
        buttons.add(prev);
        buttons.add(next);
        buttons.add(last);
        add("South", buttons);
        add("Center", ta);

        // 이벤트 핸들러 등록
        EventHandler handler = new EventHandler();
        addWindowListener(handler);         // windowClosing()
        first.addActionListener(handler);   // actionPerformed()
        prev.addActionListener(handler);
        next.addActionListener(handler);
        last.addActionListener(handler);

        // 단어장 텍스트 파일 로드
        loadFile(WORD_FILE);

        setBackground(Color.black);
        setSize(300, 200);
        setLocation(200, 200);
        setResizable(true);
        setVisible(true);

        showFirst();        // 첫 페이지부터
    }

    void showFirst() {
        pos = 0;
        display(pos);
    }

    void showPrevious() {
        pos = (pos > 0) ? --pos : 0;
        display(pos);
    }

    void showNext() {
        int size = wordList.size();
        pos = (pos < size - 1) ? ++pos : size - 1;
        display(pos);
    }

    void showLast() {
        pos = wordList.size() - 1;
        display(pos);
    }

    // pos 위치에 있는 라인의 내용을 표시
    void display(int pos) {
        String data = wordList.get(pos);
        StringTokenizer st = new StringTokenizer(data, "|");
        StringBuffer sb = new StringBuffer();

        while (st.hasMoreTokens()) {
            sb.append(st.nextToken() + CR_LF);
        }

        ta.setText(sb.toString());
    }

    // 단어장 텍스트 파일 로드
    void loadFile(String fileName) {
        try {
            // 인코딩 설정
            InputStreamReader isr = new InputStreamReader(new FileInputStream(fileName), "utf-8");
            BufferedReader br = new BufferedReader(isr);

            String data = "";

            while ((data = br.readLine()) != null) {
                wordList.add(data);
            }
            br.close();
        } catch (IOException e) {
            System.exit(0);
        }
    }

    public static void main(String[] args) {
        WordStudy mainWin = new WordStudy("Word Study");    // Frame 표시
    }

    class EventHandler extends WindowAdapter implements ActionListener {
        // 클릭한 버튼에 따라 동작 수행
        @Override
        public void actionPerformed(ActionEvent ae) {
            Button b = (Button)ae.getSource();

            if (b == first) {
                showFirst();
            } else if (b == prev) {
                showPrevious();
            } else if(b == next){
                showNext();
            } else if (b == last) {
                showLast();
            }
        }

        // 창 닫으면 프로그램 종료
        public void windowClosing(WindowEvent event) {
            System.exit(0);
        }
    }
}
