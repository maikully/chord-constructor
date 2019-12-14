package ChordConstructor;

import javafx.scene.layout.Pane;
import javafx.scene.layout.FlowPane;
import javafx.scene.layout.HBox;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;

import java.io.File;
import java.util.ArrayList;

import javafx.scene.image.ImageView;
import javafx.scene.image.Image;

import javafx.scene.media.Media;
import javafx.scene.media.MediaPlayer;
import javafx.scene.text.Font;

/**
 * Class that handles most of the logic for the program.
 */
public class ChordConstructor {
    private Key _currentKey;
    private ArrayList<Button> _buttons;
    private FlowPane _buttonPane;
    private Pane _constructorPane;
    private Pane _keyPane;
    private HBox _buttonPaneTop;
    private HBox _buttonPaneBottom;
    private ImageView _staffNode;
    private boolean _hasChord;
    private Media _cNote;
    private Media _cisNote;
    private Media _dNote;
    private Media _disNote;
    private Media _eNote;
    private Media _fNote;
    private Media _fisNote;
    private Media _gNote;
    private Media _gisNote;
    private Media _aNote;
    private Media _aisNote;
    private Media _bNote;
    private Label _label;

    /**
     * Constructor that calls helper methods to set up various aspects of hte program.
     */
    public ChordConstructor(Pane constructorPane) {
        _constructorPane = constructorPane;
        this.setUpButtons();
        this.setUpBackground();
        this.setUpMedia();
        this.setUpLabel();
        _keyPane = new Pane();
        _constructorPane.getChildren().addAll(_buttonPane);
        _hasChord = false;
    }

    /**
     * Helper method that sets up the chord's label
     */
    private void setUpLabel() {
        _label = new Label();
        _label.setTranslateX(Constants.NOTE_X_LOC - 5);
        _label.setTranslateY(Constants.C4_LOCATION + 12);
        _label.setFont(new Font("Times New Roman", 20));
    }

    /**
     * Helper method that sets up the audio files for the program
     */
    private void setUpMedia() {
        _cNote = new Media(new File(System.getProperty("user.dir") + Constants.PATH + "c4.wav").toURI().toString());
        _cisNote = new Media(new File(System.getProperty("user.dir") + Constants.PATH + "cis4.wav").toURI().toString());
        _dNote = new Media(new File(System.getProperty("user.dir") + Constants.PATH + "d4.wav").toURI().toString());
        _disNote = new Media(new File(System.getProperty("user.dir") + Constants.PATH + "dis4.wav").toURI().toString());
        _eNote = new Media(new File(System.getProperty("user.dir") + Constants.PATH + "e4.wav").toURI().toString());
        _fNote = new Media(new File(System.getProperty("user.dir") + Constants.PATH + "f4.wav").toURI().toString());
        _fisNote = new Media(new File(System.getProperty("user.dir") + Constants.PATH + "fis4.wav").toURI().toString());
        _gNote = new Media(new File(System.getProperty("user.dir") + Constants.PATH + "g4.wav").toURI().toString());
        _gisNote = new Media(new File(System.getProperty("user.dir") + Constants.PATH + "gis4.wav").toURI().toString());
        _aNote = new Media(new File(System.getProperty("user.dir") + Constants.PATH + "a5.wav").toURI().toString());
        _aisNote = new Media(new File(System.getProperty("user.dir") + Constants.PATH + "ais5.wav").toURI().toString());
        _bNote = new Media(new File(System.getProperty("user.dir") + Constants.PATH + "b5.wav").toURI().toString());
    }

    /**
     * Helper method that sets up the staff background
     */
    private void setUpBackground() {
        Image staff = new Image(this.getClass().getResourceAsStream("Staff.png"));
        _staffNode = new ImageView(staff);
        _staffNode.setX(25);
        _staffNode.setY(100);
    }
    
