/*
 * Copyright (c) 2021.
 * Name : Hyeong Seok, Oh
 * E-mail : hyngsk.o@gmail.com
 * Created at : ${DATE}
 */

package me.hyngsk.covidnow.Controller;

import javafx.animation.Animation;
import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.collections.FXCollections;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.ScrollPane;
import javafx.util.Duration;
import me.hyngsk.covidnow.Api.ApiService;
import me.hyngsk.covidnow.MainApplication;
import me.hyngsk.covidnow.Manager.DataConsumer;
import me.hyngsk.covidnow.Manager.DataManager;
import me.hyngsk.covidnow.Manager.DataProducer;
import me.hyngsk.covidnow.Model.DataModel;
import me.hyngsk.covidnow.Model.Options;
import me.hyngsk.covidnow.Utils.TimeUtil;

import static me.hyngsk.covidnow.Model.Options.total;

public class MainController {
	private MainApplication mainApp;
	private final DataManager dataManager = new DataManager();
	public DataModel model;
	public static DataModel consumed = new DataModel();

	//Top HBox
	@FXML
	private Button inquiryBtn;
	@FXML
	private ComboBox<Options> optionCbox;
	//Right VBox
	@FXML
	private Button exitBtn;
	@FXML
	private Label inquiryTimeLabel, nowTimeLabel;
	//Bottom ScrollPane
	@FXML
	private ScrollPane bottomScrollpane;

	private ApiService apiService;

	public MainController(/*모델*/) {
//		this.subject= subject;
//		subject.addObserver(this);
	}

	@FXML
	private void initialize() {
		initClock();
		apiService = new ApiService();
		optionCbox.setItems(FXCollections.observableArrayList(Options.values()));
		optionCbox.setValue(total);


	}

	private void initClock() {

		Timeline clock = new Timeline(new KeyFrame(Duration.ZERO, e -> {
			nowTimeLabel.setText(TimeUtil.getNow());
		}), new KeyFrame(Duration.seconds(1)));
		clock.setCycleCount(Animation.INDEFINITE);
		clock.play();
	}

	public void setMainApp(MainApplication mainApp) {
		this.mainApp = mainApp;
	}

	@FXML
	private void InquiryBtnClk() throws InterruptedException {
		// data
		System.out.println();
		System.out.println(model.toString());
		System.out.println();
		DataProducer dataProducer = new DataProducer(optionCbox.getValue());
		DataConsumer dataConsumer = new DataConsumer();
		dataProducer.dataManager = dataManager;
		dataConsumer.dataManager = dataManager;
		dataProducer.run();
		dataConsumer.start();
		dataConsumer.join();
		model = consumed;
		System.out.println();
		System.out.println(model.toString());
		System.out.println();

	}

	public static void consumer(DataModel dataModel) {
		consumed = dataModel;
	}

	public void initModel(DataModel k) {
		if (model != null) {
			throw new IllegalStateException("Model can only be initialized once");
		}
		model = k;

//		model.currentPersonProperty().addListener((obs, oldPerson, newPerson) -> {
//			if (oldPerson != null) {
//				firstNameField.textProperty().unbindBidirectional(oldPerson.firstNameProperty());
//				lastNameField.textProperty().unbindBidirectional(oldPerson.lastNameProperty());
//				emailField.textProperty().unbindBidirectional(oldPerson.emailProperty());
//			}
//			if (newPerson == null) {
//				firstNameField.setText("");
//				lastNameField.setText("");
//				emailField.setText("");
//			} else {
//				firstNameField.textProperty().bindBidirectional(newPerson.firstNameProperty());
//				lastNameField.textProperty().bindBidirectional(newPerson.lastNameProperty());
//				emailField.textProperty().bindBidirectional(newPerson.emailProperty());
//			}
//		});
	}

}
