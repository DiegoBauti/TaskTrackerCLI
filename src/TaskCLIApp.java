public class TaskCLIApp {
    public static void main(String[] args)  {
       if(args.length>0){
            TaskManager taskManager=new TaskManager();
            String command=args[0];
            switch (command){
                case "add":
                    if (!args[1].isEmpty()){
                        StringBuilder sb=new StringBuilder();
                        for(int i=1;i<args.length;i++){
                            sb.append(args[i]);
                            if(i< args.length-1){
                                sb.append(" ");
                            }
                        }
                        taskManager.addTask(sb.toString());
                    }
                    break;
                case "delete":
                    if (!args[1].isEmpty()){
                        try {
                            int id=Integer.parseInt(args[1]);
                            taskManager.deleteTask(id);

                        } catch (Exception e) {
                            System.out.println(e);
                        }
                    }
                    break;
                case "update":
                    if (args.length>2){
                        try {
                            int id=Integer.parseInt(args[1]);
                            taskManager.updateTask(id,args[2]);

                        } catch (Exception e) {
                            System.out.println(e);
                        }
                    }
                    break;
                case "mark-in-progress":
                    if (!args[1].isEmpty()){
                        try {
                            int id=Integer.parseInt(args[1]);
                            taskManager.markStatus(id,"progress");

                        } catch (Exception e) {
                            System.out.println(e);
                        }
                    }
                    break;
                case "mark-done":
                    if (!args[1].isEmpty()){
                        try {
                            int id=Integer.parseInt(args[1]);
                            taskManager.markStatus(id,"done");

                        } catch (Exception e) {
                            System.out.println(e);
                        }
                    }
                    break;
                case "list":
                    if (args.length>1){
                        taskManager.listTask(args[1]);
                    }else{
                        taskManager.listTask("");
                    }
                    break;
                default:
                    System.out.println("The command does not exist");
                    break;
            }
           taskManager.writeJson();
       }
    }
}
