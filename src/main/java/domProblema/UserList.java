package domProblema;

import datos.FileManager;

import java.util.ArrayList;

public class UserList {

    private static ArrayList<User> users = new ArrayList<>();

    public static ArrayList<User> getUsers() {

        return users;
    }

    public static User findUserByRut(String rut) {
        for (int i = 0; i < users.size(); i++) {
            if (users.get(i).getRut().equalsIgnoreCase(rut)) {
                return users.get(i);
            }
        }
        return null;
    }

    public static void setUsers(ArrayList<User> users) {
        UserList.users = users;
    }

    public static void addUser(ArrayList<Bike> bikes, String eMail, String name, String rut, String phone, int warnings) {
        users.add(new User(bikes, eMail, name, rut, phone, warnings));
    }

    public static void deleteUserByRut(String rut) {
        for (int i = 0; i < users.size(); i++) {
            if (users.get(i).getRut().equalsIgnoreCase(rut)) {
                users.remove(i);
            }
        }
    }

    public static void loadUsers() {
try{
        int j = 1;
        String datosUser = "Bicicletas;Email;Nombre;Rut;Numero;Advertencias";
        String userText = FileManager.readCreate("users.csv", datosUser);

        String datosBike = "Marca;Color";
        String bikeText = FileManager.readCreate("bikes.csv", datosBike);

        String[] userSplit = userText.split("\n");
        String[] bikeSplit = bikeText.split("\n");

        for (int i = 1; i < userSplit.length; i++) {

            ArrayList<Bike> bikesTemp = new ArrayList<>();
            String[] userSplitTemp = userSplit[i].split(";");
            int bikeCounter = 0;
            int userBikes = Integer.parseInt(userSplitTemp[0]);

            while (bikeCounter < userBikes) {
                String[] bikeSplitTemp = bikeSplit[j].split(";");
                String marca = bikeSplitTemp[0];
                String color = bikeSplitTemp[1];
                Bike tempBike = new Bike(marca, color);
                bikesTemp.add(tempBike);

                bikeCounter++;
                j++;
            }
            String email = userSplitTemp[1];
            String nombre = userSplitTemp[2];
            String rut = userSplitTemp[3];
            String numero = userSplitTemp[4];
            userSplitTemp[5] = userSplitTemp[5].trim();
            int advertencia = Integer.parseInt(userSplitTemp[5]);

            User userTemp = new User(bikesTemp, email, nombre, rut, numero, advertencia);
            users.add(userTemp);

        }
}
catch(Exception e){
    loadUsers();
}
    }

    public static void writeUsers() {
        String datosUser = "Bicicletas;Email;Nombre;Rut;Numero;Advertencias";
        String datosBike = "Marca;Color";
        for (int i = 0; i < users.size(); i++) {
            int bikeCounter = 0;
            int cantBicicletas = users.get(i).getBikes().size();
            String bicicletas = "" + cantBicicletas;
            String email = users.get(i).geteMail();
            String nombre = users.get(i).getName();
            String rut = users.get(i).getRut();
            String numero = users.get(i).getPhone();
            String advertencia = "" + users.get(i).getWarnings();

            datosUser = datosUser + "\n" + bicicletas+ ";"+ email+ ";" + nombre+ ";" + rut+ ";" + numero+ ";" + advertencia;

            while (bikeCounter < cantBicicletas) {
                String marca = users.get(i).getBikes().get(bikeCounter).getBrand();
                String color = users.get(i).getBikes().get(bikeCounter).getColor();
                datosBike = datosBike + "\n" +marca + ";"+color;
                bikeCounter++;
                
            }
        }
        FileManager.writeFile("users.csv", datosUser);
        FileManager.writeFile("bikes.csv", datosBike);

    }
}


/*
public static void loadUsers() {
        int j = 1;
        String datosUser = "Bicicletas;Email;Nombre;Rut;Numero;Advertencias";
        String userText = FileManager.readCreate("users.csv", datosUser);

        String datosBike = "Marca;Color";
        String bikeText = FileManager.readCreate("bikes.csv", datosBike);

        String[] userSplit = userText.split("\n");
        String[] bikeSplit = bikeText.split("\n");

        for (int i = 1; i < userSplit.length; i++) {
            ArrayList<Bike> bikesTemp = new ArrayList<>();
            String[] userSplitTemp = userSplit[i].split(";");
            int bikeCounter = 0;
            int userBikes = Integer.parseInt(userSplitTemp[0]);

            while (bikeCounter < userBikes) {
                String[] bikeSplitTemp = bikeSplit[i].split(";");
                String marca = bikeSplitTemp[0];
                String color = bikeSplitTemp[1];
                Bike tempBike = new Bike(marca, color);
                bikesTemp.add(tempBike);

                j++;
            }
            String email = userSplitTemp[1];
            String nombre = userSplitTemp[2];
            String rut = userSplitTemp[3];
            String numero = userSplitTemp[4];
            int advertencia = Integer.parseInt(userSplitTemp[5]);
            
            User userTemp = new User(bikesTemp, email, nombre, rut, numero, advertencia);
            users.add(userTemp);
        }
 */
