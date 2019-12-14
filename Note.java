package ChordConstructor;
import javafx.scene.layout.Pane;
import javafx.scene.shape.Ellipse;
import javafx.scene.shape.Line;
import javafx.scene.paint.Color;
import javafx.scene.image.ImageView;
import javafx.scene.image.Image;

/**
 * Class that represents a note of a scale. Contains both logical and graphicaly aspects of the note, including 
 * the ledger line, staff line, and note head.
 */
public class Note {
    private int _note;
    private char _accidental;
    private Ellipse _noteHead;
    private Line _ledgerLine;
    private Line _staffLine;
    private ImageView _accidentalImage;

    /**
     * Constructor for the Note, which calls helper methods
     */
    public Note(int note, char accidental, Pane notePane) {
        _note = note;
        _accidental = accidental;
        _accidentalImage = new ImageView();
        this.setUpLedger();
        this.setUpNote();
    }

    /**
     * Instantiate the note head and set its location based on the pitch it represents. Only 
     * set the ledger line if the note is below or above the staff; only set the staff line if it's a note 
     * on a staff line, so that it doesn't seem to cover up the staff since whole notes are "transparent"; only
     * set the accidental if the note contains an accidental.
     */
    private void setUpNote() {
        _noteHead = new Ellipse(Constants.NOTE_HEAD_WIDTH, Constants.NOTE_HEAD_HEIGHT);
        _noteHead.setFill(Color.WHITE);
        _noteHead.setStroke(Color.BLACK);
        _noteHead.setStrokeWidth(Constants.STROKE_WIDTH);
        _noteHead.setCenterX(Constants.NOTE_X_LOC);
        // switch statement for the note value that was passed in
        switch (_note) {
            case 0:
                _noteHead.setCenterY(Constants.C4_LOCATION);
                _ledgerLine.setStartX(Constants.NOTE_X_LOC - Constants.LEDGER_LINE_WIDTH/2);
                _ledgerLine.setEndX(Constants.NOTE_X_LOC + Constants.LEDGER_LINE_WIDTH/2);
                _ledgerLine.setStartY(Constants.C4_LOCATION);
                _ledgerLine.setEndY(Constants.C4_LOCATION);
                break;
            case 1:
                if (_accidental == 's') {
                    _noteHead.setCenterY(Constants.C4_LOCATION);
                    _ledgerLine.setStartX(Constants.NOTE_X_LOC - Constants.LEDGER_LINE_WIDTH/2);
                    _ledgerLine.setEndX(Constants.NOTE_X_LOC + Constants.LEDGER_LINE_WIDTH/2);
                    _ledgerLine.setStartY(Constants.C4_LOCATION);
                    _ledgerLine.setEndY(Constants.C4_LOCATION);
                    this.setUpSharp();
                    break;
                }
                else {
                    _noteHead.setCenterY(Constants.D4_LOCATION);   
                    this.setUpFlat();
                    break;
                }
            case 2:
                _noteHead.setCenterY(Constants.D4_LOCATION);
                break;
            case 3:                
                if (_accidental == 's') {
                    _noteHead.setCenterY(Constants.D4_LOCATION);
                    this.setUpSharp();
                    break;
                }
                else {
                    _noteHead.setCenterY(Constants.E4_LOCATION);
                    _staffLine.setStartX(Constants.NOTE_X_LOC - Constants.STAFF_LINE_WIDTH/2);
                    _staffLine.setEndX(Constants.NOTE_X_LOC + Constants.STAFF_LINE_WIDTH/2);   
                    _staffLine.setStartY(Constants.E4_LOCATION);
                    _staffLine.setEndY(Constants.E4_LOCATION);
                    this.setUpFlat();
                    break;
                }
            case 4:
                _noteHead.setCenterY(Constants.E4_LOCATION);
                _staffLine.setStartX(Constants.NOTE_X_LOC - Constants.STAFF_LINE_WIDTH/2);
                _staffLine.setEndX(Constants.NOTE_X_LOC + Constants.STAFF_LINE_WIDTH/2);   
                _staffLine.setStartY(Constants.E4_LOCATION);
                _staffLine.setEndY(Constants.E4_LOCATION);
                break;
            case 5:
                _noteHead.setCenterY(Constants.F4_LOCATION);
                break;
            case 6:
                if (_accidental == 's') {
                    _noteHead.setCenterY(Constants.F4_LOCATION);
                    this.setUpSharp();
                    break;
                }
                else {
                    _noteHead.setCenterY(Constants.G4_LOCATION);
                    _staffLine.setStartX(Constants.NOTE_X_LOC - Constants.STAFF_LINE_WIDTH/2);
                    _staffLine.setEndX(Constants.NOTE_X_LOC + Constants.STAFF_LINE_WIDTH/2);   
                    _staffLine.setStartY(Constants.G4_LOCATION);
                    _staffLine.setEndY(Constants.G4_LOCATION);
                    this.setUpFlat();
                    break;
                }
            case 7:
                _noteHead.setCenterY(Constants.G4_LOCATION);
                _staffLine.setStartX(Constants.NOTE_X_LOC - Constants.STAFF_LINE_WIDTH/2);
                _staffLine.setEndX(Constants.NOTE_X_LOC + Constants.STAFF_LINE_WIDTH/2);   
                _staffLine.setStartY(Constants.G4_LOCATION);
                _staffLine.setEndY(Constants.G4_LOCATION);
                break;
            case 8:
                if (_accidental == 's') {
                    _noteHead.setCenterY(Constants.G4_LOCATION);
                    this.setUpSharp();
                    break;
                }
                else {
                    _noteHead.setCenterY(Constants.A4_LOCATION);
                    this.setUpFlat();
                    break;
                }   
            case 9:
                _noteHead.setCenterY(Constants.A4_LOCATION);
                break;
            case 10:
                if (_accidental == 's') {
                    _noteHead.setCenterY(Constants.A4_LOCATION);
                    this.setUpSharp();
                    break;
                }
                else {
                    _noteHead.setCenterY(Constants.B4_LOCATION);
                    _staffLine.setStartX(Constants.NOTE_X_LOC - Constants.STAFF_LINE_WIDTH/2);
                    _staffLine.setEndX(Constants.NOTE_X_LOC + Constants.STAFF_LINE_WIDTH/2);   
                    _staffLine.setStartY(Constants.B4_LOCATION);
                    _staffLine.setEndY(Constants.B4_LOCATION);
                    this.setUpFlat();
                    break;
                }   
            case 11:
                _noteHead.setCenterY(Constants.B4_LOCATION);
                _staffLine.setStartX(Constants.NOTE_X_LOC - Constants.STAFF_LINE_WIDTH/2);
                _staffLine.setEndX(Constants.NOTE_X_LOC + Constants.STAFF_LINE_WIDTH/2);   
                _staffLine.setStartY(Constants.B4_LOCATION);
                _staffLine.setEndY(Constants.B4_LOCATION);
                break;
                    
        }
    }

