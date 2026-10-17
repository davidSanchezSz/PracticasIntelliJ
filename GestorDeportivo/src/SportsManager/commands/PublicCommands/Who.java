//package SportsManager.commands.PublicCommands;
//
//import SportsManager.Model.Model;
//
//public class Who implements PublicCommandsInterface {
//
//    public void execute(String[] arguments, Model model){
//        if(argumentsNeeded(arguments) && model.getCurrentUser() != null){
//            System.out.println(model.getCurrentUser().getEmail() + " " + model.getCurrentUser().getPassword());
//        }
//
//    }
//
//    public boolean argumentsNeeded(String[] arguments) {
//        return arguments.length == 1;
//    }
//
//}
