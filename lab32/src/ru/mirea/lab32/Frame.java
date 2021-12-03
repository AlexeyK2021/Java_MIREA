package ru.mirea.lab32;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.util.ArrayList;

public class Frame extends JFrame {
    InternetOrdersManager internetOrdersManager = new InternetOrdersManager();
    TablesOrdersManager tablesOrdersManager = new TablesOrdersManager();

    public ArrayList<InternetOrder> internetOrders = new ArrayList<>();
    public ArrayList<TableOrder> restaurantOrders = new ArrayList<>();


    private JPanel ordersLabelsIO = new JPanel();
    private JPanel ordersLabelsRO = new JPanel();
    private JPanel InternetOrder = new JPanel();
    private JPanel RestaurantOrder = new JPanel();

    Frame() {
        super("Restaurant control panel");
        setDefaultCloseOperation(Frame.EXIT_ON_CLOSE);
        setVisible(true);
        setResizable(false);
        setSize(700, 700);
        setLayout(new GridLayout(1, 3));

//        GridBagConstraints IOConstraints = new GridBagConstraints();
//        GridBagConstraints ROConstraints = new GridBagConstraints();
//        GridBagConstraints CBConstraints = new GridBagConstraints();
//        IOConstraints.fill = GridBagConstraints.LINE_START;
//        ROConstraints.fill = GridBagConstraints.LINE_END;
//        CBConstraints.fill = GridBagConstraints.REMAINDER;


        JButton addIO = new JButton("ADD");
        InternetOrder.add(addIO);
        InternetOrder.setLayout(new GridLayout(2, 1));


        addIO.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                CreateFrameIO createFrameIO = new CreateFrameIO(internetOrders);
                createFrameIO.addWindowListener(new WindowAdapter() {
                    @Override
                    public void windowClosed(WindowEvent e) {
                        Update();
                        InternetOrder.updateUI();
                    }
                });
            }
        });
        InternetOrder.add(ordersLabelsIO);
        add(InternetOrder);

        JPanel ControlButtons = new JPanel();
        ControlButtons.setLayout(new GridLayout(2, 1));
        JButton Statistics = new JButton("Statistics");
        JButton Exit = new JButton("Exit");
        ControlButtons.add(Statistics);
        ControlButtons.add(Exit);
        Statistics.setPreferredSize(new Dimension(100, 30));
        Exit.setPreferredSize(new Dimension(100, 30));

        Statistics.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                //TODO: Окно статистики
            }
        });
        Exit.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                System.exit(0);
            }
        });
        add(ControlButtons);


        JButton addRO = new JButton("ADD");
        JPanel RestaurantPart = new JPanel();
        RestaurantPart.setLayout(new GridLayout(2,1));
        RestaurantPart.add(addRO);
        RestaurantOrder.setLayout(new GridLayout(restaurantOrders.size(), 1));
        RestaurantPart.add(RestaurantOrder);
        ArrayList<JButton> ordersLabelsRO = new ArrayList<>();


        addRO.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                CreateFrameRO createFrameRO = new CreateFrameRO(restaurantOrders);
                createFrameRO.addWindowListener(new WindowAdapter() {
                    @Override
                    public void windowClosed(WindowEvent e) {
                        Update();
                        RestaurantOrder.updateUI();
                    }
                });
            }
        });
        add(RestaurantPart);
        //pack();
    }

    public void Update() {
        RestaurantOrder.removeAll();
        InternetOrder.removeAll();
        for (int i = 0; i < internetOrders.size(); i++) {
            JButton orderButtonIO = new JButton("Order from " +
                    internetOrders.get(i).getCostumer().getFirstName() + " " +
                    internetOrders.get(i).getCostumer().getSecondName());
            Order order1 = internetOrders.get(i);
            orderButtonIO.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    JButton deleteOrderIO = new JButton("Delete");
                    deleteOrderIO.addActionListener(new ActionListener() {
                        @Override
                        public void actionPerformed(ActionEvent e) {
                            internetOrders.remove(order1);
                            InternetOrder.remove(orderButtonIO);
                            Update();
                            InternetOrder.updateUI();
                        }
                    });
                    new InfoFrame(order1, deleteOrderIO);
                }
            });
            // ordersLabelsIO.add(orderButton);
            InternetOrder.add(orderButtonIO);
        }

        for (int i = 0; i < restaurantOrders.size(); i++) {
            JButton orderButtonRO = new JButton("Order from " +
                    restaurantOrders.get(i).getCostumer().getFirstName() + " " +
                    restaurantOrders.get(i).getCostumer().getSecondName());
            Order order1 = restaurantOrders.get(i);
            orderButtonRO.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    JButton deleteOrderIO = new JButton("Delete");
                    deleteOrderIO.addActionListener(new ActionListener() {
                        @Override
                        public void actionPerformed(ActionEvent e) {
                            restaurantOrders.remove(order1);
                            RestaurantOrder.remove(orderButtonRO);
                            Update();
                            RestaurantOrder.updateUI();
                        }
                    });
                    new InfoFrame(order1, deleteOrderIO);
                }
            });
            // ordersLabelsRO.add(order);
            RestaurantOrder.add(orderButtonRO);
        }
    }

}
