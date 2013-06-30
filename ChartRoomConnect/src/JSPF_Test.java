@PluginImplementation
@Author(name="Ralf Biedert")
/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author appleair
 */
public class JSPF_Test implements BigPlugin {

    @InjectPlugin
    public CoolPlugin coolPlugin;

    @InjectPlugin
    public InformationBroker broker;


    @Thread
    public void backgroundTask() {
        while(true) broker.publish(new StringItem("item:uri", "value"));
    }

    @Init
    public void init() {
        connectDevice();
    }

    @Shutdown
    public void shutdown() {
        sayGoodbye()
    }

    @Capabilities
    public String[] caps() {
        return new String[] {"mimetype/big", "functionality:example"};
    }

    @PluginLoaded
    public void newPlugin(RemoteAPI plugin) {
        System.out.printf("Detected new plugin " + plugin);
    }
}
