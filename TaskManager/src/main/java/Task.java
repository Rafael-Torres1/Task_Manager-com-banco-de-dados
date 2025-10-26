public class Task {

    private int id;
    private String name;
    private String description;
    private String stats;

    public Task(){}

    public Task( String name, String description, String stats){
        this.name = name;
        this.description = description;
        this.stats = stats;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getStats() {
        return stats;
    }

    public void setStats(String stats) {
        this.stats = stats;
    }

    @Override
    public String toString(){
        return "id: "+id+ " | nome: "+name+ " | description: "+description+ "| status: " +stats;
    }
}
