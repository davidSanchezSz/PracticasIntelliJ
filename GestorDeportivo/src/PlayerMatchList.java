//package SportsManager;
//
//public class PlayerMatchList extends X<Player>{
//
//}
//    public void randomMatchmake(Controll.Commands.PlayerList playerList){
//        if(playerList.getCapacity()%2 == 0){
//            Controll.Commands.PlayerList auxList = new Controll.Commands.PlayerList();
//            for (int i = 0; i < playerList.getCapacity(); i++) {
//                auxList.addPlayer(playerList.getPlayer(i).getGmail());
//                auxList.addScore(playerList.getPlayer(i).getGmail(), playerList.getPlayer(i).getScore());
//            }
//            this.clearMatch();
//            int i = 0;
//            for (; i < playerList.getCapacity()/2; i++) {
//                Random random = new Random();
//                int randomPlayer1 = random.nextInt(auxList.getCapacity());
//                Player aux = auxList.getPlayer(randomPlayer1);
//                this.matches[this.capacity][0] = aux;
//                auxList.remove(aux.getGmail());
//
//                int randomPlayer2 = random.nextInt(auxList.getCapacity());
//                Player aux2 = auxList.getPlayer(randomPlayer2);
//                this.matches[this.capacity][1] = aux2;
//                auxList.remove(aux2.getGmail());
//
//                this.capacity++;
//            }
//        }else System.out.println("No se pudo emparejar");
//    }