    /**
     * Helper method that sets up the initial key buttons that appear upon running the program
     */
    private void setUpButtons() {
        _buttonPane = new FlowPane(10, 10);
        Label selectKeyLabel = new Label("\n\nSelect a key!");
        _buttonPaneTop = new HBox(10);
        _buttonPaneBottom = new HBox(10);
        _buttons = new ArrayList<Button>();
        Button cMajorButton = new Button("C major");
        cMajorButton.setOnAction(new KeyHandler(1));
        _buttons.add(cMajorButton);
        Button cMinorButton = new Button("C minor");
        cMinorButton.setOnAction(new KeyHandler(2));
        _buttons.add(cMinorButton);
        Button desMajorButton = new Button("D-flat major");
        desMajorButton.setOnAction(new KeyHandler(3));
        _buttons.add(desMajorButton);
        Button cisMinorButton = new Button("C-sharp minor");
        cisMinorButton.setOnAction(new KeyHandler(4));
        _buttons.add(cisMinorButton);
        Button dMajorButton = new Button("D major");
        dMajorButton.setOnAction(new KeyHandler(5));
        _buttons.add(dMajorButton);
        Button dMinorButton = new Button("D minor");
        dMinorButton.setOnAction(new KeyHandler(6));
        _buttons.add(dMinorButton);
        Button eesMajorButton = new Button("E-flat major");
        eesMajorButton.setOnAction(new KeyHandler(7));
        _buttons.add(eesMajorButton);
        Button disMinorButton = new Button("D-sharp minor");
        disMinorButton.setOnAction(new KeyHandler(8));
        _buttons.add(disMinorButton);
        Button eMajorButton = new Button("E major");
        _buttons.add(eMajorButton);
        eMajorButton.setOnAction(new KeyHandler(9));
        Button eMinorButton = new Button("E minor");
        _buttons.add(eMinorButton);
        eMinorButton.setOnAction(new KeyHandler(10));
        Button fMajorButton = new Button("F major");
        _buttons.add(fMajorButton);
        fMajorButton.setOnAction(new KeyHandler(11));
        Button fMinorButton = new Button("F minor");
        fMinorButton.setOnAction(new KeyHandler(12));
        _buttons.add(fMinorButton);
        Button gesMajorButton = new Button("G-flat major");
        gesMajorButton.setOnAction(new KeyHandler(13));
        _buttons.add(gesMajorButton);
        Button fisMinorButton = new Button("F-sharp minor");
        fisMinorButton.setOnAction(new KeyHandler(14));
        _buttons.add(fisMinorButton);
        Button gMajorButton = new Button("G major");
        gMajorButton.setOnAction(new KeyHandler(15));
        _buttons.add(gMajorButton);
        Button gMinorButton = new Button("G minor");
        gMinorButton.setOnAction(new KeyHandler(16));
        _buttons.add(gMinorButton);
        Button aesMajorButton = new Button("A-flat major");
        aesMajorButton.setOnAction(new KeyHandler(17));
        _buttons.add(aesMajorButton);
        Button gisMinorButton = new Button("G-sharp minor");
        gisMinorButton.setOnAction(new KeyHandler(18));
        _buttons.add(gisMinorButton);
        Button aMajorButton = new Button("A major");
        aMajorButton.setOnAction(new KeyHandler(19));
        _buttons.add(aMajorButton);
        Button aMinorButton = new Button("A minor");
        aMinorButton.setOnAction(new KeyHandler(20));
        _buttons.add(aMinorButton);
        Button besMajorButton = new Button("B-flat major");
        besMajorButton.setOnAction(new KeyHandler(21));
        _buttons.add(besMajorButton);
        Button aisMinorButton = new Button("A sharp minor");
        aisMinorButton.setOnAction(new KeyHandler(22));
        _buttons.add(aisMinorButton);
        Button bMajorButton = new Button("B major");
        bMajorButton.setOnAction(new KeyHandler(23));
        _buttons.add(bMajorButton);
        Button bMinorButton = new Button("B minor");
        bMinorButton.setOnAction(new KeyHandler(24));
        _buttons.add(bMinorButton);
        for (int i = 0; i < _buttons.size() / 2; i++) {
            _buttonPaneTop.getChildren().add(_buttons.get(i));
        }
        for (int i = _buttons.size() / 2; i < _buttons.size(); i++) {
            _buttonPaneBottom.getChildren().add(_buttons.get(i));
        }
        _buttonPane.getChildren().addAll(selectKeyLabel, _buttonPaneTop);
        _buttonPane.getChildren().addAll(_buttonPaneBottom);
        _buttonPane.setTranslateX(100);
        _buttonPane.setTranslateY(Constants.WINDOW_HEIGHT / 2 - 200);
    }

    /**
     * Set up the roman numeral buttons for each chord, as well as the button to reset the key.
     * A boolean is passed in so the method knows whether the key should be major or minor.
     */
    private void setUpNumeralButtons(boolean major) {
        _buttons.clear();
        if (major) {
            Button iButton = new Button("I");
            Button iiButton = new Button("ii");
            Button iiiButton = new Button("iii");
            Button ivButton = new Button("IV");
            Button vButton = new Button("V");
            Button viButton = new Button("vi");
            Button viiButton = new Button("vii°");
            iButton.setOnAction(new iHandler());
            iiButton.setOnAction(new iiHandler());
            iiiButton.setOnAction(new iiiHandler());
            ivButton.setOnAction(new ivHandler());
            vButton.setOnAction(new vHandler());
            viButton.setOnAction(new viHandler());
            viiButton.setOnAction(new viiHandler());
            _buttons.add(iButton);
            _buttons.add(iiButton);
            _buttons.add(iiiButton);
            _buttons.add(ivButton);
            _buttons.add(vButton);
            _buttons.add(viButton);
            _buttons.add(viiButton);
        } else {
            Button iButton = new Button("i");
            Button iiButton = new Button("ii°");
            Button iiiButton = new Button("III");
            Button ivButton = new Button("iv");
            Button vButton = new Button("V");
            Button viButton = new Button("VI");
            Button viiButton = new Button("vii°");
            iButton.setOnAction(new iHandler());
            iiButton.setOnAction(new iiHandler());
            iiiButton.setOnAction(new iiiHandler());
            ivButton.setOnAction(new ivHandler());
            vButton.setOnAction(new vHandler());
            viButton.setOnAction(new viHandler());
            viiButton.setOnAction(new viiHandler());
            _buttons.add(iButton);
            _buttons.add(iiButton);
            _buttons.add(iiiButton);
            _buttons.add(ivButton);
            _buttons.add(vButton);
            _buttons.add(viButton);
            _buttons.add(viiButton);
        }
        Button clearButton = new Button("Reset key");
        clearButton.setOnAction(new ClearHandler());
        _buttons.add(clearButton);
        _buttonPaneTop.getChildren().clear();
        for (int i = 0; i < _buttons.size(); i++) {
            _buttonPaneTop.getChildren().add(_buttons.get(i));
        }
        _buttonPaneTop.setSpacing(50);
        _buttonPane.getChildren().clear();
        _buttonPane.getChildren().add(_buttonPaneTop);
        _buttonPane.setTranslateY(400);
        _buttonPane.setTranslateX(400);
        _constructorPane.getChildren().addAll(_buttonPane, _label);
    }

