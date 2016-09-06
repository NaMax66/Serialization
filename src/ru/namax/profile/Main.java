package ru.namax.profile;

import javax.swing.*;
import java.io.*;
import java.util.ArrayList;

/**
 * Created by Naidovich on 02.09.2016.
 */
public class Main {

    private static ArrayList<Profile> profiles = new ArrayList<>();

    public static void main(String[] args) {


        profiles = (ArrayList<Profile>)
                deserData("profiles");
        System.out.println(profiles.size());
        Profile profile = new Profile();
        profile.setName(JOptionPane.showInputDialog(null, "Введите ваше имя"));
        profile.setSurname(JOptionPane.showInputDialog(null, "Введите ваше фамилию"));
        profiles.add(profile);

        for (Profile p : profiles)
        {
            System.out.println(p.getName() + " " + p.getSurname());
        }
        System.out.println(profiles.size());
        serData("profiles", profiles);
    }

    private static void serData(String file_name, Object obj) {

        try {
            FileOutputStream fileOut = new FileOutputStream(file_name+".ser");
            ObjectOutputStream objOut = new ObjectOutputStream(fileOut);
            objOut.writeObject(obj);
            fileOut.close();
            objOut.close();
        }
        catch (FileNotFoundException e)
        {
            System.out.println("File Not Found");
            System.exit(1);
        } catch (IOException e) {
            e.printStackTrace();
            System.out.println("Ошибка ввода вывода");
            System.exit(2);
        }


    }


    private static Object deserData(String file_name) {

        Object retObj = null;

        try {
            FileInputStream fileIn = new FileInputStream(file_name+".ser");
            ObjectInputStream objIn = new ObjectInputStream(fileIn);
            retObj = objIn.readObject();
            fileIn.close();
            objIn.close();
        }
        catch (FileNotFoundException e)
        {
            System.out.println("File Not Found");
            System.exit(1);
        } catch (IOException e) {
            e.printStackTrace();
            System.out.println("Ошибка ввода вывода");
            System.exit(2);
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }

        return retObj;
    }

  
}
