package cinema.dto;

public class SoldResponse {
    private String error = "The ticket has been already purchased!";

    public SoldResponse(String error) {
        this.error = error;
    }

    public String getError() {
        return error;
    }

    public void setError(String error) {
        this.error = error;
    }

    public SoldResponse() {
    }
}
