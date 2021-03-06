package com.alphalaneous.SettingsPanels;

import com.alphalaneous.Components.CurvedButton;
import com.alphalaneous.Components.FancyTextArea;
import com.alphalaneous.Components.RoundedJButton;
import com.alphalaneous.Components.ScrollbarUI;
import com.alphalaneous.Defaults;
import com.alphalaneous.Settings;
import com.alphalaneous.ThemedComponents.ThemedCheckbox;
import com.alphalaneous.Windows.DialogBox;
import com.alphalaneous.Windows.SettingsWindow;

import javax.swing.*;
import java.awt.*;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.io.*;
import java.nio.file.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

import static com.alphalaneous.Defaults.settingsButtonUI;
import static javax.swing.ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER;
import static javax.swing.ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS;

public class RequestSettings {

	public static volatile int minLikes = 0;
	public static volatile int maxLikes = 0;
	public static volatile int minObjects = 0;
	public static volatile int maxObjects = 0;
	public static volatile int minID = 0;
	public static volatile int maxID = 0;
	public static volatile boolean minLikesOption = false;
	public static volatile boolean maxLikesOption = false;
	public static volatile boolean minObjectsOption = false;
	public static volatile boolean maxObjectsOption = false;
	public static volatile boolean minIDOption = false;
	public static volatile boolean maxIDOption = false;
	public static volatile boolean ratedOption = false;
	public static volatile boolean unratedOption = false;
	public static volatile boolean disableOption = true;
	public static volatile boolean disableLengthOption = true;
	public static volatile boolean disallowOption = false;
	public static volatile boolean allowOption = false;
	public static volatile ArrayList<String> excludedDifficulties = new ArrayList<>();
	public static volatile ArrayList<String> excludedLengths = new ArrayList<>();
	private static ThemedCheckbox na = createButton("$GD_NA$", 5);
	private static ThemedCheckbox auto = createButton("$GD_AUTO$", 35);
	private static ThemedCheckbox easy = createButton("$GD_EASY$", 65);
	private static ThemedCheckbox normal = createButton("$GD_NORMAL$", 95);
	private static ThemedCheckbox hard = createButton("$GD_HARD$", 125);
	private static ThemedCheckbox harder = createButton("$GD_HARDER$", 155);
	private static ThemedCheckbox insane = createButton("$GD_INSANE$", 185);
	private static ThemedCheckbox easyDemon = createButton("$GD_EASY_DEMON$", 215);
	private static ThemedCheckbox mediumDemon = createButton("$GD_MEDIUM_DEMON$", 245);
	private static ThemedCheckbox hardDemon = createButton("$GD_HARD_DEMON$", 275);
	private static ThemedCheckbox insaneDemon = createButton("$GD_INSANE_DEMON$", 305);
	private static ThemedCheckbox extremeDemon = createButton("$GD_EXTREME_DEMON$", 335);
	private static ThemedCheckbox tiny = createButton("$GD_TINY$", 5);
	private static ThemedCheckbox shortL = createButton("$GD_SHORT$", 35);
	private static ThemedCheckbox medium = createButton("$GD_MEDIUM$", 65);
	private static ThemedCheckbox longL = createButton("$GD_LONG$", 95);
	private static ThemedCheckbox XL = createButton("$GD_XL$", 125);
	private static ThemedCheckbox minimumLikes = createButton("$MINIMUM_LIKES$", 690);
	private static ThemedCheckbox maximumLikes = createButton("$MAXIMUM_LIKES$", 765);
	private static ThemedCheckbox minimumObjects = createButton("$MINIMUM_OBJECTS$", 840);
	private static ThemedCheckbox maximumObjects = createButton("$MAXIMUM_OBJECTS$", 915);
	private static ThemedCheckbox minimumID = createButton("$MINIMUM_ID$", 990);
	private static ThemedCheckbox maximumID = createButton("$MAXIMUM_ID$", 1065);
	private static FancyTextArea minLikesInput = new FancyTextArea(true, true);
	private static FancyTextArea maxLikesInput = new FancyTextArea(true, true);
	private static FancyTextArea minObjectsInput = new FancyTextArea(true, false);
	private static FancyTextArea maxObjectsInput = new FancyTextArea(true, false);
	private static FancyTextArea minIDInput = new FancyTextArea(true, false);
	private static FancyTextArea maxIDInput = new FancyTextArea(true, false);
	private static CurvedButton allowedStrings = new CurvedButton("$ALLOWED_WORDS$");
	private static CurvedButton disallowedStrings = new CurvedButton("$DISALLOWED_WORDS$");
	private static ThemedCheckbox rated = createButton("$RATED_LEVELS_ONLY$", 15);
	private static ThemedCheckbox unrated = createButton("$UNRATED_LEVELS_ONLY$", 45);
	private static ThemedCheckbox disableDifficulties = createButton("$DISABLE_SELECTED_DIFFICULTIES$", 75);
	private static ThemedCheckbox disableLengths = createButton("$DISABLE_SELECTED_LENGTHS$", 490);
	private static JPanel difficultyPanel = new JPanel(null);
	private static JPanel lengthPanel = new JPanel(null);
	private static JPanel mainPanel = new JPanel(null);
	private static JPanel panel = new JPanel();
	private static JScrollPane scrollPane = new JScrollPane(panel);
	private static JPanel listPanel = new JPanel();
	private static JScrollPane listScrollPane = new JScrollPane(listPanel);
	private static JPanel topPanel = new JPanel();
	private static JLabel label = new JLabel();
	private static FancyTextArea input = new FancyTextArea(false, false);
	private static RoundedJButton addID = new RoundedJButton("\uECC8", "Add Word");
	private static RoundedJButton backButton = new RoundedJButton("\uE112", "Back");
	private static ThemedCheckbox enableWordSetting = createButton("", 365, 55);
	private static int i = 0;
	private static double height = 0;
	private static boolean allowedStringsBool = false;

