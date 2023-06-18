package betternow.web;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

public class BuscandoCotacao extends WebPageProperties {

    private static final String URL = "http://google.com.br";
    private static final String CSS_SELECTOR = "#knowledge-currency__updatable-data-column > div.b1hJbf > div.dDoNo.ikb4Bb.gsrt > span.DFlfde.SwHCTb";

    public BuscandoCotacao() {
        super(null);
        this.browser.navigate().to(URL);
    }

    private String buscarCotacao(String termoPesquisa) {
        browser.findElement(By.name("q")).sendKeys(termoPesquisa);
        browser.findElement(By.name("btnK")).submit();
        WebElement elemento = browser.findElement(By.cssSelector(CSS_SELECTOR));
        String dataValue = elemento.getAttribute("data-value");
        System.out.println(dataValue);
        return dataValue;
    }

    public String buscarCotacaoDolar() {
        String dataValue = buscarCotacao("Cotacao dolar hoje");
        return "O Dolar atual é no valor de " + dataValue + " R$\n";
    }

    public String buscarCotacaoEuro() {
        String dataValue = buscarCotacao("Cotacao Euro hoje");
        return "O Euro atual é no valor de " + dataValue + " R$\n";
    }

    public String buscarCotacaoReal() {
        String dataValue = buscarCotacao("Cotacao Real hoje");
        return "O Real atual em relação ao Dolar é no valor de " + dataValue + " R$\n";
    }

    public String buscarCotacaoLibra() {
        String dataValue = buscarCotacao("Cotacao Libra hoje");
        return "A Libra atual é no valor de " + dataValue + " R$\n";
    }
}
