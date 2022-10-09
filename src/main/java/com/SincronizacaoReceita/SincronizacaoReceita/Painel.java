package com.SincronizacaoReceita.SincronizacaoReceita;

import com.SincronizacaoReceita.SincronizacaoReceita.service.ValidacaoReceita;
import com.SincronizacaoReceita.SincronizacaoReceita.dto.ContaMapperImpl;
import com.SincronizacaoReceita.SincronizacaoReceita.service.ContaService;
import com.SincronizacaoReceita.SincronizacaoReceita.util.CSVConversor;
import com.opencsv.exceptions.CsvException;
import org.springframework.stereotype.Component;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

@Component
public class Painel extends JFrame {
    private JLabel label;
    private JTextField campoTexto;
    private JButton btnConverter;
    public JPanel panelMain;

    public Painel() {
        btnConverter.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                ContaService contaService = new ContaService(new ContaMapperImpl());

                ValidacaoReceita controller = new ValidacaoReceita(contaService, new CSVConversor());

                try {
                    controller.verificacaoReceita(campoTexto.getText());
                    JOptionPane.showMessageDialog(null, "Arquivo convertido. Verifique na pasta informada.");
                } catch (CsvException ex) {
                    JOptionPane.showMessageDialog(null, "Não foi possivel converter o arquivo. " +
                            "Verifique o padrão e tente novamente");
                }
            }
        });
    }
}
