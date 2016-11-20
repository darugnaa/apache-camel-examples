package org.darugna.camel;

import org.apache.camel.main.Main;
import org.darugna.camel.http.HttpRouteBuilder;

public class StandaloneLauncher {
    
    public static void main(String... args) throws Exception {
        Main main = new Main();
        main.addRouteBuilder(new HttpRouteBuilder());
        main.run(args);
    }
}