    /**
     * helper method to set up the accidental image is a sharp
     */
    private void setUpSharp() {
        Image sharp = new Image(this.getClass().getResourceAsStream("Sharp.png"));
        _accidentalImage.setImage(sharp);
        _accidentalImage.setFitHeight(26);
        _accidentalImage.setFitWidth(26);
        _accidentalImage.setX(_noteHead.getCenterX() + Constants.SHARP_X_OFFSET);
        _accidentalImage.setY(_noteHead.getCenterY() + Constants.ACCIDENTAL_Y_OFFSET);
    }

    /**
     * helper method to set up the accidental image as a flat
     */
    private void setUpFlat() {
        Image flat = new Image(this.getClass().getResourceAsStream("Flat.png"));
        _accidentalImage.setImage(flat);
        _accidentalImage.setFitHeight(25);
        _accidentalImage.setFitWidth(12.5);
        _accidentalImage.setX(_noteHead.getCenterX() + Constants.FLAT_X_OFFSET);
        _accidentalImage.setY(_noteHead.getCenterY() + Constants.ACCIDENTAL_Y_OFFSET);
    }

    /**
     * helper method to set up the ledger line
     */
    private void setUpLedger() {
        _ledgerLine = new Line();
        _ledgerLine.setStrokeWidth(Constants.STROKE_WIDTH);
        _staffLine = new Line();
        _staffLine.setStrokeWidth(1);
    }
    /**
     * getter methods for the notehead, ledgerline, staffline, accidental, note (represented by integer), and notename
     */
    public Ellipse getHead() {
        return _noteHead;
    }
    public Line getLedger() {
        return _ledgerLine;
    }
    public Line getStaffLine() {
        return _staffLine;
    }
    public int getNote() {
        return _note;
    }
    public ImageView getAccidental() {
        return _accidentalImage;
    }
    public String getNoteName() {
        switch (_note) {
            case 0:
                return "C";
            case 1:
                // c sharp and d flat are enharmonic tones, so it is necessary to find out which is being used in the chord by 
                // checking the accidental type of the scale
                if (_accidental == 's')
                    return "C sharp";
                else 
                    return "D flat";
            case 2:
                return "D";
            case 3:
                if (_accidental == 's')
                    return "D sharp";
                else 
                    return "E flat";
            case 4:
                return "E";
            case 5:
                return "F";
            case 6:                
                if (_accidental == 's')
                    return "F sharp";
                else 
                    return "G flat";
            case 7:
                return "G";
            case 8:                
                if (_accidental == 's')
                    return "G sharp";
                else 
                    return "A flat";
            case 9:
                return "A";
            case 10:
                if (_accidental == 's')
                    return "A sharp";
                else 
                    return "B flat";
            case 11:
                return "B";
            default:
                return null;
        }


    }
}