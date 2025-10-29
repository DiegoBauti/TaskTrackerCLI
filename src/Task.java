import java.time.LocalDateTime;
import java.util.List;

public class Task {
    private int id;
    private String description;
    private Status status;
    private LocalDateTime createdAt;
    private LocalDateTime updatedAt;

    public Task() {
    }

    public Task(String title,List<Task> list) {
        this.id=generateId(list);
        this.description=title;
        this.status=Status.TODO;
        this.createdAt=LocalDateTime.now();
        this.updatedAt=LocalDateTime.now();
    }

    public int getId() {
        return id;
    }
    public void setId(int id) {
        this.id = id;
    }
    public String getDescription() {
        return description;
    }
    public void setDescription(String description) {
        this.description = description;
    }
    public Status getStatus() {
        return status;
    }
    public void setStatus(Status status) {
        this.status = status;
    }
    public LocalDateTime getCreatedAt() {
        return createdAt;
    }
    public void setCreatedAt(LocalDateTime createdAt) {
        this.createdAt = createdAt;
    }
    public LocalDateTime getUpdatedAt() {
        return updatedAt;
    }
    public void setUpdatedAt(LocalDateTime updatedAt) {
        this.updatedAt = updatedAt;
    }

    public String taskJson(){
        return "\n\t{" +
                "\n\t\t\"id\": "+this.id+","+
                "\n\t\t\"description"+"\": "+"\""+this.description+"\""+","+
                "\n\t\t\"status"+"\": "+"\""+this.status+"\""+","+
                "\n\t\t\"createdAt"+"\": "+"\""+this.createdAt+"\""+","+
                "\n\t\t\"updatedAt"+"\": "+"\""+this.updatedAt+"\""+ "\n\t}";
    }

    public static Task convertJson(String json){
        String part[]=json.replace("\"","").replace("}","").split(",");
        String id[]=part[0].split(":");
        String description[]=part[1].split(":");
        String status[]=part[2].split(":");
        String createdAt[]=part[3].split(":",2);
        String updatedAt[]=part[4].split(":",2);

        Task task=new Task();
        task.setId(Integer.parseInt(id[1].trim()));
        task.setDescription(description[1].trim());
        task.setStatus(Status.valueOf(status[1].trim()));
        task.setCreatedAt(LocalDateTime.parse(createdAt[1].trim()));
        task.setUpdatedAt(LocalDateTime.parse(updatedAt[1].trim()));

        return task;
    }

    public int generateId(List<Task> list){
        int max=0;
        if (!list.isEmpty()){
            for (Task task : list) {
                if (max<task.getId()) {
                    max= task.getId();
                }
            }
            return max+1;
        }
            return 1;

    }
}
