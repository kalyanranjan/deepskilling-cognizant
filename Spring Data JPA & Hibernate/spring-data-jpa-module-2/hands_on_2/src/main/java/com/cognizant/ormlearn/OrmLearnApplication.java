package com.cognizant.ormlearn;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.List;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

import com.cognizant.ormlearn.model.Stock;
import com.cognizant.ormlearn.repository.StockRepository;

@SpringBootApplication
public class OrmLearnApplication {

    private static StockRepository stockRepository;

    public static void main(String[] args) {
        ApplicationContext context = SpringApplication.run(OrmLearnApplication.class, args);
        stockRepository = context.getBean(StockRepository.class);

        testFBSeptember();
        testGoogleAbove1250();
        testTop3Volume();
        testNetflixLowest3();
    }

    private static void testFBSeptember() {
        List<Stock> stocks = stockRepository.findByCodeAndDateBetween("FB", LocalDate.of(2019, 9, 1), LocalDate.of(2019, 9, 30));
        stocks.forEach(System.out::println);
    }

    private static void testGoogleAbove1250() {
        List<Stock> stocks = stockRepository.findByCodeAndCloseGreaterThan("GOOGL", new BigDecimal("1250"));
        stocks.forEach(System.out::println);
    }

    private static void testTop3Volume() {
        List<Stock> stocks = stockRepository.findTop3ByOrderByVolumeDesc();
        stocks.forEach(System.out::println);
    }

    private static void testNetflixLowest3() {
        List<Stock> stocks = stockRepository.findTop3ByCodeOrderByCloseAsc("NFLX");
        stocks.forEach(System.out::println);
    }
}
