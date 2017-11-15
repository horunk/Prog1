package Practice7;

public class Athlete {
    private String name;
    private Double result;

    public Athlete(String name, double result) {
        this.setName(name);
        this.setResult(result);
    }

    @Override
    public String toString() {
        return String.format("Athlete %s, has a record of %.2f", getName(), getResult());
    }


    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Double getResult() {
        return result;
    }

    public void setResult(Double result) {
        this.result = result;
    }
}
