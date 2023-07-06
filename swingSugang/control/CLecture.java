package control;

import java.util.Vector;

import model.MLecture;
import valueObject.VLecture;

public class CLecture {

	private MLecture mLecture;	
	
	public CLecture() {
		this.mLecture = new MLecture();
	}
	
	public Vector<VLecture> getVLectureVector(String fileName) {
		Vector<VLecture> vLectureVector = mLecture.getLectureVector(fileName);
		//지금까진 그냥 뷰와 모델을 연결해주는 역할만 해줬는 데 여기에 알고리즘 로직이 들어가는 곳이다.
		return vLectureVector;
	}

}
