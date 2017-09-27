/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ch.unifr.diva.divannotation.export;

import ch.unifr.tei.facsimile.surfacegrp.TeiSurfaceGrpFolio;
import ch.unifr.tei.facsimile.surfacegrp.TeiSurfaceGrpPart;
import ch.unifr.tei.facsimile.surfacegrp.surface.TeiSurface;
import ch.unifr.tei.facsimile.surfacegrp.surface.zone.TeiTextSegZone;
import ch.unifr.tei.facsimile.surfacegrp.surface.zone.TeiTextZone;
import ch.unifr.tei.utils.TeiArea;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import javax.imageio.ImageIO;
import javax.swing.JFileChooser;
import javax.swing.JOptionPane;
import ch.unifr.diva.divannotation.GUI;
import org.javatuples.Pair;

/**
 *
 * @author Mathias Seuret
 */
public class ExportData extends javax.swing.JPanel {
    GUI gui;
    /**
     * Creates new form ExportData
     */
    public ExportData(GUI gui) {
        initComponents();
        this.gui = gui;
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        txtOcropyExportPath = new javax.swing.JTextField();
        btnBrowseOcropyPath = new javax.swing.JButton();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jcExtractionMethod = new javax.swing.JComboBox<>();
        btnExport = new javax.swing.JButton();
        progress = new javax.swing.JProgressBar();

        jLabel1.setFont(new java.awt.Font("Cantarell", 0, 18)); // NOI18N
        jLabel1.setText("Export Ocropy training data");

        btnBrowseOcropyPath.setText("Browse");
        btnBrowseOcropyPath.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnBrowseOcropyPathActionPerformed(evt);
            }
        });

        jLabel2.setText("Select destination folder");

        jLabel3.setText("Select line image extraction method");

        jcExtractionMethod.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Bounding box", "Polygon" }));
        jcExtractionMethod.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jcExtractionMethodActionPerformed(evt);
            }
        });

        btnExport.setText("Export");
        btnExport.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnExportActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(progress, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addComponent(txtOcropyExportPath)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btnBrowseOcropyPath)
                        .addGap(6, 6, 6))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel1)
                            .addComponent(jLabel2)
                            .addComponent(jLabel3)
                            .addComponent(jcExtractionMethod, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(btnExport))
                        .addGap(0, 464, Short.MAX_VALUE)))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jLabel2)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtOcropyExportPath, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnBrowseOcropyPath))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel3)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jcExtractionMethod, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btnExport)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 299, Short.MAX_VALUE)
                .addComponent(progress, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );
    }// </editor-fold>//GEN-END:initComponents

    private void btnBrowseOcropyPathActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnBrowseOcropyPathActionPerformed
        JFileChooser fileChoser = new JFileChooser();
        fileChoser.setCurrentDirectory(gui.currentDirectory);
        fileChoser.setFileSelectionMode(JFileChooser.DIRECTORIES_ONLY);
        if(fileChoser.showSaveDialog(this)==JFileChooser.APPROVE_OPTION) {
            this.txtOcropyExportPath.setText(fileChoser.getSelectedFile().getAbsolutePath());
        }
    }//GEN-LAST:event_btnBrowseOcropyPathActionPerformed

    private void jcExtractionMethodActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jcExtractionMethodActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jcExtractionMethodActionPerformed

    private void btnExportActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnExportActionPerformed
        // As this might take a while for large files, let's count things
        int nbLines = 0;
        for (TeiSurfaceGrpPart part : gui.getTei().getFacsimile().getParts()) {
            for (TeiSurfaceGrpFolio folio : part.getFolios()) {
                for (TeiSurface page : folio.getPages()) {
                    for (TeiTextZone tz : page.getTextZones()) {
                        nbLines += tz.getTextSegZones().size();
                    }
                }
            }
        }
        progress.setValue(0);
        progress.setMaximum(nbLines);
        
        boolean useBB = jcExtractionMethod.getSelectedItem().equals("Bounding box");
        TeiArea.ExtractionMethod method = (useBB) ? TeiArea.ExtractionMethod.RECTANGLE : TeiArea.ExtractionMethod.POLYGON;
        
        // Process the lines
        new Thread(new Runnable(){
            public void run() {
                int lineNum = 0;
                boolean errorDisplayed = false;
                for (TeiSurfaceGrpPart part : gui.getTei().getFacsimile().getParts()) {
                    for (TeiSurfaceGrpFolio folio : part.getFolios()) {
                        for (TeiSurface page : folio.getPages()) {
                            for (TeiTextZone tz : page.getTextZones()) {
                                if (tz.getTranscription()==null) {
                                    lineNum+=tz.getTextSegZones().size();
                                    progress.setValue(lineNum);
                                    continue;
                                }
                                for (TeiTextSegZone sg : tz.getTextSegZones()) {
                                    if (sg.getTranscription()==null) {
                                        lineNum++;
                                        progress.setValue(lineNum);
                                        continue;
                                    }
                                    try {
                                        Pair<BufferedImage, String> tr = sg.getOcropyTranscription(page.getGraphics().get(0).loadImage(), method);
                                        String baseName = String.format("%06d", lineNum);
                                        try (FileWriter fw = new FileWriter(txtOcropyExportPath.getText()+File.separator+baseName+".gt.txt")) {
                                            fw.write(tr.getValue1());
                                        }
                                        ImageIO.write(tr.getValue0(), "png", new File(txtOcropyExportPath.getText()+File.separator+baseName+".bin.png"));
                                        
                                        lineNum++;
                                        progress.setValue(lineNum);
                                    } catch (IOException ex) {
                                        if (!errorDisplayed) {
                                            JOptionPane.showMessageDialog(
                                                    null,
                                                    "An error happened: "+ex.getMessage()+"\nNext errors will be hidden",
                                                    "Huho",
                                                    JOptionPane.ERROR_MESSAGE
                                            );
                                            errorDisplayed = true;
                                        }
                                    }
                                }
                            }
                        }
                    }
                }
            }
        }).start();
    }//GEN-LAST:event_btnExportActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnBrowseOcropyPath;
    private javax.swing.JButton btnExport;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JComboBox<String> jcExtractionMethod;
    private javax.swing.JProgressBar progress;
    private javax.swing.JTextField txtOcropyExportPath;
    // End of variables declaration//GEN-END:variables
}