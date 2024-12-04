package org.usc.creatureCollection.UI;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.ArrayList;
import java.util.HashMap;

public class PanelCargaInfo extends JFrame {

    private final DefaultListModel<String> modeloListas;
    private final DefaultListModel<String> modeloArtistas;
    private final DefaultListModel<String> modeloCanciones;

    private final HashMap<String, String> cancionesAArtistas;
    private final HashMap<String, ArrayList<String>> listasAColleccion;

    public PanelCargaInfo() {
        modeloListas = new DefaultListModel<>();
        modeloArtistas = new DefaultListModel<>();
        modeloCanciones = new DefaultListModel<>();
        cancionesAArtistas = new HashMap<>();
        listasAColleccion = new HashMap<>();

        cargarDatosIniciales();

        // Configurar ventana principal
        setTitle("Music Collection");
        setSize(800, 600);
        setLayout(new GridLayout(1, 3));
        getContentPane().setBackground(new Color(25, 20, 20));

        // Paneles principales
        add(crearPanelListas());
        add(crearPanelArtistas());
        add(crearPanelCanciones());
    }

    private void cargarDatosIniciales() {
        // Artistas cargados
        modeloArtistas.addElement("Daft Punk");
        modeloArtistas.addElement("Gorillaz");
        modeloArtistas.addElement("Artic Monkeys");

        // Canciones cargadas
        modeloCanciones.addElement("One More Time");
        cancionesAArtistas.put("One More Time", "Daft Punk");

        modeloCanciones.addElement("Cracker Island");
        cancionesAArtistas.put("Cracker Island", "Gorillaz");

        modeloCanciones.addElement("505");
        cancionesAArtistas.put("505", "Artic Monkeys");

        // Playlists cargadas
        modeloListas.addElement("Playlist aa");
        modeloListas.addElement("Playlist2");

        // Colocar canciones a Playlists cargadas
        listasAColleccion.put("Playlist aa", new ArrayList<>());
        listasAColleccion.get("Playlist aa").add("One More Time");
        listasAColleccion.get("Playlist aa").add("Cracker Island");

        listasAColleccion.put("Playlist2", new ArrayList<>());
        listasAColleccion.get("Playlist2").add("505");
    }

    private JPanel crearPanelListas() {
        // Columna Playlist
        JPanel panel = new JPanel(new BorderLayout());
        panel.setBackground(new Color(25, 20, 20));

        JLabel etiqueta = new JLabel("Playlists");
        etiqueta.setForeground(Color.WHITE);
        JList<String> listaListas = new JList<>(modeloListas);
        listaListas.setBackground(new Color(40, 40, 40));
        listaListas.setForeground(Color.WHITE);

        JTextArea areaCanciones = new JTextArea(10, 20);
        areaCanciones.setEditable(false);
        areaCanciones.setBackground(new Color(40, 40, 40));
        areaCanciones.setForeground(Color.WHITE);

        JButton btnAgregarLista = new JButton("Crear Playlist");
        JButton btnAgregarCancion = new JButton("Agregar Cancion");

        btnAgregarLista.setBackground(new Color(30, 215, 96));
        btnAgregarLista.setForeground(Color.WHITE);
        btnAgregarCancion.setBackground(new Color(30, 215, 96));
        btnAgregarCancion.setForeground(Color.WHITE);

        listaListas.addListSelectionListener(e -> {
            String listaSeleccionada = listaListas.getSelectedValue();
            if (listaSeleccionada != null) {
                ArrayList<String> canciones = listasAColleccion.get(listaSeleccionada);
                if (canciones != null) {
                    StringBuilder detallesLista = new StringBuilder();
                    for (String cancion : canciones) {
                        String artista = cancionesAArtistas.get(cancion);
                        detallesLista.append(cancion)
                                .append(" - ")
                                .append(artista != null ? artista : "Artista Desconocido")
                                .append("\n");
                    }
                    areaCanciones.setText(detallesLista.toString());
                } else {
                    areaCanciones.setText("");
                }
            }
        });

        btnAgregarLista.addActionListener(e -> {
            String nombre = JOptionPane.showInputDialog(this, "Ingrese el nombre de la nueva Playlist:");
            if (nombre != null && !nombre.isEmpty()) {
                modeloListas.addElement(nombre);
                listasAColleccion.put(nombre, new ArrayList<>());
            }
        });

        btnAgregarCancion.addActionListener(e -> {
            String listaSeleccionada = listaListas.getSelectedValue();
            if (listaSeleccionada != null) {
                String cancionSeleccionada = (String) JOptionPane.showInputDialog(
                        this, "Seleccione una cancion para agregar:",
                        "Agregar Cancion", JOptionPane.QUESTION_MESSAGE,
                        null, modeloCanciones.toArray(), null
                );
                if (cancionSeleccionada != null) {
                    listasAColleccion.get(listaSeleccionada).add(cancionSeleccionada);
                    listaListas.clearSelection();
                    listaListas.setSelectedValue(listaSeleccionada, true);
                }
            } else {
                JOptionPane.showMessageDialog(this, "Seleccione una Playlist primero");
            }
        });

        panel.add(etiqueta, BorderLayout.NORTH);
        panel.add(new JScrollPane(listaListas), BorderLayout.WEST);
        panel.add(new JScrollPane(areaCanciones), BorderLayout.CENTER);

        JPanel botones = new JPanel();
        botones.setBackground(new Color(25, 20, 20));
        botones.add(btnAgregarLista);
        botones.add(btnAgregarCancion);
        panel.add(botones, BorderLayout.SOUTH);

        return panel;
    }

