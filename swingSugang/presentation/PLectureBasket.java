package presentation;

import java.awt.Color;
import java.awt.Component;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.Vector;

import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

import control.CLecture;
import valueObject.VIndex;
import valueObject.VLecture;

public class PLectureBasket extends JPanel{
	private Vector<VLecture> vLectureVector;
	private String answer; 
	private CLecture cLecture; // 이 cLecture은 PLectureBasket에서만 사용가능하네.
	private PSelection basket;

	
	
	private class PSelection extends JTable {
		private Vector<VLecture> vLectureVector;
		
		public PSelection(Vector<VLecture> vLectureVector) {
		this.vLectureVector = new Vector<VLecture>();	
			
		String[] title = new String[5];
		title[0] = "강좌코드";
		title[1] = "강좌";
		title[2] = "강의자";
		title[3] = "학점";
		title[4] = "시간";
		DefaultTableModel tableModel = new DefaultTableModel(title,0);
		this.setModel(tableModel);
		
		for(VLecture vLecture: vLectureVector) {
			String[] row = new String[5];
			row[0] = Integer.toString(vLecture.getCode());
			row[1] = vLecture.getName();
			row[2] = vLecture.getLecturer();
			row[3] = Integer.toString(vLecture.getCredit());
			row[4] = vLecture.getDate();
			tableModel.addRow(row);
	}
	}

		public VLecture getVLecture(int x) {
			VLecture vLecture = vLectureVector.get(x);
			return vLecture;
		}
	}
	
	
	
	public PLectureBasket(Vector<VLecture> vLectureVector) {
		this.setBackground(Color.blue);
		
		this.setLayout(new GridBagLayout());
		GridBagConstraints gbc = new GridBagConstraints();
	    gbc.insets = new Insets(5, 5, 5, 5); // gridBag 레이아웃으로 설정을 하면 무조건 GridBagConstraints
	    gbc.weightx = 1.0;
	    gbc.weighty = 1.0;
	    gbc.gridx = 0;
	    gbc.gridy = 0;
	    gbc.fill = GridBagConstraints.BOTH; // 컴포넌트가 활당된 영역안에서 최대로 늘어날 수 있게 한 것. 범위를 GridBagConstraints.BOTH; 로 했는 데 이건 컴포넌트가 활당된 공간 내 최대 크기 라는 의미.
	    vLectureVector = new Vector<VLecture>();
		basket = new PSelection(vLectureVector);
		basket.addMouseListener(new MouseAdapter() {
			
		});
		JScrollPane scrollPane = new JScrollPane(basket);
		this.add(scrollPane,gbc);
	}
	
	public void changeBasket(Vector<VLecture> vLectureVector) {
		changeVector(vLectureVector);
		String[] title = new String[5];
		title[0] = "강좌코드";
		title[1] = "강좌";
		title[2] = "강의자";
		title[3] = "학점";
		title[4] = "시간";
		DefaultTableModel tableModel = new DefaultTableModel(title,0);
		for(VLecture vLecture: vLectureVector) {
			String[] row = new String[5];
			row[0] = Integer.toString(vLecture.getCode());
			row[1] = vLecture.getName();
			row[2] = vLecture.getLecturer();
			row[3] = Integer.toString(vLecture.getCredit());
			row[4] = vLecture.getDate();
			tableModel.addRow(row);
	}
		basket.setModel(tableModel);
		
	}
//	class MyMouseListner extends MouseAdapter {
//		public void mouseClicked(MouseEvent event) {
//				if(event.getClickCount()==1) {
//					VLecture vLecture = basket.getVLecture(basket.getSelectedRow());
//					Object[] options = {"담기", "삭제", "취소"};
//					int choice = JOptionPane.showOptionDialog(
//						    null,
//						    vLecture.getLecturer() + "의 " + vLecture.getName() + "를 수강신청에 담으시겠습니까? 삭제하시겠습니까?",
//						    "미리담기",
//						    JOptionPane.YES_NO_CANCEL_OPTION, // 반환값 종류를 정하는 것.
//						    JOptionPane.QUESTION_MESSAGE, // 이거는 알림 옆에 있는 아이콘.
//						    null, // 이거는 커스텀한 아이콘을 적용할 떄 사용한대.
//						    options,
//						    options[2] // 기본 선택 버튼 인덱스
//						);
//					if(choice == JOptionPane.YES_OPTION) {
//						PSugangsincheng.damgi("수강신청", vLecture);
//					}
//					else if(choice == JOptionPane.NO_OPTION) {
//							PSugangsincheng.delete("미리담기",basket.getSelectedRow());
//					}
//				}
//			}
//		}
//	
//	
	public void changeVector(Vector<VLecture> vLectureVector) {
		basket.vLectureVector = vLectureVector;
	}


	public VLecture getVLecture() {
		VLecture vLecture = basket.getVLecture(basket.getSelectedRow());
		return vLecture;
	}

	public int getSelectedRow() {
		
		return basket.getSelectedRow();
	}

	public Component getTable() {
		
		return basket;
	}
}

