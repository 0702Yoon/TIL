package presentation;

import java.awt.Color;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.Vector;

import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

import control.CIndex;
import control.CLecture;
import valueObject.VIndex;
import valueObject.VLecture;

public class PLectureSelection extends JPanel{
	
	private CLecture cLecture;
	private PSelection pCampus;
	private PSelection pCollege;
	private PSelection pDepartment;
	private PSelection pSubject;
	private CIndex cIndex;
	private Vector<VIndex> vIndexVector;
	private Vector<VLecture> vLectureVector;

	
	private class PSelection extends JTable {  // 상속받아서 쓰라구 버튼은 그냥 써도 괜찮다. 테이블은 복잡하니까 상속 받아서 끄라구)
		// 이렇게 생긴애를 그리드, 테이블이라고 말한다. 갔다 써야겠네..
		private CIndex cIndex;
		private CLecture cLecture;
		private Vector<VIndex> vIndexVector;
		private Vector<VLecture> vLectureVector; 
		
		public PSelection(String titleName,String fileName) {
			if(!titleName.equals("강좌")) {
			String[] title = new String[1];
			 //테이블이 하나면 list라고 한다. 일부로 테이블을 쓰는 이유는 4개의 테이블이 나오니까 하나갖고 다  쓸려고. 
			title[0]= titleName;
			DefaultTableModel tableModel = new DefaultTableModel(title,0);
			// 이 부분이 모델이네. 이 부분을 이렇게 하지 말고 테이블 모델이란 것을 쓰는 것도 방법이다.
			this.setModel(tableModel);
			this.cIndex = new CIndex();
			
			vIndexVector = cIndex.getVIndexvector(fileName);
			
			for(VIndex vIndex: vIndexVector) {
				String[] row = new String[1];
				row[0] = vIndex.getName();
				tableModel.addRow(row);
			}
			}
			
			else {
				String[] title = new String[5];
				title[0] = "강좌코드";
				title[1] = "강좌";
				title[2] = "강의자";
				title[3] = "학점";
				title[4] = "시간";
				DefaultTableModel tableModel = new DefaultTableModel(title,0);
				this.setModel(tableModel);
				this.cLecture = new CLecture();
				vLectureVector = cLecture.getVLectureVector(fileName);
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
			
			//여기 값은 엔터티(파일)에서 가져오는 걸 만들어오자.
			// 앞에가 x row고 뒤에가 column에 따른 값이네.
		}
		public VIndex getVIndex(int x) {
			VIndex vIndex =vIndexVector.get(x);
			return vIndex;
		}
		public VLecture getVLecture(int x) {
			VLecture vLecture = vLectureVector.get(x);
			return vLecture;
		}
	}
		
	
	public PLectureSelection() {
		this.setLayout(new GridBagLayout());
		GridBagConstraints gbc = new GridBagConstraints();
	    gbc.insets = new Insets(5, 5, 5, 5); // 위 왼 아 오 반시계 방향으로 여백을 나타내는 것.
		
		pCampus = new PSelection("캠퍼스","root");
		pCampus.addMouseListener(new MouseAdapter() {
		    public void mouseClicked(MouseEvent event) {
		        if (event.getClickCount() == 1) { // 단일 클릭 이벤트인 경우
		        	VIndex vIndex = pCampus.getVIndex((pCampus.getSelectedRow()));// 첫 번째 인자는 행 두 번째 인자는 열		
		        	changeVector("pCollege",vIndex.getFileName());
		            selectCollege("대학",vIndex.getFileName());
		        }
		    }


		});
		gbc.gridx = 0;
		gbc.gridy = 0;
		gbc.weightx = 1.0; // 컴포넌트가 차지하는 가로 공간 비율
	    gbc.weighty = 1.0; // 컴포넌트가 차지하는 세로 공간 비율
	    gbc.fill = GridBagConstraints.BOTH; // 컴포넌트가 가로 및 세로로 확장되도록 설정
		JScrollPane scrollPane = new JScrollPane(pCampus);
		this.add(scrollPane,gbc);
		//스크롤패인이 패널의 자식이고 테이블은 스크콜 패인의 자식이 되는 거다. 
		
		pCollege = new PSelection("대학","yongin");
		pCollege.addMouseListener(new MouseAdapter() {
		    public void mouseClicked(MouseEvent event) {
		        if (event.getClickCount() == 1) { // 단일 클릭 이벤트인 경우
		        	 VIndex vIndex = pCollege.getVIndex((pCollege.getSelectedRow()));// 첫 번째 인자는 행 두 번째 인자는 열	
		        	 cIndex = new CIndex();
		        	 pDepartment.vIndexVector = cIndex.getVIndexvector(vIndex.getFileName());
		        	// 이렇게 해도 되는 게 그 인스턴스의 클래스에 있는 변수값을 이렇게 호출할 수가 있다는 것이네.
		            selectCollege("학과",vIndex.getFileName());
		           
		        }
		    }

		});
		 scrollPane = new JScrollPane(pCollege);
		 gbc.gridx = 1;
		 gbc.gridy = 0;
		this.add(scrollPane,gbc);
		
		pDepartment = new PSelection("학과","generalY");
		pDepartment.addMouseListener(new MouseAdapter() {
		    public void mouseClicked(MouseEvent event) {
		        if (event.getClickCount() == 1) { // 단일 클릭 이벤트인 경우
		        	VIndex vIndex = pDepartment.getVIndex(pDepartment.getSelectedRow());// 첫 번째 인자는 행 두 번째 인자는 열		     
		        	changeVector("pSubject",vIndex.getFileName());
		        	selectSubject(vIndex.getFileName());
		        	
		        }
		    }

		});
		 scrollPane = new JScrollPane(pDepartment);
		gbc.gridx = 2;
		gbc.gridy = 0;
		this.add(scrollPane,gbc);
		 // 위에는 3개가 동일하게 반복되잖아. 클래스에 집어넣어서 new를 3번하는 게 좋겠지. 
		this.setBackground(Color.green);
		// 
			pSubject = new PSelection("강좌","englishYG");
			pSubject.addMouseListener(new MouseAdapter() {
			    public void mouseClicked(MouseEvent event) {
			        if (event.getClickCount() == 1) { // 단일 클릭 이벤트인 경우
			        	VLecture vLecture = pSubject.getVLecture(pSubject.getSelectedRow());
			        	PSugangsincheng.damgi("미리담기", vLecture); // 포인트는 영향을 주기 위해서 최 상위 클래스에다가 함수 로직을 적고 그것을 이벤트 발생하는 곳에서 호출하면 된다.
			        }
			    }
			});
			
			scrollPane = new JScrollPane(pSubject);
			
			gbc.gridx = 0;
			gbc.gridy = 1;
			gbc.gridwidth =3;// weightx는 컴포넌트의 비율을 조절하는 것. 그래서 gridx나 gridy가 같은 컴포넌트는 같은 weightx나 weighty를 갖는다. 하나의 컴포넌트를 늘릴떈 gridwidth나 gridhight를 써야함 ㅅㅂ.
			this.add(scrollPane,gbc);
		 
	}