    /**
     * Method that takes in a string representing the note and plays the audio file representing that note.
     */
    private void playNote(String Note) {
        switch (Note) {
        case "C":
            new MediaPlayer(_cNote).play();
            break;
        case "C sharp":
        case "D flat":
            new MediaPlayer(_cisNote).play();
            break;
        case "D":
            new MediaPlayer(_dNote).play();
            break;
        case "D sharp":
        case "E flat":
            new MediaPlayer(_disNote).play();
            break;
        case "E":
            new MediaPlayer(_eNote).play();
            break;
        case "F":
            new MediaPlayer(_fNote).play();
            break;
        case "F sharp":
        case "G flat":
            new MediaPlayer(_fisNote).play();
            break;
        case "G":
            new MediaPlayer(_gNote).play();
            break;
        case "G sharp":
        case "A flat":
            new MediaPlayer(_gisNote).play();
            break;
        case "A":
            new MediaPlayer(_aNote).play();
            break;
        case "B flat":
        case "A sharp":
            new MediaPlayer(_aisNote).play();
            break;
        case "B":
            new MediaPlayer(_bNote).play();
            break;
        }
    }

    /**
     * private class that handles what key is created
     */
    private class KeyHandler implements EventHandler<ActionEvent> {
        private int _key;

        public KeyHandler(int key) {
            _key = key;
        }

