package ChordConstructor;
import javafx.scene.layout.Pane;
import java.util.LinkedList;

/**
* The Key class contains the seven notes, constructed based on the parameters passed in in the ProgressionConstructor class.
*/
public class Key {
    private char _quality;
    private Note _rootNote;
    private Note _secondNote;
    private Note _thirdNote;
    private Note _fourthNote;
    private Note _fifthNote;
    private Note _sixthNote;
    private Note _seventhNote;
    private Note _seventhNoteRaised;
    private LinkedList<Note> _scale;

    /**
     * The constructor takes in the root note, represented by an integer; the accidental of the root noot, represented
     * by a char; the type of accidentals in the key, represented by a char; the quality (major/minor) of the key, 
     * represented by a char; and a pane.
     */
    public Key(int root, char accidental, char typeAccidental, char quality, Pane notePane) {
        _quality = quality;
        // represent the scale by a LinkedList of Notes
        _scale = new LinkedList<Note>();
        _rootNote = new Note(root, accidental, notePane);
        _scale.add(_rootNote);
        // the second note of the scale is two half steps above the root note
        _secondNote = new Note((root + 2)%12, typeAccidental, notePane);
        _scale.add(_secondNote);
        // if the scale is major, the third note is two half steps above; if minor, it's one half step above
        if (quality == 'M') {
            _thirdNote = new Note((_secondNote.getNote() + 2)%12, typeAccidental, notePane);
            _scale.add(_thirdNote);
        } else {
            _thirdNote = new Note((_secondNote.getNote() + 1)%12, typeAccidental, notePane);
            _scale.add(_thirdNote);
        }
        _fourthNote = new Note((_secondNote.getNote() + 3)%12, typeAccidental, notePane);
        _scale.add(_fourthNote);
        _fifthNote = new Note((_fourthNote.getNote() + 2)%12, typeAccidental, notePane);
        _scale.add(_fifthNote);
        if (quality == 'M') {
            _sixthNote = new Note((_fifthNote.getNote() + 2)%12, typeAccidental, notePane);
            _scale.add(_sixthNote);
        } else {
            _sixthNote = new Note((_fifthNote.getNote() + 1)%12, typeAccidental, notePane);
            _scale.add(_sixthNote);
        }
        if (quality == 'M') {
            _seventhNote = new Note((_fifthNote.getNote() + 4)%12, typeAccidental, notePane);
            _scale.add(_seventhNote);
        } else {
            _seventhNote = new Note((_fifthNote.getNote() + 3)%12, typeAccidental, notePane);
            _scale.add(_seventhNote);
            // a minor scale requires a regular seventh for the seven chord and the raised seven for the three and five chords
            _seventhNoteRaised = new Note((_fifthNote.getNote() + 4)%12, typeAccidental, notePane);
            _scale.add(_seventhNoteRaised);
        }
    }
    /**
     * get the x note of the scale
     */
    public Note getNote(int x) {
        return _scale.get(x - 1);
    }
    public char getQuality() {
        return _quality;
    }
    public LinkedList<Note> getList() {
        return _scale;
    }
}