	private void selectCollege(String column,String fileName) {
		
		String[] title = new String[1];
		title[0]=column;
		DefaultTableModel tableModel = new DefaultTableModel(title,0);
		
		this.cIndex = new CIndex();
		vIndexVector = cIndex.getVIndexvector(fileName);
		
		for(VIndex vIndex: vIndexVector) {
			String[] row = new String[1];
			row[0] = vIndex.getName();
			tableModel.addRow(row);
		}
		if(column.equals("대학")) {
		 pCollege.setModel(tableModel);}
		else if(column.equals("학과")){
		pDepartment.setModel(tableModel);
		}
	}
	private void selectSubject(String fileName) {
		String[] title = new String[5];
		title[0] = "강좌코드";
		title[1] = "강좌";
		title[2] = "강의자";
		title[3] = "학점";
		title[4] = "시간";
		DefaultTableModel tableModel = new DefaultTableModel(title,0);
		this.cLecture = new CLecture();
		vLectureVector = cLecture.getVLectureVector(fileName);
		for(VLecture vLecture: vLectureVector) {
			String[] row = new String[5];
			row[0] = Integer.toString(vLecture.getCode());
			row[1] = vLecture.getName();
			row[2] = vLecture.getLecturer();
			row[3] = Integer.toString(vLecture.getCredit());
			row[4] = vLecture.getDate();
			tableModel.addRow(row);
	}
		pSubject.setModel(tableModel);
	}
	
	private void changeVector(String table,String fileName) {
		this.cIndex = new CIndex();
		this.cLecture = new CLecture();
		if(table.equals("pCollege")) {
		pCollege.vIndexVector = cIndex.getVIndexvector(fileName);
		}
		else if(table.equals("pDepartment")) {
			pDepartment.vIndexVector = cIndex.getVIndexvector(fileName);
		}
		else if(table.equals("pSubject")) {
			pSubject.vLectureVector = cLecture.getVLectureVector(fileName);
		}
	}
	// 이걸 해보니까 Vector값을 바꿔도 테이블이 다시 그려지지 않네. 이렇게 두 개를 만들어야 하는 것 같다.
}

	
	
	
