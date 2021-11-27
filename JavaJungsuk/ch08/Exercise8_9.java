package ch08;

/**
 * 사용자정의 예외
 */

public class Exercise8_9 {
	//해당 메서드 내에서 Exception예외(모든 예외)가 발생할 수 있음
	public static void main(String[] args) throws Exception {
		//UnsupportedFunctionException발생시켜 예외 던지기
		throw new UnsupportedFunctionException("지원하지 않는 기능입니다.", 100);
	}
}

class UnsupportedFunctionException extends RuntimeException{
	final private int ERR_CODE;	//에러코드
	
	UnsupportedFunctionException(String msg){
		this(msg, 100);			//에러코드 기본값 100 초기화
	}
	
	UnsupportedFunctionException(String msg, int errCode){
		super(msg);				//Exception클래스의 생성자
		ERR_CODE = errCode;
	}
	
	public int getErrorCode() {
		return ERR_CODE;
	}
	
	//Exception클래스의 getMessage()를 오버라이딩
	public String getMessage() {
		return "["+ERR_CODE+"]"+super.getMessage();
	}
}