package view;

import java.awt.CardLayout;

public class Tela extends javax.swing.JFrame {

    private CardLayout cardLayout;
    private ListarContatos listarContatos;

    public Tela() {
        initComponents();
        this.cardLayout = (CardLayout) new CardLayout();
        this.jPanelPrincipal.setLayout(cardLayout);
        this.jPanelPrincipal.add(new Login(this), "Login");
        this.listarContatos = new ListarContatos(this);
        this.jPanelPrincipal.add(this.listarContatos, "ListarContatos");
        this.jPanelPrincipal.add(new CadastroContato(this), "CadastroContato");
        this.jPanelPrincipal.add(new CadastroUsuario(this), "CadastroUsuario");
        this.cardLayout.show(jPanelPrincipal, "Login");
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanelPrincipal = new javax.swing.JPanel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        getContentPane().setLayout(new java.awt.CardLayout());

        javax.swing.GroupLayout jPanelPrincipalLayout = new javax.swing.GroupLayout(jPanelPrincipal);
        jPanelPrincipal.setLayout(jPanelPrincipalLayout);
        jPanelPrincipalLayout.setHorizontalGroup(
            jPanelPrincipalLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 424, Short.MAX_VALUE)
        );
        jPanelPrincipalLayout.setVerticalGroup(
            jPanelPrincipalLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 324, Short.MAX_VALUE)
        );

        getContentPane().add(jPanelPrincipal, "card2");

        pack();
    }// </editor-fold>//GEN-END:initComponents

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel jPanelPrincipal;
    // End of variables declaration//GEN-END:variables

    void irPara(String nome) {
//        this.cardLayout.next(jPanelPrincipal);
        this.cardLayout.show(jPanelPrincipal, nome);
    }

    void atualizar() {
        this.listarContatos.atualizarTabela();
    }
}