        @Override
        public void handle(ActionEvent e) {
            switch (_key) {
            case 1:
                _currentKey = new Key(Constants.C, '0','s', 'M', _keyPane);
                _constructorPane.getChildren().remove(_buttonPane);
                _constructorPane.getChildren().add(_staffNode);
                _constructorPane.getChildren().add(_keyPane);
                ChordConstructor.this.setUpNumeralButtons(true);
                break;
            case 2:
                _currentKey = new Key(Constants.C, '0', 'f', 'm', _keyPane);
                _constructorPane.getChildren().remove(_buttonPane);
                _constructorPane.getChildren().add(_staffNode);
                _constructorPane.getChildren().add(_keyPane);
                ChordConstructor.this.setUpNumeralButtons(false);
                break;
            case 3:
                _currentKey = new Key(Constants.D_FLAT, 'f', 'f', 'M', _keyPane);
                _constructorPane.getChildren().remove(_buttonPane);
                _constructorPane.getChildren().add(_staffNode);
                _constructorPane.getChildren().add(_keyPane);
                ChordConstructor.this.setUpNumeralButtons(true);
                break;
            case 4:
                _currentKey = new Key(Constants.C_SHARP, 's', 's', 'm', _keyPane);
                _constructorPane.getChildren().remove(_buttonPane);
                _constructorPane.getChildren().add(_staffNode);
                _constructorPane.getChildren().add(_keyPane);
                ChordConstructor.this.setUpNumeralButtons(false);
                break;
            case 5:
                _currentKey = new Key(Constants.D, '0', 's', 'M', _keyPane);
                _constructorPane.getChildren().remove(_buttonPane);
                _constructorPane.getChildren().add(_staffNode);
                _constructorPane.getChildren().add(_keyPane);
                ChordConstructor.this.setUpNumeralButtons(true);
                break;
            case 6:
                _currentKey = new Key(Constants.D, '0', 'f', 'm', _keyPane);
                _constructorPane.getChildren().remove(_buttonPane);
                _constructorPane.getChildren().add(_staffNode);
                _constructorPane.getChildren().add(_keyPane);
                ChordConstructor.this.setUpNumeralButtons(false);
                break;
            case 7:
                _currentKey = new Key(Constants.E_FLAT, 'f', 'f', 'M', _keyPane);
                _constructorPane.getChildren().remove(_buttonPane);
                _constructorPane.getChildren().add(_staffNode);
                _constructorPane.getChildren().add(_keyPane);
                ChordConstructor.this.setUpNumeralButtons(true);
                break;
            case 8:
                _currentKey = new Key(Constants.D_SHARP, 's', 's', 'm', _keyPane);
                _constructorPane.getChildren().remove(_buttonPane);
                _constructorPane.getChildren().add(_staffNode);
                _constructorPane.getChildren().add(_keyPane);
                ChordConstructor.this.setUpNumeralButtons(false);
                break;
            case 9:
                _currentKey = new Key(Constants.E, '0', 's', 'M', _keyPane);
                _constructorPane.getChildren().remove(_buttonPane);
                _constructorPane.getChildren().add(_staffNode);
                _constructorPane.getChildren().add(_keyPane);
                ChordConstructor.this.setUpNumeralButtons(true);
                break;
            case 10:
                _currentKey = new Key(Constants.E, '0', 's', 'm', _keyPane);
                _constructorPane.getChildren().remove(_buttonPane);
                _constructorPane.getChildren().add(_staffNode);
                _constructorPane.getChildren().add(_keyPane);
                ChordConstructor.this.setUpNumeralButtons(false);
                break;
            case 11:
                _currentKey = new Key(Constants.F, '0', 'f', 'M', _keyPane);
                _constructorPane.getChildren().remove(_buttonPane);
                _constructorPane.getChildren().add(_staffNode);
                _constructorPane.getChildren().add(_keyPane);
                ChordConstructor.this.setUpNumeralButtons(true);
                break;
            case 12:
                _currentKey = new Key(Constants.F, '0', 'f', 'm', _keyPane);
                _constructorPane.getChildren().remove(_buttonPane);
                _constructorPane.getChildren().add(_staffNode);
                _constructorPane.getChildren().add(_keyPane);
                ChordConstructor.this.setUpNumeralButtons(false);
                break;
            case 13:
                _currentKey = new Key(Constants.G_FLAT, 'f', 'f', 'M', _keyPane);
                _constructorPane.getChildren().remove(_buttonPane);
                _constructorPane.getChildren().add(_staffNode);
                _constructorPane.getChildren().add(_keyPane);
                ChordConstructor.this.setUpNumeralButtons(true);
                break;
            case 14:
                _currentKey = new Key(Constants.F_SHARP, 's', 's', 'm', _keyPane);
                _constructorPane.getChildren().remove(_buttonPane);
                _constructorPane.getChildren().add(_staffNode);
                _constructorPane.getChildren().add(_keyPane);
                ChordConstructor.this.setUpNumeralButtons(false);
                break;
            case 15:
                _currentKey = new Key(Constants.G, '0', 's', 'M', _keyPane);
                _constructorPane.getChildren().remove(_buttonPane);
                _constructorPane.getChildren().add(_staffNode);
                _constructorPane.getChildren().add(_keyPane);
                ChordConstructor.this.setUpNumeralButtons(true);
                break;
            case 16:
                _currentKey = new Key(Constants.G, '0', 'f', 'm', _keyPane);
                _constructorPane.getChildren().remove(_buttonPane);
                _constructorPane.getChildren().add(_staffNode);
                _constructorPane.getChildren().add(_keyPane);
                ChordConstructor.this.setUpNumeralButtons(false);
                break;
            case 17:
                _currentKey = new Key(Constants.A_FLAT, 'f', 'f', 'M', _keyPane);
                _constructorPane.getChildren().remove(_buttonPane);
                _constructorPane.getChildren().add(_staffNode);
                _constructorPane.getChildren().add(_keyPane);
                ChordConstructor.this.setUpNumeralButtons(true);
                break;
            case 18:
                _currentKey = new Key(Constants.G_SHARP, 's', 's', 'm', _keyPane);
                _constructorPane.getChildren().remove(_buttonPane);
                _constructorPane.getChildren().add(_staffNode);
                _constructorPane.getChildren().add(_keyPane);
                ChordConstructor.this.setUpNumeralButtons(false);
                break;
            case 19:
                _currentKey = new Key(Constants.A, '0', 's', 'M', _keyPane);
                _constructorPane.getChildren().remove(_buttonPane);
                _constructorPane.getChildren().add(_staffNode);
                _constructorPane.getChildren().add(_keyPane);
                ChordConstructor.this.setUpNumeralButtons(true);
                break;
            case 20:
                _currentKey = new Key(Constants.A, '0', 's', 'm', _keyPane);
                _constructorPane.getChildren().remove(_buttonPane);
                _constructorPane.getChildren().add(_staffNode);
                _constructorPane.getChildren().add(_keyPane);
                ChordConstructor.this.setUpNumeralButtons(false);
                break;
            case 21:
                _currentKey = new Key(Constants.B_FLAT, 'f', 'f', 'M', _keyPane);
                _constructorPane.getChildren().remove(_buttonPane);
                _constructorPane.getChildren().add(_staffNode);
                _constructorPane.getChildren().add(_keyPane);
                ChordConstructor.this.setUpNumeralButtons(true);
                break;
            case 22:
                _currentKey = new Key(Constants.A_SHARP, 's', 's', 'm', _keyPane);
                _constructorPane.getChildren().remove(_buttonPane);
                _constructorPane.getChildren().add(_staffNode);
                _constructorPane.getChildren().add(_keyPane);
                ChordConstructor.this.setUpNumeralButtons(false);
                break;
            case 23:
                _currentKey = new Key(Constants.B, '0', 's', 'M', _keyPane);
                _constructorPane.getChildren().remove(_buttonPane);
                _constructorPane.getChildren().add(_staffNode);
                _constructorPane.getChildren().add(_keyPane);
                ChordConstructor.this.setUpNumeralButtons(true);
                break;
            case 24:
                _currentKey = new Key(Constants.B, '0', 's', 'm', _keyPane);
                _constructorPane.getChildren().remove(_buttonPane);
                _constructorPane.getChildren().add(_staffNode);
                _constructorPane.getChildren().add(_keyPane);
                ChordConstructor.this.setUpNumeralButtons(false);
                break;
            }
        }
    }

