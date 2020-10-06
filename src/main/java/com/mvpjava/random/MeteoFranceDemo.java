package com.mvpjava.random;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.Timer;

import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.context.ConfigurableApplicationContext;

@SpringBootApplication
public class MeteoFranceDemo extends JFrame {

	private final AtmosphericRandom atmosphericRandom;
	private JPanel contentPane;


	static JPanel pannel_a = new JPanel();
	static JPanel pannel_b = new JPanel();
	static JPanel pannel_c = new JPanel();
	static JPanel pannel_d = new JPanel();
	static JPanel pannel_e = new JPanel();

	static Dimension dim_small = new Dimension(100, 100);
	static Dimension dim_big = new Dimension(100, 130);

	public MeteoFranceDemo(AtmosphericRandom atmosphericRandom) {

		this.atmosphericRandom = atmosphericRandom;
		this.setTitle("MeteoFrance Demo - Yves PETRO");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 580, 180);
		
		initUI();
		this.pack();

	}

	// building the view
	private void initUI() {
		
		contentPane = new JPanel();

		JPanel pannel_a = new JPanel();
		JPanel pannel_b = new JPanel();
		JPanel pannel_c = new JPanel();
		JPanel pannel_d = new JPanel();
		JPanel pannel_e = new JPanel();

		pannel_a.setBackground(Color.YELLOW);
		pannel_b.setBackground(Color.RED);
		pannel_c.setBackground(Color.LIGHT_GRAY);
		pannel_d.setBackground(Color.CYAN);
		pannel_e.setBackground(Color.GREEN);

		pannel_a.setPreferredSize(dim_small);
		pannel_b.setPreferredSize(dim_small);
		pannel_c.setPreferredSize(dim_small);
		pannel_d.setPreferredSize(dim_small);
		pannel_e.setPreferredSize(dim_small);

		JLabel label_a = new JLabel("A");
		JLabel label_b = new JLabel("B");
		JLabel label_c = new JLabel("C");
		JLabel label_d = new JLabel("D");
		JLabel label_e = new JLabel("E");

		pannel_a.add(label_a);
		pannel_b.add(label_b);
		pannel_c.add(label_c);
		pannel_d.add(label_d);
		pannel_e.add(label_e);

		contentPane.add(pannel_a);
		contentPane.add(pannel_b);
		contentPane.add(pannel_c);
		contentPane.add(pannel_d);
		contentPane.add(pannel_e);

		this.setContentPane(contentPane);

		//  timer which periodically request Random.org 
		Timer timer = new Timer(1000, new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent arg0) {

				pannel_a.setPreferredSize(dim_small);
				pannel_b.setPreferredSize(dim_small);
				pannel_c.setPreferredSize(dim_small);
				pannel_d.setPreferredSize(dim_small);
				pannel_e.setPreferredSize(dim_small);

				int value = atmosphericRandom.nextInt(1, 0, 4)[0];
				//System.out.println("value = " + value);
				switch (value) {
				case 0:
					pannel_a.setPreferredSize(dim_big);
					break;
				case 1:
					pannel_b.setPreferredSize(dim_big);
					break;
				case 2:
					pannel_c.setPreferredSize(dim_big);
					break;
				case 3:
					pannel_d.setPreferredSize(dim_big);
					break;
				case 4:
					pannel_e.setPreferredSize(dim_big);
					break;

				}
				
		        contentPane.revalidate();
		        contentPane.repaint();
		        
			}
		});
		timer.start();
	}
	
	public static void main(String[] args) {

		ConfigurableApplicationContext ctx = new SpringApplicationBuilder(MeteoFranceDemo.class)
				.headless(false) // allows SpringBoot to launch GUI app (override of the web server mode)
				.run(args);

		EventQueue.invokeLater(() -> {

			MeteoFranceDemo ex = ctx.getBean(MeteoFranceDemo.class);
			ex.setVisible(true);
		});
	}
}