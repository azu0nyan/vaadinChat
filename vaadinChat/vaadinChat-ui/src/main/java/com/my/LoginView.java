package com.my;

import com.vaadin.navigator.View;
import com.vaadin.navigator.ViewChangeListener;
import com.vaadin.ui.*;

/**
 * Created by azu on 12.01.2015.
 */
public class LoginView extends CustomComponent implements View, Button.ClickListener {

    TextField loginText;
    PasswordField passwordField;

    public LoginView() {
        setSizeFull();

        VerticalLayout loginForm = new VerticalLayout();
        loginForm.setWidth("30%");
        loginForm.setHeight("20%");

        HorizontalLayout login = new HorizontalLayout();
        Label loginLabel = new Label("Login");
        login.addComponent(loginLabel);
        loginText = new TextField();
        login.addComponent(loginText);

        loginForm.addComponent(login);

        HorizontalLayout password = new HorizontalLayout();
        Label passwordLabel = new Label("Password");
        password.addComponent(passwordLabel);
        passwordField = new PasswordField();
        password.addComponent(passwordField);

        loginForm.addComponent(password);

        Button enterPassword = new Button("Log in..");
        enterPassword.addClickListener(this);

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

    @Override
    public void buttonClick(Button.ClickEvent clickEvent) {


        getSession().setAttribute("username", loginText.getValue());
        getUI().getNavigator().navigateTo("CHAT");
    }
}