    /**
     * private class that handles the clear button
     */
    private class ClearHandler implements EventHandler<ActionEvent> {
        @Override
        public void handle(ActionEvent e) {
            _constructorPane.getChildren().removeAll(_staffNode, _buttonPane, _label, _keyPane);
            ChordConstructor.this.setUpButtons();
            ChordConstructor.this.setUpBackground();
            ChordConstructor.this.setUpMedia();
            ChordConstructor.this.setUpLabel();
            _constructorPane.getChildren().addAll(_buttonPane);
            if (_hasChord) {
                for (int i = 0; i < _currentKey.getList().size(); i++) {
                    _constructorPane.getChildren().remove(_currentKey.getList().get(i).getHead());
                    _constructorPane.getChildren().remove(_currentKey.getList().get(i).getLedger());
                    _constructorPane.getChildren().remove(_currentKey.getList().get(i).getStaffLine());
                    _constructorPane.getChildren().remove(_currentKey.getList().get(i).getAccidental());
                }
            }
            _hasChord = false;
        }
    }

    /**
     * private class that handles the roman numeral button representing the one chord. If there
     * is an existing chord, clear it before making the new chord.
     */
    private class iHandler implements EventHandler<ActionEvent> {
        @Override
        public void handle(ActionEvent e) {
            if (_hasChord) {
                for (int i = 0; i < _currentKey.getList().size(); i++) {
                    _constructorPane.getChildren().remove(_currentKey.getList().get(i).getHead());
                    _constructorPane.getChildren().remove(_currentKey.getList().get(i).getLedger());
                    _constructorPane.getChildren().remove(_currentKey.getList().get(i).getStaffLine());
                    _constructorPane.getChildren().remove(_currentKey.getList().get(i).getAccidental());
                }
            }
            System.out.print(_currentKey.getNote(1).getNoteName() + " ");
            System.out.print(_currentKey.getNote(3).getNoteName() + " ");
            System.out.print(_currentKey.getNote(5).getNoteName() + "\n");
            _constructorPane.getChildren().addAll(_currentKey.getNote(1).getHead());
            _constructorPane.getChildren().addAll(_currentKey.getNote(3).getHead());
            _constructorPane.getChildren().addAll(_currentKey.getNote(5).getHead());
            _constructorPane.getChildren().addAll(_currentKey.getNote(1).getLedger());
            _constructorPane.getChildren().addAll(_currentKey.getNote(3).getLedger());
            _constructorPane.getChildren().addAll(_currentKey.getNote(5).getLedger());
            _constructorPane.getChildren().addAll(_currentKey.getNote(1).getStaffLine());
            _constructorPane.getChildren().addAll(_currentKey.getNote(3).getStaffLine());
            _constructorPane.getChildren().addAll(_currentKey.getNote(5).getStaffLine());
            _constructorPane.getChildren().addAll(_currentKey.getNote(1).getAccidental());
            _constructorPane.getChildren().addAll(_currentKey.getNote(3).getAccidental());
            _constructorPane.getChildren().addAll(_currentKey.getNote(5).getAccidental());
            ChordConstructor.this.playNote(_currentKey.getNote(1).getNoteName());
            ChordConstructor.this.playNote(_currentKey.getNote(3).getNoteName());
            ChordConstructor.this.playNote(_currentKey.getNote(5).getNoteName());
            if (_currentKey.getQuality() == 'M')
                _label.setText("I");
            else
                _label.setText("i");
            _hasChord = true;
        }
    }

