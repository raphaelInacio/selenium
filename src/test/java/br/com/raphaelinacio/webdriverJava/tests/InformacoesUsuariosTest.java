package br.com.raphaelinacio.webdriverJava.tests;

import static org.junit.Assert.assertEquals;

import java.util.concurrent.TimeUnit;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class InformacoesUsuariosTest {

	private WebDriver navegador;

	@Before
	public void setup() {
		System.setProperty("webdriver.chrome.driver", "/home/rapha/drivers/chromedriver_linux64/chromedriver");
		navegador = new ChromeDriver();
		navegador.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
		navegador.get("http://www.juliodelima.com.br/taskit/");
	}

	@After
	public void tearDonw() {
		navegador.close();
	}

	@Test
	public void testAcidionarUmaInformacaoAdicionalDoUsuario() {

		navegador.findElement(By.linkText("Sign in")).click();

		WebElement formularioLogin = navegador.findElement(By.id("signinbox"));

		formularioLogin.findElement(By.name("login")).sendKeys("julio0001");

		formularioLogin.findElement(By.name("password")).sendKeys("123456");

		formularioLogin.findElement(By.linkText("SIGN IN")).click();

		WebElement me = navegador.findElement(By.className("me"));

		assertEquals("Hi, Julio", me.getText());
	}
}
