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


    private JPanel InternetOrder = new JPanel();
    private JPanel RestaurantOrder = new JPanel();

    Frame() {
        super("Restaurant control panel");
        setDefaultCloseOperation(Frame.EXIT_ON_CLOSE);
        setVisible(true);
        setResizable(false);
        setSize(700, 700);
        setLayout(new GridLayout(1, 3));

        JButton addIO = new JButton("ADD");
        InternetOrder.add(addIO);
        InternetOrder.setLayout(new GridLayout(2, 1));

        JPanel InternetPart = new JPanel();
        InternetPart.setLayout(new GridLayout(2, 1));
        InternetPart.add(addIO);
        RestaurantOrder.setLayout(new GridLayout(internetOrdersManager.ordersQuantity(), 1));
        InternetPart.add(InternetOrder);

        addIO.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                CreateFrameIO createFrameIO = new CreateFrameIO(internetOrdersManager);
                createFrameIO.addWindowListener(new WindowAdapter() {
                    @Override
                    public void windowClosed(WindowEvent e) {
                        Update();
                        InternetOrder.updateUI();
                    }
                });
            }
        });
        add(InternetPart);

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
        RestaurantPart.setLayout(new GridLayout(2, 1));
        RestaurantPart.add(addRO);
        RestaurantOrder.setLayout(new GridLayout(tablesOrdersManager.ordersQuantity(), 1));
        RestaurantPart.add(RestaurantOrder);


        addRO.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                CreateFrameRO createFrameRO = new CreateFrameRO(tablesOrdersManager);
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
        Order[] internetOrders_ = internetOrdersManager.getOrders();
        for (int i = 0; i < internetOrders_.length; i++) {
            JButton orderButtonIO = new JButton("Order from " +
                    internetOrders_[i].getCostumer().getFirstName() + " " +
                    internetOrders_[i].getCostumer().getSecondName());
            Order order1 = internetOrders_[i];
            orderButtonIO.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    JButton deleteOrderIO = new JButton("Delete");
                    deleteOrderIO.addActionListener(new ActionListener() {
                        @Override
                        public void actionPerformed(ActionEvent e) {
                            try {
                                internetOrdersManager.removeOrder(String.valueOf(order1.getTable()));
                            }catch (IllegalTableNumber ITN){
                                System.out.println(ITN.getMessage());
                            }
                            InternetOrder.remove(orderButtonIO);
                            Update();
                            InternetOrder.updateUI();
                        }
                    });
                    new InfoFrame(order1, deleteOrderIO);
                }
            });
            InternetOrder.add(orderButtonIO);
        }

        Order[] restaurantOrders_ = tablesOrdersManager.orders;
        for (int i = 0; i < restaurantOrders_.length; i++) {
            JButton orderButtonRO = new JButton("Order from " +
                    restaurantOrders_[i].getCostumer().getFirstName() + " " +
                    restaurantOrders_[i].getCostumer().getSecondName());
            Order order1 = restaurantOrders_[i];
            orderButtonRO.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    JButton deleteOrderIO = new JButton("Delete");
                    deleteOrderIO.addActionListener(new ActionListener() {
                        @Override
                        public void actionPerformed(ActionEvent e) {
                            try {
                                tablesOrdersManager.removeOrder(order1.getTable());
                            } catch (IllegalTableNumber ITN) {
                                System.out.println(ITN.getMessage());
                            }
                            RestaurantOrder.remove(orderButtonRO);
                            Update();
                            RestaurantOrder.updateUI();
                        }
                    });
                    new InfoFrame(order1, deleteOrderIO);
                }
            });
            RestaurantOrder.add(orderButtonRO);
        }
    }

}