    private class iiHandler implements EventHandler<ActionEvent> {
        @Override
        public void handle(ActionEvent e) {
            if (_hasChord) {
                for (int i = 0; i < _currentKey.getList().size(); i++) {
                    _constructorPane.getChildren().remove(_currentKey.getList().get(i).getHead());
                    _constructorPane.getChildren().remove(_currentKey.getList().get(i).getLedger());
                    _constructorPane.getChildren().remove(_currentKey.getList().get(i).getStaffLine());
                    _constructorPane.getChildren().remove(_currentKey.getList().get(i).getAccidental());
                }
            }
            System.out.print(_currentKey.getNote(2).getNoteName() + " ");
            System.out.print(_currentKey.getNote(4).getNoteName() + " ");
            System.out.print(_currentKey.getNote(6).getNoteName() + "\n");
            _constructorPane.getChildren().addAll(_currentKey.getNote(2).getHead());
            _constructorPane.getChildren().addAll(_currentKey.getNote(4).getHead());
            _constructorPane.getChildren().addAll(_currentKey.getNote(6).getHead());
            _constructorPane.getChildren().addAll(_currentKey.getNote(2).getLedger());
            _constructorPane.getChildren().addAll(_currentKey.getNote(4).getLedger());
            _constructorPane.getChildren().addAll(_currentKey.getNote(6).getLedger());
            _constructorPane.getChildren().addAll(_currentKey.getNote(2).getStaffLine());
            _constructorPane.getChildren().addAll(_currentKey.getNote(4).getStaffLine());
            _constructorPane.getChildren().addAll(_currentKey.getNote(6).getStaffLine());
            _constructorPane.getChildren().addAll(_currentKey.getNote(2).getAccidental());
            _constructorPane.getChildren().addAll(_currentKey.getNote(4).getAccidental());
            _constructorPane.getChildren().addAll(_currentKey.getNote(6).getAccidental());
            ChordConstructor.this.playNote(_currentKey.getNote(2).getNoteName());
            ChordConstructor.this.playNote(_currentKey.getNote(4).getNoteName());
            ChordConstructor.this.playNote(_currentKey.getNote(6).getNoteName());
            if (_currentKey.getQuality() == 'M')
                _label.setText("ii");
            else
                _label.setText("ii°");
            _hasChord = true;
        }
    }

    private class iiiHandler implements EventHandler<ActionEvent> {
        @Override
        public void handle(ActionEvent e) {
            if (_hasChord) {
                for (int i = 0; i < _currentKey.getList().size(); i++) {
                    _constructorPane.getChildren().remove(_currentKey.getList().get(i).getHead());
                    _constructorPane.getChildren().remove(_currentKey.getList().get(i).getLedger());
                    _constructorPane.getChildren().remove(_currentKey.getList().get(i).getStaffLine());
                    _constructorPane.getChildren().remove(_currentKey.getList().get(i).getAccidental());
                }
            }
            System.out.print(_currentKey.getNote(3).getNoteName() + " ");
            System.out.print(_currentKey.getNote(5).getNoteName() + " ");
            System.out.print(_currentKey.getNote(7).getNoteName() + "\n");
            _constructorPane.getChildren().addAll(_currentKey.getNote(3).getHead());
            _constructorPane.getChildren().addAll(_currentKey.getNote(5).getHead());
            _constructorPane.getChildren().addAll(_currentKey.getNote(7).getHead());
            _constructorPane.getChildren().addAll(_currentKey.getNote(3).getLedger());
            _constructorPane.getChildren().addAll(_currentKey.getNote(5).getLedger());
            _constructorPane.getChildren().addAll(_currentKey.getNote(7).getLedger());
            _constructorPane.getChildren().addAll(_currentKey.getNote(3).getStaffLine());
            _constructorPane.getChildren().addAll(_currentKey.getNote(5).getStaffLine());
            _constructorPane.getChildren().addAll(_currentKey.getNote(7).getStaffLine());
            _constructorPane.getChildren().addAll(_currentKey.getNote(3).getAccidental());
            _constructorPane.getChildren().addAll(_currentKey.getNote(5).getAccidental());
            _constructorPane.getChildren().addAll(_currentKey.getNote(7).getAccidental());
            ChordConstructor.this.playNote(_currentKey.getNote(3).getNoteName());
            ChordConstructor.this.playNote(_currentKey.getNote(5).getNoteName());
            ChordConstructor.this.playNote(_currentKey.getNote(7).getNoteName());
            if (_currentKey.getQuality() == 'M')
                _label.setText("iii");
            else
                _label.setText("III");
            _hasChord = true;

        }
    }

