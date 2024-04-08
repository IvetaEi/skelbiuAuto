import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.IFactoryAnnotation;
import org.testng.annotations.Test;

import java.util.List;
import java.util.concurrent.TimeUnit;

public class codeTestingSkelbiu {
    WebDriver driver;

    @BeforeTest
    public void setUp() {
        ChromeOptions options = new ChromeOptions();
        driver = new ChromeDriver();
        driver.manage().window().maximize();
//        options.addArguments("--headless");
        driver.get("https://m.skelbiu.lt/");
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        driver.findElement(By.id("onetrust-accept-btn-handler")).click();
    }

    public void printIDs() {
        var elements = driver.findElements(By.className("standard-list-item"));
        for (int i =0; i < elements.stream().count(); i++) {
        var element = elements.get(i);
        System.out.println(element.getAttribute("data-item-id"));
         }
    }

    @Test//Kepures su snapeliu
    public void caps() {
        driver.get("https://www.skelbiu.lt/skelbimai/?autocompleted=1&keywords=kepure+su+snapeliu&cities=0&distance=0&mainCity=0&search=1&category_id=4353&user_type=0&ad_since_min=0&ad_since_max=0&visited_page=1&orderBy=-1&detailsSearch=0");
        WebElement number = driver.findElement(By.xpath("//*[@id=\"body-container\"]/div[2]/div[1]/ul/li[1]/span"));
        String numberValue = number.getText();
        numberValue = numberValue.replaceAll("[^-?0-9]+", "");
        System.out.println("Iš viso kepurių su snapeliu skelbimų yra: " + numberValue);
        if (Integer.valueOf(numberValue) > 0) {
            System.out.println("Skelbimų ID:");
        }else{
            System.out.println("Skelbimų nėra");
        }
        printIDs();


        var pageNumbers = driver.findElements(By.className("pagination_link"));
        for (int i = 0; i < pageNumbers.stream().count() - 1; i++) {
            var next = driver.findElement(By.linkText("»"));
            next.click();
            printIDs();
        }
    }

    @Test//Traktoriai
    public void tractors() {
        System.out.println("");
        System.out.println("");
        driver.get("https://www.skelbiu.lt/skelbimai/?autocompleted=1&keywords=traktorius+22kw&cost_min=&cost_max=&type=0&condition=&cities=0&distance=0&mainCity=0&search=1&category_id=1&user_type=0&ad_since_min=0&ad_since_max=0&visited_page=1&orderBy=-1&detailsSearch=0");
        WebElement number = driver.findElement(By.xpath("//*[@id=\"body-container\"]/div[2]/div[1]/ul/li[1]/span"));
        String numberValue = number.getText();
        numberValue = numberValue.replaceAll("[^-?0-9]+", "");
        System.out.println("Iš viso traktorių skelbimų yra: "+ numberValue);
        if (Integer.valueOf(numberValue) > 0) {
            System.out.println("Skelbimų ID:");
        }else{
            System.out.println("Skelbimų nėra");
        }

        var elements = driver.findElements(By.className("standard-list-item"));
        for (int i =0; i < elements.stream().count(); i++) {
            var element = elements.get(i);
            System.out.println(element.getAttribute("data-item-id"));
        }
    }

    @Test//Samotines plytos
    public void tiles() {
        driver.get("https://www.skelbiu.lt/skelbimai/?autocompleted=1&keywords=samotines+plytos&cost_min=&cost_max=&type=0&cities=0&distance=0&mainCity=0&search=1&category_id=2&user_type=0&ad_since_min=0&ad_since_max=0&visited_page=1&orderBy=-1&detailsSearch=0");
        WebElement number = driver.findElement(By.xpath("//*[@id=\"body-container\"]/div[2]/div[1]/ul/li[1]/span"));
        String numberValue = number.getText();
        numberValue = numberValue.replaceAll("[^-?0-9]+", "");
        System.out.println("Iš viso šamotinių plytų skelbimų yra: " + numberValue);
        if (Integer.valueOf(numberValue) > 0) {
            System.out.println("Skelbimų ID:");
        }else{
            System.out.println("Skelbimų nėra");
        }
        printIDs();


        var pageNumbers = driver.findElements(By.className("pagination_link"));
        for (int i = 0; i < pageNumbers.stream().count() - 1; i++) {
            var next = driver.findElement(By.linkText("»"));
            next.click();
            printIDs();
        }
    }

    @Test//Drakono kiausiniai
    public void dragonBalls() {
        driver.get("https://www.skelbiu.lt/skelbimai/?autocompleted=1&keywords=drakono+kiausinis&cost_min=&cost_max=&type=0&cities=0&distance=0&mainCity=0&search=1&category_id=0&user_type=0&ad_since_min=0&ad_since_max=0&visited_page=1&orderBy=-1&detailsSearch=0");
        WebElement number = driver.findElement(By.xpath("//*[@id=\"body-container\"]/div[2]/div[1]/ul/li[1]/span"));
        String numberValue = number.getText();
        numberValue = numberValue.replaceAll("[^-?0-9]+", "");
        System.out.println("Iš viso drakono kiaušinių skelbimų yra: " + numberValue);
        if (Integer.valueOf(numberValue) > 0) {
            System.out.println("Skelbimų ID:");
        }else{
            System.out.println("Skelbimų nėra");
        }

        var elements = driver.findElements(By.className("standard-list-item"));
        for (int i =0; i < elements.stream().count(); i++) {
            var element = elements.get(i);
            System.out.println(element.getAttribute("data-item-id"));
        }
    }

//    Skelbiu.lt   Ištraukti visus paieškos rezultatų skelbimų ID,
//    suskaičiuoti kiek realių skelbimų yra įkelta: a) maža paieška (1-5psl); b) didelė paieška (virš 10 psl.)
//    https://www.skelbiu.lt/skelbimai/?autocompleted=1&keywords=traktorius+22kw&cost_min=&cost_max=&type=0&condition=&cities=0&distance=0&mainCity=0&search=1&category_id=1&user_type=0&ad_since_min=0&ad_since_max=0&visited_page=1&orderBy=-1&detailsSearch=0
//    https://www.skelbiu.lt/skelbimai/?autocompleted=1&keywords=samotines+plytos&cost_min=&cost_max=&type=0&cities=0&distance=0&mainCity=0&search=1&category_id=2&user_type=0&ad_since_min=0&ad_since_max=0&visited_page=1&orderBy=-1&detailsSearch=0
//    https://www.skelbiu.lt/skelbimai/?autocompleted=1&keywords=drakono+kiausinis&cost_min=&cost_max=&type=0&cities=0&distance=0&mainCity=0&search=1&category_id=0&user_type=0&ad_since_min=0&ad_since_max=0&visited_page=1&orderBy=-1&detailsSearch=0

//    Aruodas.lt       a) paieška, kuri veiktų su dinaminiu turiniu;
//    b)paieška išdalinta funkcijomis, kad būtų galima kode įrašyti ko ieškosime
//    Aruodas.lt
//    siauliai
//    zaliukiu k
//    danes g
//
//    kretingos r.
//    alko k.
//
//    palanga
//    palangos m,
//    sventoji
//    apyniu g.
}
