/*
 * Autopsy Forensic Browser
 *
 * Copyright 2020 Basis Technology Corp.
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
package org.sleuthkit.autopsy.modules.yara.ui;

import java.awt.Component;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import javax.swing.DefaultListCellRenderer;
import javax.swing.DefaultListModel;
import javax.swing.JList;
import javax.swing.ListSelectionModel;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import org.sleuthkit.autopsy.modules.yara.rules.RuleSet;

/**
 * Panel for managing yara rule sets.
 */
public final class RuleSetPanel extends javax.swing.JPanel {

    private static final long serialVersionUID = 1L;

    private final DefaultListModel<RuleSet> listModel;
    private final JList<RuleSet> ruleSetList;

    public RuleSetPanel() {
        initComponents();

        // Creating and initializing JList here to better take
        // advantace of JList use of generics.
        ruleSetList = new JList<>();
        listModel = new DefaultListModel<>();
        scrollPane.setViewportView(ruleSetList);
        ruleSetList.setModel(listModel);
        ruleSetList.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
        ruleSetList.setCellRenderer(new RuleSetRenderer());
        ruleSetList.addListSelectionListener(new ListSelectionListener() {
            @Override
            public void valueChanged(ListSelectionEvent e) {
                deleteButton.setEnabled(getSelectedRule() != null);
            }
        });

        deleteButton.setEnabled(false);
    }

    /**
     * Add the list of rule sets to the list model.
     *
     * @param ruleSetList Rule sets to add.
     */
    void addSetList(List<RuleSet> newSetList) {
        // Put the list into alphectical order.
        List<RuleSet> list = new ArrayList<>();
        list.addAll(newSetList);
        Collections.sort(list);

        listModel.clear();

        for (RuleSet set : list) {
            listModel.addElement(set);
        }
    }

    /**
     * Adds a new rule to the list.
     *
     * @param set
     */
    void addRuleSet(RuleSet set) {
        // This will assure that the new item
        // appears in the correct location.
        List<RuleSet> list = Collections.list(listModel.elements());
        list.add(set);

        addSetList(list);

        ruleSetList.setSelectedValue(set, true);
    }

    /**
     * Removes a rule set from the list.
     *
     * @param set
     */
    void removeRuleSet(RuleSet set) {
        listModel.removeElement(set);
    }

    /**
     * Add a listener for the new rule set action.
     *
     * @param listener
     */
    void addNewRuleListener(ActionListener listener) {
        newButton.addActionListener(listener);
    }

    /**
     * Add a listener for the delete rule set action.
     *
     * @param listener
     */
    void addDeleteRuleListener(ActionListener listener) {
        deleteButton.addActionListener(listener);
    }

    /**
     * Add a listener for list selection change.
     *
     * @param listener
     */
    void addListSelectionListener(ListSelectionListener listener) {
        ruleSetList.addListSelectionListener(listener);
    }

    /**
     * Returns the current selected rule set.
     *
     * @return Currently selected rule set or null if one is not selected.
     */
    RuleSet getSelectedRule() {
        return ruleSetList.getSelectedValue();
    }

    /**
     * Simple ListCellRenderer for a RuleSet.
     */
    private final class RuleSetRenderer extends DefaultListCellRenderer {

        private static final long serialVersionUID = 1L;

        @Override
        public Component getListCellRendererComponent(JList<?> list, Object value, int index, boolean isSelected, boolean cellHasFocus) {
            super.getListCellRendererComponent(list, value, index, isSelected, cellHasFocus);

            if (value instanceof RuleSet) {
                RuleSet set = (RuleSet) value;
                setText(set.getName());
                setToolTipText(set.getName());
            }

            return this;
        }
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

        javax.swing.JTextPane descriptionField = new javax.swing.JTextPane();
        javax.swing.JLabel ruleSetListLabel = new javax.swing.JLabel();
        scrollPane = new javax.swing.JScrollPane();
        javax.swing.JPanel buttonPanel = new javax.swing.JPanel();
        newButton = new javax.swing.JButton();
        deleteButton = new javax.swing.JButton();

        setLayout(new java.awt.GridBagLayout());

        descriptionField.setEditable(false);
        descriptionField.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        descriptionField.setText(org.openide.util.NbBundle.getMessage(RuleSetPanel.class, "RuleSetPanel.descriptionField.text")); // NOI18N
        descriptionField.setOpaque(false);
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
        gridBagConstraints.weightx = 1.0;
        add(descriptionField, gridBagConstraints);

        org.openide.awt.Mnemonics.setLocalizedText(ruleSetListLabel, org.openide.util.NbBundle.getMessage(RuleSetPanel.class, "RuleSetPanel.ruleSetListLabel.text")); // NOI18N
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 1;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.WEST;
        gridBagConstraints.insets = new java.awt.Insets(15, 0, 0, 0);
        add(ruleSetListLabel, gridBagConstraints);
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 2;
        gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
        gridBagConstraints.weightx = 1.0;
        gridBagConstraints.weighty = 1.0;
        gridBagConstraints.insets = new java.awt.Insets(5, 0, 10, 0);
        add(scrollPane, gridBagConstraints);

        buttonPanel.setLayout(new java.awt.GridLayout(1, 0, 5, 0));

        newButton.setIcon(new javax.swing.ImageIcon(getClass().getResource("/org/sleuthkit/autopsy/images/add16.png"))); // NOI18N
        org.openide.awt.Mnemonics.setLocalizedText(newButton, org.openide.util.NbBundle.getMessage(RuleSetPanel.class, "RuleSetPanel.newButton.text")); // NOI18N
        buttonPanel.add(newButton);

        deleteButton.setIcon(new javax.swing.ImageIcon(getClass().getResource("/org/sleuthkit/autopsy/images/delete16.png"))); // NOI18N
        org.openide.awt.Mnemonics.setLocalizedText(deleteButton, org.openide.util.NbBundle.getMessage(RuleSetPanel.class, "RuleSetPanel.deleteButton.text")); // NOI18N
        buttonPanel.add(deleteButton);

        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.WEST;
        add(buttonPanel, gridBagConstraints);
    }// </editor-fold>//GEN-END:initComponents


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton deleteButton;
    private javax.swing.JButton newButton;
    private javax.swing.JScrollPane scrollPane;
    // End of variables declaration//GEN-END:variables
}
