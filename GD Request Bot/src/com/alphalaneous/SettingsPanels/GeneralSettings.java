package com.alphalaneous.SettingsPanels;

import com.alphalaneous.Components.FancyTextArea;
import com.alphalaneous.Components.LangLabel;
import com.alphalaneous.Components.ScrollbarUI;
import com.alphalaneous.Defaults;
import com.alphalaneous.Settings;
import com.alphalaneous.ThemedComponents.ThemedCheckbox;

import javax.swing.*;
import java.awt.*;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import static javax.swing.ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER;
import static javax.swing.ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS;

public class GeneralSettings {
	public static volatile boolean gdModeOption = true;
	public static volatile boolean lowCPUMode = false;
	public static volatile boolean followersOption = false;
	public static volatile boolean subsOption = false;
	public static volatile boolean repeatedOption = false;
	public static volatile boolean repeatedOptionAll = false;
	public static volatile boolean updatedRepeatedOption = false;
	public static volatile boolean nowPlayingOption = false;
	public static volatile boolean queueFullOption = false;
	public static volatile boolean confirmOption = false;
	public static volatile boolean confirmWhisperOption = false;
	public static volatile boolean autoDownloadOption = false;
	public static volatile boolean queueLimitBoolean = false;
	public static volatile boolean userLimitOption = false;
	public static volatile boolean userLimitStreamOption = false;
	public static volatile boolean streamerBypassOption = false;
	public static volatile boolean modsBypassOption = false;
	public static volatile boolean disableShowPositionOption = true;
	public static int queueLimit = 0;
	public static int userLimit = 0;
	public static int userLimitStream = 0;
	public static int queueLevelLength = 10;
	public static ThemedCheckbox deathMessage = createButton("Death Messages", 766);
	private static ThemedCheckbox gdMode = createButton("$GD_MODE$", 20);
	private static ThemedCheckbox followers = createButton("$FOLLOWERS_ONLY$", 50);
	private static ThemedCheckbox subOnly = createButton("$SUBSCRIBERS_ONLY$", 80);
	private static ThemedCheckbox nowPlaying = createButton("$DISABLE_NOW_PLAYING$", 110);
	private static ThemedCheckbox queueFull = createButton("$DISABLE_QUEUE_FULL$", 140);
	private static ThemedCheckbox confirmWhisper = createButton("$WHISPER_CONFIRMATION$", 170);
	private static ThemedCheckbox confirm = createButton("$DISABLE_CONFIRMATION$", 200);
	private static ThemedCheckbox disableShowPosition = createButton("$DISABLE_SHOW_POSITION$", 230);
	private static ThemedCheckbox repeated = createButton("$DISABLE_REPEATED$", 260);
	private static ThemedCheckbox repeatedAll = createButton("$DISABLE_REPEATED_ALL$", 290);
	private static ThemedCheckbox allowUpdatedRepeated = createButton("$ALLOW_UPDATED_REPEATED$", 320);
	private static ThemedCheckbox autoDownload = createButton("$AUTOMATIC_SONG_DOWNLOADS$", 350);
	private static ThemedCheckbox lowCPU = createButton("$LOW_CPU_MODE$", 380);
	private static ThemedCheckbox streamerBypass = createButton("$STREAMER_BYPASS$", 410);
	private static ThemedCheckbox modsBypass = createButton("$MODS_BYPASS$", 440);
	private static ThemedCheckbox queueLimitText = createButton("$MAX_QUEUE_SIZE$", 470);
	private static ThemedCheckbox userLimitText = createButton("$REQUEST_LIMIT_QUEUE$", 542);
	private static ThemedCheckbox userLimitStreamText = createButton("$STREAM_REQUEST_LIMIT$", 617);
	private static FancyTextArea queueSizeInput = new FancyTextArea(true, false);
	private static FancyTextArea userLimitInput = new FancyTextArea(true, false);
	private static FancyTextArea userLimitStreamInput = new FancyTextArea(true, false);
	private static LangLabel queueCommandLabel = new LangLabel("$QUEUE_COMMAND_LABEL$");
	private static FancyTextArea queueCommandLength = new FancyTextArea(true, false);
	private static JPanel mainPanel = new JPanel(null);
	private static JPanel panel = new JPanel();
	private static JScrollPane scrollPane = new JScrollPane(panel);


