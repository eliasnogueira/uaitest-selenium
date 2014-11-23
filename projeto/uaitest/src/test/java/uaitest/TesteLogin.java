package uaitest;

import static org.junit.Assert.*;

import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

/**
 * Classe de teste mostrando como é fácil automatizar com Selenium WebDriver
 * 
 * @author Elias Nogueira <elias.nogueira@qualister.com.br>
 */
public class TesteLogin {

	@Test
	public void testeLogin() {
		/*
		 * Abre o Firefox na máquina. Este firefox é um browser "limpo" (não vem com os plugins instalados
		 * e não influencia nos browsers já abetos.
		 * 
		 * driver é um nome comum que utilizamos, mas poderíamos utilizar, por exemplo, firefox
		 */
		WebDriver driver = new FirefoxDriver();
		
		/*
		 * Acessa a página de exemplo. Sempre deve ser colocado o protocolo http://
		 */
		driver.get("http://eliasnogueira.com/arquivos_blog/uaitest/");
		
		/*
		 * Localiza os elementos pelo seu id e efetua as ações necessários em cada um:
		 *    - digitar = sendKeys
		 *    - clicar = click
		 *    
		 * Há outras formas de localização, que são utilizadas através da classe By
		 * Uma delas é o name, utilizado como referência para clicar no botão   
		 */
		driver.findElement(By.id("user_email")).sendKeys("elias.nogueira");
		driver.findElement(By.id("user_password")).sendKeys("123456");
		driver.findElement(By.id("user_horizontal_active")).click();
		driver.findElement(By.name("login")).click();
		
		/*
		 * Podemos também pegar textos na tela, basta localizarmos o elemento e pegar o texto (getText())
		 * Na linha abaixo estamos guardando um texto em uma variável textoTela
		 */
		String textoTela = driver.findElement(By.id("mensagem")).getText();
		
		/*
		 * Criamos uma variável com o resultado esperado, se será depois comparado com o que apresentou na tela
		 */
		String textoEsperado = "Login efetuado com sucesso!";
		
		/*
		 * Comando do frameowork junit para validar se dois textos são iguais (assertEquals)
		 * Se o texto comparado (textoExperado x textoTela) for diferente, um erro de comparação é apresentado
		 */
		assertEquals(textoEsperado, textoTela);
		
		/*
		 * Fecha o browser
		 */
		driver.quit();
	}
}
