/*
 * Central Repository
 *
 * Copyright 2018-2020 Basis Technology Corp.
 * Contact: carrier <at> sleuthkit <dot> org
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package org.sleuthkit.autopsy.modules.dataSourceIntegrity;

import org.sleuthkit.autopsy.ingest.IngestModuleIngestJobSettings;
import org.sleuthkit.autopsy.ingest.IngestModuleIngestJobSettingsPanel;
import org.sleuthkit.autopsy.corecomponents.AutoWrappingJTextPane;

/**
 * Ingest job settings panel for the Correlation Engine module.
 */
@SuppressWarnings("PMD.SingularField") // UI widgets cause lots of false positives
final class DataSourceIntegrityIngestSettingsPanel extends IngestModuleIngestJobSettingsPanel {

    /**
     * Creates new form DataSourceIntegrityIngestSettingsPanel
     */
    public DataSourceIntegrityIngestSettingsPanel(DataSourceIntegrityIngestSettings settings) {
        initComponents();
        customizeComponents(settings);
    }

    /**
     * Update components with values from the ingest job settings.
     *
     * @param settings The ingest job settings.
     */
    private void customizeComponents(DataSourceIntegrityIngestSettings settings) {
        computeHashesCheckbox.setSelected(settings.shouldComputeHashes());
        verifyHashesCheckbox.setSelected(settings.shouldVerifyHashes());
    }
    
    @Override
    public IngestModuleIngestJobSettings getSettings() {
        return new DataSourceIntegrityIngestSettings(computeHashesCheckbox.isSelected(), verifyHashesCheckbox.isSelected());
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {
        java.awt.GridBagConstraints gridBagConstraints;

        verifyHashesCheckbox = new javax.swing.JCheckBox();
        ingestSettingsLabel = new javax.swing.JLabel();
        noteLabel = new javax.swing.JLabel();
        computeHashesPanel = new javax.swing.JPanel();
        computeHashesCheckbox = new javax.swing.JCheckBox();
        computeHashesTextArea = new javax.swing.JTextArea();

        setPreferredSize(new java.awt.Dimension(300, 155));

        org.openide.awt.Mnemonics.setLocalizedText(verifyHashesCheckbox, org.openide.util.NbBundle.getMessage(DataSourceIntegrityIngestSettingsPanel.class, "DataSourceIntegrityIngestSettingsPanel.verifyHashesCheckbox.text")); // NOI18N
        verifyHashesCheckbox.setFocusable(false);

        ingestSettingsLabel.setFont(ingestSettingsLabel.getFont().deriveFont(ingestSettingsLabel.getFont().getStyle() | java.awt.Font.BOLD));
        org.openide.awt.Mnemonics.setLocalizedText(ingestSettingsLabel, org.openide.util.NbBundle.getMessage(DataSourceIntegrityIngestSettingsPanel.class, "DataSourceIntegrityIngestSettingsPanel.ingestSettingsLabel.text")); // NOI18N

        org.openide.awt.Mnemonics.setLocalizedText(noteLabel, org.openide.util.NbBundle.getMessage(DataSourceIntegrityIngestSettingsPanel.class, "DataSourceIntegrityIngestSettingsPanel.noteLabel.text")); // NOI18N

        computeHashesPanel.setLayout(new java.awt.GridBagLayout());
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 0;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
        computeHashesPanel.add(computeHashesCheckbox, gridBagConstraints);

        computeHashesTextArea.setEditable(false);
        computeHashesTextArea.setBackground(new java.awt.Color(240, 240, 240));
        computeHashesTextArea.setColumns(20);
        computeHashesTextArea.setLineWrap(true);
        computeHashesTextArea.setRows(2);
        computeHashesTextArea.setText(org.openide.util.NbBundle.getMessage(DataSourceIntegrityIngestSettingsPanel.class, "DataSourceIntegrityIngestSettingsPanel.computeHashesCheckbox.text")); // NOI18N
        computeHashesTextArea.setWrapStyleWord(true);
        computeHashesTextArea.setBorder(null);
        computeHashesTextArea.setFocusable(false);
        computeHashesTextArea.setOpaque(false);
        computeHashesTextArea.setRequestFocusEnabled(false);
        computeHashesTextArea.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                computeHashesTextAreaMouseClicked(evt);
            }
        });
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 1;
        gridBagConstraints.gridy = 0;
        gridBagConstraints.gridwidth = 3;
        gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
        gridBagConstraints.weightx = 1.0;
        gridBagConstraints.insets = new java.awt.Insets(3, 0, 0, 0);
        computeHashesPanel.add(computeHashesTextArea, gridBagConstraints);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(noteLabel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(verifyHashesCheckbox)
                    .addComponent(ingestSettingsLabel)
                    .addComponent(computeHashesPanel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap(13, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(ingestSettingsLabel)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(computeHashesPanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(verifyHashesCheckbox)
                .addGap(18, 18, 18)
                .addComponent(noteLabel)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void computeHashesTextAreaMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_computeHashesTextAreaMouseClicked
        computeHashesCheckbox.doClick();
    }//GEN-LAST:event_computeHashesTextAreaMouseClicked

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JCheckBox computeHashesCheckbox;
    private javax.swing.JPanel computeHashesPanel;
    private javax.swing.JTextArea computeHashesTextArea;
    private javax.swing.JLabel ingestSettingsLabel;
    private javax.swing.JLabel noteLabel;
    private javax.swing.JCheckBox verifyHashesCheckbox;
    // End of variables declaration//GEN-END:variables

}
