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
import me.hyngsk.covidnow.MainApplication;
import me.hyngsk.covidnow.Manager.DataConsumer;
import me.hyngsk.covidnow.Manager.DataManager;
import me.hyngsk.covidnow.Manager.DataProducer;
import me.hyngsk.covidnow.Model.DataModel;
import me.hyngsk.covidnow.Model.Options;
import me.hyngsk.covidnow.Utils.TimeUtil;

import java.util.ArrayList;

import static me.hyngsk.covidnow.Model.Options.All;

public class MainController {
	private MainApplication mainApp;
	private final DataManager dataManager = new DataManager();

	public static DataModel consumed;
	public static ArrayList<DataModel> consumed_arr;

//	@FXML
//	private BorderPane rootView;
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

	@FXML
	private void initialize() {
		initClock();
		optionCbox.setItems(FXCollections.observableArrayList(Options.values()));
		optionCbox.setValue(All);

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

		DataProducer dataProducer = new DataProducer(optionCbox.getValue());
		DataConsumer dataConsumer = new DataConsumer();
		dataProducer.dataManager = dataManager;
		dataConsumer.dataManager = dataManager;
		dataProducer.run();
		dataConsumer.start();
		dataConsumer.join();
		String time=null;
		if (optionCbox.getValue().equals(All)){
			System.out.println(consumed_arr);
			time = consumed_arr.get(0).getUpdate_dt();
		}
		else{
			System.out.println(consumed);
			time = consumed.getUpdate_dt();

		}
		inquiryTimeLabel.setText((String) time.subSequence(0, 19));
	}


}
