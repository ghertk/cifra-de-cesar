package view;

import DAO.ContatoDAO;
import cifradecesar.CifraDeCesar;
import controller.ContatoController;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.table.DefaultTableModel;
import model.Contato;

public class ListarContatos extends javax.swing.JPanel {

    private Tela tela;
    private CifraDeCesar cifraDeCesar;
    private ContatoController contatoController;
    private DefaultTableModel tableModel;

    public ListarContatos(Tela tela) {
        initComponents();
        this.tela = tela;
        this.contatoController = new ContatoController();
        this.tableModel = new DefaultTableModel();
        this.cifraDeCesar = new CifraDeCesar();
        this.initTableContato();
    }

    private void initTableContato() {
        
        try {
            this.tableModel = new DefaultTableModel();
            
            this.tableModel.addColumn("Id");
            this.tableModel.addColumn("Nome");
            this.tableModel.addColumn("Email");
            this.tableModel.addColumn("Celular");
            this.tableModel.addColumn("Cidade");
            for (Object[] contato: this.contatoController.buscarUsuarios()) {
                this.tableModel.addRow(contato);
            }
            this.jTableContato.setModel(this.tableModel);
        } catch (Exception ex) {
            ex.printStackTrace();
            System.out.println("ErroCarrge");
        }
    }

    void atualizarTabela() {
        try {
            this.tableModel = new DefaultTableModel();
            
            this.tableModel.addColumn("Id");
            this.tableModel.addColumn("Nome");
            this.tableModel.addColumn("Email");
            this.tableModel.addColumn("Celular");
            this.tableModel.addColumn("Cidade");
            for (Object[] contato: this.contatoController.buscarUsuarios()) {
                this.tableModel.addRow(contato);
            }
            this.jTableContato.setModel(this.tableModel);
        } catch (Exception ex) {
            ex.printStackTrace();
            System.out.println("ErroCarrge");
        }
        
        this.jTableContato.setModel(tableModel);
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane1 = new javax.swing.JScrollPane();
        jTableContato = new javax.swing.JTable();
        jButtonNovoContato = new javax.swing.JButton();
        jButtonCadastroUsuario = new javax.swing.JButton();

        jTableContato.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        jScrollPane1.setViewportView(jTableContato);

        jButtonNovoContato.setText("Cadastrar novo contato");
        jButtonNovoContato.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonNovoContatoActionPerformed(evt);
            }
        });

        jButtonCadastroUsuario.setText("Cadastrar novo Usuário");
        jButtonCadastroUsuario.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonCadastroUsuarioActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jButtonCadastroUsuario)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 29, Short.MAX_VALUE)
                        .addComponent(jButtonNovoContato)))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButtonNovoContato)
                    .addComponent(jButtonCadastroUsuario))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 7, Short.MAX_VALUE)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 252, javax.swing.GroupLayout.PREFERRED_SIZE))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void jButtonNovoContatoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonNovoContatoActionPerformed
        tela.irPara("CadastroContato");
    }//GEN-LAST:event_jButtonNovoContatoActionPerformed

    private void jButtonCadastroUsuarioActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonCadastroUsuarioActionPerformed
        tela.irPara("CadastroUsuario");
    }//GEN-LAST:event_jButtonCadastroUsuarioActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButtonCadastroUsuario;
    private javax.swing.JButton jButtonNovoContato;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable jTableContato;
    // End of variables declaration//GEN-END:variables
}
