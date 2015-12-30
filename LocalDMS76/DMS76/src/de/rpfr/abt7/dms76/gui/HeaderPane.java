package de.rpfr.abt7.dms76.gui;

import javafx.animation.Animation;
import javafx.animation.Transition;
import javafx.geometry.Pos;
import javafx.scene.control.Label;
import javafx.scene.layout.VBox;
import javafx.util.Duration;

public class HeaderPane extends VBox {
	
	public HeaderPane(String title, long duration){
		super();
		setLayoutX(20);
		setLayoutY(20);
		setPrefWidth(Double.MAX_VALUE);
		setId("header");
		setAlignment(Pos.CENTER);

		final String content = title;
		final Label text = new Label("");
		text.setId("headline");

		final Animation animation = new Transition() {
			{
				setCycleDuration(Duration.millis(duration));
			}

			protected void interpolate(double frac) {
				final int length = content.length();
				final int n = Math.round(length * (float) frac);
				text.setText(content.substring(0, n));
			}

		};

		animation.play();

		getChildren().add(text);
		setSpacing(10);

	}

}
