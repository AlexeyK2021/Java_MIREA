package ru.mirea.lab32;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

public class Frame extends JFrame {
    InternetOrdersManager internetOrdersManager = new InternetOrdersManager();
    TablesOrdersManager tablesOrdersManager = new TablesOrdersManager();

    private JPanel InternetOrder = new JPanel();
    private JPanel RestaurantOrder = new JPanel();

    Frame() {
        super("Restaurant control panel");
        setDefaultCloseOperation(Frame.EXIT_ON_CLOSE);
        setResizable(true);
        setSize(700, 700);
        setLayout(new GridLayout(1, 3));
        JButton addIO = new JButton("ADD");

        JPanel InternetPart = new JPanel();
        InternetPart.setLayout(new BorderLayout());
        InternetPart.add(addIO, BorderLayout.NORTH);
        InternetOrder.setLayout(new BoxLayout(InternetOrder, BoxLayout.Y_AXIS));
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
        ControlButtons.setLayout(new BorderLayout());
        JButton Statistics = new JButton("Statistics");
        JButton Exit = new JButton("Exit");
        ControlButtons.add(Statistics, BorderLayout.NORTH);
        ControlButtons.add(Exit, BorderLayout.SOUTH);

        Statistics.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                StatFrame statFrame = new StatFrame(internetOrdersManager, tablesOrdersManager);

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
        RestaurantPart.setLayout(new BorderLayout());

        RestaurantPart.add(addRO, BorderLayout.NORTH);
        RestaurantOrder.setLayout(new BoxLayout(RestaurantOrder, BoxLayout.Y_AXIS));
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
        setVisible(true);
    }

    public void Update() {
        RestaurantOrder.removeAll();
        InternetOrder.removeAll();
        Order[] internetOrders_ = internetOrdersManager.getOrders();
        for (Order order : internetOrders_) {
            JButton orderButtonIO = new JButton("Order from " +
                    order.getCostumer().getFirstName() + " " +
                    order.getCostumer().getSecondName());
            orderButtonIO.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    JButton deleteOrderIO = new JButton("Delete");
                    deleteOrderIO.addActionListener(new ActionListener() {
                        @Override
                        public void actionPerformed(ActionEvent e) {
                            try {
                                internetOrdersManager.removeOrder(String.valueOf(order.getTable()));
                            } catch (IllegalTableNumber ITN) {
                                System.out.println(ITN.getMessage());
                            }
                            InternetOrder.remove(orderButtonIO);
                            Update();
                            InternetOrder.updateUI();
                        }
                    });
                    new InfoFrame(order, deleteOrderIO);
                }
            });
            InternetOrder.add(orderButtonIO);
        }

        Order[] restaurantOrders_ = tablesOrdersManager.orders;
        for (Order order : restaurantOrders_) {
            JButton orderButtonRO = new JButton("Order from " +
                    order.getCostumer().getFirstName() + " " +
                    order.getCostumer().getSecondName());
            orderButtonRO.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    JButton deleteOrderIO = new JButton("Delete");
                    deleteOrderIO.addActionListener(new ActionListener() {
                        @Override
                        public void actionPerformed(ActionEvent e) {
                            try {
                                tablesOrdersManager.removeOrder(order.getTable());
                            } catch (IllegalTableNumber ITN) {
                                System.out.println(ITN.getMessage());
                            }
                            RestaurantOrder.remove(orderButtonRO);
                            Update();
                            RestaurantOrder.updateUI();
                        }
                    });
                    new InfoFrame(order, deleteOrderIO);
                }
            });
            RestaurantOrder.add(orderButtonRO);
        }
    }

}
