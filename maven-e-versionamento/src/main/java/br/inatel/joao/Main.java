package br.inatel.joao;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.InputStreamReader;
import java.lang.reflect.Array;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import com.opencsv.bean.CsvToBeanBuilder;
import br.inatel.joao.model.SellGames;

public class Main {
    public static ArrayList<SellGames> filterByPlatforms(List<SellGames> csv, List<String> platforms) {
        ArrayList<SellGames> filtered = new ArrayList<>();
        for (SellGames game : csv) {
            if (platforms.contains(game.getPlatform())) {
                filtered.add(game);
            }
        }

        return filtered;
    }

    public static ArrayList<SellGames> filterByPublishers(List<SellGames> csv, List<String> publishers) {
        ArrayList<SellGames> filtered = new ArrayList<>();
        for (SellGames game : csv) {
            if (publishers.contains(game.getPublisher())) {
                filtered.add(game);
            }
        }

        return filtered;
    }

    public static void main(String[] args) throws FileNotFoundException {
        try {
            var fileReader = new InputStreamReader(Main.class.getClassLoader().getResourceAsStream("vendas-games.csv"));

            var listSellGames = new CsvToBeanBuilder<SellGames>(fileReader)
                    .withType(SellGames.class)
                    .withIgnoreLeadingWhiteSpace(true)
                    .build().parse();

            for (var sellGames : filterByPlatforms(listSellGames, Arrays.asList("PS4", "PC"))) {
                System.out.println("rank: " + sellGames.getRank());
                System.out.println("name: " + sellGames.getName());
                System.out.println("platform: " + sellGames.getPlatform());
                System.out.println("-----------------------------------------------");
            }

            for (var sellGames : filterByPublishers(listSellGames, Arrays.asList("Sony Computer Entertainment", "Activision"))) {
                System.out.println("rank: " + sellGames.getRank());
                System.out.println("name: " + sellGames.getName());
                System.out.println("publisher: " + sellGames.getPublisher());
                System.out.println("-----------------------------------------------");
            }
        } catch (Exception e) {
            System.out.println(e.getMessage());

        }

    }
}
