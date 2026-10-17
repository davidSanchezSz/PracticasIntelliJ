//import java.util.Scanner;
//
//public class SportsManager {
//    public static void main(String[] args) {
//
//        Controll.Commands.MatchesList matchList = new Controll.Commands.MatchesList();
//        Controll.Commands.PlayerList playerList = new Controll.Commands.PlayerList();
//        Controll.Commands.Player player = new Controll.Commands.Player(null, null, "Luisa", null, false);
//        Controll.Commands.Player player1 = new Controll.Commands.Player(null, null, "Manuel", null, false);
//        Controll.Commands.Player player2 = new Controll.Commands.Player(null, null, "Kurt", null, false);
//        Controll.Commands.Player player3 = new Controll.Commands.Player(null, null, "Sofia", null, false);
//        Controll.Commands.Player player4 = new Controll.Commands.Player(null, null, "Robert", null, false);
//        playerList.addPlayer(player);
//        playerList.addPlayer(player1);
//        playerList.addPlayer(player2);
//        playerList.addPlayer(player3);
//        playerList.addPlayer(player4);
//        playerList.addScore("Luisa", 4.5);
//        playerList.addScore("Manuel", 2.7);
//        playerList.addScore("Kurt", 4.0);
//        playerList.addScore("Sofia", 3.8);
//        playerList.addScore("Robert", 3.8);
//        Scanner scanner = new Scanner(System.in);
//        String command;
//        System.out.println();
//
//        System.out.println("Ingrese uno de los siguientes comandos: añadir, eliminar, mostrar, añadir_puntuacion, score, mostrar_matchmaking, limpiar_matchmaking, matchmaking, random_matchmaking o exit");
//        System.out.println("Jugadores actuales: ");
//        playerList.show();
//        System.out.println();
//        do {
//            command = scanner.nextLine().trim();
//
//            String[] parts = command.split(" ");
//
//            switch (parts[0]) {
//                case "añadir":
//                    Controll.Commands.Player player5 = new Controll.Commands.Player(null,null,parts[1],null,false);
//                    playerList.addPlayer(player5);
//                    break;
//                case "eliminar":
//                    playerList.remove(parts[1]);
//                    break;
//                case "mostrar":
//                    playerList.show();
//                    break;
//                case "score":
//                    playerList.rank();
//                    break;
//                case "añadir_puntuacion":
//                    String[] scoreParts = parts[1].split(",");
//                    try{playerList.addScore(scoreParts[0], Double.parseDouble(scoreParts[1]));}catch (NumberFormatException error) {
//                        System.out.println("Error");
//                    }
//                    break;
//                case "mostrar_matchmaking":
//                    matchList.showMatchmake();
//                    break;
//                case "limpiar_matchmaking":
//                    matchList.clearMatch();
//                    break;
//                case "matchmaking":
//                    String[] matchParts = parts[1].split(",");
//                    if (playerList.getPlayerByName(matchParts[0]) != null && playerList.getPlayerByName(matchParts[1]) != null) {
//                        Controll.Commands.Player player6 = playerList.getPlayerByName(matchParts[0]);
//                        Controll.Commands.Player player7 = playerList.getPlayerByName(matchParts[1]);
//                        matchList.matchmake(player6, player7);
//                    }else System.out.println("Error");
//                    break;
//                case "random_matchmaking":
//                    matchList.randomMatchmake(playerList);
//                    break;
//                case "exit":
//                    System.out.println("Saliendo.");
//                    break;
//                default:
//                    System.out.println("Comando no valido");
//            }
//        } while (!command.equals("exit"));
//        scanner.close();
//
//    }
//
//}