    private JPanel crearPanelArtistas() {
        // Columna artista
        JPanel panel = new JPanel(new BorderLayout());
        panel.setBackground(new Color(25, 20, 20));

        JLabel etiqueta = new JLabel("Artistas");
        etiqueta.setForeground(Color.WHITE);

        JList<String> listaArtistas = new JList<>(modeloArtistas);
        listaArtistas.setBackground(new Color(40, 40, 40));
        listaArtistas.setForeground(Color.WHITE);

        JButton btnAgregarArtista = new JButton("Crear Artista");
        btnAgregarArtista.setBackground(new Color(30, 215, 96));
        btnAgregarArtista.setForeground(Color.WHITE);

        btnAgregarArtista.addActionListener(e -> {
            String nombre = JOptionPane.showInputDialog(this, "Ingrese el nombre del artista:");
            if (nombre != null && !nombre.isEmpty()) {
                modeloArtistas.addElement(nombre);
            }
        });

        panel.add(etiqueta, BorderLayout.NORTH);
        panel.add(new JScrollPane(listaArtistas), BorderLayout.CENTER);
        panel.add(btnAgregarArtista, BorderLayout.SOUTH);

        return panel;
    }

    private JPanel crearPanelCanciones() {
        // Columna canciones
        JPanel panel = new JPanel(new BorderLayout());
        panel.setBackground(new Color(25, 20, 20));

        JLabel etiqueta = new JLabel("Canciones");
        etiqueta.setForeground(Color.WHITE);

        JList<String> listaCanciones = new JList<>(modeloCanciones);
        listaCanciones.setBackground(new Color(40, 40, 40));
        listaCanciones.setForeground(Color.WHITE);

        JButton btnAgregarCancion = new JButton("Crear Cancion");
        btnAgregarCancion.setBackground(new Color(30, 215, 96));
        btnAgregarCancion.setForeground(Color.WHITE);

        btnAgregarCancion.addActionListener(e -> {
            String nombre = JOptionPane.showInputDialog(this, "Ingrese el nombre de la cancion:");
            if (nombre != null && !nombre.isEmpty()) {
                String artistaSeleccionado = (String) JOptionPane.showInputDialog(
                        this, "Seleccione un artista:",
                        "Crear Cancion", JOptionPane.QUESTION_MESSAGE,
                        null, modeloArtistas.toArray(), null
                );
                if (artistaSeleccionado != null) {
                    modeloCanciones.addElement(nombre);
                    cancionesAArtistas.put(nombre, artistaSeleccionado);
                } else {
                    JOptionPane.showMessageDialog(this, "Cree un artista primero");
                }
            }
        });

        panel.add(etiqueta, BorderLayout.NORTH);
        panel.add(new JScrollPane(listaCanciones), BorderLayout.CENTER);
        panel.add(btnAgregarCancion, BorderLayout.SOUTH);

        return panel;
    }
}