package lab1.sportprenos.model;

public class Team {
    private Long id;
    private String name;
    private String country;
    private String coach;
    private Integer foundedYear;

    public Team(Long id, String name, String country, String coach, Integer foundedYear) {
        this.id = id;
        this.name = name;
        this.country = country;
        this.coach = coach;
        this.foundedYear = foundedYear;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public String getCoach() {
        return coach;
    }

    public void setCoach(String coach) {
        this.coach = coach;
    }

    public Integer getFoundedYear() {
        return foundedYear;
    }

    public void setFoundedYear(Integer foundedYear) {
        this.foundedYear = foundedYear;
    }
}


