package org.openstreetmap.pluging;

//import org.openstreetmap.josm.gui.IconToggleButton;
import org.openstreetmap.josm.gui.MapFrame;
import org.openstreetmap.josm.plugins.Plugin;
import org.openstreetmap.josm.plugins.PluginInformation;


/**
 *
 * @author samely
 */
public class DownUpHelper extends Plugin {

    //private IconToggleButton btnIcon;
    protected static DialogBox db;

    public DownUpHelper(PluginInformation info) {
        super(info);
    }

    @Override
    public void mapFrameInitialized(MapFrame oldFrame, MapFrame newFrame) {
        if (newFrame != null) {
            newFrame.addToggleDialog(db = new DialogBox());
        }
    }
}