package com.my;

import com.vaadin.navigator.View;
import com.vaadin.navigator.ViewChangeListener;
import com.vaadin.shared.ui.MarginInfo;
import com.vaadin.ui.*;

import java.util.ArrayList;
import java.util.List;


public class ChatView extends CustomComponent implements View {

    String user = "anonymous";
    VerticalLayout messages = null;
    public static List<ChatView> clients = new ArrayList<>();


    public ChatView() {
        setSizeFull();
        clients.add(this);

        VerticalLayout content = new VerticalLayout();
        content.setHeight("90%");
        content.setWidth("90%");
        content.setMargin(new MarginInfo(true));


        Label l = new Label("Messages");
        l.setWidthUndefined();
        l.setHeightUndefined();
        content.addComponent(l);

        Component msgList = createMsgList();
        content.addComponent(msgList);
        content.setExpandRatio(msgList, 1.0f);

        Component sendMsg = createSendMsgField();
        content.addComponent(sendMsg);
        setCompositionRoot(content);
        //setContent(content);


    }

    public Component createMsgList() {

        messages = new VerticalLayout();
        messages.setHeightUndefined();

        Panel p = new Panel();
        p.setContent(messages);
        p.setHeight("100%");
        p.setWidth("100%");
        return p;
    }

    public void addMessageToView(String text) {
        //access(() -> {
            Label l = new Label(text);
            l.setHeightUndefined();
            messages.addComponent(l);
        //     scrollIntoView(l);
        // });
    }


    public Component createSendMsgField() {

        HorizontalLayout l = new HorizontalLayout();
        TextField t = new TextField();
        l.addComponent(t);
        Button b = new Button("send");
        b.addClickListener(e -> sendMessage(user + t.getValue()));
        l.addComponent(b);

        Panel p = new Panel();
        p.setContent(l);

        p.setHeightUndefined();
        p.setWidthUndefined();
        return p;
    }

    public static void sendMessage(String text) {
        clients.stream().forEach(e -> e.addMessageToView(text));
    }

    @Override
    public void enter(ViewChangeListener.ViewChangeEvent viewChangeEvent) {

    }
}
