package cinema.dto;

public class BuyTicket {
    private int row;
    private int column;

    public int getRow() {
        return row;
    }

    public void setRow(int row) {
        this.row = row;
    }

    public int getColumn() {
        return column;
    }

    public void setColumn(int column) {
        this.column = column;
    }

    public BuyTicket() {
    }

    public BuyTicket(int row, int column) {
        this.row = row;
        this.column = column;
    }
}