    private class ivHandler implements EventHandler<ActionEvent> {
        @Override
        public void handle(ActionEvent e) {
            if (_hasChord) {
                for (int i = 0; i < _currentKey.getList().size(); i++) {
                    _constructorPane.getChildren().remove(_currentKey.getList().get(i).getHead());
                    _constructorPane.getChildren().remove(_currentKey.getList().get(i).getLedger());
                    _constructorPane.getChildren().remove(_currentKey.getList().get(i).getStaffLine());
                    _constructorPane.getChildren().remove(_currentKey.getList().get(i).getAccidental());
                }
            }
            System.out.print(_currentKey.getNote(4).getNoteName() + " ");
            System.out.print(_currentKey.getNote(6).getNoteName() + " ");
            System.out.print(_currentKey.getNote(1).getNoteName() + "\n");
            _constructorPane.getChildren().addAll(_currentKey.getNote(4).getHead());
            _constructorPane.getChildren().addAll(_currentKey.getNote(6).getHead());
            _constructorPane.getChildren().addAll(_currentKey.getNote(1).getHead());
            _constructorPane.getChildren().addAll(_currentKey.getNote(4).getLedger());
            _constructorPane.getChildren().addAll(_currentKey.getNote(6).getLedger());
            _constructorPane.getChildren().addAll(_currentKey.getNote(1).getLedger());
            _constructorPane.getChildren().addAll(_currentKey.getNote(4).getStaffLine());
            _constructorPane.getChildren().addAll(_currentKey.getNote(6).getStaffLine());
            _constructorPane.getChildren().addAll(_currentKey.getNote(1).getStaffLine());
            _constructorPane.getChildren().addAll(_currentKey.getNote(4).getAccidental());
            _constructorPane.getChildren().addAll(_currentKey.getNote(6).getAccidental());
            _constructorPane.getChildren().addAll(_currentKey.getNote(1).getAccidental());
            ChordConstructor.this.playNote(_currentKey.getNote(4).getNoteName());
            ChordConstructor.this.playNote(_currentKey.getNote(6).getNoteName());
            ChordConstructor.this.playNote(_currentKey.getNote(1).getNoteName());
            if (_currentKey.getQuality() == 'M')
                _label.setText("IV");
            else
                _label.setText("iv");
            _hasChord = true;

        }
    }

    /**
     * private class that handles the roman numeral button representing the five chord. Since the chord
     * is altered from the usual scale if the key is minor, it has a different function for 
     * minor keys.
     */
    private class vHandler implements EventHandler<ActionEvent> {
        @Override
        public void handle(ActionEvent e) {
            if (_hasChord) {
                for (int i = 0; i < _currentKey.getList().size(); i++) {
                    _constructorPane.getChildren().remove(_currentKey.getList().get(i).getHead());
                    _constructorPane.getChildren().remove(_currentKey.getList().get(i).getLedger());
                    _constructorPane.getChildren().remove(_currentKey.getList().get(i).getStaffLine());
                    _constructorPane.getChildren().remove(_currentKey.getList().get(i).getAccidental());
                }
            }
            System.out.print(_currentKey.getNote(5).getNoteName() + " ");
            _constructorPane.getChildren().addAll(_currentKey.getNote(5).getHead());
            _constructorPane.getChildren().addAll(_currentKey.getNote(5).getLedger());
            _constructorPane.getChildren().addAll(_currentKey.getNote(5).getStaffLine());
            _constructorPane.getChildren().addAll(_currentKey.getNote(5).getAccidental());
            ChordConstructor.this.playNote(_currentKey.getNote(5).getNoteName());
            if (_currentKey.getQuality() == 'M') {
                System.out.print(_currentKey.getNote(7).getNoteName() + " ");
                _constructorPane.getChildren().addAll(_currentKey.getNote(7).getHead());
                _constructorPane.getChildren().addAll(_currentKey.getNote(7).getLedger());
                _constructorPane.getChildren().addAll(_currentKey.getNote(7).getStaffLine());
                _constructorPane.getChildren().addAll(_currentKey.getNote(7).getAccidental());
                ChordConstructor.this.playNote(_currentKey.getNote(7).getNoteName());
            } else {
                System.out.print(_currentKey.getNote(8).getNoteName() + " ");
                _constructorPane.getChildren().addAll(_currentKey.getNote(8).getHead());
                _constructorPane.getChildren().addAll(_currentKey.getNote(8).getLedger());
                _constructorPane.getChildren().addAll(_currentKey.getNote(8).getStaffLine());
                _constructorPane.getChildren().addAll(_currentKey.getNote(8).getAccidental());
                ChordConstructor.this.playNote(_currentKey.getNote(8).getNoteName());
            }
            System.out.print(_currentKey.getNote(2).getNoteName() + "\n");
            _constructorPane.getChildren().addAll(_currentKey.getNote(2).getHead());
            _constructorPane.getChildren().addAll(_currentKey.getNote(2).getLedger());
            _constructorPane.getChildren().addAll(_currentKey.getNote(2).getStaffLine());
            _constructorPane.getChildren().addAll(_currentKey.getNote(2).getAccidental());
            ChordConstructor.this.playNote(_currentKey.getNote(2).getNoteName());
            _label.setText("V");
            _hasChord = true;

        }
    }

