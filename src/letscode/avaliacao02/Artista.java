package letscode.avaliacao02;

import static java.lang.Integer.parseInt;

public class Artista {

    private Integer index;
    private Integer year;
    private Integer age;
    private String name;
    private String movie;
    private Sex sex;

    private Artista(Integer index, Integer year, Integer age, String name, String movie, Sex sex) {
        this.index = index;
        this.year = year;
        this.age = age;
        this.name = name;
        this.movie = movie;
        this.sex = sex;
    }

    public static Artista of(String line, Sex sex) {
        String[] split = line.split("; ");
        return new Artista(
                parseInt(split[0]),
                parseInt(split[1]),
                parseInt(split[2]),
                split[3],
                split[4],
                sex
        );
    }

    public Integer getIndex() {
        return index;
    }

    public void setIndex(Integer index) {
        this.index = index;
    }

    public Integer getYear() {
        return year;
    }

    public void setYear(Integer year) {
        this.year = year;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getMovie() {
        return movie;
    }

    public void setMovie(String movie) {
        this.movie = movie;
    }

    public Sex getSex() {
        return sex;
    }

    public void setSex(Sex sex) {
        this.sex = sex;
    }

    public Boolean isFemale() {
        return this.getSex() == Sex.F;
    }

    public Boolean isMale() {
        return this.getSex() == Sex.M;
    }

    public Boolean artistAgeIsBetween(int initialAge, int endAge) {
        return this.getAge() >= initialAge && this.getAge() <= endAge;
    }

    @Override
    public String toString() {
        return "Artista{" +
                "index=" + index +
                ", year=" + year +
                ", age=" + age +
                ", name='" + name + '\'' +
                ", movie='" + movie + '\'' +
                ", sex=" + sex +
                '}';
    }

    enum Sex {
        M,
        F
    }
}
