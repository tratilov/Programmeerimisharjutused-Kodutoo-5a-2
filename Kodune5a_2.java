

import java.util.ArrayList;
import java.util.List;

/*****************************************************************************
 * Programmeerimisharjutused. LTAT.03.007
 * 2019/2020 kevadsemester
 *
 * Kodutöö. Ülesanne nr 5a-2.
 * Teemad:
 *              sõned.
 *
 * Autor: Tatjana Ratilovskaja
 *
 * Kasutab andmefaili temperatuurid2018.txt
 *
 *****************************************************************************/

public class Kodune5a_2 {
    // Meetod kordusgruppide eemaldamiseks sõnes.
    public static int kaashäälikuühendeid(String sõne) {
        StringBuilder uusSõne = new StringBuilder().append(sõne);
        List<Character> kaashäälikud = new ArrayList<>();
        char[] massiiv = {'b', 'c', 'd', 'f', 'g', 'h', 'j', 'k', 'l', 'm', 'n', 'p', 'q', 'r', 's', 'š', 'z', 'ž', 't', 'v', 'w', 'x', 'y'};
        for (Character sümbol : massiiv) {
            kaashäälikud.add(sümbol);
        }

        String sõne1 = sõne.toLowerCase();
        int kokku = 0;
        int i = 0;

        while (i < uusSõne.length()) {
            char sümbol = sõne1.charAt(i);
            int kõrvalKaashäälikuid = 0;
            int j = i+1;
            if (kaashäälikud.contains(sümbol)){
                while (j < sõne1.length()){
                    if (kaashäälikud.contains(sõne1.charAt(j))){
                        j++;
                        kõrvalKaashäälikuid++;
                    }
                    else{
                        break;
                    }
                }
            }
            if (kõrvalKaashäälikuid != 0){
                kokku++;
                i += kõrvalKaashäälikuid;
            }
            else i++;
        }
        return kokku;
    }

    public static void main(String[] args) {
        System.out.println("Kodutöö nr 5a-2.                        Programmi väljund");
        System.out.println("=".repeat(57) + ":");
        System.out.println();

        System.out.println("Kaashäälikuühendeid tekstis \"Mait Malmsten kehastus korstnapühkijaks\" on : "+
                kaashäälikuühendeid("Mait Malmsten kehastus korstnapühkijaks"));
        System.out.println();
        System.out.println("Kaashäälikuühendeid tekstis \"MaitMalmstenkehastuskorstnapühkijaks\" on : "+
                kaashäälikuühendeid("\"MaitMalmstenkehastuskorstnapühkijaks"));

        System.out.println("\n" + "=".repeat(57) + ".");
        System.out.println("Tatjana Ratilovsakaja             "
                + new java.sql.Timestamp(System.currentTimeMillis()));
    }
}