	public static JPanel createPanel() {


		panel.setLayout(null);
		panel.setDoubleBuffered(true);
		panel.setBounds(0, 0, 415, 810);
		panel.setPreferredSize(new Dimension(415, 810));
		panel.setBackground(Defaults.SUB_MAIN);

		gdMode.setChecked(true);
		gdMode.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseReleased(MouseEvent e) {
				gdModeOption = gdMode.getSelectedState();
				CommandSettings.refresh();

			}
		});

		followers.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseReleased(MouseEvent e) {
				followersOption = followers.getSelectedState();
			}
		});

		subOnly.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseReleased(MouseEvent e) {
				subsOption = subOnly.getSelectedState();
			}
		});

		nowPlaying.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseReleased(MouseEvent e) {
				nowPlayingOption = nowPlaying.getSelectedState();
			}
		});
		queueFull.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseReleased(MouseEvent e) {
				queueFullOption = queueFull.getSelectedState();
			}
		});
		confirmWhisper.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseReleased(MouseEvent e) {
				confirmWhisperOption = confirmWhisper.getSelectedState();
			}
		});

		confirm.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseReleased(MouseEvent e) {
				confirmOption = confirm.getSelectedState();
			}
		});
		disableShowPosition.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseReleased(MouseEvent e) {
				disableShowPositionOption = disableShowPosition.getSelectedState();
			}
		});
		repeated.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseReleased(MouseEvent e) {
				repeatedOption = repeated.getSelectedState();
			}
		});

		repeatedAll.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseReleased(MouseEvent e) {
				repeatedOptionAll = repeatedAll.getSelectedState();
			}
		});
		allowUpdatedRepeated.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseReleased(MouseEvent e) {
				updatedRepeatedOption = allowUpdatedRepeated.getSelectedState();
			}
		});

		autoDownload.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseReleased(MouseEvent e) {
				autoDownloadOption = autoDownload.getSelectedState();
			}
		});
		lowCPU.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseReleased(MouseEvent e) {
				lowCPUMode = lowCPU.getSelectedState();
			}
		});


		streamerBypass.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseReleased(MouseEvent e) {
				streamerBypassOption = streamerBypass.getSelectedState();
			}
		});
		modsBypass.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseReleased(MouseEvent e) {
				modsBypassOption = modsBypass.getSelectedState();
			}
		});

		deathMessage.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseReleased(MouseEvent e) {
				Settings.writeSettings("SendDeathMessages", String.valueOf(deathMessage.getSelectedState()));
			}
		});

		queueLimitText.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseReleased(MouseEvent e) {
				queueLimitBoolean = queueLimitText.getSelectedState();
				if (!queueLimitBoolean) {
					queueSizeInput.setEditable(false);
				} else {
					queueSizeInput.setEditable(true);
				}
			}
		});
		queueSizeInput.setEditable(false);
		queueSizeInput.setBounds(25, 503, 345, 32);
		queueSizeInput.getDocument().putProperty("filterNewlines", Boolean.TRUE);
		queueSizeInput.addKeyListener(new KeyListener() {
			@Override
			public void keyTyped(KeyEvent e) {
			}

			@Override
			public void keyPressed(KeyEvent e) {
			}

			@Override
			public void keyReleased(KeyEvent e) {
				try {
					queueLimit = Integer.parseInt(queueSizeInput.getText());
				} catch (NumberFormatException f) {
					queueLimit = 0;
				}
				System.out.println(queueLimit);
			}
		});

		userLimitText.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseReleased(MouseEvent e) {
				userLimitOption = userLimitText.getSelectedState();
				if (!userLimitOption) {
					userLimitInput.setEditable(false);
				} else {
					userLimitInput.setEditable(true);
				}
			}
		});

		userLimitInput.setEditable(false);
		userLimitInput.setBounds(25, 575, 345, 32);
		userLimitInput.getDocument().putProperty("filterNewlines", Boolean.TRUE);
		userLimitInput.addKeyListener(new KeyListener() {
			@Override
			public void keyTyped(KeyEvent e) {
			}

			@Override
			public void keyPressed(KeyEvent e) {
			}

			@Override
			public void keyReleased(KeyEvent e) {
				try {
					userLimit = Integer.parseInt(userLimitInput.getText());
				} catch (NumberFormatException f) {
					userLimit = 0;
				}
				System.out.println(userLimit);
			}
		});

		userLimitStreamText.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseReleased(MouseEvent e) {
				userLimitStreamOption = userLimitStreamText.getSelectedState();
				if (!userLimitStreamOption) {
					userLimitStreamInput.setEditable(false);
				} else {
					userLimitStreamInput.setEditable(true);
				}
			}
		});

		userLimitStreamInput.setEditable(false);
		userLimitStreamInput.setBounds(25, 650, 345, 32);
		userLimitStreamInput.getDocument().putProperty("filterNewlines", Boolean.TRUE);
		userLimitStreamInput.addKeyListener(new KeyListener() {
			@Override
			public void keyTyped(KeyEvent e) {
			}

			@Override
			public void keyPressed(KeyEvent e) {
			}

			@Override
			public void keyReleased(KeyEvent e) {
				try {
					userLimitStream = Integer.parseInt(userLimitStreamInput.getText());
				} catch (NumberFormatException f) {
					userLimitStream = 0;
				}
			}
		});

		queueCommandLabel.setForeground(Defaults.FOREGROUND);
		queueCommandLabel.setFont(Defaults.SEGOE.deriveFont(14f));
		queueCommandLabel.setBounds(25, 694, 345, queueCommandLabel.getPreferredSize().height + 5);

		queueCommandLength.setText("10");
		queueCommandLength.setBounds(25, 726, 345, 32);
		queueCommandLength.getDocument().putProperty("filterNewlines", Boolean.TRUE);
		queueCommandLength.addKeyListener(new KeyListener() {
			@Override
			public void keyTyped(KeyEvent e) {
			}

			@Override
			public void keyPressed(KeyEvent e) {
			}

			@Override
			public void keyReleased(KeyEvent e) {
				try {
					queueLevelLength = Integer.parseInt(queueCommandLength.getText());
				} catch (NumberFormatException f) {
					queueLevelLength = 10;
				}
			}
		});

		panel.add(gdMode);
		panel.add(followers);
		panel.add(subOnly);
		//panel.add(silentMode);
		panel.add(nowPlaying);
		panel.add(queueFull);
		panel.add(confirmWhisper);
		panel.add(confirm);
		panel.add(disableShowPosition);
		panel.add(repeated);
		panel.add(repeatedAll);
		panel.add(allowUpdatedRepeated);
		panel.add(autoDownload);
		panel.add(lowCPU);
		panel.add(streamerBypass);
		panel.add(modsBypass);
		panel.add(queueLimitText);
		panel.add(queueSizeInput);
		panel.add(userLimitText);
		panel.add(userLimitInput);
		panel.add(userLimitStreamText);
		panel.add(userLimitStreamInput);
		panel.add(queueCommandLabel);
		panel.add(queueCommandLength);
		panel.add(deathMessage);

		scrollPane.setBorder(BorderFactory.createEmptyBorder());
		scrollPane.getViewport().setBackground(Defaults.SUB_MAIN);
		scrollPane.setBounds(0, 0, 412, 622);
		scrollPane.setPreferredSize(new Dimension(412, 532));
		scrollPane.setHorizontalScrollBarPolicy(HORIZONTAL_SCROLLBAR_NEVER);
		scrollPane.getVerticalScrollBar().setUnitIncrement(30);
		scrollPane.getVerticalScrollBar().setOpaque(false);
		scrollPane.setOpaque(false);
		scrollPane.setVerticalScrollBarPolicy(VERTICAL_SCROLLBAR_ALWAYS);
		scrollPane.getVerticalScrollBar().setUI(new ScrollbarUI());
		mainPanel.setBounds(0, 0, 415, 622);
		mainPanel.add(scrollPane);
		return mainPanel;
	}

	public static void loadSettings() {
		if (!Settings.getSettings("gdMode").equalsIgnoreCase("")) {
			gdModeOption = Boolean.parseBoolean(Settings.getSettings("gdMode"));
		} else {
			gdModeOption = true;
		}
		followersOption = Boolean.parseBoolean(Settings.getSettings("followers"));
		subsOption = Boolean.parseBoolean(Settings.getSettings("subscribers"));
		//silentOption = Boolean.parseBoolean(Settings.getSettings("silentMode"));
		nowPlayingOption = Boolean.parseBoolean(Settings.getSettings("disableNP"));
		queueFullOption = Boolean.parseBoolean(Settings.getSettings("disableQF"));
		confirmWhisperOption = Boolean.parseBoolean(Settings.getSettings("whisperConfirm"));
		confirmOption = Boolean.parseBoolean(Settings.getSettings("disableConfirm"));
		disableShowPositionOption = Boolean.parseBoolean(Settings.getSettings("disableShowPosition"));
		repeatedOption = Boolean.parseBoolean(Settings.getSettings("repeatedRequests"));
		repeatedOptionAll = Boolean.parseBoolean(Settings.getSettings("repeatedRequestsAll"));
		updatedRepeatedOption = Boolean.parseBoolean(Settings.getSettings("updatedRepeated"));
		lowCPUMode = Boolean.parseBoolean(Settings.getSettings("lowCPUMode"));
		streamerBypassOption = Boolean.parseBoolean(Settings.getSettings("streamerBypass"));
		modsBypassOption = Boolean.parseBoolean(Settings.getSettings("modsBypass"));


		autoDownloadOption = Boolean.parseBoolean(Settings.getSettings("autoDL"));
		queueLimitBoolean = Boolean.parseBoolean(Settings.getSettings("queueLimitEnabled"));
		if (!Settings.getSettings("queueLimit").equalsIgnoreCase("")) {
			queueLimit = Integer.parseInt(Settings.getSettings("queueLimit"));
			queueSizeInput.setText(String.valueOf(queueLimit));
		}
		userLimitOption = Boolean.parseBoolean(Settings.getSettings("userLimitEnabled"));
		if (!Settings.getSettings("userLimit").equalsIgnoreCase("")) {
			userLimit = Integer.parseInt(Settings.getSettings("userLimit"));
			userLimitInput.setText(String.valueOf(userLimit));
		}
		userLimitStreamOption = Boolean.parseBoolean(Settings.getSettings("userLimitStreamEnabled"));
		if (!Settings.getSettings("userLimitStream").equalsIgnoreCase("")) {
			userLimitStream = Integer.parseInt(Settings.getSettings("userLimitStream"));
			userLimitStreamInput.setText(String.valueOf(userLimitStream));
		}
		if (!Settings.getSettings("queueLevelLength").equalsIgnoreCase("")) {
			queueLevelLength = Integer.parseInt(Settings.getSettings("queueLevelLength"));
			queueCommandLength.setText(String.valueOf(queueLevelLength));
		}
		gdMode.setChecked(gdModeOption);
		followers.setChecked(followersOption);
		nowPlaying.setChecked(nowPlayingOption);
		disableShowPosition.setChecked(disableShowPositionOption);
		queueFull.setChecked(queueFullOption);
		confirm.setChecked(confirmOption);
		confirmWhisper.setChecked(confirmWhisperOption);
		subOnly.setChecked(subsOption);
		repeated.setChecked(repeatedOption);
		repeatedAll.setChecked(repeatedOptionAll);
		allowUpdatedRepeated.setChecked(updatedRepeatedOption);
		autoDownload.setChecked(autoDownloadOption);
		queueLimitText.setChecked(queueLimitBoolean);
		userLimitText.setChecked(userLimitOption);
		userLimitStreamText.setChecked(userLimitStreamOption);
		lowCPU.setChecked(lowCPUMode);
		streamerBypass.setChecked(streamerBypassOption);
		modsBypass.setChecked(modsBypassOption);

		deathMessage.setChecked(Boolean.parseBoolean(Settings.getSettings("SendDeathMessages")));


		if (!queueLimitBoolean) {
			queueSizeInput.setEditable(false);
		} else {
			queueSizeInput.setEditable(true);
		}
		if (!userLimitOption) {
			userLimitInput.setEditable(false);
		} else {
			userLimitInput.setEditable(true);
		}
		if (!userLimitStreamOption) {
			userLimitStreamInput.setEditable(false);
		} else {
			userLimitStreamInput.setEditable(true);
		}
	}

	public static void setSettings() {

		Settings.writeSettings("gdMode", String.valueOf(gdModeOption));
		Settings.writeSettings("followers", String.valueOf(followersOption));
		Settings.writeSettings("subscribers", String.valueOf(subsOption));
		Settings.writeSettings("disableNP", String.valueOf(nowPlayingOption));
		Settings.writeSettings("disableQF", String.valueOf(queueFullOption));
		Settings.writeSettings("whisperConfirm", String.valueOf(confirmWhisperOption));
		Settings.writeSettings("disableConfirm", String.valueOf(confirmOption));
		Settings.writeSettings("disableShowPosition", String.valueOf(disableShowPositionOption));
		Settings.writeSettings("autoDL", String.valueOf(autoDownloadOption));
		Settings.writeSettings("queueLimitEnabled", String.valueOf(queueLimitBoolean));
		Settings.writeSettings("queueLimit", String.valueOf(queueLimit));
		Settings.writeSettings("userLimitEnabled", String.valueOf(userLimitOption));
		Settings.writeSettings("userLimit", String.valueOf(userLimit));
		Settings.writeSettings("userLimitStreamEnabled", String.valueOf(userLimitStreamOption));
		Settings.writeSettings("userLimitStream", String.valueOf(userLimitStream));
		Settings.writeSettings("repeatedRequests", String.valueOf(repeatedOption));
		Settings.writeSettings("repeatedRequestsAll", String.valueOf(repeatedOptionAll));
		Settings.writeSettings("updatedRepeated", String.valueOf(updatedRepeatedOption));
		Settings.writeSettings("lowCPUMode", String.valueOf(lowCPUMode));
		Settings.writeSettings("streamerBypass", String.valueOf(streamerBypassOption));
		Settings.writeSettings("modsBypass", String.valueOf(modsBypassOption));
		Settings.writeSettings("queueLevelLength", String.valueOf(queueLevelLength));


	}

	@SuppressWarnings("unused")
	private static JLabel createLabel(String text, int y) {
		JLabel label = new JLabel(text);
		label.setFont(Defaults.SEGOE.deriveFont(14f));
		label.setBounds(25, y, label.getPreferredSize().width + 5, 30);
		label.setForeground(Defaults.FOREGROUND);

		return label;
	}

	private static ThemedCheckbox createButton(String text, int y) {

		ThemedCheckbox button = new ThemedCheckbox(text);
		button.setBounds(25, y, 345, 30);
		button.setForeground(Defaults.FOREGROUND);
		button.setBorder(BorderFactory.createEmptyBorder());
		button.setFont(Defaults.SEGOE.deriveFont(14f));
		button.refresh();
		return button;
	}

	public static void refreshUI() {
		panel.setBackground(Defaults.SUB_MAIN);
		scrollPane.getVerticalScrollBar().setUI(new ScrollbarUI());

		for (Component component : panel.getComponents()) {
			if (component instanceof JButton) {
				for (Component component2 : ((JButton) component).getComponents()) {
					if (component2 instanceof JLabel) {
						component2.setForeground(Defaults.FOREGROUND);
					}
				}
				component.setBackground(Defaults.BUTTON);
			}
			if (component instanceof JLabel && !(((LangLabel) component).getIdentifier().equals("GDBOARD_VERSION"))) {
				component.setForeground(Defaults.FOREGROUND);

			}
			if (component instanceof JTextArea) {
				((FancyTextArea) component).refresh_();
			}
			if (component instanceof ThemedCheckbox) {
				((ThemedCheckbox) component).refresh();
			}

		}
	}
}
