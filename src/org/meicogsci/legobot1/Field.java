package org.meicogsci.legobot1;

public class Field {

    public FieldType type;
    
    public int certainty;

    public Field() {
        this.type = FieldType.UNKNOWN;
        this.certainty = 100;
    }
    
    public char getChar() {
        char out = ' '; //─│┌┐└┘▒
        if (type.equals(FieldType.HORIZONTAL_WALL)) {
            out = '─';
        }
        if (type.equals(FieldType.VERTICAL_WALL)) {
            out = '│';
        }
        if (type.equals(FieldType.CORNER_LD)) {
            out = '┐';
        }
        if (type.equals(FieldType.CORNER_RD)) {
            out = '┌';
        }
        if (type.equals(FieldType.CORNER_LU)) {
            out = '┘';
        }
        if (type.equals(FieldType.CORNER_RU)) {
            out = '└';
        }
        if (type.equals(FieldType.UNKNOWN)) {
            out = '▒';
        }
        if (type.equals(FieldType.POSITION)) {
            out = 'X';
        }
        return out;
    }
}