    private class viHandler implements EventHandler<ActionEvent> {
        @Override
        public void handle(ActionEvent e) {
            if (_hasChord) {
                for (int i = 0; i < _currentKey.getList().size(); i++) {
                    _constructorPane.getChildren().remove(_currentKey.getList().get(i).getHead());
                    _constructorPane.getChildren().remove(_currentKey.getList().get(i).getLedger());
                    _constructorPane.getChildren().remove(_currentKey.getList().get(i).getStaffLine());
                    _constructorPane.getChildren().remove(_currentKey.getList().get(i).getAccidental());
                }
            }
            System.out.print(_currentKey.getNote(6).getNoteName() + " ");
            System.out.print(_currentKey.getNote(1).getNoteName() + " ");
            System.out.print(_currentKey.getNote(3).getNoteName() + "\n");
            _constructorPane.getChildren().addAll(_currentKey.getNote(6).getHead());
            _constructorPane.getChildren().addAll(_currentKey.getNote(1).getHead());
            _constructorPane.getChildren().addAll(_currentKey.getNote(3).getHead());
            _constructorPane.getChildren().addAll(_currentKey.getNote(6).getLedger());
            _constructorPane.getChildren().addAll(_currentKey.getNote(1).getLedger());
            _constructorPane.getChildren().addAll(_currentKey.getNote(3).getLedger());
            _constructorPane.getChildren().addAll(_currentKey.getNote(6).getStaffLine());
            _constructorPane.getChildren().addAll(_currentKey.getNote(1).getStaffLine());
            _constructorPane.getChildren().addAll(_currentKey.getNote(3).getStaffLine());
            _constructorPane.getChildren().addAll(_currentKey.getNote(6).getAccidental());
            _constructorPane.getChildren().addAll(_currentKey.getNote(1).getAccidental());
            _constructorPane.getChildren().addAll(_currentKey.getNote(3).getAccidental());
            ChordConstructor.this.playNote(_currentKey.getNote(6).getNoteName());
            ChordConstructor.this.playNote(_currentKey.getNote(1).getNoteName());
            ChordConstructor.this.playNote(_currentKey.getNote(3).getNoteName());
            if (_currentKey.getQuality() == 'M')
                _label.setText("vi");
            else
                _label.setText("VI");
            _hasChord = true;

        }
    }

    /**
     * private class that handles the roman numeral button representing the seven chord. Since the chord
     * is altered from the usual scale if the key is minor, it has a different function for 
     * minor keys.
     */
    private class viiHandler implements EventHandler<ActionEvent> {
        @Override
        public void handle(ActionEvent e) {
            if (_hasChord) {
                for (int i = 0; i < _currentKey.getList().size(); i++) {
                    _constructorPane.getChildren().remove(_currentKey.getList().get(i).getHead());
                    _constructorPane.getChildren().remove(_currentKey.getList().get(i).getLedger());
                    _constructorPane.getChildren().remove(_currentKey.getList().get(i).getStaffLine());
                    _constructorPane.getChildren().remove(_currentKey.getList().get(i).getAccidental());
                }
            }
            if (_currentKey.getQuality() == 'M') {
                System.out.print(_currentKey.getNote(7).getNoteName() + " ");
                _constructorPane.getChildren().addAll(_currentKey.getNote(7).getHead());
                _constructorPane.getChildren().addAll(_currentKey.getNote(7).getLedger());
                _constructorPane.getChildren().addAll(_currentKey.getNote(7).getStaffLine());
                _constructorPane.getChildren().addAll(_currentKey.getNote(7).getAccidental());
                ChordConstructor.this.playNote(_currentKey.getNote(7).getNoteName());
            } else {
                System.out.print(_currentKey.getNote(8).getNoteName() + " ");
                _constructorPane.getChildren().addAll(_currentKey.getNote(8).getHead());
                _constructorPane.getChildren().addAll(_currentKey.getNote(8).getLedger());
                _constructorPane.getChildren().addAll(_currentKey.getNote(8).getStaffLine());
                _constructorPane.getChildren().addAll(_currentKey.getNote(8).getAccidental());
                ChordConstructor.this.playNote(_currentKey.getNote(8).getNoteName());
            }
            System.out.print(_currentKey.getNote(2).getNoteName() + " ");
            System.out.print(_currentKey.getNote(4).getNoteName() + "\n");
            _constructorPane.getChildren().addAll(_currentKey.getNote(2).getHead());
            _constructorPane.getChildren().addAll(_currentKey.getNote(2).getLedger());
            _constructorPane.getChildren().addAll(_currentKey.getNote(2).getStaffLine());
            _constructorPane.getChildren().addAll(_currentKey.getNote(2).getAccidental());
            ChordConstructor.this.playNote(_currentKey.getNote(2).getNoteName());
            _constructorPane.getChildren().addAll(_currentKey.getNote(4).getHead());
            _constructorPane.getChildren().addAll(_currentKey.getNote(4).getLedger());
            _constructorPane.getChildren().addAll(_currentKey.getNote(4).getStaffLine());
            _constructorPane.getChildren().addAll(_currentKey.getNote(4).getAccidental());
            ChordConstructor.this.playNote(_currentKey.getNote(4).getNoteName());
            _label.setText("vii°");
            _hasChord = true;

        }
    }
}