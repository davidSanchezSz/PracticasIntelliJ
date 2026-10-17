package tennisManager.controller;

import tennisManager.model.objects.Referee;

public class RefereeController extends Controller {

    public void login(String[] arguments){
        model.setCurrentReferee(model.getRefereeList().getItemByName(arguments[1]));
    }

    public void logout(){
        model.setCurrentReferee(null);
    }

    public void createReferee(String[] arguments){
        model.getRefereeList().addItem(new Referee(arguments[1], arguments[2]));
    }
}