	public static JPanel createPanel() {

		scrollPane.setBorder(BorderFactory.createEmptyBorder());
		scrollPane.getViewport().setBackground(Defaults.SUB_MAIN);
		scrollPane.setBounds(0, 0, 412, 622);
		scrollPane.setPreferredSize(new Dimension(412, 622));
		scrollPane.setHorizontalScrollBarPolicy(HORIZONTAL_SCROLLBAR_NEVER);
		scrollPane.getVerticalScrollBar().setUnitIncrement(30);
		scrollPane.getVerticalScrollBar().setOpaque(false);
		scrollPane.setOpaque(false);
		scrollPane.setVerticalScrollBarPolicy(VERTICAL_SCROLLBAR_ALWAYS);
		scrollPane.getVerticalScrollBar().setUI(new ScrollbarUI());

		listPanel.setDoubleBuffered(true);
		listPanel.setLayout(new FlowLayout(FlowLayout.CENTER, 4, 4));
		listPanel.setPreferredSize(new Dimension(400, 0));
		listPanel.setBackground(Defaults.SUB_MAIN);

		topPanel.setBackground(Defaults.TOP);
		topPanel.setLayout(null);

		label.setForeground(Defaults.FOREGROUND);
		label.setFont(Defaults.SEGOE.deriveFont(14f));

		input.setBounds(160, 15, 200, 32);
		input.getDocument().putProperty("filterNewlines", Boolean.TRUE);
		addID.setBackground(Defaults.BUTTON);
		addID.setBounds(370, 16, 30, 30);
		addID.setFont(Defaults.SYMBOLS.deriveFont(22f));
		addID.setForeground(Defaults.FOREGROUND);
		addID.setUI(settingsButtonUI);

		backButton.setBackground(Defaults.BUTTON);
		backButton.setBounds(15, 16, 30, 30);
		backButton.setFont(Defaults.SYMBOLS.deriveFont(14f));

		backButton.setForeground(Defaults.FOREGROUND);
		backButton.setUI(settingsButtonUI);

		backButton.addActionListener(e -> {
			topPanel.setVisible(false);
			listScrollPane.setVisible(false);
			scrollPane.setVisible(true);
		});

		addID.addActionListener(e -> {

			try {
				Path file;
				if (allowedStringsBool) {
					file = Paths.get(Defaults.saveDirectory + "\\GDBoard\\allowedStrings.txt");
				} else {
					file = Paths.get(Defaults.saveDirectory + "\\GDBoard\\disallowedStrings.txt");
				}
				if (!Files.exists(file)) {
					Files.createFile(file);
				}
				boolean goThrough = true;
				Scanner sc = new Scanner(file.toFile());
				while (sc.hasNextLine()) {
					if (String.valueOf(input.getText()).equals(sc.nextLine())) {
						goThrough = false;
						break;
					}
				}
				sc.close();
				if (goThrough) {
					if (!input.getText().equalsIgnoreCase("")) {

						Files.write(file, (input.getText() + "\n").getBytes(), StandardOpenOption.APPEND);
						addButton(input.getText());
						input.setText("");
						listPanel.updateUI();
					}
				}
			} catch (IOException e1) {
				DialogBox.showDialogBox("Error!", e1.toString(), "Please report to Alphalaneous.", new String[]{"OK"});
			}

		});


		topPanel.add(backButton);
		topPanel.add(addID);
		topPanel.add(input);
		topPanel.add(label);
		topPanel.add(enableWordSetting);
		topPanel.setBounds(0, 0, 412, 90);
		topPanel.setVisible(false);

		listScrollPane.setBorder(BorderFactory.createEmptyBorder());
		listScrollPane.getViewport().setBackground(Defaults.SUB_MAIN);
		listScrollPane.setBounds(0, 90, 412, 532);
		listScrollPane.setPreferredSize(new Dimension(412, 532));
		listScrollPane.setHorizontalScrollBarPolicy(HORIZONTAL_SCROLLBAR_NEVER);
		listScrollPane.getVerticalScrollBar().setUnitIncrement(30);
		listScrollPane.getVerticalScrollBar().setOpaque(false);
		listScrollPane.setOpaque(false);
		listScrollPane.setVerticalScrollBarPolicy(VERTICAL_SCROLLBAR_ALWAYS);
		listScrollPane.getVerticalScrollBar().setUI(new ScrollbarUI());
		listScrollPane.setVisible(false);

		enableWordSetting.addMouseListener(new MouseAdapter() {
			@Override
			public void mousePressed(MouseEvent e) {
				if (allowedStringsBool) {
					allowOption = enableWordSetting.getSelectedState();
				} else {
					disallowOption = enableWordSetting.getSelectedState();
				}
			}
		});

		mainPanel.setBounds(0, 0, 415, 622);
		mainPanel.setBackground(Defaults.SUB_MAIN);


		panel.setLayout(null);
		panel.setDoubleBuffered(true);
		panel.setBounds(0, 0, 412, 1240);
		panel.setPreferredSize(new Dimension(412, 1240));
		panel.setBackground(Defaults.SUB_MAIN);

		rated.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseReleased(MouseEvent e) {
				ratedOption = rated.getSelectedState();
			}
		});
		unrated.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseReleased(MouseEvent e) {
				unratedOption = unrated.getSelectedState();
			}
		});
		disableDifficulties.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseReleased(MouseEvent e) {
				disableOption = disableDifficulties.getSelectedState();
			}
		});
		disableLengths.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseReleased(MouseEvent e) {
				disableLengthOption = disableLengths.getSelectedState();
			}
		});
		disableDifficulties.setChecked(true);
		disableLengths.setChecked(true);
		na.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseReleased(MouseEvent e) {
				if (na.getSelectedState()) {
					excludedDifficulties.add("na");
					System.out.println(excludedDifficulties.toString());
				} else {
					excludedDifficulties.remove("na");
					System.out.println(excludedDifficulties.toString());
				}
			}
		});
		auto.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseReleased(MouseEvent e) {
				if (auto.getSelectedState()) {
					excludedDifficulties.add("auto");
					System.out.println(excludedDifficulties.toString());
				} else {
					excludedDifficulties.remove("auto");
					System.out.println(excludedDifficulties.toString());
				}
			}
		});
		easy.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseReleased(MouseEvent e) {
				if (easy.getSelectedState()) {
					excludedDifficulties.add("easy");
					System.out.println(excludedDifficulties.toString());
				} else {
					excludedDifficulties.remove("easy");
					System.out.println(excludedDifficulties.toString());
				}
			}
		});
		normal.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseReleased(MouseEvent e) {
				if (normal.getSelectedState()) {
					excludedDifficulties.add("normal");
					System.out.println(excludedDifficulties.toString());
				} else {
					excludedDifficulties.remove("normal");
					System.out.println(excludedDifficulties.toString());
				}
			}
		});
		hard.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseReleased(MouseEvent e) {
				if (hard.getSelectedState()) {
					excludedDifficulties.add("hard");
					System.out.println(excludedDifficulties.toString());
				} else {
					excludedDifficulties.remove("hard");
					System.out.println(excludedDifficulties.toString());
				}
			}
		});
		harder.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseReleased(MouseEvent e) {
				if (harder.getSelectedState()) {
					excludedDifficulties.add("harder");
					System.out.println(excludedDifficulties.toString());
				} else {
					excludedDifficulties.remove("harder");
					System.out.println(excludedDifficulties.toString());
				}
			}
		});
		insane.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseReleased(MouseEvent e) {
				if (insane.getSelectedState()) {
					excludedDifficulties.add("insane");
					System.out.println(excludedDifficulties.toString());
				} else {
					excludedDifficulties.remove("insane");
					System.out.println(excludedDifficulties.toString());
				}
			}
		});
		easyDemon.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseReleased(MouseEvent e) {
				if (easyDemon.getSelectedState()) {
					excludedDifficulties.add("easy demon");
					System.out.println(excludedDifficulties.toString());
				} else {
					excludedDifficulties.remove("easy demon");
					System.out.println(excludedDifficulties.toString());
				}
			}
		});
		mediumDemon.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseReleased(MouseEvent e) {
				if (mediumDemon.getSelectedState()) {
					excludedDifficulties.add("medium demon");
					System.out.println(excludedDifficulties.toString());
				} else {
					excludedDifficulties.remove("medium demon");
					System.out.println(excludedDifficulties.toString());
				}
			}
		});
		hardDemon.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseReleased(MouseEvent e) {
				if (hardDemon.getSelectedState()) {
					excludedDifficulties.add("hard demon");
					System.out.println(excludedDifficulties.toString());
				} else {
					excludedDifficulties.remove("hard demon");
					System.out.println(excludedDifficulties.toString());
				}
			}
		});
		insaneDemon.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseReleased(MouseEvent e) {
				if (insaneDemon.getSelectedState()) {
					excludedDifficulties.add("insane demon");
					System.out.println(excludedDifficulties.toString());
				} else {
					excludedDifficulties.remove("insane demon");
					System.out.println(excludedDifficulties.toString());
				}
			}
		});
		extremeDemon.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseReleased(MouseEvent e) {
				if (extremeDemon.getSelectedState()) {
					excludedDifficulties.add("extreme demon");
					System.out.println(excludedDifficulties.toString());
				} else {
					excludedDifficulties.remove("extreme demon");
					System.out.println(excludedDifficulties.toString());
				}
			}
		});


		tiny.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseReleased(MouseEvent e) {
				if (tiny.getSelectedState()) {
					excludedLengths.add("tiny");
					System.out.println(excludedLengths.toString());
				} else {
					excludedLengths.remove("tiny");
					System.out.println(excludedLengths.toString());
				}
			}
		});
		shortL.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseReleased(MouseEvent e) {
				if (shortL.getSelectedState()) {
					excludedLengths.add("short");
					System.out.println(excludedLengths.toString());
				} else {
					excludedLengths.remove("short");
					System.out.println(excludedLengths.toString());
				}
			}
		});
		medium.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseReleased(MouseEvent e) {
				if (medium.getSelectedState()) {
					excludedLengths.add("medium");
					System.out.println(excludedLengths.toString());
				} else {
					excludedLengths.remove("medium");
					System.out.println(excludedLengths.toString());
				}
			}
		});
		longL.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseReleased(MouseEvent e) {
				if (longL.getSelectedState()) {
					excludedLengths.add("long");
					System.out.println(excludedLengths.toString());
				} else {
					excludedLengths.remove("long");
					System.out.println(excludedLengths.toString());
				}
			}
		});
		XL.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseReleased(MouseEvent e) {
				if (XL.getSelectedState()) {
					excludedLengths.add("xl");
					System.out.println(excludedLengths.toString());
				} else {
					excludedLengths.remove("xl");
					System.out.println(excludedLengths.toString());
				}
			}
		});

		minimumLikes.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseReleased(MouseEvent e) {
				minLikesOption = minimumLikes.getSelectedState();
				minLikesInput.setEditable(minLikesOption);
			}
		});
		maximumLikes.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseReleased(MouseEvent e) {
				maxLikesOption = maximumLikes.getSelectedState();
				maxLikesInput.setEditable(maxLikesOption);
			}
		});
		minimumObjects.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseReleased(MouseEvent e) {
				minObjectsOption = minimumObjects.getSelectedState();
				minObjectsInput.setEditable(minObjectsOption);
			}
		});
		maximumObjects.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseReleased(MouseEvent e) {
				maxObjectsOption = maximumObjects.getSelectedState();
				maxObjectsInput.setEditable(maxObjectsOption);
			}
		});

		minimumID.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseReleased(MouseEvent e) {
				minIDOption = minimumID.getSelectedState();
				minIDInput.setEditable(minIDOption);
			}
		});
		maximumID.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseReleased(MouseEvent e) {
				maxIDOption = maximumID.getSelectedState();
				maxIDInput.setEditable(maxIDOption);
			}
		});

		minLikesInput.setEditable(false);
		minLikesInput.setBounds(25, 723, 345, 32);
		minLikesInput.getDocument().putProperty("filterNewlines", Boolean.TRUE);
		minLikesInput.addKeyListener(new KeyListener() {
			@Override
			public void keyTyped(KeyEvent e) {
			}

			@Override
			public void keyPressed(KeyEvent e) {
			}

			@Override
			public void keyReleased(KeyEvent e) {
				try {
					minLikes = Integer.parseInt(minLikesInput.getText());
				} catch (NumberFormatException f) {
					minLikes = 0;
				}
			}
		});
		maxLikesInput.setEditable(false);
		maxLikesInput.setBounds(25, 798, 345, 32);
		maxLikesInput.getDocument().putProperty("filterNewlines", Boolean.TRUE);
		maxLikesInput.addKeyListener(new KeyListener() {
			@Override
			public void keyTyped(KeyEvent e) {
			}

			@Override
			public void keyPressed(KeyEvent e) {
			}

			@Override
			public void keyReleased(KeyEvent e) {
				try {
					maxLikes = Integer.parseInt(maxLikesInput.getText());
				} catch (NumberFormatException f) {
					maxLikes = 0;
				}
			}
		});
		minObjectsInput.setEditable(false);
		minObjectsInput.setBounds(25, 873, 345, 32);
		minObjectsInput.getDocument().putProperty("filterNewlines", Boolean.TRUE);
		minObjectsInput.addKeyListener(new KeyListener() {
			@Override
			public void keyTyped(KeyEvent e) {
			}

			@Override
			public void keyPressed(KeyEvent e) {
			}

			@Override
			public void keyReleased(KeyEvent e) {
				try {
					minObjects = Integer.parseInt(minObjectsInput.getText());
				} catch (NumberFormatException f) {
					minObjects = 0;
				}
			}
		});
		maxObjectsInput.setEditable(false);
		maxObjectsInput.setBounds(25, 948, 345, 32);
		maxObjectsInput.getDocument().putProperty("filterNewlines", Boolean.TRUE);
		maxObjectsInput.addKeyListener(new KeyListener() {
			@Override
			public void keyTyped(KeyEvent e) {
			}

			@Override
			public void keyPressed(KeyEvent e) {
			}

			@Override
			public void keyReleased(KeyEvent e) {
				try {
					maxObjects = Integer.parseInt(maxObjectsInput.getText());
				} catch (NumberFormatException f) {
					maxObjects = 0;
				}
			}
		});
		minIDInput.setEditable(false);
		minIDInput.setBounds(25, 1023, 345, 32);
		minIDInput.getDocument().putProperty("filterNewlines", Boolean.TRUE);
		minIDInput.addKeyListener(new KeyListener() {
			@Override
			public void keyTyped(KeyEvent e) {
			}

			@Override
			public void keyPressed(KeyEvent e) {
			}

			@Override
			public void keyReleased(KeyEvent e) {
				try {
					minID = Integer.parseInt(minIDInput.getText());
				} catch (NumberFormatException f) {
					minID = 0;
				}
			}
		});
		maxIDInput.setEditable(false);
		maxIDInput.setBounds(25, 1098, 345, 32);
		maxIDInput.getDocument().putProperty("filterNewlines", Boolean.TRUE);
		maxIDInput.addKeyListener(new KeyListener() {
			@Override
			public void keyTyped(KeyEvent e) {
			}

			@Override
			public void keyPressed(KeyEvent e) {
			}

			@Override
			public void keyReleased(KeyEvent e) {
				try {
					maxID = Integer.parseInt(maxIDInput.getText());
				} catch (NumberFormatException f) {
					maxID = 0;
				}
			}
		});

		allowedStrings.setBounds(25, 1160, 345, 30);
		allowedStrings.setPreferredSize(new Dimension(345, 30));
		allowedStrings.setFont(Defaults.SEGOE.deriveFont(14f));
		allowedStrings.setUI(settingsButtonUI);
		allowedStrings.setForeground(Defaults.FOREGROUND);
		allowedStrings.setBackground(Defaults.BUTTON);
		allowedStrings.refresh();

		allowedStrings.addActionListener(e -> {
			i = 0;
			height = 0;
			allowedStringsBool = true;
			scrollPane.setVisible(false);
			listPanel.removeAll();
			enableWordSetting.setText("Only allow level titles that contain these");
			enableWordSetting.setChecked(allowOption);
			enableWordSetting.refresh();
			label.setText("Allowed: ");
			label.setBounds(60, 22, label.getPreferredSize().width + 5, label.getPreferredSize().height + 5);
			topPanel.setVisible(true);
			listScrollPane.setVisible(true);
			File file = new File(Defaults.saveDirectory + "\\GDBoard\\allowedStrings.txt");
			if (file.exists()) {
				Scanner sc = null;
				try {
					sc = new Scanner(file);
				} catch (FileNotFoundException f) {
					f.printStackTrace();
				}
				assert sc != null;
				while (sc.hasNextLine()) {
					addButton(sc.nextLine());
					try {
						Thread.sleep(5);
					} catch (InterruptedException f) {
						f.printStackTrace();
					}
				}
				sc.close();
			}

		});

		disallowedStrings.setBounds(25, 1200, 345, 30);
		disallowedStrings.setPreferredSize(new Dimension(345, 30));
		disallowedStrings.setFont(Defaults.SEGOE.deriveFont(14f));
		disallowedStrings.setUI(settingsButtonUI);
		disallowedStrings.setForeground(Defaults.FOREGROUND);
		disallowedStrings.setBackground(Defaults.BUTTON);
		disallowedStrings.refresh();

		disallowedStrings.addActionListener(e -> {
			i = 0;
			height = 0;
			allowedStringsBool = false;
			scrollPane.setVisible(false);
			listPanel.removeAll();
			enableWordSetting.setText("Don't allow level titles that contain these");
			enableWordSetting.setChecked(disallowOption);
			enableWordSetting.refresh();
			label.setText("Disallowed: ");
			label.setBounds(60, 22, label.getPreferredSize().width + 5, label.getPreferredSize().height + 5);
			topPanel.setVisible(true);
			listScrollPane.setVisible(true);
			File file = new File(Defaults.saveDirectory + "\\GDBoard\\disallowedStrings.txt");
			if (file.exists()) {
				Scanner sc = null;
				try {
					sc = new Scanner(file);
				} catch (FileNotFoundException f) {
					f.printStackTrace();
				}
				assert sc != null;
				while (sc.hasNextLine()) {
					addButton(sc.nextLine());
					try {
						Thread.sleep(5);
					} catch (InterruptedException f) {
						f.printStackTrace();
					}
				}
				sc.close();
			}

		});


		difficultyPanel.setBounds(0, 110, 415, 370);
		difficultyPanel.setBackground(Defaults.TOP);


		lengthPanel.setBounds(0, 525, 415, 160);
		lengthPanel.setBackground(Defaults.TOP);

		lengthPanel.add(tiny);
		lengthPanel.add(shortL);
		lengthPanel.add(medium);
		lengthPanel.add(longL);
		lengthPanel.add(XL);

		panel.add(rated);
		panel.add(unrated);
		panel.add(disableDifficulties);
		panel.add(disableLengths);
		difficultyPanel.add(na);
		difficultyPanel.add(auto);
		difficultyPanel.add(easy);
		difficultyPanel.add(normal);
		difficultyPanel.add(hard);
		difficultyPanel.add(harder);
		difficultyPanel.add(insane);
		difficultyPanel.add(easyDemon);
		difficultyPanel.add(mediumDemon);
		difficultyPanel.add(hardDemon);
		difficultyPanel.add(insaneDemon);
		difficultyPanel.add(extremeDemon);

		panel.add(difficultyPanel);
		panel.add(lengthPanel);

		panel.add(minimumLikes);
		panel.add(maximumLikes);
		panel.add(minimumObjects);
		panel.add(maximumObjects);
		panel.add(minimumID);
		panel.add(maximumID);

		panel.add(minLikesInput);
		panel.add(maxLikesInput);
		panel.add(minObjectsInput);
		panel.add(maxObjectsInput);
		panel.add(minIDInput);
		panel.add(maxIDInput);

		panel.add(allowedStrings);
		panel.add(disallowedStrings);

		mainPanel.add(scrollPane);
		mainPanel.add(listScrollPane);
		mainPanel.add(topPanel);
		return mainPanel;


	}

	public static void loadSettings() {
		ratedOption = Boolean.parseBoolean(Settings.getSettings("rated"));
		rated.setChecked(ratedOption);
		unratedOption = Boolean.parseBoolean(Settings.getSettings("unrated"));
		unrated.setChecked(unratedOption);
		if (!Settings.getSettings("disableDifficulties").equalsIgnoreCase("")) {
			disableOption = Boolean.parseBoolean(Settings.getSettings("disableDifficulties"));
		}
		if (!Settings.getSettings("disableLengths").equalsIgnoreCase("")) {
			disableLengthOption = Boolean.parseBoolean(Settings.getSettings("disableLengths"));
		}
		disableDifficulties.setChecked(disableOption);
		if (!Settings.getSettings("difficultyFilter").equalsIgnoreCase("")) {
			excludedDifficulties = new ArrayList<>(Arrays.asList(Settings.getSettings("difficultyFilter").split(", ")));
		}
		if (!Settings.getSettings("lengthFilter").equalsIgnoreCase("")) {
			excludedLengths = new ArrayList<>(Arrays.asList(Settings.getSettings("lengthFilter").split(", ")));
		}

		if (!Settings.getSettings("minLikesOption").equalsIgnoreCase("")) {
			minLikesOption = Boolean.parseBoolean(Settings.getSettings("minLikesOption"));
			minimumLikes.setChecked(minLikesOption);
			minLikesInput.setEditable(minLikesOption);
		}
		if (!Settings.getSettings("maxLikesOption").equalsIgnoreCase("")) {
			maxLikesOption = Boolean.parseBoolean(Settings.getSettings("maxLikesOption"));
			maximumLikes.setChecked(maxLikesOption);
			maxLikesInput.setEditable(maxLikesOption);
		}
		if (!Settings.getSettings("minObjectsOption").equalsIgnoreCase("")) {
			minObjectsOption = Boolean.parseBoolean(Settings.getSettings("minObjectsOption"));
			minimumObjects.setChecked(minObjectsOption);
			minObjectsInput.setEditable(minObjectsOption);
		}
		if (!Settings.getSettings("maxObjectsOption").equalsIgnoreCase("")) {
			maxObjectsOption = Boolean.parseBoolean(Settings.getSettings("maxObjectsOption"));
			maximumObjects.setChecked(maxObjectsOption);
			maxObjectsInput.setEditable(maxObjectsOption);
		}
		if (!Settings.getSettings("minIDOption").equalsIgnoreCase("")) {
			minIDOption = Boolean.parseBoolean(Settings.getSettings("minIDOption"));
			minimumID.setChecked(minIDOption);
			minIDInput.setEditable(minIDOption);
		}
		if (!Settings.getSettings("maxIDOption").equalsIgnoreCase("")) {
			maxIDOption = Boolean.parseBoolean(Settings.getSettings("maxIDOption"));
			maximumID.setChecked(maxIDOption);
			maxIDInput.setEditable(maxIDOption);
		}
		if (!Settings.getSettings("allowStrings").equalsIgnoreCase("")) {
			allowOption = Boolean.parseBoolean(Settings.getSettings("allowStrings"));
		}
		if (!Settings.getSettings("disallowStrings").equalsIgnoreCase("")) {
			disallowOption = Boolean.parseBoolean(Settings.getSettings("disallowStrings"));
		}
		if (excludedLengths.contains("tiny")) {
			tiny.setChecked(true);
		}
		if (excludedLengths.contains("short")) {
			shortL.setChecked(true);
		}
		if (excludedLengths.contains("medium")) {
			medium.setChecked(true);
		}
		if (excludedLengths.contains("long")) {
			longL.setChecked(true);
		}
		if (excludedLengths.contains("xl")) {
			XL.setChecked(true);
		}

		if (excludedDifficulties.contains("na")) {
			na.setChecked(true);
		}
		if (excludedDifficulties.contains("auto")) {
			auto.setChecked(true);
		}
		if (excludedDifficulties.contains("easy")) {
			easy.setChecked(true);
		}
		if (excludedDifficulties.contains("normal")) {
			normal.setChecked(true);
		}
		if (excludedDifficulties.contains("hard")) {
			hard.setChecked(true);
		}
		if (excludedDifficulties.contains("harder")) {
			harder.setChecked(true);
		}
		if (excludedDifficulties.contains("insane")) {
			insane.setChecked(true);
		}
		if (excludedDifficulties.contains("easy demon")) {
			easyDemon.setChecked(true);
		}
		if (excludedDifficulties.contains("medium demon")) {
			mediumDemon.setChecked(true);
		}
		if (excludedDifficulties.contains("hard demon")) {
			hardDemon.setChecked(true);
		}
		if (excludedDifficulties.contains("insane demon")) {
			insaneDemon.setChecked(true);
		}
		if (excludedDifficulties.contains("extreme demon")) {
			extremeDemon.setChecked(true);
		}
		if (!Settings.getSettings("minLikes").equalsIgnoreCase("")) {
			minLikes = Integer.parseInt(Settings.getSettings("minLikes"));
			minLikesInput.setText(String.valueOf(minLikes));
		}
		if (!Settings.getSettings("maxLikes").equalsIgnoreCase("")) {
			maxLikes = Integer.parseInt(Settings.getSettings("maxLikes"));
			maxLikesInput.setText(String.valueOf(maxLikes));
		}
		if (!Settings.getSettings("minObjects").equalsIgnoreCase("")) {
			minObjects = Integer.parseInt(Settings.getSettings("minObjects"));
			minObjectsInput.setText(String.valueOf(minObjects));
		}
		if (!Settings.getSettings("maxObjects").equalsIgnoreCase("")) {
			maxObjects = Integer.parseInt(Settings.getSettings("maxObjects"));
			maxObjectsInput.setText(String.valueOf(maxObjects));
		}
		if (!Settings.getSettings("minID").equalsIgnoreCase("")) {
			minID = Integer.parseInt(Settings.getSettings("minID"));
			minIDInput.setText(String.valueOf(minID));
		}
		if (!Settings.getSettings("maxID").equalsIgnoreCase("")) {
			maxID = Integer.parseInt(Settings.getSettings("maxID"));
			maxIDInput.setText(String.valueOf(maxID));
		}
	}

	public static void setSettings() {

		Settings.writeSettings("rated", String.valueOf(ratedOption));
		Settings.writeSettings("unrated", String.valueOf(unratedOption));
		Settings.writeSettings("disallowStrings", String.valueOf(disallowOption));
		Settings.writeSettings("allowStrings", String.valueOf(allowOption));
		Settings.writeSettings("disableDifficulties", String.valueOf(disableOption));
		Settings.writeSettings("minLikesOption", String.valueOf(minLikesOption));
		Settings.writeSettings("maxLikesOption", String.valueOf(maxLikesOption));
		Settings.writeSettings("minObjectsOption", String.valueOf(minObjectsOption));
		Settings.writeSettings("maxObjectsOption", String.valueOf(maxObjectsOption));
		Settings.writeSettings("minIDOption", String.valueOf(minIDOption));
		Settings.writeSettings("maxIDOption", String.valueOf(maxIDOption));
		Settings.writeSettings("disableLengths", String.valueOf(disableOption));
		Settings.writeSettings("minLikes", String.valueOf(minLikes));
		Settings.writeSettings("maxLikes", String.valueOf(maxLikes));
		Settings.writeSettings("minObjects", String.valueOf(minObjects));
		Settings.writeSettings("maxObjects", String.valueOf(maxObjects));
		Settings.writeSettings("minID", String.valueOf(minID));
		Settings.writeSettings("maxID", String.valueOf(maxID));
		Settings.writeSettings("difficultyFilter", excludedDifficulties.toString().replaceAll("\\[", "").replaceAll("]", "").replaceAll(",{4}", ","));
		Settings.writeSettings("lengthFilter", excludedLengths.toString().replaceAll("\\[", "").replaceAll("]", "").replaceAll(",{4}", ","));

	}

	private static void removeString(String string) {
		i--;
		if (i % 2 == 0) {
			height = height - 39;
			listPanel.setBounds(0, 0, 400, (int) (height + 4));
			listPanel.setPreferredSize(new Dimension(400, (int) (height + 4)));
			scrollPane.updateUI();
		}
		for (Component component : listPanel.getComponents()) {
			if (component instanceof CurvedButton) {
				if (((CurvedButton) component).getLText().equalsIgnoreCase(string)) {
					listPanel.remove(component);
					listPanel.updateUI();
				}
			}
		}
	}

	public static void addButton(String string) {
		i++;
		if ((i - 1) % 2 == 0) {
			height = height + 39;

			listPanel.setBounds(0, 0, 400, (int) (height + 4));
			listPanel.setPreferredSize(new Dimension(400, (int) (height + 4)));
			if (i > 0) {
				scrollPane.updateUI();
			}
		}
		Path file;
		if (allowedStringsBool) {
			file = Paths.get(Defaults.saveDirectory + "\\GDBoard\\allowedStrings.txt");
		} else {
			file = Paths.get(Defaults.saveDirectory + "\\GDBoard\\disallowedStrings.txt");
		}
		CurvedButton button = new CurvedButton(string);

		button.setBackground(Defaults.BUTTON);
		button.setUI(settingsButtonUI);
		button.setForeground(Defaults.FOREGROUND);
		button.setBorder(BorderFactory.createEmptyBorder());
		button.setFont(Defaults.SEGOE.deriveFont(14f));
		button.setPreferredSize(new Dimension(170, 35));
		button.addMouseListener(new MouseAdapter() {
			@Override
			public void mousePressed(MouseEvent e) {

				SettingsWindow.run = false;
				new Thread(() -> {
					String option;
					if (allowedStringsBool) {
						option = DialogBox.showDialogBox("Remove " + button.getLText() + "?", "<html>This will remove the ability to send levels containing this word.<html>", "", new String[]{"Yes", "No"});
					} else {
						option = DialogBox.showDialogBox("Remove " + button.getLText() + "?", "<html>This will allow levels containing this word.<html>", "", new String[]{"Yes", "No"});

					}
					if (option.equalsIgnoreCase("yes")) {
						if (Files.exists(file)) {
							try {
								Path temp = Paths.get(Defaults.saveDirectory + "\\GDBoard\\_temp_");
								PrintWriter out = new PrintWriter(new FileWriter(temp.toFile()));
								Files.lines(file)
										.filter(line -> !line.contains(button.getLText()))
										.forEach(out::println);
								out.flush();
								out.close();
								Files.delete(file);
								if (allowedStringsBool) {
									Files.move(temp, temp.resolveSibling(Defaults.saveDirectory + "\\GDBoard\\allowedStrings.txt"), StandardCopyOption.REPLACE_EXISTING);
								} else {
									Files.move(temp, temp.resolveSibling(Defaults.saveDirectory + "\\GDBoard\\disallowedStrings.txt"), StandardCopyOption.REPLACE_EXISTING);

								}

							} catch (IOException ex) {
								ex.printStackTrace();
								DialogBox.showDialogBox("Error!", ex.toString(), "Please report to Alphalaneous.", new String[]{"OK"});
							}
						}
						removeString(button.getLText());
					}
					SettingsWindow.run = true;
				}).start();
			}
		});
		button.refresh();
		listPanel.add(button);
		listPanel.updateUI();

	}

	private static ThemedCheckbox createButton(String text, int width, int y) {

		ThemedCheckbox button = new ThemedCheckbox(text);
		button.setBounds(25, y, width, 30);
		button.setForeground(Defaults.FOREGROUND);
		button.setOpaque(false);
		button.setBorder(BorderFactory.createEmptyBorder());
		button.setFont(Defaults.SEGOE.deriveFont(14f));
		button.refresh();
		return button;
	}

	private static ThemedCheckbox createButton(String text, int y) {
		return createButton(text, 345, y);
	}

	public static void refreshUI() {
		difficultyPanel.setBackground(Defaults.TOP);
		lengthPanel.setBackground(Defaults.TOP);
		panel.setBackground(Defaults.SUB_MAIN);
		mainPanel.setBackground(Defaults.SUB_MAIN);
		scrollPane.setBackground(Defaults.SUB_MAIN);
		scrollPane.getVerticalScrollBar().setUI(new ScrollbarUI());
		addID.setForeground(Defaults.FOREGROUND);
		addID.setBackground(Defaults.BUTTON);
		label.setForeground(Defaults.FOREGROUND);
		listPanel.setBackground(Defaults.SUB_MAIN);
		listScrollPane.getVerticalScrollBar().setUI(new ScrollbarUI());
		backButton.setForeground(Defaults.FOREGROUND);
		backButton.setBackground(Defaults.BUTTON);
		input.refresh_();
		enableWordSetting.refresh();
		topPanel.setBackground(Defaults.TOP);


		for (Component component : panel.getComponents()) {
			if (component instanceof JButton) {
				for (Component component2 : ((JButton) component).getComponents()) {
					if (component2 instanceof JLabel) {
						component2.setForeground(Defaults.FOREGROUND);

					}
				}
				component.setBackground(Defaults.BUTTON);
			}
			if (component instanceof JLabel) {
				component.setForeground(Defaults.FOREGROUND);

			}
			if (component instanceof JTextArea) {
				((FancyTextArea) component).refresh_();
			}
			if (component instanceof ThemedCheckbox) {
				((ThemedCheckbox) component).refresh();
			}
		}
		for (Component component : difficultyPanel.getComponents()) {
			if (component instanceof JButton) {
				for (Component component2 : ((JButton) component).getComponents()) {
					if (component2 instanceof JLabel) {
						component2.setForeground(Defaults.FOREGROUND);
					}
				}
				component.setBackground(Defaults.MAIN);
			}
			if (component instanceof JLabel) {
				component.setForeground(Defaults.FOREGROUND);

			}
			if (component instanceof JTextArea) {
				((FancyTextArea) component).refresh_();
			}
			if (component instanceof ThemedCheckbox) {
				((ThemedCheckbox) component).refresh();
			}
		}
		for (Component component : listPanel.getComponents()) {
			if (component instanceof JButton) {
				for (Component component2 : ((JButton) component).getComponents()) {
					if (component2 instanceof JLabel) {
						component2.setForeground(Defaults.FOREGROUND);
					}
				}
				component.setBackground(Defaults.MAIN);
			}
		}
		for (Component component : lengthPanel.getComponents()) {
			if (component instanceof JButton) {
				for (Component component2 : ((JButton) component).getComponents()) {
					if (component2 instanceof JLabel) {
						component2.setForeground(Defaults.FOREGROUND);
					}
				}
				component.setBackground(Defaults.BUTTON);
			}
			if (component instanceof JLabel) {
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
