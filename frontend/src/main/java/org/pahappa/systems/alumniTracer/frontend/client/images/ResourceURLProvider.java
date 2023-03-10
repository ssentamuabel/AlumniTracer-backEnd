package org.pahappa.systems.alumniTracer.frontend.client.images;

import java.net.URL;

public class ResourceURLProvider {
    private static String KHANS_LOGO_NAME = "actv.jpg";

    private ResourceURLProvider() {

    }

    public URL getKhansLogo() {
        return getClass().getResource(KHANS_LOGO_NAME);
    }

    public static class Util {

        private static ResourceURLProvider instance;

        private Util() {

        }

        public static ResourceURLProvider getInstance() {
            if (instance == null)
                instance = new ResourceURLProvider();

            return instance;
        }
    }
}
