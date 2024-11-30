package org.usc.creatureCollection.UI;

import javax.swing.*;
import java.awt.*;

public class PanelCargaInfo extends JFrame {

    private final DefaultListModel<String> modeloListas;
    private final DefaultListModel<String> modeloArtistas;
    private final DefaultListModel<String> modeloCanciones;

    public PanelCargaInfo() {
        modeloListas = new DefaultListModel<>();
        modeloArtistas = new DefaultListModel<>();
        modeloCanciones = new DefaultListModel<>();

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
        modeloArtistas.addElement("Arctic Monkeys");

        // Canciones cargadas
        modeloCanciones.addElement("One More Time");
        modeloCanciones.addElement("Cracker Island");
        modeloCanciones.addElement("505");

        // Playlists cargadas
        modeloListas.addElement("Playlist aa");
        modeloListas.addElement("Playlist2");
    }

    private JPanel crearPanelListas() {
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
        JButton btnAgregarCancion = new JButton("Agregar Canción");

        // Estilo de los botones
        btnAgregarLista.setBackground(new Color(30, 215, 96));
        btnAgregarLista.setForeground(Color.WHITE);
        btnAgregarCancion.setBackground(new Color(30, 215, 96));
        btnAgregarCancion.setForeground(Color.WHITE);

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

        panel.add(etiqueta, BorderLayout.NORTH);
        panel.add(new JScrollPane(listaArtistas), BorderLayout.CENTER);
        panel.add(btnAgregarArtista, BorderLayout.SOUTH);

        return panel;
    }

    private JPanel crearPanelCanciones() {
        JPanel panel = new JPanel(new BorderLayout());
        panel.setBackground(new Color(25, 20, 20));

        JLabel etiqueta = new JLabel("Canciones");
        etiqueta.setForeground(Color.WHITE);

        JList<String> listaCanciones = new JList<>(modeloCanciones);
        listaCanciones.setBackground(new Color(40, 40, 40));
        listaCanciones.setForeground(Color.WHITE);

        JButton btnAgregarCancion = new JButton("Crear Canción");
        btnAgregarCancion.setBackground(new Color(30, 215, 96));
        btnAgregarCancion.setForeground(Color.WHITE);

        panel.add(etiqueta, BorderLayout.NORTH);
        panel.add(new JScrollPane(listaCanciones), BorderLayout.CENTER);
        panel.add(btnAgregarCancion, BorderLayout.SOUTH);

        return panel;
    }
}