package by.nikolay;


import java.util.Objects;

public class Technology {
    private String name;
    private String discription;

    public Technology() {
    }

    public Technology(String name, String discription) {
        this.name = name;
        this.discription = discription;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDiscription() {
        return discription;
    }

    public void setDiscription(String discription) {
        this.discription = discription;
    }

    @Override
    public String toString() {
        return "Technology{" +
                "name='" + name + '\'' +
                ", discription='" + discription + '\'' +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Technology that)) return false;
        return Objects.equals(name, that.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name);
    }
}
