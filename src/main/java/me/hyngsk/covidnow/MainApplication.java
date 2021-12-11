/**
 * [주석 1 : 과제 설명]
 * 객체지향프로그래밍 평가과제 (배점 25점)
 * 학과 :
 * 학번 :
 * 이름 :
 * <p>
 * 과제 주제 :
 */
package me.hyngsk.covidnow;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;
import me.hyngsk.covidnow.Controller.MainController;

import java.io.IOException;


/*


1. 과제 설명
2. 클래스 상속 *
3. 생성자 *
4. static 메소드 * TimeUtil.class
5. 오버로딩
6. 오버라이딩 *
7. 추상클래스 *
8. 다형성 *
9. Wrapper 객체의 박싱/언박싱
10. 예외처리 *
11. 다중인터페이스
12. 다중스레드(Thread) *
13. 다중스레드(Runnable) *
14. 코드 설명 동영상

 */


public class MainApplication extends Application {
	@Override
	public void start(Stage stage) {
		FXMLLoader fxmlLoader = new FXMLLoader(MainApplication.class.getResource("hello-view.fxml"));
		BorderPane root = null;
		Scene scene = null;
		try {
			root = fxmlLoader.load();
			scene = new Scene(root);
			MainController controller = fxmlLoader.getController();
			controller.setMainApp(this);
//			controller.initModel(new DataModel());
		} catch (IOException e) {
			e.printStackTrace();
		}
		if (root != null) {
			System.out.println(root.getChildren());
			System.out.println(scene.getRoot());
		}
		stage.setMinWidth(800);
		stage.setMinHeight(600);
		stage.setTitle("코로나 확진자수 현황판");
		stage.setAlwaysOnTop(true);
		stage.setScene(scene);
		stage.show();


	}

	public static void main(String[] args) {
		launch(args);
	}
}