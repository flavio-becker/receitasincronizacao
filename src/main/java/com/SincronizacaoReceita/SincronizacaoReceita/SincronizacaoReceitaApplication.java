package com.SincronizacaoReceita.SincronizacaoReceita;

import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.context.ConfigurableApplicationContext;

import javax.swing.*;
import java.awt.*;

@SpringBootApplication
public class SincronizacaoReceitaApplication extends JFrame {

	public SincronizacaoReceitaApplication() {

		initUI();
	}

	private void initUI() {

		Painel painel = new Painel();
		painel.setContentPane(painel.panelMain);
		painel.setTitle("Sincronização Receita");
		painel.setSize(500, 200);
		painel.setVisible(true);
		painel.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}

	public static void main(String[] args) {
		ConfigurableApplicationContext ctx = new SpringApplicationBuilder(SincronizacaoReceitaApplication.class)
				.headless(false).run(args);

		EventQueue.invokeLater(() -> {

			SincronizacaoReceitaApplication ex = ctx.getBean(SincronizacaoReceitaApplication.class);
			ex.setVisible(true);
		});
	}
}