package com.my;

import com.vaadin.annotations.*;
import com.vaadin.navigator.Navigator;
import com.vaadin.server.VaadinRequest;
import com.vaadin.server.VaadinServlet;
import com.vaadin.shared.ui.ui.Transport;
import com.vaadin.ui.UI;

import javax.servlet.annotation.WebServlet;

/**
 * Created by azu on 12.01.2015.
 */
@Title("Chat")
@Theme("mytheme")
@Widgetset("com.my.MyAppWidgetset")
@Push(transport = Transport.STREAMING)
public class MyUI extends UI {

    @WebServlet(urlPatterns = "/*", name = "uiServlet", asyncSupported = true)
    @VaadinServletConfiguration(ui = MyUI.class, productionMode = false)
    public static class ChatServlet extends VaadinServlet {
    }

    Navigator navigator;

    @Override
    protected void init(VaadinRequest vaadinRequest) {
        navigator = new Navigator(this, this);

        navigator.addView("LOGIN", new LoginView());
        navigator.addView("CHAT", new ChatView());
        navigator.navigateTo("LOGIN");
    }
}
