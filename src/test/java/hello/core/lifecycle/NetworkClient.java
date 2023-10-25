package hello.core.lifecycle;

//javax : java 표준
import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;

public class NetworkClient {
	private String url;

	public NetworkClient() {
		System.out.println("생성자 호출, url = " + url);
	}

	public void setUrl(String url) {
		this.url = url;
	}

	//서비스 시작 시, 호출
	public void connect() {
		System.out.println("connect : " + url);
	}

	public void call(String message) {
		System.out.println("call : " + url + " message = " + message);
	}

	//서비스 종료 시, 호출
	public void disconnect() {
		System.out.println("close " + url);
	}

	//객체 생성 및 의존관계 주입 종료 후 호출
	@PostConstruct
	public void init() {
		System.out.println("NetworkClient.init");
		connect();
		call("초기화 연결 메세지");
	}

	//생성자 소멸 직전에 호출
	@PreDestroy
	public void close() {
		System.out.println("NetworkClient.close");
		disconnect();
	}
}
