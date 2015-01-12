package com.my;

import com.vaadin.navigator.View;
import com.vaadin.navigator.ViewChangeListener;
import com.vaadin.ui.*;

/**
 * Created by azu on 12.01.2015.
 */
public class LoginView extends CustomComponent implements View {

    public LoginView() {
        setSizeFull();

        VerticalLayout loginForm = new VerticalLayout();
        loginForm.setWidth("30%");
        loginForm.setHeight("20%");

        HorizontalLayout login = new HorizontalLayout();
        Label loginLabel = new Label("Login");
        login.addComponent(loginLabel);
        TextField loginText = new TextField();
        login.addComponent(loginText);

        loginForm.addComponent(login);

        HorizontalLayout password = new HorizontalLayout();
        Label passwordLabel = new Label("Password");
        password.addComponent(passwordLabel);
        PasswordField passwordField = new PasswordField();
        password.addComponent(passwordField);

        loginForm.addComponent(password);

        Button enterPassword = new Button("Log in..");

        loginForm.addComponent(enterPassword);

        VerticalLayout alignLayout = new VerticalLayout();
        //alignLayout.setWidth("30%");
        alignLayout.addComponent(loginForm);
        alignLayout.setComponentAlignment(loginForm, Alignment.MIDDLE_CENTER);

        setCompositionRoot(alignLayout);


    }

    @Override
    public void enter(ViewChangeListener.ViewChangeEvent viewChangeEvent) {

    }
}
