package Case;

import Strumienie.Auto;

import javax.swing.*;
import java.io.FileWriter;
import java.io.IOException;
import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class SystemZajecia {

    public static List<Przedmioty> listaPrzedmiotow = new ArrayList<Przedmioty>();

    public static void main(String[] args) throws IOException {

        int ECTSDoWydania = 7;
        int dostepneECTS = ECTSDoWydania;
        List<Integer> listaPrzedmiotowZapisanych = new ArrayList<Integer>();
        int doplata_Ects = 150;
        int doplata_Suma = 0;
        int nadwyzkaECTS = 0;
        listaPrzedmiotow.add(new Przedmioty("Algebra","Aleksander Brzeziński",3,"Poniedziałek",14,"304"));
        listaPrzedmiotow.add(new Przedmioty("Matematyka","Agnieszka Bogdewicz",3,"Poniedziałek",14,"12"));
        listaPrzedmiotow.add(new Przedmioty("Bazy danych","Dariusz Gotlib",2,"Poniedziałek",8,"45"));
        listaPrzedmiotow.add(new Przedmioty("Geostatystyka","Robert Olszewski",1,"Poniedziałek",16,"aula II"));
        listaPrzedmiotow.add(new Przedmioty("Programowanie w Java","Remigiusz Rajtner",4,"Poniedziałek",18,"220"));
        listaPrzedmiotow.add(new Przedmioty("Analiza matematyczna","Grzegorz Sójka",2,"Wtorek",10,"304"));
        listaPrzedmiotow.add(new Przedmioty("Modelowanie kartograficzne","Sylwia Marczak",3,"Wtorek",12,"302"));
        listaPrzedmiotow.add(new Przedmioty("GIS w Internecie","Anna Fiedukowicz",1,"Wtorek",14,"45"));
        listaPrzedmiotow.add(new Przedmioty("Analizy przestrzenne","Sebastian Różycki",2,"Wtorek",16,"220"));
        listaPrzedmiotow.add(new Przedmioty("Podstawy SQL","Dariusz Gotlib",3,"Wtorek",18,"aula III"));
        listaPrzedmiotow.add(new Przedmioty("Smart Cities","Robert Olszewski",2,"Środa",8,"304"));
        listaPrzedmiotow.add(new Przedmioty("Grawimetria","Tomasz Olejak",2,"Środa",10,"12"));
        listaPrzedmiotow.add(new Przedmioty("Fotogrametria","Zdzisław Kurczyński",3,"Środa",12,"4"));
        listaPrzedmiotow.add(new Przedmioty("Geofizyka","Michał Kruczyk",1,"Środa",14,"12"));
        listaPrzedmiotow.add(new Przedmioty("Cyfrowe Przetwarzanie Obrazów","Jakub Markiewicz",1,"Środa",16,"245"));
        listaPrzedmiotow.add(new Przedmioty("Podstawy C++","Zbigniew Kożuszek",1,"Czwartek",18,"4"));
        listaPrzedmiotow.add(new Przedmioty("BIM","Michał Wyszomirski",2,"Czwartek",8,"304"));
        listaPrzedmiotow.add(new Przedmioty("FTP","Jakub Markiewicz",3,"Czwartek",10,"aula II"));
        listaPrzedmiotow.add(new Przedmioty("Bazy danych przestrzennych","Dariusz Gotlib",2,"Czwartek",12,"302"));
        listaPrzedmiotow.add(new Przedmioty("Data mining","Robert Olszewski",1,"Czwartek",14,"aula I"));
        listaPrzedmiotow.add(new Przedmioty("Matematyka w biznesie","Grzegorz Sójka",1,"Piątek",16,"4"));
        listaPrzedmiotow.add(new Przedmioty("Python","Remigiusz Rajtner",2,"Piątek",18,"12"));
        listaPrzedmiotow.add(new Przedmioty("Analiza matematyczna II","Agnieszka Bogdewicz",1,"Piątek",8,"304"));
        listaPrzedmiotow.add(new Przedmioty("Zaawansowany SQL","Dariusz Gotlib",3,"Piątek",10,"220"));
        listaPrzedmiotow.add(new Przedmioty("AutoCAD","Michał Wyszomirski",4,"Piątek",16,"20"));

        System.out.println("Masz "+ listaPrzedmiotow.size() + " przedmiotów do wyboru");

        Boolean flagaKoniec=false;
        Scanner sc = new Scanner(System.in);

        while(!flagaKoniec) {
            System.out.println("Naciśnij: 1 jeśli chcesz wyszukać przedmiot, 2 jeśli chcesz dodać przedmiot, 3 aby zakończyć układanie planu");
            try {
                int decyzja = sc.nextInt();
                if (decyzja==1) {
                    System.out.println("Zapytamy się teraz Ciebie po czym chcesz filtrować. Możesz wpisać tylko jeden element. Możesz też nie wpisywać żadnego");
                    sc.nextLine();
                    System.out.println("Nazwa przedmiotu");
                    String nazwaWysz = sc.nextLine();
                    System.out.println("Prowadzący");
                    String prowadzacyWysz = sc.nextLine();
                    System.out.println("Dzień tygodnia - z wielkiej litery i polskimi znakami");
                    String dzienWysz = sc.nextLine();
                    System.out.println("Godzina");
                    String godzinaWysz = sc.nextLine();
                    System.out.println("Filtrujesz po następujących parametrach: " + nazwaWysz + " " + prowadzacyWysz + " " + dzienWysz + " " + godzinaWysz);
                    wyszukiwanie(listaPrzedmiotow, nazwaWysz, prowadzacyWysz, dzienWysz, godzinaWysz);
                }
                else if (decyzja==2) {
                    System.out.println("Podaj nazwę przedmiotu, który chcesz dodać do Twojego planu");
                    sc.nextLine();
                    String wybranyprzedmiot = sc.nextLine();
                    OptionalInt l = IntStream.range(0, listaPrzedmiotow.size())
                            .filter(i -> (listaPrzedmiotow.get(i).getNazwa()).toUpperCase().equals(wybranyprzedmiot.toUpperCase()))
                            .findFirst();

                    Boolean czynakladasie = sprawdzanienakladania(listaPrzedmiotow, listaPrzedmiotowZapisanych, l.getAsInt());

                    if (listaPrzedmiotowZapisanych.contains(l.getAsInt())) {
                        System.out.println("Masz już ten przedmiot w planie");
                    }
                    else if (czynakladasie){
                        System.out.println("W tym czasie masz inny przedmiot");
                    }

                    else{
                        listaPrzedmiotowZapisanych.add(l.getAsInt());
                        dostepneECTS -= listaPrzedmiotow.get(l.getAsInt()).getLiczbaEcts();
                        if (dostepneECTS < 0)
                        {
                            nadwyzkaECTS = Math.abs(dostepneECTS);
                            doplata_Suma = doplata_Ects * (Math.abs(dostepneECTS));
                            System.out.println("Zapisany jesteś na " + listaPrzedmiotowZapisanych.size() + ". Dostępne ECTS: 0. Nadpłata: " + doplata_Suma);
                        }
                        else
                        {
                            System.out.println("Zapisany jesteś na " + listaPrzedmiotowZapisanych.size() + ". Dostępne ECTS: " + dostepneECTS);
                        }
                    }
                }
                else if (decyzja==3) {
                    System.out.println("Wskaż folder do zapisu pliku");
                    zapispliku(listaPrzedmiotow,listaPrzedmiotowZapisanych,doplata_Suma, nadwyzkaECTS);
                    flagaKoniec=true;
                }
                else {
                    System.out.println("Nie ma takiej komendy");
                }
            } catch (InputMismatchException e) {
                System.out.println("Wygląda na to, że wpisałem coś innego niż żądane wartości. Spróbuj jeszcze raz");
                sc.nextLine();
            } catch (Exception e) {
                System.out.println("Coś poszło nie tak. Spróbuj jeszcze raz");
                sc.nextLine();
            }
        }

    }

    static void wyszukiwanie(List<Przedmioty> listaPrzedmiotow, String nazwaW, String prowW, String dzienW, String godzW) {
        listaPrzedmiotow.stream()
                .filter(przedmiot -> przedmiot.getNazwa().contains(nazwaW) && przedmiot.getProwadzacy().contains(prowW) &&
                        przedmiot.getDzienTygodnia().contains(dzienW) && new Integer(przedmiot.getGodzina()).toString().contains(godzW))
                .map(przedmiot -> przedmiot.toString())
                .forEach(System.out::println);
    }

    static boolean sprawdzanienakladania(List<Przedmioty> listaPrzedmiotow, List<Integer> wybrane, int przedmiotdosprawdzenia){

        boolean flaga=false;
        String dziendosprawdzenia = listaPrzedmiotow.get(przedmiotdosprawdzenia).getDzienTygodnia();
        int godzinadosprawdzenia = listaPrzedmiotow.get(przedmiotdosprawdzenia).getGodzina();

        for (int i:wybrane){
            if (listaPrzedmiotow.get(i).getDzienTygodnia() == dziendosprawdzenia && listaPrzedmiotow.get(i).getGodzina() == godzinadosprawdzenia)
            {
                flaga=true;//pokrywają się
            }
        }

        return flaga;
    }

    static boolean zapispliku(List<Przedmioty> listaPrzedmiotow, List<Integer> wybrane, int doplata, int nadwyzkaECTS) {

        List<Przedmioty> listatmp = new ArrayList<Przedmioty>();//lista z obiektami, a nie indeksami
        for (int i:wybrane){
            listatmp.add(listaPrzedmiotow.get(i));
        }

        JFileChooser f = new JFileChooser();
        f.setFileSelectionMode(JFileChooser.DIRECTORIES_ONLY);
        f.showSaveDialog(null);
        System.out.println("Trwa zapisywanie...");

        String path = f.getSelectedFile().getAbsolutePath().toString() + "\\planZajec.txt";
        FileWriter filewriter = null;


        try {
            filewriter = new FileWriter(path);

            FileWriter finalFilewriter = filewriter;

            long pnCount= listatmp.stream().filter(przedmiot -> przedmiot.getDzienTygodnia().contains("Poniedziałek")).count();
            long wtCount= listatmp.stream().filter(przedmiot -> przedmiot.getDzienTygodnia().contains("Wtorek")).count();
            long srCount= listatmp.stream().filter(przedmiot -> przedmiot.getDzienTygodnia().contains("Środa")).count();
            long czwCount= listatmp.stream().filter(przedmiot -> przedmiot.getDzienTygodnia().contains("Czwartek")).count();
            long ptCount= listatmp.stream().filter(przedmiot -> przedmiot.getDzienTygodnia().contains("Piątek")).count();

            String dzientygodnia;
            if (pnCount!=0) {
                filewriter.write("PONIEDZIAŁEK:" + System.getProperty("line.separator"));
                dzientygodnia = "Poniedziałek";
                zapis2(listatmp, finalFilewriter, dzientygodnia);
            }
            if (wtCount!=0) {
                filewriter.write("WTOREK:" + System.getProperty("line.separator"));
                dzientygodnia = "Wtorek";
                zapis2(listatmp, finalFilewriter, dzientygodnia);
            }
            if (srCount!=0) {
                filewriter.write("ŚRODA:" + System.getProperty("line.separator"));
                dzientygodnia = "Środa";
                zapis2(listatmp, finalFilewriter, dzientygodnia);
            }
            if (czwCount!=0) {
                filewriter.write("CZWARTEK:" + System.getProperty("line.separator"));
                dzientygodnia = "Czwartek";
                zapis2(listatmp, finalFilewriter, dzientygodnia);
            }
            if (ptCount!=0) {
                filewriter.write("PIĄTEK:" + System.getProperty("line.separator"));
                dzientygodnia = "Piątek";
                zapis2(listatmp, finalFilewriter, dzientygodnia);
            }

            if (doplata !=0) {
                filewriter.write("***DOPŁATA***" + System.getProperty("line.separator"));
                filewriter.write("Przekroczono " + nadwyzkaECTS + " ECTS, za co zostaje naliczona opłata " + doplata + " zł. Jeżeli chcesz, aby opłata została potrącona ze stypendium Rektora, skontaktuj się z dziekanatem.");
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        finally{
            if(filewriter!=null)
            {
                try {
                    filewriter.close();
                } catch (IOException e) {
                    e.printStackTrace();
                    System.out.println("Błąd podczas zapisu pliku");
                }
                System.out.println("Utworzono plik z planem zajęć w " + f.getSelectedFile().getAbsolutePath());
            }
        }
        return true;
    }
    static void zapis2(List<Przedmioty> listatmp,FileWriter finalFilewriter, String dzientygodnia) {
        listatmp.stream()
                .filter(przedmiot -> przedmiot.getDzienTygodnia().contains(dzientygodnia))
                .sorted(Comparator.comparing(Przedmioty::getGodzina))
                .map(przedmiot -> przedmiot.toStringFormal())
                .forEach(przedmiot -> {
                    try {
                        finalFilewriter.write(przedmiot);
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                });
    }

}