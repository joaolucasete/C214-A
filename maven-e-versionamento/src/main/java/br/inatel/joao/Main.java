package br.inatel.joao;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.InputStreamReader;
import java.nio.file.Files;
import java.nio.file.Path;

import com.opencsv.bean.CsvToBeanBuilder;
import br.inatel.joao.model.SellGames;

public class Main {

    public static void main(String[] args) throws FileNotFoundException {
        try {
            var fileReader = new InputStreamReader(Main.class.getClassLoader().getResourceAsStream("vendas-games.csv"));

            var listSellGames = new CsvToBeanBuilder<SellGames>(fileReader)
                    .withType(SellGames.class)
                    .withIgnoreLeadingWhiteSpace(true)
                    .build().parse();

            for (var sellGames : listSellGames) {

                System.out.println("rank: " + sellGames.getRank());
                System.out.println("name: " + sellGames.getName());
                System.out.println("platform: " + sellGames.getPlatform());
                System.out.println("year: " + sellGames.getYear());
                System.out.println("genre: " + sellGames.getGenre());
                System.out.println("publisher: " + sellGames.getPublisher());
                System.out.println("na_sales: " + sellGames.getNa_sales());
                System.out.println("eu_sales: " + sellGames.getEu_sales());
                System.out.println("jp_sales: " + sellGames.getJp_sales());
                System.out.println("other_sales: " + sellGames.getOther_sales());
                System.out.println("global_sales: " + sellGames.getGlobal_sales());
                System.out.println("-----------------------------------------------");
            }
        } catch (Exception e) {
            System.out.println(e.getMessage());

        }

    }
}
