package presentation;

import java.awt.Color;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.Vector;


import javax.swing.JButton;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.table.DefaultTableModel;


import valueObject.VLecture;

public class PSugangsincheng extends JPanel {
	

	private PLectureSelection pLectureSelection;
	private static PLectureBasket pMiridamgiBasket;
	private static PLectureBasket pSinchengBasket;
	private JButton Selection1;
	private static Vector<VLecture> vLectureVector1;
	private static Vector<VLecture> vLectureVector2;
	
	
	public PSugangsincheng() {
		this.setBackground(Color.white);
		
		
		this.setLayout(new GridBagLayout()); //레이아웃 매니저를 만들어서 붙여야 한다.
		GridBagConstraints gbc = new GridBagConstraints();
		gbc.insets = new Insets(5, 5, 5, 5);
		gbc.weightx = 1.0;
	    gbc.weighty = 1.0;
	    gbc.gridx = 0;
	    gbc.gridy = 0;
	    gbc.fill = GridBagConstraints.BOTH; 
		
		this.pLectureSelection = new PLectureSelection();
		this.add(pLectureSelection,gbc);
		vLectureVector1 = new Vector<VLecture>();
		vLectureVector2 = new Vector<VLecture>();
		gbc.gridx = 1;
		pMiridamgiBasket = new PLectureBasket(vLectureVector1);
		pMiridamgiBasket.getTable().addMouseListener(new MouseAdapter() { // 킵 포인트, 내가 그토록 바랬던 것. pMiridamgi에 있는 테이블에다가 이벤트르 붙이고 싶었는 데 못붙였잖아. 거기 안에
			//함수를 만드는 거야. 테이블을 반환하는 그러면 거기에다가 이벤트를 붙일 수가 있네!
			public void mouseClicked(MouseEvent event) {
				if(event.getClickCount()==1) {
					VLecture vLecture = pMiridamgiBasket.getVLecture();
					Object[] options = {"담기", "삭제", "취소"};
					int choice = JOptionPane.showOptionDialog(
						    null,
						    vLecture.getLecturer() + "의 " + vLecture.getName() + "를 수강신청에 담으시겠습니까? 삭제하시겠습니까?",
						    "미리담기",
						    JOptionPane.YES_NO_CANCEL_OPTION, // 반환값 종류를 정하는 것.
						    JOptionPane.QUESTION_MESSAGE, // 이거는 알림 옆에 있는 아이콘.
						    null, // 이거는 커스텀한 아이콘을 적용할 떄 사용한대.
						    options,
						    options[2] // 기본 선택 버튼 인덱스
						);
					if(choice == JOptionPane.YES_OPTION) {
						PSugangsincheng.delete("미리담기",pMiridamgiBasket.getSelectedRow());
						PSugangsincheng.damgi2("수강신청", vLecture);
						pMiridamgiBasket.changeVector(vLectureVector1);
						pSinchengBasket.changeVector(vLectureVector2);
					}
					else if(choice == JOptionPane.NO_OPTION) {
							PSugangsincheng.delete("미리담기",pMiridamgiBasket.getSelectedRow());
							pMiridamgiBasket.changeVector(vLectureVector1);
							pSinchengBasket.changeVector(vLectureVector2);
					}
				}
			}
		});
		this.add(pMiridamgiBasket,gbc);
		gbc.gridx = 2;
		pSinchengBasket = new PLectureBasket(vLectureVector2);
		pSinchengBasket.getTable().addMouseListener(new MouseAdapter() { // 킵 포인트, 내가 그토록 바랬던 것. pMiridamgi에 있는 테이블에다가 이벤트르 붙이고 싶었는 데 못붙였잖아. 거기 안에
			//함수를 만드는 거야. 테이블을 반환하는 그러면 거기에다가 이벤트를 붙일 수가 있네!
			public void mouseClicked(MouseEvent event) {
				if(event.getClickCount()==1) {
					VLecture vLecture = pSinchengBasket.getVLecture();
					Object[] options = {"미리담기로 빼기", "삭제", "취소"};
					int choice = JOptionPane.showOptionDialog(
						    null,
						    vLecture.getLecturer() + "의 " + vLecture.getName() + "를 미리담기에 담으시겠습니까? 삭제하시겠습니까?",
						    "수강신청",
						    JOptionPane.YES_NO_CANCEL_OPTION, // 반환값 종류를 정하는 것.
						    JOptionPane.QUESTION_MESSAGE, // 이거는 알림 옆에 있는 아이콘.
						    null, // 이거는 커스텀한 아이콘을 적용할 떄 사용한대.
						    options,
						    options[2] // 기본 선택 버튼 인덱스
						);
					if(choice == JOptionPane.YES_OPTION) {
						PSugangsincheng.delete("수강신청",pSinchengBasket.getSelectedRow());
						PSugangsincheng.damgi2("미리담기", vLecture);
						pMiridamgiBasket.changeVector(vLectureVector1);
						pSinchengBasket.changeVector(vLectureVector2);
						
					}
					else if(choice == JOptionPane.NO_OPTION) {
							PSugangsincheng.delete("수강신청",pSinchengBasket.getSelectedRow());
							pMiridamgiBasket.changeVector(vLectureVector1);
							pSinchengBasket.changeVector(vLectureVector2);
					}
				}
			}
		});
		
		pSinchengBasket.setBackground(Color.red); // static으로 변수를 선언하면 공통적으로 사용되서 this를 안해도 되는 건가?
		this.add(pSinchengBasket,gbc);
		
	}
	
	public static void damgi(String string, VLecture vLecture){
		// 여기 있는 null은 다 해당 알림창이 속할 부모 컴포넌트를 정하는 거래. 그 부모 컴포넌트의 중앙에 등장하나봐.
		
        // 질문 메시지를 포함한 알림창 표시
        int choice = JOptionPane.showConfirmDialog(null, vLecture.getLecturer()+"의 "+vLecture.getName()+"를 담으시겠습니까?", string, JOptionPane.YES_NO_OPTION);
        if (choice == JOptionPane.YES_OPTION) {
        	vLectureVector1.add(vLecture);
        	pMiridamgiBasket.changeBasket(vLectureVector1);
        	JOptionPane.showMessageDialog(null, string+"에 담겼습니다.");
        }
        // 입력 필드를 포함한 알림창 표시
	}
	
	public static void damgi2(String string, VLecture vLecture){
		if(string.equals("미리담기")) {
        	vLectureVector1.add(vLecture);
        	pMiridamgiBasket.changeBasket(vLectureVector1);
        	
        	
        } else {
        	vLectureVector2.add(vLecture);
        	pSinchengBasket.changeBasket(vLectureVector2);
        	
        }
	}
	
	private static void changeBasket(String basket,Vector<VLecture> vLectureVector) {
		if(basket.equals("미리담기")) {
			pMiridamgiBasket.changeBasket(vLectureVector);
		}
		else if(basket.equals("수강신청")) {
			pSinchengBasket.changeBasket(vLectureVector);
		}
	}
	public static void delete(String string, int selectedRow) {
		if(string.equals("미리담기")) {
			
			vLectureVector1.remove(selectedRow);
			changeBasket(string,vLectureVector1);
	
		
		}
		else {
			
			vLectureVector2.remove(selectedRow);
			changeBasket(string,vLectureVector2);
			
		}
	}
	
	
	
}

