
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

public class TaskManager {

     private final Path path= Path.of("../task.json");

     List<Task> taskList;

     public TaskManager(){
         ensureFileExists();
         this.taskList=jsonToObject();
     }

     public  void ensureFileExists(){
        if (!Files.exists(path)){
            try {
                Files.createFile(path);
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    public String readJson(){
        try{
            return Files.readString(path).trim();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return "";
    }

    public List<Task> jsonToObject(){
        String content=readJson();
        List<Task> list=new ArrayList<>();
        if (!content.isEmpty()){
            String format=content.replace("]","").replace("[","");
            String da[]=format.split("},");
            for (String daa:da){
                list.add(Task.convertJson(daa));
            }
            return list;
        }
        return list;
    }

    public void addTask(String description) {
         Task task=new Task(description,taskList);
         taskList.add(task);
         System.out.println("Task added successfully (ID: "+task.getId()+")");
    }


    public  void deleteTask(int id){
            Task taskRemove=null;
            for (Task task:taskList){
                if (task.getId()==id){
                    taskRemove=task;
                }
            }
            taskList.remove(taskRemove);
        }

    public  void updateTask(int id, String description) {
        Task taskRemove;
        for (Task task:taskList){
            if (task.getId()==id){
                taskRemove=task;
                taskRemove.setDescription(description);
                taskRemove.setUpdatedAt(LocalDateTime.now());
            }
        }
    }

    public  void markStatus(int id,String status) {
        Task taskRemove;
        for (Task task:taskList){
            if (task.getId()==id){
                taskRemove=task;
                if (status.equals("done")){
                    taskRemove.setStatus(Status.DONE);
                    taskRemove.setUpdatedAt(LocalDateTime.now());
                } else if (status.equals("progress")) {
                    taskRemove.setStatus(Status.IN_PROGRESS);
                    taskRemove.setUpdatedAt(LocalDateTime.now());
                }
            }
        }
    }


    public  void listTask(String status) {
            Status actual;
            if(status.equals("done")){
                actual=Status.DONE;
            } else if (status.equals("todo")) {
                actual=Status.TODO;
            } else if (status.equals("in-progress")) {
                actual=Status.IN_PROGRESS;
            }else {
                actual=null;
            }
            for (Task task : taskList) {
                if(actual==null || task.getStatus()==actual){
                    System.out.println(task.toString());
                }
            }
    }

    public void writeJson(){
        StringBuilder sb=new StringBuilder();
        try {
            if (!taskList.isEmpty()){
                sb.append("[");
                for (int i=0;i<taskList.size();i++){
                    Task task=taskList.get(i);
                    sb.append(task.taskJson().stripTrailing());
                    if(i<taskList.size()-1){
                        sb.append(",");
                    }
                }
                sb.append("\n]");
                Files.writeString(path,sb);
            }else{
                Files.writeString(path,"");
            }
        }catch (IOException e){
            e.printStackTrace();
        }
    }
}

