package br.inatel.joao;

import java.io.FileNotFoundException;
import java.io.Reader;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import com.opencsv.bean.CsvToBeanBuilder;
import br.inatel.joao.model.Games;

public class Main {
    public static ArrayList<Games> filterByPlatforms(List<Games> csv, List<String> platforms) {
        ArrayList<Games> filtered = new ArrayList<>();
        for (Games game : csv) {
            if (platforms.contains(game.getPlatform())) {
                filtered.add(game);
            }
        }

        return filtered;
    }

    public static ArrayList<Games> filterByPublishers(List<Games> csv, List<String> publishers) {
        ArrayList<Games> filtered = new ArrayList<>();
        for (Games game : csv) {
            if (publishers.contains(game.getPublisher())) {
                filtered.add(game);
            }
        }

        return filtered;
    }

    public static void main(String[] args) throws FileNotFoundException {
        List<Games> listGames;

        try {
            listGames = new CsvToBeanBuilder<Games>(Files.newBufferedReader(Paths.get(ClassLoader.getSystemResource("vendas-games.csv").toURI())))
                    .withType(Games.class)
                    .withIgnoreLeadingWhiteSpace(true)
                    .build().parse();
        } catch (Exception e) {
            throw new FileNotFoundException();
        }

        filterByPlatforms(listGames, Arrays.asList("PS4", "PC"))
                .forEach(g -> System.out.println("Name: " + g.getName()));

        System.out.println("-----------------------------------------------");

        filterByPublishers(listGames, Arrays.asList("Sony Computer Entertainment", "Activision"))
                .forEach(g -> System.out.println("Name: " + g.getName()));

        System.out.println("-----------------------------------------------");

    }
}
