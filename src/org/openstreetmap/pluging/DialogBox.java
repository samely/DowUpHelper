package org.openstreetmap.pluging;

import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import javax.swing.AbstractAction;
import static javax.swing.Action.NAME;
import static javax.swing.Action.SHORT_DESCRIPTION;
import static javax.swing.Action.SMALL_ICON;
import javax.swing.JCheckBox;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import org.openstreetmap.josm.gui.SideButton;
import org.openstreetmap.josm.gui.dialogs.ToggleDialog;
import static org.openstreetmap.josm.gui.mappaint.mapcss.ExpressionFactory.Functions.tr;
import org.openstreetmap.josm.tools.ImageProvider;
import org.openstreetmap.josm.tools.Shortcut;
import org.openstreetmap.pluging.Download.DownloadAction;
import org.openstreetmap.pluging.Upload.UploadAction;


public class DialogBox extends ToggleDialog implements ActionListener {

    JPanel jpCheckBox = new JPanel();
    private final SideButton sbSkip;

    private final JCheckBox jcbdownload,jcbupload;

    public DialogBox() {
        super("DownUpHelper", "up", tr("Open DownUp."), Shortcut.registerShortcut("tool:DownUpHelper", tr("Toggle: {0}", tr("DownUpHelper")),
                KeyEvent.VK_F, Shortcut.CTRL_SHIFT), 75);

        sbSkip = new SideButton(new AbstractAction() {
            {
                putValue(NAME, tr("Active"));
                putValue(SMALL_ICON, ImageProvider.get("mapmode", "skip.png"));
                putValue(SHORT_DESCRIPTION, tr("Skip Error"));
            }

            @Override
            public void actionPerformed(ActionEvent e) {
                JOptionPane.showConfirmDialog(null, "This upload the layers in back");
            }
        });

        jcbdownload = new JCheckBox(new AbstractAction() {
            {
                putValue(NAME, tr("Download"));
                putValue(SHORT_DESCRIPTION, tr("Download in background."));
            }

            @Override
            public void actionPerformed(ActionEvent e) {
                if (jcbdownload.isSelected()) {
                   new DownloadAction().actionPerformed(e);                                      
                }
            }
        });
        
         jcbupload = new JCheckBox(new AbstractAction() {
            {
                putValue(NAME, tr("Upload"));
                putValue(SHORT_DESCRIPTION, tr("Upload in background."));
            }

            @Override
            public void actionPerformed(ActionEvent e) {
                if (jcbupload.isSelected()) {
                    new UploadAction().actionPerformed(e);
                }
            }
        });

        this.setPreferredSize(new Dimension(0, 40));
        jpCheckBox.add(jcbdownload); 
        jpCheckBox.add(jcbupload);

        createLayout(jpCheckBox, false, null);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        JOptionPane.showConfirmDialog(null, "DownUp Helper Progress.");
    }
}
